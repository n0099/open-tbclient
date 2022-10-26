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
/* loaded from: classes6.dex */
public class yn8 {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap a;
    public transient /* synthetic */ FieldHolder $fh;

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public final class a extends CustomMessageListener {
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
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof BackgroundSwitchMessage) && ((Boolean) ((BackgroundSwitchMessage) customResponsedMessage).getData()).booleanValue()) {
                yn8.a(1);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948336038, "Lcom/baidu/tieba/yn8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948336038, "Lcom/baidu/tieba/yn8;");
                return;
            }
        }
        MessageManager.getInstance().registerListener(new a(2001011));
        a = new HashMap();
    }

    public static void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65537, null, i) == null) {
            for (Object obj : a.keySet()) {
                b((ao8) a.get(obj), i);
            }
        }
    }

    public static void b(ao8 ao8Var, int i) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, ao8Var, i) == null) {
            zn8 zn8Var = ao8Var.d;
            zn8 zn8Var2 = ao8Var.e;
            zn8 zn8Var3 = ao8Var.f;
            if (zn8Var.b + zn8Var2.b + zn8Var3.b >= i) {
                mh mhVar = new mh("dbg");
                mhVar.b("act", ao8Var.c);
                mhVar.b("httpTimeCost", String.valueOf(zn8Var.a));
                mhVar.b("httpNum", String.valueOf(zn8Var.b));
                mhVar.b("httpFailnum", String.valueOf(zn8Var.c));
                mhVar.b("httpSize", String.valueOf(zn8Var.d));
                mhVar.b("socketTimeCost", String.valueOf(zn8Var2.a));
                mhVar.b("socketNum", String.valueOf(zn8Var2.b));
                mhVar.b("socketFailnum", String.valueOf(zn8Var2.c));
                mhVar.b("socketSize", String.valueOf(zn8Var2.d));
                mhVar.b("abortTimeCost", String.valueOf(zn8Var3.a));
                mhVar.b("abortNum", String.valueOf(zn8Var3.b));
                mhVar.b("netType", ao8Var.b);
                if (ao8Var.a) {
                    str = "1";
                } else {
                    str = "0";
                }
                mhVar.b("isJson", str);
                BdStatisticsManager.getInstance().debug("frs", mhVar);
                zn8Var.a();
                zn8Var2.a();
                zn8Var3.a();
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
                a.put(str3, new ao8(str, str2, z));
            }
        }
    }

    public static ao8 e(String str, String str2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65541, null, str, str2, z)) == null) {
            if (str2 == null) {
                str2 = "";
            }
            String str3 = str + str2;
            if (!a.containsKey(str3)) {
                a.put(str3, new ao8(str, str2, z));
            }
            return (ao8) a.get(str3);
        }
        return (ao8) invokeLLZ.objValue;
    }
}
