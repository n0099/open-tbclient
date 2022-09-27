package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.switchs.PreInitMainTabViewSwitch;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class o95 {
    public static /* synthetic */ Interceptable $ic;
    public static o95 c;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<Integer, Object> a;
    public final ht4 b;

    /* loaded from: classes5.dex */
    public interface a {
        Object build();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947987102, "Lcom/baidu/tieba/o95;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947987102, "Lcom/baidu/tieba/o95;");
        }
    }

    public o95() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new HashMap<>();
        this.b = new ht4();
    }

    public static o95 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (c == null) {
                synchronized (o95.class) {
                    if (c == null) {
                        c = new o95();
                    }
                }
            }
            return c;
        }
        return (o95) invokeV.objValue;
    }

    public void a(int i, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, obj) == null) {
            this.a.put(Integer.valueOf(i), obj);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.b.a();
            this.a.clear();
        }
    }

    public Object c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) ? this.a.get(Integer.valueOf(i)) : invokeI.objValue;
    }

    public Object d(int i, a aVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048579, this, i, aVar)) == null) {
            Object obj = this.a.get(Integer.valueOf(i));
            if ((!PreInitMainTabViewSwitch.getIsOn() || obj == null) && aVar != null) {
                obj = aVar.build();
            }
            this.a.remove(Integer.valueOf(i));
            if (obj == null && TbadkCoreApplication.getInst().isDebugMode()) {
                throw new RuntimeException("ViewCache must have return value.");
            }
            return obj;
        }
        return invokeIL.objValue;
    }

    public ht4 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.b : (ht4) invokeV.objValue;
    }
}
