package com.bytedance.pangle.download;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static b f38067d;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public List<a> f38068b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f38069c;

    /* renamed from: e  reason: collision with root package name */
    public int f38070e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1012231086, "Lcom/bytedance/pangle/download/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1012231086, "Lcom/bytedance/pangle/download/b;");
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f38070e = 0;
        this.a = true;
        this.f38068b = new ArrayList();
        this.f38069c = false;
    }

    public static /* synthetic */ int c(b bVar) {
        int i = bVar.f38070e;
        bVar.f38070e = i + 1;
        return i;
    }

    public static /* synthetic */ int d(b bVar) {
        int i = bVar.f38070e;
        bVar.f38070e = i - 1;
        return i;
    }

    public static b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f38067d == null) {
                synchronized (b.class) {
                    if (f38067d == null) {
                        f38067d = new b();
                    }
                }
            }
            return f38067d;
        }
        return (b) invokeV.objValue;
    }
}
