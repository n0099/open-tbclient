package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.xe;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public abstract class pe<T> implements we<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean a;
    public final qe b;

    public abstract se<T> i(String str);

    public abstract void j(se<T> seVar);

    public abstract void l(String str);

    public abstract void m(String str);

    public pe(qe qeVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qeVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = qeVar;
        this.a = z;
    }

    @Override // com.baidu.tieba.we
    public T a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            se<T> k = k(str, str2);
            if (k == null) {
                return null;
            }
            return k.b;
        }
        return (T) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.we
    public void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            l(h(str, str2));
        }
    }

    @Override // com.baidu.tieba.we
    public xe.b<T> e(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            se<T> k = k(str, str2);
            if (k == null) {
                return null;
            }
            xe.b<T> bVar = new xe.b<>();
            bVar.a = str2;
            bVar.b = k.b;
            long j = k.f;
            bVar.c = k.d;
            return bVar;
        }
        return (xe.b) invokeLL.objValue;
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

    @Override // com.baidu.tieba.we
    public qe c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return (qe) invokeV.objValue;
    }

    @Override // com.baidu.tieba.we
    public void f(String str, String str2, T t, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, str2, t, Long.valueOf(j)}) == null) {
            se<T> seVar = new se<>();
            seVar.a = h(str, str2);
            seVar.c = str;
            seVar.f = j;
            seVar.b = t;
            seVar.e = System.currentTimeMillis();
            seVar.d = System.currentTimeMillis();
            j(seVar);
        }
    }

    public se<T> k(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2)) == null) {
            String h = h(str, str2);
            se<T> i = i(h);
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
        return (se) invokeLL.objValue;
    }
}
