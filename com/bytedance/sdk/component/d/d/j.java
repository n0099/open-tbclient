package com.bytedance.sdk.component.d.d;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.d.p;
/* loaded from: classes6.dex */
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

    @Override // com.bytedance.sdk.component.d.d.h
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "net_request" : (String) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.component.d.d.h
    public void a(com.bytedance.sdk.component.d.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            com.bytedance.sdk.component.d.c.b a2 = com.bytedance.sdk.component.d.c.b.a();
            com.bytedance.sdk.component.d.c e2 = a2.e();
            aVar.a(false);
            try {
                com.bytedance.sdk.component.d.b.d a3 = e2.a(new com.bytedance.sdk.component.d.b.c(aVar.a(), aVar.k()));
                int a4 = a3.a();
                if (a3.a() == 200) {
                    byte[] bArr = (byte[]) a3.b();
                    boolean a5 = a(bArr);
                    if (aVar.j() != p.f28730b && !a5) {
                        aVar.a(new d(bArr, a3));
                        a2.g().submit(new Runnable(this, aVar, a5, a2, bArr) { // from class: com.bytedance.sdk.component.d.d.j.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ com.bytedance.sdk.component.d.c.a f28693a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ boolean f28694b;

                            /* renamed from: c  reason: collision with root package name */
                            public final /* synthetic */ com.bytedance.sdk.component.d.c.b f28695c;

                            /* renamed from: d  reason: collision with root package name */
                            public final /* synthetic */ byte[] f28696d;

                            /* renamed from: e  reason: collision with root package name */
                            public final /* synthetic */ j f28697e;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, aVar, Boolean.valueOf(a5), a2, bArr};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f28697e = this;
                                this.f28693a = aVar;
                                this.f28694b = a5;
                                this.f28695c = a2;
                                this.f28696d = bArr;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    String d2 = this.f28693a.d();
                                    if (this.f28693a.b().f28656a && (this.f28694b || this.f28693a.j() == p.f28730b)) {
                                        this.f28695c.c().a(d2, this.f28696d);
                                    }
                                    if (this.f28693a.b().f28657b) {
                                        this.f28695c.d().a(d2, this.f28696d);
                                    }
                                }
                            }
                        });
                        return;
                    }
                    aVar.a(new l(bArr, a3, a5));
                    a2.g().submit(new Runnable(this, aVar, a5, a2, bArr) { // from class: com.bytedance.sdk.component.d.d.j.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ com.bytedance.sdk.component.d.c.a f28693a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ boolean f28694b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ com.bytedance.sdk.component.d.c.b f28695c;

                        /* renamed from: d  reason: collision with root package name */
                        public final /* synthetic */ byte[] f28696d;

                        /* renamed from: e  reason: collision with root package name */
                        public final /* synthetic */ j f28697e;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = objArr;
                                Object[] objArr = {this, aVar, Boolean.valueOf(a5), a2, bArr};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f28697e = this;
                            this.f28693a = aVar;
                            this.f28694b = a5;
                            this.f28695c = a2;
                            this.f28696d = bArr;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                String d2 = this.f28693a.d();
                                if (this.f28693a.b().f28656a && (this.f28694b || this.f28693a.j() == p.f28730b)) {
                                    this.f28695c.c().a(d2, this.f28696d);
                                }
                                if (this.f28693a.b().f28657b) {
                                    this.f28695c.d().a(d2, this.f28696d);
                                }
                            }
                        }
                    });
                    return;
                }
                com.bytedance.sdk.component.d.c.c.a(String.valueOf(a3));
                Object b2 = a3.b();
                a(a4, a3.c(), b2 instanceof Throwable ? (Throwable) b2 : null, aVar);
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

    private void a(int i2, String str, Throwable th, com.bytedance.sdk.component.d.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, this, new Object[]{Integer.valueOf(i2), str, th, aVar}) == null) {
            aVar.a(new g(i2, str, th));
        }
    }
}
