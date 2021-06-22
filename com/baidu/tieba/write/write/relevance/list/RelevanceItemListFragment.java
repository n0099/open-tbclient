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
    public View f22329e;

    /* renamed from: f  reason: collision with root package name */
    public RelevanceItemListController f22330f;

    /* renamed from: g  reason: collision with root package name */
    public String f22331g;

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f22332h = new a(2921529);

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage instanceof EvaluateRelevanceItemSearchMessage)) {
                return;
            }
            RelevanceItemListFragment.this.G0(((EvaluateRelevanceItemSearchMessage) customResponsedMessage).content);
        }
    }

    public void G0(String str) {
        RelevanceItemListController relevanceItemListController = this.f22330f;
        if (relevanceItemListController == null) {
            return;
        }
        relevanceItemListController.g(str);
        this.f22330f.i().setVisibility(8);
        showLoadingView(this.f22329e);
    }

    public final void H0() {
        registerListener(this.f22332h);
    }

    public void I0() {
        if (isLoadingViewAttached()) {
            hideLoadingView(this.f22329e);
        }
    }

    public void J0(String str) {
        hideLoadingView(this.f22329e);
        showNetRefreshView(this.f22329e, str, false);
    }

    public void K0() {
        hideLoadingView(this.f22329e);
        showNoDataNoRefreshView(this.f22329e, false);
    }

    public void L0(String str) {
        this.f22331g = str;
    }

    public final void initData() {
        this.f22330f = new RelevanceItemListController(this, this.f22329e, this.f22331g, getUniqueId());
        String obj = (((RelevanceItemSearchActivity) getActivity()).getSearchView() == null || ((RelevanceItemSearchActivity) getActivity()).getSearchView().h() == null) ? "" : ((RelevanceItemSearchActivity) getActivity()).getSearchView().h().getText().toString();
        if (!TextUtils.isEmpty(obj)) {
            G0(obj);
            return;
        }
        showLoadingView(this.f22329e);
        this.f22330f.h();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.f22329e == null) {
            this.f22329e = layoutInflater.inflate(R.layout.fragment_relevance_item_list, (ViewGroup) null);
        }
        initData();
        H0();
        return this.f22329e;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f22330f.k();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.f22329e);
        this.f22330f.h();
        showLoadingView(this.f22329e);
    }
}
