package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class EditorInfoView extends TextView {
    private int afy;
    private GradientDrawable fju;
    protected int fjv;
    protected int fjw;

    public EditorInfoView(Context context) {
        this(context, null);
    }

    public EditorInfoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EditorInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.afy = 3;
        this.fjv = (int) context.getResources().getDimension(u.e.ds18);
        this.fjw = (int) context.getResources().getDimension(u.e.ds6);
        setPadding(this.fjv, this.fjw, this.fjv, this.fjw);
        setGravity(16);
        setSingleLine(true);
        setTextSize(0, context.getResources().getDimension(u.e.ds24));
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), (int) getContext().getResources().getDimension(u.e.ds48));
    }

    public void vm() {
        int skinType = TbadkCoreApplication.m10getInst().getSkinType();
        if (skinType != this.afy) {
            this.afy = skinType;
            sd();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sd() {
        if (this.fju == null) {
            this.fju = new GradientDrawable();
            this.fju.setCornerRadius(getContext().getResources().getDimension(u.e.ds24));
        }
        av.c(this, u.d.cp_cont_c, 1);
        this.fju.setColor(av.getColor(u.d.cp_bg_line_e));
    }
}
