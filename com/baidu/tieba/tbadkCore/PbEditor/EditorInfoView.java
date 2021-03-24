package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class EditorInfoView extends TextView {

    /* renamed from: e  reason: collision with root package name */
    public int f21325e;

    /* renamed from: f  reason: collision with root package name */
    public int f21326f;

    /* renamed from: g  reason: collision with root package name */
    public int f21327g;

    public EditorInfoView(Context context) {
        this(context, null);
    }

    public void a(int i) {
        if (i != this.f21325e) {
            SkinManager.setViewTextColor(this, R.color.CAM_X0106);
            this.f21325e = i;
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), (int) getContext().getResources().getDimension(R.dimen.ds48));
    }

    public EditorInfoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EditorInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f21325e = 3;
        this.f21326f = (int) context.getResources().getDimension(R.dimen.ds18);
        int dimension = (int) context.getResources().getDimension(R.dimen.ds6);
        this.f21327g = dimension;
        int i2 = this.f21326f;
        setPadding(i2, dimension, i2, dimension);
        setGravity(16);
        setSingleLine(true);
        setTextSize(0, context.getResources().getDimension(R.dimen.ds24));
    }
}
