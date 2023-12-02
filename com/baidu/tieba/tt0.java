package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes8.dex */
public abstract class tt0 implements dt0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public cv0 a;

    public abstract void f(ms0 ms0Var);

    public abstract void g(ms0 ms0Var);

    public abstract void h(ms0 ms0Var);

    public abstract void i(ms0 ms0Var);

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948192601, "Lcom/baidu/tieba/tt0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948192601, "Lcom/baidu/tieba/tt0;");
                return;
            }
        }
        rp0.f();
    }

    public tt0(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {map};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        j(map);
    }

    @Override // com.baidu.tieba.dt0
    public final <T extends yu0> void d(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
            this.a = (cv0) t;
        }
    }

    @Override // com.baidu.tieba.et0
    public final void c(ms0 ms0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, ms0Var) == null) && ms0Var != null && this.a != null) {
            int m = ms0Var.m();
            if (m != 1) {
                if (m != 2) {
                    if (m != 3) {
                        if (m == 4) {
                            h(ms0Var);
                            return;
                        }
                        return;
                    }
                    g(ms0Var);
                    return;
                }
                f(ms0Var);
                return;
            }
            i(ms0Var);
        }
    }

    public void j(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, map) == null) && map != null && map.size() > 0) {
            if (map.containsKey(WriteActivityConfig.VIDEO_INFO)) {
                String str = (String) py0.b(map, WriteActivityConfig.VIDEO_INFO);
            }
            if (map.containsKey("channel_id")) {
                String str2 = (String) py0.b(map, "channel_id");
            }
            if (map.containsKey("channel_title")) {
                String str3 = (String) py0.b(map, "channel_title");
            }
            if (map.containsKey("type")) {
                String str4 = (String) py0.b(map, "type");
            }
            if (map.containsKey("source")) {
                String str5 = (String) py0.b(map, "source");
            }
            if (map.containsKey("from")) {
                String str6 = (String) py0.b(map, "from");
            }
            if (map.containsKey("pd")) {
                String str7 = (String) py0.b(map, "pd");
            }
            if (map.containsKey("tpl")) {
                String str8 = (String) py0.b(map, "tpl");
            }
            if (map.containsKey("ext_request")) {
                String str9 = (String) py0.b(map, "ext_request");
            }
        }
    }
}
