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
public abstract class tw0 implements dw0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public cy0 a;

    public abstract void f(lv0 lv0Var);

    public abstract void g(lv0 lv0Var);

    public abstract void h(lv0 lv0Var);

    public abstract void i(lv0 lv0Var);

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948195484, "Lcom/baidu/tieba/tw0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948195484, "Lcom/baidu/tieba/tw0;");
                return;
            }
        }
        qs0.f();
    }

    public tw0(Map<String, String> map) {
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

    @Override // com.baidu.tieba.dw0
    public final <T extends yx0> void d(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
            this.a = (cy0) t;
        }
    }

    @Override // com.baidu.tieba.ew0
    public final void c(lv0 lv0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, lv0Var) == null) && lv0Var != null && this.a != null) {
            int type = lv0Var.getType();
            if (type != 1) {
                if (type != 2) {
                    if (type != 3) {
                        if (type == 4) {
                            h(lv0Var);
                            return;
                        }
                        return;
                    }
                    g(lv0Var);
                    return;
                }
                f(lv0Var);
                return;
            }
            i(lv0Var);
        }
    }

    public void j(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, map) == null) && map != null && map.size() > 0) {
            if (map.containsKey(WriteActivityConfig.VIDEO_INFO)) {
                String str = (String) q11.b(map, WriteActivityConfig.VIDEO_INFO);
            }
            if (map.containsKey("channel_id")) {
                String str2 = (String) q11.b(map, "channel_id");
            }
            if (map.containsKey("channel_title")) {
                String str3 = (String) q11.b(map, "channel_title");
            }
            if (map.containsKey("type")) {
                String str4 = (String) q11.b(map, "type");
            }
            if (map.containsKey("source")) {
                String str5 = (String) q11.b(map, "source");
            }
            if (map.containsKey("from")) {
                String str6 = (String) q11.b(map, "from");
            }
            if (map.containsKey("pd")) {
                String str7 = (String) q11.b(map, "pd");
            }
            if (map.containsKey("tpl")) {
                String str8 = (String) q11.b(map, "tpl");
            }
            if (map.containsKey("ext_request")) {
                String str9 = (String) q11.b(map, "ext_request");
            }
        }
    }
}
