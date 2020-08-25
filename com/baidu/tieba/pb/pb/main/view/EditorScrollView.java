package com.baidu.tieba.pb.pb.main.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ScrollView;
/* loaded from: classes2.dex */
public class EditorScrollView extends ScrollView {
    public View contentView;
    private boolean hFi;
    private int kQE;
    private ViewTreeObserver.OnScrollChangedListener kQF;
    private a kQG;
    private boolean kQH;
    private boolean kQI;

    /* loaded from: classes2.dex */
    public interface a {
        void a(EditorScrollView editorScrollView, int i, int i2, int i3, int i4);

        void dcc();

        void dcd();
    }

    public EditorScrollView(Context context) {
        super(context);
        this.kQE = 50;
    }

    public EditorScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kQE = 50;
    }

    public EditorScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kQE = 50;
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
            case 2:
                this.hFi = true;
                break;
            case 1:
            case 3:
                this.hFi = false;
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.kQG != null) {
            this.kQG.a(this, i, i2, i3, i4);
        }
        if (getHeight() + i2 >= this.contentView.getHeight() && this.kQG != null) {
            this.kQG.dcd();
        }
        if ((i2 == 0 || getHeight() + i2 > this.contentView.getHeight()) && this.kQG != null) {
            this.kQG.dcc();
        }
        if (this.kQF != null && this.hFi && Math.abs(i3 - i2) >= this.kQE) {
            this.kQF.onScrollChanged();
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.onOverScrolled(i, i2, z, z2);
        if (i2 == 0) {
            this.kQH = z2;
            this.kQI = false;
            return;
        }
        this.kQH = false;
        this.kQI = z2;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() > 0) {
            this.contentView = getChildAt(0);
        }
    }

    public void setListener(ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        this.kQF = onScrollChangedListener;
    }

    public void setOnScrollChangedListener(a aVar) {
        this.kQG = aVar;
    }
}
