package com.baidu.tieba;

import com.baidu.android.imsdk.chatmessage.messages.NetDiskFileMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.sweetsqlite.Column;
import com.baidu.nadcore.sweetsqlite.IntegerColumn;
import com.baidu.nadcore.sweetsqlite.LongColumn;
import com.baidu.nadcore.sweetsqlite.StringColumn;
import com.baidu.tbadk.core.util.TiebaMainDatabaseHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public final class tna extends sz0 {
    public static /* synthetic */ Interceptable $ic;
    public static final kz0 l;
    public static final kz0 m;
    public static final kz0 n;
    public static final kz0 o;
    public static final kz0 p;
    public static final kz0 q;
    public static final kz0 r;
    public static final kz0 s;
    public static final kz0 t;
    public static final kz0 u;
    public static final kz0[] v;
    public static final kz0[][] w;
    public static final kz0[] x;
    public transient /* synthetic */ FieldHolder $fh;
    public final LongColumn a;
    public final LongColumn b;
    public final LongColumn c;
    public final StringColumn d;
    public final StringColumn e;
    public final StringColumn f;
    public final StringColumn g;
    public final IntegerColumn h;
    public final StringColumn i;
    public final StringColumn j;
    public final Column[] k;

    @Override // com.baidu.tieba.sz0
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? TiebaMainDatabaseHelper.TABLE_DOWNLOAD_MULTI_INFO : (String) invokeV.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948188354, "Lcom/baidu/tieba/tna;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948188354, "Lcom/baidu/tieba/tna;");
                return;
            }
        }
        l = sz0.b(3, "id", "                    id", 0, 3);
        m = sz0.a(3, "start_download_time", "   start_download_time", 1);
        n = sz0.a(3, "finished_download_time", "finished_download_time", 2);
        o = sz0.a(4, "download_url", "          download_url", 3);
        p = sz0.a(4, "package_name", "          package_name", 4);
        q = sz0.a(4, "title", "                 title", 5);
        r = sz0.a(4, "detail_info", "           detail_info", 6);
        s = sz0.a(2, "source", "                source", 7);
        t = sz0.a(4, "extra", "                 extra", 8);
        kz0 a = sz0.a(4, NetDiskFileMsg.NetDiskFile.JSON_KEY_FILE_TYPE, "             file_type", 9);
        u = a;
        kz0 kz0Var = l;
        v = new kz0[]{kz0Var, m, n, o, p, q, r, s, t, a};
        w = new kz0[0];
        x = new kz0[]{kz0Var};
    }

    public tna() {
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
        this.a = new LongColumn(l);
        this.b = new LongColumn(m);
        this.c = new LongColumn(n);
        this.d = new StringColumn(o);
        this.e = new StringColumn(p);
        this.f = new StringColumn(q);
        this.g = new StringColumn(r);
        this.h = new IntegerColumn(s);
        this.i = new StringColumn(t);
        StringColumn stringColumn = new StringColumn(u);
        this.j = stringColumn;
        this.k = new Column[]{this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, stringColumn};
    }

    @Override // com.baidu.tieba.sz0
    public Column[] c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.k;
        }
        return (Column[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sz0
    public kz0[] d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return v;
        }
        return (kz0[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sz0
    public kz0[][] e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return w;
        }
        return (kz0[][]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sz0
    public kz0[] f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return x;
        }
        return (kz0[]) invokeV.objValue;
    }
}
