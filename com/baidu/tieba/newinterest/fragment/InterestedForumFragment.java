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
    private BdRecyclerView hRt;
    private TBSpecificationBtn liH;
    private FrameLayout liO;
    private TextView liV;
    private TextView liW;
    private a liX;
    private List<b> liY;
    private TBSpecificationBtn liZ;
    private View mRootView;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_interested_forum_layout, viewGroup, false);
        initUI();
        cBW();
        initData();
        return this.mRootView;
    }

    private void initUI() {
        this.liW = (TextView) this.mRootView.findViewById(R.id.interested_desc);
        this.liV = (TextView) this.mRootView.findViewById(R.id.interested_title);
        this.liV.setTypeface(Typeface.DEFAULT_BOLD);
        ap.setViewTextColor(this.liV, R.color.CAM_X0105);
        ap.setViewTextColor(this.liW, R.color.CAM_X0107);
        this.hRt = (BdRecyclerView) this.mRootView.findViewById(R.id.interested_forum_list_view);
        this.liO = (FrameLayout) this.mRootView.findViewById(R.id.bottom_select_layout);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        this.liZ = (TBSpecificationBtn) this.mRootView.findViewById(R.id.interest_forum_selected_btn);
        this.liZ.setTextSize(R.dimen.tbds42);
        this.liZ.setConfig(aVar);
        this.liZ.setText(getResources().getString(R.string.try_to_select));
        this.liZ.setEnabled(false);
        this.liZ.setOnClickListener(this);
        this.liH = (TBSpecificationBtn) this.mRootView.findViewById(R.id.select_all_btn);
        this.liH.setText(getString(R.string.select_all));
        this.liX = new a(this, this.hRt, this.liZ, this.liH, getPageContext(), new com.baidu.tieba.newinterest.c.b(getUniqueId()));
    }

    private void cBW() {
        this.liH.setOnClickListener(this);
    }

    private void initData() {
        this.liX.eU(this.liY);
        showLoadingView(this.mRootView);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.liH) {
            this.liX.dgh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        ap.setBackgroundColor(this.liO, R.color.CAM_X0201);
        ap.setViewTextColor(this.liV, R.color.CAM_X0105);
        ap.setViewTextColor(this.liW, R.color.CAM_X0107);
    }

    public void eW(List<b> list) {
        this.liY = list;
    }

    public void onError(String str) {
        hideLoadingView(this.mRootView);
        showNetRefreshView(this.mRootView, str, false);
    }

    public void dgk() {
        hideLoadingView(this.mRootView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.mRootView);
        this.liX.eU(this.liY);
        showLoadingView(this.mRootView);
    }
}
