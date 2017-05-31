package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class EditorInfoView extends TextView {
    private int ana;
    private GradientDrawable fAZ;
    protected int fBa;
    protected int fBb;

    public EditorInfoView(Context context) {
        this(context, null);
    }

    public EditorInfoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EditorInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ana = 3;
        this.fBa = (int) context.getResources().getDimension(w.f.ds18);
        this.fBb = (int) context.getResources().getDimension(w.f.ds6);
        setPadding(this.fBa, this.fBb, this.fBa, this.fBb);
        setGravity(16);
        setSingleLine(true);
        setTextSize(0, context.getResources().getDimension(w.f.ds24));
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), (int) getContext().getResources().getDimension(w.f.ds48));
    }

    public void ws() {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (skinType != this.ana) {
            this.ana = skinType;
            onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType() {
        if (this.fAZ == null) {
            this.fAZ = new GradientDrawable();
            this.fAZ.setCornerRadius(getContext().getResources().getDimension(w.f.ds24));
        }
        aq.c(this, w.e.cp_cont_c, 1);
        this.fAZ.setColor(aq.getColor(w.e.cp_bg_line_e));
    }
}
