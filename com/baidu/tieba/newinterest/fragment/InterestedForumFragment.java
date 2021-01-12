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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.newinterest.a.a;
import com.baidu.tieba.newinterest.data.b;
import java.util.List;
/* loaded from: classes7.dex */
public class InterestedForumFragment extends BaseFragment {
    private BdRecyclerView ikg;
    private TBSpecificationBtn lwK;
    private FrameLayout lwR;
    private TextView lwY;
    private TextView lwZ;
    private a lxa;
    private List<b> lxb;
    private TBSpecificationBtn lxc;
    private View mRootView;

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_interested_forum_layout, viewGroup, false);
        initUI();
        cFy();
        initData();
        return this.mRootView;
    }

    private void initUI() {
        this.lwZ = (TextView) this.mRootView.findViewById(R.id.interested_desc);
        this.lwY = (TextView) this.mRootView.findViewById(R.id.interested_title);
        this.lwY.setTypeface(Typeface.DEFAULT_BOLD);
        ao.setViewTextColor(this.lwY, R.color.CAM_X0105);
        ao.setViewTextColor(this.lwZ, R.color.CAM_X0107);
        this.ikg = (BdRecyclerView) this.mRootView.findViewById(R.id.interested_forum_list_view);
        this.lwR = (FrameLayout) this.mRootView.findViewById(R.id.bottom_select_layout);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        this.lxc = (TBSpecificationBtn) this.mRootView.findViewById(R.id.interest_forum_selected_btn);
        this.lxc.setTextSize(R.dimen.tbds42);
        this.lxc.setConfig(aVar);
        this.lxc.setText(getResources().getString(R.string.try_to_select));
        this.lxc.setEnabled(false);
        this.lxc.setOnClickListener(this);
        this.lwK = (TBSpecificationBtn) this.mRootView.findViewById(R.id.select_all_btn);
        this.lwK.setText(getString(R.string.select_all));
        this.lxa = new a(this, this.ikg, this.lxc, this.lwK, getPageContext(), new com.baidu.tieba.newinterest.b.b(getUniqueId()));
    }

    private void cFy() {
        this.lwK.setOnClickListener(this);
    }

    private void initData() {
        this.lxa.ff(this.lxb);
        showLoadingView(this.mRootView);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.lwK) {
            this.lxa.dhn();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ao.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        ao.setBackgroundColor(this.lwR, R.color.CAM_X0201);
        ao.setViewTextColor(this.lwY, R.color.CAM_X0105);
        ao.setViewTextColor(this.lwZ, R.color.CAM_X0107);
    }

    public void fh(List<b> list) {
        this.lxb = list;
    }

    public void onError(String str) {
        hideLoadingView(this.mRootView);
        showNetRefreshView(this.mRootView, str, false);
    }

    public void dhq() {
        hideLoadingView(this.mRootView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.mRootView);
        this.lxa.ff(this.lxb);
        showLoadingView(this.mRootView);
    }
}
