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
/* loaded from: classes17.dex */
public class InterestedForumFragment extends BaseFragment {
    private BdRecyclerView hcG;
    private TextView ksA;
    private a ksB;
    private List<b> ksC;
    private TBSpecificationBtn ksD;
    private TBSpecificationBtn ksl;
    private FrameLayout kss;
    private TextView ksz;
    private View mRootView;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_interested_forum_layout, viewGroup, false);
        initUI();
        cqa();
        initData();
        return this.mRootView;
    }

    private void initUI() {
        this.ksA = (TextView) this.mRootView.findViewById(R.id.interested_desc);
        this.ksz = (TextView) this.mRootView.findViewById(R.id.interested_title);
        this.ksz.setTypeface(Typeface.DEFAULT_BOLD);
        ap.setViewTextColor(this.ksz, R.color.cp_cont_b);
        ap.setViewTextColor(this.ksA, R.color.cp_cont_j);
        this.hcG = (BdRecyclerView) this.mRootView.findViewById(R.id.interested_forum_list_view);
        this.kss = (FrameLayout) this.mRootView.findViewById(R.id.bottom_select_layout);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        this.ksD = (TBSpecificationBtn) this.mRootView.findViewById(R.id.interest_forum_selected_btn);
        this.ksD.setTextSize(R.dimen.tbds42);
        this.ksD.setConfig(aVar);
        this.ksD.setText(getResources().getString(R.string.try_to_select));
        this.ksD.setEnabled(false);
        this.ksD.setOnClickListener(this);
        this.ksl = (TBSpecificationBtn) this.mRootView.findViewById(R.id.select_all_btn);
        this.ksl.setText(getString(R.string.select_all));
        this.ksB = new a(this, this.hcG, this.ksD, this.ksl, getPageContext(), new com.baidu.tieba.newinterest.c.b(getUniqueId()));
    }

    private void cqa() {
        this.ksl.setOnClickListener(this);
    }

    private void initData() {
        this.ksB.es(this.ksC);
        showLoadingView(this.mRootView);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ksl) {
            this.ksB.cTM();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.kss, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.ksz, R.color.cp_cont_b);
        ap.setViewTextColor(this.ksA, R.color.cp_cont_j);
    }

    public void eu(List<b> list) {
        this.ksC = list;
    }

    public void onError(String str) {
        hideLoadingView(this.mRootView);
        showNetRefreshView(this.mRootView, str, false);
    }

    public void cTP() {
        hideLoadingView(this.mRootView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.mRootView);
        this.ksB.es(this.ksC);
        showLoadingView(this.mRootView);
    }
}
