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
public class yw {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final LinkedHashMap a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;

    public Object a(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            return null;
        }
        return invokeL.objValue;
    }

    public void b(boolean z, Object obj, Object obj2, Object obj3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), obj, obj2, obj3}) == null) {
        }
    }

    public int f(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, obj, obj2)) == null) {
            return 1;
        }
        return invokeLL.intValue;
    }

    public yw(int i) {
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
            this.a = new LinkedHashMap(0, 0.75f, true);
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    public final Object c(Object obj) {
        InterceptResult invokeL;
        Object put;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            if (obj != null) {
                synchronized (this) {
                    Object obj2 = this.a.get(obj);
                    if (obj2 != null) {
                        this.g++;
                        return obj2;
                    }
                    this.h++;
                    Object a = a(obj);
                    if (a == null) {
                        return null;
                    }
                    synchronized (this) {
                        this.e++;
                        put = this.a.put(obj, a);
                        if (put != null) {
                            this.a.put(obj, put);
                        } else {
                            this.b += e(obj, a);
                        }
                    }
                    if (put != null) {
                        b(false, obj, a, put);
                        return put;
                    }
                    g(this.c);
                    return a;
                }
            }
            throw new NullPointerException("key == null");
        }
        return invokeL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0074, code lost:
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void g(int i) {
        Object key;
        Object value;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
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

    public final Object d(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Object put;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, obj, obj2)) == null) {
            if (obj != null && obj2 != null) {
                synchronized (this) {
                    this.d++;
                    this.b += e(obj, obj2);
                    put = this.a.put(obj, obj2);
                    if (put != null) {
                        this.b -= e(obj, put);
                    }
                }
                if (put != null) {
                    b(false, obj, put, obj2);
                }
                g(this.c);
                return put;
            }
            throw new NullPointerException("key == null || value == null");
        }
        return invokeLL.objValue;
    }

    public final int e(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, obj, obj2)) == null) {
            int f = f(obj, obj2);
            if (f >= 0) {
                return f;
            }
            throw new IllegalStateException("Negative size: " + obj + "=" + obj2);
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
