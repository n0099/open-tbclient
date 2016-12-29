package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class EditorInfoView extends TextView {
    private int aib;
    private GradientDrawable ffm;
    protected int ffn;
    protected int ffo;

    public EditorInfoView(Context context) {
        this(context, null);
    }

    public EditorInfoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EditorInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aib = 3;
        this.ffn = (int) context.getResources().getDimension(r.e.ds18);
        this.ffo = (int) context.getResources().getDimension(r.e.ds6);
        setPadding(this.ffn, this.ffo, this.ffn, this.ffo);
        setGravity(16);
        setSingleLine(true);
        setTextSize(0, context.getResources().getDimension(r.e.ds24));
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), (int) getContext().getResources().getDimension(r.e.ds48));
    }

    public void wx() {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (skinType != this.aib) {
            this.aib = skinType;
            tm();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void tm() {
        if (this.ffm == null) {
            this.ffm = new GradientDrawable();
            this.ffm.setCornerRadius(getContext().getResources().getDimension(r.e.ds24));
        }
        ar.c(this, r.d.cp_cont_c, 1);
        this.ffm.setColor(ar.getColor(r.d.cp_bg_line_e));
    }
}
