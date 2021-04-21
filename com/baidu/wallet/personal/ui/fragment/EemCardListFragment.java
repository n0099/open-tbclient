package com.baidu.wallet.personal.ui.fragment;

import android.app.Activity;
import android.content.Context;
import com.baidu.wallet.core.beans.BeanManager;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.k;
import com.baidu.wallet.paysdk.datamodel.CardListResponse;
import com.baidu.wallet.paysdk.datamodel.SourceFlag;
import com.baidu.wallet.personal.storage.CardListCache;
import com.baidu.wallet.personal.storage.a;
import com.baidu.wallet.personal.ui.fragment.base.CardListBaseFragment;
/* loaded from: classes5.dex */
public class EemCardListFragment extends CardListBaseFragment {

    /* renamed from: a  reason: collision with root package name */
    public k f26336a;

    @Override // com.baidu.wallet.personal.ui.fragment.base.CardListBaseFragment
    public void bindCardData(boolean z) {
        CardListResponse.Card[] cardArr = this.mCardListResponse.bind_card_arr;
        if (cardArr != null) {
            this.mBankLayout.setData(true, cardArr, 1, z, this.mOnCardClickListener);
        }
    }

    @Override // com.baidu.wallet.personal.ui.fragment.base.CardListBaseFragment
    public void getCacheData() {
        CardListCache.getInstance().getEemCardList(new CardListCache.a<CardListResponse>() { // from class: com.baidu.wallet.personal.ui.fragment.EemCardListFragment.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.wallet.personal.storage.CardListCache.a
            public void a(final CardListResponse cardListResponse) {
                EemCardListFragment.this.mActivity.runOnUiThread(new Runnable() { // from class: com.baidu.wallet.personal.ui.fragment.EemCardListFragment.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        EemCardListFragment eemCardListFragment = EemCardListFragment.this;
                        CardListResponse cardListResponse2 = cardListResponse;
                        eemCardListFragment.mCardListResponse = cardListResponse2;
                        if (cardListResponse2 != null) {
                            eemCardListFragment.mLoadFailedView.setVisibility(8);
                            EemCardListFragment.this.bindData(true);
                        }
                    }
                });
            }
        });
    }

    @Override // com.baidu.wallet.personal.ui.fragment.base.CardListBaseFragment
    public void handleFailure(int i, int i2, String str) {
        hideLoading();
        super.handleFailure(i, i2, str);
    }

    @Override // com.baidu.wallet.personal.ui.fragment.base.CardListBaseFragment
    public void handleResponse(int i, Object obj, String str) {
        hideLoading();
        super.handleResponse(i, obj, str);
        Activity activity = this.mActivity;
        if (activity != null) {
            a.c(activity, CardListBaseFragment.KEY_HAS_EEM_CARD_LIST_LOADED + CardListCache.getInstance().getUserIdV2(), Boolean.TRUE);
        }
    }

    @Override // com.baidu.wallet.personal.ui.fragment.base.CardListBaseFragment
    public void loadData() {
        removeRequest();
        Activity activity = this.mActivity;
        if (!a.d(activity, CardListBaseFragment.KEY_HAS_EEM_CARD_LIST_LOADED + CardListCache.getInstance().getUserIdV2(), Boolean.FALSE)) {
            showLoading();
        }
        if (this.f26336a == null) {
            this.f26336a = (k) PayBeanFactory.getInstance().getBean((Context) getActivity(), 607, "EemCardListFragment");
        }
        this.f26336a.setResponseCallback(this);
        this.f26336a.a(SourceFlag.SDK);
        this.f26336a.execBean();
    }

    @Override // com.baidu.wallet.personal.ui.fragment.base.CardListBaseFragment, com.baidu.wallet.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        CardListCache.getInstance().getEemCardList(null);
    }

    @Override // com.baidu.wallet.personal.ui.fragment.base.CardListBaseFragment
    public void removeRequest() {
        BeanManager.getInstance().removeAllBeans("EemCardListFragment");
    }
}
