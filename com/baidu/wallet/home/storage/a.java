package com.baidu.wallet.home.storage;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.utils.SharedPreferencesUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.wallet.core.beans.BeanConstants;
/* loaded from: classes8.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65537, null, context, str, str2) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, "key_for_stamptime_with_id_" + HomeDataCacheManager.getInstance().getPpKey(context) + str, str2);
    }

    public static String a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, str)) == null) {
            return (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, "key_for_stamptime_with_id_" + HomeDataCacheManager.getInstance().getPpKey(context) + str, "");
        }
        return (String) invokeLL.objValue;
    }

    public static boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            return ((Boolean) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, "key_for_home_mask_switch" + HomeDataCacheManager.getInstance().getPpKey(context), Boolean.FALSE)).booleanValue();
        }
        return invokeL.booleanValue;
    }

    public static void a(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65538, null, context, z) == null) {
            SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, "key_for_home_mask_switch" + HomeDataCacheManager.getInstance().getPpKey(context), Boolean.valueOf(z));
        }
    }
}
