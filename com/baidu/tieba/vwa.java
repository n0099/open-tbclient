package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.BdStatsItem;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class vwa {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, xwa> a;
    public transient /* synthetic */ FieldHolder $fh;

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public class a extends CustomMessageListener {
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
                vwa.a(1);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948256585, "Lcom/baidu/tieba/vwa;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948256585, "Lcom/baidu/tieba/vwa;");
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

    public static void b(xwa xwaVar, int i) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, xwaVar, i) == null) {
            wwa wwaVar = xwaVar.d;
            wwa wwaVar2 = xwaVar.e;
            wwa wwaVar3 = xwaVar.f;
            if (wwaVar.b + wwaVar2.b + wwaVar3.b >= i) {
                BdStatsItem bdStatsItem = new BdStatsItem("dbg");
                bdStatsItem.append("act", xwaVar.c);
                bdStatsItem.append("httpTimeCost", String.valueOf(wwaVar.a));
                bdStatsItem.append("httpNum", String.valueOf(wwaVar.b));
                bdStatsItem.append("httpFailnum", String.valueOf(wwaVar.c));
                bdStatsItem.append("httpSize", String.valueOf(wwaVar.d));
                bdStatsItem.append("socketTimeCost", String.valueOf(wwaVar2.a));
                bdStatsItem.append("socketNum", String.valueOf(wwaVar2.b));
                bdStatsItem.append("socketFailnum", String.valueOf(wwaVar2.c));
                bdStatsItem.append("socketSize", String.valueOf(wwaVar2.d));
                bdStatsItem.append("abortTimeCost", String.valueOf(wwaVar3.a));
                bdStatsItem.append("abortNum", String.valueOf(wwaVar3.b));
                bdStatsItem.append("netType", xwaVar.b);
                if (xwaVar.a) {
                    str = "1";
                } else {
                    str = "0";
                }
                bdStatsItem.append("isJson", str);
                BdStatisticsManager.getInstance().debug("frs", bdStatsItem);
                wwaVar.a();
                wwaVar2.a();
                wwaVar3.a();
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
                a.put(str3, new xwa(str, str2, z));
            }
        }
    }

    public static xwa e(String str, String str2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65541, null, str, str2, z)) == null) {
            if (str2 == null) {
                str2 = "";
            }
            String str3 = str + str2;
            if (!a.containsKey(str3)) {
                a.put(str3, new xwa(str, str2, z));
            }
            return a.get(str3);
        }
        return (xwa) invokeLLZ.objValue;
    }
}
