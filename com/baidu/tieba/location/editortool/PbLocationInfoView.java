package com.baidu.tieba.location.editortool;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.b.b.a.j;
import d.b.i0.c3.a;
/* loaded from: classes3.dex */
public class PbLocationInfoView extends TextView {

    /* renamed from: e  reason: collision with root package name */
    public int f18773e;

    /* renamed from: f  reason: collision with root package name */
    public Rect f18774f;

    public PbLocationInfoView(Context context) {
        this(context, null);
    }

    public void a() {
        if (this.f18773e == 1) {
            Drawable drawable = SkinManager.getDrawable(R.drawable.icon_posts_pin_loading_anim);
            if (drawable != null) {
                drawable.setBounds(this.f18774f);
            }
            setCompoundDrawables(drawable, null, null, null);
            a.a((TbPageContextSupport) j.b(getContext()), (Animatable) drawable);
            return;
        }
        Drawable drawable2 = SkinManager.getDrawable(R.drawable.icon_tips_site);
        if (drawable2 != null) {
            drawable2.setBounds(this.f18774f);
        }
        setCompoundDrawables(drawable2, null, null, null);
    }

    public final void b() {
        this.f18774f = new Rect(0, 0, getResources().getDimensionPixelSize(R.dimen.ds32), getResources().getDimensionPixelSize(R.dimen.ds32));
        setState(0, null);
        c();
    }

    public void c() {
        setTextColor(SkinManager.getColor(R.color.CAM_X0108));
        a();
    }

    public int getState() {
        return this.f18773e;
    }

    public void setState(int i, String str) {
        this.f18773e = i;
        if (i == 1) {
            if (str == null) {
                str = getResources().getString(R.string.location_loading);
            }
            setText(str);
        } else {
            if (str == null) {
                str = getResources().getString(R.string.location_default);
            }
            setText(str);
        }
        a();
    }

    public PbLocationInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }
}
