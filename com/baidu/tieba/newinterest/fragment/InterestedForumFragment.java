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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.newinterest.b.a;
import com.baidu.tieba.newinterest.data.b;
import java.util.List;
/* loaded from: classes10.dex */
public class InterestedForumFragment extends BaseFragment {
    private BdRecyclerView gKg;
    private TBSpecificationBtn jUA;
    private TBSpecificationBtn jUi;
    private FrameLayout jUp;
    private TextView jUw;
    private TextView jUx;
    private a jUy;
    private List<b> jUz;
    private View mRootView;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_interested_forum_layout, viewGroup, false);
        initUI();
        cbW();
        initData();
        return this.mRootView;
    }

    private void initUI() {
        this.jUx = (TextView) this.mRootView.findViewById(R.id.interested_desc);
        this.jUw = (TextView) this.mRootView.findViewById(R.id.interested_title);
        this.jUw.setTypeface(Typeface.DEFAULT_BOLD);
        an.setViewTextColor(this.jUw, (int) R.color.cp_cont_b);
        an.setViewTextColor(this.jUx, (int) R.color.cp_cont_j);
        this.gKg = (BdRecyclerView) this.mRootView.findViewById(R.id.interested_forum_list_view);
        this.jUp = (FrameLayout) this.mRootView.findViewById(R.id.bottom_select_layout);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        this.jUA = (TBSpecificationBtn) this.mRootView.findViewById(R.id.interest_forum_selected_btn);
        this.jUA.setTextSize(R.dimen.tbds42);
        this.jUA.setConfig(bVar);
        this.jUA.setText(getResources().getString(R.string.try_to_select));
        this.jUA.setEnabled(false);
        this.jUA.setOnClickListener(this);
        this.jUi = (TBSpecificationBtn) this.mRootView.findViewById(R.id.select_all_btn);
        this.jUi.setText(getString(R.string.select_all));
        this.jUy = new a(this, this.gKg, this.jUA, this.jUi, getPageContext(), new com.baidu.tieba.newinterest.c.b(getUniqueId()));
    }

    private void cbW() {
        this.jUi.setOnClickListener(this);
    }

    private void initData() {
        this.jUy.ee(this.jUz);
        showLoadingView(this.mRootView);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jUi) {
            this.jUy.cFn();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        an.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        an.setBackgroundColor(this.jUp, R.color.cp_bg_line_d);
        an.setViewTextColor(this.jUw, (int) R.color.cp_cont_b);
        an.setViewTextColor(this.jUx, (int) R.color.cp_cont_j);
    }

    public void eg(List<b> list) {
        this.jUz = list;
    }

    public void onError(String str) {
        hideLoadingView(this.mRootView);
        showNetRefreshView(this.mRootView, str, false);
    }

    public void cFq() {
        hideLoadingView(this.mRootView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.mRootView);
        this.jUy.ee(this.jUz);
        showLoadingView(this.mRootView);
    }
}
