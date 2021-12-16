package com.baidu.wallet.paysdk.presenter;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.wallet.paysdk.contract.PayTypeContract;
import com.baidu.wallet.paysdk.ui.PayTypeActivity;
/* loaded from: classes13.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static PayTypeContract.Presenter a(String str, PayTypeActivity payTypeActivity) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, str, payTypeActivity)) == null) {
            if (TextUtils.isEmpty(str)) {
                return new PayTypePresenter(payTypeActivity);
            }
            if (str.equals("FORM_PRECASHIER")) {
                return new PreCashierPayTypePresenter(payTypeActivity);
            }
            if (str.equals("FROM_AUTHORIZE")) {
                return new AuthorizePayTypePresenter(payTypeActivity);
            }
            return new PayTypePresenter(payTypeActivity);
        }
        return (PayTypeContract.Presenter) invokeLL.objValue;
    }
}
