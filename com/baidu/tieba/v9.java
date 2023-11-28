package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.da;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public abstract class v9<T> implements ca<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean a;
    public final w9 b;

    public abstract y9<T> h(String str);

    public abstract void i(y9<T> y9Var);

    public abstract void k(String str);

    public abstract void l(String str);

    public v9(w9 w9Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {w9Var, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = w9Var;
        this.a = z;
    }

    @Override // com.baidu.tieba.ca
    public w9 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return (w9) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ca
    public void c(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            k(g(str, str2));
        }
    }

    @Override // com.baidu.tieba.ca
    public da.b<T> d(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            y9<T> j = j(str, str2);
            if (j == null) {
                return null;
            }
            da.b<T> bVar = new da.b<>();
            bVar.a = str2;
            bVar.b = j.b;
            long j2 = j.f;
            bVar.c = j.d;
            return bVar;
        }
        return (da.b) invokeLL.objValue;
    }

    public String g(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, str2)) == null) {
            if (this.a) {
                return str + "@" + str2;
            }
            return str2;
        }
        return (String) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.ca
    public T get(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, str2)) == null) {
            y9<T> j = j(str, str2);
            if (j == null) {
                return null;
            }
            return j.b;
        }
        return (T) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.ca
    public void e(String str, String str2, T t, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, str2, t, Long.valueOf(j)}) == null) {
            y9<T> y9Var = new y9<>();
            y9Var.a = g(str, str2);
            y9Var.c = str;
            y9Var.f = j;
            y9Var.b = t;
            y9Var.e = System.currentTimeMillis();
            y9Var.d = System.currentTimeMillis();
            i(y9Var);
        }
    }

    public y9<T> j(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2)) == null) {
            String g = g(str, str2);
            y9<T> h = h(g);
            if (h == null) {
                BdLog.isDebugMode();
                return null;
            } else if (h.f < System.currentTimeMillis()) {
                l(g);
                BdLog.isDebugMode();
                return null;
            } else {
                if (this.b.a()) {
                    h.e = System.currentTimeMillis();
                    i(h);
                }
                BdLog.isDebugMode();
                return h;
            }
        }
        return (y9) invokeLL.objValue;
    }
}
