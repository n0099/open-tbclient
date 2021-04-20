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
import d.b.i0.z1.b.a;
import d.b.i0.z1.c.b;
import java.util.List;
/* loaded from: classes3.dex */
public class InterestedForumFragment extends BaseFragment {

    /* renamed from: e  reason: collision with root package name */
    public View f19046e;

    /* renamed from: f  reason: collision with root package name */
    public BdRecyclerView f19047f;

    /* renamed from: g  reason: collision with root package name */
    public TBSpecificationBtn f19048g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f19049h;
    public TextView i;
    public a j;
    public List<b> k;
    public FrameLayout l;
    public TBSpecificationBtn m;
    public int n;

    public static InterestedForumFragment E0(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("scene", i);
        InterestedForumFragment interestedForumFragment = new InterestedForumFragment();
        interestedForumFragment.setArguments(bundle);
        return interestedForumFragment;
    }

    public int F0() {
        return this.n;
    }

    public final void G0() {
        this.i = (TextView) this.f19046e.findViewById(R.id.interested_desc);
        TextView textView = (TextView) this.f19046e.findViewById(R.id.interested_title);
        this.f19049h = textView;
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        SkinManager.setViewTextColor(this.f19049h, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.i, R.color.CAM_X0107);
        this.f19047f = (BdRecyclerView) this.f19046e.findViewById(R.id.interested_forum_list_view);
        this.l = (FrameLayout) this.f19046e.findViewById(R.id.bottom_select_layout);
        d.b.h0.r.f0.m.a aVar = new d.b.h0.r.f0.m.a();
        TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) this.f19046e.findViewById(R.id.interest_forum_selected_btn);
        this.m = tBSpecificationBtn;
        tBSpecificationBtn.setTextSize(R.dimen.tbds42);
        this.m.setConfig(aVar);
        this.m.setText(getResources().getString(R.string.try_to_select));
        this.m.setEnabled(false);
        this.m.setOnClickListener(this);
        TBSpecificationBtn tBSpecificationBtn2 = (TBSpecificationBtn) this.f19046e.findViewById(R.id.select_all_btn);
        this.f19048g = tBSpecificationBtn2;
        tBSpecificationBtn2.setText(getString(R.string.select_all));
        this.j = new a(this, this.f19047f, this.m, this.f19048g, getPageContext(), new d.b.i0.z1.e.b(getUniqueId()));
    }

    public final void H0() {
        this.f19048g.setOnClickListener(this);
    }

    public void I0() {
        hideLoadingView(this.f19046e);
    }

    public void J0(String str) {
        hideLoadingView(this.f19046e);
        showNetRefreshView(this.f19046e, str, false);
    }

    public void K0(List<b> list) {
        this.k = list;
    }

    public final void initData() {
        this.j.e(this.k);
        showLoadingView(this.f19046e);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        SkinManager.setBackgroundColor(this.f19046e, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.l, R.color.CAM_X0201);
        SkinManager.setViewTextColor(this.f19049h, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.i, R.color.CAM_X0107);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f19048g) {
            this.j.i();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f19046e = LayoutInflater.from(getContext()).inflate(R.layout.fragment_interested_forum_layout, viewGroup, false);
        G0();
        H0();
        initData();
        if (getArguments() != null) {
            this.n = getArguments().getInt("scene");
        }
        return this.f19046e;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.f19046e);
        this.j.e(this.k);
        showLoadingView(this.f19046e);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (getFragmentManager().getFragments().size() == 2) {
            d.b.i0.z1.d.a.b(2, this.n);
        }
    }
}
