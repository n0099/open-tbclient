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
    public View f22272e;

    /* renamed from: f  reason: collision with root package name */
    public RelevanceItemListController f22273f;

    /* renamed from: g  reason: collision with root package name */
    public String f22274g;

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f22275h = new a(2921529);

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
        RelevanceItemListController relevanceItemListController = this.f22273f;
        if (relevanceItemListController == null) {
            return;
        }
        relevanceItemListController.g(str);
        this.f22273f.i().setVisibility(8);
        showLoadingView(this.f22272e);
    }

    public final void F0() {
        registerListener(this.f22275h);
    }

    public void G0() {
        if (isLoadingViewAttached()) {
            hideLoadingView(this.f22272e);
        }
    }

    public void H0(String str) {
        hideLoadingView(this.f22272e);
        showNetRefreshView(this.f22272e, str, false);
    }

    public void I0() {
        hideLoadingView(this.f22272e);
        showNoDataNoRefreshView(this.f22272e, false);
    }

    public void J0(String str) {
        this.f22274g = str;
    }

    public final void initData() {
        this.f22273f = new RelevanceItemListController(this, this.f22272e, this.f22274g, getUniqueId());
        String obj = (((RelevanceItemSearchActivity) getActivity()).getSearchView() == null || ((RelevanceItemSearchActivity) getActivity()).getSearchView().h() == null) ? "" : ((RelevanceItemSearchActivity) getActivity()).getSearchView().h().getText().toString();
        if (!TextUtils.isEmpty(obj)) {
            E0(obj);
            return;
        }
        showLoadingView(this.f22272e);
        this.f22273f.h();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.f22272e == null) {
            this.f22272e = layoutInflater.inflate(R.layout.fragment_relevance_item_list, (ViewGroup) null);
        }
        initData();
        F0();
        return this.f22272e;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f22273f.k();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.f22272e);
        this.f22273f.h();
        showLoadingView(this.f22272e);
    }
}
