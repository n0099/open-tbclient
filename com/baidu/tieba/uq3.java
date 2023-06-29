package com.baidu.tieba;

import android.os.Handler;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
/* loaded from: classes8.dex */
public final class uq3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vq3 a;
        public final /* synthetic */ Object b;

        public a(vq3 vq3Var, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vq3Var, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vq3Var;
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

    public static <T> void a(Handler handler, vq3<T> vq3Var, Collection<T> collection) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65536, null, handler, vq3Var, collection) == null) && vq3Var != null && collection != null && !collection.isEmpty()) {
            for (T t : collection) {
                e(handler, vq3Var, t);
            }
        }
    }

    public static <T> void b(Handler handler, vq3<T> vq3Var, T... tArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65537, null, handler, vq3Var, tArr) == null) && vq3Var != null && tArr != null && tArr.length >= 1) {
            for (T t : tArr) {
                e(handler, vq3Var, t);
            }
        }
    }

    public static <T> void e(Handler handler, vq3<T> vq3Var, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, handler, vq3Var, t) == null) {
            if (handler == null) {
                vq3Var.a(t);
            } else {
                handler.post(new a(vq3Var, t));
            }
        }
    }

    public static <T> void c(vq3<T> vq3Var, Collection<T> collection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, vq3Var, collection) == null) {
            a(null, vq3Var, collection);
        }
    }

    public static <T> void d(vq3<T> vq3Var, T... tArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, vq3Var, tArr) == null) {
            b(null, vq3Var, tArr);
        }
    }
}
