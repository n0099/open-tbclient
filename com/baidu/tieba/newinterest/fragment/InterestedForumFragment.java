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
/* loaded from: classes22.dex */
public class InterestedForumFragment extends BaseFragment {
    private BdRecyclerView hjF;
    private TBSpecificationBtn kAK;
    private FrameLayout kAR;
    private TextView kAY;
    private TextView kAZ;
    private a kBa;
    private List<b> kBb;
    private TBSpecificationBtn kBc;
    private View mRootView;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_interested_forum_layout, viewGroup, false);
        initUI();
        ctn();
        initData();
        return this.mRootView;
    }

    private void initUI() {
        this.kAZ = (TextView) this.mRootView.findViewById(R.id.interested_desc);
        this.kAY = (TextView) this.mRootView.findViewById(R.id.interested_title);
        this.kAY.setTypeface(Typeface.DEFAULT_BOLD);
        ap.setViewTextColor(this.kAY, R.color.cp_cont_b);
        ap.setViewTextColor(this.kAZ, R.color.cp_cont_j);
        this.hjF = (BdRecyclerView) this.mRootView.findViewById(R.id.interested_forum_list_view);
        this.kAR = (FrameLayout) this.mRootView.findViewById(R.id.bottom_select_layout);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        this.kBc = (TBSpecificationBtn) this.mRootView.findViewById(R.id.interest_forum_selected_btn);
        this.kBc.setTextSize(R.dimen.tbds42);
        this.kBc.setConfig(aVar);
        this.kBc.setText(getResources().getString(R.string.try_to_select));
        this.kBc.setEnabled(false);
        this.kBc.setOnClickListener(this);
        this.kAK = (TBSpecificationBtn) this.mRootView.findViewById(R.id.select_all_btn);
        this.kAK.setText(getString(R.string.select_all));
        this.kBa = new a(this, this.hjF, this.kBc, this.kAK, getPageContext(), new com.baidu.tieba.newinterest.c.b(getUniqueId()));
    }

    private void ctn() {
        this.kAK.setOnClickListener(this);
    }

    private void initData() {
        this.kBa.eA(this.kBb);
        showLoadingView(this.mRootView);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.kAK) {
            this.kBa.cXr();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.kAR, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.kAY, R.color.cp_cont_b);
        ap.setViewTextColor(this.kAZ, R.color.cp_cont_j);
    }

    public void eC(List<b> list) {
        this.kBb = list;
    }

    public void onError(String str) {
        hideLoadingView(this.mRootView);
        showNetRefreshView(this.mRootView, str, false);
    }

    public void cXu() {
        hideLoadingView(this.mRootView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.mRootView);
        this.kBa.eA(this.kBb);
        showLoadingView(this.mRootView);
    }
}
