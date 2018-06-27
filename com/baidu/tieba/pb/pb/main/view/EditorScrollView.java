package com.baidu.tieba.pb.pb.main.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewTreeObserver;
import android.widget.ScrollView;
/* loaded from: classes2.dex */
public class EditorScrollView extends ScrollView {
    private boolean cSP;
    private int fIY;
    private ViewTreeObserver.OnScrollChangedListener fIZ;

    public EditorScrollView(Context context) {
        super(context);
        this.fIY = 50;
    }

    public EditorScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fIY = 50;
    }

    public EditorScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fIY = 50;
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
            case 2:
                this.cSP = true;
                break;
            case 1:
            case 3:
                this.cSP = false;
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.fIZ != null && this.cSP && Math.abs(i3 - i2) >= this.fIY) {
            this.fIZ.onScrollChanged();
        }
    }

    public void setListener(ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        this.fIZ = onScrollChangedListener;
    }
}
