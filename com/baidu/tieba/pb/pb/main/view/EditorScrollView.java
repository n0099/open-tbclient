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
    private boolean gKR;
    private boolean jFA;
    private int jFw;
    private ViewTreeObserver.OnScrollChangedListener jFx;
    private a jFy;
    private boolean jFz;

    /* loaded from: classes.dex */
    public interface a {
        void a(EditorScrollView editorScrollView, int i, int i2, int i3, int i4);

        void cBW();

        void cBX();
    }

    public EditorScrollView(Context context) {
        super(context);
        this.jFw = 50;
    }

    public EditorScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jFw = 50;
    }

    public EditorScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jFw = 50;
    }

    public boolean aVg() {
        return this.jFz;
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
            case 2:
                this.gKR = true;
                break;
            case 1:
            case 3:
                this.gKR = false;
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.jFy != null) {
            this.jFy.a(this, i, i2, i3, i4);
        }
        if (getHeight() + i2 >= this.contentView.getHeight() && this.jFy != null) {
            this.jFy.cBX();
        }
        if ((i2 == 0 || getHeight() + i2 > this.contentView.getHeight()) && this.jFy != null) {
            this.jFy.cBW();
        }
        if (this.jFx != null && this.gKR && Math.abs(i3 - i2) >= this.jFw) {
            this.jFx.onScrollChanged();
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.onOverScrolled(i, i2, z, z2);
        if (i2 == 0) {
            this.jFz = z2;
            this.jFA = false;
            return;
        }
        this.jFz = false;
        this.jFA = z2;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() > 0) {
            this.contentView = getChildAt(0);
        }
    }

    public void setListener(ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        this.jFx = onScrollChangedListener;
    }

    public void setOnScrollChangedListener(a aVar) {
        this.jFy = aVar;
    }
}
