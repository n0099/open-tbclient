package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class jc9 {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, lc9> a;
    public transient /* synthetic */ FieldHolder $fh;

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public static class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof BackgroundSwitchMessage) && ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                jc9.a(1);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947878633, "Lcom/baidu/tieba/jc9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947878633, "Lcom/baidu/tieba/jc9;");
                return;
            }
        }
        MessageManager.getInstance().registerListener(new a(2001011));
        a = new HashMap<>();
    }

    public static void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65537, null, i) == null) {
            for (String str : a.keySet()) {
                b(a.get(str), i);
            }
        }
    }

    public static void b(lc9 lc9Var, int i) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, lc9Var, i) == null) {
            kc9 kc9Var = lc9Var.d;
            kc9 kc9Var2 = lc9Var.e;
            kc9 kc9Var3 = lc9Var.f;
            if (kc9Var.b + kc9Var2.b + kc9Var3.b >= i) {
                og ogVar = new og("dbg");
                ogVar.b("act", lc9Var.c);
                ogVar.b("httpTimeCost", String.valueOf(kc9Var.a));
                ogVar.b("httpNum", String.valueOf(kc9Var.b));
                ogVar.b("httpFailnum", String.valueOf(kc9Var.c));
                ogVar.b("httpSize", String.valueOf(kc9Var.d));
                ogVar.b("socketTimeCost", String.valueOf(kc9Var2.a));
                ogVar.b("socketNum", String.valueOf(kc9Var2.b));
                ogVar.b("socketFailnum", String.valueOf(kc9Var2.c));
                ogVar.b("socketSize", String.valueOf(kc9Var2.d));
                ogVar.b("abortTimeCost", String.valueOf(kc9Var3.a));
                ogVar.b("abortNum", String.valueOf(kc9Var3.b));
                ogVar.b("netType", lc9Var.b);
                if (lc9Var.a) {
                    str = "1";
                } else {
                    str = "0";
                }
                ogVar.b("isJson", str);
                BdStatisticsManager.getInstance().debug("frs", ogVar);
                kc9Var.a();
                kc9Var2.a();
                kc9Var3.a();
            }
        }
    }

    public static void c(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65539, null, str, str2, z) == null) {
            if (str2 == null) {
                str2 = "";
            }
            String str3 = str + str2;
            if (!a.containsKey(str3)) {
                a.put(str3, new lc9(str, str2, z));
            }
        }
    }

    public static lc9 e(String str, String str2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65541, null, str, str2, z)) == null) {
            if (str2 == null) {
                str2 = "";
            }
            String str3 = str + str2;
            if (!a.containsKey(str3)) {
                a.put(str3, new lc9(str, str2, z));
            }
            return a.get(str3);
        }
        return (lc9) invokeLLZ.objValue;
    }
}
