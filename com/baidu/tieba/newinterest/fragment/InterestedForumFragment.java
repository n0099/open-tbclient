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
/* loaded from: classes17.dex */
public class InterestedForumFragment extends BaseFragment {
    private BdRecyclerView hcC;
    private TBSpecificationBtn kse;
    private FrameLayout ksl;
    private TextView kss;
    private TextView kst;
    private a ksu;
    private List<b> ksv;
    private TBSpecificationBtn ksw;
    private View mRootView;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_interested_forum_layout, viewGroup, false);
        initUI();
        cpZ();
        initData();
        return this.mRootView;
    }

    private void initUI() {
        this.kst = (TextView) this.mRootView.findViewById(R.id.interested_desc);
        this.kss = (TextView) this.mRootView.findViewById(R.id.interested_title);
        this.kss.setTypeface(Typeface.DEFAULT_BOLD);
        ap.setViewTextColor(this.kss, R.color.cp_cont_b);
        ap.setViewTextColor(this.kst, R.color.cp_cont_j);
        this.hcC = (BdRecyclerView) this.mRootView.findViewById(R.id.interested_forum_list_view);
        this.ksl = (FrameLayout) this.mRootView.findViewById(R.id.bottom_select_layout);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        this.ksw = (TBSpecificationBtn) this.mRootView.findViewById(R.id.interest_forum_selected_btn);
        this.ksw.setTextSize(R.dimen.tbds42);
        this.ksw.setConfig(aVar);
        this.ksw.setText(getResources().getString(R.string.try_to_select));
        this.ksw.setEnabled(false);
        this.ksw.setOnClickListener(this);
        this.kse = (TBSpecificationBtn) this.mRootView.findViewById(R.id.select_all_btn);
        this.kse.setText(getString(R.string.select_all));
        this.ksu = new a(this, this.hcC, this.ksw, this.kse, getPageContext(), new com.baidu.tieba.newinterest.c.b(getUniqueId()));
    }

    private void cpZ() {
        this.kse.setOnClickListener(this);
    }

    private void initData() {
        this.ksu.es(this.ksv);
        showLoadingView(this.mRootView);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.kse) {
            this.ksu.cTL();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.ksl, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.kss, R.color.cp_cont_b);
        ap.setViewTextColor(this.kst, R.color.cp_cont_j);
    }

    public void eu(List<b> list) {
        this.ksv = list;
    }

    public void onError(String str) {
        hideLoadingView(this.mRootView);
        showNetRefreshView(this.mRootView, str, false);
    }

    public void cTO() {
        hideLoadingView(this.mRootView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.mRootView);
        this.ksu.es(this.ksv);
        showLoadingView(this.mRootView);
    }
}
