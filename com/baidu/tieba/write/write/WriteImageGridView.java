package com.baidu.tieba.write.write;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
/* loaded from: classes5.dex */
public class WriteImageGridView extends GridView {
    public WriteImageGridView(Context context) {
        super(context);
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (getCount() > 0) {
            int ceil = (int) Math.ceil(getCount() / 3.0f);
            setMeasuredDimension(getMeasuredWidth(), ((((l.k(getContext()) - (l.g(getContext(), R.dimen.tbds44) * 2)) - (l.g(getContext(), R.dimen.M_H_X003) * 2)) / 3) * ceil) + ((ceil - 1) * l.g(getContext(), R.dimen.M_H_X003)) + getPaddingTop() + getPaddingBottom() + l.g(getContext(), R.dimen.tbds24));
        }
    }

    public WriteImageGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WriteImageGridView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
