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
public abstract class rt0 implements bt0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public av0 a;

    public abstract void f(ks0 ks0Var);

    public abstract void g(ks0 ks0Var);

    public abstract void h(ks0 ks0Var);

    public abstract void i(ks0 ks0Var);

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948133019, "Lcom/baidu/tieba/rt0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948133019, "Lcom/baidu/tieba/rt0;");
                return;
            }
        }
        pp0.f();
    }

    public rt0(Map<String, String> map) {
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

    @Override // com.baidu.tieba.bt0
    public final <T extends wu0> void d(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
            this.a = (av0) t;
        }
    }

    @Override // com.baidu.tieba.ct0
    public final void c(ks0 ks0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, ks0Var) == null) && ks0Var != null && this.a != null) {
            int m = ks0Var.m();
            if (m != 1) {
                if (m != 2) {
                    if (m != 3) {
                        if (m == 4) {
                            h(ks0Var);
                            return;
                        }
                        return;
                    }
                    g(ks0Var);
                    return;
                }
                f(ks0Var);
                return;
            }
            i(ks0Var);
        }
    }

    public void j(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, map) == null) && map != null && map.size() > 0) {
            if (map.containsKey(WriteActivityConfig.VIDEO_INFO)) {
                String str = (String) ny0.b(map, WriteActivityConfig.VIDEO_INFO);
            }
            if (map.containsKey("channel_id")) {
                String str2 = (String) ny0.b(map, "channel_id");
            }
            if (map.containsKey("channel_title")) {
                String str3 = (String) ny0.b(map, "channel_title");
            }
            if (map.containsKey("type")) {
                String str4 = (String) ny0.b(map, "type");
            }
            if (map.containsKey("source")) {
                String str5 = (String) ny0.b(map, "source");
            }
            if (map.containsKey("from")) {
                String str6 = (String) ny0.b(map, "from");
            }
            if (map.containsKey("pd")) {
                String str7 = (String) ny0.b(map, "pd");
            }
            if (map.containsKey("tpl")) {
                String str8 = (String) ny0.b(map, "tpl");
            }
            if (map.containsKey("ext_request")) {
                String str9 = (String) ny0.b(map, "ext_request");
            }
        }
    }
}
