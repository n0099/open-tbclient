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
/* loaded from: classes11.dex */
public class MarqueeView extends TextView {
    private boolean mPaused;
    private Scroller mScroller;
    private int ops;
    private int opu;
    private boolean opv;
    private int opw;
    private int opx;

    public MarqueeView(Context context) {
        this(context, null);
    }

    public MarqueeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MarqueeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.opu = 0;
        this.mPaused = true;
        this.opv = true;
        b(context, attributeSet, i);
    }

    private void b(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.MarqueeView);
        this.ops = obtainStyledAttributes.getInt(a.j.MarqueeView_scroll_interval, 10000);
        this.opw = obtainStyledAttributes.getInt(a.j.MarqueeView_scroll_mode, 100);
        this.opx = obtainStyledAttributes.getInt(a.j.MarqueeView_scroll_first_delay, 1000);
        obtainStyledAttributes.recycle();
        setSingleLine();
        setEllipsize(null);
    }

    public void setContent(String str) {
        if (TextUtils.isEmpty(str) || !TextUtils.equals(str, getText())) {
            setText(str);
            cHO();
        }
    }

    public void cHO() {
        this.opu = 0;
        this.mPaused = true;
        this.opv = true;
        ecF();
    }

    public void ecF() {
        if (this.mPaused) {
            setHorizontallyScrolling(true);
            if (this.mScroller == null) {
                this.mScroller = new Scroller(getContext(), new LinearInterpolator());
                setScroller(this.mScroller);
            }
            int ecG = ecG();
            final int i = ecG - this.opu;
            final int intValue = Double.valueOf(((this.ops * i) * 1.0d) / ecG).intValue();
            if (this.opv) {
                SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.MarqueeView.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MarqueeView.this.mScroller.startScroll(MarqueeView.this.opu, 0, i, 0, intValue);
                        MarqueeView.this.invalidate();
                        MarqueeView.this.mPaused = false;
                    }
                }, this.opx);
                return;
            }
            this.mScroller.startScroll(this.opu, 0, i, 0, intValue);
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

    private int ecG() {
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
            if (this.opw == 101) {
                stopScroll();
                return;
            }
            this.mPaused = true;
            this.opu = getWidth() * (-1);
            this.opv = false;
            ecF();
        }
    }

    public int getRndDuration() {
        return this.ops;
    }

    public void setRndDuration(int i) {
        this.ops = i;
    }

    public void setScrollMode(int i) {
        this.opw = i;
    }

    public int getScrollMode() {
        return this.opw;
    }

    public void setScrollFirstDelay(int i) {
        this.opx = i;
    }

    public int getScrollFirstDelay() {
        return this.opx;
    }
}
