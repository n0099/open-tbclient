package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class EditorInfoView extends TextView {
    private int aCJ;
    protected int gUx;
    protected int gUy;

    public EditorInfoView(Context context) {
        this(context, null);
    }

    public EditorInfoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EditorInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aCJ = 3;
        this.gUx = (int) context.getResources().getDimension(e.C0141e.ds18);
        this.gUy = (int) context.getResources().getDimension(e.C0141e.ds6);
        setPadding(this.gUx, this.gUy, this.gUx, this.gUy);
        setGravity(16);
        setSingleLine(true);
        setTextSize(0, context.getResources().getDimension(e.C0141e.ds24));
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), (int) getContext().getResources().getDimension(e.C0141e.ds48));
    }

    public void onChangeSkinType(int i) {
        if (i != this.aCJ) {
            al.h(this, e.d.cp_cont_f);
            this.aCJ = i;
        }
    }
}
