package com.bumptech.glide.load.engine.cache;

import android.util.Log;
import com.bumptech.glide.disklrucache.DiskLruCache;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.cache.DiskCache;
import java.io.File;
import java.io.IOException;
/* loaded from: classes4.dex */
public class DiskLruCacheWrapper implements DiskCache {
    public static final int APP_VERSION = 1;
    public static final String TAG = "DiskLruCacheWrapper";
    public static final int VALUE_COUNT = 1;
    public static DiskLruCacheWrapper wrapper;
    public final File directory;
    public DiskLruCache diskLruCache;
    public final long maxSize;
    public final DiskCacheWriteLocker writeLocker = new DiskCacheWriteLocker();
    public final SafeKeyGenerator safeKeyGenerator = new SafeKeyGenerator();

    @Deprecated
    public DiskLruCacheWrapper(File file, long j) {
        this.directory = file;
        this.maxSize = j;
    }

    public static DiskCache create(File file, long j) {
        return new DiskLruCacheWrapper(file, j);
    }

    @Deprecated
    public static synchronized DiskCache get(File file, long j) {
        DiskLruCacheWrapper diskLruCacheWrapper;
        synchronized (DiskLruCacheWrapper.class) {
            if (wrapper == null) {
                wrapper = new DiskLruCacheWrapper(file, j);
            }
            diskLruCacheWrapper = wrapper;
        }
        return diskLruCacheWrapper;
    }

    private synchronized DiskLruCache getDiskCache() throws IOException {
        if (this.diskLruCache == null) {
            this.diskLruCache = DiskLruCache.open(this.directory, 1, 1, this.maxSize);
        }
        return this.diskLruCache;
    }

    private synchronized void resetDiskCache() {
        this.diskLruCache = null;
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public synchronized void clear() {
        try {
            getDiskCache().delete();
        } catch (IOException e2) {
            if (Log.isLoggable(TAG, 5)) {
                Log.w(TAG, "Unable to clear disk cache or disk cache cleared externally", e2);
            }
        }
        resetDiskCache();
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public void delete(Key key) {
        try {
            getDiskCache().remove(this.safeKeyGenerator.getSafeKey(key));
        } catch (IOException e2) {
            if (Log.isLoggable(TAG, 5)) {
                Log.w(TAG, "Unable to delete from disk cache", e2);
            }
        }
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public void put(Key key, DiskCache.Writer writer) {
        DiskLruCache diskCache;
        String safeKey = this.safeKeyGenerator.getSafeKey(key);
        this.writeLocker.acquire(safeKey);
        try {
            if (Log.isLoggable(TAG, 2)) {
                Log.v(TAG, "Put: Obtained: " + safeKey + " for for Key: " + key);
            }
            try {
                diskCache = getDiskCache();
            } catch (IOException e2) {
                if (Log.isLoggable(TAG, 5)) {
                    Log.w(TAG, "Unable to put to disk cache", e2);
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

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public File get(Key key) {
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
        } catch (IOException e2) {
            if (Log.isLoggable(TAG, 5)) {
                Log.w(TAG, "Unable to get from disk cache", e2);
                return null;
            }
            return null;
        }
    }
}
