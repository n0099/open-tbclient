package com.baidu.wallet.base.controllers;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.android.pay.BindBack;
import com.baidu.android.pay.PayCallBack;
import com.baidu.apollon.utils.CheckUtils;
import com.baidu.apollon.utils.SharedPreferencesUtils;
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
    public static final int KEY_CHECK_PWD_COMPLETE_CARD = 0;
    public static final int KEY_CHECK_PWD_PAY = 1;
    public static final int SELECT_PAY_WAY_FROM_PWDPAY_ACT = 101;
    public static final int SELECT_PAY_WAY_FROM_SMS_ACT = 102;
    public static final int SELECT_PAY_WAY_FROM_WELCOME_ACT = 100;

    /* renamed from: a  reason: collision with root package name */
    public a f23599a;

    /* renamed from: b  reason: collision with root package name */
    public IModifyPayTypeCallback f23600b;

    /* renamed from: c  reason: collision with root package name */
    public PayCallBack f23601c;

    /* renamed from: d  reason: collision with root package name */
    public Context f23602d;

    /* loaded from: classes5.dex */
    public static final class PayResultWrapper implements Serializable {
        public int payResult;
        public PayResultContent payResultContent;
        public int payResultType;

        public PayResultWrapper(int i, int i2, PayResultContent payResultContent) {
            this.payResult = i;
            this.payResultType = i2;
            this.payResultContent = payResultContent;
        }
    }

    /* loaded from: classes5.dex */
    public interface a {
        void a();
    }

    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static PayController f23603a = new PayController();
    }

    private void a(Context context, Bundle bundle, Class<?> cls) {
        Intent intent = new Intent(context, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        context.startActivity(intent);
    }

    private void b(BaseActivity baseActivity, int i, int i2, PayResultContent payResultContent) {
        H5ResultParams h5ResultParams;
        if (payResultContent != null) {
            payResultContent.isPaySuccess = i == 0;
        }
        PayDataCache.getInstance().setPayReslutContent(payResultContent);
        if (payResultContent != null && payResultContent.isPaySuccess && (h5ResultParams = PayDataCache.getInstance().getH5ResultParams()) != null && h5ResultParams.toShowH5ResultPage()) {
            CashierDeskPayResult cashierDeskPayResult = new CashierDeskPayResult(baseActivity.getActivity(), h5ResultParams);
            cashierDeskPayResult.beforeShow();
            cashierDeskPayResult.show();
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt(BeanConstants.KEY_PAY_RESULT_TYPE, i2);
        baseActivity.startActivityWithExtras(bundle, WalletPayResultCommonActivity.class);
        PayBaseBeanActivity.exitEbpay();
    }

    public static PayController getInstance() {
        return b.f23603a;
    }

    public static BigDecimal priceToBigDecimal(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        return new BigDecimal(str).multiply(BigDecimal.valueOf(0.01d)).setScale(2);
    }

    public void bindCardPay(Context context, Intent intent, boolean z) {
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

    public void bindExtSuccess(BaseActivity baseActivity, Object obj) {
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

    public void bindFail(Context context, String str) {
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

    public void bindSuccess(Object obj) {
        StatisticManager.onEventWithValue(PayStatServiceEvent.INITIVATIVE_BIND_CARD_SUCCESS, StatHelper.getSessionId());
        BaiduPay.IBindCardCallback bindCallback = BaiduPay.getInstance().getBindCallback();
        BindCardResponse bindCardResponse = (BindCardResponse) obj;
        if (bindCallback != null) {
            bindCallback.onChangeSucceed((bindCardResponse == null || TextUtils.isEmpty(bindCardResponse.card_no)) ? null : bindCardResponse.card_no);
        }
        BaiduPay.getInstance().clearBindCallback();
        PayBaseBeanActivity.exitActiveBindCard();
    }

    public void clearPreModifiedCallBack() {
        if (this.f23600b != null) {
            this.f23600b = null;
        }
    }

    public void completeCardPay(Context context, CardData.BondCard bondCard) {
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

    public a getIConfirmPayCallback() {
        return this.f23599a;
    }

    public void gotoDiscountPage(BaseActivity baseActivity) {
        Intent intent = new Intent();
        intent.setClass(baseActivity, CouponListActivity.class);
        baseActivity.startActivity(intent);
    }

    public void gotoOrderConfirm(BaseActivity baseActivity, Intent intent) {
        a(baseActivity, intent != null ? intent.getExtras() : new Bundle(), OrderConfirmActivity.class);
        baseActivity.finishWithoutAnim();
    }

    public void gotoPayTypePage(Context context, boolean z) {
        StatisticManager.onEvent(StatServiceEvent.EVENT_CLICK_OTHER_PAY_TYPE);
        Intent intent = new Intent();
        intent.putExtra("isGatewaySignPay", z);
        intent.setClass(context, PayTypeActivity.class);
        if (!BaiduWalletUtils.isActivity(context)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    public void gotoPwdPay(BaseActivity baseActivity) {
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

    public void gotoWithholdPay(BaseActivity baseActivity) {
        baseActivity.startActivity(new Intent(baseActivity, WithholdPayActivity.class));
    }

    public void modifyPayType(Context context, PrecashierModifyPayTypeManager.TwoTupleForPrecashier<Boolean, PrecashierModifyPayTypeDefaultData> twoTupleForPrecashier) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setClass(context, PayTypeActivity.class);
        if (!BaiduWalletUtils.isActivity(context)) {
            intent.addFlags(268435456);
        }
        intent.putExtra(PreCashierPayTypePresenter.DEFAULT_PAY_DATA, twoTupleForPrecashier);
        context.startActivity(intent);
    }

    public void onConfirmPay() {
        a aVar = this.f23599a;
        if (aVar != null) {
            aVar.a();
            this.f23599a = null;
        }
    }

    public void onPreModifiedPayType(PrecashierModifyPayTypeDefaultData precashierModifyPayTypeDefaultData) {
        IModifyPayTypeCallback iModifyPayTypeCallback = this.f23600b;
        if (iModifyPayTypeCallback == null) {
            return;
        }
        iModifyPayTypeCallback.onPayTypeModified(precashierModifyPayTypeDefaultData);
        this.f23600b = null;
    }

    public void onPrePayMethodSetted() {
        IModifyPayTypeCallback iModifyPayTypeCallback = this.f23600b;
        if (iModifyPayTypeCallback == null) {
            return;
        }
        iModifyPayTypeCallback.onPayTypeSetted();
        this.f23600b = null;
    }

    public void payPaying(BaseActivity baseActivity, PayResultContent payResultContent, int i) {
        WalletGlobalUtils.safeDismissDialog(baseActivity, 0);
        a(baseActivity, 1, i, payResultContent);
    }

    public void paySucess(BaseActivity baseActivity, PayResultContent payResultContent, int i) {
        StatisticManager.onEventEnd(StatServiceEvent.TIME_PAY, 0);
        a(baseActivity, 0, i, payResultContent);
    }

    public void selectCompletCards(Context context, Intent intent) {
        if (context == null || intent == null) {
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
        this.f23601c = payCallBack;
        this.f23602d = context;
    }

    public void setModifyPayTypeCallback(IModifyPayTypeCallback iModifyPayTypeCallback) {
        this.f23600b = iModifyPayTypeCallback;
    }

    public void startPaySettingActivity(Context context, PaySettingActivity.a aVar) {
        if (CheckUtils.isFastDoubleClick()) {
            return;
        }
        Intent intent = new Intent(context, PaySettingActivity.class);
        PaySettingActivity.setPaySettingChangeListener(aVar);
        context.startActivity(intent);
    }

    public void startPaySortActivity(Context context, PaySortSettingActivity.a aVar) {
        Intent intent = new Intent(context, PaySortSettingActivity.class);
        PaySortSettingActivity.setOnModifyPaySortListener(aVar);
        context.startActivity(intent);
    }

    public void updateCardInfoPay(Context context, ErrorContentResponse errorContentResponse) {
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

    public PayController() {
        this.f23601c = null;
        this.f23602d = null;
    }

    private void a(BaseActivity baseActivity, Bundle bundle, Class<?> cls) {
        Intent intent = new Intent(baseActivity, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        baseActivity.startActivityWithoutAnim(intent);
    }

    private void a(BaseActivity baseActivity, int i, int i2, PayResultContent payResultContent) {
        PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
        boolean z = false;
        if ((payResultContent == null || !"0".equalsIgnoreCase(payResultContent.redirect_sp_succpage_remain_time)) && payRequest != null && payRequest.FP_Guide_Strategy > 0 && !payRequest.supportFingerprintPay) {
            z = true;
        }
        if (z) {
            int intValue = ((Integer) SharedPreferencesUtils.getParam(baseActivity, FpConstancts.SHAREPREFRENCE_FOR_FINGERPRINT, "resultPageShowFpCounts", 3)).intValue();
            if (intValue <= 0) {
                b(baseActivity, i, i2, payResultContent);
                return;
            }
            SharedPreferencesUtils.setParam(baseActivity, FpConstancts.SHAREPREFRENCE_FOR_FINGERPRINT, "resultPageShowFpCounts", Integer.valueOf(intValue - 1));
            Intent intent = new Intent(baseActivity, FingerprintOpenGuideActivity.class);
            intent.putExtra("payresultwrapper", new PayResultWrapper(i, i2, payResultContent));
            baseActivity.startActivity(intent);
            return;
        }
        b(baseActivity, i, i2, payResultContent);
    }

    public void completeCardPay(Context context, CardData.BondCard bondCard, GetCardInfoResponse getCardInfoResponse) {
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
