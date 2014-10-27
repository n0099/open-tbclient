package com.baidu.tieba.im.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;
/* loaded from: classes.dex */
public class LocateScrollView extends ScrollView {
    private View aIG;
    private h bjo;
    private boolean bjp;
    private boolean bjq;
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
        this.bjp = true;
        if (this.bjo != null) {
            this.bjo.f(i, i2, i3, i4);
        }
        if (this.bjq) {
            n(this.aIG, this.mOffset);
            this.bjq = false;
        }
    }

    public void n(View view, int i) {
        if (!this.bjp) {
            this.bjq = true;
            return;
        }
        this.aIG = view;
        this.mOffset = i;
        if (this.aIG != null) {
            this.aIG.getDrawingRect(this.dZ);
            offsetDescendantRectToMyCoords(this.aIG, this.dZ);
            smoothScrollBy(0, computeScrollDeltaToGetChildRectOnScreen(this.dZ) + this.mOffset);
        } else {
            smoothScrollTo(0, this.mOffset);
        }
        invalidate();
    }

    public void setOnSizeChangeListener(h hVar) {
        this.bjo = hVar;
    }
}
