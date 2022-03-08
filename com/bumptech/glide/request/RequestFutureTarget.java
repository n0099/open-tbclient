package com.bumptech.glide.request;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Util;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* loaded from: classes7.dex */
public class RequestFutureTarget<R> implements FutureTarget<R>, RequestListener<R>, Runnable {
    public static /* synthetic */ Interceptable $ic;
    public static final Waiter DEFAULT_WAITER;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean assertBackgroundThread;
    @Nullable
    public GlideException exception;
    public final int height;
    public boolean isCancelled;
    public boolean loadFailed;
    public final Handler mainHandler;
    @Nullable
    public Request request;
    @Nullable
    public R resource;
    public boolean resultReceived;
    public final Waiter waiter;
    public final int width;

    @VisibleForTesting
    /* loaded from: classes7.dex */
    public static class Waiter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Waiter() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public void notifyAll(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                obj.notifyAll();
            }
        }

        public void waitForTimeout(Object obj, long j2) throws InterruptedException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, j2) == null) {
                obj.wait(j2);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(734796747, "Lcom/bumptech/glide/request/RequestFutureTarget;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(734796747, "Lcom/bumptech/glide/request/RequestFutureTarget;");
                return;
            }
        }
        DEFAULT_WAITER = new Waiter();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RequestFutureTarget(Handler handler, int i2, int i3) {
        this(handler, i2, i3, true, DEFAULT_WAITER);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {handler, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Handler) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), ((Boolean) objArr2[3]).booleanValue(), (Waiter) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private void clearOnMainThread() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.mainHandler.post(this);
        }
    }

    private synchronized R doGet(Long l) throws ExecutionException, InterruptedException, TimeoutException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, l)) == null) {
            synchronized (this) {
                if (this.assertBackgroundThread && !isDone()) {
                    Util.assertBackgroundThread();
                }
                if (!this.isCancelled) {
                    if (!this.loadFailed) {
                        if (this.resultReceived) {
                            return this.resource;
                        }
                        if (l == null) {
                            this.waiter.waitForTimeout(this, 0L);
                        } else if (l.longValue() > 0) {
                            long currentTimeMillis = System.currentTimeMillis();
                            long longValue = l.longValue() + currentTimeMillis;
                            while (!isDone() && currentTimeMillis < longValue) {
                                this.waiter.waitForTimeout(this, longValue - currentTimeMillis);
                                currentTimeMillis = System.currentTimeMillis();
                            }
                        }
                        if (!Thread.interrupted()) {
                            if (!this.loadFailed) {
                                if (!this.isCancelled) {
                                    if (this.resultReceived) {
                                        return this.resource;
                                    }
                                    throw new TimeoutException();
                                }
                                throw new CancellationException();
                            }
                            throw new ExecutionException(this.exception);
                        }
                        throw new InterruptedException();
                    }
                    throw new ExecutionException(this.exception);
                }
                throw new CancellationException();
            }
        }
        return (R) invokeL.objValue;
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean cancel(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            synchronized (this) {
                if (isDone()) {
                    return false;
                }
                this.isCancelled = true;
                this.waiter.notifyAll(this);
                if (z) {
                    clearOnMainThread();
                }
                return true;
            }
        }
        return invokeZ.booleanValue;
    }

    @Override // java.util.concurrent.Future
    public R get() throws InterruptedException, ExecutionException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            try {
                return doGet(null);
            } catch (TimeoutException e2) {
                throw new AssertionError(e2);
            }
        }
        return (R) invokeV.objValue;
    }

    @Override // com.bumptech.glide.request.target.Target
    @Nullable
    public Request getRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.request : (Request) invokeV.objValue;
    }

    @Override // com.bumptech.glide.request.target.Target
    public void getSize(@NonNull SizeReadyCallback sizeReadyCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, sizeReadyCallback) == null) {
            sizeReadyCallback.onSizeReady(this.width, this.height);
        }
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isCancelled() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                z = this.isCancelled;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isDone() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this) {
                if (!this.isCancelled && !this.resultReceived) {
                    z = this.loadFailed;
                }
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadCleared(@Nullable Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, drawable) == null) {
        }
    }

    @Override // com.bumptech.glide.request.target.Target
    public synchronized void onLoadFailed(@Nullable Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, drawable) == null) {
            synchronized (this) {
            }
        }
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadStarted(@Nullable Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, drawable) == null) {
        }
    }

    @Override // com.bumptech.glide.request.target.Target
    public synchronized void onResourceReady(@NonNull R r, @Nullable Transition<? super R> transition) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, r, transition) == null) {
            synchronized (this) {
            }
        }
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
        }
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
        }
    }

    @Override // com.bumptech.glide.request.target.Target
    public void removeCallback(@NonNull SizeReadyCallback sizeReadyCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, sizeReadyCallback) == null) {
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Request request;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (request = this.request) == null) {
            return;
        }
        request.clear();
        this.request = null;
    }

    @Override // com.bumptech.glide.request.target.Target
    public void setRequest(@Nullable Request request) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, request) == null) {
            this.request = request;
        }
    }

    public RequestFutureTarget(Handler handler, int i2, int i3, boolean z, Waiter waiter) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {handler, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), waiter};
            interceptable.invokeUnInit(65538, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mainHandler = handler;
        this.width = i2;
        this.height = i3;
        this.assertBackgroundThread = z;
        this.waiter = waiter;
    }

    @Override // com.bumptech.glide.request.RequestListener
    public synchronized boolean onLoadFailed(@Nullable GlideException glideException, Object obj, Target<R> target, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{glideException, obj, target, Boolean.valueOf(z)})) == null) {
            synchronized (this) {
                this.loadFailed = true;
                this.exception = glideException;
                this.waiter.notifyAll(this);
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.bumptech.glide.request.RequestListener
    public synchronized boolean onResourceReady(R r, Object obj, Target<R> target, DataSource dataSource, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{r, obj, target, dataSource, Boolean.valueOf(z)})) == null) {
            synchronized (this) {
                this.resultReceived = true;
                this.resource = r;
                this.waiter.notifyAll(this);
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    @Override // java.util.concurrent.Future
    public R get(long j2, @NonNull TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJL = interceptable.invokeJL(Constants.METHOD_SEND_USER_MSG, this, j2, timeUnit)) == null) ? doGet(Long.valueOf(timeUnit.toMillis(j2))) : (R) invokeJL.objValue;
    }
}
