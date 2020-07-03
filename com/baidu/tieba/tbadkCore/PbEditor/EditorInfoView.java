package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class EditorInfoView extends TextView {
    private int ahx;
    protected int lEK;
    protected int lEL;

    public EditorInfoView(Context context) {
        this(context, null);
    }

    public EditorInfoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EditorInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ahx = 3;
        this.lEK = (int) context.getResources().getDimension(R.dimen.ds18);
        this.lEL = (int) context.getResources().getDimension(R.dimen.ds6);
        setPadding(this.lEK, this.lEL, this.lEK, this.lEL);
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
        if (i != this.ahx) {
            an.setViewTextColor(this, (int) R.color.cp_cont_f);
            this.ahx = i;
        }
    }
}
