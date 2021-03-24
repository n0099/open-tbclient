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
/* loaded from: classes5.dex */
public class RelevanceItemListFragment extends BaseFragment {

    /* renamed from: e  reason: collision with root package name */
    public View f22586e;

    /* renamed from: f  reason: collision with root package name */
    public RelevanceItemListController f22587f;

    /* renamed from: g  reason: collision with root package name */
    public String f22588g;

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f22589h = new a(2921529);

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage instanceof EvaluateRelevanceItemSearchMessage)) {
                return;
            }
            RelevanceItemListFragment.this.E0(((EvaluateRelevanceItemSearchMessage) customResponsedMessage).content);
        }
    }

    public void E0(String str) {
        RelevanceItemListController relevanceItemListController = this.f22587f;
        if (relevanceItemListController == null) {
            return;
        }
        relevanceItemListController.g(str);
        this.f22587f.i().setVisibility(8);
        showLoadingView(this.f22586e);
    }

    public final void F0() {
        registerListener(this.f22589h);
    }

    public void G0() {
        if (isLoadingViewAttached()) {
            hideLoadingView(this.f22586e);
        }
    }

    public void H0(String str) {
        hideLoadingView(this.f22586e);
        showNetRefreshView(this.f22586e, str, false);
    }

    public void I0() {
        hideLoadingView(this.f22586e);
        showNoDataNoRefreshView(this.f22586e, false);
    }

    public void J0(String str) {
        this.f22588g = str;
    }

    public final void initData() {
        this.f22587f = new RelevanceItemListController(this, this.f22586e, this.f22588g, getUniqueId());
        String obj = (((RelevanceItemSearchActivity) getActivity()).getSearchView() == null || ((RelevanceItemSearchActivity) getActivity()).getSearchView().h() == null) ? "" : ((RelevanceItemSearchActivity) getActivity()).getSearchView().h().getText().toString();
        if (!TextUtils.isEmpty(obj)) {
            E0(obj);
            return;
        }
        showLoadingView(this.f22586e);
        this.f22587f.h();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.f22586e == null) {
            this.f22586e = layoutInflater.inflate(R.layout.fragment_relevance_item_list, (ViewGroup) null);
        }
        initData();
        F0();
        return this.f22586e;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f22587f.k();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.f22586e);
        this.f22587f.h();
        showLoadingView(this.f22586e);
    }
}
