package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class EditorInfoView extends TextView {
    private int agt;
    protected int lkQ;
    protected int lkR;

    public EditorInfoView(Context context) {
        this(context, null);
    }

    public EditorInfoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EditorInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.agt = 3;
        this.lkQ = (int) context.getResources().getDimension(R.dimen.ds18);
        this.lkR = (int) context.getResources().getDimension(R.dimen.ds6);
        setPadding(this.lkQ, this.lkR, this.lkQ, this.lkR);
        setGravity(16);
        setSingleLine(true);
        setTextSize(0, context.getResources().getDimension(R.dimen.ds24));
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), (int) getContext().getResources().getDimension(R.dimen.ds48));
    }

    public void onChangeSkinType(int i) {
        if (i != this.agt) {
            am.setViewTextColor(this, (int) R.color.cp_cont_f);
            this.agt = i;
        }
    }
}
