package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.tr2;
import com.baidu.tieba.xw1;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class yw1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile yw1 b;
    public transient /* synthetic */ FieldHolder $fh;
    public c a;

    /* loaded from: classes7.dex */
    public interface c {
        void b(xw1.c cVar, int i);

        void f(xw1.c cVar, String str);

        void g(xw1.c cVar, sa3 sa3Var);
    }

    /* loaded from: classes7.dex */
    public class a implements w23 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xw1.c a;
        public final /* synthetic */ yw1 b;

        public a(yw1 yw1Var, xw1.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yw1Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yw1Var;
            this.a = cVar;
        }

        @Override // com.baidu.tieba.w23
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.b.c(this.a);
            }
        }

        @Override // com.baidu.tieba.w23
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                t42.c("GetLocationHelper", str);
                ze3.b("getLocation", 5002, "user no permission", 10005, str);
                this.b.a.f(this.a, str);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements tr2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xw1.c a;
        public final /* synthetic */ yw1 b;

        public b(yw1 yw1Var, xw1.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yw1Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yw1Var;
            this.a = cVar;
        }

        @Override // com.baidu.tieba.tr2.a
        public void a(sa3 sa3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, sa3Var) == null) {
                this.b.a.g(this.a, sa3Var);
            }
        }

        @Override // com.baidu.tieba.tr2.a
        public void onFailed(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                ze3.b("getLocation", 4000, "sdk's errCode is " + i, 1001, String.valueOf(i));
                this.b.a.b(this.a, i);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948344470, "Lcom/baidu/tieba/yw1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948344470, "Lcom/baidu/tieba/yw1;");
                return;
            }
        }
        boolean z = do1.a;
    }

    public yw1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static yw1 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (b == null) {
                synchronized (yw1.class) {
                    if (b == null) {
                        b = new yw1();
                    }
                }
            }
            return b;
        }
        return (yw1) invokeV.objValue;
    }

    public final void c(xw1.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            String str = "gcj02";
            if (!TextUtils.equals(cVar.a, "gcj02")) {
                if (TextUtils.equals(cVar.a, "bd09ll")) {
                    str = "bd09ll";
                } else {
                    str = "wgs84";
                }
            }
            ar2.I().b(str, false, cVar.b, new b(this, cVar));
        }
    }

    public void e(@NonNull xw1.c cVar, @NonNull c cVar2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, cVar2, z) == null) {
            this.a = cVar2;
            if (nl3.M()) {
                c(cVar);
            } else if (z) {
                ze3.b("getLocation", 1002, "GetLocation does not supported when app is invisible", 10005, "GetLocation does not supported when app is invisible");
                this.a.f(cVar, "GetLocation does not supported when app is invisible");
            } else {
                v23.g(s73.K().w(), new String[]{com.kuaishou.weapon.p0.h.g, com.kuaishou.weapon.p0.h.h}, 0, new a(this, cVar));
            }
        }
    }
}
