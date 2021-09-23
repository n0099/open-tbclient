package com.baidu.wallet.paysdk.presenter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.BaiduPayDelegate;
import com.baidu.wallet.base.controllers.PayController;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.w;
import com.baidu.wallet.paysdk.contract.PwdPayContract;
import com.baidu.wallet.paysdk.datamodel.AuthorizeInfo;
import com.baidu.wallet.paysdk.datamodel.BalancePayResponse;
import com.baidu.wallet.paysdk.datamodel.ErrorContentResponse;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.datamodel.PwdRequest;
import com.baidu.wallet.paysdk.fingerprint.SysFingerprintPay;
import com.baidu.wallet.paysdk.payresult.datamodel.H5ResultParams;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import com.baidu.wallet.paysdk.payresult.presenter.CashierDeskPayResult;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.PwdPayActivity;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.datamodel.UserData;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.StatHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class PwdPayPresenterForCashdesk extends PwdPayContract.Presenter implements PwdPayContract.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean checkPass;
    public CheckForWhat mCheckForWhat;
    public boolean mIsForBindCardPay;
    public PayRequest mPayRequest;
    public String otpToken;
    public String pwdword;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes8.dex */
    public static final class CheckForWhat {
        public static final /* synthetic */ CheckForWhat[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final CheckForWhat FOR_BIND_CARD_PAY;
        public static final CheckForWhat FOR_COMPLETE_PAY;
        public static final CheckForWhat FOR_ONEKEYPAY;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(343266310, "Lcom/baidu/wallet/paysdk/presenter/PwdPayPresenterForCashdesk$CheckForWhat;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(343266310, "Lcom/baidu/wallet/paysdk/presenter/PwdPayPresenterForCashdesk$CheckForWhat;");
                    return;
                }
            }
            FOR_ONEKEYPAY = new CheckForWhat("FOR_ONEKEYPAY", 0);
            FOR_BIND_CARD_PAY = new CheckForWhat("FOR_BIND_CARD_PAY", 1);
            CheckForWhat checkForWhat = new CheckForWhat("FOR_COMPLETE_PAY", 2);
            FOR_COMPLETE_PAY = checkForWhat;
            $VALUES = new CheckForWhat[]{FOR_ONEKEYPAY, FOR_BIND_CARD_PAY, checkForWhat};
        }

        public CheckForWhat(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static CheckForWhat valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (CheckForWhat) Enum.valueOf(CheckForWhat.class, str) : (CheckForWhat) invokeL.objValue;
        }

        public static CheckForWhat[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (CheckForWhat[]) $VALUES.clone() : (CheckForWhat[]) invokeV.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PwdPayPresenterForCashdesk(PwdPayActivity pwdPayActivity, Intent intent) {
        super(pwdPayActivity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pwdPayActivity, intent};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((PwdPayActivity) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.checkPass = false;
        this.mCheckForWhat = CheckForWhat.FOR_ONEKEYPAY;
        if (intent != null) {
            this.mIsForBindCardPay = intent.getBooleanExtra("IS_FOR_BIND_CARD_PAY", false);
            this.otpToken = intent.getStringExtra("otpToken");
            String stringExtra = intent.getStringExtra("warningTips");
            if (TextUtils.isEmpty(stringExtra)) {
                return;
            }
            this.mActivity.showWarningTips(stringExtra);
        }
    }

    private boolean isPwdOnekeypay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) ? this.mCheckForWhat == CheckForWhat.FOR_ONEKEYPAY && this.mPayRequest.getPayWay() == 3 : invokeV.booleanValue;
    }

    private void refreshPara() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            PayRequest.PayPrice payPrice = this.mPayRequest.getPayPrice();
            if (payPrice == null) {
                PwdPayActivity pwdPayActivity = this.mActivity;
                PayCallBackManager.callBackClientCancel(pwdPayActivity, this.TAG + "initView().1");
                return;
            }
            if (this.mIsForBindCardPay) {
                this.mCheckForWhat = CheckForWhat.FOR_BIND_CARD_PAY;
                PwdPayActivity pwdPayActivity2 = this.mActivity;
                pwdPayActivity2.setTitleText(ResUtils.getString(pwdPayActivity2, "ebpay_please_input_pwd2"));
            } else {
                PayRequest.PayPrice.PayType payType = payPrice.payType;
                if (payType == PayRequest.PayPrice.PayType.BANKCARD) {
                    CardData.BondCard bondCard = this.mPayRequest.mBondCard;
                    if (bondCard == null) {
                        this.mCheckForWhat = CheckForWhat.FOR_BIND_CARD_PAY;
                    } else if (!bondCard.isCompled()) {
                        this.mCheckForWhat = CheckForWhat.FOR_COMPLETE_PAY;
                    } else {
                        this.mCheckForWhat = CheckForWhat.FOR_ONEKEYPAY;
                    }
                } else if (payType == PayRequest.PayPrice.PayType.BALANCE) {
                    this.mCheckForWhat = CheckForWhat.FOR_ONEKEYPAY;
                } else if (payType == PayRequest.PayPrice.PayType.CREIDT) {
                    this.mCheckForWhat = CheckForWhat.FOR_ONEKEYPAY;
                }
            }
            if (PayDataCache.getInstance().isFromPreCashier()) {
                if (this.mCheckForWhat == CheckForWhat.FOR_ONEKEYPAY) {
                    if (isFingerprintPay()) {
                        this.mActivity.showLikeLoadingPage(true);
                        this.mActivity.doVerifyFingerprint(this.mPayRequest.mFingerprintPay);
                    } else if (PayDataCache.getInstance().isPassFree()) {
                        this.mActivity.showLikeLoadingPage(true);
                        this.mActivity.setErrorArea(false);
                        PayRequest payRequest = this.mPayRequest;
                        if (payRequest != null) {
                            payRequest.setPayWay(1);
                        }
                        doPay();
                    }
                } else {
                    this.mActivity.setErrorArea(true);
                    this.mActivity.showLikeLoadingPage(false);
                }
            } else if (this.mCheckForWhat == CheckForWhat.FOR_ONEKEYPAY) {
                if (isFingerprintPay()) {
                    if (!TextUtils.isEmpty(this.otpToken)) {
                        onFPCheckOK(this.otpToken);
                    } else {
                        this.mActivity.doVerifyFingerprint(this.mPayRequest.mFingerprintPay);
                    }
                } else if (PayDataCache.getInstance().isPassFree()) {
                    this.mActivity.setErrorArea(false);
                    PayRequest payRequest2 = this.mPayRequest;
                    if (payRequest2 != null) {
                        payRequest2.setPayWay(1);
                    }
                    doPay();
                }
            } else {
                this.mActivity.setErrorArea(true);
            }
            if (this.mPayRequest.supportFingerprintPay && isPwdOnekeypay()) {
                this.mActivity.rightTextShow(true, "指纹支付");
            } else if (isFingerprintPay()) {
                this.mActivity.rightTextShow(true, "密码支付");
            } else {
                this.mActivity.rightTextShow(false, null);
            }
        }
    }

    private void statPaySuccess(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65539, this, i2) == null) {
            StatHelper.cachePayType(i2);
            if (PayDataCache.getInstance().isFromPreCashier()) {
                StatHelper.statServiceEvent(PayStatServiceEvent.PERCASHIER_PAY);
                StatHelper.statServiceEvent(PayStatServiceEvent.PERCASHIER_PAY_SUCCESS);
                return;
            }
            StatHelper.statServiceEvent(PayStatServiceEvent.STD_PAY);
            StatHelper.statServiceEvent(PayStatServiceEvent.STD_PAY_SUCCESS);
        }
    }

    @Override // com.baidu.wallet.paysdk.contract.PwdPayContract.Presenter
    public boolean dialogNevigateOper_QuitCashDesk() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (PayDataCache.getInstance().isPassFree() || isFingerprintPay()) && PayDataCache.getInstance().isFromPreCashier() : invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.contract.PwdPayContract.Presenter
    public boolean dialogNevigateOper_QuitCurrentPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (PayDataCache.getInstance().isPassFree() || isFingerprintPay()) && !PayDataCache.getInstance().isFromPreCashier() : invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.contract.PwdPayContract.Presenter
    public boolean directQuit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (PayDataCache.getInstance().isFromPreCashier()) {
                WalletGlobalUtils.safeShowDialog(this.mActivity, 18, "");
                return false;
            } else if (isGatewaySignPay()) {
                BaiduPayDelegate.getInstance().reOrderPay(this.mActivity);
                return false;
            } else {
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    public void doPay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            PwdRequest pwdRequest = new PwdRequest();
            int i2 = 2;
            if (PayDataCache.getInstance().isPassFree()) {
                pwdRequest.mPayPass = null;
            } else {
                pwdRequest.mPayPass = this.pwdword;
                PayRequest payRequest = this.mPayRequest;
                i2 = (payRequest == null || payRequest.getPayWay() != 2) ? 0 : 1;
            }
            StatHelper.cachePayWay(i2);
            PayRequestCache.getInstance().addBeanRequestToCache(pwdRequest.getRequestId(), pwdRequest);
            if (this.mPayRequest == null) {
                PwdPayActivity pwdPayActivity = this.mActivity;
                PayCallBackManager.callBackClientCancel(pwdPayActivity, this.TAG + "doPay().1");
                return;
            }
            if (shouldFullScreenLoading()) {
                this.mActivity.showLikeLoadingPage(true);
            } else {
                this.mActivity.showLikeLoadingPage(false);
            }
            PayRequest.PayPrice.PayType payType = this.mPayRequest.getPayPrice().payType;
            if (payType == PayRequest.PayPrice.PayType.BALANCE) {
                if (!this.checkPass) {
                    this.mActivity.showLoading(-1);
                }
                com.baidu.wallet.paysdk.beans.a aVar = (com.baidu.wallet.paysdk.beans.a) PayBeanFactory.getInstance().getBean((Context) this.mActivity, 14, this.TAG);
                aVar.setResponseCallback(this);
                aVar.execBean();
            } else if (payType == PayRequest.PayPrice.PayType.CREIDT) {
                if (!this.checkPass) {
                    this.mActivity.showLoading(-1);
                }
                com.baidu.wallet.paysdk.beans.i iVar = (com.baidu.wallet.paysdk.beans.i) PayBeanFactory.getInstance().getBean((Context) this.mActivity, PayBeanFactory.BEAN_ID_CREDIT_PAY, this.TAG);
                iVar.setResponseCallback(this);
                iVar.execBean();
            } else if (payType == PayRequest.PayPrice.PayType.BANKCARD) {
                if (!this.checkPass) {
                    this.mActivity.showLoading(-1);
                }
                w wVar = (w) PayBeanFactory.getInstance().getBean((Context) this.mActivity, 13, this.TAG);
                wVar.a(true);
                wVar.setResponseCallback(this);
                wVar.execBean();
            } else {
                PwdPayActivity pwdPayActivity2 = this.mActivity;
                PayCallBackManager.callBackClientCancel(pwdPayActivity2, this.TAG + "doPay().2");
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.contract.PwdPayContract.Presenter
    public void handleActivityError() {
        ErrorContentResponse errorContentResponse;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (errorContentResponse = this.mActivity.mErrorContent) == null || errorContentResponse.mkt_solution == null) {
            return;
        }
        w wVar = (w) PayBeanFactory.getInstance().getBean((Context) this.mActivity, 13, this.TAG);
        if (this.mPayRequest == null) {
            this.mPayRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
        }
        this.mPayRequest.setMktSolution(this.mActivity.mErrorContent.mkt_solution);
        this.mActivity.showLoading(-1);
        wVar.a(true);
        wVar.setResponseCallback(this);
        wVar.execBean();
    }

    @Override // com.baidu.wallet.paysdk.contract.PwdPayContract.Presenter, com.baidu.wallet.paysdk.presenter.NetWorkPresenter
    public void handleFailure(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048581, this, i2, i3, str) == null) {
            StatHelper.cacheCodeAndMsg(i3 + "", str);
            this.mActivity.dismissLoading(-1);
            if ((PayDataCache.getInstance().isPassFree() || (this.mPayRequest != null && isFingerprintPay())) && PayDataCache.getInstance().isFromPreCashier() && this.mCheckForWhat == CheckForWhat.FOR_ONEKEYPAY) {
                this.mActivity.setPageTransparent(true);
            }
            if (i2 != 14 && i2 != 13 && i2 != 263) {
                super.handleFailure(i2, i3, str);
                return;
            }
            this.mActivity.showPWdInputView(true);
            clearPayPwdCache(i3);
            if (i3 == 100015) {
                this.mActivity.showPassError(str);
            } else if (i3 == 100018) {
                this.mActivity.setErrorTips(false, null);
                PwdPayActivity pwdPayActivity = this.mActivity;
                pwdPayActivity.mDialogMsg = str;
                pwdPayActivity.mPayErrorCode = i3;
                pwdPayActivity.mBeanId = i2;
                WalletGlobalUtils.safeShowDialog(pwdPayActivity, 17, "");
            } else if (i3 == -8) {
                WalletGlobalUtils.safeShowDialog(this.mActivity, 11, "");
            } else if (i3 == 60500) {
                PwdPayActivity pwdPayActivity2 = this.mActivity;
                pwdPayActivity2.mDialogMsg = str;
                pwdPayActivity2.mPayErrorCode = i3;
                pwdPayActivity2.mBeanId = i2;
                WalletGlobalUtils.safeShowDialog(pwdPayActivity2, 37, "");
            } else if (65312 == i3) {
                StatisticManager.onEvent("fp_sys_65312_on_pwdpay");
                PwdPayActivity pwdPayActivity3 = this.mActivity;
                GlobalUtils.toast(pwdPayActivity3, ResUtils.getString(pwdPayActivity3, "bd_wallet_fingerprint_auth_failed"));
                String str2 = "指纹验证失败, 切到密码输入模式   , wireless-pay接口请求失败 错误码是  : " + i3;
                this.mActivity.turntoPwdPay(true, null);
            } else {
                PwdPayActivity pwdPayActivity4 = this.mActivity;
                if (TextUtils.isEmpty(str)) {
                    str = ResUtils.getString(this.mActivity, "dxm_fp_get_data_fail");
                }
                pwdPayActivity4.mDialogMsg = str;
                WalletGlobalUtils.safeShowDialog(this.mActivity, 12, "");
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.contract.PwdPayContract.Presenter, com.baidu.wallet.paysdk.presenter.NetWorkPresenter
    public void handleResponse(int i2, Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048582, this, i2, obj, str) == null) {
            StatHelper.cacheCodeAndMsg("0", StatHelper.SENSOR_OK);
            if (i2 == 257) {
                CheckForWhat checkForWhat = this.mCheckForWhat;
                if (checkForWhat == CheckForWhat.FOR_BIND_CARD_PAY) {
                    PayController payController = PayController.getInstance();
                    PwdPayActivity pwdPayActivity = this.mActivity;
                    payController.bindCardPay(pwdPayActivity, pwdPayActivity.getIntent(), false);
                    this.mActivity.finishWithoutAnim();
                } else if (checkForWhat == CheckForWhat.FOR_COMPLETE_PAY) {
                    PayController.getInstance().completeCardPay(this.mActivity, this.mPayRequest.mBondCard);
                    this.mActivity.finishWithoutAnim();
                } else if (checkForWhat == CheckForWhat.FOR_ONEKEYPAY) {
                    doPay();
                }
            } else if (i2 == 14) {
                BalancePayResponse balancePayResponse = (BalancePayResponse) obj;
                if (balancePayResponse == null || !balancePayResponse.checkResponseValidity()) {
                    return;
                }
                PayResultContent payResultContent = new PayResultContent();
                payResultContent.notify = balancePayResponse.notify;
                payResultContent.paytype_desc = balancePayResponse.paytype_desc;
                payResultContent.coupon_msg = balancePayResponse.coupon_msg;
                BalancePayResponse.Business business = balancePayResponse.business;
                if (business != null) {
                    String str2 = business.stream_recharge_msg;
                    if (str2 != null) {
                        payResultContent.stream_recharge_msg = str2;
                    }
                    String str3 = balancePayResponse.business.expected_time;
                    if (str3 != null) {
                        payResultContent.expected_time = str3;
                    }
                }
                payResultContent.coupon_find_prompt = balancePayResponse.coupon_find_prompt;
                payResultContent.total_amount = balancePayResponse.total_amount;
                payResultContent.cash_amount = balancePayResponse.cash_amount;
                payResultContent.discount_amount = balancePayResponse.discount_amount;
                payResultContent.discount_info = balancePayResponse.discount_info;
                payResultContent.pay_detail_info = balancePayResponse.pay_detail_info;
                payResultContent.paytype_info = balancePayResponse.paytype_info;
                payResultContent.cross_market = balancePayResponse.cross_market;
                payResultContent.order_prefix = balancePayResponse.order_prefix;
                payResultContent.discount_prefix = balancePayResponse.discount_prefix;
                payResultContent.payResultCashbackDetail = balancePayResponse.cashback_dialog_detail;
                AuthorizeInfo authorizeInfo = balancePayResponse.authorize_info;
                payResultContent.authorize_msg = authorizeInfo != null ? authorizeInfo.authorize_desc : "";
                payResultContent.feedback_info = balancePayResponse.feedback_info;
                payResultContent.trans_no = balancePayResponse.trans_no;
                payResultContent.redirect_sp_succpage_remain_time = balancePayResponse.redirect_sp_succpage_remain_time;
                payResultContent.fp_open_or_update_msg = balancePayResponse.fp_open_or_update_msg;
                payResultContent.compliance = balancePayResponse.compliance;
                payResultContent.title_url = balancePayResponse.title_url;
                payResultContent.order_no = balancePayResponse.order_no;
                StatHelper.cachePayAmount(Double.valueOf(balancePayResponse.cash_amount).doubleValue());
                statPaySuccess(1);
                if (balancePayResponse.toShowH5ResultPage()) {
                    PayDataCache.getInstance().setH5ResultParams(new H5ResultParams(balancePayResponse.redirect_sp_succpage_remain_time, balancePayResponse.pay_result_url, balancePayResponse.pay_result_params, balancePayResponse.show_h5_result, CashierDeskPayResult.PayScenario.BalancedPay));
                }
                this.mActivity.showPaySuccessPage(true, payResultContent, 1);
            } else {
                super.handleResponse(i2, obj, str);
            }
        }
    }

    public boolean isFingerprintPay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mCheckForWhat == CheckForWhat.FOR_ONEKEYPAY && this.mPayRequest.getPayWay() == 2 : invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.contract.PwdPayContract.Presenter
    public PwdPayContract.protocolModel needshowProtocolContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            UserData.UserModel userInfo = PayDataCache.getInstance().getUserInfo();
            if (userInfo == null || this.mPayRequest == null) {
                return null;
            }
            PwdPayContract.protocolModel protocolmodel = new PwdPayContract.protocolModel();
            boolean z = true;
            if (!userInfo.getPassfreeSelected() && this.mPayRequest.getOpenPassFreeFlag() != 1) {
                z = false;
            }
            protocolmodel.checked = z;
            if (userInfo.getPassfreeProtocol() != null && !TextUtils.isEmpty(userInfo.getPassfreeProtocol().getPassfreeProtocolPrefix()) && !TextUtils.isEmpty(userInfo.getPassfreeProtocol().getPassfreeProtocolMsg()) && !TextUtils.isEmpty(userInfo.getPassfreeProtocol().getPassfreeProtocolUrl())) {
                protocolmodel.passfree_protocol_msg = userInfo.getPassfreeProtocol().getPassfreeProtocolMsg();
                protocolmodel.passfree_protocol_prefix = userInfo.getPassfreeProtocol().getPassfreeProtocolPrefix();
                protocolmodel.passfree_protocol_url = userInfo.getPassfreeProtocol().getPassfreeProtocolUrl();
            }
            protocolmodel.iClickCallback = this;
            return protocolmodel;
        }
        return (PwdPayContract.protocolModel) invokeV.objValue;
    }

    @Override // com.baidu.wallet.paysdk.contract.PwdPayContract.Presenter
    public boolean onBeanExecFailureWithErrContent(int i2, int i3, String str, Object obj) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, obj})) == null) {
            if (!PayDataCache.getInstance().isPassFree() && !isFingerprintPay()) {
                this.mActivity.showPWdInputView(true);
            }
            ErrorContentResponse errorContentResponse = null;
            if (obj != null && (obj instanceof ErrorContentResponse)) {
                errorContentResponse = (ErrorContentResponse) obj;
            }
            clearPayPwdCache(i3);
            if (i3 == 100015 && errorContentResponse != null && "1".equals(errorContentResponse.use_vcode_to_pay)) {
                this.mActivity.showPassError(str);
                this.mPayRequest.mUseVcodeToPay = errorContentResponse.use_vcode_to_pay;
                triggleSmsPay();
                this.mActivity.finishWithoutAnim();
                return true;
            } else if (errorContentResponse != null && "1".equals(errorContentResponse.need_other_pay_method)) {
                PwdPayActivity pwdPayActivity = this.mActivity;
                pwdPayActivity.mDialogMsg = str;
                WalletGlobalUtils.safeShowDialog(pwdPayActivity, 36, "");
                return true;
            } else {
                return super.onBeanExecFailureWithErrContent(i2, i3, str, obj);
            }
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.presenter.BasePresenter
    public void onCreate(Bundle bundle) {
        Serializable serializable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            this.mPayRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
            if (bundle != null && (serializable = bundle.getSerializable("checkforwhat")) != null && (serializable instanceof CheckForWhat)) {
                this.mCheckForWhat = (CheckForWhat) serializable;
            }
            if (this.mPayRequest == null) {
                PwdPayActivity pwdPayActivity = this.mActivity;
                PayCallBackManager.callBackClientCancel(pwdPayActivity, this.TAG + "onCreate().1");
                this.mActivity.finishWithoutAnim();
                return;
            }
            refreshPara();
        }
    }

    @Override // com.baidu.wallet.paysdk.presenter.BasePresenter
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
        }
    }

    @Override // com.baidu.wallet.paysdk.contract.PwdPayContract.Presenter
    public void onFPCheckCancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (PayDataCache.getInstance().isFromPreCashier()) {
                PayCallBackManager.callBackClientCancel(this.mActivity, "doVerifyFingerprint().1");
            } else {
                this.mActivity.finish();
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.contract.PwdPayContract.Presenter
    public void onFPCheckOK(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.mPayRequest.storeFingerprintData(str);
            if (this.mPayRequest.mFingerprintPay instanceof SysFingerprintPay) {
                StatHelper.statServiceEvent("fp_sys_verify_success_pay");
            } else {
                StatisticManager.onEvent("fp_fido_verify_success_pay");
            }
            doPay();
        }
    }

    @Override // com.baidu.wallet.paysdk.presenter.BasePresenter
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
        }
    }

    @Override // com.baidu.wallet.paysdk.contract.PwdPayContract.a
    public void onProtocolClicked(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.mPayRequest.applyNoPwd(z);
        }
    }

    @Override // com.baidu.wallet.paysdk.contract.PwdPayContract.Presenter
    public void onPwdChanged(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            if (this.mCheckForWhat == CheckForWhat.FOR_ONEKEYPAY) {
                this.pwdword = str;
                PayRequest payRequest = this.mPayRequest;
                if (payRequest == null) {
                    return;
                }
                CardData.BondCard bondCard = payRequest.mBondCard;
                boolean z = bondCard != null && bondCard.isCheckPass;
                this.checkPass = z;
                if (z) {
                    doCheckPwd(str);
                    return;
                } else {
                    doPay();
                    return;
                }
            }
            doCheckPwd(str);
        }
    }

    @Override // com.baidu.wallet.paysdk.presenter.BasePresenter
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
        }
    }

    @Override // com.baidu.wallet.paysdk.presenter.BasePresenter
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bundle) == null) {
            bundle.putSerializable("checkforwhat", this.mCheckForWhat);
        }
    }

    @Override // com.baidu.wallet.paysdk.contract.PwdPayContract.Presenter
    public void onTurntoPwdPay(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            if (z) {
                this.mPayRequest.supportFingerprintPay = false;
            }
            this.mPayRequest.setPayWay(3);
            refreshPara();
        }
    }

    @Override // com.baidu.wallet.paysdk.contract.PwdPayContract.Presenter
    public void pwdAndFpTypeChange() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if (isPwdOnekeypay()) {
                this.mPayRequest.setPayWay(2);
                if (PayDataCache.getInstance().isFromPreCashier()) {
                    this.mActivity.doVerifyFingerprint(this.mPayRequest.mFingerprintPay);
                } else {
                    this.mActivity.finish();
                }
                HashMap hashMap = new HashMap();
                hashMap.put("pay_from", StatHelper.getPayFrom());
                ArrayList arrayList = new ArrayList();
                arrayList.add(StatHelper.getOrderNo());
                hashMap.put(StatHelper.PAY_WAY, "1");
                StatisticManager.onEventWithValues(PayStatServiceEvent.CHANGE_PAY_WAY, arrayList, hashMap);
            } else if (isFingerprintPay()) {
                this.mActivity.turntoPwdPay(false, null);
            }
        }
    }

    public boolean shouldFullScreenLoading() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (PayDataCache.getInstance().isFromPreCashier()) {
                return isFingerprintPay() || PayDataCache.getInstance().isPassFree();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.contract.PwdPayContract.Presenter
    public boolean showSucAnim() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? !shouldFullScreenLoading() : invokeV.booleanValue;
    }
}
