package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class kr<K, V> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final LinkedHashMap<K, V> a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;

    public V a(K k) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, k)) == null) {
            return null;
        }
        return (V) invokeL.objValue;
    }

    public void b(boolean z, K k, V v, V v2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), k, v, v2}) == null) {
        }
    }

    public int f(K k, V v) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, k, v)) == null) {
            return 1;
        }
        return invokeLL.intValue;
    }

    public kr(int i) {
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
        if (i > 0) {
            this.c = i;
            this.a = new LinkedHashMap<>(0, 0.75f, true);
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    public final V c(K k) {
        InterceptResult invokeL;
        V put;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, k)) == null) {
            if (k != null) {
                synchronized (this) {
                    V v = this.a.get(k);
                    if (v != null) {
                        this.g++;
                        return v;
                    }
                    this.h++;
                    V a = a(k);
                    if (a == null) {
                        return null;
                    }
                    synchronized (this) {
                        this.e++;
                        put = this.a.put(k, a);
                        if (put != null) {
                            this.a.put(k, put);
                        } else {
                            this.b += e(k, a);
                        }
                    }
                    if (put != null) {
                        b(false, k, a, put);
                        return put;
                    }
                    g(this.c);
                    return a;
                }
            }
            throw new NullPointerException("key == null");
        }
        return (V) invokeL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0074, code lost:
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void g(int i) {
        K key;
        V value;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            while (true) {
                synchronized (this) {
                    if (this.b >= 0 && (!this.a.isEmpty() || this.b == 0)) {
                        if (this.b <= i || this.a.isEmpty()) {
                            break;
                        }
                        Map.Entry<K, V> next = this.a.entrySet().iterator().next();
                        key = next.getKey();
                        value = next.getValue();
                        this.a.remove(key);
                        this.b -= e(key, value);
                        this.f++;
                    } else {
                        break;
                    }
                }
                b(true, key, value, null);
            }
        }
    }

    public final V d(K k, V v) {
        InterceptResult invokeLL;
        V put;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, k, v)) == null) {
            if (k != null && v != null) {
                synchronized (this) {
                    this.d++;
                    this.b += e(k, v);
                    put = this.a.put(k, v);
                    if (put != null) {
                        this.b -= e(k, put);
                    }
                }
                if (put != null) {
                    b(false, k, put, v);
                }
                g(this.c);
                return put;
            }
            throw new NullPointerException("key == null || value == null");
        }
        return (V) invokeLL.objValue;
    }

    public final int e(K k, V v) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, k, v)) == null) {
            int f = f(k, v);
            if (f >= 0) {
                return f;
            }
            throw new IllegalStateException("Negative size: " + k + "=" + v);
        }
        return invokeLL.intValue;
    }

    public final synchronized String toString() {
        InterceptResult invokeV;
        int i;
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            synchronized (this) {
                int i2 = this.g + this.h;
                if (i2 != 0) {
                    i = (this.g * 100) / i2;
                } else {
                    i = 0;
                }
                format = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.c), Integer.valueOf(this.g), Integer.valueOf(this.h), Integer.valueOf(i));
            }
            return format;
        }
        return (String) invokeV.objValue;
    }
}
