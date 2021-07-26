package com.bytedance.sdk.openadsdk.core;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTSecAbs;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class s {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile s f30699a;

    /* renamed from: b  reason: collision with root package name */
    public static com.bytedance.sdk.openadsdk.core.i.b f30700b;

    /* renamed from: d  reason: collision with root package name */
    public static String f30701d;

    /* renamed from: e  reason: collision with root package name */
    public static volatile String f30702e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f30703c;

    /* renamed from: f  reason: collision with root package name */
    public volatile AtomicBoolean f30704f;

    /* renamed from: g  reason: collision with root package name */
    public String f30705g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(210335075, "Lcom/bytedance/sdk/openadsdk/core/s;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(210335075, "Lcom/bytedance/sdk/openadsdk/core/s;");
        }
    }

    public s() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f30703c = false;
        this.f30704f = new AtomicBoolean(false);
        this.f30705g = null;
        if (e() == null) {
            f30700b = com.bytedance.sdk.openadsdk.core.i.d.a();
        }
    }

    private TTSecAbs e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) ? h.d().r() : (TTSecAbs) invokeV.objValue;
    }

    public void b(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            com.bytedance.sdk.openadsdk.core.i.b bVar = f30700b;
            if (bVar != null) {
                bVar.b(str);
            }
            if (this.f30703c || e() == null) {
                return;
            }
            e().NM_reportNow(str);
            this.f30703c = true;
        }
    }

    private boolean d(String str) {
        InterceptResult invokeL;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, str)) == null) {
            if (TextUtils.isEmpty(str) || (split = str.split(":")) == null || split.length < 20) {
                return false;
            }
            for (String str2 : split) {
                if (!"00".equals(str2)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.i.b bVar = f30700b;
        if (bVar != null) {
            bVar.a(str);
        }
        f30701d = str;
        if (e() != null) {
            e().NM_setParams(str);
        }
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            try {
                if (!TextUtils.isEmpty(this.f30705g)) {
                    return this.f30705g;
                }
                String a2 = h.a("sdk_app_sha1", 2592000000L);
                this.f30705g = a2;
                if (!TextUtils.isEmpty(a2)) {
                    return this.f30705g;
                }
                if (e() != null) {
                    this.f30705g = e().NM_pullSg();
                } else if (f30700b != null) {
                    this.f30705g = f30700b.a();
                }
                if (d(this.f30705g)) {
                    String upperCase = this.f30705g.toUpperCase();
                    this.f30705g = upperCase;
                    h.a("sdk_app_sha1", upperCase);
                    return this.f30705g;
                }
                String a3 = com.bytedance.sdk.component.utils.c.a(o.a());
                this.f30705g = a3;
                if (d(a3)) {
                    String upperCase2 = this.f30705g.toUpperCase();
                    this.f30705g = upperCase2;
                    h.a("sdk_app_sha1", upperCase2);
                    return this.f30705g;
                }
                return "";
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (f30702e != null) {
                return f30702e;
            }
            if (this.f30704f.compareAndSet(false, true)) {
                try {
                    com.bytedance.sdk.component.d.e.a(new com.bytedance.sdk.component.d.g(this, "getSecdid") { // from class: com.bytedance.sdk.openadsdk.core.s.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ s f30706a;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(r8);
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, r8};
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
                            this.f30706a = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                if (s.f30700b != null) {
                                    String b2 = s.f30700b.b();
                                    if (!TextUtils.isEmpty(b2)) {
                                        String unused = s.f30702e = b2;
                                    }
                                }
                                this.f30706a.f30704f.set(false);
                            }
                        }
                    });
                    return "";
                } catch (Throwable unused) {
                    this.f30704f.set(false);
                    return "";
                }
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public static s a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f30699a == null) {
                synchronized (s.class) {
                    if (f30699a == null) {
                        f30699a = new s();
                    }
                }
            }
            return f30699a;
        }
        return (s) invokeV.objValue;
    }

    public Map<String, String> a(String str, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, bArr)) == null) {
            if (e() != null) {
                return e().NM_ssSign(str, bArr);
            }
            com.bytedance.sdk.openadsdk.core.i.b bVar = f30700b;
            if (bVar != null) {
                return bVar.a(str, bArr);
            }
            return new HashMap();
        }
        return (Map) invokeLL.objValue;
    }
}
