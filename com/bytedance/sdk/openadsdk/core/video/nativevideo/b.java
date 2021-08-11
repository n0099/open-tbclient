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
        public static final a f66768a;

        /* renamed from: b  reason: collision with root package name */
        public static final a f66769b;

        /* renamed from: c  reason: collision with root package name */
        public static final a f66770c;

        /* renamed from: d  reason: collision with root package name */
        public static final a f66771d;

        /* renamed from: e  reason: collision with root package name */
        public static final a f66772e;

        /* renamed from: f  reason: collision with root package name */
        public static final a f66773f;

        /* renamed from: g  reason: collision with root package name */
        public static final /* synthetic */ a[] f66774g;
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
            f66768a = new a("hideCloseBtn", 0);
            f66769b = new a("alwayShowBackBtn", 1);
            f66770c = new a("alwayShowMediaView", 2);
            f66771d = new a("fixedSize", 3);
            f66772e = new a("hideBackBtn", 4);
            a aVar = new a("hideTopMoreBtn", 5);
            f66773f = aVar;
            f66774g = new a[]{f66768a, f66769b, f66770c, f66771d, f66772e, aVar};
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
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (a[]) f66774g.clone() : (a[]) invokeV.objValue;
        }
    }
}
