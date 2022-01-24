package com.baidu.wallet.paysdk.presenter;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.contract.PwdPayContract;
import com.baidu.wallet.paysdk.ui.PwdPayActivity;
/* loaded from: classes2.dex */
public class PwdPayPresenterFactory {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int PWDPAYACTIVITY_FROM_AUTHORIZE = 3;
    public static final int PWDPAYACTIVITY_FROM_CASHDESK = 4;
    public static final String PWDPAYACTIVITY_FROM_KEY = "pwdpayactivity_from_key";
    public static final int PWDPAYACTIVITY_FROM_SCANCODE = 2;
    public transient /* synthetic */ FieldHolder $fh;

    public PwdPayPresenterFactory() {
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

    public static PwdPayContract.Presenter a(int i2, PwdPayActivity pwdPayActivity) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65537, null, i2, pwdPayActivity)) == null) {
            if (i2 != 2) {
                if (i2 != 3) {
                    return new PwdPayPresenterForCashdesk(pwdPayActivity, pwdPayActivity.getIntent());
                }
                return new PwdPayPresenterForAuthsign(pwdPayActivity);
            }
            return new PwdPayPresenterForScancode(pwdPayActivity, pwdPayActivity.getIntent());
        }
        return (PwdPayContract.Presenter) invokeIL.objValue;
    }
}
