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
import com.baidu.tieba.newinterest.b.a;
import com.baidu.tieba.newinterest.data.b;
import java.util.List;
/* loaded from: classes17.dex */
public class InterestedForumFragment extends BaseFragment {
    private BdRecyclerView gPM;
    private TBSpecificationBtn kcJ;
    private FrameLayout kcQ;
    private TextView kcX;
    private TextView kcY;
    private a kcZ;
    private List<b> kda;
    private TBSpecificationBtn kdb;
    private View mRootView;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_interested_forum_layout, viewGroup, false);
        initUI();
        cfu();
        initData();
        return this.mRootView;
    }

    private void initUI() {
        this.kcY = (TextView) this.mRootView.findViewById(R.id.interested_desc);
        this.kcX = (TextView) this.mRootView.findViewById(R.id.interested_title);
        this.kcX.setTypeface(Typeface.DEFAULT_BOLD);
        ao.setViewTextColor(this.kcX, R.color.cp_cont_b);
        ao.setViewTextColor(this.kcY, R.color.cp_cont_j);
        this.gPM = (BdRecyclerView) this.mRootView.findViewById(R.id.interested_forum_list_view);
        this.kcQ = (FrameLayout) this.mRootView.findViewById(R.id.bottom_select_layout);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        this.kdb = (TBSpecificationBtn) this.mRootView.findViewById(R.id.interest_forum_selected_btn);
        this.kdb.setTextSize(R.dimen.tbds42);
        this.kdb.setConfig(bVar);
        this.kdb.setText(getResources().getString(R.string.try_to_select));
        this.kdb.setEnabled(false);
        this.kdb.setOnClickListener(this);
        this.kcJ = (TBSpecificationBtn) this.mRootView.findViewById(R.id.select_all_btn);
        this.kcJ.setText(getString(R.string.select_all));
        this.kcZ = new a(this, this.gPM, this.kdb, this.kcJ, getPageContext(), new com.baidu.tieba.newinterest.c.b(getUniqueId()));
    }

    private void cfu() {
        this.kcJ.setOnClickListener(this);
    }

    private void initData() {
        this.kcZ.ek(this.kda);
        showLoadingView(this.mRootView);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.kcJ) {
            this.kcZ.cIW();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ao.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        ao.setBackgroundColor(this.kcQ, R.color.cp_bg_line_d);
        ao.setViewTextColor(this.kcX, R.color.cp_cont_b);
        ao.setViewTextColor(this.kcY, R.color.cp_cont_j);
    }

    public void em(List<b> list) {
        this.kda = list;
    }

    public void onError(String str) {
        hideLoadingView(this.mRootView);
        showNetRefreshView(this.mRootView, str, false);
    }

    public void cIZ() {
        hideLoadingView(this.mRootView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.mRootView);
        this.kcZ.ek(this.kda);
        showLoadingView(this.mRootView);
    }
}
