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
/* loaded from: classes7.dex */
public final class p31 extends i41 {
    public static /* synthetic */ Interceptable $ic;
    public static final a41 A;
    public static final a41[] B;
    public static final a41[][] C;
    public static final a41[] D;
    public static final a41 o;
    public static final a41 p;
    public static final a41 q;
    public static final a41 r;
    public static final a41 s;
    public static final a41 t;
    public static final a41 u;
    public static final a41 v;
    public static final a41 w;
    public static final a41 x;
    public static final a41 y;
    public static final a41 z;
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

    @Override // com.baidu.tieba.i41
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "t_apk_info" : (String) invokeV.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948011003, "Lcom/baidu/tieba/p31;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948011003, "Lcom/baidu/tieba/p31;");
                return;
            }
        }
        o = i41.b(4, "key", "                   key", 0, 2);
        p = i41.a(2, "task_id", "               task_id", 1);
        q = i41.a(2, "status", "                status", 2);
        r = i41.a(4, "package_name", "          package_name", 3);
        s = i41.a(4, "url", "                   url", 4);
        t = i41.a(4, "file", "                  file", 5);
        u = i41.a(2, "progress", "              progress", 6);
        v = i41.a(2, "v_progress", "            v_progress", 7);
        w = i41.a(3, "start_download_time", "   start_download_time", 8);
        x = i41.a(3, "finished_download_time", "finished_download_time", 9);
        y = i41.a(4, "mt", "                    mt", 10);
        z = i41.a(4, "ctrl", "                  ctrl", 11);
        a41 a = i41.a(4, "extra", "                 extra", 12);
        A = a;
        a41 a41Var = o;
        B = new a41[]{a41Var, p, q, r, s, t, u, v, w, x, y, z, a};
        C = new a41[0];
        D = new a41[]{a41Var};
    }

    public p31() {
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

    @Override // com.baidu.tieba.i41
    public Column[] c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.n;
        }
        return (Column[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.i41
    public a41[] d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return B;
        }
        return (a41[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.i41
    public a41[][] e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return C;
        }
        return (a41[][]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.i41
    public a41[] f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return D;
        }
        return (a41[]) invokeV.objValue;
    }
}
