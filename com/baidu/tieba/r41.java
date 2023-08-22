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
/* loaded from: classes7.dex */
public class r41 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<a> a;
    public final List<p41> b;
    public String c;
    public String d;
    public n41 e;
    public o41 f;
    public q41 g;
    public int h;
    public int i;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String a;
        public final d41[] b;

        public a(String str, d41[] d41VarArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, d41VarArr};
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
            this.b = d41VarArr;
        }
    }

    public r41() {
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

    public static r41 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return new r41();
        }
        return (r41) invokeV.objValue;
    }

    public String[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            n41 n41Var = this.e;
            if (n41Var == null) {
                return null;
            }
            return n41Var.e();
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

    public r41 a(String str, d41... d41VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, d41VarArr)) == null) {
            this.a.add(new a(str, d41VarArr));
            return this;
        }
        return (r41) invokeLL.objValue;
    }

    public r41 c(String str, m41 m41Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, m41Var)) == null) {
            this.d = str;
            this.c = m41Var.b().g();
            return this;
        }
        return (r41) invokeLL.objValue;
    }

    public r41 d(String str, Class<? extends m41> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, cls)) == null) {
            this.d = str;
            this.c = g41.b(cls).g();
            return this;
        }
        return (r41) invokeLL.objValue;
    }

    public n41 h(d41 d41Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, d41Var, str)) == null) {
            return i(null, d41Var, str);
        }
        return (n41) invokeLL.objValue;
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
            for (p41 p41Var : this.b) {
                sb.append(p41Var.c());
            }
            n41 n41Var = this.e;
            if (n41Var != null) {
                sb.append(n41Var.l());
            }
            o41 o41Var = this.f;
            if (o41Var != null) {
                sb.append(o41Var.a());
            }
            q41 q41Var = this.g;
            if (q41Var != null) {
                sb.append(q41Var.a());
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

    public n41 i(String str, d41 d41Var, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, str, d41Var, str2)) == null) {
            n41 j = n41.j(str, d41Var, str2);
            this.e = j;
            return j;
        }
        return (n41) invokeLLL.objValue;
    }
}
