package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public interface b {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f67494a;

        /* renamed from: b  reason: collision with root package name */
        public static final a f67495b;

        /* renamed from: c  reason: collision with root package name */
        public static final a f67496c;

        /* renamed from: d  reason: collision with root package name */
        public static final a f67497d;

        /* renamed from: e  reason: collision with root package name */
        public static final a f67498e;

        /* renamed from: f  reason: collision with root package name */
        public static final a f67499f;

        /* renamed from: g  reason: collision with root package name */
        public static final /* synthetic */ a[] f67500g;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1033855306, "Lcom/bytedance/sdk/openadsdk/core/video/nativevideo/b$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1033855306, "Lcom/bytedance/sdk/openadsdk/core/video/nativevideo/b$a;");
                    return;
                }
            }
            f67494a = new a("hideCloseBtn", 0);
            f67495b = new a("alwayShowBackBtn", 1);
            f67496c = new a("alwayShowMediaView", 2);
            f67497d = new a("fixedSize", 3);
            f67498e = new a("hideBackBtn", 4);
            a aVar = new a("hideTopMoreBtn", 5);
            f67499f = aVar;
            f67500g = new a[]{f67494a, f67495b, f67496c, f67497d, f67498e, aVar};
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
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (a[]) f67500g.clone() : (a[]) invokeV.objValue;
        }
    }
}
