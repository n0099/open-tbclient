package com.baidu.tieba.interestlabel.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.BdGridView;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
/* loaded from: classes4.dex */
public class GridLineView extends BdGridView {

    /* renamed from: e  reason: collision with root package name */
    public Paint f17908e;

    /* renamed from: f  reason: collision with root package name */
    public int f17909f;

    public GridLineView(Context context) {
        super(context);
        c(context);
    }

    public final void c(Context context) {
        Paint paint = new Paint();
        this.f17908e = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.f17908e.setColor(SkinManager.getColor(R.color.CAM_X0204));
        this.f17908e.setStrokeWidth(1.0f);
        this.f17909f = l.g(context, R.dimen.ds26);
    }

    public void d() {
        this.f17908e.setColor(SkinManager.getColor(R.color.CAM_X0204));
    }

    @Override // com.baidu.tbadk.core.view.BdGridView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        View childAt;
        int i2;
        super.dispatchDraw(canvas);
        int childCount = getChildCount();
        if (childCount > 0 && (childAt = getChildAt(0)) != null) {
            int numColumns = getNumColumns();
            int i3 = childCount % numColumns;
            int i4 = childCount / numColumns;
            if (i3 != 0) {
                i4++;
            }
            int width = childAt.getWidth() * numColumns;
            int width2 = childAt.getWidth();
            int height = childAt.getHeight();
            int top = childAt.getTop();
            for (int i5 = 1; i5 <= i4; i5++) {
                float f2 = top + (height * i5);
                canvas.drawLine(0.0f, f2, width, f2, this.f17908e);
                for (int i6 = 1; i6 < numColumns; i6++) {
                    float f3 = width2 * i6;
                    int i7 = this.f17909f;
                    canvas.drawLine(f3, ((i5 - 1) * height) + top + i7, f3, i2 - i7, this.f17908e);
                }
            }
        }
    }

    public GridLineView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(context);
    }

    public GridLineView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        c(context);
    }
}
