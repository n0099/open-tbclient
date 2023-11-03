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
/* loaded from: classes9.dex */
public final class zy0 extends sz0 {
    public static /* synthetic */ Interceptable $ic;
    public static final kz0 A;
    public static final kz0[] B;
    public static final kz0[][] C;
    public static final kz0[] D;
    public static final kz0 o;
    public static final kz0 p;
    public static final kz0 q;
    public static final kz0 r;
    public static final kz0 s;
    public static final kz0 t;
    public static final kz0 u;
    public static final kz0 v;
    public static final kz0 w;
    public static final kz0 x;
    public static final kz0 y;
    public static final kz0 z;
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

    @Override // com.baidu.tieba.sz0
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "t_apk_info" : (String) invokeV.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948376152, "Lcom/baidu/tieba/zy0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948376152, "Lcom/baidu/tieba/zy0;");
                return;
            }
        }
        o = sz0.b(4, "key", "                   key", 0, 2);
        p = sz0.a(2, "task_id", "               task_id", 1);
        q = sz0.a(2, "status", "                status", 2);
        r = sz0.a(4, "package_name", "          package_name", 3);
        s = sz0.a(4, "url", "                   url", 4);
        t = sz0.a(4, "file", "                  file", 5);
        u = sz0.a(2, "progress", "              progress", 6);
        v = sz0.a(2, "v_progress", "            v_progress", 7);
        w = sz0.a(3, "start_download_time", "   start_download_time", 8);
        x = sz0.a(3, "finished_download_time", "finished_download_time", 9);
        y = sz0.a(4, "mt", "                    mt", 10);
        z = sz0.a(4, "ctrl", "                  ctrl", 11);
        kz0 a = sz0.a(4, "extra", "                 extra", 12);
        A = a;
        kz0 kz0Var = o;
        B = new kz0[]{kz0Var, p, q, r, s, t, u, v, w, x, y, z, a};
        C = new kz0[0];
        D = new kz0[]{kz0Var};
    }

    public zy0() {
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

    @Override // com.baidu.tieba.sz0
    public Column[] c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.n;
        }
        return (Column[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sz0
    public kz0[] d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return B;
        }
        return (kz0[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sz0
    public kz0[][] e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return C;
        }
        return (kz0[][]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sz0
    public kz0[] f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return D;
        }
        return (kz0[]) invokeV.objValue;
    }
}
