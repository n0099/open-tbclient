package com.baidu.tieba.write.write.relevance.list;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.message.EvaluateRelevanceItemSearchMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.relevance.RelevanceItemSearchActivity;
/* loaded from: classes7.dex */
public class RelevanceItemListFragment extends BaseFragment {
    private String mCategory;
    private View mRootView;
    private CustomMessageListener oom = new CustomMessageListener(2921529) { // from class: com.baidu.tieba.write.write.relevance.list.RelevanceItemListFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof EvaluateRelevanceItemSearchMessage)) {
                RelevanceItemListFragment.this.VK(((EvaluateRelevanceItemSearchMessage) customResponsedMessage).content);
            }
        }
    };
    private RelevanceItemListController opC;

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(R.layout.fragment_relevance_item_list, (ViewGroup) null);
        }
        initData();
        initListener();
        return this.mRootView;
    }

    private void initData() {
        String str;
        this.opC = new RelevanceItemListController(this, this.mRootView, this.mCategory, getUniqueId());
        if (((RelevanceItemSearchActivity) getActivity()).dZR() == null || ((RelevanceItemSearchActivity) getActivity()).dZR().dZU() == null) {
            str = "";
        } else {
            str = ((RelevanceItemSearchActivity) getActivity()).dZR().dZU().getText().toString();
        }
        if (!TextUtils.isEmpty(str)) {
            VK(str);
            return;
        }
        showLoadingView(this.mRootView);
        this.opC.dZV();
    }

    private void initListener() {
        registerListener(this.oom);
    }

    public void onError(String str) {
        hideLoadingView(this.mRootView);
        showNetRefreshView(this.mRootView, str, false);
    }

    public void djH() {
        if (isLoadingViewAttached()) {
            hideLoadingView(this.mRootView);
        }
    }

    public void VK(String str) {
        if (this.opC != null) {
            this.opC.VK(str);
            this.opC.getListView().setVisibility(8);
            showLoadingView(this.mRootView);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.mRootView);
        this.opC.dZV();
        showLoadingView(this.mRootView);
    }

    public void cPd() {
        hideLoadingView(this.mRootView);
        showNoDataNoRefreshView(this.mRootView, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.opC.onDestroy();
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }
}
