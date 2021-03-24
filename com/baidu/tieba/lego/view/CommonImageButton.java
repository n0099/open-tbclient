package com.baidu.tieba.lego.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.b.i0.i1.m.b;
import d.b.i0.i1.o.j.a;
/* loaded from: classes4.dex */
public class CommonImageButton extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f18727e;

    /* renamed from: f  reason: collision with root package name */
    public View f18728f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f18729g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f18730h;

    public CommonImageButton(Context context) {
        this(context, null, 0);
    }

    public final void a() {
        View inflate = LayoutInflater.from(this.f18727e).inflate(R.layout.lego_common_button, (ViewGroup) this, true);
        this.f18728f = inflate;
        this.f18729g = (TextView) inflate.findViewById(R.id.image_local);
        this.f18730h = (TbImageView) this.f18728f.findViewById(R.id.image_net);
    }

    public void b(a aVar) {
        if (aVar == null) {
            return;
        }
        if (!aVar.j()) {
            b.a().d(aVar, aVar.h());
        }
        if (aVar.a()) {
            c(aVar);
        } else {
            d(aVar);
        }
    }

    public final void c(a aVar) {
        this.f18730h.setVisibility(8);
        int f2 = aVar.f();
        if (f2 != 0) {
            this.f18729g.setVisibility(0);
            SkinManager.setBackgroundResource(this.f18729g, f2);
            return;
        }
        this.f18729g.setVisibility(8);
    }

    public final void d(a aVar) {
        this.f18729g.setVisibility(8);
        this.f18730h.setVisibility(0);
        this.f18730h.W(1 == TbadkCoreApplication.getInst().getSkinType() ? aVar.e() : aVar.d(), 10, false);
    }

    public CommonImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommonImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f18727e = context;
        a();
    }
}
