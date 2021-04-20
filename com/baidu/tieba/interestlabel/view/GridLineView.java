package com.baidu.tieba.interestlabel.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.BdGridView;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
/* loaded from: classes4.dex */
public class GridLineView extends BdGridView {

    /* renamed from: e  reason: collision with root package name */
    public Paint f18168e;

    /* renamed from: f  reason: collision with root package name */
    public int f18169f;

    public GridLineView(Context context) {
        super(context);
        c(context);
    }

    public final void c(Context context) {
        Paint paint = new Paint();
        this.f18168e = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.f18168e.setColor(SkinManager.getColor(R.color.CAM_X0204));
        this.f18168e.setStrokeWidth(1.0f);
        this.f18169f = l.g(context, R.dimen.ds26);
    }

    public void d() {
        this.f18168e.setColor(SkinManager.getColor(R.color.CAM_X0204));
    }

    @Override // com.baidu.tbadk.core.view.BdGridView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        View childAt;
        int i;
        super.dispatchDraw(canvas);
        int childCount = getChildCount();
        if (childCount > 0 && (childAt = getChildAt(0)) != null) {
            int numColumns = getNumColumns();
            int i2 = childCount % numColumns;
            int i3 = childCount / numColumns;
            if (i2 != 0) {
                i3++;
            }
            int width = childAt.getWidth() * numColumns;
            int width2 = childAt.getWidth();
            int height = childAt.getHeight();
            int top = childAt.getTop();
            for (int i4 = 1; i4 <= i3; i4++) {
                float f2 = top + (height * i4);
                canvas.drawLine(0.0f, f2, width, f2, this.f18168e);
                for (int i5 = 1; i5 < numColumns; i5++) {
                    float f3 = width2 * i5;
                    int i6 = this.f18169f;
                    canvas.drawLine(f3, ((i4 - 1) * height) + top + i6, f3, i - i6, this.f18168e);
                }
            }
        }
    }

    public GridLineView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(context);
    }

    public GridLineView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        c(context);
    }
}
