package com.baidu.wallet.paysdk.presenter;

import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.controllers.PasswordController;
import com.baidu.wallet.base.datamodel.Authorize;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.AuthorizeSignActivity;
import com.dxmpay.apollon.utils.CheckUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.statistics.StatServiceEvent;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.StatHelper;
/* loaded from: classes8.dex */
public class a implements View.OnClickListener, e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public AuthorizeSignActivity f62280a;

    /* renamed from: b  reason: collision with root package name */
    public int f62281b;

    public a(AuthorizeSignActivity authorizeSignActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {authorizeSignActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f62281b = 1;
        this.f62280a = authorizeSignActivity;
    }

    private void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            StatHelper.statServiceEvent(PayStatServiceEvent.PAY_BIND_CARD_ENTER);
            StatisticManager.onEventStart(PayStatServiceEvent.PAY_BIND_CARD_DURATION);
            if (PayDataCache.getInstance().hasMobilePwd()) {
                PasswordController.getPassWordInstance().checkPwd(this.f62280a.getActivity(), BeanConstants.FROM_BIND_PAY, new PasswordController.IPwdListener(this) { // from class: com.baidu.wallet.paysdk.presenter.a.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ a f62283a;

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
                        this.f62283a = this;
                    }

                    @Override // com.baidu.wallet.base.controllers.PasswordController.IPwdListener
                    public void onFail(int i2, String str) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                            PayRequestCache.getInstance().removeBeanRequestFromCache(BeanConstants.REQUEST_ID_PWD);
                        }
                    }

                    @Override // com.baidu.wallet.base.controllers.PasswordController.IPwdListener
                    public void onSucceed(String str) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                            PayRequestCache.getInstance().removeBeanRequestFromCache(BeanConstants.REQUEST_ID_PWD);
                            BaiduPay.getInstance().bindCardAuth(this.f62283a.f62280a.getActivity(), false);
                            StatHelper.statServiceEvent(StatServiceEvent.EVENT_AuthorizePay_ClickNext, null, StatServiceEvent.VALUE_AuthorizePay_ClickNext_NewCard);
                        }
                    }
                });
                return;
            }
            BaiduPay.getInstance().bindCardAuth(this.f62280a.getActivity(), false);
            StatHelper.statServiceEvent(StatServiceEvent.EVENT_AuthorizePay_ClickNext, null, StatServiceEvent.VALUE_AuthorizePay_ClickNext_NewCard);
        }
    }

    @Override // com.baidu.wallet.paysdk.presenter.e
    public void a() {
        AuthorizeSignActivity authorizeSignActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (authorizeSignActivity = this.f62280a) == null) {
            return;
        }
        authorizeSignActivity.initCardList();
        this.f62280a.setSelectCardListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.presenter.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f62282a;

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
                this.f62282a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    com.baidu.wallet.paysdk.a.b.a(this.f62282a.f62280a.getActivity(), null);
                }
            }
        });
        this.f62280a.initNextButton(this);
    }

    @Override // com.baidu.wallet.paysdk.presenter.e
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
        }
    }

    @Override // com.baidu.wallet.paysdk.presenter.e
    public void b() {
        AuthorizeSignActivity authorizeSignActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (authorizeSignActivity = this.f62280a) == null) {
            return;
        }
        authorizeSignActivity.updateProtocolFields();
        this.f62280a.updateNextButton();
        AuthorizeSignActivity authorizeSignActivity2 = this.f62280a;
        authorizeSignActivity2.updateSelBankInfo(authorizeSignActivity2.getPayRequest().mBondCard);
        DirectPayContentResponse payResponse = this.f62280a.getPayResponse();
        if (payResponse == null || payResponse.authorize == null || !f()) {
            return;
        }
        this.f62280a.updateHintText(payResponse.authorize.extra.fee_tip);
    }

    @Override // com.baidu.wallet.paysdk.presenter.e
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.presenter.e
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.presenter.e
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.presenter.e
    public boolean f() {
        InterceptResult invokeV;
        Authorize authorize;
        Authorize.Extra extra;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            DirectPayContentResponse payResponse = this.f62280a.getPayResponse();
            return (payResponse == null || (authorize = payResponse.authorize) == null || (extra = authorize.extra) == null || TextUtils.isEmpty(extra.fee_tip)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.presenter.e
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f62281b : invokeV.intValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view) == null) && this.f62280a != null && view.getId() == ResUtils.id(this.f62280a.getApplicationContext(), "sign_next_btn")) {
            PayRequest payRequest = this.f62280a.getPayRequest();
            CardData.BondCard selectedCard = this.f62280a.getSelectedCard();
            StatHelper.cacheHasPwd(PayDataCache.getInstance().hasMobilePwd());
            StatHelper.cacheHasBankCard(PayDataCache.getInstance().hasBondCards());
            StatHelper.cachePayType(0);
            StatHelper.cachePayWay(3);
            if (selectedCard == null) {
                h();
            } else if (selectedCard.isCompled()) {
                if (CheckUtils.isFastDoubleClick()) {
                    return;
                }
                if (payRequest != null) {
                    payRequest.mBondCard = selectedCard;
                }
                BaiduPay.getInstance().directAuth(this.f62280a.getActivity(), selectedCard);
                StatHelper.statServiceEvent(StatServiceEvent.EVENT_AuthorizePay_ClickNext, null, StatServiceEvent.VALUE_AuthorizePay_ClickNext_BoundCard);
                StatisticManager.onEventStart(PayStatServiceEvent.PAY_SMS_DURATION);
            } else {
                if (payRequest != null) {
                    payRequest.mBondCard = selectedCard;
                }
                a(selectedCard);
            }
        }
    }

    private void a(CardData.BondCard bondCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, bondCard) == null) {
            if (PayDataCache.getInstance().hasMobilePwd()) {
                PasswordController.getPassWordInstance().checkPwd(this.f62280a.getActivity(), BeanConstants.FROM_COMPLETE_PAY, new PasswordController.IPwdListener(this, bondCard) { // from class: com.baidu.wallet.paysdk.presenter.a.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ CardData.BondCard f62284a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ a f62285b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, bondCard};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f62285b = this;
                        this.f62284a = bondCard;
                    }

                    @Override // com.baidu.wallet.base.controllers.PasswordController.IPwdListener
                    public void onFail(int i2, String str) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                            PayRequestCache.getInstance().removeBeanRequestFromCache(BeanConstants.REQUEST_ID_PWD);
                        }
                    }

                    @Override // com.baidu.wallet.base.controllers.PasswordController.IPwdListener
                    public void onSucceed(String str) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                            PayRequestCache.getInstance().removeBeanRequestFromCache(BeanConstants.REQUEST_ID_PWD);
                            BaiduPay.getInstance().completeCardAuth(this.f62285b.f62280a.getActivity(), this.f62284a);
                            StatHelper.statServiceEvent(StatServiceEvent.EVENT_AuthorizePay_ClickNext, null, StatServiceEvent.VALUE_AuthorizePay_ClickNext_CompleteCard);
                        }
                    }
                });
                return;
            }
            BaiduPay.getInstance().completeCardAuth(this.f62280a.getActivity(), bondCard);
            StatHelper.statServiceEvent(StatServiceEvent.EVENT_AuthorizePay_ClickNext, null, StatServiceEvent.VALUE_AuthorizePay_ClickNext_CompleteCard);
        }
    }
}
