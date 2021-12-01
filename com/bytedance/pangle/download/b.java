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
/* loaded from: classes12.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static b f54522d;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public List<a> f54523b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f54524c;

    /* renamed from: e  reason: collision with root package name */
    public int f54525e;

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
        this.f54525e = 0;
        this.a = true;
        this.f54523b = new ArrayList();
        this.f54524c = false;
    }

    public static /* synthetic */ int c(b bVar) {
        int i2 = bVar.f54525e;
        bVar.f54525e = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int d(b bVar) {
        int i2 = bVar.f54525e;
        bVar.f54525e = i2 - 1;
        return i2;
    }

    public static b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f54522d == null) {
                synchronized (b.class) {
                    if (f54522d == null) {
                        f54522d = new b();
                    }
                }
            }
            return f54522d;
        }
        return (b) invokeV.objValue;
    }
}
