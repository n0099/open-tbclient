package com.bytedance.sdk.openadsdk.downloadnew;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.p.a.d.b.a.a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.downloadnew.a.b;
import com.bytedance.sdk.openadsdk.downloadnew.a.c;
import com.bytedance.sdk.openadsdk.downloadnew.a.d;
import com.bytedance.sdk.openadsdk.downloadnew.a.e;
import com.bytedance.sdk.openadsdk.downloadnew.a.g;
import com.bytedance.sdk.openadsdk.downloadnew.core.ExitInstallListener;
import com.bytedance.sdk.openadsdk.q.q;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static com.bytedance.sdk.openadsdk.downloadnew.core.a a(Context context, m mVar, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, context, mVar, str)) == null) {
            if (q.k(context)) {
                return new d(context, mVar, str);
            }
            return new b(context, mVar, str);
        }
        return (com.bytedance.sdk.openadsdk.downloadnew.core.a) invokeLLL.objValue;
    }

    public static com.bytedance.sdk.openadsdk.downloadnew.core.b b(Context context, m mVar, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, mVar, str)) == null) {
            if (q.k(context)) {
                return new c(context, mVar, str);
            }
            return new com.bytedance.sdk.openadsdk.downloadnew.a.a(context, mVar, str);
        }
        return (com.bytedance.sdk.openadsdk.downloadnew.core.b) invokeLLL.objValue;
    }

    public static com.bytedance.sdk.openadsdk.downloadnew.core.a a(Context context, String str, m mVar, String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, null, context, str, mVar, str2)) == null) ? new e(context, str, mVar, str2) : (com.bytedance.sdk.openadsdk.downloadnew.core.a) invokeLLLL.objValue;
    }

    public static boolean a(Activity activity, ExitInstallListener exitInstallListener) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, activity, exitInstallListener)) == null) ? c.p.a.d.b.a.a.a().h(activity, false, new a.b(exitInstallListener) { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ ExitInstallListener f67215a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {exitInstallListener};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f67215a = exitInstallListener;
            }

            @Override // c.p.a.d.b.a.a.b
            public void a() {
                ExitInstallListener exitInstallListener2;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (exitInstallListener2 = this.f67215a) == null) {
                    return;
                }
                exitInstallListener2.onExitInstall();
            }
        }) : invokeLL.booleanValue;
    }

    @NonNull
    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            try {
                return g.d().q();
            } catch (Exception e2) {
                k.a("TTDownloadFactory", "get download sdk version error", e2);
                return "0.0.0";
            }
        }
        return (String) invokeV.objValue;
    }
}
