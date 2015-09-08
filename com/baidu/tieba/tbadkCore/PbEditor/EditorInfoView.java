package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class EditorInfoView extends TextView {
    private int arr;
    private GradientDrawable cQp;
    protected int cQq;
    protected int cQr;

    public EditorInfoView(Context context) {
        this(context, null);
    }

    public EditorInfoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EditorInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.arr = -1;
        this.cQq = (int) context.getResources().getDimension(i.d.ds18);
        this.cQr = (int) context.getResources().getDimension(i.d.ds6);
        setPadding(this.cQq, this.cQr, this.cQq, this.cQr);
        setGravity(16);
        setSingleLine(true);
        setTextSize(0, context.getResources().getDimension(i.d.ds24));
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), (int) getContext().getResources().getDimension(i.d.ds48));
    }

    public void vI() {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (skinType != this.arr) {
            this.arr = skinType;
            tf();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void tf() {
        if (this.cQp == null) {
            this.cQp = new GradientDrawable();
            this.cQp.setCornerRadius(getContext().getResources().getDimension(i.d.ds24));
        }
        al.b(this, i.c.cp_cont_c, 1);
        this.cQp.setColor(al.getColor(i.c.cp_bg_line_e));
        setBackgroundDrawable(this.cQp);
    }
}
