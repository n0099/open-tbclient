package com.bytedance.pangle.log;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.pangle.g;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile a a;
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (a.class) {
                    a = new a();
                }
            }
            return a;
        }
        return (a) invokeV.objValue;
    }

    public static void a(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65538, null, str, jSONObject, jSONObject2, jSONObject3) == null) {
            if (!g.a().f51712b.isCloseDefaultReport()) {
                ZeusLogger.d("Zeus/DefaultReporterImpl", "report by defaultImpl");
                com.bytedance.pangle.helper.d.a().monitorStatusAndEvent(str, 0, jSONObject, jSONObject2, jSONObject3);
                com.bytedance.pangle.helper.d.a().flushBuffer(new b("report result : "));
                return;
            }
            ZeusLogger.d("Zeus/DefaultReporterImpl", "skip default report");
        }
    }
}
