package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class EditorInfoView extends TextView {
    private int aLH;
    protected int hnv;
    protected int hnw;

    public EditorInfoView(Context context) {
        this(context, null);
    }

    public EditorInfoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EditorInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aLH = 3;
        this.hnv = (int) context.getResources().getDimension(e.C0210e.ds18);
        this.hnw = (int) context.getResources().getDimension(e.C0210e.ds6);
        setPadding(this.hnv, this.hnw, this.hnv, this.hnw);
        setGravity(16);
        setSingleLine(true);
        setTextSize(0, context.getResources().getDimension(e.C0210e.ds24));
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), (int) getContext().getResources().getDimension(e.C0210e.ds48));
    }

    public void onChangeSkinType(int i) {
        if (i != this.aLH) {
            al.h(this, e.d.cp_cont_f);
            this.aLH = i;
        }
    }
}
