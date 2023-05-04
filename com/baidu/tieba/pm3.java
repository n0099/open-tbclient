package com.baidu.tieba;

import android.os.Handler;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
/* loaded from: classes5.dex */
public final class pm3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qm3 a;
        public final /* synthetic */ Object b;

        public a(qm3 qm3Var, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qm3Var, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qm3Var;
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

    public static <T> void a(Handler handler, qm3<T> qm3Var, Collection<T> collection) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65536, null, handler, qm3Var, collection) == null) && qm3Var != null && collection != null && !collection.isEmpty()) {
            for (T t : collection) {
                e(handler, qm3Var, t);
            }
        }
    }

    public static <T> void b(Handler handler, qm3<T> qm3Var, T... tArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65537, null, handler, qm3Var, tArr) == null) && qm3Var != null && tArr != null && tArr.length >= 1) {
            for (T t : tArr) {
                e(handler, qm3Var, t);
            }
        }
    }

    public static <T> void e(Handler handler, qm3<T> qm3Var, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, handler, qm3Var, t) == null) {
            if (handler == null) {
                qm3Var.a(t);
            } else {
                handler.post(new a(qm3Var, t));
            }
        }
    }

    public static <T> void c(qm3<T> qm3Var, Collection<T> collection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, qm3Var, collection) == null) {
            a(null, qm3Var, collection);
        }
    }

    public static <T> void d(qm3<T> qm3Var, T... tArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, qm3Var, tArr) == null) {
            b(null, qm3Var, tArr);
        }
    }
}
