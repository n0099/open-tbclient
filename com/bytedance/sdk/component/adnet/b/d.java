package com.bytedance.sdk.component.adnet.b;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.adnet.core.Request;
import com.bytedance.sdk.component.adnet.core.m;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* loaded from: classes9.dex */
public class d<T> implements m.a<T>, Future<m<T>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Request<?> f64051a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f64052b;

    /* renamed from: c  reason: collision with root package name */
    public m<T> f64053c;

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f64052b = false;
    }

    public static <E> d<E> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new d<>() : (d) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.concurrent.Future
    /* renamed from: b */
    public m<T> get() throws InterruptedException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                return a((Long) null);
            } catch (TimeoutException e2) {
                throw new AssertionError(e2);
            }
        }
        return (m) invokeV.objValue;
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean cancel(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
            synchronized (this) {
                if (this.f64051a == null) {
                    return false;
                }
                if (isDone()) {
                    return false;
                }
                this.f64051a.cancel();
                return true;
            }
        }
        return invokeZ.booleanValue;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            Request<?> request = this.f64051a;
            if (request == null) {
                return false;
            }
            return request.isCanceled();
        }
        return invokeV.booleanValue;
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isDone() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            synchronized (this) {
                if (!this.f64052b) {
                    z = isCancelled();
                }
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.concurrent.Future
    /* renamed from: a */
    public m<T> get(long j2, @NonNull TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j2, timeUnit)) == null) ? a(Long.valueOf(TimeUnit.MILLISECONDS.convert(j2, timeUnit))) : (m) invokeJL.objValue;
    }

    private synchronized m<T> a(Long l) throws InterruptedException, TimeoutException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, l)) == null) {
            synchronized (this) {
                if (this.f64052b) {
                    return this.f64053c;
                }
                if (l == null) {
                    while (!isDone()) {
                        wait(0L);
                    }
                } else if (l.longValue() > 0) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    long longValue = l.longValue() + uptimeMillis;
                    while (!isDone() && uptimeMillis < longValue) {
                        wait(longValue - uptimeMillis);
                        uptimeMillis = SystemClock.uptimeMillis();
                    }
                }
                if (this.f64052b) {
                    return this.f64053c;
                }
                throw new TimeoutException();
            }
        }
        return (m) invokeL.objValue;
    }

    @Override // com.bytedance.sdk.component.adnet.core.m.a
    public synchronized void b(m<T> mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, mVar) == null) {
            synchronized (this) {
                this.f64052b = true;
                this.f64053c = mVar;
                notifyAll();
            }
        }
    }

    @Override // com.bytedance.sdk.component.adnet.core.m.a
    public synchronized void a(m<T> mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mVar) == null) {
            synchronized (this) {
                this.f64052b = true;
                this.f64053c = mVar;
                notifyAll();
            }
        }
    }
}
