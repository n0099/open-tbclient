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
    private a iOA;
    private boolean iOB;
    private boolean iOC;
    private int iOy;
    private ViewTreeObserver.OnScrollChangedListener iOz;
    private boolean mIsTouching;

    /* loaded from: classes.dex */
    public interface a {
        void a(EditorScrollView editorScrollView, int i, int i2, int i3, int i4);

        void cos();

        void cot();
    }

    public EditorScrollView(Context context) {
        super(context);
        this.iOy = 50;
    }

    public EditorScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iOy = 50;
    }

    public EditorScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iOy = 50;
    }

    public boolean aJN() {
        return this.iOB;
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
            case 2:
                this.mIsTouching = true;
                break;
            case 1:
            case 3:
                this.mIsTouching = false;
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.iOA != null) {
            this.iOA.a(this, i, i2, i3, i4);
        }
        if (getHeight() + i2 >= this.contentView.getHeight() && this.iOA != null) {
            this.iOA.cot();
        }
        if ((i2 == 0 || getHeight() + i2 > this.contentView.getHeight()) && this.iOA != null) {
            this.iOA.cos();
        }
        if (this.iOz != null && this.mIsTouching && Math.abs(i3 - i2) >= this.iOy) {
            this.iOz.onScrollChanged();
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.onOverScrolled(i, i2, z, z2);
        if (i2 == 0) {
            this.iOB = z2;
            this.iOC = false;
            return;
        }
        this.iOB = false;
        this.iOC = z2;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() > 0) {
            this.contentView = getChildAt(0);
        }
    }

    public void setListener(ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        this.iOz = onScrollChangedListener;
    }

    public void setOnScrollChangedListener(a aVar) {
        this.iOA = aVar;
    }
}
