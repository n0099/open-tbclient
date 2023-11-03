package com.baidu.tieba;

import android.os.Handler;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
/* loaded from: classes9.dex */
public final class yk3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zk3 a;
        public final /* synthetic */ Object b;

        public a(zk3 zk3Var, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zk3Var, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zk3Var;
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

    public static <T> void a(Handler handler, zk3<T> zk3Var, Collection<T> collection) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65536, null, handler, zk3Var, collection) == null) && zk3Var != null && collection != null && !collection.isEmpty()) {
            for (T t : collection) {
                e(handler, zk3Var, t);
            }
        }
    }

    public static <T> void b(Handler handler, zk3<T> zk3Var, T... tArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65537, null, handler, zk3Var, tArr) == null) && zk3Var != null && tArr != null && tArr.length >= 1) {
            for (T t : tArr) {
                e(handler, zk3Var, t);
            }
        }
    }

    public static <T> void e(Handler handler, zk3<T> zk3Var, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, handler, zk3Var, t) == null) {
            if (handler == null) {
                zk3Var.a(t);
            } else {
                handler.post(new a(zk3Var, t));
            }
        }
    }

    public static <T> void c(zk3<T> zk3Var, Collection<T> collection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, zk3Var, collection) == null) {
            a(null, zk3Var, collection);
        }
    }

    public static <T> void d(zk3<T> zk3Var, T... tArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, zk3Var, tArr) == null) {
            b(null, zk3Var, tArr);
        }
    }
}
