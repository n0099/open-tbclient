package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.f;
/* loaded from: classes.dex */
public class EditorInfoView extends TextView {
    private int azF;
    protected int gMU;
    protected int gMV;

    public EditorInfoView(Context context) {
        this(context, null);
    }

    public EditorInfoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EditorInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.azF = 3;
        this.gMU = (int) context.getResources().getDimension(f.e.ds18);
        this.gMV = (int) context.getResources().getDimension(f.e.ds6);
        setPadding(this.gMU, this.gMV, this.gMU, this.gMV);
        setGravity(16);
        setSingleLine(true);
        setTextSize(0, context.getResources().getDimension(f.e.ds24));
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), (int) getContext().getResources().getDimension(f.e.ds48));
    }

    public void onChangeSkinType(int i) {
        if (i != this.azF) {
            am.h(this, f.d.cp_cont_f);
            this.azF = i;
        }
    }
}
