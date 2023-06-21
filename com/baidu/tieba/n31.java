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
/* loaded from: classes6.dex */
public final class n31 extends g41 {
    public static /* synthetic */ Interceptable $ic;
    public static final y31 A;
    public static final y31[] B;
    public static final y31[][] C;
    public static final y31[] D;
    public static final y31 o;
    public static final y31 p;
    public static final y31 q;
    public static final y31 r;
    public static final y31 s;
    public static final y31 t;
    public static final y31 u;
    public static final y31 v;
    public static final y31 w;
    public static final y31 x;
    public static final y31 y;
    public static final y31 z;
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

    @Override // com.baidu.tieba.g41
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "t_apk_info" : (String) invokeV.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947951421, "Lcom/baidu/tieba/n31;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947951421, "Lcom/baidu/tieba/n31;");
                return;
            }
        }
        o = g41.b(4, "key", "                   key", 0, 2);
        p = g41.a(2, "task_id", "               task_id", 1);
        q = g41.a(2, "status", "                status", 2);
        r = g41.a(4, "package_name", "          package_name", 3);
        s = g41.a(4, "url", "                   url", 4);
        t = g41.a(4, "file", "                  file", 5);
        u = g41.a(2, "progress", "              progress", 6);
        v = g41.a(2, "v_progress", "            v_progress", 7);
        w = g41.a(3, "start_download_time", "   start_download_time", 8);
        x = g41.a(3, "finished_download_time", "finished_download_time", 9);
        y = g41.a(4, "mt", "                    mt", 10);
        z = g41.a(4, "ctrl", "                  ctrl", 11);
        y31 a = g41.a(4, "extra", "                 extra", 12);
        A = a;
        y31 y31Var = o;
        B = new y31[]{y31Var, p, q, r, s, t, u, v, w, x, y, z, a};
        C = new y31[0];
        D = new y31[]{y31Var};
    }

    public n31() {
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

    @Override // com.baidu.tieba.g41
    public Column[] c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.n;
        }
        return (Column[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.g41
    public y31[] d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return B;
        }
        return (y31[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.g41
    public y31[][] e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return C;
        }
        return (y31[][]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.g41
    public y31[] f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return D;
        }
        return (y31[]) invokeV.objValue;
    }
}
