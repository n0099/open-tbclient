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
    private boolean gZJ;
    private int jXb;
    private ViewTreeObserver.OnScrollChangedListener jXc;
    private a jXd;
    private boolean jXe;
    private boolean jXf;

    /* loaded from: classes.dex */
    public interface a {
        void a(EditorScrollView editorScrollView, int i, int i2, int i3, int i4);

        void cIR();

        void cIS();
    }

    public EditorScrollView(Context context) {
        super(context);
        this.jXb = 50;
    }

    public EditorScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jXb = 50;
    }

    public EditorScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jXb = 50;
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
            case 2:
                this.gZJ = true;
                break;
            case 1:
            case 3:
                this.gZJ = false;
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.jXd != null) {
            this.jXd.a(this, i, i2, i3, i4);
        }
        if (getHeight() + i2 >= this.contentView.getHeight() && this.jXd != null) {
            this.jXd.cIS();
        }
        if ((i2 == 0 || getHeight() + i2 > this.contentView.getHeight()) && this.jXd != null) {
            this.jXd.cIR();
        }
        if (this.jXc != null && this.gZJ && Math.abs(i3 - i2) >= this.jXb) {
            this.jXc.onScrollChanged();
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.onOverScrolled(i, i2, z, z2);
        if (i2 == 0) {
            this.jXe = z2;
            this.jXf = false;
            return;
        }
        this.jXe = false;
        this.jXf = z2;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() > 0) {
            this.contentView = getChildAt(0);
        }
    }

    public void setListener(ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        this.jXc = onScrollChangedListener;
    }

    public void setOnScrollChangedListener(a aVar) {
        this.jXd = aVar;
    }
}
