package com.baidu.tieba.pb.pb.main.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ScrollView;
/* loaded from: classes.dex */
public class EditorScrollView extends ScrollView {
    public View contentView;
    private boolean fcR;
    private a hYA;
    private boolean hYB;
    private boolean hYC;
    private int hYy;
    private ViewTreeObserver.OnScrollChangedListener hYz;

    /* loaded from: classes.dex */
    public interface a {
        void a(EditorScrollView editorScrollView, int i, int i2, int i3, int i4);

        void bYw();

        void bYx();
    }

    public EditorScrollView(Context context) {
        super(context);
        this.hYy = 50;
    }

    public EditorScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hYy = 50;
    }

    public EditorScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hYy = 50;
    }

    public boolean aqi() {
        return this.hYB;
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
            case 2:
                this.fcR = true;
                break;
            case 1:
            case 3:
                this.fcR = false;
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.hYA != null) {
            this.hYA.a(this, i, i2, i3, i4);
        }
        if (getHeight() + i2 >= this.contentView.getHeight() && this.hYA != null) {
            this.hYA.bYx();
        }
        if ((i2 == 0 || getHeight() + i2 > this.contentView.getHeight()) && this.hYA != null) {
            this.hYA.bYw();
        }
        if (this.hYz != null && this.fcR && Math.abs(i3 - i2) >= this.hYy) {
            this.hYz.onScrollChanged();
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.onOverScrolled(i, i2, z, z2);
        if (i2 == 0) {
            this.hYB = z2;
            this.hYC = false;
            return;
        }
        this.hYB = false;
        this.hYC = z2;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() > 0) {
            this.contentView = getChildAt(0);
        }
    }

    public void setListener(ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        this.hYz = onScrollChangedListener;
    }

    public void setOnScrollChangedListener(a aVar) {
        this.hYA = aVar;
    }
}
