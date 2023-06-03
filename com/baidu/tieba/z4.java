package com.baidu.tieba;

import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.reflect.ReflectionException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteKey;
import com.baidu.searchbox.download.lightdownload.LightFileUtils;
import com.baidu.tieba.g7;
import com.baidu.tieba.o7;
import com.baidu.tieba.s6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class z4<T> implements g7.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public o7<String, b> a;
    public s6<b> b;
    public s6<a> c;
    public T d;

    /* loaded from: classes8.dex */
    public static class a<T> implements g7.c {
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

        @Override // com.baidu.tieba.g7.c
        public void a(g7 g7Var, JsonValue jsonValue) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, g7Var, jsonValue) == null) {
                this.a = (String) g7Var.l(BreakpointSQLiteKey.FILENAME, String.class, jsonValue);
                String str = (String) g7Var.l("type", String.class, jsonValue);
                try {
                    this.b = l8.a(str);
                } catch (ReflectionException e) {
                    throw new GdxRuntimeException("Class not found: " + str, e);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b implements g7.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public d7 a;
        public z4 b;

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
            new o7();
            this.a = new d7();
        }

        @Override // com.baidu.tieba.g7.c
        public void a(g7 g7Var, JsonValue jsonValue) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, g7Var, jsonValue) == null) {
                o7 o7Var = (o7) g7Var.l("data", o7.class, jsonValue);
                this.a.b((int[]) g7Var.l("indices", int[].class, jsonValue));
            }
        }
    }

    public z4() {
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
        this.a = new o7<>();
        this.b = new s6<>(true, 3, b.class);
        this.c = new s6<>();
    }

    @Override // com.baidu.tieba.g7.c
    public void a(g7 g7Var, JsonValue jsonValue) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, g7Var, jsonValue) == null) {
            o7<String, b> o7Var = (o7) g7Var.l("unique", o7.class, jsonValue);
            this.a = o7Var;
            o7.a<String, b> b2 = o7Var.b();
            b2.c();
            while (b2.hasNext()) {
                ((b) b2.next().b).b = this;
            }
            s6<b> s6Var = (s6) g7Var.m("data", s6.class, b.class, jsonValue);
            this.b = s6Var;
            s6.b<b> it = s6Var.iterator();
            while (it.hasNext()) {
                it.next().b = this;
            }
            this.c.b((s6) g7Var.m("assets", s6.class, a.class, jsonValue));
            this.d = (T) g7Var.l(LightFileUtils.DIRCTORY_DOWNLOAD_RESOURCE, null, jsonValue);
        }
    }

    public s6<a> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c;
        }
        return (s6) invokeV.objValue;
    }
}
