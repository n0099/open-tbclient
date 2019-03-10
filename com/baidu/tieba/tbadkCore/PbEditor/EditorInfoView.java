package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class EditorInfoView extends TextView {
    private int bUJ;
    protected int iFi;
    protected int iFj;

    public EditorInfoView(Context context) {
        this(context, null);
    }

    public EditorInfoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EditorInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bUJ = 3;
        this.iFi = (int) context.getResources().getDimension(d.e.ds18);
        this.iFj = (int) context.getResources().getDimension(d.e.ds6);
        setPadding(this.iFi, this.iFj, this.iFi, this.iFj);
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
        if (i != this.bUJ) {
            al.j(this, d.C0236d.cp_cont_f);
            this.bUJ = i;
        }
    }
}
