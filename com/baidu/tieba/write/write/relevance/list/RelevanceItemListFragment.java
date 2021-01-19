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
    private CustomMessageListener obN = new CustomMessageListener(2921529) { // from class: com.baidu.tieba.write.write.relevance.list.RelevanceItemListFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof EvaluateRelevanceItemSearchMessage)) {
                RelevanceItemListFragment.this.Ut(((EvaluateRelevanceItemSearchMessage) customResponsedMessage).content);
            }
        }
    };
    private RelevanceItemListController ode;

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
        this.ode = new RelevanceItemListController(this, this.mRootView, this.mCategory, getUniqueId());
        if (((RelevanceItemSearchActivity) getActivity()).dXq() == null || ((RelevanceItemSearchActivity) getActivity()).dXq().dXt() == null) {
            str = "";
        } else {
            str = ((RelevanceItemSearchActivity) getActivity()).dXq().dXt().getText().toString();
        }
        if (!TextUtils.isEmpty(str)) {
            Ut(str);
            return;
        }
        showLoadingView(this.mRootView);
        this.ode.dXu();
    }

    private void initListener() {
        registerListener(this.obN);
    }

    public void onError(String str) {
        hideLoadingView(this.mRootView);
        showNetRefreshView(this.mRootView, str, false);
    }

    public void dhq() {
        if (isLoadingViewAttached()) {
            hideLoadingView(this.mRootView);
        }
    }

    public void Ut(String str) {
        if (this.ode != null) {
            this.ode.Ut(str);
            this.ode.getListView().setVisibility(8);
            showLoadingView(this.mRootView);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.mRootView);
        this.ode.dXu();
        showLoadingView(this.mRootView);
    }

    public void cMT() {
        hideLoadingView(this.mRootView);
        showNoDataNoRefreshView(this.mRootView, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.ode.onDestroy();
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }
}
