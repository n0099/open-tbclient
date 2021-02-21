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
    private int ove;
    private int ovf;
    private boolean ovg;
    private int ovh;
    private int ovi;

    public MarqueeView(Context context) {
        this(context, null);
    }

    public MarqueeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MarqueeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ovf = 0;
        this.mPaused = true;
        this.ovg = true;
        b(context, attributeSet, i);
    }

    private void b(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.MarqueeView);
        this.ove = obtainStyledAttributes.getInt(a.j.MarqueeView_scroll_interval, 10000);
        this.ovh = obtainStyledAttributes.getInt(a.j.MarqueeView_scroll_mode, 100);
        this.ovi = obtainStyledAttributes.getInt(a.j.MarqueeView_scroll_first_delay, 1000);
        obtainStyledAttributes.recycle();
        setSingleLine();
        setEllipsize(null);
    }

    public void setContent(String str) {
        if (TextUtils.isEmpty(str) || !TextUtils.equals(str, getText())) {
            setText(str);
            cFq();
        }
    }

    public void cFq() {
        this.ovf = 0;
        this.mPaused = true;
        this.ovg = true;
        ebi();
    }

    public void ebi() {
        if (this.mPaused) {
            setHorizontallyScrolling(true);
            if (this.mScroller == null) {
                this.mScroller = new Scroller(getContext(), new LinearInterpolator());
                setScroller(this.mScroller);
            }
            int ebj = ebj();
            final int i = ebj - this.ovf;
            final int intValue = Double.valueOf(((this.ove * i) * 1.0d) / ebj).intValue();
            if (this.ovg) {
                SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.MarqueeView.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MarqueeView.this.mScroller.startScroll(MarqueeView.this.ovf, 0, i, 0, intValue);
                        MarqueeView.this.invalidate();
                        MarqueeView.this.mPaused = false;
                    }
                }, this.ovi);
                return;
            }
            this.mScroller.startScroll(this.ovf, 0, i, 0, intValue);
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

    private int ebj() {
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
            if (this.ovh == 101) {
                stopScroll();
                return;
            }
            this.mPaused = true;
            this.ovf = getWidth() * (-1);
            this.ovg = false;
            ebi();
        }
    }

    public int getRndDuration() {
        return this.ove;
    }

    public void setRndDuration(int i) {
        this.ove = i;
    }

    public void setScrollMode(int i) {
        this.ovh = i;
    }

    public int getScrollMode() {
        return this.ovh;
    }

    public void setScrollFirstDelay(int i) {
        this.ovi = i;
    }

    public int getScrollFirstDelay() {
        return this.ovi;
    }
}
