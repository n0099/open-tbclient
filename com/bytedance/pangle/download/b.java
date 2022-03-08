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
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static b f51641d;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public List<a> f51642b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f51643c;

    /* renamed from: e  reason: collision with root package name */
    public int f51644e;

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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f51644e = 0;
        this.a = true;
        this.f51642b = new ArrayList();
        this.f51643c = false;
    }

    public static /* synthetic */ int c(b bVar) {
        int i2 = bVar.f51644e;
        bVar.f51644e = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int d(b bVar) {
        int i2 = bVar.f51644e;
        bVar.f51644e = i2 - 1;
        return i2;
    }

    public static b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f51641d == null) {
                synchronized (b.class) {
                    if (f51641d == null) {
                        f51641d = new b();
                    }
                }
            }
            return f51641d;
        }
        return (b) invokeV.objValue;
    }
}
