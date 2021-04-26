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
import d.a.c.e.p.l;
import d.a.j0.d3.c;
/* loaded from: classes3.dex */
public class AdCloseReasonCheckBox extends CheckBox {

    /* renamed from: e  reason: collision with root package name */
    public Context f21006e;

    /* renamed from: f  reason: collision with root package name */
    public GradientDrawable f21007f;

    /* renamed from: g  reason: collision with root package name */
    public GradientDrawable f21008g;

    /* renamed from: h  reason: collision with root package name */
    public StateListDrawable f21009h;

    public AdCloseReasonCheckBox(Context context) {
        super(context);
        this.f21006e = context;
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

    public final void b(int i2, int i3, int i4, int i5) {
        int parseInt = Integer.parseInt(TbadkCoreApplication.getInst().getResources().getString(i2).split(",")[0]);
        GradientDrawable gradientDrawable = new GradientDrawable();
        this.f21007f = gradientDrawable;
        gradientDrawable.setShape(0);
        float f2 = parseInt;
        this.f21007f.setCornerRadius(f2);
        this.f21007f.setStroke(i3, SkinManager.getColor(i4));
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        this.f21008g = gradientDrawable2;
        gradientDrawable2.setShape(0);
        this.f21008g.setCornerRadius(f2);
        this.f21008g.setStroke(i3, c.a(SkinManager.getColor(i5), 0.5f));
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.f21009h = stateListDrawable;
        stateListDrawable.addState(new int[]{-16842912}, this.f21007f);
        this.f21009h.addState(new int[]{16842912}, this.f21008g);
        setBackgroundDrawable(this.f21009h);
    }

    public AdCloseReasonCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21006e = context;
        a(context);
    }

    public AdCloseReasonCheckBox(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f21006e = context;
        a(context);
    }
}
