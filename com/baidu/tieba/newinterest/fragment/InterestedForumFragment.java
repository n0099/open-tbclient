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
/* loaded from: classes7.dex */
public class InterestedForumFragment extends BaseFragment {
    private BdRecyclerView irL;
    private TBSpecificationBtn lHe;
    private FrameLayout lHl;
    private TextView lHs;
    private TextView lHt;
    private a lHu;
    private List<b> lHv;
    private TBSpecificationBtn lHw;
    private View mRootView;

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_interested_forum_layout, viewGroup, false);
        initUI();
        cGY();
        initData();
        return this.mRootView;
    }

    private void initUI() {
        this.lHt = (TextView) this.mRootView.findViewById(R.id.interested_desc);
        this.lHs = (TextView) this.mRootView.findViewById(R.id.interested_title);
        this.lHs.setTypeface(Typeface.DEFAULT_BOLD);
        ap.setViewTextColor(this.lHs, R.color.CAM_X0105);
        ap.setViewTextColor(this.lHt, R.color.CAM_X0107);
        this.irL = (BdRecyclerView) this.mRootView.findViewById(R.id.interested_forum_list_view);
        this.lHl = (FrameLayout) this.mRootView.findViewById(R.id.bottom_select_layout);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        this.lHw = (TBSpecificationBtn) this.mRootView.findViewById(R.id.interest_forum_selected_btn);
        this.lHw.setTextSize(R.dimen.tbds42);
        this.lHw.setConfig(aVar);
        this.lHw.setText(getResources().getString(R.string.try_to_select));
        this.lHw.setEnabled(false);
        this.lHw.setOnClickListener(this);
        this.lHe = (TBSpecificationBtn) this.mRootView.findViewById(R.id.select_all_btn);
        this.lHe.setText(getString(R.string.select_all));
        this.lHu = new a(this, this.irL, this.lHw, this.lHe, getPageContext(), new com.baidu.tieba.newinterest.b.b(getUniqueId()));
    }

    private void cGY() {
        this.lHe.setOnClickListener(this);
    }

    private void initData() {
        this.lHu.fd(this.lHv);
        showLoadingView(this.mRootView);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.lHe) {
            this.lHu.djE();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        ap.setBackgroundColor(this.lHl, R.color.CAM_X0201);
        ap.setViewTextColor(this.lHs, R.color.CAM_X0105);
        ap.setViewTextColor(this.lHt, R.color.CAM_X0107);
    }

    public void ff(List<b> list) {
        this.lHv = list;
    }

    public void onError(String str) {
        hideLoadingView(this.mRootView);
        showNetRefreshView(this.mRootView, str, false);
    }

    public void djH() {
        hideLoadingView(this.mRootView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.mRootView);
        this.lHu.fd(this.lHv);
        showLoadingView(this.mRootView);
    }
}
