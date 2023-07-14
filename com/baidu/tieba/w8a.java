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
/* loaded from: classes8.dex */
public final class w8a extends f51 {
    public static /* synthetic */ Interceptable $ic;
    public static final x41 f;
    public static final x41 g;
    public static final x41 h;
    public static final x41 i;
    public static final x41[] j;
    public static final x41[][] k;
    public static final x41[] l;
    public transient /* synthetic */ FieldHolder $fh;
    public final StringColumn a;
    public final StringColumn b;
    public final LongColumn c;
    public final LongColumn d;
    public final Column[] e;

    @Override // com.baidu.tieba.f51
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "forum_visited_info" : (String) invokeV.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948225833, "Lcom/baidu/tieba/w8a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948225833, "Lcom/baidu/tieba/w8a;");
                return;
            }
        }
        f = f51.a(4, "fid", "         fid", 0);
        g = f51.a(4, GfhKeyValue.TYPE_DATE, "        date", 1);
        h = f51.a(3, "custom_count", "custom_count", 2);
        x41 a = f51.a(3, "latest_time", " latest_time", 3);
        i = a;
        x41 x41Var = f;
        x41 x41Var2 = g;
        j = new x41[]{x41Var, x41Var2, h, a};
        k = new x41[][]{new x41[]{x41Var}, new x41[]{x41Var2}, new x41[]{a}};
        l = new x41[0];
    }

    public w8a() {
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

    @Override // com.baidu.tieba.f51
    public Column[] c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.e;
        }
        return (Column[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.f51
    public x41[] d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return j;
        }
        return (x41[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.f51
    public x41[][] e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return k;
        }
        return (x41[][]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.f51
    public x41[] f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return l;
        }
        return (x41[]) invokeV.objValue;
    }
}
