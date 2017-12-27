package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class EditorInfoView extends TextView {
    private int bdE;
    protected int hhE;
    protected int hhF;

    public EditorInfoView(Context context) {
        this(context, null);
    }

    public EditorInfoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EditorInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bdE = 3;
        this.hhE = (int) context.getResources().getDimension(d.e.ds18);
        this.hhF = (int) context.getResources().getDimension(d.e.ds6);
        setPadding(this.hhE, this.hhF, this.hhE, this.hhF);
        setGravity(16);
        setSingleLine(true);
        setTextSize(0, context.getResources().getDimension(d.e.ds24));
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), (int) getContext().getResources().getDimension(d.e.ds48));
    }

    public void onChangeSkinType(int i) {
        if (i != this.bdE) {
            aj.r(this, d.C0108d.cp_cont_f);
            this.bdE = i;
        }
    }
}
