package com.baidu.ufosdk;

import android.text.TextUtils;
import com.baidu.browser.sailor.platform.BdSailorPlatform;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.sdk.WebViewFactory;
/* loaded from: classes8.dex */
public class q1 {
    public static /* synthetic */ Interceptable $ic = null;
    public static int a = 600;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (!TextUtils.equals("com.baidu.searchbox", c.a()) && !TextUtils.equals(BdSailorPlatform.LITE_PACKAGE_NAME, c.a()) && !TextUtils.equals("com.baidu.searchbox.tomas", c.a()) && !TextUtils.equals("com.baidu.searchbox.vision", c.a()) && !TextUtils.equals(WebViewFactory.CHROMIUM_HOST_APP, c.a()) && !TextUtils.equals("com.baidu.hao123", c.a())) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
