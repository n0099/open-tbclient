package com.baidu.wallet.paysdk.sms.controller;

import android.app.Dialog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.ui.widget.IdentifyCodeGetFailDialog;
import com.dxmpay.apollon.armor.SecurePay;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.core.utils.StringUtils;
/* loaded from: classes10.dex */
public class g extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public g() {
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

    @Override // com.baidu.wallet.paysdk.sms.controller.c, com.baidu.wallet.paysdk.sms.controller.ISmsController
    public Dialog doOnCreateDialog(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if (i2 == 23) {
                return new IdentifyCodeGetFailDialog(this.f59905a, IdentifyCodeGetFailDialog.VerifyCodeType.VOICE);
            }
            return super.doOnCreateDialog(i2);
        }
        return (Dialog) invokeI.objValue;
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.c, com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void initSmsActivityView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            String string = ResUtils.getString(this.f59905a, "ebpay_submit_pay");
            PayRequest payRequest = this.f59908d;
            if (payRequest != null) {
                if (payRequest.mMktSolution != null) {
                    string = String.format(ResUtils.getString(this.f59905a, "wallet_base_confirm_pay"), StringUtils.fen2Yuan(this.f59908d.mMktSolution.easypay_amount));
                } else {
                    string = String.format(ResUtils.getString(this.f59905a, "wallet_base_confirm_pay"), StringUtils.fen2Yuan(this.f59908d.getFinalPayAmount()));
                }
            }
            this.f59906b.initSMSActivityView("ebpay_sms_top_tip_voice_verify", "", string, SecurePay.unicodeDecode(SecurePay.getInstance().localDecryptProxy(this.f59909e)), true);
        }
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.c, com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean isSendSmsOnCreate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }
}
