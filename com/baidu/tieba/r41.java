package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.sweetsqlite.Column;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class r41 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public final ArrayList<String> b;
    public final StringBuilder c;

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
        this.a = false;
        this.b = new ArrayList<>();
        this.c = new StringBuilder();
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append((CharSequence) this.c);
            if (this.a) {
                sb.insert(0, "(");
                sb.append(SmallTailInfo.EMOTION_SUFFIX);
            }
            sb.insert(0, " WHERE ");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public static r41 g(Column column) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, column)) == null) {
            return i(column.field, column.stringValue());
        }
        return (r41) invokeL.objValue;
    }

    public static r41 h(h41 h41Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, h41Var)) == null) {
            r41 r41Var = new r41();
            r41Var.f(null, h41Var, " = ?");
            return r41Var;
        }
        return (r41) invokeL.objValue;
    }

    public static r41 k(Column... columnArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, columnArr)) == null) {
            r41 g = g(columnArr[0]);
            for (int i = 1; i < columnArr.length; i++) {
                g.b(columnArr[i].field, columnArr[i].stringValue());
            }
            return g;
        }
        return (r41) invokeL.objValue;
    }

    public r41 d(Object... objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, objArr)) == null) {
            for (Object obj : objArr) {
                this.b.add(String.valueOf(obj));
            }
            return this;
        }
        return (r41) invokeL.objValue;
    }

    public static r41 i(h41 h41Var, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, h41Var, obj)) == null) {
            r41 h = h(h41Var);
            h.d(obj);
            return h;
        }
        return (r41) invokeLL.objValue;
    }

    public r41 b(h41 h41Var, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, h41Var, obj)) == null) {
            c(null, h41Var, obj);
            return this;
        }
        return (r41) invokeLL.objValue;
    }

    public static r41 j(String str, h41 h41Var, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, h41Var, str2)) == null) {
            r41 r41Var = new r41();
            r41Var.f(str, h41Var, str2);
            return r41Var;
        }
        return (r41) invokeLLL.objValue;
    }

    public r41 a(String str, h41 h41Var, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, h41Var, str2)) == null) {
            this.a = true;
            this.c.append(" AND ");
            f(str, h41Var, str2);
            return this;
        }
        return (r41) invokeLLL.objValue;
    }

    public r41 c(String str, h41 h41Var, Object obj) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, h41Var, obj)) == null) {
            a(str, h41Var, " = ?");
            d(obj);
            return this;
        }
        return (r41) invokeLLL.objValue;
    }

    public String[] e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            String[] strArr = new String[this.b.size()];
            for (int i = 0; i < this.b.size(); i++) {
                strArr[i] = this.b.get(i);
            }
            return strArr;
        }
        return (String[]) invokeV.objValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append((CharSequence) this.c);
            if (this.a) {
                sb.insert(0, "(");
                sb.append(SmallTailInfo.EMOTION_SUFFIX);
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public final void f(String str, h41 h41Var, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, str, h41Var, str2) == null) {
            if (h41Var != null) {
                if (str != null) {
                    this.c.append(str);
                    this.c.append(".");
                }
                this.c.append(h41Var.b);
                if (str2.charAt(0) != ' ') {
                    this.c.append(" ");
                }
            } else if (str != null) {
                throw new IllegalArgumentException("prefix should be null when field is null");
            }
            this.c.append(str2);
        }
    }
}
