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
    private BdRecyclerView gxh;
    private List<b> jAa;
    private TBSpecificationBtn jAb;
    private TBSpecificationBtn jzJ;
    private FrameLayout jzQ;
    private TextView jzX;
    private TextView jzY;
    private a jzZ;
    private View mRootView;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_interested_forum_layout, viewGroup, false);
        initUI();
        cAH();
        initData();
        return this.mRootView;
    }

    private void initUI() {
        this.jzY = (TextView) this.mRootView.findViewById(R.id.interested_desc);
        this.jzX = (TextView) this.mRootView.findViewById(R.id.interested_title);
        this.jzX.setTypeface(Typeface.DEFAULT_BOLD);
        am.setViewTextColor(this.jzX, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.jzY, (int) R.color.cp_cont_j);
        this.gxh = (BdRecyclerView) this.mRootView.findViewById(R.id.interested_forum_list_view);
        this.jzQ = (FrameLayout) this.mRootView.findViewById(R.id.bottom_select_layout);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        this.jAb = (TBSpecificationBtn) this.mRootView.findViewById(R.id.interest_forum_selected_btn);
        this.jAb.setTextSize(R.dimen.tbds42);
        this.jAb.setConfig(bVar);
        this.jAb.setText(getResources().getString(R.string.try_to_select));
        this.jAb.setEnabled(false);
        this.jAb.setOnClickListener(this);
        this.jzJ = (TBSpecificationBtn) this.mRootView.findViewById(R.id.select_all_btn);
        this.jzJ.setText(getString(R.string.select_all));
        this.jzZ = new a(this, this.gxh, this.jAb, this.jzJ, getPageContext(), new com.baidu.tieba.newinterest.c.b(getUniqueId()));
    }

    private void cAH() {
        this.jzJ.setOnClickListener(this);
    }

    private void initData() {
        this.jzZ.dO(this.jAa);
        showLoadingView(this.mRootView);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jzJ) {
            this.jzZ.cAF();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.jzQ, R.color.cp_bg_line_d);
        am.setViewTextColor(this.jzX, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.jzY, (int) R.color.cp_cont_j);
    }

    public void dQ(List<b> list) {
        this.jAa = list;
    }

    public void onError(String str) {
        hideLoadingView(this.mRootView);
        showNetRefreshView(this.mRootView, str, false);
    }

    public void cAJ() {
        hideLoadingView(this.mRootView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.mRootView);
        this.jzZ.dO(this.jAa);
        showLoadingView(this.mRootView);
    }
}
