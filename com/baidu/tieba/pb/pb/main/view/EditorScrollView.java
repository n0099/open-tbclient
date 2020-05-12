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
    private boolean gKX;
    private int jFA;
    private ViewTreeObserver.OnScrollChangedListener jFB;
    private a jFC;
    private boolean jFD;
    private boolean jFE;

    /* loaded from: classes.dex */
    public interface a {
        void a(EditorScrollView editorScrollView, int i, int i2, int i3, int i4);

        void cBU();

        void cBV();
    }

    public EditorScrollView(Context context) {
        super(context);
        this.jFA = 50;
    }

    public EditorScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jFA = 50;
    }

    public EditorScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jFA = 50;
    }

    public boolean aVe() {
        return this.jFD;
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
            case 2:
                this.gKX = true;
                break;
            case 1:
            case 3:
                this.gKX = false;
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.jFC != null) {
            this.jFC.a(this, i, i2, i3, i4);
        }
        if (getHeight() + i2 >= this.contentView.getHeight() && this.jFC != null) {
            this.jFC.cBV();
        }
        if ((i2 == 0 || getHeight() + i2 > this.contentView.getHeight()) && this.jFC != null) {
            this.jFC.cBU();
        }
        if (this.jFB != null && this.gKX && Math.abs(i3 - i2) >= this.jFA) {
            this.jFB.onScrollChanged();
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.onOverScrolled(i, i2, z, z2);
        if (i2 == 0) {
            this.jFD = z2;
            this.jFE = false;
            return;
        }
        this.jFD = false;
        this.jFE = z2;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() > 0) {
            this.contentView = getChildAt(0);
        }
    }

    public void setListener(ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        this.jFB = onScrollChangedListener;
    }

    public void setOnScrollChangedListener(a aVar) {
        this.jFC = aVar;
    }
}
