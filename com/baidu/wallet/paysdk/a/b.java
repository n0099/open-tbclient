package com.baidu.wallet.paysdk.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.ui.PayTypeActivity;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.wallet.core.utils.BaiduWalletUtils;
import java.util.List;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? !TextUtils.isEmpty(PayDataCache.getInstance().getPureSign()) : invokeV.booleanValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? "1".equals(PayDataCache.getInstance().getPureSign()) : invokeV.booleanValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? "0".equals(PayDataCache.getInstance().getPureSign()) : invokeV.booleanValue;
    }

    public static void a(List<RestNameValuePair> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, list) == null) || list == null) {
            return;
        }
        list.add(new RestNameValuePair("pure_sign", PayDataCache.getInstance().getPureSign()));
    }

    public static void a(Context context, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, context, aVar) == null) {
            a = aVar;
            Intent intent = new Intent();
            intent.setClass(context, PayTypeActivity.class);
            if (!BaiduWalletUtils.isActivity(context)) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
        }
    }
}
