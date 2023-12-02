package com.baidu.tieba;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class jpb {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public static String g;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final int b;
    public final int c;
    public long d;
    public int e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947892397, "Lcom/baidu/tieba/jpb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947892397, "Lcom/baidu/tieba/jpb;");
                return;
            }
        }
        f = ipb.a & true;
        g = "ControlData";
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int i = this.e;
            if (i != 0 && i == this.c) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public jpb(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = str;
        this.b = i;
        this.c = i2;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.b != 0 && this.c != 0) {
                Long valueOf = Long.valueOf(System.currentTimeMillis());
                if (f) {
                    Log.d(g, "id " + this.a + " mLimitUnit " + this.b + " mLimitCnt " + this.c + "mCount =  " + this.e + " duration " + ((valueOf.longValue() - this.d) / 1000));
                }
                if (this.d != 0 && (valueOf.longValue() - this.d) / 1000 <= this.b && this.e >= this.c) {
                    if (f) {
                        Log.d(g, "control");
                    }
                    return true;
                }
                if (this.d == 0) {
                    this.d = valueOf.longValue();
                } else if ((valueOf.longValue() - this.d) / 1000 > this.b) {
                    this.d = valueOf.longValue();
                    this.e = 0;
                    if (f) {
                        Log.d(g, "reset");
                    }
                }
                this.e++;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
