package com.baidu.tieba.wallet;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.b85;
import com.repackage.e85;
import java.util.Map;
/* loaded from: classes4.dex */
public class CurrencyJumpHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public CurrencyJumpHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void buyGiftGotoBuyTBeanPage(Context context, float f) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLF(65538, null, context, f) == null) && CurrencySwitchUtil.isYyIsConvert()) {
            goYYPay(context);
        }
    }

    public static void goYYPay(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context) == null) {
            goYYPay(context, null);
        }
    }

    public static void gotoBuyTBeanPage(Context context, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLJ(65545, null, context, j) == null) && CurrencySwitchUtil.isYyIsConvert()) {
            goYYPay(context);
        }
    }

    public static void memberCenterBuyTBean(Context context, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65546, null, context, str) == null) && CurrencySwitchUtil.isYyIsConvert()) {
            goYYPay(context);
        }
    }

    public static void nativeGotoBuyBean(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, null, context) == null) && CurrencySwitchUtil.isYyIsConvert()) {
            goYYPay(context);
        }
    }

    public static void openNativeBuyTBean(Context context, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65548, null, context, map) == null) && CurrencySwitchUtil.isYyIsConvert()) {
            goYYPay(context);
        }
    }

    public static void personGotoBuyBean(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65549, null, context) == null) && CurrencySwitchUtil.isYyIsConvert()) {
            goYYPay(context);
        }
    }

    public static void schemaGotoBuyBean(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65550, null, context) == null) && CurrencySwitchUtil.isYyIsConvert()) {
            goYYPay(context);
        }
    }

    public static void goYYPay(Context context, @Nullable b85 b85Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, context, b85Var) == null) {
            MessageManager.getInstance().runTask(2921546, String.class, new e85(context, 0, null, null, b85Var));
        }
    }

    public static void buyGiftGotoBuyTBeanPage(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, context) == null) && CurrencySwitchUtil.isYyIsConvert()) {
            goYYPay(context);
        }
    }

    public static void gotoBuyTBeanPage(Context context, float f, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{context, Float.valueOf(f), str, str2}) == null) {
            gotoBuyTBeanPage(context, f, str, str2, null);
        }
    }

    public static void goYYPay(Context context, @Nullable b85 b85Var, String str, Long l, boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{context, b85Var, str, l, Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            e85 e85Var = new e85(context, 0, str, l, b85Var);
            e85Var.g = z;
            e85Var.f = i;
            MessageManager.getInstance().runTask(2921546, String.class, e85Var);
        }
    }

    public static void gotoBuyTBeanPage(Context context, float f, String str, String str2, @Nullable b85 b85Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{context, Float.valueOf(f), str, str2, b85Var}) == null) && CurrencySwitchUtil.isYyIsConvert()) {
            goYYPay(context, b85Var);
        }
    }

    public static void buyGiftGotoBuyTBeanPage(Context context, b85 b85Var, String str, Long l, boolean z, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{context, b85Var, str, l, Boolean.valueOf(z), Integer.valueOf(i)}) == null) && CurrencySwitchUtil.isYyIsConvert()) {
            goYYPay(context, b85Var, str, l, z, i);
        }
    }
}
