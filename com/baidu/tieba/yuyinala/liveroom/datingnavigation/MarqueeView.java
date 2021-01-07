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
    private int opr;
    private int ops;
    private boolean opu;
    private int opv;
    private int opw;

    public MarqueeView(Context context) {
        this(context, null);
    }

    public MarqueeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MarqueeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ops = 0;
        this.mPaused = true;
        this.opu = true;
        b(context, attributeSet, i);
    }

    private void b(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.MarqueeView);
        this.opr = obtainStyledAttributes.getInt(a.j.MarqueeView_scroll_interval, 10000);
        this.opv = obtainStyledAttributes.getInt(a.j.MarqueeView_scroll_mode, 100);
        this.opw = obtainStyledAttributes.getInt(a.j.MarqueeView_scroll_first_delay, 1000);
        obtainStyledAttributes.recycle();
        setSingleLine();
        setEllipsize(null);
    }

    public void setContent(String str) {
        if (TextUtils.isEmpty(str) || !TextUtils.equals(str, getText())) {
            setText(str);
            cHP();
        }
    }

    public void cHP() {
        this.ops = 0;
        this.mPaused = true;
        this.opu = true;
        ecG();
    }

    public void ecG() {
        if (this.mPaused) {
            setHorizontallyScrolling(true);
            if (this.mScroller == null) {
                this.mScroller = new Scroller(getContext(), new LinearInterpolator());
                setScroller(this.mScroller);
            }
            int ecH = ecH();
            final int i = ecH - this.ops;
            final int intValue = Double.valueOf(((this.opr * i) * 1.0d) / ecH).intValue();
            if (this.opu) {
                SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.MarqueeView.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MarqueeView.this.mScroller.startScroll(MarqueeView.this.ops, 0, i, 0, intValue);
                        MarqueeView.this.invalidate();
                        MarqueeView.this.mPaused = false;
                    }
                }, this.opw);
                return;
            }
            this.mScroller.startScroll(this.ops, 0, i, 0, intValue);
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

    private int ecH() {
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
            if (this.opv == 101) {
                stopScroll();
                return;
            }
            this.mPaused = true;
            this.ops = getWidth() * (-1);
            this.opu = false;
            ecG();
        }
    }

    public int getRndDuration() {
        return this.opr;
    }

    public void setRndDuration(int i) {
        this.opr = i;
    }

    public void setScrollMode(int i) {
        this.opv = i;
    }

    public int getScrollMode() {
        return this.opv;
    }

    public void setScrollFirstDelay(int i) {
        this.opw = i;
    }

    public int getScrollFirstDelay() {
        return this.opw;
    }
}
