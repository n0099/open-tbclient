package com.baidu.tieba.im.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;
/* loaded from: classes.dex */
public class LocateScrollView extends ScrollView {
    private View aIT;
    private h bjC;
    private boolean bjD;
    private boolean bjE;
    private Rect dZ;
    private int mOffset;

    public LocateScrollView(Context context) {
        super(context);
        this.dZ = new Rect();
    }

    public LocateScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dZ = new Rect();
    }

    public LocateScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dZ = new Rect();
    }

    @Override // android.widget.ScrollView, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.bjD = true;
        if (this.bjC != null) {
            this.bjC.f(i, i2, i3, i4);
        }
        if (this.bjE) {
            n(this.aIT, this.mOffset);
            this.bjE = false;
        }
    }

    public void n(View view, int i) {
        if (!this.bjD) {
            this.bjE = true;
            return;
        }
        this.aIT = view;
        this.mOffset = i;
        if (this.aIT != null) {
            this.aIT.getDrawingRect(this.dZ);
            offsetDescendantRectToMyCoords(this.aIT, this.dZ);
            smoothScrollBy(0, computeScrollDeltaToGetChildRectOnScreen(this.dZ) + this.mOffset);
        } else {
            smoothScrollTo(0, this.mOffset);
        }
        invalidate();
    }

    public void setOnSizeChangeListener(h hVar) {
        this.bjC = hVar;
    }
}
