package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes7.dex */
public class s14 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile HashMap<String, List<a24>> a;

    public s14() {
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
        this.a = new HashMap<>();
    }

    public synchronized void a(String str, a24 a24Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, a24Var) == null) {
            synchronized (this) {
                if (e(str, a24Var)) {
                    return;
                }
                List<a24> c = c(str);
                if (!c.contains(a24Var)) {
                    c.add(a24Var);
                }
                if (!this.a.containsKey(str)) {
                    this.a.put(str, c);
                }
            }
        }
    }

    public synchronized void b(String str, b24 b24Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, b24Var) == null) {
            synchronized (this) {
                for (a24 a24Var : new ArrayList(c(str))) {
                    if (a24Var != null) {
                        a24Var.a(b24Var);
                    }
                }
            }
        }
    }

    public synchronized void g(String str, a24 a24Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, a24Var) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (a24Var == null) {
                    this.a.remove(str);
                    return;
                }
                List<a24> c = c(str);
                if (c.contains(a24Var)) {
                    c.remove(a24Var);
                    if (c.isEmpty()) {
                        this.a.remove(str);
                    }
                }
            }
        }
    }

    public final List<a24> c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return new ArrayList();
            }
            List<a24> list = this.a.get(str);
            if (list == null) {
                return new ArrayList();
            }
            return list;
        }
        return (List) invokeL.objValue;
    }

    public synchronized boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            synchronized (this) {
                boolean z = false;
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                List<a24> list = this.a.get(str);
                if (list != null) {
                    if (!list.isEmpty()) {
                        z = true;
                    }
                }
                return z;
            }
        }
        return invokeL.booleanValue;
    }

    public synchronized void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            synchronized (this) {
                g(str, null);
            }
        }
    }

    public final boolean e(String str, a24 a24Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, a24Var)) == null) {
            if (!TextUtils.isEmpty(str) && a24Var != null) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
