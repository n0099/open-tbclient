package com.baidu.tieba;

import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.reflect.ReflectionException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteKey;
import com.baidu.tieba.c7;
import com.baidu.tieba.k7;
import com.baidu.tieba.o6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class v4<T> implements c7.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public k7<String, b> a;
    public o6<b> b;
    public o6<a> c;
    public T d;

    /* loaded from: classes7.dex */
    public static class a<T> implements c7.c {
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

        @Override // com.baidu.tieba.c7.c
        public void a(c7 c7Var, JsonValue jsonValue) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, c7Var, jsonValue) == null) {
                this.a = (String) c7Var.l(BreakpointSQLiteKey.FILENAME, String.class, jsonValue);
                String str = (String) c7Var.l("type", String.class, jsonValue);
                try {
                    this.b = h8.a(str);
                } catch (ReflectionException e) {
                    throw new GdxRuntimeException("Class not found: " + str, e);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements c7.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public z6 a;
        public v4 b;

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
            new k7();
            this.a = new z6();
        }

        @Override // com.baidu.tieba.c7.c
        public void a(c7 c7Var, JsonValue jsonValue) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, c7Var, jsonValue) == null) {
                k7 k7Var = (k7) c7Var.l("data", k7.class, jsonValue);
                this.a.b((int[]) c7Var.l("indices", int[].class, jsonValue));
            }
        }
    }

    public v4() {
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
        this.a = new k7<>();
        this.b = new o6<>(true, 3, b.class);
        this.c = new o6<>();
    }

    @Override // com.baidu.tieba.c7.c
    public void a(c7 c7Var, JsonValue jsonValue) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, c7Var, jsonValue) == null) {
            k7<String, b> k7Var = (k7) c7Var.l("unique", k7.class, jsonValue);
            this.a = k7Var;
            k7.a<String, b> b2 = k7Var.b();
            b2.c();
            while (b2.hasNext()) {
                ((b) b2.next().b).b = this;
            }
            o6<b> o6Var = (o6) c7Var.m("data", o6.class, b.class, jsonValue);
            this.b = o6Var;
            o6.b<b> it = o6Var.iterator();
            while (it.hasNext()) {
                it.next().b = this;
            }
            this.c.b((o6) c7Var.m("assets", o6.class, a.class, jsonValue));
            this.d = (T) c7Var.l("resource", null, jsonValue);
        }
    }

    public o6<a> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c;
        }
        return (o6) invokeV.objValue;
    }
}
