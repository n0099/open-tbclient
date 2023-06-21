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
/* loaded from: classes8.dex */
public class uxa {
    public static /* synthetic */ Interceptable $ic = null;
    public static String b = "UnionIDFactory";
    public static boolean c;
    public transient /* synthetic */ FieldHolder $fh;
    public yxa a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948227755, "Lcom/baidu/tieba/uxa;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948227755, "Lcom/baidu/tieba/uxa;");
                return;
            }
        }
        c = rxa.e();
    }

    public yxa a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (yxa) invokeV.objValue;
    }

    public uxa(Context context) {
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
        int a = sxa.a();
        if (c) {
            String str = b;
            Log.e(str, "UnionIDFactory manufacturer:" + a);
        }
        if (a != 10001) {
            if (a != 10002) {
                this.a = new bya(context);
                return;
            }
            if (c) {
                Log.e(b, "UnionIDFactory XMUnionID");
            }
            this.a = new cya(context);
            return;
        }
        this.a = new aya(context);
    }
}
