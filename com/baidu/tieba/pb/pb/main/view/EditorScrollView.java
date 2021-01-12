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
    private boolean iMW;
    private int lVW;
    private ViewTreeObserver.OnScrollChangedListener lVX;
    private a lVY;
    private boolean lVZ;
    private boolean lWa;

    /* loaded from: classes.dex */
    public interface a {
        void a(EditorScrollView editorScrollView, int i, int i2, int i3, int i4);

        void dpP();

        void dpQ();
    }

    public EditorScrollView(Context context) {
        super(context);
        this.lVW = 50;
    }

    public EditorScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lVW = 50;
    }

    public EditorScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lVW = 50;
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
            case 2:
                this.iMW = true;
                break;
            case 1:
            case 3:
                this.iMW = false;
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.lVY != null) {
            this.lVY.a(this, i, i2, i3, i4);
        }
        if (getHeight() + i2 >= this.contentView.getHeight() && this.lVY != null) {
            this.lVY.dpQ();
        }
        if ((i2 == 0 || getHeight() + i2 > this.contentView.getHeight()) && this.lVY != null) {
            this.lVY.dpP();
        }
        if (this.lVX != null && this.iMW && Math.abs(i3 - i2) >= this.lVW) {
            this.lVX.onScrollChanged();
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.onOverScrolled(i, i2, z, z2);
        if (i2 == 0) {
            this.lVZ = z2;
            this.lWa = false;
            return;
        }
        this.lVZ = false;
        this.lWa = z2;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() > 0) {
            this.contentView = getChildAt(0);
        }
    }

    public void setListener(ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        this.lVX = onScrollChangedListener;
    }

    public void setOnScrollChangedListener(a aVar) {
        this.lVY = aVar;
    }
}
