package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class EditorInfoView extends TextView {
    private int aiX;
    protected int mnA;
    protected int mnz;

    public EditorInfoView(Context context) {
        this(context, null);
    }

    public EditorInfoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EditorInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aiX = 3;
        this.mnz = (int) context.getResources().getDimension(R.dimen.ds18);
        this.mnA = (int) context.getResources().getDimension(R.dimen.ds6);
        setPadding(this.mnz, this.mnA, this.mnz, this.mnA);
        setGravity(16);
        setSingleLine(true);
        setTextSize(0, context.getResources().getDimension(R.dimen.ds24));
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), (int) getContext().getResources().getDimension(R.dimen.ds48));
    }

    public void onChangeSkinType(int i) {
        if (i != this.aiX) {
            ap.setViewTextColor(this, R.color.cp_cont_f);
            this.aiX = i;
        }
    }
}
