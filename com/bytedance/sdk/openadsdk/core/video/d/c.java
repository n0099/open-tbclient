package com.bytedance.sdk.openadsdk.core.video.d;

import android.os.Build;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.j;
import com.bytedance.sdk.component.video.a.c.a;
import com.bytedance.sdk.openadsdk.core.o;
/* loaded from: classes5.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(com.bytedance.sdk.openadsdk.o.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, bVar) == null) {
            a(bVar, null);
        }
    }

    public static void a(com.bytedance.sdk.openadsdk.o.f.b bVar, a.InterfaceC0325a interfaceC0325a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, bVar, interfaceC0325a) == null) {
            if (bVar.c() > 0 || bVar.j()) {
                j.b("VideoPreloadUtils", "preloadVideo: preload size = ", Integer.valueOf(bVar.c()));
                if (Build.VERSION.SDK_INT >= 23) {
                    com.bytedance.sdk.component.video.b.a aVar = new com.bytedance.sdk.component.video.b.a();
                    aVar.b(bVar.b());
                    aVar.a(bVar.a());
                    aVar.b(bVar.c());
                    aVar.a(bVar.i());
                    aVar.a(bVar.j());
                    aVar.c(bVar.d());
                    aVar.b(6000);
                    aVar.c(6000);
                    aVar.d(6000);
                    com.bytedance.sdk.component.video.a.b.a.a(o.a(), aVar, new a.InterfaceC0325a(interfaceC0325a) { // from class: com.bytedance.sdk.openadsdk.core.video.d.c.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ a.InterfaceC0325a f30647a;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {interfaceC0325a};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f30647a = interfaceC0325a;
                        }

                        @Override // com.bytedance.sdk.component.video.a.c.a.InterfaceC0325a
                        public void a(com.bytedance.sdk.component.video.b.a aVar2, int i2) {
                            a.InterfaceC0325a interfaceC0325a2;
                            Interceptable interceptable2 = $ic;
                            if (!(interceptable2 == null || interceptable2.invokeLI(1048576, this, aVar2, i2) == null) || (interfaceC0325a2 = this.f30647a) == null) {
                                return;
                            }
                            interfaceC0325a2.a(aVar2, i2);
                        }

                        @Override // com.bytedance.sdk.component.video.a.c.a.InterfaceC0325a
                        public void b(com.bytedance.sdk.component.video.b.a aVar2, int i2) {
                            a.InterfaceC0325a interfaceC0325a2;
                            Interceptable interceptable2 = $ic;
                            if (!(interceptable2 == null || interceptable2.invokeLI(Constants.METHOD_SEND_USER_MSG, this, aVar2, i2) == null) || (interfaceC0325a2 = this.f30647a) == null) {
                                return;
                            }
                            interfaceC0325a2.a(aVar2, i2);
                        }

                        @Override // com.bytedance.sdk.component.video.a.c.a.InterfaceC0325a
                        public void a(com.bytedance.sdk.component.video.b.a aVar2, int i2, String str) {
                            a.InterfaceC0325a interfaceC0325a2;
                            Interceptable interceptable2 = $ic;
                            if (!(interceptable2 == null || interceptable2.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar2, i2, str) == null) || (interfaceC0325a2 = this.f30647a) == null) {
                                return;
                            }
                            interfaceC0325a2.a(aVar2, i2, str);
                        }
                    });
                    return;
                }
                com.bytedance.sdk.openadsdk.o.f.a.a().a(bVar);
            }
        }
    }
}
