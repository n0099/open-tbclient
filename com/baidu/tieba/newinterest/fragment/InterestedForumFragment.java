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
/* loaded from: classes8.dex */
public class InterestedForumFragment extends BaseFragment {
    private BdRecyclerView ioP;
    private TextView lBE;
    private TextView lBF;
    private a lBG;
    private List<b> lBH;
    private TBSpecificationBtn lBI;
    private TBSpecificationBtn lBq;
    private FrameLayout lBx;
    private View mRootView;

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_interested_forum_layout, viewGroup, false);
        initUI();
        cJp();
        initData();
        return this.mRootView;
    }

    private void initUI() {
        this.lBF = (TextView) this.mRootView.findViewById(R.id.interested_desc);
        this.lBE = (TextView) this.mRootView.findViewById(R.id.interested_title);
        this.lBE.setTypeface(Typeface.DEFAULT_BOLD);
        ao.setViewTextColor(this.lBE, R.color.CAM_X0105);
        ao.setViewTextColor(this.lBF, R.color.CAM_X0107);
        this.ioP = (BdRecyclerView) this.mRootView.findViewById(R.id.interested_forum_list_view);
        this.lBx = (FrameLayout) this.mRootView.findViewById(R.id.bottom_select_layout);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        this.lBI = (TBSpecificationBtn) this.mRootView.findViewById(R.id.interest_forum_selected_btn);
        this.lBI.setTextSize(R.dimen.tbds42);
        this.lBI.setConfig(aVar);
        this.lBI.setText(getResources().getString(R.string.try_to_select));
        this.lBI.setEnabled(false);
        this.lBI.setOnClickListener(this);
        this.lBq = (TBSpecificationBtn) this.mRootView.findViewById(R.id.select_all_btn);
        this.lBq.setText(getString(R.string.select_all));
        this.lBG = new a(this, this.ioP, this.lBI, this.lBq, getPageContext(), new com.baidu.tieba.newinterest.b.b(getUniqueId()));
    }

    private void cJp() {
        this.lBq.setOnClickListener(this);
    }

    private void initData() {
        this.lBG.ff(this.lBH);
        showLoadingView(this.mRootView);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.lBq) {
            this.lBG.dle();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ao.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        ao.setBackgroundColor(this.lBx, R.color.CAM_X0201);
        ao.setViewTextColor(this.lBE, R.color.CAM_X0105);
        ao.setViewTextColor(this.lBF, R.color.CAM_X0107);
    }

    public void fh(List<b> list) {
        this.lBH = list;
    }

    public void onError(String str) {
        hideLoadingView(this.mRootView);
        showNetRefreshView(this.mRootView, str, false);
    }

    public void dlh() {
        hideLoadingView(this.mRootView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.mRootView);
        this.lBG.ff(this.lBH);
        showLoadingView(this.mRootView);
    }
}
