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
    private boolean eXP;
    private int hSh;
    private ViewTreeObserver.OnScrollChangedListener hSi;
    private a hSj;
    private boolean hSk;
    private boolean hSl;

    /* loaded from: classes.dex */
    public interface a {
        void a(EditorScrollView editorScrollView, int i, int i2, int i3, int i4);

        void bVE();

        void bVF();
    }

    public EditorScrollView(Context context) {
        super(context);
        this.hSh = 50;
    }

    public EditorScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hSh = 50;
    }

    public EditorScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hSh = 50;
    }

    public boolean apc() {
        return this.hSk;
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
            case 2:
                this.eXP = true;
                break;
            case 1:
            case 3:
                this.eXP = false;
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.hSj != null) {
            this.hSj.a(this, i, i2, i3, i4);
        }
        if (getHeight() + i2 >= this.contentView.getHeight() && this.hSj != null) {
            this.hSj.bVF();
        }
        if ((i2 == 0 || getHeight() + i2 > this.contentView.getHeight()) && this.hSj != null) {
            this.hSj.bVE();
        }
        if (this.hSi != null && this.eXP && Math.abs(i3 - i2) >= this.hSh) {
            this.hSi.onScrollChanged();
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.onOverScrolled(i, i2, z, z2);
        if (i2 == 0) {
            this.hSk = z2;
            this.hSl = false;
            return;
        }
        this.hSk = false;
        this.hSl = z2;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() > 0) {
            this.contentView = getChildAt(0);
        }
    }

    public void setListener(ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        this.hSi = onScrollChangedListener;
    }

    public void setOnScrollChangedListener(a aVar) {
        this.hSj = aVar;
    }
}
