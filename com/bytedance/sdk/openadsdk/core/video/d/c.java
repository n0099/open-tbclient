package com.bytedance.sdk.openadsdk.core.video.d;

import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.component.video.a.c.a;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.e.b.i;
import com.bytedance.sdk.openadsdk.e.b.j;
import com.bytedance.sdk.openadsdk.e.b.l;
import com.bytedance.sdk.openadsdk.q.q;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(com.bytedance.sdk.openadsdk.n.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, bVar) == null) {
            a(bVar, null);
        }
    }

    public static void a(com.bytedance.sdk.openadsdk.n.f.b bVar, a.InterfaceC1895a interfaceC1895a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, bVar, interfaceC1895a) == null) {
            if (bVar.d() > 0 || bVar.j()) {
                k.b("VideoPreloadUtils", "preloadVideo: preload size = ", Integer.valueOf(bVar.d()));
                if (Build.VERSION.SDK_INT >= 23) {
                    m k = bVar.k();
                    AdSlot l = bVar.l();
                    if (k != null && l != null) {
                        com.bytedance.sdk.openadsdk.e.a.a.a(new com.bytedance.sdk.openadsdk.e.b.a(o.a(), k, q.b(l.getDurationSlotType()), com.bytedance.sdk.openadsdk.e.a.a.a(k, (String) null, -1), new com.bytedance.sdk.openadsdk.e.b.k(bVar.a(), bVar.j() ? bVar.i() : bVar.d())));
                    }
                    com.bytedance.sdk.component.video.b.a aVar = new com.bytedance.sdk.component.video.b.a();
                    aVar.b(bVar.b());
                    aVar.a(bVar.a());
                    aVar.b(bVar.d());
                    aVar.a(bVar.i());
                    aVar.a(bVar.j());
                    aVar.c(bVar.c());
                    aVar.b(6000);
                    aVar.c(6000);
                    aVar.d(6000);
                    com.bytedance.sdk.component.video.a.b.a.a(o.a(), aVar, new a.InterfaceC1895a(interfaceC1895a, k, l, bVar, SystemClock.elapsedRealtime()) { // from class: com.bytedance.sdk.openadsdk.core.video.d.c.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ a.InterfaceC1895a f67440a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ m f67441b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ AdSlot f67442c;

                        /* renamed from: d  reason: collision with root package name */
                        public final /* synthetic */ com.bytedance.sdk.openadsdk.n.f.b f67443d;

                        /* renamed from: e  reason: collision with root package name */
                        public final /* synthetic */ long f67444e;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {interfaceC1895a, k, l, bVar, Long.valueOf(r10)};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f67440a = interfaceC1895a;
                            this.f67441b = k;
                            this.f67442c = l;
                            this.f67443d = bVar;
                            this.f67444e = r10;
                        }

                        @Override // com.bytedance.sdk.component.video.a.c.a.InterfaceC1895a
                        public void a(com.bytedance.sdk.component.video.b.a aVar2, int i2) {
                            AdSlot adSlot;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeLI(1048576, this, aVar2, i2) == null) {
                                a.InterfaceC1895a interfaceC1895a2 = this.f67440a;
                                if (interfaceC1895a2 != null) {
                                    interfaceC1895a2.a(aVar2, i2);
                                }
                                if (this.f67441b == null || (adSlot = this.f67442c) == null) {
                                    return;
                                }
                                String b2 = q.b(adSlot.getDurationSlotType());
                                JSONObject a2 = com.bytedance.sdk.openadsdk.e.a.a.a(this.f67441b, (String) null, -1);
                                l lVar = new l();
                                lVar.a(this.f67443d.a());
                                lVar.a(this.f67443d.d());
                                lVar.b(SystemClock.elapsedRealtime() - this.f67444e);
                                if (aVar2.f() == 1) {
                                    lVar.c(1L);
                                } else {
                                    lVar.c(0L);
                                }
                                com.bytedance.sdk.openadsdk.e.a.a.b(new com.bytedance.sdk.openadsdk.e.b.a(o.a(), this.f67441b, b2, a2, lVar));
                            }
                        }

                        @Override // com.bytedance.sdk.component.video.a.c.a.InterfaceC1895a
                        public void b(com.bytedance.sdk.component.video.b.a aVar2, int i2) {
                            AdSlot adSlot;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeLI(Constants.METHOD_SEND_USER_MSG, this, aVar2, i2) == null) {
                                a.InterfaceC1895a interfaceC1895a2 = this.f67440a;
                                if (interfaceC1895a2 != null) {
                                    interfaceC1895a2.a(aVar2, i2);
                                }
                                if (this.f67441b == null || (adSlot = this.f67442c) == null) {
                                    return;
                                }
                                com.bytedance.sdk.openadsdk.e.a.a.d(new com.bytedance.sdk.openadsdk.e.b.a(o.a(), this.f67441b, q.b(adSlot.getDurationSlotType()), com.bytedance.sdk.openadsdk.e.a.a.a(this.f67441b, (String) null, -1), new i(this.f67443d.a(), this.f67443d.d())));
                            }
                        }

                        @Override // com.bytedance.sdk.component.video.a.c.a.InterfaceC1895a
                        public void a(com.bytedance.sdk.component.video.b.a aVar2, int i2, String str) {
                            AdSlot adSlot;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar2, i2, str) == null) {
                                a.InterfaceC1895a interfaceC1895a2 = this.f67440a;
                                if (interfaceC1895a2 != null) {
                                    interfaceC1895a2.a(aVar2, i2, str);
                                }
                                if (this.f67441b == null || (adSlot = this.f67442c) == null) {
                                    return;
                                }
                                String b2 = q.b(adSlot.getDurationSlotType());
                                JSONObject a2 = com.bytedance.sdk.openadsdk.e.a.a.a(this.f67441b, (String) null, -1);
                                j jVar = new j();
                                jVar.a(this.f67443d.a());
                                jVar.a(this.f67443d.d());
                                jVar.b(SystemClock.elapsedRealtime() - this.f67444e);
                                jVar.a(i2);
                                if (TextUtils.isEmpty(str)) {
                                    str = "";
                                }
                                jVar.b(str);
                                jVar.c("");
                                com.bytedance.sdk.openadsdk.e.a.a.c(new com.bytedance.sdk.openadsdk.e.b.a(o.a(), this.f67441b, b2, a2, jVar));
                            }
                        }
                    });
                    return;
                }
                com.bytedance.sdk.openadsdk.n.f.a.a().a(bVar);
            }
        }
    }
}
