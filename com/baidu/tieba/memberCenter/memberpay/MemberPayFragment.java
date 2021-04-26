package com.baidu.tieba.memberCenter.memberpay;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.R;
import d.a.j0.r1.f.b;
import d.a.j0.r1.f.f;
/* loaded from: classes3.dex */
public class MemberPayFragment extends BaseFragment {

    /* renamed from: e  reason: collision with root package name */
    public int f19075e;

    /* renamed from: f  reason: collision with root package name */
    public String f19076f;

    /* renamed from: g  reason: collision with root package name */
    public String f19077g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f19078h;

    /* renamed from: i  reason: collision with root package name */
    public int f19079i;
    public b j;
    public f k = null;
    public View l;

    public int E0() {
        return this.f19075e;
    }

    public void F0(Boolean bool) {
        b bVar = this.j;
        if (bVar != null) {
            bVar.q(bool.booleanValue());
        }
    }

    public void G0(f fVar) {
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
        this.f19075e = arguments.getInt("member_type");
        this.f19076f = arguments.getString("member_refer_page");
        this.f19077g = arguments.getString("member_click_zone");
        this.f19078h = arguments.getBoolean("member_is_pay_dialog");
        this.f19079i = arguments.getInt("member_from_type");
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.l = layoutInflater.inflate(R.layout.member_pay_fragment_view, viewGroup, false);
        b bVar = new b(getPageContext(), this.l, this.f19075e, this.f19076f, this.f19077g, this.f19078h, this.f19079i);
        this.j = bVar;
        bVar.s(this.k);
        return this.l;
    }
}
