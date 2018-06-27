package com.baidu.tieba.interestlabel.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.BdGridView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class GridLineView extends BdGridView {
    private int eIy;
    private Paint mPaint;

    public GridLineView(Context context) {
        super(context);
        init(context);
    }

    public GridLineView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public GridLineView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.mPaint = new Paint();
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setColor(am.getColor(d.C0142d.cp_bg_line_c));
        this.mPaint.setStrokeWidth(1.0f);
        this.eIy = l.e(context, d.e.ds26);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.BdGridView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        View childAt;
        super.dispatchDraw(canvas);
        int childCount = getChildCount();
        if (childCount > 0 && (childAt = getChildAt(0)) != null) {
            int numColumns = getNumColumns();
            int i = childCount % numColumns == 0 ? childCount / numColumns : (childCount / numColumns) + 1;
            int width = childAt.getWidth() * numColumns;
            int width2 = childAt.getWidth();
            int height = childAt.getHeight();
            int top = childAt.getTop();
            for (int i2 = 1; i2 <= i; i2++) {
                canvas.drawLine(0.0f, (height * i2) + top, width, (height * i2) + top, this.mPaint);
                for (int i3 = 1; i3 < numColumns; i3++) {
                    canvas.drawLine(width2 * i3, ((i2 - 1) * height) + top + this.eIy, width2 * i3, ((height * i2) + top) - this.eIy, this.mPaint);
                }
            }
        }
    }

    public void onChangeSkinType() {
        this.mPaint.setColor(am.getColor(d.C0142d.cp_bg_line_c));
    }
}
