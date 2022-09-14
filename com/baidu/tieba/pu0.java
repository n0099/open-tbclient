package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes5.dex */
public abstract class pu0 implements zt0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public yv0 a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948074398, "Lcom/baidu/tieba/pu0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948074398, "Lcom/baidu/tieba/pu0;");
                return;
            }
        }
        mq0.f();
    }

    public pu0(Map<String, String> map) {
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

    @Override // com.baidu.tieba.au0
    public final void c(ht0 ht0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, ht0Var) == null) || ht0Var == null || this.a == null) {
            return;
        }
        int type = ht0Var.getType();
        if (type == 1) {
            i(ht0Var);
        } else if (type == 2) {
            f(ht0Var);
        } else if (type == 3) {
            g(ht0Var);
        } else if (type != 4) {
        } else {
            h(ht0Var);
        }
    }

    @Override // com.baidu.tieba.zt0
    public final <T extends uv0> void d(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
            this.a = (yv0) t;
        }
    }

    public abstract void f(ht0 ht0Var);

    public abstract void g(ht0 ht0Var);

    public abstract void h(ht0 ht0Var);

    public abstract void i(ht0 ht0Var);

    public void j(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, map) == null) || map == null || map.size() <= 0) {
            return;
        }
        if (map.containsKey(WriteActivityConfig.VIDEO_INFO)) {
            String str = (String) lz0.b(map, WriteActivityConfig.VIDEO_INFO);
        }
        if (map.containsKey("channel_id")) {
            String str2 = (String) lz0.b(map, "channel_id");
        }
        if (map.containsKey("channel_title")) {
            String str3 = (String) lz0.b(map, "channel_title");
        }
        if (map.containsKey("type")) {
            String str4 = (String) lz0.b(map, "type");
        }
        if (map.containsKey("source")) {
            String str5 = (String) lz0.b(map, "source");
        }
        if (map.containsKey("from")) {
            String str6 = (String) lz0.b(map, "from");
        }
        if (map.containsKey(Config.EVENT_PAGE_MAPPING)) {
            String str7 = (String) lz0.b(map, Config.EVENT_PAGE_MAPPING);
        }
        if (map.containsKey("tpl")) {
            String str8 = (String) lz0.b(map, "tpl");
        }
        if (map.containsKey("ext_request")) {
            String str9 = (String) lz0.b(map, "ext_request");
        }
    }
}
