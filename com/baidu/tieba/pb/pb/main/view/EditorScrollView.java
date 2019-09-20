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
    private boolean ffe;
    private int ibr;
    private ViewTreeObserver.OnScrollChangedListener ibs;
    private a ibt;
    private boolean ibu;
    private boolean ibv;

    /* loaded from: classes.dex */
    public interface a {
        void a(EditorScrollView editorScrollView, int i, int i2, int i3, int i4);

        void bZA();

        void bZB();
    }

    public EditorScrollView(Context context) {
        super(context);
        this.ibr = 50;
    }

    public EditorScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ibr = 50;
    }

    public EditorScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ibr = 50;
    }

    public boolean aqw() {
        return this.ibu;
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
            case 2:
                this.ffe = true;
                break;
            case 1:
            case 3:
                this.ffe = false;
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.ibt != null) {
            this.ibt.a(this, i, i2, i3, i4);
        }
        if (getHeight() + i2 >= this.contentView.getHeight() && this.ibt != null) {
            this.ibt.bZB();
        }
        if ((i2 == 0 || getHeight() + i2 > this.contentView.getHeight()) && this.ibt != null) {
            this.ibt.bZA();
        }
        if (this.ibs != null && this.ffe && Math.abs(i3 - i2) >= this.ibr) {
            this.ibs.onScrollChanged();
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.onOverScrolled(i, i2, z, z2);
        if (i2 == 0) {
            this.ibu = z2;
            this.ibv = false;
            return;
        }
        this.ibu = false;
        this.ibv = z2;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() > 0) {
            this.contentView = getChildAt(0);
        }
    }

    public void setListener(ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        this.ibs = onScrollChangedListener;
    }

    public void setOnScrollChangedListener(a aVar) {
        this.ibt = aVar;
    }
}
