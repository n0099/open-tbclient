package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class al extends LinearLayout {
    private View Xo;
    private boolean Xp;

    public al(Context context) {
        super(context);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.Xo != null) {
            this.Xo.measure(getChildMeasureSpec(i, 0, this.Xo.getLayoutParams().width), getChildMeasureSpec(i2, 0, this.Xo.getLayoutParams().height));
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        View childAt = getChildAt(0);
        if (this.Xo != null && childAt != null) {
            int measuredWidth = childAt.getMeasuredWidth() - this.Xo.getMeasuredWidth();
            this.Xo.layout(measuredWidth, 0, this.Xo.getMeasuredWidth() + measuredWidth, this.Xo.getMeasuredHeight());
        }
    }

    public void setNewView(View view) {
        this.Xo = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.Xp) {
            canvas.save();
            canvas.translate(this.Xo.getLeft(), this.Xo.getTop());
            this.Xo.draw(canvas);
            canvas.restore();
        }
    }

    public void setNewViewVisible(boolean z) {
        this.Xp = z;
        invalidate();
    }
}
