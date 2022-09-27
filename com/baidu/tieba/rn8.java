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
public class rn8 {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, tn8> a;
    public transient /* synthetic */ FieldHolder $fh;

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
                rn8.a(1);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948127501, "Lcom/baidu/tieba/rn8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948127501, "Lcom/baidu/tieba/rn8;");
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

    public static void b(tn8 tn8Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, tn8Var, i) == null) {
            sn8 sn8Var = tn8Var.d;
            sn8 sn8Var2 = tn8Var.e;
            sn8 sn8Var3 = tn8Var.f;
            if (sn8Var.b + sn8Var2.b + sn8Var3.b >= i) {
                lh lhVar = new lh("dbg");
                lhVar.b("act", tn8Var.c);
                lhVar.b("httpTimeCost", String.valueOf(sn8Var.a));
                lhVar.b("httpNum", String.valueOf(sn8Var.b));
                lhVar.b("httpFailnum", String.valueOf(sn8Var.c));
                lhVar.b("httpSize", String.valueOf(sn8Var.d));
                lhVar.b("socketTimeCost", String.valueOf(sn8Var2.a));
                lhVar.b("socketNum", String.valueOf(sn8Var2.b));
                lhVar.b("socketFailnum", String.valueOf(sn8Var2.c));
                lhVar.b("socketSize", String.valueOf(sn8Var2.d));
                lhVar.b("abortTimeCost", String.valueOf(sn8Var3.a));
                lhVar.b("abortNum", String.valueOf(sn8Var3.b));
                lhVar.b("netType", tn8Var.b);
                lhVar.b("isJson", tn8Var.a ? "1" : "0");
                BdStatisticsManager.getInstance().debug("frs", lhVar);
                sn8Var.a();
                sn8Var2.a();
                sn8Var3.a();
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
            if (a.containsKey(str3)) {
                return;
            }
            a.put(str3, new tn8(str, str2, z));
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
        }
    }

    public static tn8 e(String str, String str2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65541, null, str, str2, z)) == null) {
            if (str2 == null) {
                str2 = "";
            }
            String str3 = str + str2;
            if (!a.containsKey(str3)) {
                a.put(str3, new tn8(str, str2, z));
            }
            return a.get(str3);
        }
        return (tn8) invokeLLZ.objValue;
    }
}
