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
    private boolean iux;
    private int lHs;
    private ViewTreeObserver.OnScrollChangedListener lHt;
    private a lHu;
    private boolean lHv;
    private boolean lHw;

    /* loaded from: classes.dex */
    public interface a {
        void a(EditorScrollView editorScrollView, int i, int i2, int i3, int i4);

        void doA();

        void doz();
    }

    public EditorScrollView(Context context) {
        super(context);
        this.lHs = 50;
    }

    public EditorScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lHs = 50;
    }

    public EditorScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lHs = 50;
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
            case 2:
                this.iux = true;
                break;
            case 1:
            case 3:
                this.iux = false;
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.lHu != null) {
            this.lHu.a(this, i, i2, i3, i4);
        }
        if (getHeight() + i2 >= this.contentView.getHeight() && this.lHu != null) {
            this.lHu.doA();
        }
        if ((i2 == 0 || getHeight() + i2 > this.contentView.getHeight()) && this.lHu != null) {
            this.lHu.doz();
        }
        if (this.lHt != null && this.iux && Math.abs(i3 - i2) >= this.lHs) {
            this.lHt.onScrollChanged();
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.onOverScrolled(i, i2, z, z2);
        if (i2 == 0) {
            this.lHv = z2;
            this.lHw = false;
            return;
        }
        this.lHv = false;
        this.lHw = z2;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() > 0) {
            this.contentView = getChildAt(0);
        }
    }

    public void setListener(ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        this.lHt = onScrollChangedListener;
    }

    public void setOnScrollChangedListener(a aVar) {
        this.lHu = aVar;
    }
}
