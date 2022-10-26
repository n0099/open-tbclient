package com.bumptech.glide.load.engine.cache;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes7.dex */
public final class DiskCacheWriteLocker {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map locks;
    public final WriteLockPool writeLockPool;

    /* loaded from: classes7.dex */
    public class WriteLock {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int interestedThreads;
        public final Lock lock;

        public WriteLock() {
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
            this.lock = new ReentrantLock();
        }
    }

    /* loaded from: classes7.dex */
    public class WriteLockPool {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int MAX_POOL_SIZE = 10;
        public transient /* synthetic */ FieldHolder $fh;
        public final Queue pool;

        public WriteLockPool() {
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
            this.pool = new ArrayDeque();
        }

        public WriteLock obtain() {
            InterceptResult invokeV;
            WriteLock writeLock;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                synchronized (this.pool) {
                    writeLock = (WriteLock) this.pool.poll();
                }
                if (writeLock == null) {
                    return new WriteLock();
                }
                return writeLock;
            }
            return (WriteLock) invokeV.objValue;
        }

        public void offer(WriteLock writeLock) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, writeLock) == null) {
                synchronized (this.pool) {
                    if (this.pool.size() < 10) {
                        this.pool.offer(writeLock);
                    }
                }
            }
        }
    }

    public DiskCacheWriteLocker() {
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
        this.locks = new HashMap();
        this.writeLockPool = new WriteLockPool();
    }

    public void acquire(String str) {
        WriteLock writeLock;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            synchronized (this) {
                writeLock = (WriteLock) this.locks.get(str);
                if (writeLock == null) {
                    writeLock = this.writeLockPool.obtain();
                    this.locks.put(str, writeLock);
                }
                writeLock.interestedThreads++;
            }
            writeLock.lock.lock();
        }
    }

    public void release(String str) {
        WriteLock writeLock;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            synchronized (this) {
                writeLock = (WriteLock) Preconditions.checkNotNull(this.locks.get(str));
                if (writeLock.interestedThreads >= 1) {
                    int i = writeLock.interestedThreads - 1;
                    writeLock.interestedThreads = i;
                    if (i == 0) {
                        WriteLock writeLock2 = (WriteLock) this.locks.remove(str);
                        if (writeLock2.equals(writeLock)) {
                            this.writeLockPool.offer(writeLock2);
                        } else {
                            throw new IllegalStateException("Removed the wrong lock, expected to remove: " + writeLock + ", but actually removed: " + writeLock2 + ", safeKey: " + str);
                        }
                    }
                } else {
                    throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + writeLock.interestedThreads);
                }
            }
            writeLock.lock.unlock();
        }
    }
}
