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
/* loaded from: classes6.dex */
public class m41 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<a> a;
    public final List<k41> b;
    public String c;
    public String d;
    public i41 e;
    public j41 f;
    public l41 g;
    public int h;
    public int i;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String a;
        public final y31[] b;

        public a(String str, y31[] y31VarArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, y31VarArr};
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
            this.b = y31VarArr;
        }
    }

    public m41() {
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

    public static m41 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return new m41();
        }
        return (m41) invokeV.objValue;
    }

    public String[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            i41 i41Var = this.e;
            if (i41Var == null) {
                return null;
            }
            return i41Var.e();
        }
        return (String[]) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return d(null).toString();
        }
        return (String) invokeV.objValue;
    }

    public m41 a(String str, y31... y31VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, y31VarArr)) == null) {
            this.a.add(new a(str, y31VarArr));
            return this;
        }
        return (m41) invokeLL.objValue;
    }

    public m41 c(String str, h41 h41Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, h41Var)) == null) {
            this.d = str;
            this.c = h41Var.b().g();
            return this;
        }
        return (m41) invokeLL.objValue;
    }

    public final StringBuilder d(StringBuilder sb) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, sb)) == null) {
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
            for (k41 k41Var : this.b) {
                sb.append(k41Var.c());
            }
            i41 i41Var = this.e;
            if (i41Var != null) {
                sb.append(i41Var.k());
            }
            j41 j41Var = this.f;
            if (j41Var != null) {
                sb.append(j41Var.a());
            }
            l41 l41Var = this.g;
            if (l41Var != null) {
                sb.append(l41Var.a());
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
}
