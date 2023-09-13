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
/* loaded from: classes8.dex */
public class v41 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<a> a;
    public final List<t41> b;
    public String c;
    public String d;
    public r41 e;
    public s41 f;
    public u41 g;
    public int h;
    public int i;

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String a;
        public final h41[] b;

        public a(String str, h41[] h41VarArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, h41VarArr};
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
            this.b = h41VarArr;
        }
    }

    public v41() {
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

    public static v41 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return new v41();
        }
        return (v41) invokeV.objValue;
    }

    public String[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            r41 r41Var = this.e;
            if (r41Var == null) {
                return null;
            }
            return r41Var.e();
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

    public v41 a(String str, h41... h41VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, h41VarArr)) == null) {
            this.a.add(new a(str, h41VarArr));
            return this;
        }
        return (v41) invokeLL.objValue;
    }

    public v41 c(String str, q41 q41Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, q41Var)) == null) {
            this.d = str;
            this.c = q41Var.b().g();
            return this;
        }
        return (v41) invokeLL.objValue;
    }

    public v41 d(String str, Class<? extends q41> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, cls)) == null) {
            this.d = str;
            this.c = k41.b(cls).g();
            return this;
        }
        return (v41) invokeLL.objValue;
    }

    public r41 h(h41 h41Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, h41Var, str)) == null) {
            return i(null, h41Var, str);
        }
        return (r41) invokeLL.objValue;
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
            for (t41 t41Var : this.b) {
                sb.append(t41Var.c());
            }
            r41 r41Var = this.e;
            if (r41Var != null) {
                sb.append(r41Var.l());
            }
            s41 s41Var = this.f;
            if (s41Var != null) {
                sb.append(s41Var.a());
            }
            u41 u41Var = this.g;
            if (u41Var != null) {
                sb.append(u41Var.a());
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

    public r41 i(String str, h41 h41Var, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, str, h41Var, str2)) == null) {
            r41 j = r41.j(str, h41Var, str2);
            this.e = j;
            return j;
        }
        return (r41) invokeLLL.objValue;
    }
}
