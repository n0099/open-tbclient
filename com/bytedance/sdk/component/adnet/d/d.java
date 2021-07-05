package com.bytedance.sdk.component.adnet.d;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public a f27941a;

    /* renamed from: b  reason: collision with root package name */
    public b f27942b;

    /* renamed from: com.bytedance.sdk.component.adnet.d.d$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f27943a;

        /* renamed from: b  reason: collision with root package name */
        public static final a f27944b;

        /* renamed from: c  reason: collision with root package name */
        public static final a f27945c;

        /* renamed from: d  reason: collision with root package name */
        public static final a f27946d;

        /* renamed from: e  reason: collision with root package name */
        public static final /* synthetic */ a[] f27947e;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(662044255, "Lcom/bytedance/sdk/component/adnet/d/d$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(662044255, "Lcom/bytedance/sdk/component/adnet/d/d$a;");
                    return;
                }
            }
            f27943a = new a("DEBUG", 0);
            f27944b = new a("INFO", 1);
            f27945c = new a("ERROR", 2);
            a aVar = new a("OFF", 3);
            f27946d = aVar;
            f27947e = new a[]{f27943a, f27944b, f27945c, aVar};
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
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (a[]) f27947e.clone() : (a[]) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a(String str, String str2);

        void b(String str, String str2);
    }

    /* loaded from: classes6.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final d f27948a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(662044317, "Lcom/bytedance/sdk/component/adnet/d/d$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(662044317, "Lcom/bytedance/sdk/component/adnet/d/d$c;");
                    return;
                }
            }
            f27948a = new d(null);
        }
    }

    public /* synthetic */ d(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, aVar) == null) {
            synchronized (d.class) {
                c.f27948a.f27941a = aVar;
            }
        }
    }

    public static void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65540, null, str, str2) == null) || c.f27948a.f27941a.compareTo(a.f27943a) > 0) {
            return;
        }
        c.f27948a.f27942b.b(str, str2);
    }

    public d() {
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
        this.f27941a = a.f27946d;
        this.f27942b = new com.bytedance.sdk.component.adnet.d.b();
    }

    public static void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, str, str2) == null) || c.f27948a.f27941a.compareTo(a.f27945c) > 0) {
            return;
        }
        c.f27948a.f27942b.a(str, str2);
    }
}
