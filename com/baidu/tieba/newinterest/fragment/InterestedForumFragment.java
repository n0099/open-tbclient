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
    private BdRecyclerView icp;
    private TBSpecificationBtn lwA;
    private TBSpecificationBtn lwi;
    private FrameLayout lwp;
    private TextView lww;
    private TextView lwx;
    private a lwy;
    private List<b> lwz;
    private View mRootView;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_interested_forum_layout, viewGroup, false);
        initUI();
        cGq();
        initData();
        return this.mRootView;
    }

    private void initUI() {
        this.lwx = (TextView) this.mRootView.findViewById(R.id.interested_desc);
        this.lww = (TextView) this.mRootView.findViewById(R.id.interested_title);
        this.lww.setTypeface(Typeface.DEFAULT_BOLD);
        ap.setViewTextColor(this.lww, R.color.CAM_X0105);
        ap.setViewTextColor(this.lwx, R.color.CAM_X0107);
        this.icp = (BdRecyclerView) this.mRootView.findViewById(R.id.interested_forum_list_view);
        this.lwp = (FrameLayout) this.mRootView.findViewById(R.id.bottom_select_layout);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        this.lwA = (TBSpecificationBtn) this.mRootView.findViewById(R.id.interest_forum_selected_btn);
        this.lwA.setTextSize(R.dimen.tbds42);
        this.lwA.setConfig(aVar);
        this.lwA.setText(getResources().getString(R.string.try_to_select));
        this.lwA.setEnabled(false);
        this.lwA.setOnClickListener(this);
        this.lwi = (TBSpecificationBtn) this.mRootView.findViewById(R.id.select_all_btn);
        this.lwi.setText(getString(R.string.select_all));
        this.lwy = new a(this, this.icp, this.lwA, this.lwi, getPageContext(), new com.baidu.tieba.newinterest.c.b(getUniqueId()));
    }

    private void cGq() {
        this.lwi.setOnClickListener(this);
    }

    private void initData() {
        this.lwy.ff(this.lwz);
        showLoadingView(this.mRootView);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.lwi) {
            this.lwy.dlu();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        ap.setBackgroundColor(this.lwp, R.color.CAM_X0201);
        ap.setViewTextColor(this.lww, R.color.CAM_X0105);
        ap.setViewTextColor(this.lwx, R.color.CAM_X0107);
    }

    public void fh(List<b> list) {
        this.lwz = list;
    }

    public void onError(String str) {
        hideLoadingView(this.mRootView);
        showNetRefreshView(this.mRootView, str, false);
    }

    public void dlx() {
        hideLoadingView(this.mRootView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.mRootView);
        this.lwy.ff(this.lwz);
        showLoadingView(this.mRootView);
    }
}
