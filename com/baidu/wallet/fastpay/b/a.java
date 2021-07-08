package com.baidu.wallet.fastpay.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.utils.SharedPreferencesUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.wallet.core.beans.BeanConstants;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: classes5.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, context, str) == null) || context == null || TextUtils.isEmpty(str) || str.length() > 13) {
            return;
        }
        String str2 = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, "history_new_1", "");
        String localDecrypt1 = !TextUtils.isEmpty(str2) ? SafePay.getInstance().localDecrypt1(str2) : "";
        if (TextUtils.isEmpty(localDecrypt1)) {
            SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, "history_new_1", TextUtils.isEmpty(str) ? "" : SafePay.getInstance().localEncrypt1(str));
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        String[] split = localDecrypt1.split(",");
        int length = split.length;
        boolean z = length > 4;
        for (int i2 = 0; i2 < length; i2++) {
            if (split[i2] == null || split[i2].length() < 13 || str.substring(0, 13).equals(split[i2].substring(0, 13))) {
                z = false;
            } else {
                int i3 = length - 1;
                if (i2 < i3 || (i2 == i3 && !z)) {
                    sb.append(",");
                    sb.append(split[i2]);
                }
            }
        }
        SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, "history_new_1", TextUtils.isEmpty(sb.toString()) ? "" : SafePay.getInstance().localEncrypt1(sb.toString()));
    }

    public static void b(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, context) == null) || context == null) {
            return;
        }
        SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, "history_new_1", "");
    }

    public static ArrayList<String> a(Context context) {
        InterceptResult invokeL;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            if (context == null) {
                return null;
            }
            String str = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, "history_new_1", "");
            String localDecrypt1 = TextUtils.isEmpty(str) ? "" : SafePay.getInstance().localDecrypt1(str);
            if (TextUtils.isEmpty(localDecrypt1) || (split = localDecrypt1.split(",")) == null) {
                return null;
            }
            return new ArrayList<>(Arrays.asList(split));
        }
        return (ArrayList) invokeL.objValue;
    }
}
