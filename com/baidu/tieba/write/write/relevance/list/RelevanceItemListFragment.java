package com.baidu.tieba.write.write.relevance.list;

import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class RelevanceItemListFragment extends BaseFragment {
    private String mCategory;
    private View mRootView;
    private a oge;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.fragment_relevance_item_list, (ViewGroup) null);
        }
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        showLoadingView(this.mRootView);
        this.oge = new a(this, this.mRootView, this.mCategory, getUniqueId());
        this.oge.eco();
    }

    public void onError(String str) {
        hideLoadingView(this.mRootView);
        showNetRefreshView(this.mRootView, str, false);
    }

    public void dlw() {
        if (isLoadingViewAttached()) {
            hideLoadingView(this.mRootView);
        }
    }

    public void g(Editable editable) {
        this.oge.g(editable);
        this.oge.getListView().setVisibility(8);
        showLoadingView(this.mRootView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.mRootView);
        this.oge.eco();
        showLoadingView(this.mRootView);
    }

    public void cND() {
        hideLoadingView(this.mRootView);
        showNoDataNoRefreshView(this.mRootView, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.oge.onDestroy();
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }
}
