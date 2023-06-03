package com.baidu.tieba;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.common.others.url.UrlUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BdToken.BdUniDispatchSchemeController;
import com.baidu.tbadk.browser.BaseWebViewActivity;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.atomData.WebViewActivityConfig;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.PvThread;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.HashMap;
/* loaded from: classes6.dex */
public final class lz4 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean n;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public String b;
    public String c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public Bundle l;
    public HashMap<String, Serializable> m;

    public lz4(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = "";
        this.d = true;
        this.e = true;
        this.f = true;
        this.g = true;
        this.h = true;
        this.i = false;
        this.j = false;
        this.k = false;
        this.l = null;
        this.m = null;
        this.a = context;
        this.b = str;
    }

    public static TbWebViewActivityConfig e(Context context, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, Bundle bundle, HashMap<String, Serializable> hashMap) {
        InterceptResult invokeCommon;
        boolean z9;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{context, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5), Boolean.valueOf(z6), Boolean.valueOf(z7), Boolean.valueOf(z8), bundle, hashMap})) == null) {
            n();
            try {
                if (StringUtils.isNull(str2)) {
                    return null;
                }
                if (!UrlUtils.isBaiduDomain(str2)) {
                    z9 = false;
                } else {
                    z9 = z5;
                }
                if (bundle != null && !bundle.getBoolean(BaseWebViewActivity.BUNDLE_NEED_EXTRA_PARAM, true)) {
                    z9 = false;
                }
                if (z9) {
                    str3 = qx4.c(qx4.f(qx4.d(str2)));
                } else {
                    str3 = str2;
                }
                TbWebViewActivityConfig i = qx4.i(context, str, str3, z, z2, z3, !hm6.b(hashMap));
                i.setNeedImmerSiveSticky(z6);
                i.setFixTitle(z7);
                i.setAutoPlay(z8);
                i.setBundle(bundle);
                if (!hm6.b(hashMap)) {
                    i.setPageData(hashMap);
                }
                if (bundle != null) {
                    if (bundle.getBoolean(WebViewActivityConfig.TAG_TEXT_AUTO_SIZE, false)) {
                        i.setTextAutoSize(true);
                    }
                    String string = bundle.getString(WebViewActivityConfig.TAG_PAGE_TRANSLUCENT, "");
                    if (!TextUtils.isEmpty(string)) {
                        i.setPageTranslucent(string);
                    }
                    if (bundle.getBoolean(WebViewActivityConfig.TAG_TRANSLUCENT_AUTO_CLOSE, false)) {
                        i.setTranslucentAutoClose(true);
                    }
                    String string2 = bundle.getString(WebViewActivityConfig.TAG_WEB_DIALOG_NAME, "");
                    if (!TextUtils.isEmpty(string2)) {
                        i.setWebDialogName(string2);
                    }
                    if ("1".equals(bundle.getString(BdUniDispatchSchemeController.PARAM_OPEN_TYPE))) {
                        i.setPageTranslucent(TbWebViewActivityConfig.PAGE_TYPE_BLACK_TRANSLUCENT);
                        i.setLoadingSwitch(1);
                        i.setLoadingStyle(1);
                    }
                }
                if (n) {
                    i.setUseCustomHistoryStack(true);
                    n = false;
                }
                if (bundle != null && bundle.getBoolean(WebViewActivityConfig.FROM_SCHEMA)) {
                    i.setIsFromSchema(true);
                }
                return i;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }
        return (TbWebViewActivityConfig) invokeCommon.objValue;
    }

    public static lz4 j(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            return new lz4(context, str);
        }
        return (lz4) invokeLL.objValue;
    }

    public static void n() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65539, null) != null) || !PermissionUtil.isAgreePrivacyPolicy()) {
            return;
        }
        new PvThread("open_webview", true).start();
    }

    public TbWebViewActivityConfig b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return e(this.a, this.c, this.b, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m);
        }
        return (TbWebViewActivityConfig) invokeV.objValue;
    }

    public lz4 a(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundle)) == null) {
            this.l = bundle;
            if (bundle != null) {
                String string = bundle.getString(BdUniDispatchSchemeController.PARAM_INIT_DATA, "");
                if (!TextUtils.isEmpty(string)) {
                    if (this.m == null) {
                        this.m = new HashMap<>();
                    }
                    this.m.put(BdUniDispatchSchemeController.PARAM_INIT_DATA, string);
                }
            }
            return this;
        }
        return (lz4) invokeL.objValue;
    }

    public lz4 c(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
            this.f = z;
            return this;
        }
        return (lz4) invokeZ.objValue;
    }

    public lz4 d(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
            this.j = z;
            return this;
        }
        return (lz4) invokeZ.objValue;
    }

    public lz4 f(HashMap<String, Serializable> hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, hashMap)) == null) {
            this.m = hashMap;
            return this;
        }
        return (lz4) invokeL.objValue;
    }

    public lz4 g(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
            this.h = z;
            return this;
        }
        return (lz4) invokeZ.objValue;
    }

    public lz4 h(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
            this.k = z;
            return this;
        }
        return (lz4) invokeZ.objValue;
    }

    public lz4 i(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
            this.g = z;
            return this;
        }
        return (lz4) invokeZ.objValue;
    }

    public lz4 k(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z)) == null) {
            this.e = z;
            return this;
        }
        return (lz4) invokeZ.objValue;
    }

    public lz4 l(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048585, this, z)) == null) {
            this.i = z;
            return this;
        }
        return (lz4) invokeZ.objValue;
    }

    public lz4 m(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048586, this, z)) == null) {
            this.d = z;
            return this;
        }
        return (lz4) invokeZ.objValue;
    }

    public lz4 p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            this.c = str;
            return this;
        }
        return (lz4) invokeL.objValue;
    }

    public void o() {
        TbWebViewActivityConfig e;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (e = e(this.a, this.c, this.b, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m)) != null) {
            e.start();
        }
    }
}
