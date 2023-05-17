package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.se;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public abstract class ke<T> implements re<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean a;
    public final le b;

    public abstract ne<T> i(String str);

    public abstract void j(ne<T> neVar);

    public abstract void l(String str);

    public abstract void m(String str);

    public ke(le leVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {leVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = leVar;
        this.a = z;
    }

    @Override // com.baidu.tieba.re
    public T a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            ne<T> k = k(str, str2);
            if (k == null) {
                return null;
            }
            return k.b;
        }
        return (T) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.re
    public void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            l(h(str, str2));
        }
    }

    @Override // com.baidu.tieba.re
    public se.b<T> e(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            ne<T> k = k(str, str2);
            if (k == null) {
                return null;
            }
            se.b<T> bVar = new se.b<>();
            bVar.a = str2;
            bVar.b = k.b;
            long j = k.f;
            bVar.c = k.d;
            return bVar;
        }
        return (se.b) invokeLL.objValue;
    }

    public String h(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, str2)) == null) {
            if (this.a) {
                return str + "@" + str2;
            }
            return str2;
        }
        return (String) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.re
    public le c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return (le) invokeV.objValue;
    }

    @Override // com.baidu.tieba.re
    public void f(String str, String str2, T t, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, str2, t, Long.valueOf(j)}) == null) {
            ne<T> neVar = new ne<>();
            neVar.a = h(str, str2);
            neVar.c = str;
            neVar.f = j;
            neVar.b = t;
            neVar.e = System.currentTimeMillis();
            neVar.d = System.currentTimeMillis();
            j(neVar);
        }
    }

    public ne<T> k(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2)) == null) {
            String h = h(str, str2);
            ne<T> i = i(h);
            if (i == null) {
                BdLog.isDebugMode();
                return null;
            } else if (i.f < System.currentTimeMillis()) {
                m(h);
                BdLog.isDebugMode();
                return null;
            } else {
                if (this.b.a()) {
                    i.e = System.currentTimeMillis();
                    j(i);
                }
                BdLog.isDebugMode();
                return i;
            }
        }
        return (ne) invokeLL.objValue;
    }
}
