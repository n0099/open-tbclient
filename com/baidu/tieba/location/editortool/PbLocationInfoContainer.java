package com.baidu.tieba.location.editortool;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.RawLayout;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
import d.b.h0.r.f0.m.b;
import d.b.h0.w.a;
import d.b.h0.w.n;
/* loaded from: classes3.dex */
public class PbLocationInfoContainer extends LinearLayout implements View.OnClickListener, n {

    /* renamed from: e  reason: collision with root package name */
    public TBSpecificationBtn f18447e;

    /* renamed from: f  reason: collision with root package name */
    public EditorTools f18448f;

    /* renamed from: g  reason: collision with root package name */
    public int f18449g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f18450h;

    public PbLocationInfoContainer(Context context) {
        super(context);
        this.f18449g = 0;
        this.f18450h = true;
        c();
    }

    public void a(int i) {
        this.f18447e.l(i);
    }

    @Override // d.b.h0.w.n
    public void b() {
        if (this.f18450h) {
            this.f18450h = false;
            d(new a(18, -1, Config.TRACE_VISIT_FIRST));
        }
    }

    public final void c() {
        setGravity(16);
        setOrientation(0);
        RawLayout.LayoutParams layoutParams = new RawLayout.LayoutParams(-2, l.g(getContext(), R.dimen.ds48));
        layoutParams.setMargins(0, l.g(getContext(), R.dimen.ds30), 0, l.g(getContext(), R.dimen.ds12));
        setLayoutParams(layoutParams);
        b bVar = new b();
        bVar.o(R.color.CAM_X0209, R.color.CAM_X0105);
        bVar.h(R.color.CAM_X0110);
        bVar.f(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
        bVar.l(l.g(getContext(), R.dimen.M_W_X004), l.g(getContext(), R.dimen.M_W_X004));
        bVar.m(l.g(getContext(), R.dimen.M_H_X002));
        bVar.i(R.drawable.ic_icon_pure_post_location12, 0, TBSpecificationButtonConfig.IconType.WEBP);
        bVar.g(UtilHelper.getDimenPixelSize(R.dimen.tbds31));
        TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(getContext());
        this.f18447e = tBSpecificationBtn;
        tBSpecificationBtn.setConfig(bVar);
        this.f18447e.setTextSize(R.dimen.tbds32);
        this.f18447e.setOnClickListener(this);
        this.f18447e.setText(getContext().getString(R.string.location_where_are_you));
        addView(this.f18447e, new LinearLayout.LayoutParams(-2, l.g(getContext(), R.dimen.tbds63)));
    }

    @Override // d.b.h0.w.n
    public void d(a aVar) {
        EditorTools editorTools = this.f18448f;
        if (editorTools != null) {
            editorTools.A(aVar);
        }
    }

    @Override // d.b.h0.w.n
    public int getToolId() {
        return this.f18449g;
    }

    @Override // d.b.h0.w.n
    public void hide() {
        this.f18447e.setText(getContext().getString(R.string.location_where_are_you));
    }

    @Override // d.b.h0.w.n
    public void init() {
    }

    @Override // d.b.h0.w.b
    public void onAction(a aVar) {
        if (aVar == null) {
            return;
        }
        int i = aVar.f51942a;
        if (i != 19) {
            if (i == 20) {
                hide();
                return;
            }
            return;
        }
        Object obj = aVar.f51944c;
        if (obj == null) {
            hide();
            return;
        }
        d.b.h0.w.u.a aVar2 = (d.b.h0.w.u.a) obj;
        if (aVar2.f51967a == 1) {
            this.f18447e.setText(getContext().getString(R.string.location_loading));
        } else if (!TextUtils.isEmpty(aVar2.f51968b)) {
            this.f18447e.setText(aVar2.f51968b);
        } else {
            this.f18447e.setText(getContext().getString(R.string.location_where_are_you));
        }
    }

    @Override // d.b.h0.w.n
    public void onChangeSkinType(int i) {
        a(i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f18447e) {
            d(new a(18, -1, null));
        }
    }

    @Override // d.b.h0.w.n
    public void setEditorTools(EditorTools editorTools) {
        this.f18448f = editorTools;
    }

    @Override // d.b.h0.w.n
    public void setToolId(int i) {
        this.f18449g = i;
    }
}
