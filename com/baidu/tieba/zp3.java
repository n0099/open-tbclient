package com.baidu.tieba;

import android.os.Handler;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
/* loaded from: classes9.dex */
public final class zp3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aq3 a;
        public final /* synthetic */ Object b;

        public a(aq3 aq3Var, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aq3Var, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aq3Var;
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

    public static <T> void a(Handler handler, aq3<T> aq3Var, Collection<T> collection) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65536, null, handler, aq3Var, collection) == null) && aq3Var != null && collection != null && !collection.isEmpty()) {
            for (T t : collection) {
                e(handler, aq3Var, t);
            }
        }
    }

    public static <T> void b(Handler handler, aq3<T> aq3Var, T... tArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65537, null, handler, aq3Var, tArr) == null) && aq3Var != null && tArr != null && tArr.length >= 1) {
            for (T t : tArr) {
                e(handler, aq3Var, t);
            }
        }
    }

    public static <T> void e(Handler handler, aq3<T> aq3Var, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, handler, aq3Var, t) == null) {
            if (handler == null) {
                aq3Var.a(t);
            } else {
                handler.post(new a(aq3Var, t));
            }
        }
    }

    public static <T> void c(aq3<T> aq3Var, Collection<T> collection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, aq3Var, collection) == null) {
            a(null, aq3Var, collection);
        }
    }

    public static <T> void d(aq3<T> aq3Var, T... tArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, aq3Var, tArr) == null) {
            b(null, aq3Var, tArr);
        }
    }
}
