package com.baidu.tieba.memberCenter.memberpay;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.R;
import d.b.j0.r1.f.b;
import d.b.j0.r1.f.f;
/* loaded from: classes3.dex */
public class MemberPayFragment extends BaseFragment {

    /* renamed from: e  reason: collision with root package name */
    public int f18652e;

    /* renamed from: f  reason: collision with root package name */
    public String f18653f;

    /* renamed from: g  reason: collision with root package name */
    public String f18654g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f18655h;
    public int i;
    public b j;
    public f k = null;
    public View l;

    public int E0() {
        return this.f18652e;
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
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        b bVar = this.j;
        if (bVar != null) {
            bVar.p(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.f18652e = arguments.getInt("member_type");
        this.f18653f = arguments.getString("member_refer_page");
        this.f18654g = arguments.getString("member_click_zone");
        this.f18655h = arguments.getBoolean("member_is_pay_dialog");
        this.i = arguments.getInt("member_from_type");
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.l = layoutInflater.inflate(R.layout.member_pay_fragment_view, viewGroup, false);
        b bVar = new b(getPageContext(), this.l, this.f18652e, this.f18653f, this.f18654g, this.f18655h, this.i);
        this.j = bVar;
        bVar.s(this.k);
        return this.l;
    }
}
