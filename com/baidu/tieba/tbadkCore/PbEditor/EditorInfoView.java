package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class EditorInfoView extends TextView {
    private int aoR;
    private GradientDrawable gfA;
    protected int gfB;
    protected int gfC;

    public EditorInfoView(Context context) {
        this(context, null);
    }

    public EditorInfoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EditorInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aoR = 3;
        this.gfB = (int) context.getResources().getDimension(d.f.ds18);
        this.gfC = (int) context.getResources().getDimension(d.f.ds6);
        setPadding(this.gfB, this.gfC, this.gfB, this.gfC);
        setGravity(16);
        setSingleLine(true);
        setTextSize(0, context.getResources().getDimension(d.f.ds24));
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), (int) getContext().getResources().getDimension(d.f.ds48));
    }

    public void wV() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.aoR) {
            this.aoR = skinType;
            onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType() {
        if (this.gfA == null) {
            this.gfA = new GradientDrawable();
            this.gfA.setCornerRadius(getContext().getResources().getDimension(d.f.ds24));
        }
        ai.c(this, d.e.cp_cont_c, 1);
        this.gfA.setColor(ai.getColor(d.e.cp_bg_line_e));
    }
}
