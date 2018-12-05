package com.baidu.tieba.pb.pb.main.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewTreeObserver;
import android.widget.ScrollView;
/* loaded from: classes.dex */
public class EditorScrollView extends ScrollView {
    private boolean dri;
    private int ggD;
    private ViewTreeObserver.OnScrollChangedListener ggE;

    public EditorScrollView(Context context) {
        super(context);
        this.ggD = 50;
    }

    public EditorScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ggD = 50;
    }

    public EditorScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ggD = 50;
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
            case 2:
                this.dri = true;
                break;
            case 1:
            case 3:
                this.dri = false;
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.ggE != null && this.dri && Math.abs(i3 - i2) >= this.ggD) {
            this.ggE.onScrollChanged();
        }
    }

    public void setListener(ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        this.ggE = onScrollChangedListener;
    }
}
