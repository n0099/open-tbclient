package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.data.PersonPrivateData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class x05 {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, Integer> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948246572, "Lcom/baidu/tieba/x05;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948246572, "Lcom/baidu/tieba/x05;");
                return;
            }
        }
        a = new HashMap<>();
    }

    public static int a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) {
            String str = TbadkCoreApplication.getCurrentAccount() + "@" + i;
            if (a.containsKey(str)) {
                return a.get(str).intValue();
            }
            a.put(str, 1);
            return 1;
        }
        return invokeI.intValue;
    }

    public static void b(PersonPrivateData personPrivateData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, personPrivateData) != null) || personPrivateData == null) {
            return;
        }
        String str = TbadkCoreApplication.getCurrentAccount() + "@2";
        int U = personPrivateData.U();
        if (!a.containsKey(str)) {
            a.put(str, Integer.valueOf(U));
        }
    }

    public static void c(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65539, null, i, i2) == null) {
            a.put(TbadkCoreApplication.getCurrentAccount() + "@" + i, Integer.valueOf(i2));
        }
    }
}
