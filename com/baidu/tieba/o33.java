package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class o33 extends n33 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public Map a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947981274, "Lcom/baidu/tieba/o33;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947981274, "Lcom/baidu/tieba/o33;");
                return;
            }
        }
        b = wj1.a;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.clear();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            a();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o33(m33 m33Var) {
        super(m33Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {m33Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((m33) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new HashMap();
    }

    public boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return this.a.containsKey(str);
        }
        return invokeL.booleanValue;
    }

    public Boolean c(String str, Boolean bool) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, bool)) == null) {
            try {
                return (Boolean) f(str, bool);
            } catch (ClassCastException e) {
                if (b) {
                    e.printStackTrace();
                }
                return bool;
            }
        }
        return (Boolean) invokeLL.objValue;
    }

    public Integer d(String str, Integer num) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, num)) == null) {
            try {
                return (Integer) f(str, num);
            } catch (ClassCastException e) {
                if (b) {
                    e.printStackTrace();
                }
                return num;
            }
        }
        return (Integer) invokeLL.objValue;
    }

    public String e(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, str2)) == null) {
            try {
                return (String) f(str, str2);
            } catch (ClassCastException e) {
                if (b) {
                    e.printStackTrace();
                }
                return str2;
            }
        }
        return (String) invokeLL.objValue;
    }

    public final Object f(String str, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, obj)) == null) {
            if (!b(str)) {
                return obj;
            }
            if (this.a.get(str) == null) {
                return null;
            }
            try {
                return this.a.get(str);
            } catch (Exception e) {
                if (b) {
                    e.printStackTrace();
                    return obj;
                }
                return obj;
            }
        }
        return invokeLL.objValue;
    }

    public void h(String str, Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, bool) == null) {
            k(str, bool);
        }
    }

    public void i(String str, Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, num) == null) {
            k(str, num);
        }
    }

    public void j(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, str2) == null) {
            k(str, str2);
        }
    }

    public final void k(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, obj) == null) {
            this.a.put(str, obj);
        }
    }
}
