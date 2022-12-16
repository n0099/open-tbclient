package com.baidu.tieba;

import android.os.Handler;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
/* loaded from: classes6.dex */
public final class wi3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xi3 a;
        public final /* synthetic */ Object b;

        public a(xi3 xi3Var, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xi3Var, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xi3Var;
            this.b = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a(this.b);
            }
        }
    }

    public static <T> void a(Handler handler, xi3<T> xi3Var, Collection<T> collection) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65536, null, handler, xi3Var, collection) == null) && xi3Var != null && collection != null && !collection.isEmpty()) {
            for (T t : collection) {
                e(handler, xi3Var, t);
            }
        }
    }

    public static <T> void b(Handler handler, xi3<T> xi3Var, T... tArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65537, null, handler, xi3Var, tArr) == null) && xi3Var != null && tArr != null && tArr.length >= 1) {
            for (T t : tArr) {
                e(handler, xi3Var, t);
            }
        }
    }

    public static <T> void e(Handler handler, xi3<T> xi3Var, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, handler, xi3Var, t) == null) {
            if (handler == null) {
                xi3Var.a(t);
            } else {
                handler.post(new a(xi3Var, t));
            }
        }
    }

    public static <T> void c(xi3<T> xi3Var, Collection<T> collection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, xi3Var, collection) == null) {
            a(null, xi3Var, collection);
        }
    }

    public static <T> void d(xi3<T> xi3Var, T... tArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, xi3Var, tArr) == null) {
            b(null, xi3Var, tArr);
        }
    }
}
