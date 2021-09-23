package com.bytedance.sdk.component.video.a.b;

import android.content.Context;
import android.os.Build;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.sdk.component.b.b.w;
import com.bytedance.sdk.component.video.a.c.a;
import com.bytedance.sdk.component.video.d.c;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final ConcurrentHashMap<String, com.bytedance.sdk.component.video.a.c.a> f65589a;

    /* renamed from: b  reason: collision with root package name */
    public static w f65590b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(438073358, "Lcom/bytedance/sdk/component/video/a/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(438073358, "Lcom/bytedance/sdk/component/video/a/b/a;");
                return;
            }
        }
        f65589a = new ConcurrentHashMap<>();
        f65590b = null;
    }

    public static synchronized void a(Context context, com.bytedance.sdk.component.video.b.a aVar, a.InterfaceC1895a interfaceC1895a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, context, aVar, interfaceC1895a) == null) {
            synchronized (a.class) {
                if (aVar != null) {
                    if (aVar.a()) {
                        if (Build.VERSION.SDK_INT >= 23) {
                            com.bytedance.sdk.component.video.a.c.a aVar2 = f65589a.get(aVar.c());
                            if (aVar2 == null) {
                                aVar2 = new com.bytedance.sdk.component.video.a.c.a(context, aVar);
                                f65589a.put(aVar.c(), aVar2);
                                c.b("VideoFileManager", "preloadVideo:  cache size = ", Long.valueOf(aVar.e()), aVar.c());
                            }
                            aVar2.a(interfaceC1895a);
                        }
                        c.b("VideoFileManager", "preloadVideo:  cache size = ", Long.valueOf(aVar.e()), aVar.c());
                        return;
                    }
                }
                c.a(" url、dir and hash is must property   in VideoInfoModel");
            }
        }
    }

    public static synchronized void a(com.bytedance.sdk.component.video.b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, aVar) == null) {
            synchronized (a.class) {
                if (Build.VERSION.SDK_INT >= 23) {
                    com.bytedance.sdk.component.video.a.c.a remove = f65589a.remove(aVar.c());
                    if (remove != null) {
                        remove.a(true);
                    }
                    c.b("VideoFileManager", "removePreload:  cache size = ", Long.valueOf(aVar.e()), aVar.c());
                }
            }
        }
    }
}
