package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class EditorInfoView extends TextView {
    private int ahp;
    private GradientDrawable foH;
    protected int foI;
    protected int foJ;

    public EditorInfoView(Context context) {
        this(context, null);
    }

    public EditorInfoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EditorInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ahp = 3;
        this.foI = (int) context.getResources().getDimension(r.f.ds18);
        this.foJ = (int) context.getResources().getDimension(r.f.ds6);
        setPadding(this.foI, this.foJ, this.foI, this.foJ);
        setGravity(16);
        setSingleLine(true);
        setTextSize(0, context.getResources().getDimension(r.f.ds24));
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), (int) getContext().getResources().getDimension(r.f.ds48));
    }

    public void ws() {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (skinType != this.ahp) {
            this.ahp = skinType;
            tg();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void tg() {
        if (this.foH == null) {
            this.foH = new GradientDrawable();
            this.foH.setCornerRadius(getContext().getResources().getDimension(r.f.ds24));
        }
        ap.c(this, r.e.cp_cont_c, 1);
        this.foH.setColor(ap.getColor(r.e.cp_bg_line_e));
    }
}
