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
/* loaded from: classes6.dex */
public abstract class vv0 implements fv0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ex0 a;

    public abstract void f(nu0 nu0Var);

    public abstract void g(nu0 nu0Var);

    public abstract void h(nu0 nu0Var);

    public abstract void i(nu0 nu0Var);

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948254105, "Lcom/baidu/tieba/vv0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948254105, "Lcom/baidu/tieba/vv0;");
                return;
            }
        }
        sr0.f();
    }

    public vv0(Map<String, String> map) {
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

    @Override // com.baidu.tieba.fv0
    public final <T extends ax0> void d(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
            this.a = (ex0) t;
        }
    }

    @Override // com.baidu.tieba.gv0
    public final void c(nu0 nu0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, nu0Var) == null) && nu0Var != null && this.a != null) {
            int type = nu0Var.getType();
            if (type != 1) {
                if (type != 2) {
                    if (type != 3) {
                        if (type == 4) {
                            h(nu0Var);
                            return;
                        }
                        return;
                    }
                    g(nu0Var);
                    return;
                }
                f(nu0Var);
                return;
            }
            i(nu0Var);
        }
    }

    public void j(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, map) == null) && map != null && map.size() > 0) {
            if (map.containsKey(WriteActivityConfig.VIDEO_INFO)) {
                String str = (String) r01.b(map, WriteActivityConfig.VIDEO_INFO);
            }
            if (map.containsKey("channel_id")) {
                String str2 = (String) r01.b(map, "channel_id");
            }
            if (map.containsKey("channel_title")) {
                String str3 = (String) r01.b(map, "channel_title");
            }
            if (map.containsKey("type")) {
                String str4 = (String) r01.b(map, "type");
            }
            if (map.containsKey("source")) {
                String str5 = (String) r01.b(map, "source");
            }
            if (map.containsKey("from")) {
                String str6 = (String) r01.b(map, "from");
            }
            if (map.containsKey(Config.EVENT_PAGE_MAPPING)) {
                String str7 = (String) r01.b(map, Config.EVENT_PAGE_MAPPING);
            }
            if (map.containsKey("tpl")) {
                String str8 = (String) r01.b(map, "tpl");
            }
            if (map.containsKey("ext_request")) {
                String str9 = (String) r01.b(map, "ext_request");
            }
        }
    }
}
