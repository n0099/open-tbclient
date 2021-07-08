package com.baidu.wallet.personal.ui.fragment;

import android.app.Activity;
import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public k f27154a;

    public EemCardListFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.wallet.personal.ui.fragment.base.CardListBaseFragment
    public void bindCardData(boolean z) {
        CardListResponse.Card[] cardArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (cardArr = this.mCardListResponse.bind_card_arr) == null) {
            return;
        }
        this.mBankLayout.setData(true, cardArr, 1, z, this.mOnCardClickListener);
    }

    @Override // com.baidu.wallet.personal.ui.fragment.base.CardListBaseFragment
    public void getCacheData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            CardListCache.getInstance().getEemCardList(new CardListCache.a<CardListResponse>(this) { // from class: com.baidu.wallet.personal.ui.fragment.EemCardListFragment.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ EemCardListFragment f27155a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f27155a = this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.wallet.personal.storage.CardListCache.a
                public void a(CardListResponse cardListResponse) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, cardListResponse) == null) {
                        this.f27155a.mActivity.runOnUiThread(new Runnable(this, cardListResponse) { // from class: com.baidu.wallet.personal.ui.fragment.EemCardListFragment.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ CardListResponse f27156a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass1 f27157b;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, cardListResponse};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f27157b = this;
                                this.f27156a = cardListResponse;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    EemCardListFragment eemCardListFragment = this.f27157b.f27155a;
                                    CardListResponse cardListResponse2 = this.f27156a;
                                    eemCardListFragment.mCardListResponse = cardListResponse2;
                                    if (cardListResponse2 != null) {
                                        eemCardListFragment.mLoadFailedView.setVisibility(8);
                                        this.f27157b.f27155a.bindData(true);
                                    }
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    @Override // com.baidu.wallet.personal.ui.fragment.base.CardListBaseFragment
    public void handleFailure(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, str) == null) {
            hideLoading();
            super.handleFailure(i2, i3, str);
        }
    }

    @Override // com.baidu.wallet.personal.ui.fragment.base.CardListBaseFragment
    public void handleResponse(int i2, Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048579, this, i2, obj, str) == null) {
            hideLoading();
            super.handleResponse(i2, obj, str);
            Activity activity = this.mActivity;
            if (activity != null) {
                a.c(activity, CardListBaseFragment.KEY_HAS_EEM_CARD_LIST_LOADED + CardListCache.getInstance().getUserIdV2(), Boolean.TRUE);
            }
        }
    }

    @Override // com.baidu.wallet.personal.ui.fragment.base.CardListBaseFragment
    public void loadData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            removeRequest();
            Activity activity = this.mActivity;
            if (!a.d(activity, CardListBaseFragment.KEY_HAS_EEM_CARD_LIST_LOADED + CardListCache.getInstance().getUserIdV2(), Boolean.FALSE)) {
                showLoading();
            }
            if (this.f27154a == null) {
                this.f27154a = (k) PayBeanFactory.getInstance().getBean((Context) getActivity(), 607, "EemCardListFragment");
            }
            this.f27154a.setResponseCallback(this);
            this.f27154a.a(SourceFlag.SDK);
            this.f27154a.execBean();
        }
    }

    @Override // com.baidu.wallet.personal.ui.fragment.base.CardListBaseFragment, com.baidu.wallet.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDestroy();
            CardListCache.getInstance().getEemCardList(null);
        }
    }

    @Override // com.baidu.wallet.personal.ui.fragment.base.CardListBaseFragment
    public void removeRequest() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            BeanManager.getInstance().removeAllBeans("EemCardListFragment");
        }
    }
}
