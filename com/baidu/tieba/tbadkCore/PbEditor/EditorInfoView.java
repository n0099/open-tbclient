package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class EditorInfoView extends TextView {
    private int aik;
    private GradientDrawable eon;
    protected int eoo;
    protected int eop;

    public EditorInfoView(Context context) {
        this(context, null);
    }

    public EditorInfoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EditorInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aik = 3;
        this.eoo = (int) context.getResources().getDimension(t.e.ds18);
        this.eop = (int) context.getResources().getDimension(t.e.ds6);
        setPadding(this.eoo, this.eop, this.eoo, this.eop);
        setGravity(16);
        setSingleLine(true);
        setTextSize(0, context.getResources().getDimension(t.e.ds24));
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), (int) getContext().getResources().getDimension(t.e.ds48));
    }

    public void xy() {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (skinType != this.aik) {
            this.aik = skinType;
            uA();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void uA() {
        if (this.eon == null) {
            this.eon = new GradientDrawable();
            this.eon.setCornerRadius(getContext().getResources().getDimension(t.e.ds24));
        }
        at.b(this, t.d.cp_cont_c, 1);
        this.eon.setColor(at.getColor(t.d.cp_bg_line_e));
        setBackgroundDrawable(this.eon);
    }
}
