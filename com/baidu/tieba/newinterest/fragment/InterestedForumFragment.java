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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.newinterest.b.a;
import com.baidu.tieba.newinterest.data.b;
import java.util.List;
/* loaded from: classes23.dex */
public class InterestedForumFragment extends BaseFragment {
    private BdRecyclerView hyA;
    private TBSpecificationBtn kPV;
    private FrameLayout kQc;
    private TextView kQj;
    private TextView kQk;
    private a kQl;
    private List<b> kQm;
    private TBSpecificationBtn kQn;
    private View mRootView;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_interested_forum_layout, viewGroup, false);
        initUI();
        cwK();
        initData();
        return this.mRootView;
    }

    private void initUI() {
        this.kQk = (TextView) this.mRootView.findViewById(R.id.interested_desc);
        this.kQj = (TextView) this.mRootView.findViewById(R.id.interested_title);
        this.kQj.setTypeface(Typeface.DEFAULT_BOLD);
        ap.setViewTextColor(this.kQj, R.color.cp_cont_b);
        ap.setViewTextColor(this.kQk, R.color.cp_cont_j);
        this.hyA = (BdRecyclerView) this.mRootView.findViewById(R.id.interested_forum_list_view);
        this.kQc = (FrameLayout) this.mRootView.findViewById(R.id.bottom_select_layout);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        this.kQn = (TBSpecificationBtn) this.mRootView.findViewById(R.id.interest_forum_selected_btn);
        this.kQn.setTextSize(R.dimen.tbds42);
        this.kQn.setConfig(aVar);
        this.kQn.setText(getResources().getString(R.string.try_to_select));
        this.kQn.setEnabled(false);
        this.kQn.setOnClickListener(this);
        this.kPV = (TBSpecificationBtn) this.mRootView.findViewById(R.id.select_all_btn);
        this.kPV.setText(getString(R.string.select_all));
        this.kQl = new a(this, this.hyA, this.kQn, this.kPV, getPageContext(), new com.baidu.tieba.newinterest.c.b(getUniqueId()));
    }

    private void cwK() {
        this.kPV.setOnClickListener(this);
    }

    private void initData() {
        this.kQl.eD(this.kQm);
        showLoadingView(this.mRootView);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.kPV) {
            this.kQl.dba();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.kQc, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.kQj, R.color.cp_cont_b);
        ap.setViewTextColor(this.kQk, R.color.cp_cont_j);
    }

    public void eF(List<b> list) {
        this.kQm = list;
    }

    public void onError(String str) {
        hideLoadingView(this.mRootView);
        showNetRefreshView(this.mRootView, str, false);
    }

    public void dbd() {
        hideLoadingView(this.mRootView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.mRootView);
        this.kQl.eD(this.kQm);
        showLoadingView(this.mRootView);
    }
}
