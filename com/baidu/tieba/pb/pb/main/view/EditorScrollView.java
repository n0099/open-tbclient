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
    private boolean hmg;
    private int krZ;
    private ViewTreeObserver.OnScrollChangedListener ksa;
    private a ksb;
    private boolean ksc;
    private boolean ksd;

    /* loaded from: classes.dex */
    public interface a {
        void a(EditorScrollView editorScrollView, int i, int i2, int i3, int i4);

        void cNA();

        void cNz();
    }

    public EditorScrollView(Context context) {
        super(context);
        this.krZ = 50;
    }

    public EditorScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.krZ = 50;
    }

    public EditorScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.krZ = 50;
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
            case 2:
                this.hmg = true;
                break;
            case 1:
            case 3:
                this.hmg = false;
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.ksb != null) {
            this.ksb.a(this, i, i2, i3, i4);
        }
        if (getHeight() + i2 >= this.contentView.getHeight() && this.ksb != null) {
            this.ksb.cNA();
        }
        if ((i2 == 0 || getHeight() + i2 > this.contentView.getHeight()) && this.ksb != null) {
            this.ksb.cNz();
        }
        if (this.ksa != null && this.hmg && Math.abs(i3 - i2) >= this.krZ) {
            this.ksa.onScrollChanged();
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.onOverScrolled(i, i2, z, z2);
        if (i2 == 0) {
            this.ksc = z2;
            this.ksd = false;
            return;
        }
        this.ksc = false;
        this.ksd = z2;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() > 0) {
            this.contentView = getChildAt(0);
        }
    }

    public void setListener(ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        this.ksa = onScrollChangedListener;
    }

    public void setOnScrollChangedListener(a aVar) {
        this.ksb = aVar;
    }
}
