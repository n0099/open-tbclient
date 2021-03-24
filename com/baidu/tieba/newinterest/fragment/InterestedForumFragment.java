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
import d.b.i0.y1.b.a;
import d.b.i0.y1.c.b;
import java.util.List;
/* loaded from: classes4.dex */
public class InterestedForumFragment extends BaseFragment {

    /* renamed from: e  reason: collision with root package name */
    public View f19368e;

    /* renamed from: f  reason: collision with root package name */
    public BdRecyclerView f19369f;

    /* renamed from: g  reason: collision with root package name */
    public TBSpecificationBtn f19370g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f19371h;
    public TextView i;
    public a j;
    public List<b> k;
    public FrameLayout l;
    public TBSpecificationBtn m;
    public int n;

    public InterestedForumFragment(int i) {
        this.n = i;
    }

    public int E0() {
        return this.n;
    }

    public final void F0() {
        this.i = (TextView) this.f19368e.findViewById(R.id.interested_desc);
        TextView textView = (TextView) this.f19368e.findViewById(R.id.interested_title);
        this.f19371h = textView;
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        SkinManager.setViewTextColor(this.f19371h, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.i, R.color.CAM_X0107);
        this.f19369f = (BdRecyclerView) this.f19368e.findViewById(R.id.interested_forum_list_view);
        this.l = (FrameLayout) this.f19368e.findViewById(R.id.bottom_select_layout);
        d.b.h0.r.f0.m.a aVar = new d.b.h0.r.f0.m.a();
        TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) this.f19368e.findViewById(R.id.interest_forum_selected_btn);
        this.m = tBSpecificationBtn;
        tBSpecificationBtn.setTextSize(R.dimen.tbds42);
        this.m.setConfig(aVar);
        this.m.setText(getResources().getString(R.string.try_to_select));
        this.m.setEnabled(false);
        this.m.setOnClickListener(this);
        TBSpecificationBtn tBSpecificationBtn2 = (TBSpecificationBtn) this.f19368e.findViewById(R.id.select_all_btn);
        this.f19370g = tBSpecificationBtn2;
        tBSpecificationBtn2.setText(getString(R.string.select_all));
        this.j = new a(this, this.f19369f, this.m, this.f19370g, getPageContext(), new d.b.i0.y1.e.b(getUniqueId()));
    }

    public final void G0() {
        this.f19370g.setOnClickListener(this);
    }

    public void H0() {
        hideLoadingView(this.f19368e);
    }

    public void I0(String str) {
        hideLoadingView(this.f19368e);
        showNetRefreshView(this.f19368e, str, false);
    }

    public void J0(List<b> list) {
        this.k = list;
    }

    public final void initData() {
        this.j.e(this.k);
        showLoadingView(this.f19368e);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        SkinManager.setBackgroundColor(this.f19368e, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.l, R.color.CAM_X0201);
        SkinManager.setViewTextColor(this.f19371h, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.i, R.color.CAM_X0107);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f19370g) {
            this.j.i();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f19368e = LayoutInflater.from(getContext()).inflate(R.layout.fragment_interested_forum_layout, viewGroup, false);
        F0();
        G0();
        initData();
        return this.f19368e;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.f19368e);
        this.j.e(this.k);
        showLoadingView(this.f19368e);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (getFragmentManager().getFragments().size() == 2) {
            d.b.i0.y1.d.a.b(2, this.n);
        }
    }
}
