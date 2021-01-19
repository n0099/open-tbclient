package com.baidu.tieba.yuyinala.liveroom.datingnavigation;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import android.widget.TextView;
import com.baidu.live.adp.lib.safe.SafeHandler;
import com.baidu.live.sdk.a;
/* loaded from: classes10.dex */
public class MarqueeView extends TextView {
    private boolean mPaused;
    private Scroller mScroller;
    private int okM;
    private int okN;
    private boolean okO;
    private int okP;
    private int okQ;

    public MarqueeView(Context context) {
        this(context, null);
    }

    public MarqueeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MarqueeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.okN = 0;
        this.mPaused = true;
        this.okO = true;
        b(context, attributeSet, i);
    }

    private void b(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.MarqueeView);
        this.okM = obtainStyledAttributes.getInt(a.j.MarqueeView_scroll_interval, 10000);
        this.okP = obtainStyledAttributes.getInt(a.j.MarqueeView_scroll_mode, 100);
        this.okQ = obtainStyledAttributes.getInt(a.j.MarqueeView_scroll_first_delay, 1000);
        obtainStyledAttributes.recycle();
        setSingleLine();
        setEllipsize(null);
    }

    public void setContent(String str) {
        if (TextUtils.isEmpty(str) || !TextUtils.equals(str, getText())) {
            setText(str);
            cDX();
        }
    }

    public void cDX() {
        this.okN = 0;
        this.mPaused = true;
        this.okO = true;
        dYO();
    }

    public void dYO() {
        if (this.mPaused) {
            setHorizontallyScrolling(true);
            if (this.mScroller == null) {
                this.mScroller = new Scroller(getContext(), new LinearInterpolator());
                setScroller(this.mScroller);
            }
            int dYP = dYP();
            final int i = dYP - this.okN;
            final int intValue = Double.valueOf(((this.okM * i) * 1.0d) / dYP).intValue();
            if (this.okO) {
                SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.MarqueeView.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MarqueeView.this.mScroller.startScroll(MarqueeView.this.okN, 0, i, 0, intValue);
                        MarqueeView.this.invalidate();
                        MarqueeView.this.mPaused = false;
                    }
                }, this.okQ);
                return;
            }
            this.mScroller.startScroll(this.okN, 0, i, 0, intValue);
            invalidate();
            this.mPaused = false;
        }
    }

    public void stopScroll() {
        if (this.mScroller != null) {
            this.mPaused = true;
            this.mScroller.startScroll(0, 0, 0, 0, 0);
        }
    }

    private int dYP() {
        TextPaint paint = getPaint();
        Rect rect = new Rect();
        String charSequence = getText().toString();
        paint.getTextBounds(charSequence, 0, charSequence.length(), rect);
        return rect.width();
    }

    @Override // android.widget.TextView, android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (this.mScroller != null && this.mScroller.isFinished() && !this.mPaused) {
            if (this.okP == 101) {
                stopScroll();
                return;
            }
            this.mPaused = true;
            this.okN = getWidth() * (-1);
            this.okO = false;
            dYO();
        }
    }

    public int getRndDuration() {
        return this.okM;
    }

    public void setRndDuration(int i) {
        this.okM = i;
    }

    public void setScrollMode(int i) {
        this.okP = i;
    }

    public int getScrollMode() {
        return this.okP;
    }

    public void setScrollFirstDelay(int i) {
        this.okQ = i;
    }

    public int getScrollFirstDelay() {
        return this.okQ;
    }
}
