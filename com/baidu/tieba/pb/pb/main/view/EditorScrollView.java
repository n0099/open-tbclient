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
    private boolean eHX;
    private int hAC;
    private ViewTreeObserver.OnScrollChangedListener hAD;
    private a hAE;
    private boolean hAF;
    private boolean hAG;

    /* loaded from: classes.dex */
    public interface a {
        void a(EditorScrollView editorScrollView, int i, int i2, int i3, int i4);

        void bNO();

        void bNP();
    }

    public EditorScrollView(Context context) {
        super(context);
        this.hAC = 50;
    }

    public EditorScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hAC = 50;
    }

    public EditorScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hAC = 50;
    }

    public boolean akf() {
        return this.hAF;
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
            case 2:
                this.eHX = true;
                break;
            case 1:
            case 3:
                this.eHX = false;
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.hAE != null) {
            this.hAE.a(this, i, i2, i3, i4);
        }
        if (getHeight() + i2 >= this.contentView.getHeight() && this.hAE != null) {
            this.hAE.bNP();
        }
        if ((i2 == 0 || getHeight() + i2 > this.contentView.getHeight()) && this.hAE != null) {
            this.hAE.bNO();
        }
        if (this.hAD != null && this.eHX && Math.abs(i3 - i2) >= this.hAC) {
            this.hAD.onScrollChanged();
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.onOverScrolled(i, i2, z, z2);
        if (i2 == 0) {
            this.hAF = z2;
            this.hAG = false;
            return;
        }
        this.hAF = false;
        this.hAG = z2;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() > 0) {
            this.contentView = getChildAt(0);
        }
    }

    public void setListener(ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        this.hAD = onScrollChangedListener;
    }

    public void setOnScrollChangedListener(a aVar) {
        this.hAE = aVar;
    }
}
