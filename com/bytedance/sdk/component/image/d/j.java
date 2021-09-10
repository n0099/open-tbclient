package com.bytedance.sdk.component.image.d;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.image.IHttpClient;
import com.bytedance.sdk.component.image.ResultType;
/* loaded from: classes9.dex */
public class j extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public j() {
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

    @Override // com.bytedance.sdk.component.image.d.h
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "net_request" : (String) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.component.image.d.h
    public void a(com.bytedance.sdk.component.image.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            com.bytedance.sdk.component.image.c.b a2 = com.bytedance.sdk.component.image.c.b.a();
            IHttpClient e2 = a2.e();
            aVar.a(false);
            try {
                com.bytedance.sdk.component.image.b.d call = e2.call(new com.bytedance.sdk.component.image.b.c(aVar.a(), aVar.k(), aVar.l()));
                int b2 = call.b();
                aVar.a(call.a());
                if (call.b() == 200) {
                    byte[] bArr = (byte[]) call.c();
                    boolean a3 = a(bArr);
                    if (aVar.j() != ResultType.RAW && !a3) {
                        aVar.a(new d(bArr, call));
                        a2.g().submit(new Runnable(this, aVar, a3, a2, bArr) { // from class: com.bytedance.sdk.component.image.d.j.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ com.bytedance.sdk.component.image.c.a f65226a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ boolean f65227b;

                            /* renamed from: c  reason: collision with root package name */
                            public final /* synthetic */ com.bytedance.sdk.component.image.c.b f65228c;

                            /* renamed from: d  reason: collision with root package name */
                            public final /* synthetic */ byte[] f65229d;

                            /* renamed from: e  reason: collision with root package name */
                            public final /* synthetic */ j f65230e;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, aVar, Boolean.valueOf(a3), a2, bArr};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f65230e = this;
                                this.f65226a = aVar;
                                this.f65227b = a3;
                                this.f65228c = a2;
                                this.f65229d = bArr;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    String d2 = this.f65226a.d();
                                    if (this.f65226a.b().f65178a && (this.f65227b || this.f65226a.j() == ResultType.RAW)) {
                                        this.f65228c.c().a(d2, this.f65229d);
                                    }
                                    if (this.f65226a.b().f65179b) {
                                        this.f65228c.d().a(d2, this.f65229d);
                                    }
                                }
                            }
                        });
                        return;
                    }
                    aVar.a(new l(bArr, call, a3));
                    a2.g().submit(new Runnable(this, aVar, a3, a2, bArr) { // from class: com.bytedance.sdk.component.image.d.j.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ com.bytedance.sdk.component.image.c.a f65226a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ boolean f65227b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ com.bytedance.sdk.component.image.c.b f65228c;

                        /* renamed from: d  reason: collision with root package name */
                        public final /* synthetic */ byte[] f65229d;

                        /* renamed from: e  reason: collision with root package name */
                        public final /* synthetic */ j f65230e;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = objArr;
                                Object[] objArr = {this, aVar, Boolean.valueOf(a3), a2, bArr};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f65230e = this;
                            this.f65226a = aVar;
                            this.f65227b = a3;
                            this.f65228c = a2;
                            this.f65229d = bArr;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                String d2 = this.f65226a.d();
                                if (this.f65226a.b().f65178a && (this.f65227b || this.f65226a.j() == ResultType.RAW)) {
                                    this.f65228c.c().a(d2, this.f65229d);
                                }
                                if (this.f65226a.b().f65179b) {
                                    this.f65228c.d().a(d2, this.f65229d);
                                }
                            }
                        }
                    });
                    return;
                }
                com.bytedance.sdk.component.image.c.c.a(String.valueOf(call));
                Object c2 = call.c();
                a(b2, call.d(), c2 instanceof Throwable ? (Throwable) c2 : null, aVar);
            } catch (Throwable th) {
                a(1004, "net request failed!", th, aVar);
            }
        }
    }

    public static boolean a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) ? bArr != null && bArr.length >= 3 && bArr[0] == 71 && bArr[1] == 73 && bArr[2] == 70 : invokeL.booleanValue;
    }

    private void a(int i2, String str, Throwable th, com.bytedance.sdk.component.image.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, this, new Object[]{Integer.valueOf(i2), str, th, aVar}) == null) {
            aVar.a(new g(i2, str, th));
        }
    }
}
