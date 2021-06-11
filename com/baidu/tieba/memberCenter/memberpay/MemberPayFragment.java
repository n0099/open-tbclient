package com.baidu.tieba.memberCenter.memberpay;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.R;
import d.a.n0.s1.f.b;
import d.a.n0.s1.f.f;
/* loaded from: classes3.dex */
public class MemberPayFragment extends BaseFragment {

    /* renamed from: e  reason: collision with root package name */
    public int f18349e;

    /* renamed from: f  reason: collision with root package name */
    public String f18350f;

    /* renamed from: g  reason: collision with root package name */
    public String f18351g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f18352h;

    /* renamed from: i  reason: collision with root package name */
    public int f18353i;
    public b j;
    public f k = null;
    public View l;

    public int G0() {
        return this.f18349e;
    }

    public void H0(Boolean bool) {
        b bVar = this.j;
        if (bVar != null) {
            bVar.q(bool.booleanValue());
        }
    }

    public void I0(f fVar) {
        this.k = fVar;
        b bVar = this.j;
        if (bVar != null) {
            bVar.s(fVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        b bVar = this.j;
        if (bVar != null) {
            bVar.p(i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.f18349e = arguments.getInt("member_type");
        this.f18350f = arguments.getString("member_refer_page");
        this.f18351g = arguments.getString("member_click_zone");
        this.f18352h = arguments.getBoolean("member_is_pay_dialog");
        this.f18353i = arguments.getInt("member_from_type");
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.l = layoutInflater.inflate(R.layout.member_pay_fragment_view, viewGroup, false);
        b bVar = new b(getPageContext(), this.l, this.f18349e, this.f18350f, this.f18351g, this.f18352h, this.f18353i);
        this.j = bVar;
        bVar.s(this.k);
        return this.l;
    }
}
