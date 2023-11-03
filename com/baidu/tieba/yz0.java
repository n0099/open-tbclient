package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class yz0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<a> a;
    public final List<wz0> b;
    public String c;
    public String d;
    public uz0 e;
    public vz0 f;
    public xz0 g;
    public int h;
    public int i;

    /* loaded from: classes9.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String a;
        public final kz0[] b;

        public a(String str, kz0[] kz0VarArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, kz0VarArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = kz0VarArr;
        }
    }

    public yz0() {
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
        this.a = new ArrayList(4);
        this.b = new ArrayList(2);
        this.h = -1;
        this.i = -1;
    }

    public static yz0 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return new yz0();
        }
        return (yz0) invokeV.objValue;
    }

    public String[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            uz0 uz0Var = this.e;
            if (uz0Var == null) {
                return null;
            }
            return uz0Var.e();
        }
        return (String[]) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return e(null).toString();
        }
        return (String) invokeV.objValue;
    }

    public yz0 a(String str, kz0... kz0VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, kz0VarArr)) == null) {
            this.a.add(new a(str, kz0VarArr));
            return this;
        }
        return (yz0) invokeLL.objValue;
    }

    public yz0 c(String str, tz0 tz0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, tz0Var)) == null) {
            this.d = str;
            this.c = tz0Var.b().g();
            return this;
        }
        return (yz0) invokeLL.objValue;
    }

    public yz0 d(String str, Class<? extends tz0> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, cls)) == null) {
            this.d = str;
            this.c = nz0.b(cls).g();
            return this;
        }
        return (yz0) invokeLL.objValue;
    }

    public uz0 h(kz0 kz0Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, kz0Var, str)) == null) {
            return i(null, kz0Var, str);
        }
        return (uz0) invokeLL.objValue;
    }

    public final StringBuilder e(StringBuilder sb) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, sb)) == null) {
            if (sb == null) {
                sb = new StringBuilder();
            }
            sb.append("SELECT ");
            int size = this.a.size();
            String str = "";
            for (int i = 0; i < size; i++) {
                int i2 = 0;
                while (i2 < this.a.get(i).b.length) {
                    sb.append(str);
                    String str2 = this.a.get(i).a;
                    if (!TextUtils.isEmpty(str2)) {
                        sb.append(str2);
                        sb.append(".");
                    }
                    sb.append(this.a.get(i).b[i2].b);
                    i2++;
                    str = StringUtil.ARRAY_ELEMENT_SEPARATOR;
                }
            }
            sb.append(" ");
            sb.append("FROM ");
            sb.append(this.c);
            if (!TextUtils.isEmpty(this.d)) {
                sb.append(" AS ");
                sb.append(this.d);
            }
            for (wz0 wz0Var : this.b) {
                sb.append(wz0Var.c());
            }
            uz0 uz0Var = this.e;
            if (uz0Var != null) {
                sb.append(uz0Var.l());
            }
            vz0 vz0Var = this.f;
            if (vz0Var != null) {
                sb.append(vz0Var.a());
            }
            xz0 xz0Var = this.g;
            if (xz0Var != null) {
                sb.append(xz0Var.a());
            }
            if (this.h > -1) {
                sb.append(" LIMIT ");
                sb.append(this.h);
            }
            if (this.i > -1) {
                sb.append(" OFFSET ");
                sb.append(this.i);
            }
            return sb;
        }
        return (StringBuilder) invokeL.objValue;
    }

    public uz0 i(String str, kz0 kz0Var, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, str, kz0Var, str2)) == null) {
            uz0 j = uz0.j(str, kz0Var, str2);
            this.e = j;
            return j;
        }
        return (uz0) invokeLLL.objValue;
    }
}
