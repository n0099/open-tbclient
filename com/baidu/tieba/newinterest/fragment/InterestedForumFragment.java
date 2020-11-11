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
    private BdRecyclerView hQT;
    private TextView liE;
    private TextView liF;
    private a liG;
    private List<b> liH;
    private TBSpecificationBtn liI;
    private TBSpecificationBtn liq;
    private FrameLayout lix;
    private View mRootView;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_interested_forum_layout, viewGroup, false);
        initUI();
        cCs();
        initData();
        return this.mRootView;
    }

    private void initUI() {
        this.liF = (TextView) this.mRootView.findViewById(R.id.interested_desc);
        this.liE = (TextView) this.mRootView.findViewById(R.id.interested_title);
        this.liE.setTypeface(Typeface.DEFAULT_BOLD);
        ap.setViewTextColor(this.liE, R.color.cp_cont_b);
        ap.setViewTextColor(this.liF, R.color.cp_cont_j);
        this.hQT = (BdRecyclerView) this.mRootView.findViewById(R.id.interested_forum_list_view);
        this.lix = (FrameLayout) this.mRootView.findViewById(R.id.bottom_select_layout);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        this.liI = (TBSpecificationBtn) this.mRootView.findViewById(R.id.interest_forum_selected_btn);
        this.liI.setTextSize(R.dimen.tbds42);
        this.liI.setConfig(aVar);
        this.liI.setText(getResources().getString(R.string.try_to_select));
        this.liI.setEnabled(false);
        this.liI.setOnClickListener(this);
        this.liq = (TBSpecificationBtn) this.mRootView.findViewById(R.id.select_all_btn);
        this.liq.setText(getString(R.string.select_all));
        this.liG = new a(this, this.hQT, this.liI, this.liq, getPageContext(), new com.baidu.tieba.newinterest.c.b(getUniqueId()));
    }

    private void cCs() {
        this.liq.setOnClickListener(this);
    }

    private void initData() {
        this.liG.eU(this.liH);
        showLoadingView(this.mRootView);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.liq) {
            this.liG.dgK();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.lix, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.liE, R.color.cp_cont_b);
        ap.setViewTextColor(this.liF, R.color.cp_cont_j);
    }

    public void eW(List<b> list) {
        this.liH = list;
    }

    public void onError(String str) {
        hideLoadingView(this.mRootView);
        showNetRefreshView(this.mRootView, str, false);
    }

    public void dgN() {
        hideLoadingView(this.mRootView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.mRootView);
        this.liG.eU(this.liH);
        showLoadingView(this.mRootView);
    }
}
