package com.baidu.tieba;

import android.os.Bundle;
import com.baidu.payment.PaymentManager;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
/* loaded from: classes5.dex */
public class pe1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, bundle) == null) {
            if (bundle == null) {
                PaymentManager.i(3, "闪付返回信息为空");
                return;
            }
            String string = bundle.getString(HiAnalyticsConstant.HaKey.BI_KEY_RESULT);
            try {
                PaymentManager.i(Integer.parseInt(string), bundle.getString("payInfo"));
            } catch (NumberFormatException e) {
                PaymentManager.i(3, e.getMessage());
            }
        }
    }

    public static void b(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, bundle) == null) {
            ne1.a().g(bundle);
        }
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, null) == null) && ProcessUtils.isMainProcess()) {
            ne1.a().h("");
        }
    }
}
