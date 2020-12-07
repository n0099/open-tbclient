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
    private BdRecyclerView icn;
    private TBSpecificationBtn lwg;
    private FrameLayout lwn;
    private TextView lwu;
    private TextView lwv;
    private a lww;
    private List<b> lwx;
    private TBSpecificationBtn lwy;
    private View mRootView;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_interested_forum_layout, viewGroup, false);
        initUI();
        cGp();
        initData();
        return this.mRootView;
    }

    private void initUI() {
        this.lwv = (TextView) this.mRootView.findViewById(R.id.interested_desc);
        this.lwu = (TextView) this.mRootView.findViewById(R.id.interested_title);
        this.lwu.setTypeface(Typeface.DEFAULT_BOLD);
        ap.setViewTextColor(this.lwu, R.color.CAM_X0105);
        ap.setViewTextColor(this.lwv, R.color.CAM_X0107);
        this.icn = (BdRecyclerView) this.mRootView.findViewById(R.id.interested_forum_list_view);
        this.lwn = (FrameLayout) this.mRootView.findViewById(R.id.bottom_select_layout);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        this.lwy = (TBSpecificationBtn) this.mRootView.findViewById(R.id.interest_forum_selected_btn);
        this.lwy.setTextSize(R.dimen.tbds42);
        this.lwy.setConfig(aVar);
        this.lwy.setText(getResources().getString(R.string.try_to_select));
        this.lwy.setEnabled(false);
        this.lwy.setOnClickListener(this);
        this.lwg = (TBSpecificationBtn) this.mRootView.findViewById(R.id.select_all_btn);
        this.lwg.setText(getString(R.string.select_all));
        this.lww = new a(this, this.icn, this.lwy, this.lwg, getPageContext(), new com.baidu.tieba.newinterest.c.b(getUniqueId()));
    }

    private void cGp() {
        this.lwg.setOnClickListener(this);
    }

    private void initData() {
        this.lww.ff(this.lwx);
        showLoadingView(this.mRootView);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.lwg) {
            this.lww.dlt();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        ap.setBackgroundColor(this.lwn, R.color.CAM_X0201);
        ap.setViewTextColor(this.lwu, R.color.CAM_X0105);
        ap.setViewTextColor(this.lwv, R.color.CAM_X0107);
    }

    public void fh(List<b> list) {
        this.lwx = list;
    }

    public void onError(String str) {
        hideLoadingView(this.mRootView);
        showNetRefreshView(this.mRootView, str, false);
    }

    public void dlw() {
        hideLoadingView(this.mRootView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.mRootView);
        this.lww.ff(this.lwx);
        showLoadingView(this.mRootView);
    }
}
