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
    private BdRecyclerView hKW;
    private FrameLayout lcA;
    private TextView lcH;
    private TextView lcI;
    private a lcJ;
    private List<b> lcK;
    private TBSpecificationBtn lcL;
    private TBSpecificationBtn lct;
    private View mRootView;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_interested_forum_layout, viewGroup, false);
        initUI();
        czR();
        initData();
        return this.mRootView;
    }

    private void initUI() {
        this.lcI = (TextView) this.mRootView.findViewById(R.id.interested_desc);
        this.lcH = (TextView) this.mRootView.findViewById(R.id.interested_title);
        this.lcH.setTypeface(Typeface.DEFAULT_BOLD);
        ap.setViewTextColor(this.lcH, R.color.cp_cont_b);
        ap.setViewTextColor(this.lcI, R.color.cp_cont_j);
        this.hKW = (BdRecyclerView) this.mRootView.findViewById(R.id.interested_forum_list_view);
        this.lcA = (FrameLayout) this.mRootView.findViewById(R.id.bottom_select_layout);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        this.lcL = (TBSpecificationBtn) this.mRootView.findViewById(R.id.interest_forum_selected_btn);
        this.lcL.setTextSize(R.dimen.tbds42);
        this.lcL.setConfig(aVar);
        this.lcL.setText(getResources().getString(R.string.try_to_select));
        this.lcL.setEnabled(false);
        this.lcL.setOnClickListener(this);
        this.lct = (TBSpecificationBtn) this.mRootView.findViewById(R.id.select_all_btn);
        this.lct.setText(getString(R.string.select_all));
        this.lcJ = new a(this, this.hKW, this.lcL, this.lct, getPageContext(), new com.baidu.tieba.newinterest.c.b(getUniqueId()));
    }

    private void czR() {
        this.lct.setOnClickListener(this);
    }

    private void initData() {
        this.lcJ.eM(this.lcK);
        showLoadingView(this.mRootView);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.lct) {
            this.lcJ.dei();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.lcA, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.lcH, R.color.cp_cont_b);
        ap.setViewTextColor(this.lcI, R.color.cp_cont_j);
    }

    public void eO(List<b> list) {
        this.lcK = list;
    }

    public void onError(String str) {
        hideLoadingView(this.mRootView);
        showNetRefreshView(this.mRootView, str, false);
    }

    public void del() {
        hideLoadingView(this.mRootView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.mRootView);
        this.lcJ.eM(this.lcK);
        showLoadingView(this.mRootView);
    }
}
