package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.tieba.ms1;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Service
/* loaded from: classes6.dex */
public class zk3 implements eo1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public class b implements xn1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(zk3 zk3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zk3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.xn1
        @NonNull
        public m93 e(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
                return new wk3(context);
            }
            return (m93) invokeL.objValue;
        }

        @Override // com.baidu.tieba.xn1
        @NonNull
        public l93 f(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) {
                return new vk3(context);
            }
            return (l93) invokeL.objValue;
        }

        public /* synthetic */ b(zk3 zk3Var, a aVar) {
            this(zk3Var);
        }

        @Override // com.baidu.tieba.xn1
        @NonNull
        public k93 g(Context context, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, context, str)) == null) {
                return new uk3(context, str);
            }
            return (k93) invokeLL.objValue;
        }

        @Override // com.baidu.tieba.xn1
        @NonNull
        public i93 a(Activity activity, boolean z, String str, String str2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{activity, Boolean.valueOf(z), str, str2})) == null) {
                return new sk3(activity, z, str, str2);
            }
            return (i93) invokeCommon.objValue;
        }

        @Override // com.baidu.tieba.xn1
        @NonNull
        public n93 b(Activity activity, ms1.d dVar, Bundle bundle) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, dVar, bundle)) == null) {
                return new xk3(activity, dVar, bundle);
            }
            return (n93) invokeLLL.objValue;
        }

        @Override // com.baidu.tieba.xn1
        @NonNull
        public o93 c(Activity activity, String str, String str2, boolean z, boolean z2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{activity, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
                return new yk3(activity, str, str2, z, z2);
            }
            return (o93) invokeCommon.objValue;
        }

        @Override // com.baidu.tieba.xn1
        @NonNull
        public j93 d(Context context, boolean z, boolean z2, String[] strArr, String str, boolean z3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{context, Boolean.valueOf(z), Boolean.valueOf(z2), strArr, str, Boolean.valueOf(z3)})) == null) {
                return new tk3(context, z, z2, strArr, str, z3);
            }
            return (j93) invokeCommon.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948362791, "Lcom/baidu/tieba/zk3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948362791, "Lcom/baidu/tieba/zk3;");
                return;
            }
        }
        boolean z = ok1.a;
    }

    public zk3() {
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

    @Override // com.baidu.tieba.eo1
    public qn1 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new rk3();
        }
        return (qn1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.eo1
    public xn1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return new b(this, null);
        }
        return (xn1) invokeV.objValue;
    }
}
