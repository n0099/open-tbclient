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
    private boolean eXQ;
    private int hSk;
    private ViewTreeObserver.OnScrollChangedListener hSl;
    private a hSm;
    private boolean hSn;
    private boolean hSo;

    /* loaded from: classes.dex */
    public interface a {
        void a(EditorScrollView editorScrollView, int i, int i2, int i3, int i4);

        void bVH();

        void bVI();
    }

    public EditorScrollView(Context context) {
        super(context);
        this.hSk = 50;
    }

    public EditorScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hSk = 50;
    }

    public EditorScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hSk = 50;
    }

    public boolean apc() {
        return this.hSn;
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
            case 2:
                this.eXQ = true;
                break;
            case 1:
            case 3:
                this.eXQ = false;
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.hSm != null) {
            this.hSm.a(this, i, i2, i3, i4);
        }
        if (getHeight() + i2 >= this.contentView.getHeight() && this.hSm != null) {
            this.hSm.bVI();
        }
        if ((i2 == 0 || getHeight() + i2 > this.contentView.getHeight()) && this.hSm != null) {
            this.hSm.bVH();
        }
        if (this.hSl != null && this.eXQ && Math.abs(i3 - i2) >= this.hSk) {
            this.hSl.onScrollChanged();
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.onOverScrolled(i, i2, z, z2);
        if (i2 == 0) {
            this.hSn = z2;
            this.hSo = false;
            return;
        }
        this.hSn = false;
        this.hSo = z2;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() > 0) {
            this.contentView = getChildAt(0);
        }
    }

    public void setListener(ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        this.hSl = onScrollChangedListener;
    }

    public void setOnScrollChangedListener(a aVar) {
        this.hSm = aVar;
    }
}
