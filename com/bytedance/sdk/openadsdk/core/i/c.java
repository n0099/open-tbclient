package com.bytedance.sdk.openadsdk.core.i;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.mobsec.metasec.ml.MSConfig;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.core.o;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes9.dex */
public class c extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.b.b.b.a.a f66274a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f66275b;

    public c() {
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
        this.f66275b = c();
    }

    private boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            try {
                Context a2 = o.a();
                String h2 = h.d().h();
                String a3 = j.a(a2);
                MSConfig.a aVar = new MSConfig.a("1371", h2, "THYFfhd167Y/Etj/JFI+OYhGnAsIhCvIXKQbbKuslfRMO6XQmCuZImqOyljyF6dQ900Hy8ecQzUcHu72ks7Xvvncqt7BZjf4VSth/OzZbJlDJqtayy2lcb5mqCQUzE5fIvFXAZkyxl+SRzGnzUojBcyqITZ3bGRvteMi+qu/15oKM3BWY0IDJ9Ry5FUGfzt+FyCqvZI8PFQNAzvZXcWHlJoRXydZUjUbtEy/AFUvusIO1HDx");
                aVar.d(a3);
                MSConfig.a aVar2 = aVar;
                aVar2.c(1);
                c.b.b.b.a.b.b(a2, aVar2.e());
                e();
                if (this.f66274a != null) {
                    this.f66274a.d(a3);
                }
                return true;
            } catch (Throwable th) {
                k.b("MSSdkImpl", "appid 为空，初始化失败！", th);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    private synchronized boolean d() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            synchronized (this) {
                if (!this.f66275b) {
                    this.f66275b = c();
                }
                z = this.f66275b;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    private void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, this) == null) && this.f66274a == null) {
            this.f66274a = c.b.b.b.a.b.a("1371");
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.i.b
    public void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && d()) {
            e();
            c.b.b.b.a.a aVar = this.f66274a;
            if (aVar != null) {
                aVar.d(str);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.i.b
    public void b(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && d()) {
            e();
            c.b.b.b.a.a aVar = this.f66274a;
            if (aVar != null) {
                aVar.a(str);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.i.b
    public Map<String, String> a(String str, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, bArr)) == null) {
            if (!d()) {
                return new HashMap();
            }
            e();
            c.b.b.b.a.a aVar = this.f66274a;
            if (aVar != null) {
                return aVar.c(str, bArr);
            }
            return new HashMap();
        }
        return (Map) invokeLL.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.i.a, com.bytedance.sdk.openadsdk.core.i.b
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (d()) {
                e();
                c.b.b.b.a.a aVar = this.f66274a;
                return aVar != null ? aVar.b() : "";
            }
            return "";
        }
        return (String) invokeV.objValue;
    }
}
