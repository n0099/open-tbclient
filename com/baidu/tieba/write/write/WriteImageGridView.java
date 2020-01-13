package com.baidu.tieba.write.write;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.R;
/* loaded from: classes11.dex */
public class WriteImageGridView extends GridView {
    public WriteImageGridView(Context context) {
        super(context);
    }

    public WriteImageGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WriteImageGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getCount() > 0) {
            int ceil = (int) Math.ceil(getCount() / 3.0f);
            setMeasuredDimension(getMeasuredWidth(), ((ceil - 1) * l.getDimens(getContext(), R.dimen.tbds10)) + ((((l.getEquipmentWidth(getContext()) - (l.getDimens(getContext(), R.dimen.tbds44) * 2)) - (l.getDimens(getContext(), R.dimen.tbds10) * 2)) / 3) * ceil) + getPaddingTop() + getPaddingBottom());
        }
    }
}
