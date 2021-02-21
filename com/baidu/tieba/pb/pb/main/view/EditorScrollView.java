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
    private boolean iSR;
    private int mfq;
    private ViewTreeObserver.OnScrollChangedListener mfr;
    private a mfs;
    private boolean mft;
    private boolean mfu;

    /* loaded from: classes.dex */
    public interface a {
        void a(EditorScrollView editorScrollView, int i, int i2, int i3, int i4);

        void dsk();

        void dsl();
    }

    public EditorScrollView(Context context) {
        super(context);
        this.mfq = 50;
    }

    public EditorScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mfq = 50;
    }

    public EditorScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mfq = 50;
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
            case 2:
                this.iSR = true;
                break;
            case 1:
            case 3:
                this.iSR = false;
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.mfs != null) {
            this.mfs.a(this, i, i2, i3, i4);
        }
        if (getHeight() + i2 >= this.contentView.getHeight() && this.mfs != null) {
            this.mfs.dsl();
        }
        if ((i2 == 0 || getHeight() + i2 > this.contentView.getHeight()) && this.mfs != null) {
            this.mfs.dsk();
        }
        if (this.mfr != null && this.iSR && Math.abs(i3 - i2) >= this.mfq) {
            this.mfr.onScrollChanged();
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.onOverScrolled(i, i2, z, z2);
        if (i2 == 0) {
            this.mft = z2;
            this.mfu = false;
            return;
        }
        this.mft = false;
        this.mfu = z2;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() > 0) {
            this.contentView = getChildAt(0);
        }
    }

    public void setListener(ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        this.mfr = onScrollChangedListener;
    }

    public void setOnScrollChangedListener(a aVar) {
        this.mfs = aVar;
    }
}
