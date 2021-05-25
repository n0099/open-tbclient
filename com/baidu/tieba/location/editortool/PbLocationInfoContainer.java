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
import d.a.c.e.p.l;
import d.a.m0.r.f0.m.b;
import d.a.m0.w.a;
import d.a.m0.w.n;
/* loaded from: classes3.dex */
public class PbLocationInfoContainer extends LinearLayout implements View.OnClickListener, n {

    /* renamed from: e  reason: collision with root package name */
    public TBSpecificationBtn f18045e;

    /* renamed from: f  reason: collision with root package name */
    public EditorTools f18046f;

    /* renamed from: g  reason: collision with root package name */
    public int f18047g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f18048h;

    public PbLocationInfoContainer(Context context) {
        super(context);
        this.f18047g = 0;
        this.f18048h = true;
        c();
    }

    public void a(int i2) {
        this.f18045e.l(i2);
    }

    @Override // d.a.m0.w.n
    public void b() {
        if (this.f18048h) {
            this.f18048h = false;
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
        this.f18045e = tBSpecificationBtn;
        tBSpecificationBtn.setConfig(bVar);
        this.f18045e.setTextSize(R.dimen.tbds32);
        this.f18045e.setOnClickListener(this);
        this.f18045e.setText(getContext().getString(R.string.location_where_are_you));
        addView(this.f18045e, new LinearLayout.LayoutParams(-2, l.g(getContext(), R.dimen.tbds63)));
    }

    @Override // d.a.m0.w.n
    public void d(a aVar) {
        EditorTools editorTools = this.f18046f;
        if (editorTools != null) {
            editorTools.A(aVar);
        }
    }

    @Override // d.a.m0.w.n
    public int getToolId() {
        return this.f18047g;
    }

    @Override // d.a.m0.w.n
    public void hide() {
        this.f18045e.setText(getContext().getString(R.string.location_where_are_you));
    }

    @Override // d.a.m0.w.n
    public void init() {
    }

    @Override // d.a.m0.w.b
    public void onAction(a aVar) {
        if (aVar == null) {
            return;
        }
        int i2 = aVar.f50841a;
        if (i2 != 19) {
            if (i2 == 20) {
                hide();
                return;
            }
            return;
        }
        Object obj = aVar.f50843c;
        if (obj == null) {
            hide();
            return;
        }
        d.a.m0.w.u.a aVar2 = (d.a.m0.w.u.a) obj;
        if (aVar2.f50867a == 1) {
            this.f18045e.setText(getContext().getString(R.string.location_loading));
        } else if (!TextUtils.isEmpty(aVar2.f50868b)) {
            this.f18045e.setText(aVar2.f50868b);
        } else {
            this.f18045e.setText(getContext().getString(R.string.location_where_are_you));
        }
    }

    @Override // d.a.m0.w.n
    public void onChangeSkinType(int i2) {
        a(i2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f18045e) {
            d(new a(18, -1, null));
        }
    }

    @Override // d.a.m0.w.n
    public void setEditorTools(EditorTools editorTools) {
        this.f18046f = editorTools;
    }

    @Override // d.a.m0.w.n
    public void setToolId(int i2) {
        this.f18047g = i2;
    }
}
