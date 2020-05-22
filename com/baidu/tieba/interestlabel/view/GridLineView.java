package com.baidu.tieba.interestlabel.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.BdGridView;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class GridLineView extends BdGridView {
    private int iVg;
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
        this.mPaint.setColor(am.getColor(R.color.cp_bg_line_c));
        this.mPaint.setStrokeWidth(1.0f);
        this.iVg = l.getDimens(context, R.dimen.ds26);
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
            int top2 = childAt.getTop();
            for (int i2 = 1; i2 <= i; i2++) {
                canvas.drawLine(0.0f, (height * i2) + top2, width, (height * i2) + top2, this.mPaint);
                for (int i3 = 1; i3 < numColumns; i3++) {
                    canvas.drawLine(width2 * i3, ((i2 - 1) * height) + top2 + this.iVg, width2 * i3, ((height * i2) + top2) - this.iVg, this.mPaint);
                }
            }
        }
    }

    public void onChangeSkinType() {
        this.mPaint.setColor(am.getColor(R.color.cp_bg_line_c));
    }
}
