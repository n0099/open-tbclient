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
    private boolean eHG;
    private int hAj;
    private ViewTreeObserver.OnScrollChangedListener hAk;
    private a hAl;
    private boolean hAm;
    private boolean hAn;

    /* loaded from: classes.dex */
    public interface a {
        void a(EditorScrollView editorScrollView, int i, int i2, int i3, int i4);

        void bNL();

        void bNM();
    }

    public EditorScrollView(Context context) {
        super(context);
        this.hAj = 50;
    }

    public EditorScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hAj = 50;
    }

    public EditorScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hAj = 50;
    }

    public boolean akb() {
        return this.hAm;
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
            case 2:
                this.eHG = true;
                break;
            case 1:
            case 3:
                this.eHG = false;
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.hAl != null) {
            this.hAl.a(this, i, i2, i3, i4);
        }
        if (getHeight() + i2 >= this.contentView.getHeight() && this.hAl != null) {
            this.hAl.bNM();
        }
        if ((i2 == 0 || getHeight() + i2 > this.contentView.getHeight()) && this.hAl != null) {
            this.hAl.bNL();
        }
        if (this.hAk != null && this.eHG && Math.abs(i3 - i2) >= this.hAj) {
            this.hAk.onScrollChanged();
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.onOverScrolled(i, i2, z, z2);
        if (i2 == 0) {
            this.hAm = z2;
            this.hAn = false;
            return;
        }
        this.hAm = false;
        this.hAn = z2;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() > 0) {
            this.contentView = getChildAt(0);
        }
    }

    public void setListener(ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        this.hAk = onScrollChangedListener;
    }

    public void setOnScrollChangedListener(a aVar) {
        this.hAl = aVar;
    }
}
