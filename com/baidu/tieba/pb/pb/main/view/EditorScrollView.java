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
    private boolean fgY;
    private int hZh;
    private ViewTreeObserver.OnScrollChangedListener hZi;
    private a hZj;
    private boolean hZk;
    private boolean hZl;

    /* loaded from: classes.dex */
    public interface a {
        void a(EditorScrollView editorScrollView, int i, int i2, int i3, int i4);

        void bWA();

        void bWB();
    }

    public EditorScrollView(Context context) {
        super(context);
        this.hZh = 50;
    }

    public EditorScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hZh = 50;
    }

    public EditorScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hZh = 50;
    }

    public boolean aso() {
        return this.hZk;
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
            case 2:
                this.fgY = true;
                break;
            case 1:
            case 3:
                this.fgY = false;
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.hZj != null) {
            this.hZj.a(this, i, i2, i3, i4);
        }
        if (getHeight() + i2 >= this.contentView.getHeight() && this.hZj != null) {
            this.hZj.bWB();
        }
        if ((i2 == 0 || getHeight() + i2 > this.contentView.getHeight()) && this.hZj != null) {
            this.hZj.bWA();
        }
        if (this.hZi != null && this.fgY && Math.abs(i3 - i2) >= this.hZh) {
            this.hZi.onScrollChanged();
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.onOverScrolled(i, i2, z, z2);
        if (i2 == 0) {
            this.hZk = z2;
            this.hZl = false;
            return;
        }
        this.hZk = false;
        this.hZl = z2;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() > 0) {
            this.contentView = getChildAt(0);
        }
    }

    public void setListener(ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        this.hZi = onScrollChangedListener;
    }

    public void setOnScrollChangedListener(a aVar) {
        this.hZj = aVar;
    }
}
