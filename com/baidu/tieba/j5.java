package com.baidu.tieba;

import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.reflect.ReflectionException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteKey;
import com.baidu.tieba.c7;
import com.baidu.tieba.q7;
import com.baidu.tieba.y7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class j5<T> implements q7.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public y7<String, b> a;
    public c7<b> b;
    public c7<a> c;
    public T d;

    /* loaded from: classes5.dex */
    public static class a<T> implements q7.c {
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

        @Override // com.baidu.tieba.q7.c
        public void a(q7 q7Var, JsonValue jsonValue) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, q7Var, jsonValue) == null) {
                this.a = (String) q7Var.l(BreakpointSQLiteKey.FILENAME, String.class, jsonValue);
                String str = (String) q7Var.l("type", String.class, jsonValue);
                try {
                    this.b = v8.a(str);
                } catch (ReflectionException e) {
                    throw new GdxRuntimeException("Class not found: " + str, e);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements q7.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public n7 a;
        public j5 b;

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
            new y7();
            this.a = new n7();
        }

        @Override // com.baidu.tieba.q7.c
        public void a(q7 q7Var, JsonValue jsonValue) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, q7Var, jsonValue) == null) {
                y7 y7Var = (y7) q7Var.l("data", y7.class, jsonValue);
                this.a.b((int[]) q7Var.l("indices", int[].class, jsonValue));
            }
        }
    }

    public j5() {
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
        this.a = new y7<>();
        this.b = new c7<>(true, 3, b.class);
        this.c = new c7<>();
    }

    @Override // com.baidu.tieba.q7.c
    public void a(q7 q7Var, JsonValue jsonValue) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, q7Var, jsonValue) == null) {
            y7<String, b> y7Var = (y7) q7Var.l("unique", y7.class, jsonValue);
            this.a = y7Var;
            y7.a<String, b> b2 = y7Var.b();
            b2.c();
            while (b2.hasNext()) {
                ((b) b2.next().b).b = this;
            }
            c7<b> c7Var = (c7) q7Var.m("data", c7.class, b.class, jsonValue);
            this.b = c7Var;
            c7.b<b> it = c7Var.iterator();
            while (it.hasNext()) {
                it.next().b = this;
            }
            this.c.b((c7) q7Var.m("assets", c7.class, a.class, jsonValue));
            this.d = (T) q7Var.l("resource", null, jsonValue);
        }
    }

    public c7<a> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c;
        }
        return (c7) invokeV.objValue;
    }
}
