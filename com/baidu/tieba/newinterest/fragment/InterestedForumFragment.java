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
/* loaded from: classes8.dex */
public class InterestedForumFragment extends BaseFragment {
    private BdRecyclerView iqc;
    private TBSpecificationBtn lFc;
    private FrameLayout lFj;
    private TextView lFq;
    private TextView lFr;
    private a lFs;
    private List<b> lFt;
    private TBSpecificationBtn lFu;
    private View mRootView;

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_interested_forum_layout, viewGroup, false);
        initUI();
        cGS();
        initData();
        return this.mRootView;
    }

    private void initUI() {
        this.lFr = (TextView) this.mRootView.findViewById(R.id.interested_desc);
        this.lFq = (TextView) this.mRootView.findViewById(R.id.interested_title);
        this.lFq.setTypeface(Typeface.DEFAULT_BOLD);
        ap.setViewTextColor(this.lFq, R.color.CAM_X0105);
        ap.setViewTextColor(this.lFr, R.color.CAM_X0107);
        this.iqc = (BdRecyclerView) this.mRootView.findViewById(R.id.interested_forum_list_view);
        this.lFj = (FrameLayout) this.mRootView.findViewById(R.id.bottom_select_layout);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        this.lFu = (TBSpecificationBtn) this.mRootView.findViewById(R.id.interest_forum_selected_btn);
        this.lFu.setTextSize(R.dimen.tbds42);
        this.lFu.setConfig(aVar);
        this.lFu.setText(getResources().getString(R.string.try_to_select));
        this.lFu.setEnabled(false);
        this.lFu.setOnClickListener(this);
        this.lFc = (TBSpecificationBtn) this.mRootView.findViewById(R.id.select_all_btn);
        this.lFc.setText(getString(R.string.select_all));
        this.lFs = new a(this, this.iqc, this.lFu, this.lFc, getPageContext(), new com.baidu.tieba.newinterest.b.b(getUniqueId()));
    }

    private void cGS() {
        this.lFc.setOnClickListener(this);
    }

    private void initData() {
        this.lFs.fd(this.lFt);
        showLoadingView(this.mRootView);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.lFc) {
            this.lFs.djv();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201);
        ap.setBackgroundColor(this.lFj, R.color.CAM_X0201);
        ap.setViewTextColor(this.lFq, R.color.CAM_X0105);
        ap.setViewTextColor(this.lFr, R.color.CAM_X0107);
    }

    public void ff(List<b> list) {
        this.lFt = list;
    }

    public void onError(String str) {
        hideLoadingView(this.mRootView);
        showNetRefreshView(this.mRootView, str, false);
    }

    public void djy() {
        hideLoadingView(this.mRootView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.mRootView);
        this.lFs.fd(this.lFt);
        showLoadingView(this.mRootView);
    }
}
