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
/* loaded from: classes7.dex */
public abstract class zv0 implements jv0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ix0 a;

    public abstract void f(ru0 ru0Var);

    public abstract void g(ru0 ru0Var);

    public abstract void h(ru0 ru0Var);

    public abstract void i(ru0 ru0Var);

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948373269, "Lcom/baidu/tieba/zv0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948373269, "Lcom/baidu/tieba/zv0;");
                return;
            }
        }
        wr0.f();
    }

    public zv0(Map<String, String> map) {
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

    @Override // com.baidu.tieba.jv0
    public final <T extends ex0> void d(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
            this.a = (ix0) t;
        }
    }

    @Override // com.baidu.tieba.kv0
    public final void c(ru0 ru0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, ru0Var) == null) && ru0Var != null && this.a != null) {
            int type = ru0Var.getType();
            if (type != 1) {
                if (type != 2) {
                    if (type != 3) {
                        if (type == 4) {
                            h(ru0Var);
                            return;
                        }
                        return;
                    }
                    g(ru0Var);
                    return;
                }
                f(ru0Var);
                return;
            }
            i(ru0Var);
        }
    }

    public void j(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, map) == null) && map != null && map.size() > 0) {
            if (map.containsKey(WriteActivityConfig.VIDEO_INFO)) {
                String str = (String) w01.b(map, WriteActivityConfig.VIDEO_INFO);
            }
            if (map.containsKey("channel_id")) {
                String str2 = (String) w01.b(map, "channel_id");
            }
            if (map.containsKey("channel_title")) {
                String str3 = (String) w01.b(map, "channel_title");
            }
            if (map.containsKey("type")) {
                String str4 = (String) w01.b(map, "type");
            }
            if (map.containsKey("source")) {
                String str5 = (String) w01.b(map, "source");
            }
            if (map.containsKey("from")) {
                String str6 = (String) w01.b(map, "from");
            }
            if (map.containsKey("pd")) {
                String str7 = (String) w01.b(map, "pd");
            }
            if (map.containsKey("tpl")) {
                String str8 = (String) w01.b(map, "tpl");
            }
            if (map.containsKey("ext_request")) {
                String str9 = (String) w01.b(map, "ext_request");
            }
        }
    }
}
