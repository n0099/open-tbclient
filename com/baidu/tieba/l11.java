package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.sweetsqlite.Column;
import com.baidu.nadcore.sweetsqlite.IntegerColumn;
import com.baidu.nadcore.sweetsqlite.LongColumn;
import com.baidu.nadcore.sweetsqlite.StringColumn;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public final class l11 extends e21 {
    public static /* synthetic */ Interceptable $ic;
    public static final w11 A;
    public static final w11[] B;
    public static final w11[][] C;
    public static final w11[] D;
    public static final w11 o;
    public static final w11 p;
    public static final w11 q;
    public static final w11 r;
    public static final w11 s;
    public static final w11 t;
    public static final w11 u;
    public static final w11 v;
    public static final w11 w;
    public static final w11 x;
    public static final w11 y;
    public static final w11 z;
    public transient /* synthetic */ FieldHolder $fh;
    public final StringColumn a;
    public final IntegerColumn b;
    public final IntegerColumn c;
    public final StringColumn d;
    public final StringColumn e;
    public final StringColumn f;
    public final IntegerColumn g;
    public final IntegerColumn h;
    public final LongColumn i;
    public final LongColumn j;
    public final StringColumn k;
    public final StringColumn l;
    public final StringColumn m;
    public final Column[] n;

    @Override // com.baidu.tieba.e21
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "t_apk_info" : (String) invokeV.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947889917, "Lcom/baidu/tieba/l11;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947889917, "Lcom/baidu/tieba/l11;");
                return;
            }
        }
        o = e21.b(4, "key", "                   key", 0, 2);
        p = e21.a(2, "task_id", "               task_id", 1);
        q = e21.a(2, "status", "                status", 2);
        r = e21.a(4, "package_name", "          package_name", 3);
        s = e21.a(4, "url", "                   url", 4);
        t = e21.a(4, "file", "                  file", 5);
        u = e21.a(2, "progress", "              progress", 6);
        v = e21.a(2, "v_progress", "            v_progress", 7);
        w = e21.a(3, "start_download_time", "   start_download_time", 8);
        x = e21.a(3, "finished_download_time", "finished_download_time", 9);
        y = e21.a(4, "mt", "                    mt", 10);
        z = e21.a(4, "ctrl", "                  ctrl", 11);
        w11 a = e21.a(4, "extra", "                 extra", 12);
        A = a;
        w11 w11Var = o;
        B = new w11[]{w11Var, p, q, r, s, t, u, v, w, x, y, z, a};
        C = new w11[0];
        D = new w11[]{w11Var};
    }

    public l11() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new StringColumn(o);
        this.b = new IntegerColumn(p);
        this.c = new IntegerColumn(q);
        this.d = new StringColumn(r);
        this.e = new StringColumn(s);
        this.f = new StringColumn(t);
        this.g = new IntegerColumn(u);
        this.h = new IntegerColumn(v);
        this.i = new LongColumn(w);
        this.j = new LongColumn(x);
        this.k = new StringColumn(y);
        this.l = new StringColumn(z);
        StringColumn stringColumn = new StringColumn(A);
        this.m = stringColumn;
        this.n = new Column[]{this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, stringColumn};
    }

    @Override // com.baidu.tieba.e21
    public Column[] c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.n;
        }
        return (Column[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.e21
    public w11[] d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return B;
        }
        return (w11[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.e21
    public w11[][] e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return C;
        }
        return (w11[][]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.e21
    public w11[] f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return D;
        }
        return (w11[]) invokeV.objValue;
    }
}
