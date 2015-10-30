package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class EditorInfoView extends TextView {
    private int apS;
    private GradientDrawable cYi;
    protected int cYj;
    protected int cYk;

    public EditorInfoView(Context context) {
        this(context, null);
    }

    public EditorInfoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EditorInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.apS = 3;
        this.cYj = (int) context.getResources().getDimension(i.d.ds18);
        this.cYk = (int) context.getResources().getDimension(i.d.ds6);
        setPadding(this.cYj, this.cYk, this.cYj, this.cYk);
        setGravity(16);
        setSingleLine(true);
        setTextSize(0, context.getResources().getDimension(i.d.ds24));
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), (int) getContext().getResources().getDimension(i.d.ds48));
    }

    public void vx() {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (skinType != this.apS) {
            this.apS = skinType;
            sZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sZ() {
        if (this.cYi == null) {
            this.cYi = new GradientDrawable();
            this.cYi.setCornerRadius(getContext().getResources().getDimension(i.d.ds24));
        }
        an.b(this, i.c.cp_cont_c, 1);
        this.cYi.setColor(an.getColor(i.c.cp_bg_line_e));
        setBackgroundDrawable(this.cYi);
    }
}
