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
    private int oxj;
    private int oxk;
    private boolean oxl;
    private int oxm;
    private int oxn;

    public MarqueeView(Context context) {
        this(context, null);
    }

    public MarqueeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MarqueeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oxk = 0;
        this.mPaused = true;
        this.oxl = true;
        b(context, attributeSet, i);
    }

    private void b(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.MarqueeView);
        this.oxj = obtainStyledAttributes.getInt(a.j.MarqueeView_scroll_interval, 10000);
        this.oxm = obtainStyledAttributes.getInt(a.j.MarqueeView_scroll_mode, 100);
        this.oxn = obtainStyledAttributes.getInt(a.j.MarqueeView_scroll_first_delay, 1000);
        obtainStyledAttributes.recycle();
        setSingleLine();
        setEllipsize(null);
    }

    public void setContent(String str) {
        if (TextUtils.isEmpty(str) || !TextUtils.equals(str, getText())) {
            setText(str);
            cFw();
        }
    }

    public void cFw() {
        this.oxk = 0;
        this.mPaused = true;
        this.oxl = true;
        ebq();
    }

    public void ebq() {
        if (this.mPaused) {
            setHorizontallyScrolling(true);
            if (this.mScroller == null) {
                this.mScroller = new Scroller(getContext(), new LinearInterpolator());
                setScroller(this.mScroller);
            }
            int ebr = ebr();
            final int i = ebr - this.oxk;
            final int intValue = Double.valueOf(((this.oxj * i) * 1.0d) / ebr).intValue();
            if (this.oxl) {
                SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.MarqueeView.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MarqueeView.this.mScroller.startScroll(MarqueeView.this.oxk, 0, i, 0, intValue);
                        MarqueeView.this.invalidate();
                        MarqueeView.this.mPaused = false;
                    }
                }, this.oxn);
                return;
            }
            this.mScroller.startScroll(this.oxk, 0, i, 0, intValue);
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

    private int ebr() {
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
            if (this.oxm == 101) {
                stopScroll();
                return;
            }
            this.mPaused = true;
            this.oxk = getWidth() * (-1);
            this.oxl = false;
            ebq();
        }
    }

    public int getRndDuration() {
        return this.oxj;
    }

    public void setRndDuration(int i) {
        this.oxj = i;
    }

    public void setScrollMode(int i) {
        this.oxm = i;
    }

    public int getScrollMode() {
        return this.oxm;
    }

    public void setScrollFirstDelay(int i) {
        this.oxn = i;
    }

    public int getScrollFirstDelay() {
        return this.oxn;
    }
}
