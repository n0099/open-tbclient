package com.baidu.tieba;

import android.os.Handler;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
/* loaded from: classes5.dex */
public final class lm3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mm3 a;
        public final /* synthetic */ Object b;

        public a(mm3 mm3Var, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mm3Var, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mm3Var;
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

    public static <T> void a(Handler handler, mm3<T> mm3Var, Collection<T> collection) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65536, null, handler, mm3Var, collection) == null) && mm3Var != null && collection != null && !collection.isEmpty()) {
            for (T t : collection) {
                e(handler, mm3Var, t);
            }
        }
    }

    public static <T> void b(Handler handler, mm3<T> mm3Var, T... tArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65537, null, handler, mm3Var, tArr) == null) && mm3Var != null && tArr != null && tArr.length >= 1) {
            for (T t : tArr) {
                e(handler, mm3Var, t);
            }
        }
    }

    public static <T> void e(Handler handler, mm3<T> mm3Var, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, handler, mm3Var, t) == null) {
            if (handler == null) {
                mm3Var.a(t);
            } else {
                handler.post(new a(mm3Var, t));
            }
        }
    }

    public static <T> void c(mm3<T> mm3Var, Collection<T> collection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, mm3Var, collection) == null) {
            a(null, mm3Var, collection);
        }
    }

    public static <T> void d(mm3<T> mm3Var, T... tArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, mm3Var, tArr) == null) {
            b(null, mm3Var, tArr);
        }
    }
}
