package com.bytedance.pangle.log;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.pangle.i;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f62341a;
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
            if (f62341a == null) {
                synchronized (a.class) {
                    f62341a = new a();
                }
            }
            return f62341a;
        }
        return (a) invokeV.objValue;
    }

    public static void a(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65538, null, str, jSONObject, jSONObject2, jSONObject3) == null) {
            if (!i.a().f62337b.isCloseDefaultReport()) {
                ZeusLogger.d("Zeus/DefaultReporterImpl", "report by defaultImpl");
                com.bytedance.pangle.helper.d.a().monitorStatusAndEvent(str, 0, jSONObject, jSONObject2, jSONObject3);
                com.bytedance.pangle.helper.d.a().flushBuffer(new b("report result : "));
                return;
            }
            ZeusLogger.d("Zeus/DefaultReporterImpl", "skip default report");
        }
    }
}
