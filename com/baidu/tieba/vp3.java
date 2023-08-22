package com.baidu.tieba;

import android.os.Handler;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
/* loaded from: classes8.dex */
public final class vp3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wp3 a;
        public final /* synthetic */ Object b;

        public a(wp3 wp3Var, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wp3Var, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wp3Var;
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

    public static <T> void a(Handler handler, wp3<T> wp3Var, Collection<T> collection) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65536, null, handler, wp3Var, collection) == null) && wp3Var != null && collection != null && !collection.isEmpty()) {
            for (T t : collection) {
                e(handler, wp3Var, t);
            }
        }
    }

    public static <T> void b(Handler handler, wp3<T> wp3Var, T... tArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65537, null, handler, wp3Var, tArr) == null) && wp3Var != null && tArr != null && tArr.length >= 1) {
            for (T t : tArr) {
                e(handler, wp3Var, t);
            }
        }
    }

    public static <T> void e(Handler handler, wp3<T> wp3Var, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, handler, wp3Var, t) == null) {
            if (handler == null) {
                wp3Var.a(t);
            } else {
                handler.post(new a(wp3Var, t));
            }
        }
    }

    public static <T> void c(wp3<T> wp3Var, Collection<T> collection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, wp3Var, collection) == null) {
            a(null, wp3Var, collection);
        }
    }

    public static <T> void d(wp3<T> wp3Var, T... tArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, wp3Var, tArr) == null) {
            b(null, wp3Var, tArr);
        }
    }
}
