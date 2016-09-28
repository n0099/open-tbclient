package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class EditorInfoView extends TextView {
    private int ahV;
    private GradientDrawable ftU;
    protected int ftV;
    protected int ftW;

    public EditorInfoView(Context context) {
        this(context, null);
    }

    public EditorInfoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EditorInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ahV = 3;
        this.ftV = (int) context.getResources().getDimension(r.e.ds18);
        this.ftW = (int) context.getResources().getDimension(r.e.ds6);
        setPadding(this.ftV, this.ftW, this.ftV, this.ftW);
        setGravity(16);
        setSingleLine(true);
        setTextSize(0, context.getResources().getDimension(r.e.ds24));
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), (int) getContext().getResources().getDimension(r.e.ds48));
    }

    public void wH() {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (skinType != this.ahV) {
            this.ahV = skinType;
            tx();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void tx() {
        if (this.ftU == null) {
            this.ftU = new GradientDrawable();
            this.ftU.setCornerRadius(getContext().getResources().getDimension(r.e.ds24));
        }
        av.c(this, r.d.cp_cont_c, 1);
        this.ftU.setColor(av.getColor(r.d.cp_bg_line_e));
    }
}
