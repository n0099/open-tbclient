package com.baidu.tieba;

import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.reflect.ReflectionException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteKey;
import com.baidu.tieba.d8;
import com.baidu.tieba.h7;
import com.baidu.tieba.v7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class o5<T> implements v7.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d8<String, b> a;
    public h7<b> b;
    public h7<a> c;
    public T d;

    /* loaded from: classes5.dex */
    public static class a<T> implements v7.c {
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

        @Override // com.baidu.tieba.v7.c
        public void a(v7 v7Var, JsonValue jsonValue) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, v7Var, jsonValue) == null) {
                this.a = (String) v7Var.l(BreakpointSQLiteKey.FILENAME, String.class, jsonValue);
                String str = (String) v7Var.l("type", String.class, jsonValue);
                try {
                    this.b = a9.a(str);
                } catch (ReflectionException e) {
                    throw new GdxRuntimeException("Class not found: " + str, e);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements v7.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public s7 a;
        public o5 b;

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
            new d8();
            this.a = new s7();
        }

        @Override // com.baidu.tieba.v7.c
        public void a(v7 v7Var, JsonValue jsonValue) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, v7Var, jsonValue) == null) {
                d8 d8Var = (d8) v7Var.l("data", d8.class, jsonValue);
                this.a.b((int[]) v7Var.l("indices", int[].class, jsonValue));
            }
        }
    }

    public o5() {
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
        this.a = new d8<>();
        this.b = new h7<>(true, 3, b.class);
        this.c = new h7<>();
    }

    @Override // com.baidu.tieba.v7.c
    public void a(v7 v7Var, JsonValue jsonValue) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, v7Var, jsonValue) == null) {
            d8<String, b> d8Var = (d8) v7Var.l("unique", d8.class, jsonValue);
            this.a = d8Var;
            d8.a<String, b> b2 = d8Var.b();
            b2.c();
            while (b2.hasNext()) {
                ((b) b2.next().b).b = this;
            }
            h7<b> h7Var = (h7) v7Var.m("data", h7.class, b.class, jsonValue);
            this.b = h7Var;
            h7.b<b> it = h7Var.iterator();
            while (it.hasNext()) {
                it.next().b = this;
            }
            this.c.b((h7) v7Var.m("assets", h7.class, a.class, jsonValue));
            this.d = (T) v7Var.l("resource", null, jsonValue);
        }
    }

    public h7<a> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c;
        }
        return (h7) invokeV.objValue;
    }
}
