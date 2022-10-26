package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class y0a extends c1a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y0a(int i) {
        super(i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (k() == h()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            long k = k();
            while (true) {
                long h = h();
                long k2 = k();
                if (k == k2) {
                    return (int) (h - k2);
                }
                k = k2;
            }
        } else {
            return invokeV.intValue;
        }
    }

    @Override // java.util.Queue
    public boolean offer(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            if (obj != null) {
                Object[] objArr = this.b;
                long j = this.a;
                long h = h();
                long a = a(h);
                if (e(objArr, a) != null) {
                    if (h - k() > j) {
                        return false;
                    }
                    do {
                    } while (e(objArr, a) != null);
                    g(objArr, a, obj);
                    i(h + 1);
                    return true;
                }
                g(objArr, a, obj);
                i(h + 1);
                return true;
            }
            throw new NullPointerException("Null is not a valid element");
        }
        return invokeL.booleanValue;
    }

    @Override // java.util.Queue
    public Object peek() {
        InterceptResult invokeV;
        Object d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            long l = l();
            do {
                long k = k();
                if (k >= l) {
                    long h = h();
                    if (k >= h) {
                        return null;
                    }
                    m(h);
                }
                d = d(a(k));
            } while (d == null);
            return d;
        }
        return invokeV.objValue;
    }

    @Override // java.util.Queue, com.baidu.tieba.w0a
    public Object poll() {
        InterceptResult invokeV;
        long k;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            long l = l();
            do {
                k = k();
                if (k >= l) {
                    long h = h();
                    if (k >= h) {
                        return null;
                    }
                    m(h);
                }
            } while (!j(k, 1 + k));
            long a = a(k);
            Object[] objArr = this.b;
            Object c = c(objArr, a);
            f(objArr, a, null);
            return c;
        }
        return invokeV.objValue;
    }
}
