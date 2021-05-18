package com.baidu.tieba.newinterest.fragment;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import d.a.k0.z1.b.a;
import d.a.k0.z1.c.b;
import java.util.List;
/* loaded from: classes4.dex */
public class InterestedForumFragment extends BaseFragment {

    /* renamed from: e  reason: collision with root package name */
    public View f18795e;

    /* renamed from: f  reason: collision with root package name */
    public BdRecyclerView f18796f;

    /* renamed from: g  reason: collision with root package name */
    public TBSpecificationBtn f18797g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f18798h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f18799i;
    public a j;
    public List<b> k;
    public FrameLayout l;
    public TBSpecificationBtn m;
    public int n;

    public static InterestedForumFragment D0(int i2) {
        Bundle bundle = new Bundle();
        bundle.putInt("scene", i2);
        InterestedForumFragment interestedForumFragment = new InterestedForumFragment();
        interestedForumFragment.setArguments(bundle);
        return interestedForumFragment;
    }

    public int E0() {
        return this.n;
    }

    public final void F0() {
        this.f18799i = (TextView) this.f18795e.findViewById(R.id.interested_desc);
        TextView textView = (TextView) this.f18795e.findViewById(R.id.interested_title);
        this.f18798h = textView;
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        SkinManager.setViewTextColor(this.f18798h, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f18799i, R.color.CAM_X0107);
        this.f18796f = (BdRecyclerView) this.f18795e.findViewById(R.id.interested_forum_list_view);
        this.l = (FrameLayout) this.f18795e.findViewById(R.id.bottom_select_layout);
        d.a.j0.r.f0.m.a aVar = new d.a.j0.r.f0.m.a();
        TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) this.f18795e.findViewById(R.id.interest_forum_selected_btn);
        this.m = tBSpecificationBtn;
        tBSpecificationBtn.setTextSize(R.dimen.tbds42);
        this.m.setConfig(aVar);
        this.m.setText(getResources().getString(R.string.try_to_select));
        this.m.setEnabled(false);
        this.m.setOnClickListener(this);
        TBSpecificationBtn tBSpecificationBtn2 = (TBSpecificationBtn) this.f18795e.findViewById(R.id.select_all_btn);
        this.f18797g = tBSpecificationBtn2;
        tBSpecificationBtn2.setText(getString(R.string.select_all));
        this.j = new a(this, this.f18796f, this.m, this.f18797g, getPageContext(), new d.a.k0.z1.e.b(getUniqueId()));
    }

    public final void G0() {
        this.f18797g.setOnClickListener(this);
    }

    public void H0() {
        hideLoadingView(this.f18795e);
    }

    public void I0(String str) {
        hideLoadingView(this.f18795e);
        showNetRefreshView(this.f18795e, str, false);
    }

    public void J0(List<b> list) {
        this.k = list;
    }

    public final void initData() {
        this.j.e(this.k);
        showLoadingView(this.f18795e);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        SkinManager.setBackgroundColor(this.f18795e, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.l, R.color.CAM_X0201);
        SkinManager.setViewTextColor(this.f18798h, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f18799i, R.color.CAM_X0107);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f18797g) {
            this.j.h();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f18795e = LayoutInflater.from(getContext()).inflate(R.layout.fragment_interested_forum_layout, viewGroup, false);
        F0();
        G0();
        initData();
        if (getArguments() != null) {
            this.n = getArguments().getInt("scene");
        }
        return this.f18795e;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.f18795e);
        this.j.e(this.k);
        showLoadingView(this.f18795e);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (getFragmentManager().getFragments().size() == 2) {
            d.a.k0.z1.d.a.b(2, this.n);
        }
    }
}
