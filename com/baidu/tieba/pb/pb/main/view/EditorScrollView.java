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
    private boolean eHT;
    private boolean hAA;
    private int hAw;
    private ViewTreeObserver.OnScrollChangedListener hAx;
    private a hAy;
    private boolean hAz;

    /* loaded from: classes.dex */
    public interface a {
        void a(EditorScrollView editorScrollView, int i, int i2, int i3, int i4);

        void bNO();

        void bNP();
    }

    public EditorScrollView(Context context) {
        super(context);
        this.hAw = 50;
    }

    public EditorScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hAw = 50;
    }

    public EditorScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hAw = 50;
    }

    public boolean ake() {
        return this.hAz;
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
            case 2:
                this.eHT = true;
                break;
            case 1:
            case 3:
                this.eHT = false;
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.hAy != null) {
            this.hAy.a(this, i, i2, i3, i4);
        }
        if (getHeight() + i2 >= this.contentView.getHeight() && this.hAy != null) {
            this.hAy.bNP();
        }
        if ((i2 == 0 || getHeight() + i2 > this.contentView.getHeight()) && this.hAy != null) {
            this.hAy.bNO();
        }
        if (this.hAx != null && this.eHT && Math.abs(i3 - i2) >= this.hAw) {
            this.hAx.onScrollChanged();
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.onOverScrolled(i, i2, z, z2);
        if (i2 == 0) {
            this.hAz = z2;
            this.hAA = false;
            return;
        }
        this.hAz = false;
        this.hAA = z2;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() > 0) {
            this.contentView = getChildAt(0);
        }
    }

    public void setListener(ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        this.hAx = onScrollChangedListener;
    }

    public void setOnScrollChangedListener(a aVar) {
        this.hAy = aVar;
    }
}
