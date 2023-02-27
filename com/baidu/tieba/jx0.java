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
/* loaded from: classes5.dex */
public abstract class jx0 implements tw0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public sy0 a;

    public abstract void f(bw0 bw0Var);

    public abstract void g(bw0 bw0Var);

    public abstract void h(bw0 bw0Var);

    public abstract void i(bw0 bw0Var);

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947898535, "Lcom/baidu/tieba/jx0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947898535, "Lcom/baidu/tieba/jx0;");
                return;
            }
        }
        gt0.f();
    }

    public jx0(Map<String, String> map) {
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

    @Override // com.baidu.tieba.tw0
    public final <T extends oy0> void d(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
            this.a = (sy0) t;
        }
    }

    @Override // com.baidu.tieba.uw0
    public final void c(bw0 bw0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, bw0Var) == null) && bw0Var != null && this.a != null) {
            int type = bw0Var.getType();
            if (type != 1) {
                if (type != 2) {
                    if (type != 3) {
                        if (type == 4) {
                            h(bw0Var);
                            return;
                        }
                        return;
                    }
                    g(bw0Var);
                    return;
                }
                f(bw0Var);
                return;
            }
            i(bw0Var);
        }
    }

    public void j(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, map) == null) && map != null && map.size() > 0) {
            if (map.containsKey(WriteActivityConfig.VIDEO_INFO)) {
                String str = (String) g21.b(map, WriteActivityConfig.VIDEO_INFO);
            }
            if (map.containsKey("channel_id")) {
                String str2 = (String) g21.b(map, "channel_id");
            }
            if (map.containsKey("channel_title")) {
                String str3 = (String) g21.b(map, "channel_title");
            }
            if (map.containsKey("type")) {
                String str4 = (String) g21.b(map, "type");
            }
            if (map.containsKey("source")) {
                String str5 = (String) g21.b(map, "source");
            }
            if (map.containsKey("from")) {
                String str6 = (String) g21.b(map, "from");
            }
            if (map.containsKey("pd")) {
                String str7 = (String) g21.b(map, "pd");
            }
            if (map.containsKey("tpl")) {
                String str8 = (String) g21.b(map, "tpl");
            }
            if (map.containsKey("ext_request")) {
                String str9 = (String) g21.b(map, "ext_request");
            }
        }
    }
}
