package com.bytedance.sdk.openadsdk.core.widget.webview.a;

import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.d.g;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.e.u;
import com.bytedance.sdk.openadsdk.core.e.v;
import com.bytedance.sdk.openadsdk.core.widget.webview.a.e;
import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Set;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Object f67765a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2180914, "Lcom/bytedance/sdk/openadsdk/core/widget/webview/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2180914, "Lcom/bytedance/sdk/openadsdk/core/widget/webview/a/a;");
                return;
            }
        }
        f67765a = new Object();
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            b.a();
            d.a();
        }
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            try {
                f.d();
                File e2 = b.e();
                if (e2 == null || !e2.exists()) {
                    return;
                }
                if (e2.getParentFile() != null) {
                    com.bytedance.sdk.component.utils.f.c(e2.getParentFile());
                } else {
                    com.bytedance.sdk.component.utils.f.c(e2);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? c.c() : (String) invokeV.objValue;
    }

    public static v d(m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, mVar)) == null) {
            if (mVar == null || mVar.Q() == null) {
                return null;
            }
            v a2 = d.a().a(mVar.Q().b());
            if (a2 != null) {
                a2.a(Long.valueOf(System.currentTimeMillis()));
                a(a2);
            }
            return a2;
        }
        return (v) invokeL.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            if (d() == null) {
                return null;
            }
            return d().c();
        }
        return (String) invokeV.objValue;
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? b.a().b() : invokeV.booleanValue;
    }

    public static v c(m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, mVar)) == null) {
            if (mVar == null || mVar.P() == null) {
                return null;
            }
            v a2 = d.a().a(mVar.P().b());
            if (a2 != null) {
                a2.a(Long.valueOf(System.currentTimeMillis()));
                a(a2);
            }
            return a2;
        }
        return (v) invokeL.objValue;
    }

    public static void a(m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, mVar) == null) {
            d.a().a(mVar);
        }
    }

    public static v a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? d.a().a(str) : (v) invokeL.objValue;
    }

    public static void a(v vVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, vVar) == null) {
            com.bytedance.sdk.component.d.e.a(new g("updateTmplTime", vVar) { // from class: com.bytedance.sdk.openadsdk.core.widget.webview.a.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ v f67766a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r7);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r7, vVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super((String) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f67766a = vVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        synchronized (a.f67765a) {
                            c.a().a(this.f67766a);
                        }
                    }
                }
            }, 10);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x005e, code lost:
        if (r2.b().equals(r6) != false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static WebResourceResponse a(String str, e.a aVar, String str2) {
        InterceptResult invokeLLL;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, str, aVar, str2)) == null) {
            if (f()) {
                Iterator<u.a> it = d().e().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    u.a next = it.next();
                    if (next.a() != null && next.a().equals(str)) {
                        String a2 = com.bytedance.sdk.component.utils.e.a(next.a());
                        if (TextUtils.isEmpty(str2)) {
                            str2 = a2;
                        }
                        file = new File(b.e(), str2);
                        String a3 = com.bytedance.sdk.component.utils.e.a(file);
                        if (next.b() != null) {
                        }
                    }
                }
            }
            file = null;
            if (file != null) {
                try {
                    return new WebResourceResponse(aVar.a(), "utf-8", new FileInputStream(file));
                } catch (Throwable th) {
                    k.c("TTDynamic", "get html WebResourceResponse error", th);
                    return null;
                }
            }
            return null;
        }
        return (WebResourceResponse) invokeLLL.objValue;
    }

    public static u d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? b.a().c() : (u) invokeV.objValue;
    }

    public static void b(m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, mVar) == null) {
            d.a().b(mVar);
        }
    }

    public static Set<String> b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) ? d.a().b(str) : (Set) invokeL.objValue;
    }
}
