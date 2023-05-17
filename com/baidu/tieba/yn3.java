package com.baidu.tieba;

import android.os.Handler;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
/* loaded from: classes8.dex */
public final class yn3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zn3 a;
        public final /* synthetic */ Object b;

        public a(zn3 zn3Var, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zn3Var, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zn3Var;
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

    public static <T> void a(Handler handler, zn3<T> zn3Var, Collection<T> collection) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65536, null, handler, zn3Var, collection) == null) && zn3Var != null && collection != null && !collection.isEmpty()) {
            for (T t : collection) {
                e(handler, zn3Var, t);
            }
        }
    }

    public static <T> void b(Handler handler, zn3<T> zn3Var, T... tArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65537, null, handler, zn3Var, tArr) == null) && zn3Var != null && tArr != null && tArr.length >= 1) {
            for (T t : tArr) {
                e(handler, zn3Var, t);
            }
        }
    }

    public static <T> void e(Handler handler, zn3<T> zn3Var, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, handler, zn3Var, t) == null) {
            if (handler == null) {
                zn3Var.a(t);
            } else {
                handler.post(new a(zn3Var, t));
            }
        }
    }

    public static <T> void c(zn3<T> zn3Var, Collection<T> collection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, zn3Var, collection) == null) {
            a(null, zn3Var, collection);
        }
    }

    public static <T> void d(zn3<T> zn3Var, T... tArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, zn3Var, tArr) == null) {
            b(null, zn3Var, tArr);
        }
    }
}
