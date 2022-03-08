package com.baidu.wallet.paysdk.contract;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.u;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.datamodel.PwdRequest;
import com.baidu.wallet.paysdk.presenter.NetWorkPresenter;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.PwdPayActivity;
import com.baidu.wallet.paysdk.ui.WalletSmsActivity;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.core.NoProguard;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import java.io.Serializable;
/* loaded from: classes6.dex */
public interface PwdPayContract {

    /* loaded from: classes6.dex */
    public static abstract class Presenter extends NetWorkPresenter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String TAG;
        public PwdPayActivity mActivity;
        public PayRequest mPayRequest;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Presenter(PwdPayActivity pwdPayActivity) {
            super(pwdPayActivity);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pwdPayActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.TAG = toString();
            this.mActivity = pwdPayActivity;
            pwdPayActivity.setPresenter(this);
            this.mPayRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
        }

        public void clearPayPwdCache(int i2) {
            PwdRequest pwdRequest;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if ((100015 == i2 || 100018 == i2) && (pwdRequest = (PwdRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PWD)) != null) {
                    pwdRequest.mPayPass = null;
                }
            }
        }

        public boolean dialogNevigateOper_QuitCashDesk() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        public boolean dialogNevigateOper_QuitCurrentPage() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        public abstract boolean directQuit();

        public final void doCheckPwd(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                PwdRequest pwdRequest = new PwdRequest();
                pwdRequest.mFrom = 1;
                pwdRequest.mRequestType = 2;
                pwdRequest.mPayPass = str;
                PayRequestCache.getInstance().addBeanRequestToCache(pwdRequest.getRequestId(), pwdRequest);
                u uVar = (u) PayBeanFactory.getInstance().getBean((Context) this.mActivity, 257, this.TAG);
                this.mActivity.showLoading(-1);
                uVar.setResponseCallback(this);
                uVar.execBean();
            }
        }

        public void handleActivityError() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            }
        }

        @Override // com.baidu.wallet.paysdk.presenter.NetWorkPresenter
        public void handleFailure(int i2, int i3, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(1048582, this, i2, i3, str) == null) {
                this.mActivity.dismissLoading(-1);
                if (i2 == 257) {
                    this.mActivity.showPWdInputView(true);
                    clearPayPwdCache(i3);
                    if (i3 == 100015) {
                        this.mActivity.showPassError(str);
                        return;
                    } else if (i3 == 100018) {
                        this.mActivity.setErrorTips(false, null);
                        PwdPayActivity pwdPayActivity = this.mActivity;
                        pwdPayActivity.mDialogMsg = str;
                        pwdPayActivity.mPayErrorCode = i3;
                        pwdPayActivity.mBeanId = i2;
                        WalletGlobalUtils.safeShowDialog(pwdPayActivity, 17, "");
                        return;
                    } else if (i3 == -8) {
                        WalletGlobalUtils.safeShowDialog(this.mActivity, 11, "");
                        return;
                    } else if (i3 == 60500) {
                        PwdPayActivity pwdPayActivity2 = this.mActivity;
                        pwdPayActivity2.mDialogMsg = str;
                        pwdPayActivity2.mPayErrorCode = i3;
                        pwdPayActivity2.mBeanId = i2;
                        WalletGlobalUtils.safeShowDialog(pwdPayActivity2, 37, "");
                        return;
                    } else if (65312 == i3) {
                        PwdPayActivity pwdPayActivity3 = this.mActivity;
                        GlobalUtils.toast(pwdPayActivity3, ResUtils.getString(pwdPayActivity3, "bd_wallet_fingerprint_auth_failed"));
                        String str2 = "指纹验证失败, 切到密码输入模式   , wireless-pay接口请求失败 错误码是  : " + i3;
                        this.mActivity.turntoPwdPay(true, null);
                        return;
                    } else {
                        PwdPayActivity pwdPayActivity4 = this.mActivity;
                        if (TextUtils.isEmpty(str)) {
                            str = ResUtils.getString(this.mActivity, "dxm_fp_get_data_fail");
                        }
                        pwdPayActivity4.mDialogMsg = str;
                        WalletGlobalUtils.safeShowDialog(this.mActivity, 12, "");
                        return;
                    }
                }
                this.mActivity.handleFailure(i2, i3, str);
            }
        }

        @Override // com.baidu.wallet.paysdk.presenter.NetWorkPresenter
        public void handleResponse(int i2, Object obj, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048583, this, i2, obj, str) == null) {
                this.mActivity.handleResponse(i2, obj, str);
            }
        }

        public boolean isGatewaySignPay() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mActivity.isGatewaySignPay() : invokeV.booleanValue;
        }

        public protocolModel needshowProtocolContainer() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                return null;
            }
            return (protocolModel) invokeV.objValue;
        }

        public boolean onBeanExecFailureWithErrContent(int i2, int i3, String str, Object obj) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, obj})) == null) {
                clearPayPwdCache(i3);
                return false;
            }
            return invokeCommon.booleanValue;
        }

        public abstract void onFPCheckCancel();

        public abstract void onFPCheckOK(String str);

        public abstract void onPwdChanged(String str);

        public void onTurntoPwdPay(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            }
        }

        public abstract void pwdAndFpTypeChange();

        public boolean showSucAnim() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        public void triggleSmsPay() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
                StatisticManager.onEvent("triggleSmsVerify");
                Intent intent = new Intent();
                intent.setClass(this.mActivity, WalletSmsActivity.class);
                intent.putExtra(BeanConstants.SMS_ACTIVITY_FROM_KEY, 1);
                intent.putExtra("pay_by_smscode", true);
                this.mActivity.startActivityWithoutAnim(intent);
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface a {
        void onProtocolClicked(boolean z);
    }

    /* loaded from: classes6.dex */
    public static class protocolModel implements NoProguard, Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean checked;
        public a iClickCallback;
        public String passfree_protocol_msg;
        public String passfree_protocol_prefix;
        public String passfree_protocol_url;

        public protocolModel() {
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
    }
}
