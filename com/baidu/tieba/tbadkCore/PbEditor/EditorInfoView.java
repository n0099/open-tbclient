package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class EditorInfoView extends TextView {
    private int ahU;
    private GradientDrawable dVI;
    protected int dVJ;
    protected int dVK;

    public EditorInfoView(Context context) {
        this(context, null);
    }

    public EditorInfoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EditorInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ahU = 3;
        this.dVJ = (int) context.getResources().getDimension(t.e.ds18);
        this.dVK = (int) context.getResources().getDimension(t.e.ds6);
        setPadding(this.dVJ, this.dVK, this.dVJ, this.dVK);
        setGravity(16);
        setSingleLine(true);
        setTextSize(0, context.getResources().getDimension(t.e.ds24));
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), (int) getContext().getResources().getDimension(t.e.ds48));
    }

    public void xf() {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (skinType != this.ahU) {
            this.ahU = skinType;
            uv();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void uv() {
        if (this.dVI == null) {
            this.dVI = new GradientDrawable();
            this.dVI.setCornerRadius(getContext().getResources().getDimension(t.e.ds24));
        }
        ar.b(this, t.d.cp_cont_c, 1);
        this.dVI.setColor(ar.getColor(t.d.cp_bg_line_e));
        setBackgroundDrawable(this.dVI);
    }
}
