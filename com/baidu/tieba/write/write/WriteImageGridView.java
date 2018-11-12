package com.baidu.tieba.write.write;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
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
            int ceil = (int) Math.ceil(getCount() / 4.0f);
            setMeasuredDimension(getMeasuredWidth(), ((ceil - 1) * l.h(getContext(), e.C0200e.ds16)) + ((((l.aO(getContext()) - (l.h(getContext(), e.C0200e.ds34) * 2)) - (l.h(getContext(), e.C0200e.ds16) * 3)) / 4) * ceil) + getPaddingTop() + getPaddingBottom());
        }
    }
}
