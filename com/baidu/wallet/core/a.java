package com.baidu.wallet.core;

import android.content.Context;
import android.net.http.HttpResponseCache;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.utils.LogUtil;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f61069a = "HttpCache";
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
                if (context == null) {
                    LogUtil.i(f61069a, "HTTP response cache installation failed, context is null");
                } else if (HttpResponseCache.getInstalled() == null) {
                    new URL("https://www.duxiaoman.com/index").openConnection().setDefaultUseCaches(false);
                    HttpResponseCache.install(new File(context.getCacheDir(), "http"), 10485760L);
                }
            } catch (MalformedURLException unused) {
            } catch (IOException e2) {
                LogUtil.i(f61069a, "HTTP response cache installation failed:" + e2);
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
