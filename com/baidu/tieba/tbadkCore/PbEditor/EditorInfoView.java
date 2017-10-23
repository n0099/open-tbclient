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
    private int aoN;
    private GradientDrawable gfs;
    protected int gft;
    protected int gfu;

    public EditorInfoView(Context context) {
        this(context, null);
    }

    public EditorInfoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EditorInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aoN = 3;
        this.gft = (int) context.getResources().getDimension(d.f.ds18);
        this.gfu = (int) context.getResources().getDimension(d.f.ds6);
        setPadding(this.gft, this.gfu, this.gft, this.gfu);
        setGravity(16);
        setSingleLine(true);
        setTextSize(0, context.getResources().getDimension(d.f.ds24));
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), (int) getContext().getResources().getDimension(d.f.ds48));
    }

    public void wu() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.aoN) {
            this.aoN = skinType;
            onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType() {
        if (this.gfs == null) {
            this.gfs = new GradientDrawable();
            this.gfs.setCornerRadius(getContext().getResources().getDimension(d.f.ds24));
        }
        aj.c(this, d.e.cp_cont_c, 1);
        this.gfs.setColor(aj.getColor(d.e.cp_bg_line_e));
    }
}
