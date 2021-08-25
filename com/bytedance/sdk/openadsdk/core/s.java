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
    public static volatile s f66823a;

    /* renamed from: b  reason: collision with root package name */
    public static com.bytedance.sdk.openadsdk.core.i.b f66824b;

    /* renamed from: d  reason: collision with root package name */
    public static String f66825d;

    /* renamed from: e  reason: collision with root package name */
    public static volatile String f66826e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f66827c;

    /* renamed from: f  reason: collision with root package name */
    public volatile AtomicBoolean f66828f;

    /* renamed from: g  reason: collision with root package name */
    public String f66829g;

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
        this.f66827c = false;
        this.f66828f = new AtomicBoolean(false);
        this.f66829g = null;
        if (e() == null) {
            f66824b = com.bytedance.sdk.openadsdk.core.i.d.a();
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
            com.bytedance.sdk.openadsdk.core.i.b bVar = f66824b;
            if (bVar != null) {
                bVar.b(str);
            }
            if (this.f66827c || e() == null) {
                return;
            }
            e().NM_reportNow(str);
            this.f66827c = true;
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
        com.bytedance.sdk.openadsdk.core.i.b bVar = f66824b;
        if (bVar != null) {
            bVar.a(str);
        }
        f66825d = str;
        if (e() != null) {
            e().NM_setParams(str);
        }
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            try {
                if (!TextUtils.isEmpty(this.f66829g)) {
                    return this.f66829g;
                }
                String a2 = h.a("sdk_app_sha1", 2592000000L);
                this.f66829g = a2;
                if (!TextUtils.isEmpty(a2)) {
                    return this.f66829g;
                }
                if (e() != null) {
                    this.f66829g = e().NM_pullSg();
                } else if (f66824b != null) {
                    this.f66829g = f66824b.a();
                }
                if (d(this.f66829g)) {
                    String upperCase = this.f66829g.toUpperCase();
                    this.f66829g = upperCase;
                    h.a("sdk_app_sha1", upperCase);
                    return this.f66829g;
                }
                String a3 = com.bytedance.sdk.component.utils.c.a(o.a());
                this.f66829g = a3;
                if (d(a3)) {
                    String upperCase2 = this.f66829g.toUpperCase();
                    this.f66829g = upperCase2;
                    h.a("sdk_app_sha1", upperCase2);
                    return this.f66829g;
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
            if (f66826e != null) {
                return f66826e;
            }
            if (this.f66828f.compareAndSet(false, true)) {
                try {
                    com.bytedance.sdk.component.d.e.a(new com.bytedance.sdk.component.d.g(this, "getSecdid") { // from class: com.bytedance.sdk.openadsdk.core.s.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ s f66830a;

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
                            this.f66830a = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                if (s.f66824b != null) {
                                    String b2 = s.f66824b.b();
                                    if (!TextUtils.isEmpty(b2)) {
                                        String unused = s.f66826e = b2;
                                    }
                                }
                                this.f66830a.f66828f.set(false);
                            }
                        }
                    });
                    return "";
                } catch (Throwable unused) {
                    this.f66828f.set(false);
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
            if (f66823a == null) {
                synchronized (s.class) {
                    if (f66823a == null) {
                        f66823a = new s();
                    }
                }
            }
            return f66823a;
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
            com.bytedance.sdk.openadsdk.core.i.b bVar = f66824b;
            if (bVar != null) {
                return bVar.a(str, bArr);
            }
            return new HashMap();
        }
        return (Map) invokeLL.objValue;
    }
}
