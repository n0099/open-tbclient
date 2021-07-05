package com.baidu.wallet.core;

import android.content.Context;
import android.net.http.HttpResponseCache;
import com.baidu.mobstat.Config;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.utils.LogUtil;
import java.io.File;
import java.io.IOException;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f24556a = "HttpCache";
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, context) == null) {
            try {
                HttpResponseCache.install(new File(context.getCacheDir(), "http"), Config.FULL_TRACE_LOG_LIMIT);
            } catch (IOException e2) {
                LogUtil.i(f24556a, "HTTP response cache installation failed:" + e2);
            }
        }
    }

    public static void a() {
        HttpResponseCache installed;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, null) == null) || (installed = HttpResponseCache.getInstalled()) == null) {
            return;
        }
        installed.flush();
    }
}
