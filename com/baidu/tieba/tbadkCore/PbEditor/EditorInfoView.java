package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class EditorInfoView extends TextView {
    private int aoZ;
    private GradientDrawable gfH;
    protected int gfI;
    protected int gfJ;

    public EditorInfoView(Context context) {
        this(context, null);
    }

    public EditorInfoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EditorInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aoZ = 3;
        this.gfI = (int) context.getResources().getDimension(d.f.ds18);
        this.gfJ = (int) context.getResources().getDimension(d.f.ds6);
        setPadding(this.gfI, this.gfJ, this.gfI, this.gfJ);
        setGravity(16);
        setSingleLine(true);
        setTextSize(0, context.getResources().getDimension(d.f.ds24));
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), (int) getContext().getResources().getDimension(d.f.ds48));
    }

    public void wB() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.aoZ) {
            this.aoZ = skinType;
            onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType() {
        if (this.gfH == null) {
            this.gfH = new GradientDrawable();
            this.gfH.setCornerRadius(getContext().getResources().getDimension(d.f.ds24));
        }
        aj.c(this, d.e.cp_cont_c, 1);
        this.gfH.setColor(aj.getColor(d.e.cp_bg_line_e));
    }
}
