package com.baidu.tieba;

import android.app.Activity;
import android.webkit.URLUtil;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ll6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Activity activity, String str, boolean z, boolean z2) {
        sm6 sm6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{activity, str, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if ((URLUtil.isNetworkUrl(str) || URLUtil.isFileUrl(str) || URLUtil.isAssetUrl(str)) && (sm6Var = (sm6) ServiceManager.getService(sm6.a)) != null) {
                sm6Var.a(activity, str, z, z2);
            }
        }
    }
}
