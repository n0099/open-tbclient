package com.baidu.tieba;

import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.TreeMap;
/* loaded from: classes5.dex */
public final class me2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public static final boolean c;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947969711, "Lcom/baidu/tieba/me2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947969711, "Lcom/baidu/tieba/me2;");
                return;
            }
        }
        b = eo1.a;
        br2.g0().getSwitch("swan_slave_ready", false);
        c = false;
    }

    public me2() {
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

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (b) {
                Log.d("SlaveReadyEvent", "isSlaveReadyABSwitchOn:" + c);
            }
            return c;
        }
        return invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "SlaveReadyEvent{slaveId='" + this.a + "'}";
        }
        return (String) invokeV.objValue;
    }

    public static vh2 a(me2 me2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, me2Var)) == null) {
            if (b) {
                Log.d("SlaveReadyEvent", "createSlaveReadyMessage:" + me2Var);
            }
            TreeMap treeMap = new TreeMap();
            treeMap.put("slaveId", me2Var.a);
            return new vh2("SlaveReady", treeMap);
        }
        return (vh2) invokeL.objValue;
    }
}
