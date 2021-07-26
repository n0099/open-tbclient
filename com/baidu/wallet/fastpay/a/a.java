package com.baidu.wallet.fastpay.a;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static String f24959a = "mobileRechargeClickMenu";

    /* renamed from: b  reason: collision with root package name */
    public static String f24960b = "mobileRechargeAddressbookClick";

    /* renamed from: c  reason: collision with root package name */
    public static String f24961c = "mobileRechargeClickService";

    /* renamed from: d  reason: collision with root package name */
    public static String f24962d = "mobileRechargeClickHistoryRecord";

    /* renamed from: e  reason: collision with root package name */
    public static String f24963e = "mobileRechargeBackBtnClick";

    /* renamed from: f  reason: collision with root package name */
    public static String f24964f = "mobileRechargeChooseDenomination";

    /* renamed from: g  reason: collision with root package name */
    public static String f24965g = "mobileRechargeClickPrompt";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1136003667, "Lcom/baidu/wallet/fastpay/a/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1136003667, "Lcom/baidu/wallet/fastpay/a/a;");
        }
    }
}
