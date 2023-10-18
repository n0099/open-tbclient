package com.baidu.tieba;

import com.baidu.android.imsdk.chatmessage.messages.gfh.GfhKeyValue;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.sweetsqlite.Column;
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
public final class oaa extends bz0 {
    public static /* synthetic */ Interceptable $ic;
    public static final ty0 f;
    public static final ty0 g;
    public static final ty0 h;
    public static final ty0 i;
    public static final ty0[] j;
    public static final ty0[][] k;
    public static final ty0[] l;
    public transient /* synthetic */ FieldHolder $fh;
    public final StringColumn a;
    public final StringColumn b;
    public final LongColumn c;
    public final LongColumn d;
    public final Column[] e;

    @Override // com.baidu.tieba.bz0
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "forum_visited_info" : (String) invokeV.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948026906, "Lcom/baidu/tieba/oaa;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948026906, "Lcom/baidu/tieba/oaa;");
                return;
            }
        }
        f = bz0.a(4, "fid", "         fid", 0);
        g = bz0.a(4, GfhKeyValue.TYPE_DATE, "        date", 1);
        h = bz0.a(3, "custom_count", "custom_count", 2);
        ty0 a = bz0.a(3, "latest_time", " latest_time", 3);
        i = a;
        ty0 ty0Var = f;
        ty0 ty0Var2 = g;
        j = new ty0[]{ty0Var, ty0Var2, h, a};
        k = new ty0[][]{new ty0[]{ty0Var}, new ty0[]{ty0Var2}, new ty0[]{a}};
        l = new ty0[0];
    }

    public oaa() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new StringColumn(f);
        this.b = new StringColumn(g);
        this.c = new LongColumn(h);
        LongColumn longColumn = new LongColumn(i);
        this.d = longColumn;
        this.e = new Column[]{this.a, this.b, this.c, longColumn};
    }

    @Override // com.baidu.tieba.bz0
    public Column[] c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.e;
        }
        return (Column[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bz0
    public ty0[] d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return j;
        }
        return (ty0[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bz0
    public ty0[][] e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return k;
        }
        return (ty0[][]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bz0
    public ty0[] f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return l;
        }
        return (ty0[]) invokeV.objValue;
    }
}
