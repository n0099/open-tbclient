package com.bytedance.sdk.openadsdk.core;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTSecAbs;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class s {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile s f30529a;

    /* renamed from: b  reason: collision with root package name */
    public static com.bytedance.sdk.openadsdk.core.i.b f30530b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f30531c;

    /* renamed from: d  reason: collision with root package name */
    public String f30532d;

    /* renamed from: e  reason: collision with root package name */
    public String f30533e;

    public s() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f30531c = false;
        this.f30532d = null;
        this.f30533e = null;
        if (d() == null) {
            f30530b = com.bytedance.sdk.openadsdk.core.i.d.a();
        }
    }

    private TTSecAbs d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) ? h.d().q() : (TTSecAbs) invokeV.objValue;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.i.b bVar = f30530b;
        if (bVar != null) {
            bVar.a(str);
        }
        this.f30532d = str;
        if (d() != null) {
            d().NM_setParams(str);
        }
    }

    public void b(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            com.bytedance.sdk.openadsdk.core.i.b bVar = f30530b;
            if (bVar != null) {
                bVar.b(str);
            }
            if (this.f30531c || d() == null) {
                return;
            }
            d().NM_reportNow(str);
            this.f30531c = true;
        }
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            try {
                if (!TextUtils.isEmpty(this.f30533e)) {
                    return this.f30533e;
                }
                String a2 = h.a("sdk_app_sha1", 2592000000L);
                this.f30533e = a2;
                if (!TextUtils.isEmpty(a2)) {
                    return this.f30533e;
                }
                if (d() != null) {
                    this.f30533e = d().NM_pullSg();
                } else if (f30530b != null) {
                    this.f30533e = f30530b.a();
                }
                if (c(this.f30533e)) {
                    String upperCase = this.f30533e.toUpperCase();
                    this.f30533e = upperCase;
                    h.a("sdk_app_sha1", upperCase);
                    return this.f30533e;
                }
                String a3 = com.bytedance.sdk.component.utils.c.a(o.a());
                this.f30533e = a3;
                if (c(a3)) {
                    String upperCase2 = this.f30533e.toUpperCase();
                    this.f30533e = upperCase2;
                    h.a("sdk_app_sha1", upperCase2);
                    return this.f30533e;
                }
                return "";
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public static s a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f30529a == null) {
                synchronized (s.class) {
                    if (f30529a == null) {
                        f30529a = new s();
                    }
                }
            }
            return f30529a;
        }
        return (s) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        String b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            com.bytedance.sdk.openadsdk.core.i.b bVar = f30530b;
            return (bVar == null || (b2 = bVar.b()) == null) ? "" : b2;
        }
        return (String) invokeV.objValue;
    }

    public Map<String, String> a(String str, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, bArr)) == null) {
            if (d() != null) {
                return d().NM_ssSign(str, bArr);
            }
            com.bytedance.sdk.openadsdk.core.i.b bVar = f30530b;
            if (bVar != null) {
                return bVar.a(str, bArr);
            }
            return new HashMap();
        }
        return (Map) invokeLL.objValue;
    }

    private boolean c(String str) {
        InterceptResult invokeL;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) {
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
}
