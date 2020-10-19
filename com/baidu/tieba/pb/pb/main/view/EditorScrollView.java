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
    private boolean ibk;
    private int loF;
    private ViewTreeObserver.OnScrollChangedListener loG;
    private a loH;
    private boolean loI;
    private boolean loJ;

    /* loaded from: classes.dex */
    public interface a {
        void a(EditorScrollView editorScrollView, int i, int i2, int i3, int i4);

        void djq();

        void djr();
    }

    public EditorScrollView(Context context) {
        super(context);
        this.loF = 50;
    }

    public EditorScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.loF = 50;
    }

    public EditorScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.loF = 50;
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
            case 2:
                this.ibk = true;
                break;
            case 1:
            case 3:
                this.ibk = false;
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.loH != null) {
            this.loH.a(this, i, i2, i3, i4);
        }
        if (getHeight() + i2 >= this.contentView.getHeight() && this.loH != null) {
            this.loH.djr();
        }
        if ((i2 == 0 || getHeight() + i2 > this.contentView.getHeight()) && this.loH != null) {
            this.loH.djq();
        }
        if (this.loG != null && this.ibk && Math.abs(i3 - i2) >= this.loF) {
            this.loG.onScrollChanged();
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.onOverScrolled(i, i2, z, z2);
        if (i2 == 0) {
            this.loI = z2;
            this.loJ = false;
            return;
        }
        this.loI = false;
        this.loJ = z2;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() > 0) {
            this.contentView = getChildAt(0);
        }
    }

    public void setListener(ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        this.loG = onScrollChangedListener;
    }

    public void setOnScrollChangedListener(a aVar) {
        this.loH = aVar;
    }
}
