package com.baidu.tieba;

import android.os.Handler;
import android.os.Looper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
/* loaded from: classes7.dex */
public class za0 implements xa0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Handler a;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ va0 a;
        public final /* synthetic */ Object b;

        public a(za0 za0Var, va0 va0Var, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {za0Var, va0Var, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = va0Var;
            this.b = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.call(this.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ va0 a;
        public final /* synthetic */ Object b;

        public b(za0 za0Var, va0 va0Var, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {za0Var, va0Var, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = va0Var;
            this.b = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.call(this.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ va0 a;
        public final /* synthetic */ Object b;

        public c(za0 za0Var, va0 va0Var, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {za0Var, va0Var, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = va0Var;
            this.b = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.call(this.b);
            }
        }
    }

    public za0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new Handler(Looper.getMainLooper());
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.xa0
    public void a(int i, Object obj, va0 va0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048576, this, i, obj, va0Var) == null) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        va0Var.call(obj);
                    } else {
                        fb0.a(new c(this, va0Var, obj));
                    }
                } else if (b()) {
                    fb0.a(new b(this, va0Var, obj));
                } else {
                    va0Var.call(obj);
                }
            } else if (b()) {
                va0Var.call(obj);
            } else {
                this.a.post(new a(this, va0Var, obj));
            }
        }
    }

    public synchronized void c(WeakHashMap<Object, List<wa0>> weakHashMap, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, weakHashMap, obj) == null) {
            synchronized (this) {
                for (Map.Entry<Object, List<wa0>> entry : weakHashMap.entrySet()) {
                    if (entry != null && entry.getValue() != null) {
                        for (wa0 wa0Var : entry.getValue()) {
                            if (wa0Var.b(obj)) {
                                wa0Var.call(obj);
                            }
                        }
                    }
                }
            }
        }
    }

    public synchronized void d(WeakHashMap<Object, List<wa0>> weakHashMap, Object obj, Class<?> cls, int i, va0 va0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{weakHashMap, obj, cls, Integer.valueOf(i), va0Var}) == null) {
            synchronized (this) {
                List<wa0> list = null;
                if (weakHashMap.containsKey(obj)) {
                    list = weakHashMap.get(obj);
                }
                if (list == null) {
                    list = new ArrayList<>();
                    weakHashMap.put(obj, list);
                }
                list.add(new wa0(i, cls, va0Var, this));
            }
        }
    }

    public void e(WeakHashMap<Object, List<wa0>> weakHashMap, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, weakHashMap, obj) == null) {
            List<wa0> remove = weakHashMap.remove(obj);
            if (!kb0.c(remove)) {
                for (wa0 wa0Var : remove) {
                    wa0Var.a();
                }
            }
            remove.clear();
        }
    }
}
