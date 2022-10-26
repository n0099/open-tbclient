package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class ug {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final LinkedHashMap a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;

    public void b(boolean z, Object obj, Object obj2, Object obj3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), obj, obj2, obj3}) == null) {
        }
    }

    public int m(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, obj, obj2)) == null) {
            return 1;
        }
        return invokeLL.intValue;
    }

    public ug(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = i;
        this.a = new LinkedHashMap(0, 0.75f, true);
    }

    public final synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                c();
                this.d = 0;
                this.e = 0;
                this.f = 0;
                this.g = 0;
            }
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            n(-1);
        }
    }

    public final synchronized int d() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this) {
                i = this.e;
            }
            return i;
        }
        return invokeV.intValue;
    }

    public final synchronized int g() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this) {
                i = this.c;
            }
            return i;
        }
        return invokeV.intValue;
    }

    public final synchronized int l() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            synchronized (this) {
                i = this.b;
            }
            return i;
        }
        return invokeV.intValue;
    }

    public synchronized boolean e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            synchronized (this) {
                if (this.b + i > this.c * 0.8d) {
                    n(this.b - i);
                }
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public final Object f(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (obj == null) {
                return null;
            }
            synchronized (this) {
                Object obj2 = this.a.get(obj);
                if (obj2 != null) {
                    this.f++;
                    return obj2;
                }
                this.g++;
                return null;
            }
        }
        return invokeL.objValue;
    }

    public final Object i(Object obj) {
        InterceptResult invokeL;
        Object remove;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj)) == null) {
            if (obj == null) {
                return null;
            }
            synchronized (this) {
                remove = this.a.remove(obj);
                if (remove != null) {
                    this.b -= j(obj, remove);
                }
            }
            if (remove != null) {
                b(false, obj, remove, null);
            }
            return remove;
        }
        return invokeL.objValue;
    }

    public final void k(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            synchronized (this) {
                this.c = i;
                n(i);
            }
        }
    }

    public final Object h(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Object put;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, obj, obj2)) == null) {
            if (obj != null && obj2 != null) {
                synchronized (this) {
                    this.d++;
                    this.b += j(obj, obj2);
                    put = this.a.put(obj, obj2);
                    if (put != null) {
                        this.b -= j(obj, put);
                    }
                }
                if (put != null) {
                    b(false, obj, put, obj2);
                }
                n(this.c);
                return put;
            }
            return null;
        }
        return invokeLL.objValue;
    }

    public final int j(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, obj, obj2)) == null) {
            int m = m(obj, obj2);
            if (m >= 0) {
                return m;
            }
            throw new IllegalStateException("Negative size: " + obj + "=" + obj2);
        }
        return invokeLL.intValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0074, code lost:
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void n(int i) {
        Object key;
        Object value;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            while (true) {
                synchronized (this) {
                    if (this.b >= 0 && (!this.a.isEmpty() || this.b == 0)) {
                        if (this.b <= i || this.a.isEmpty()) {
                            break;
                        }
                        Map.Entry entry = (Map.Entry) this.a.entrySet().iterator().next();
                        key = entry.getKey();
                        value = entry.getValue();
                        this.a.remove(key);
                        this.b -= j(key, value);
                        this.e++;
                    } else {
                        break;
                    }
                }
                b(true, key, value, null);
            }
        }
    }
}
