package com.baidu.wallet.personal.ui.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.eventbus.EventBus;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.CheckUtils;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.apollon.utils.support.ViewHelper;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.BaiduWalletDelegate;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.core.beans.BeanManager;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.e;
import com.baidu.wallet.paysdk.datamodel.ApplyCardEntrance;
import com.baidu.wallet.paysdk.datamodel.CardListResponse;
import com.baidu.wallet.paysdk.datamodel.SourceFlag;
import com.baidu.wallet.personal.storage.CardListCache;
import com.baidu.wallet.personal.ui.BankCardListActivity;
import com.baidu.wallet.personal.ui.fragment.base.CardListBaseFragment;
/* loaded from: classes6.dex */
public class BankCardListFragment extends CardListBaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public LinearLayout f27031a;

    /* renamed from: b  reason: collision with root package name */
    public View f27032b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f27033c;

    /* renamed from: d  reason: collision with root package name */
    public e f27034d;

    /* renamed from: e  reason: collision with root package name */
    public View f27035e;

    public BankCardListFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f27033c = false;
    }

    @Override // com.baidu.wallet.personal.ui.fragment.base.CardListBaseFragment
    public void bindCardData(boolean z) {
        CardListResponse.Card[] cardArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (cardArr = this.mCardListResponse.bind_card_arr) == null) {
            return;
        }
        this.mBankLayout.setData(true, cardArr, 0, z, this.mOnCardClickListener);
    }

    @Override // com.baidu.wallet.personal.ui.fragment.base.CardListBaseFragment
    public void bindCustomViewData() {
        CardListBaseFragment.a aVar;
        CardListResponse.User user;
        CardListBaseFragment.a aVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            boolean z = false;
            if (a() != null) {
                this.mCustomContainer.setVisibility(0);
                this.mCustomContainer.removeAllViews();
                this.mCustomContainer.addView(a());
            }
            CardListResponse.Misc misc = this.mCardListResponse.card_bind_misc_info;
            if (misc != null && "0".equals(misc.bank_card_detect_enabled) && (aVar2 = this.mCallback) != null) {
                aVar2.setBankCardDetectEnabled(true);
            }
            CardListResponse.Card[] cardArr = this.mCardListResponse.bind_card_arr;
            if ((cardArr == null || cardArr.length == 0) && (aVar = this.mCallback) != null) {
                aVar.setNoBankCardAndPwdFlag(true);
            }
            CardListResponse.Misc misc2 = this.mCardListResponse.card_bind_misc_info;
            if (misc2 != null) {
                this.f27033c = "1".equals(misc2.can_bind_card_flag);
                View view = this.f27032b;
                if (view != null) {
                    view.setVisibility(0);
                }
            }
            CardListResponse cardListResponse = this.mCardListResponse;
            if (cardListResponse != null && (user = cardListResponse.user) != null && !"1".equals(user.has_pwd)) {
                z = true;
            }
            CardListBaseFragment.a aVar3 = this.mCallback;
            if (aVar3 != null) {
                aVar3.showPwdLayout(z);
            }
            b();
        }
    }

    @Override // com.baidu.wallet.personal.ui.fragment.base.CardListBaseFragment
    public void getCacheData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            CardListCache.getInstance().getCardList(new CardListCache.b<CardListResponse>(this) { // from class: com.baidu.wallet.personal.ui.fragment.BankCardListFragment.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ BankCardListFragment f27037a;

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
                    this.f27037a = this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.wallet.personal.storage.CardListCache.b
                public void a(CardListResponse cardListResponse) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, cardListResponse) == null) {
                        this.f27037a.mActivity.runOnUiThread(new Runnable(this, cardListResponse) { // from class: com.baidu.wallet.personal.ui.fragment.BankCardListFragment.2.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ CardListResponse f27038a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass2 f27039b;

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
                                this.f27039b = this;
                                this.f27038a = cardListResponse;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    BankCardListFragment bankCardListFragment = this.f27039b.f27037a;
                                    CardListResponse cardListResponse2 = this.f27038a;
                                    bankCardListFragment.mCardListResponse = cardListResponse2;
                                    if (cardListResponse2 != null) {
                                        bankCardListFragment.mLoadFailedView.setVisibility(4);
                                        this.f27039b.f27037a.bindData(true);
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
    public void loadData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            removeRequest();
            if (this.f27034d == null) {
                this.f27034d = (e) PayBeanFactory.getInstance().getBean((Context) this.mActivity, PayBeanFactory.BEAN_ID_CARD_LIST, "BankCardListFragment");
            }
            this.f27034d.setResponseCallback(this);
            this.f27034d.a(SourceFlag.SDK);
            this.f27034d.execBean();
        }
    }

    @Override // com.baidu.wallet.personal.ui.fragment.base.CardListBaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        String string;
        CardListResponse.Misc misc;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            super.onClick(view);
            if (view == this.f27032b) {
                PayStatisticsUtil.onEventWithValue(StatServiceEvent.ADD_NEW_BANK_CARD, "addBankCard");
                if (this.f27033c) {
                    CardListBaseFragment.a aVar = this.mCallback;
                    if (aVar != null) {
                        aVar.bindCard();
                        return;
                    }
                    return;
                }
                CardListResponse cardListResponse = this.mCardListResponse;
                if (cardListResponse != null && (misc = cardListResponse.card_bind_misc_info) != null && !TextUtils.isEmpty(misc.bind_card_limit_msg)) {
                    string = this.mCardListResponse.card_bind_misc_info.bind_card_limit_msg;
                } else {
                    string = ResUtils.getString(this.mActivity, "bd_wallet_bind_card_number_overrun");
                }
                GlobalUtils.toast(this.mActivity, string);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            b();
        }
    }

    @Override // com.baidu.wallet.personal.ui.fragment.base.CardListBaseFragment, com.baidu.wallet.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onCreate(bundle);
            EventBus.getInstance().register(this, BankCardListActivity.EVENT_BANK_CARD_BIND_SUCCESS, 0, EventBus.ThreadMode.MainThread);
        }
    }

    @Override // com.baidu.wallet.personal.ui.fragment.base.CardListBaseFragment, com.baidu.wallet.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDestroy();
            EventBus.getInstance().unregister(this, BankCardListActivity.EVENT_BANK_CARD_BIND_SUCCESS);
            CardListCache.getInstance().getCardList(null);
        }
    }

    @Override // com.baidu.wallet.personal.ui.fragment.base.CardListBaseFragment
    public void onModuleEvent(EventBus.Event event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, event) == null) {
            super.onModuleEvent(event);
            if (event != null && BankCardListActivity.EVENT_BANK_CARD_BIND_SUCCESS.equals(event.mEventKey)) {
                syncData();
            }
        }
    }

    @Override // com.baidu.wallet.personal.ui.fragment.base.CardListBaseFragment
    public void removeRequest() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            BeanManager.getInstance().removeAllBeans("BankCardListFragment");
        }
    }

    private View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            if (this.f27035e == null) {
                View inflate = this.mInflater.inflate(ResUtils.layout(this.mActivity, "wallet_bank_card_list_fragment"), (ViewGroup) null);
                this.f27035e = inflate;
                this.f27031a = (LinearLayout) inflate.findViewById(ResUtils.id(this.mActivity, "wallet_my_bank_ll_credicard"));
                View findViewById = this.f27035e.findViewById(ResUtils.id(this.mActivity, "wallet_my_bank_card_btn"));
                this.f27032b = findViewById;
                findViewById.setOnClickListener(this);
                this.f27032b.setOnTouchListener(new View.OnTouchListener(this) { // from class: com.baidu.wallet.personal.ui.fragment.BankCardListFragment.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ BankCardListFragment f27036a;

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
                        this.f27036a = this;
                    }

                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        InterceptResult invokeLL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view, motionEvent)) == null) {
                            if (motionEvent.getAction() == 0 || motionEvent.getAction() == 2) {
                                ViewHelper.setAlpha(this.f27036a.f27032b, 0.5f);
                                return false;
                            }
                            ViewHelper.setAlpha(this.f27036a.f27032b, 1.0f);
                            return false;
                        }
                        return invokeLL.booleanValue;
                    }
                });
            }
            return this.f27035e;
        }
        return (View) invokeV.objValue;
    }

    private void b() {
        CardListResponse cardListResponse;
        ApplyCardEntrance[] applyCardEntranceArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, this) == null) || (cardListResponse = this.mCardListResponse) == null || (applyCardEntranceArr = cardListResponse.apply_card_entrance) == null) {
            return;
        }
        a(applyCardEntranceArr);
    }

    private void a(ApplyCardEntrance[] applyCardEntranceArr) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, applyCardEntranceArr) == null) {
            LinearLayout linearLayout2 = this.f27031a;
            if (linearLayout2 != null && linearLayout2.getChildCount() > 0) {
                this.f27031a.removeAllViews();
            }
            Activity activity = this.mActivity;
            if (activity == null || applyCardEntranceArr == null || applyCardEntranceArr.length <= 0) {
                return;
            }
            int dimension = (int) ResUtils.getDimension(activity, "wallet_base_15dp");
            int dimension2 = (int) ResUtils.getDimension(this.mActivity, "wallet_base_25dp");
            int displayWidth = DisplayUtils.getDisplayWidth(this.mActivity);
            boolean z = true;
            for (ApplyCardEntrance applyCardEntrance : applyCardEntranceArr) {
                if (applyCardEntrance != null) {
                    String str = applyCardEntrance.image;
                    String str2 = applyCardEntrance.jump_url;
                    float heightToWidthRatio = applyCardEntrance.getHeightToWidthRatio();
                    NetImageView a2 = a(str, str2);
                    a2.setAdjustViewBounds(true);
                    a2.setContentDescription(applyCardEntrance.desc + "");
                    LinearLayout.LayoutParams a3 = a(heightToWidthRatio, displayWidth, dimension, z ? dimension2 : dimension);
                    if (a2 != null && a3 != null && (linearLayout = this.f27031a) != null) {
                        linearLayout.addView(a2, a3);
                    }
                    z = false;
                }
            }
        }
    }

    private NetImageView a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65540, this, str, str2)) == null) {
            NetImageView netImageView = new NetImageView(this.mActivity);
            netImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            netImageView.setImageResource(ResUtils.drawable(this.mActivity, "wallet_personal_my_bank_credit_list_item_bg"));
            if (!TextUtils.isEmpty(str)) {
                netImageView.setImageUrl(str);
            }
            netImageView.setOnTouchListener(new View.OnTouchListener(this, netImageView) { // from class: com.baidu.wallet.personal.ui.fragment.BankCardListFragment.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ NetImageView f27040a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ BankCardListFragment f27041b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, netImageView};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f27041b = this;
                    this.f27040a = netImageView;
                }

                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    InterceptResult invokeLL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL2 = interceptable2.invokeLL(1048576, this, view, motionEvent)) == null) {
                        if (motionEvent.getAction() != 0 && motionEvent.getAction() != 2) {
                            ViewHelper.setAlpha(this.f27040a, 1.0f);
                            return false;
                        }
                        ViewHelper.setAlpha(this.f27040a, 0.5f);
                        return false;
                    }
                    return invokeLL2.booleanValue;
                }
            });
            netImageView.setOnClickListener(new View.OnClickListener(this, str2) { // from class: com.baidu.wallet.personal.ui.fragment.BankCardListFragment.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f27042a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ BankCardListFragment f27043b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f27043b = this;
                    this.f27042a = str2;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || CheckUtils.isFastDoubleClick()) {
                        return;
                    }
                    if (TextUtils.isEmpty(this.f27042a)) {
                        GlobalUtils.toast(this.f27043b.mActivity, ResUtils.getString(this.f27043b.mActivity, "bd_wallet_jump_url_error"));
                        return;
                    }
                    this.f27043b.mRefreshFlag = true;
                    BaiduWalletDelegate.getInstance().openH5Module(this.f27043b.mActivity, this.f27042a, true);
                }
            });
            return netImageView;
        }
        return (NetImageView) invokeLL.objValue;
    }

    private LinearLayout.LayoutParams a(float f2, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, this, new Object[]{Float.valueOf(f2), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            if (f2 > 0.0f) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, (int) ((i2 - (i3 * 2)) * f2));
                layoutParams.setMargins(0, i4, 0, 0);
                return layoutParams;
            }
            return null;
        }
        return (LinearLayout.LayoutParams) invokeCommon.objValue;
    }
}
