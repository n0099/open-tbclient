package com.bytedance.sdk.component.b.b.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.b.b.a.b.g;
import com.bytedance.sdk.component.b.b.ab;
import com.bytedance.sdk.component.b.b.ad;
import com.bytedance.sdk.component.b.b.j;
import com.bytedance.sdk.component.b.b.k;
import com.bytedance.sdk.component.b.b.s;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
/* loaded from: classes5.dex */
public abstract class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static a f28146a;
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

    public abstract int a(ab.a aVar);

    public abstract com.bytedance.sdk.component.b.b.a.b.c a(j jVar, com.bytedance.sdk.component.b.b.a aVar, g gVar, ad adVar);

    public abstract com.bytedance.sdk.component.b.b.a.b.d a(j jVar);

    public abstract Socket a(j jVar, com.bytedance.sdk.component.b.b.a aVar, g gVar);

    public abstract void a(k kVar, SSLSocket sSLSocket, boolean z);

    public abstract void a(s.a aVar, String str);

    public abstract void a(s.a aVar, String str, String str2);

    public abstract boolean a(com.bytedance.sdk.component.b.b.a aVar, com.bytedance.sdk.component.b.b.a aVar2);

    public abstract boolean a(j jVar, com.bytedance.sdk.component.b.b.a.b.c cVar);

    public abstract void b(j jVar, com.bytedance.sdk.component.b.b.a.b.c cVar);
}
