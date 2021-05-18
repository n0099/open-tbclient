package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class EditorInfoView extends TextView {

    /* renamed from: e  reason: collision with root package name */
    public int f20846e;

    /* renamed from: f  reason: collision with root package name */
    public int f20847f;

    /* renamed from: g  reason: collision with root package name */
    public int f20848g;

    public EditorInfoView(Context context) {
        this(context, null);
    }

    public void a(int i2) {
        if (i2 != this.f20846e) {
            SkinManager.setViewTextColor(this, R.color.CAM_X0106);
            this.f20846e = i2;
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        setMeasuredDimension(getMeasuredWidth(), (int) getContext().getResources().getDimension(R.dimen.ds48));
    }

    public EditorInfoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EditorInfoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f20846e = 3;
        this.f20847f = (int) context.getResources().getDimension(R.dimen.ds18);
        int dimension = (int) context.getResources().getDimension(R.dimen.ds6);
        this.f20848g = dimension;
        int i3 = this.f20847f;
        setPadding(i3, dimension, i3, dimension);
        setGravity(16);
        setSingleLine(true);
        setTextSize(0, context.getResources().getDimension(R.dimen.ds24));
    }
}
