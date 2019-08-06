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
    private boolean fdr;
    private int hZu;
    private ViewTreeObserver.OnScrollChangedListener hZv;
    private a hZw;
    private boolean hZx;
    private boolean hZy;

    /* loaded from: classes.dex */
    public interface a {
        void a(EditorScrollView editorScrollView, int i, int i2, int i3, int i4);

        void bYN();

        void bYO();
    }

    public EditorScrollView(Context context) {
        super(context);
        this.hZu = 50;
    }

    public EditorScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hZu = 50;
    }

    public EditorScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hZu = 50;
    }

    public boolean aqk() {
        return this.hZx;
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
            case 2:
                this.fdr = true;
                break;
            case 1:
            case 3:
                this.fdr = false;
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.hZw != null) {
            this.hZw.a(this, i, i2, i3, i4);
        }
        if (getHeight() + i2 >= this.contentView.getHeight() && this.hZw != null) {
            this.hZw.bYO();
        }
        if ((i2 == 0 || getHeight() + i2 > this.contentView.getHeight()) && this.hZw != null) {
            this.hZw.bYN();
        }
        if (this.hZv != null && this.fdr && Math.abs(i3 - i2) >= this.hZu) {
            this.hZv.onScrollChanged();
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.onOverScrolled(i, i2, z, z2);
        if (i2 == 0) {
            this.hZx = z2;
            this.hZy = false;
            return;
        }
        this.hZx = false;
        this.hZy = z2;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() > 0) {
            this.contentView = getChildAt(0);
        }
    }

    public void setListener(ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        this.hZv = onScrollChangedListener;
    }

    public void setOnScrollChangedListener(a aVar) {
        this.hZw = aVar;
    }
}
