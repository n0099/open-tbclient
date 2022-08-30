package com.bumptech.glide.load.engine.cache;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.disklrucache.DiskLruCache;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.cache.DiskCache;
import java.io.File;
import java.io.IOException;
/* loaded from: classes7.dex */
public class DiskLruCacheWrapper implements DiskCache {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int APP_VERSION = 1;
    public static final String TAG = "DiskLruCacheWrapper";
    public static final int VALUE_COUNT = 1;
    public static DiskLruCacheWrapper wrapper;
    public transient /* synthetic */ FieldHolder $fh;
    public final File directory;
    public DiskLruCache diskLruCache;
    public final long maxSize;
    public final SafeKeyGenerator safeKeyGenerator;
    public final DiskCacheWriteLocker writeLocker;

    @Deprecated
    public DiskLruCacheWrapper(File file, long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {file, Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.writeLocker = new DiskCacheWriteLocker();
        this.directory = file;
        this.maxSize = j;
        this.safeKeyGenerator = new SafeKeyGenerator();
    }

    public static DiskCache create(File file, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(65537, null, file, j)) == null) ? new DiskLruCacheWrapper(file, j) : (DiskCache) invokeLJ.objValue;
    }

    @Deprecated
    public static synchronized DiskCache get(File file, long j) {
        InterceptResult invokeLJ;
        DiskLruCacheWrapper diskLruCacheWrapper;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65538, null, file, j)) == null) {
            synchronized (DiskLruCacheWrapper.class) {
                if (wrapper == null) {
                    wrapper = new DiskLruCacheWrapper(file, j);
                }
                diskLruCacheWrapper = wrapper;
            }
            return diskLruCacheWrapper;
        }
        return (DiskCache) invokeLJ.objValue;
    }

    private synchronized DiskLruCache getDiskCache() throws IOException {
        InterceptResult invokeV;
        DiskLruCache diskLruCache;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            synchronized (this) {
                if (this.diskLruCache == null) {
                    this.diskLruCache = DiskLruCache.open(this.directory, 1, 1, this.maxSize);
                }
                diskLruCache = this.diskLruCache;
            }
            return diskLruCache;
        }
        return (DiskLruCache) invokeV.objValue;
    }

    private synchronized void resetDiskCache() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            synchronized (this) {
                this.diskLruCache = null;
            }
        }
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public synchronized void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                try {
                    getDiskCache().delete();
                } catch (IOException e) {
                    if (Log.isLoggable(TAG, 5)) {
                        Log.w(TAG, "Unable to clear disk cache or disk cache cleared externally", e);
                    }
                }
                resetDiskCache();
            }
        }
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public void delete(Key key) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, key) == null) {
            try {
                getDiskCache().remove(this.safeKeyGenerator.getSafeKey(key));
            } catch (IOException e) {
                if (Log.isLoggable(TAG, 5)) {
                    Log.w(TAG, "Unable to delete from disk cache", e);
                }
            }
        }
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public void put(Key key, DiskCache.Writer writer) {
        DiskLruCache diskCache;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, key, writer) == null) {
            String safeKey = this.safeKeyGenerator.getSafeKey(key);
            this.writeLocker.acquire(safeKey);
            try {
                if (Log.isLoggable(TAG, 2)) {
                    Log.v(TAG, "Put: Obtained: " + safeKey + " for for Key: " + key);
                }
                try {
                    diskCache = getDiskCache();
                } catch (IOException e) {
                    if (Log.isLoggable(TAG, 5)) {
                        Log.w(TAG, "Unable to put to disk cache", e);
                    }
                }
                if (diskCache.get(safeKey) != null) {
                    return;
                }
                DiskLruCache.Editor edit = diskCache.edit(safeKey);
                if (edit != null) {
                    try {
                        if (writer.write(edit.getFile(0))) {
                            edit.commit();
                        }
                        edit.abortUnlessCommitted();
                        return;
                    } catch (Throwable th) {
                        edit.abortUnlessCommitted();
                        throw th;
                    }
                }
                throw new IllegalStateException("Had two simultaneous puts for: " + safeKey);
            } finally {
                this.writeLocker.release(safeKey);
            }
        }
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public File get(Key key) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, key)) == null) {
            String safeKey = this.safeKeyGenerator.getSafeKey(key);
            if (Log.isLoggable(TAG, 2)) {
                Log.v(TAG, "Get: Obtained: " + safeKey + " for for Key: " + key);
            }
            try {
                DiskLruCache.Value value = getDiskCache().get(safeKey);
                if (value != null) {
                    return value.getFile(0);
                }
                return null;
            } catch (IOException e) {
                if (Log.isLoggable(TAG, 5)) {
                    Log.w(TAG, "Unable to get from disk cache", e);
                    return null;
                }
                return null;
            }
        }
        return (File) invokeL.objValue;
    }
}
