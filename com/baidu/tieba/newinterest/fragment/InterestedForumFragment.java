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
import com.baidu.tieba.newinterest.a.a;
import com.baidu.tieba.newinterest.data.b;
import java.util.List;
/* loaded from: classes8.dex */
public class InterestedForumFragment extends BaseFragment {
    private BdRecyclerView ipO;
    private TBSpecificationBtn lEO;
    private FrameLayout lEV;
    private TextView lFc;
    private TextView lFd;
    private a lFe;
    private List<b> lFf;
    private TBSpecificationBtn lFg;
    private View mRootView;

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_interested_forum_layout, viewGroup, false);
        initUI();
        cGL();
        initData();
        return this.mRootView;
    }

    private void initUI() {
        this.lFd = (TextView) this.mRootView.findViewById(R.id.interested_desc);
        this.lFc = (TextView) this.mRootView.findViewById(R.id.interested_title);
        this.lFc.setTypeface(Typeface.DEFAULT_BOLD);
        ap.setViewTextColor(this.lFc, R.color.CAM_X0105);
        ap.setViewTextColor(this.lFd, R.color.CAM_X0107);
        this.ipO = (BdRecyclerView) this.mRootView.findViewById(R.id.interested_forum_list_view);
        this.lEV = (FrameLayout) this.mRootView.findViewById(R.id.bottom_select_layout);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        this.lFg = (TBSpecificationBtn) this.mRootView.findViewById(R.id.interest_forum_selected_btn);
        this.lFg.setTextSize(R.dimen.tbds42);
        this.lFg.setConfig(aVar);
        this.lFg.setText(getResources().getString(R.string.try_to_select));
        this.lFg.setEnabled(false);
        this.lFg.setOnClickListener(this);
        this.lEO = (TBSpecificationBtn) this.mRootView.findViewById(R.id.select_all_btn);
        this.lEO.setText(getString(R.string.select_all));
        this.lFe = new a(this, this.ipO, this.lFg, this.lEO, getPageContext(), new com.baidu.tieba.newinterest.b.b(getUniqueId()));
    }

    private void cGL() {
        this.lEO.setOnClickListener(this);
    }

    private void initData() {
        this.lFe.fd(this.lFf);
        showLoadingView(this.mRootView);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.lEO) {
            this.lFe.djo();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        ap.setBackgroundColor(this.lEV, R.color.CAM_X0201);
        ap.setViewTextColor(this.lFc, R.color.CAM_X0105);
        ap.setViewTextColor(this.lFd, R.color.CAM_X0107);
    }

    public void ff(List<b> list) {
        this.lFf = list;
    }

    public void onError(String str) {
        hideLoadingView(this.mRootView);
        showNetRefreshView(this.mRootView, str, false);
    }

    public void djr() {
        hideLoadingView(this.mRootView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.mRootView);
        this.lFe.fd(this.lFf);
        showLoadingView(this.mRootView);
    }
}
