package com.baidu.tieba;

import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.reflect.ReflectionException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteKey;
import com.baidu.tieba.g7;
import com.baidu.tieba.k6;
import com.baidu.tieba.y6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class r4<T> implements y6.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public g7<String, b> a;
    public k6<b> b;
    public k6<a> c;
    public T d;

    /* loaded from: classes6.dex */
    public static class a<T> implements y6.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public Class<T> b;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.y6.c
        public void a(y6 y6Var, JsonValue jsonValue) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, y6Var, jsonValue) == null) {
                this.a = (String) y6Var.l(BreakpointSQLiteKey.FILENAME, String.class, jsonValue);
                String str = (String) y6Var.l("type", String.class, jsonValue);
                try {
                    this.b = d8.a(str);
                } catch (ReflectionException e) {
                    throw new GdxRuntimeException("Class not found: " + str, e);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements y6.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public v6 a;
        public r4 b;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            new g7();
            this.a = new v6();
        }

        @Override // com.baidu.tieba.y6.c
        public void a(y6 y6Var, JsonValue jsonValue) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, y6Var, jsonValue) == null) {
                g7 g7Var = (g7) y6Var.l("data", g7.class, jsonValue);
                this.a.b((int[]) y6Var.l("indices", int[].class, jsonValue));
            }
        }
    }

    public r4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new g7<>();
        this.b = new k6<>(true, 3, b.class);
        this.c = new k6<>();
    }

    @Override // com.baidu.tieba.y6.c
    public void a(y6 y6Var, JsonValue jsonValue) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, y6Var, jsonValue) == null) {
            g7<String, b> g7Var = (g7) y6Var.l("unique", g7.class, jsonValue);
            this.a = g7Var;
            g7.a<String, b> b2 = g7Var.b();
            b2.c();
            while (b2.hasNext()) {
                ((b) b2.next().b).b = this;
            }
            k6<b> k6Var = (k6) y6Var.m("data", k6.class, b.class, jsonValue);
            this.b = k6Var;
            k6.b<b> it = k6Var.iterator();
            while (it.hasNext()) {
                it.next().b = this;
            }
            this.c.b((k6) y6Var.m("assets", k6.class, a.class, jsonValue));
            this.d = (T) y6Var.l("resource", null, jsonValue);
        }
    }

    public k6<a> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c;
        }
        return (k6) invokeV.objValue;
    }
}
