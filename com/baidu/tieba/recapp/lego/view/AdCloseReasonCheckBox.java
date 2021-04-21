package com.baidu.tieba.recapp.lego.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.widget.CheckBox;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
import d.b.j0.d3.c;
/* loaded from: classes4.dex */
public class AdCloseReasonCheckBox extends CheckBox {

    /* renamed from: e  reason: collision with root package name */
    public Context f20463e;

    /* renamed from: f  reason: collision with root package name */
    public GradientDrawable f20464f;

    /* renamed from: g  reason: collision with root package name */
    public GradientDrawable f20465g;

    /* renamed from: h  reason: collision with root package name */
    public StateListDrawable f20466h;

    public AdCloseReasonCheckBox(Context context) {
        super(context);
        this.f20463e = context;
        a(context);
    }

    public final void a(Context context) {
        b(R.string.J_X07, l.g(context, R.dimen.L_X01), R.color.CAM_X0902, R.color.CAM_X0304);
        SkinManager.setViewCheckedTextColorSelector(this, R.color.CAM_X0105, R.color.CAM_X0304, R.color.CAM_X0105);
        int g2 = l.g(context, R.dimen.ds24);
        setPadding(g2, 0, g2, 0);
        setGravity(17);
        setButtonDrawable((Drawable) null);
    }

    public final void b(int i, int i2, int i3, int i4) {
        int parseInt = Integer.parseInt(TbadkCoreApplication.getInst().getResources().getString(i).split(",")[0]);
        GradientDrawable gradientDrawable = new GradientDrawable();
        this.f20464f = gradientDrawable;
        gradientDrawable.setShape(0);
        float f2 = parseInt;
        this.f20464f.setCornerRadius(f2);
        this.f20464f.setStroke(i2, SkinManager.getColor(i3));
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        this.f20465g = gradientDrawable2;
        gradientDrawable2.setShape(0);
        this.f20465g.setCornerRadius(f2);
        this.f20465g.setStroke(i2, c.a(SkinManager.getColor(i4), 0.5f));
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.f20466h = stateListDrawable;
        stateListDrawable.addState(new int[]{-16842912}, this.f20464f);
        this.f20466h.addState(new int[]{16842912}, this.f20465g);
        setBackgroundDrawable(this.f20466h);
    }

    public AdCloseReasonCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20463e = context;
        a(context);
    }

    public AdCloseReasonCheckBox(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f20463e = context;
        a(context);
    }
}
