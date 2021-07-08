package com.baidu.wallet.base.controllers;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.asm.Label;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pay.BindBack;
import com.baidu.android.pay.PayCallBack;
import com.baidu.apollon.utils.CheckUtils;
import com.baidu.apollon.utils.SharedPreferencesUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.core.BaseActivity;
import com.baidu.wallet.core.utils.BaiduWalletUtils;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.b.i;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.datamodel.BindCardResponse;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.ErrorContentResponse;
import com.baidu.wallet.paysdk.datamodel.GetCardInfoResponse;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.fingerprint.FpConstancts;
import com.baidu.wallet.paysdk.fingerprint.ui.FingerprintOpenGuideActivity;
import com.baidu.wallet.paysdk.payresult.datamodel.H5ResultParams;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import com.baidu.wallet.paysdk.payresult.presenter.CashierDeskPayResult;
import com.baidu.wallet.paysdk.payresult.view.WalletPayResultCommonActivity;
import com.baidu.wallet.paysdk.precashier.IModifyPayTypeCallback;
import com.baidu.wallet.paysdk.precashier.PrecashierModifyPayTypeDefaultData;
import com.baidu.wallet.paysdk.precashier.PrecashierModifyPayTypeManager;
import com.baidu.wallet.paysdk.presenter.PreCashierPayTypePresenter;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.BindCardBaseActivity;
import com.baidu.wallet.paysdk.ui.BindCardImplActivity;
import com.baidu.wallet.paysdk.ui.CouponListActivity;
import com.baidu.wallet.paysdk.ui.OrderConfirmActivity;
import com.baidu.wallet.paysdk.ui.PayBaseBeanActivity;
import com.baidu.wallet.paysdk.ui.PaySettingActivity;
import com.baidu.wallet.paysdk.ui.PaySortSettingActivity;
import com.baidu.wallet.paysdk.ui.PayTypeActivity;
import com.baidu.wallet.paysdk.ui.PwdPayActivity;
import com.baidu.wallet.paysdk.ui.SelectBindCardActivity;
import com.baidu.wallet.paysdk.ui.WithholdPayActivity;
import com.baidu.wallet.statistics.api.StatisticManager;
import com.baidu.wallet.util.StatHelper;
import java.io.Serializable;
import java.math.BigDecimal;
/* loaded from: classes5.dex */
public final class PayController {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int KEY_CHECK_PWD_COMPLETE_CARD = 0;
    public static final int KEY_CHECK_PWD_PAY = 1;
    public static final int SELECT_PAY_WAY_FROM_PWDPAY_ACT = 101;
    public static final int SELECT_PAY_WAY_FROM_SMS_ACT = 102;
    public static final int SELECT_PAY_WAY_FROM_WELCOME_ACT = 100;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public a f24022a;

    /* renamed from: b  reason: collision with root package name */
    public IModifyPayTypeCallback f24023b;

    /* renamed from: c  reason: collision with root package name */
    public PayCallBack f24024c;

    /* renamed from: d  reason: collision with root package name */
    public Context f24025d;

    /* renamed from: com.baidu.wallet.base.controllers.PayController$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public static final class PayResultWrapper implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int payResult;
        public PayResultContent payResultContent;
        public int payResultType;

        public PayResultWrapper(int i2, int i3, PayResultContent payResultContent) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), payResultContent};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.payResult = i2;
            this.payResultType = i3;
            this.payResultContent = payResultContent;
        }
    }

    /* loaded from: classes5.dex */
    public interface a {
        void a();
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static PayController f24026a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1931929561, "Lcom/baidu/wallet/base/controllers/PayController$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1931929561, "Lcom/baidu/wallet/base/controllers/PayController$b;");
                    return;
                }
            }
            f24026a = new PayController(null);
        }
    }

    public /* synthetic */ PayController(AnonymousClass1 anonymousClass1) {
        this();
    }

    private void a(Context context, Bundle bundle, Class<?> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, this, context, bundle, cls) == null) {
            Intent intent = new Intent(context, cls);
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            context.startActivity(intent);
        }
    }

    private void b(BaseActivity baseActivity, int i2, int i3, PayResultContent payResultContent) {
        H5ResultParams h5ResultParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, this, new Object[]{baseActivity, Integer.valueOf(i2), Integer.valueOf(i3), payResultContent}) == null) {
            if (payResultContent != null) {
                payResultContent.isPaySuccess = i2 == 0;
            }
            PayDataCache.getInstance().setPayReslutContent(payResultContent);
            if (payResultContent != null && payResultContent.isPaySuccess && (h5ResultParams = PayDataCache.getInstance().getH5ResultParams()) != null && h5ResultParams.toShowH5ResultPage()) {
                CashierDeskPayResult cashierDeskPayResult = new CashierDeskPayResult(baseActivity.getActivity(), h5ResultParams);
                cashierDeskPayResult.beforeShow();
                cashierDeskPayResult.show();
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putInt(BeanConstants.KEY_PAY_RESULT_TYPE, i3);
            baseActivity.startActivityWithExtras(bundle, WalletPayResultCommonActivity.class);
            PayBaseBeanActivity.exitEbpay();
        }
    }

    public static PayController getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? b.f24026a : (PayController) invokeV.objValue;
    }

    public static BigDecimal priceToBigDecimal(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            return new BigDecimal(str).multiply(BigDecimal.valueOf(0.01d)).setScale(2);
        }
        return (BigDecimal) invokeL.objValue;
    }

    public void bindCardPay(Context context, Intent intent, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048576, this, context, intent, z) == null) {
            StatisticManager.onEventWithValue(PayStatServiceEvent.PAY_BIND_CARD_ENTER, StatHelper.getOrderNo());
            StatHelper.cachePayType(0);
            StatHelper.cachePayWay(4);
            Bundle extras = intent != null ? intent.getExtras() : new Bundle();
            if (extras == null) {
                extras = new Bundle();
            }
            extras.putBoolean(BindFastRequest.BIND_IS_FIRST, z);
            BindFastRequest bindFastRequest = new BindFastRequest();
            bindFastRequest.mBindFrom = 0;
            PayRequestCache.getInstance().addBeanRequestToCache(bindFastRequest.getRequestId(), bindFastRequest);
            a(context, extras, BindCardImplActivity.class);
            if (z && (context instanceof BaseActivity)) {
                ((BaseActivity) context).finishWithoutAnim();
            }
        }
    }

    public void bindExtSuccess(BaseActivity baseActivity, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, baseActivity, obj) == null) {
            StatisticManager.onEventWithValue(PayStatServiceEvent.INITIVATIVE_BIND_CARD_SUCCESS, StatHelper.getSessionId());
            BindCardResponse bindCardResponse = (BindCardResponse) obj;
            PayResultContent payResultContent = new PayResultContent();
            payResultContent.notify = bindCardResponse.notify;
            payResultContent.cash_amount = "";
            payResultContent.total_amount = "";
            payResultContent.pay_detail_info = bindCardResponse.activity_desc;
            payResultContent.isPaySuccess = true;
            WalletGlobalUtils.safeDismissDialog(baseActivity, 0);
            PayBaseBeanActivity.exitActiveBindCard();
            PayDataCache.getInstance().setPayReslutContent(payResultContent);
            paySucess(baseActivity, payResultContent, 1);
        }
    }

    public void bindFail(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, str) == null) {
            BaiduPay.IBindCardCallback bindCallback = BaiduPay.getInstance().getBindCallback();
            BindBack bindCallbackExt = BaiduPay.getInstance().getBindCallbackExt();
            if (bindCallback != null) {
                bindCallback.onChangeFailed(str);
            } else if (bindCallbackExt != null) {
                StatisticManager.onEvent(StatServiceEvent.EVENT_API_ONPAYRESULT);
                bindCallbackExt.onBindResult(2, new PayCallBackManager.PayStateModle(2, "").toString());
                PayRequestCache.getInstance().clearPaySdkRequestCache();
            }
            BaiduPay.getInstance().clearBindCallback();
            BaiduPay.getInstance().clearBindCallbackExt();
        }
    }

    public void bindSuccess(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, obj) == null) {
            StatisticManager.onEventWithValue(PayStatServiceEvent.INITIVATIVE_BIND_CARD_SUCCESS, StatHelper.getSessionId());
            BaiduPay.IBindCardCallback bindCallback = BaiduPay.getInstance().getBindCallback();
            BindCardResponse bindCardResponse = (BindCardResponse) obj;
            if (bindCallback != null) {
                bindCallback.onChangeSucceed((bindCardResponse == null || TextUtils.isEmpty(bindCardResponse.card_no)) ? null : bindCardResponse.card_no);
            }
            BaiduPay.getInstance().clearBindCallback();
            PayBaseBeanActivity.exitActiveBindCard();
        }
    }

    public void clearPreModifiedCallBack() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f24023b == null) {
            return;
        }
        this.f24023b = null;
    }

    public void completeCardPay(Context context, CardData.BondCard bondCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, context, bondCard) == null) {
            BindFastRequest bindFastRequest = new BindFastRequest();
            bindFastRequest.mBindFrom = 2;
            bindFastRequest.mBondCard = bondCard;
            PayRequestCache.getInstance().addBeanRequestToCache(bindFastRequest.getRequestId(), bindFastRequest);
            Intent intent = new Intent(context, BindCardImplActivity.class);
            int a2 = i.a().a(context, bondCard, false);
            if (a2 > 0 && 2 >= a2) {
                intent.putExtra("halfScreen", a2);
            }
            intent.putExtra("reasonForChangeCardItem", 1);
            context.startActivity(intent);
        }
    }

    public a getIConfirmPayCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f24022a : (a) invokeV.objValue;
    }

    public void gotoDiscountPage(BaseActivity baseActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, baseActivity) == null) {
            Intent intent = new Intent();
            intent.setClass(baseActivity, CouponListActivity.class);
            baseActivity.startActivity(intent);
        }
    }

    public void gotoOrderConfirm(BaseActivity baseActivity, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, baseActivity, intent) == null) {
            a(baseActivity, intent != null ? intent.getExtras() : new Bundle(), OrderConfirmActivity.class);
            baseActivity.finishWithoutAnim();
        }
    }

    public void gotoPayTypePage(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048586, this, context, z) == null) {
            StatisticManager.onEvent(StatServiceEvent.EVENT_CLICK_OTHER_PAY_TYPE);
            Intent intent = new Intent();
            intent.putExtra("isGatewaySignPay", z);
            intent.setClass(context, PayTypeActivity.class);
            if (!BaiduWalletUtils.isActivity(context)) {
                intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            }
            context.startActivity(intent);
        }
    }

    public void gotoPwdPay(BaseActivity baseActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, baseActivity) == null) {
            Intent intent = new Intent(baseActivity, PwdPayActivity.class);
            if (PayDataCache.getInstance().hasBondCards()) {
                StatHelper.cachePayWay(0);
                intent.putExtra("IS_FOR_BIND_CARD_PAY", false);
            } else {
                StatHelper.cachePayType(0);
                StatHelper.cachePayWay(4);
                intent.putExtra("IS_FOR_BIND_CARD_PAY", true);
            }
            baseActivity.startActivity(intent);
        }
    }

    public void gotoWithholdPay(BaseActivity baseActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, baseActivity) == null) {
            baseActivity.startActivity(new Intent(baseActivity, WithholdPayActivity.class));
        }
    }

    public void modifyPayType(Context context, PrecashierModifyPayTypeManager.TwoTupleForPrecashier<Boolean, PrecashierModifyPayTypeDefaultData> twoTupleForPrecashier) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, context, twoTupleForPrecashier) == null) || context == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setClass(context, PayTypeActivity.class);
        if (!BaiduWalletUtils.isActivity(context)) {
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        }
        intent.putExtra(PreCashierPayTypePresenter.DEFAULT_PAY_DATA, twoTupleForPrecashier);
        context.startActivity(intent);
    }

    public void onConfirmPay() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (aVar = this.f24022a) == null) {
            return;
        }
        aVar.a();
        this.f24022a = null;
    }

    public void onPreModifiedPayType(PrecashierModifyPayTypeDefaultData precashierModifyPayTypeDefaultData) {
        IModifyPayTypeCallback iModifyPayTypeCallback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, precashierModifyPayTypeDefaultData) == null) || (iModifyPayTypeCallback = this.f24023b) == null) {
            return;
        }
        iModifyPayTypeCallback.onPayTypeModified(precashierModifyPayTypeDefaultData);
        this.f24023b = null;
    }

    public void onPrePayMethodSetted() {
        IModifyPayTypeCallback iModifyPayTypeCallback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (iModifyPayTypeCallback = this.f24023b) == null) {
            return;
        }
        iModifyPayTypeCallback.onPayTypeSetted();
        this.f24023b = null;
    }

    public void payPaying(BaseActivity baseActivity, PayResultContent payResultContent, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048593, this, baseActivity, payResultContent, i2) == null) {
            WalletGlobalUtils.safeDismissDialog(baseActivity, 0);
            a(baseActivity, 1, i2, payResultContent);
        }
    }

    public void paySucess(BaseActivity baseActivity, PayResultContent payResultContent, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048594, this, baseActivity, payResultContent, i2) == null) {
            StatisticManager.onEventEnd(StatServiceEvent.TIME_PAY, 0);
            a(baseActivity, 0, i2, payResultContent);
        }
    }

    public void selectCompletCards(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048595, this, context, intent) == null) || context == null || intent == null) {
            return;
        }
        Bundle extras = intent.getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        extras.putBoolean(BindFastRequest.BIND_IS_FIRST, true);
        BindFastRequest bindFastRequest = (BindFastRequest) PayRequestCache.getInstance().getBeanRequestFromCache(PayRequestCache.BindCategory.Other.name());
        if (bindFastRequest == null) {
            bindFastRequest = new BindFastRequest();
        }
        bindFastRequest.mBindFrom = 2;
        PayRequestCache.getInstance().addBeanRequestToCache(bindFastRequest.getRequestId(), bindFastRequest);
        a(context, extras, SelectBindCardActivity.class);
        if (context instanceof BaseActivity) {
            ((BaseActivity) context).finishWithoutAnim();
        }
    }

    public void setMiniPayCallback(PayCallBack payCallBack, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, payCallBack, context) == null) {
            this.f24024c = payCallBack;
            this.f24025d = context;
        }
    }

    public void setModifyPayTypeCallback(IModifyPayTypeCallback iModifyPayTypeCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, iModifyPayTypeCallback) == null) {
            this.f24023b = iModifyPayTypeCallback;
        }
    }

    public void startPaySettingActivity(Context context, PaySettingActivity.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048598, this, context, aVar) == null) || CheckUtils.isFastDoubleClick()) {
            return;
        }
        Intent intent = new Intent(context, PaySettingActivity.class);
        PaySettingActivity.setPaySettingChangeListener(aVar);
        context.startActivity(intent);
    }

    public void startPaySortActivity(Context context, PaySortSettingActivity.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, context, aVar) == null) {
            Intent intent = new Intent(context, PaySortSettingActivity.class);
            PaySortSettingActivity.setOnModifyPaySortListener(aVar);
            context.startActivity(intent);
        }
    }

    public void updateCardInfoPay(Context context, ErrorContentResponse errorContentResponse) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048600, this, context, errorContentResponse) == null) {
            BindFastRequest bindFastRequest = (BindFastRequest) PayRequestCache.getInstance().getBeanRequestFromCache(PayRequestCache.BindCategory.Other.name());
            PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
            if (bindFastRequest == null) {
                bindFastRequest = new BindFastRequest();
                bindFastRequest.mBindFrom = 2;
                PayRequestCache.getInstance().addBeanRequestToCache(bindFastRequest.getRequestId(), bindFastRequest);
            } else if (bindFastRequest.mBindFrom == 8) {
                bindFastRequest.mBindFrom = 7;
            }
            bindFastRequest.mBondCard = payRequest.mBondCard;
            bindFastRequest.mCardInfoUpdateContent = errorContentResponse;
            if (context instanceof BindCardBaseActivity) {
                ((BindCardBaseActivity) context).loadCvv2();
                return;
            }
            Intent intent = new Intent(context, BindCardImplActivity.class);
            int a2 = i.a().a(context, errorContentResponse);
            if (a2 > 0 && 2 >= a2) {
                intent.putExtra("halfScreen", a2);
            }
            intent.putExtra("reasonForChangeCardItem", 2);
            if (context instanceof BaseActivity) {
                ((BaseActivity) context).finish();
            }
            context.startActivity(intent);
        }
    }

    public PayController() {
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
        this.f24024c = null;
        this.f24025d = null;
    }

    private void a(BaseActivity baseActivity, Bundle bundle, Class<?> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, this, baseActivity, bundle, cls) == null) {
            Intent intent = new Intent(baseActivity, cls);
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            baseActivity.startActivityWithoutAnim(intent);
        }
    }

    private void a(BaseActivity baseActivity, int i2, int i3, PayResultContent payResultContent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{baseActivity, Integer.valueOf(i2), Integer.valueOf(i3), payResultContent}) == null) {
            PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
            boolean z = false;
            if ((payResultContent == null || !"0".equalsIgnoreCase(payResultContent.redirect_sp_succpage_remain_time)) && payRequest != null && payRequest.FP_Guide_Strategy > 0 && !payRequest.supportFingerprintPay) {
                z = true;
            }
            if (z) {
                int intValue = ((Integer) SharedPreferencesUtils.getParam(baseActivity, FpConstancts.SHAREPREFRENCE_FOR_FINGERPRINT, "resultPageShowFpCounts", 3)).intValue();
                if (intValue <= 0) {
                    b(baseActivity, i2, i3, payResultContent);
                    return;
                }
                SharedPreferencesUtils.setParam(baseActivity, FpConstancts.SHAREPREFRENCE_FOR_FINGERPRINT, "resultPageShowFpCounts", Integer.valueOf(intValue - 1));
                Intent intent = new Intent(baseActivity, FingerprintOpenGuideActivity.class);
                intent.putExtra("payresultwrapper", new PayResultWrapper(i2, i3, payResultContent));
                baseActivity.startActivity(intent);
                return;
            }
            b(baseActivity, i2, i3, payResultContent);
        }
    }

    public void completeCardPay(Context context, CardData.BondCard bondCard, GetCardInfoResponse getCardInfoResponse) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, context, bondCard, getCardInfoResponse) == null) {
            BindFastRequest bindFastRequest = (BindFastRequest) PayRequestCache.getInstance().getBeanRequestFromCache(PayRequestCache.BindCategory.Other.name());
            if (bindFastRequest == null) {
                bindFastRequest = new BindFastRequest();
            }
            bindFastRequest.mBondCard = bondCard;
            bindFastRequest.setBindFromOrigin(bindFastRequest.mBindFrom);
            bindFastRequest.mBindFrom = 9;
            bindFastRequest.setmBankInfo(getCardInfoResponse);
            PayRequestCache.getInstance().addBeanRequestToCache(bindFastRequest.getRequestId(), bindFastRequest);
            Intent intent = new Intent(context, BindCardImplActivity.class);
            intent.putExtra("reasonForChangeCardItem", 1);
            context.startActivity(intent);
        }
    }
}
