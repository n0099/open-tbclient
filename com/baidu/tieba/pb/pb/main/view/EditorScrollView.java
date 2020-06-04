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
    private boolean gZU;
    private int jYh;
    private ViewTreeObserver.OnScrollChangedListener jYi;
    private a jYj;
    private boolean jYk;
    private boolean jYl;

    /* loaded from: classes.dex */
    public interface a {
        void a(EditorScrollView editorScrollView, int i, int i2, int i3, int i4);

        void cJh();

        void cJi();
    }

    public EditorScrollView(Context context) {
        super(context);
        this.jYh = 50;
    }

    public EditorScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jYh = 50;
    }

    public EditorScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jYh = 50;
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
            case 2:
                this.gZU = true;
                break;
            case 1:
            case 3:
                this.gZU = false;
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.jYj != null) {
            this.jYj.a(this, i, i2, i3, i4);
        }
        if (getHeight() + i2 >= this.contentView.getHeight() && this.jYj != null) {
            this.jYj.cJi();
        }
        if ((i2 == 0 || getHeight() + i2 > this.contentView.getHeight()) && this.jYj != null) {
            this.jYj.cJh();
        }
        if (this.jYi != null && this.gZU && Math.abs(i3 - i2) >= this.jYh) {
            this.jYi.onScrollChanged();
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.onOverScrolled(i, i2, z, z2);
        if (i2 == 0) {
            this.jYk = z2;
            this.jYl = false;
            return;
        }
        this.jYk = false;
        this.jYl = z2;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() > 0) {
            this.contentView = getChildAt(0);
        }
    }

    public void setListener(ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        this.jYi = onScrollChangedListener;
    }

    public void setOnScrollChangedListener(a aVar) {
        this.jYj = aVar;
    }
}
