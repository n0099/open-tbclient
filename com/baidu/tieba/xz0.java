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
/* loaded from: classes9.dex */
public class xz0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public final ArrayList<String> b;
    public final StringBuilder c;

    public xz0() {
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

    public static xz0 g(Column column) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, column)) == null) {
            return i(column.field, column.stringValue());
        }
        return (xz0) invokeL.objValue;
    }

    public static xz0 h(nz0 nz0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, nz0Var)) == null) {
            xz0 xz0Var = new xz0();
            xz0Var.f(null, nz0Var, " = ?");
            return xz0Var;
        }
        return (xz0) invokeL.objValue;
    }

    public static xz0 k(Column... columnArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, columnArr)) == null) {
            xz0 g = g(columnArr[0]);
            for (int i = 1; i < columnArr.length; i++) {
                g.b(columnArr[i].field, columnArr[i].stringValue());
            }
            return g;
        }
        return (xz0) invokeL.objValue;
    }

    public xz0 d(Object... objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, objArr)) == null) {
            for (Object obj : objArr) {
                this.b.add(String.valueOf(obj));
            }
            return this;
        }
        return (xz0) invokeL.objValue;
    }

    public static xz0 i(nz0 nz0Var, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, nz0Var, obj)) == null) {
            xz0 h = h(nz0Var);
            h.d(obj);
            return h;
        }
        return (xz0) invokeLL.objValue;
    }

    public xz0 b(nz0 nz0Var, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nz0Var, obj)) == null) {
            c(null, nz0Var, obj);
            return this;
        }
        return (xz0) invokeLL.objValue;
    }

    public static xz0 j(String str, nz0 nz0Var, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, nz0Var, str2)) == null) {
            xz0 xz0Var = new xz0();
            xz0Var.f(str, nz0Var, str2);
            return xz0Var;
        }
        return (xz0) invokeLLL.objValue;
    }

    public xz0 a(String str, nz0 nz0Var, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, nz0Var, str2)) == null) {
            this.a = true;
            this.c.append(" AND ");
            f(str, nz0Var, str2);
            return this;
        }
        return (xz0) invokeLLL.objValue;
    }

    public xz0 c(String str, nz0 nz0Var, Object obj) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, nz0Var, obj)) == null) {
            a(str, nz0Var, " = ?");
            d(obj);
            return this;
        }
        return (xz0) invokeLLL.objValue;
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

    public final void f(String str, nz0 nz0Var, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, str, nz0Var, str2) == null) {
            if (nz0Var != null) {
                if (str != null) {
                    this.c.append(str);
                    this.c.append(".");
                }
                this.c.append(nz0Var.b);
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
