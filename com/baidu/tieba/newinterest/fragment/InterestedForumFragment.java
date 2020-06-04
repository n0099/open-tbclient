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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.newinterest.b.a;
import com.baidu.tieba.newinterest.data.b;
import java.util.List;
/* loaded from: classes10.dex */
public class InterestedForumFragment extends BaseFragment {
    private BdRecyclerView gxs;
    private TBSpecificationBtn jAP;
    private FrameLayout jAW;
    private TextView jBd;
    private TextView jBe;
    private a jBf;
    private List<b> jBg;
    private TBSpecificationBtn jBh;
    private View mRootView;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_interested_forum_layout, viewGroup, false);
        initUI();
        bYI();
        initData();
        return this.mRootView;
    }

    private void initUI() {
        this.jBe = (TextView) this.mRootView.findViewById(R.id.interested_desc);
        this.jBd = (TextView) this.mRootView.findViewById(R.id.interested_title);
        this.jBd.setTypeface(Typeface.DEFAULT_BOLD);
        am.setViewTextColor(this.jBd, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.jBe, (int) R.color.cp_cont_j);
        this.gxs = (BdRecyclerView) this.mRootView.findViewById(R.id.interested_forum_list_view);
        this.jAW = (FrameLayout) this.mRootView.findViewById(R.id.bottom_select_layout);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        this.jBh = (TBSpecificationBtn) this.mRootView.findViewById(R.id.interest_forum_selected_btn);
        this.jBh.setTextSize(R.dimen.tbds42);
        this.jBh.setConfig(bVar);
        this.jBh.setText(getResources().getString(R.string.try_to_select));
        this.jBh.setEnabled(false);
        this.jBh.setOnClickListener(this);
        this.jAP = (TBSpecificationBtn) this.mRootView.findViewById(R.id.select_all_btn);
        this.jAP.setText(getString(R.string.select_all));
        this.jBf = new a(this, this.gxs, this.jBh, this.jAP, getPageContext(), new com.baidu.tieba.newinterest.c.b(getUniqueId()));
    }

    private void bYI() {
        this.jAP.setOnClickListener(this);
    }

    private void initData() {
        this.jBf.dQ(this.jBg);
        showLoadingView(this.mRootView);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jAP) {
            this.jBf.cAW();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.jAW, R.color.cp_bg_line_d);
        am.setViewTextColor(this.jBd, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.jBe, (int) R.color.cp_cont_j);
    }

    public void dS(List<b> list) {
        this.jBg = list;
    }

    public void onError(String str) {
        hideLoadingView(this.mRootView);
        showNetRefreshView(this.mRootView, str, false);
    }

    public void cAZ() {
        hideLoadingView(this.mRootView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.mRootView);
        this.jBf.dQ(this.jBg);
        showLoadingView(this.mRootView);
    }
}
