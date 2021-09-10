package com.bytedance.sdk.component.adnet.d;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public a f64368a;

    /* renamed from: b  reason: collision with root package name */
    public b f64369b;

    /* renamed from: com.bytedance.sdk.component.adnet.d.c$1  reason: invalid class name */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f64370a;

        /* renamed from: b  reason: collision with root package name */
        public static final a f64371b;

        /* renamed from: c  reason: collision with root package name */
        public static final a f64372c;

        /* renamed from: d  reason: collision with root package name */
        public static final a f64373d;

        /* renamed from: e  reason: collision with root package name */
        public static final /* synthetic */ a[] f64374e;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(662014464, "Lcom/bytedance/sdk/component/adnet/d/c$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(662014464, "Lcom/bytedance/sdk/component/adnet/d/c$a;");
                    return;
                }
            }
            f64370a = new a("DEBUG", 0);
            f64371b = new a("INFO", 1);
            f64372c = new a("ERROR", 2);
            a aVar = new a("OFF", 3);
            f64373d = aVar;
            f64374e = new a[]{f64370a, f64371b, f64372c, aVar};
        }

        public a(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static a valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (a) Enum.valueOf(a.class, str) : (a) invokeL.objValue;
        }

        public static a[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (a[]) f64374e.clone() : (a[]) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public interface b {
        void a(String str, String str2);

        void b(String str, String str2);
    }

    /* renamed from: com.bytedance.sdk.component.adnet.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C1881c {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final c f64375a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(662014526, "Lcom/bytedance/sdk/component/adnet/d/c$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(662014526, "Lcom/bytedance/sdk/component/adnet/d/c$c;");
                    return;
                }
            }
            f64375a = new c(null);
        }
    }

    public /* synthetic */ c(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, aVar) == null) {
            synchronized (c.class) {
                C1881c.f64375a.f64368a = aVar;
            }
        }
    }

    public static void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2) == null) || C1881c.f64375a.f64368a.compareTo(a.f64370a) > 0) {
            return;
        }
        C1881c.f64375a.f64369b.b(str, str2);
    }

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
        this.f64368a = a.f64373d;
        this.f64369b = new com.bytedance.sdk.component.adnet.d.a();
    }

    public static void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, str, str2) == null) || C1881c.f64375a.f64368a.compareTo(a.f64372c) > 0) {
            return;
        }
        C1881c.f64375a.f64369b.a(str, str2);
    }
}
