package com.baidu.wallet.paysdk.presenter;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.contract.PwdPayContract;
import com.baidu.wallet.paysdk.datamodel.O2OPayResultItemInfo;
import com.baidu.wallet.paysdk.datamodel.O2OTransInfo;
import com.baidu.wallet.paysdk.datamodel.PayQueryRequest;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.datamodel.ScanCodeConstant;
import com.baidu.wallet.paysdk.datamodel.ScanCodeLimitPayResponse;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.PwdPayActivity;
import com.baidu.wallet.paysdk.ui.WalletSmsActivity;
import com.baidu.wallet.router.LocalRouter;
import com.baidu.wallet.router.RouterCallback;
import com.baidu.wallet.router.RouterRequest;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.api.WalletLoginHelper;
import com.dxmpay.wallet.base.datamodel.AccountManager;
import com.dxmpay.wallet.core.beans.BaseBean;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.StatHelper;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class PwdPayPresenterForScancode extends PwdPayContract.Presenter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isQuerying;
    public boolean mCheckSMS;
    public O2OTransInfo mOrderInfo;
    public PayQueryRequest mQueryRequest;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PwdPayPresenterForScancode(PwdPayActivity pwdPayActivity, Intent intent) {
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
        this.mCheckSMS = false;
        this.isQuerying = false;
        if (intent != null) {
            this.mOrderInfo = (O2OTransInfo) intent.getSerializableExtra(ScanCodeConstant.ORDER_INFO_KEY);
            this.mCheckSMS = intent.getBooleanExtra("checkSms", false);
        }
    }

    private void scancodePay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            LocalRouter.getInstance(this.mActivity).route(this.mActivity, new RouterRequest().provider("scancode").action("getLimitPayBean"), new RouterCallback(this) { // from class: com.baidu.wallet.paysdk.presenter.PwdPayPresenterForScancode.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ PwdPayPresenterForScancode f59859a;

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
                    this.f59859a = this;
                }

                @Override // com.baidu.wallet.router.RouterCallback
                public void onResult(int i2, HashMap hashMap) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, hashMap) == null) {
                        if (i2 != 0 || hashMap == null || hashMap.get("data") == null) {
                            if (i2 == 5) {
                                HashMap hashMap2 = new HashMap();
                                hashMap2.put("provider", "scancode");
                                hashMap2.put("action", "getLimitPayBean");
                                StatisticManager.onEventEndWithValues("sdk_router_error", i2, hashMap2.values());
                                return;
                            }
                            return;
                        }
                        Object obj = hashMap.get("data");
                        if (obj == null || !(obj instanceof BaseBean)) {
                            return;
                        }
                        BaseBean baseBean = (BaseBean) obj;
                        baseBean.setBeanParams(this.f59859a.mOrderInfo.sp_no, this.f59859a.mOrderInfo.order_no, this.f59859a.mOrderInfo.pay_code, "");
                        baseBean.setResponseCallback(this.f59859a);
                        baseBean.execBean();
                    }
                }
            });
        }
    }

    @Override // com.baidu.wallet.paysdk.contract.PwdPayContract.Presenter
    public boolean directQuit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            WalletGlobalUtils.safeShowDialog(this.mActivity, 18, "");
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.contract.PwdPayContract.Presenter, com.baidu.wallet.paysdk.presenter.NetWorkPresenter
    public void handleFailure(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, str) == null) {
            this.mActivity.dismissLoading(-1);
            if (i2 == 594) {
                this.mActivity.showPWdInputView(true);
                clearPayPwdCache(i3);
                if (TextUtils.isEmpty(str)) {
                    str = ResUtils.getString(this.mActivity, "dxm_fp_get_data_fail");
                }
                if (i3 == 5003) {
                    AccountManager.getInstance(this.mActivity).logout();
                    WalletLoginHelper.getInstance().logout(false);
                } else if (i3 == 15414 || i3 == 15432 || i3 == 100015) {
                    this.mActivity.showPassError(str);
                } else if (i3 == 100018) {
                    this.mActivity.showPassError(str);
                }
                if (i3 == 65235) {
                    this.mActivity.showPassError(str);
                    return;
                } else {
                    this.mActivity.showPassError(str);
                    return;
                }
            }
            super.handleFailure(i2, i3, str);
        }
    }

    @Override // com.baidu.wallet.paysdk.contract.PwdPayContract.Presenter, com.baidu.wallet.paysdk.presenter.NetWorkPresenter
    public void handleResponse(int i2, Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i2, obj, str) == null) {
            if (i2 == 257) {
                if (this.mCheckSMS) {
                    this.mActivity.dismissLoading(-1);
                    this.mActivity.showPWdInputView(true);
                    triggleSmsPay();
                    return;
                }
                scancodePay();
            } else if (i2 != 594) {
                if (i2 == 12) {
                    if (this.mOrderInfo == null) {
                        return;
                    }
                    PayRequest payRequest = new PayRequest();
                    payRequest.setPayFrom(BeanConstants.PAY_FROM_B_SAO_C);
                    payRequest.mGoodName = this.mOrderInfo.goods_name;
                    PayRequestCache.getInstance().addBeanRequestToCache(payRequest.getRequestId(), payRequest);
                    return;
                }
                super.handleResponse(i2, obj, str);
            } else {
                this.isQuerying = false;
                ScanCodeLimitPayResponse scanCodeLimitPayResponse = (ScanCodeLimitPayResponse) obj;
                if (scanCodeLimitPayResponse.checkResponseValidity()) {
                    O2OTransInfo o2OTransInfo = this.mOrderInfo;
                    o2OTransInfo.notify = scanCodeLimitPayResponse.notify;
                    o2OTransInfo.score_tip = scanCodeLimitPayResponse.score_tip;
                    if ("2".equalsIgnoreCase(scanCodeLimitPayResponse.pay_type)) {
                        if (this.mQueryRequest == null) {
                            this.mQueryRequest = new PayQueryRequest();
                        }
                        PayQueryRequest payQueryRequest = this.mQueryRequest;
                        payQueryRequest.mBankNo = scanCodeLimitPayResponse.bank_no;
                        payQueryRequest.mOrderNo = scanCodeLimitPayResponse.bank_send_trans_no;
                        PayRequestCache.getInstance().addBeanRequestToCache(this.mQueryRequest.getRequestId(), this.mQueryRequest);
                        this.mActivity.queryPayResult();
                    } else if (scanCodeLimitPayResponse == null && this.mOrderInfo == null) {
                    } else {
                        PayRequest payRequest2 = new PayRequest();
                        payRequest2.setPayFrom(BeanConstants.PAY_FROM_B_SAO_C);
                        payRequest2.mGoodName = this.mOrderInfo.goods_name;
                        PayRequestCache.getInstance().addBeanRequestToCache(payRequest2.getRequestId(), payRequest2);
                        this.mOrderInfo.paytype_desc = scanCodeLimitPayResponse.paytype_desc;
                        PayResultContent payResultContent = new PayResultContent();
                        payResultContent.notify = scanCodeLimitPayResponse.notify;
                        payResultContent.score_tip = scanCodeLimitPayResponse.score_tip;
                        payResultContent.paytype_desc = scanCodeLimitPayResponse.paytype_desc;
                        O2OPayResultItemInfo o2OPayResultItemInfo = scanCodeLimitPayResponse.pay_result;
                        if (o2OPayResultItemInfo != null) {
                            payResultContent.coupon_msg = o2OPayResultItemInfo.coupon_msg;
                            payResultContent.coupon_find_prompt = o2OPayResultItemInfo.coupon_find_prompt;
                            String str2 = o2OPayResultItemInfo.cash_amount;
                            payResultContent.cash_amount = str2;
                            payResultContent.total_amount = o2OPayResultItemInfo.total_amount;
                            payResultContent.discount_amount = o2OPayResultItemInfo.discount_amount;
                            payResultContent.pay_detail_info = o2OPayResultItemInfo.pay_detail_info;
                            payResultContent.paytype_info = o2OPayResultItemInfo.paytype_info;
                            payResultContent.discount_prefix = o2OPayResultItemInfo.discount_prefix;
                            payResultContent.order_prefix = o2OPayResultItemInfo.order_prefix;
                            payResultContent.redirect_sp_succpage_remain_time = o2OPayResultItemInfo.redirect_sp_succpage_remain_time;
                            StatHelper.cachePayAmount(Double.valueOf(str2).doubleValue());
                        }
                        this.mActivity.showPaySuccessPage(true, payResultContent, 1);
                    }
                }
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.contract.PwdPayContract.Presenter
    public boolean onBeanExecFailureWithErrContent(int i2, int i3, String str, Object obj) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, obj})) == null) {
            clearPayPwdCache(i3);
            return false;
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.presenter.BasePresenter
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) || bundle == null) {
            return;
        }
        this.mOrderInfo = (O2OTransInfo) bundle.getSerializable(ScanCodeConstant.ORDER_INFO_KEY);
        this.mCheckSMS = bundle.getBoolean("checkSms", false);
    }

    @Override // com.baidu.wallet.paysdk.presenter.BasePresenter
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    @Override // com.baidu.wallet.paysdk.contract.PwdPayContract.Presenter
    public void onFPCheckCancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.mActivity.finish();
        }
    }

    @Override // com.baidu.wallet.paysdk.contract.PwdPayContract.Presenter
    public void onFPCheckOK(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
        }
    }

    @Override // com.baidu.wallet.paysdk.presenter.BasePresenter
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    @Override // com.baidu.wallet.paysdk.contract.PwdPayContract.Presenter
    public void onPwdChanged(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            doCheckPwd(str);
        }
    }

    @Override // com.baidu.wallet.paysdk.presenter.BasePresenter
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
        }
    }

    @Override // com.baidu.wallet.paysdk.presenter.BasePresenter
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) {
            bundle.putSerializable(ScanCodeConstant.ORDER_INFO_KEY, this.mOrderInfo);
            bundle.putSerializable("checkSms", Boolean.valueOf(this.mCheckSMS));
        }
    }

    @Override // com.baidu.wallet.paysdk.contract.PwdPayContract.Presenter
    public void pwdAndFpTypeChange() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }

    @Override // com.baidu.wallet.paysdk.contract.PwdPayContract.Presenter
    public void triggleSmsPay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            StatisticManager.onEvent("triggleSmsVerify");
            Intent intent = new Intent();
            intent.setClass(this.mActivity, WalletSmsActivity.class);
            intent.putExtra(BeanConstants.SMS_ACTIVITY_FROM_KEY, 10);
            intent.putExtra(ScanCodeConstant.ORDER_INFO_KEY, this.mOrderInfo);
            this.mActivity.startActivityWithoutAnim(intent);
        }
    }
}
