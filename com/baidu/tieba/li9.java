package com.baidu.tieba;

import android.content.Context;
import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class li9 {
    public static /* synthetic */ Interceptable $ic = null;
    public static String b = "UnionIDFactory";
    public static boolean c;
    public transient /* synthetic */ FieldHolder $fh;
    public pi9 a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947943981, "Lcom/baidu/tieba/li9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947943981, "Lcom/baidu/tieba/li9;");
                return;
            }
        }
        c = ii9.e();
    }

    public pi9 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (pi9) invokeV.objValue;
    }

    public li9(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        int a = ji9.a();
        if (c) {
            String str = b;
            Log.e(str, "UnionIDFactory manufacturer:" + a);
        }
        if (a != 10001) {
            if (a != 10002) {
                this.a = new si9(context);
                return;
            }
            if (c) {
                Log.e(b, "UnionIDFactory XMUnionID");
            }
            this.a = new ti9(context);
            return;
        }
        this.a = new ri9(context);
    }
}
