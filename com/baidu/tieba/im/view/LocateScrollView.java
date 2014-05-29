package com.baidu.tieba.im.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;
/* loaded from: classes.dex */
public class LocateScrollView extends ScrollView {
    private l a;
    private View b;
    private int c;
    private Rect d;
    private boolean e;
    private boolean f;

    public LocateScrollView(Context context) {
        super(context);
        this.d = new Rect();
    }

    public LocateScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = new Rect();
    }

    public LocateScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = new Rect();
    }

    @Override // android.widget.ScrollView, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.e = true;
        if (this.a != null) {
            this.a.a(i, i2, i3, i4);
        }
        if (this.f) {
            a(this.b, this.c);
            this.f = false;
        }
    }

    public void a(View view, int i) {
        if (!this.e) {
            this.f = true;
            return;
        }
        this.b = view;
        this.c = i;
        if (this.b != null) {
            this.b.getDrawingRect(this.d);
            offsetDescendantRectToMyCoords(this.b, this.d);
            smoothScrollBy(0, computeScrollDeltaToGetChildRectOnScreen(this.d) + this.c);
        } else {
            smoothScrollTo(0, this.c);
        }
        invalidate();
    }

    public void setOnSizeChangeListener(l lVar) {
        this.a = lVar;
    }
}
