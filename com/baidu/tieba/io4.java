package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class io4<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<lo4<T>> a;

    public io4() {
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
        this.a = new ArrayList(6);
    }

    public void a(lo4<T> lo4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, lo4Var) == null) && lo4Var != null && !this.a.contains(lo4Var)) {
            this.a.add(lo4Var);
        }
    }

    public T b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList<lo4> arrayList = new ArrayList();
            Iterator<lo4<T>> it = this.a.iterator();
            T t = null;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                lo4<T> next = it.next();
                T t2 = next.get();
                if (c(t2)) {
                    t = t2;
                    break;
                }
                arrayList.add(next);
                t = t2;
            }
            if (arrayList.size() > 0) {
                for (lo4 lo4Var : arrayList) {
                    lo4Var.put(t);
                }
            }
            return t;
        }
        return (T) invokeV.objValue;
    }

    public final boolean c(T t) {
        InterceptResult invokeL;
        char[] charArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t)) == null) {
            if (t == null || !(t instanceof String)) {
                return false;
            }
            String str = (String) t;
            if (str.length() != 32) {
                return false;
            }
            for (char c : str.toCharArray()) {
                if ((c < 'A' || c > 'Z') && (c < '0' || c > '9')) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void d(T t) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, t) != null) || c(t)) {
            return;
        }
        for (lo4<T> lo4Var : this.a) {
            if (lo4Var.a()) {
                lo4Var.put(t);
            }
        }
    }
}
