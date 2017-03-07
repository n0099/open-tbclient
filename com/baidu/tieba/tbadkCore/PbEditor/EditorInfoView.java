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
    private int amL;
    private GradientDrawable ftd;
    protected int fte;
    protected int ftf;

    public EditorInfoView(Context context) {
        this(context, null);
    }

    public EditorInfoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EditorInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.amL = 3;
        this.fte = (int) context.getResources().getDimension(w.f.ds18);
        this.ftf = (int) context.getResources().getDimension(w.f.ds6);
        setPadding(this.fte, this.ftf, this.fte, this.ftf);
        setGravity(16);
        setSingleLine(true);
        setTextSize(0, context.getResources().getDimension(w.f.ds24));
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), (int) getContext().getResources().getDimension(w.f.ds48));
    }

    public void wP() {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (skinType != this.amL) {
            this.amL = skinType;
            tD();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void tD() {
        if (this.ftd == null) {
            this.ftd = new GradientDrawable();
            this.ftd.setCornerRadius(getContext().getResources().getDimension(w.f.ds24));
        }
        aq.c(this, w.e.cp_cont_c, 1);
        this.ftd.setColor(aq.getColor(w.e.cp_bg_line_e));
    }
}
