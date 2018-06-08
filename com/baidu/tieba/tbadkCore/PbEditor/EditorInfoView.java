package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class EditorInfoView extends TextView {
    private int ayX;
    protected int gHU;
    protected int gHV;

    public EditorInfoView(Context context) {
        this(context, null);
    }

    public EditorInfoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EditorInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ayX = 3;
        this.gHU = (int) context.getResources().getDimension(d.e.ds18);
        this.gHV = (int) context.getResources().getDimension(d.e.ds6);
        setPadding(this.gHU, this.gHV, this.gHU, this.gHV);
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
        if (i != this.ayX) {
            al.h(this, d.C0141d.cp_cont_f);
            this.ayX = i;
        }
    }
}
