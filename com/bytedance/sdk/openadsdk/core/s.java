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
/* loaded from: classes9.dex */
public class s {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile s f67349a;

    /* renamed from: b  reason: collision with root package name */
    public static com.bytedance.sdk.openadsdk.core.i.b f67350b;

    /* renamed from: d  reason: collision with root package name */
    public static String f67351d;

    /* renamed from: e  reason: collision with root package name */
    public static volatile String f67352e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f67353c;

    /* renamed from: f  reason: collision with root package name */
    public volatile AtomicBoolean f67354f;

    /* renamed from: g  reason: collision with root package name */
    public String f67355g;

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
        this.f67353c = false;
        this.f67354f = new AtomicBoolean(false);
        this.f67355g = null;
        if (e() == null) {
            f67350b = com.bytedance.sdk.openadsdk.core.i.d.a();
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
            com.bytedance.sdk.openadsdk.core.i.b bVar = f67350b;
            if (bVar != null) {
                bVar.b(str);
            }
            if (this.f67353c || e() == null) {
                return;
            }
            e().NM_reportNow(str);
            this.f67353c = true;
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
        com.bytedance.sdk.openadsdk.core.i.b bVar = f67350b;
        if (bVar != null) {
            bVar.a(str);
        }
        f67351d = str;
        if (e() != null) {
            e().NM_setParams(str);
        }
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            try {
                if (!TextUtils.isEmpty(this.f67355g)) {
                    return this.f67355g;
                }
                String a2 = h.a("sdk_app_sha1", 2592000000L);
                this.f67355g = a2;
                if (!TextUtils.isEmpty(a2)) {
                    return this.f67355g;
                }
                if (e() != null) {
                    this.f67355g = e().NM_pullSg();
                } else if (f67350b != null) {
                    this.f67355g = f67350b.a();
                }
                if (d(this.f67355g)) {
                    String upperCase = this.f67355g.toUpperCase();
                    this.f67355g = upperCase;
                    h.a("sdk_app_sha1", upperCase);
                    return this.f67355g;
                }
                String a3 = com.bytedance.sdk.component.utils.c.a(o.a());
                this.f67355g = a3;
                if (d(a3)) {
                    String upperCase2 = this.f67355g.toUpperCase();
                    this.f67355g = upperCase2;
                    h.a("sdk_app_sha1", upperCase2);
                    return this.f67355g;
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
            if (f67352e != null) {
                return f67352e;
            }
            if (this.f67354f.compareAndSet(false, true)) {
                try {
                    com.bytedance.sdk.component.d.e.a(new com.bytedance.sdk.component.d.g(this, "getSecdid") { // from class: com.bytedance.sdk.openadsdk.core.s.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ s f67356a;

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
                            this.f67356a = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                if (s.f67350b != null) {
                                    String b2 = s.f67350b.b();
                                    if (!TextUtils.isEmpty(b2)) {
                                        String unused = s.f67352e = b2;
                                    }
                                }
                                this.f67356a.f67354f.set(false);
                            }
                        }
                    });
                    return "";
                } catch (Throwable unused) {
                    this.f67354f.set(false);
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
            if (f67349a == null) {
                synchronized (s.class) {
                    if (f67349a == null) {
                        f67349a = new s();
                    }
                }
            }
            return f67349a;
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
            com.bytedance.sdk.openadsdk.core.i.b bVar = f67350b;
            if (bVar != null) {
                return bVar.a(str, bArr);
            }
            return new HashMap();
        }
        return (Map) invokeLL.objValue;
    }
}
