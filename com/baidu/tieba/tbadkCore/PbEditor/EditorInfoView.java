package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class EditorInfoView extends TextView {
    private int aiA;
    private GradientDrawable fBh;
    protected int fBi;
    protected int fBj;

    public EditorInfoView(Context context) {
        this(context, null);
    }

    public EditorInfoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EditorInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aiA = 3;
        this.fBi = (int) context.getResources().getDimension(r.e.ds18);
        this.fBj = (int) context.getResources().getDimension(r.e.ds6);
        setPadding(this.fBi, this.fBj, this.fBi, this.fBj);
        setGravity(16);
        setSingleLine(true);
        setTextSize(0, context.getResources().getDimension(r.e.ds24));
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), (int) getContext().getResources().getDimension(r.e.ds48));
    }

    public void wM() {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (skinType != this.aiA) {
            this.aiA = skinType;
            tB();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void tB() {
        if (this.fBh == null) {
            this.fBh = new GradientDrawable();
            this.fBh.setCornerRadius(getContext().getResources().getDimension(r.e.ds24));
        }
        at.c(this, r.d.cp_cont_c, 1);
        this.fBh.setColor(at.getColor(r.d.cp_bg_line_e));
    }
}
