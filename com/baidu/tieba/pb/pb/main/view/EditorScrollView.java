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
    private boolean iFr;
    private int lVp;
    private ViewTreeObserver.OnScrollChangedListener lVq;
    private a lVr;
    private boolean lVs;
    private boolean lVt;

    /* loaded from: classes.dex */
    public interface a {
        void a(EditorScrollView editorScrollView, int i, int i2, int i3, int i4);

        void dtR();

        void dtS();
    }

    public EditorScrollView(Context context) {
        super(context);
        this.lVp = 50;
    }

    public EditorScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lVp = 50;
    }

    public EditorScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lVp = 50;
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
            case 2:
                this.iFr = true;
                break;
            case 1:
            case 3:
                this.iFr = false;
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.lVr != null) {
            this.lVr.a(this, i, i2, i3, i4);
        }
        if (getHeight() + i2 >= this.contentView.getHeight() && this.lVr != null) {
            this.lVr.dtS();
        }
        if ((i2 == 0 || getHeight() + i2 > this.contentView.getHeight()) && this.lVr != null) {
            this.lVr.dtR();
        }
        if (this.lVq != null && this.iFr && Math.abs(i3 - i2) >= this.lVp) {
            this.lVq.onScrollChanged();
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.onOverScrolled(i, i2, z, z2);
        if (i2 == 0) {
            this.lVs = z2;
            this.lVt = false;
            return;
        }
        this.lVs = false;
        this.lVt = z2;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() > 0) {
            this.contentView = getChildAt(0);
        }
    }

    public void setListener(ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        this.lVq = onScrollChangedListener;
    }

    public void setOnScrollChangedListener(a aVar) {
        this.lVr = aVar;
    }
}
