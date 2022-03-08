package com.bumptech.glide.load.engine.bitmap_recycle;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes7.dex */
public class LruBitmapPool implements BitmapPool {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Bitmap.Config DEFAULT_CONFIG;
    public static final String TAG = "LruBitmapPool";
    public transient /* synthetic */ FieldHolder $fh;
    public final Set<Bitmap.Config> allowedConfigs;
    public long currentSize;
    public int evictions;
    public int hits;
    public final long initialMaxSize;
    public long maxSize;
    public int misses;
    public int puts;
    public final LruPoolStrategy strategy;
    public final BitmapTracker tracker;

    /* loaded from: classes7.dex */
    public interface BitmapTracker {
        void add(Bitmap bitmap);

        void remove(Bitmap bitmap);
    }

    /* loaded from: classes7.dex */
    public static final class NullBitmapTracker implements BitmapTracker {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public NullBitmapTracker() {
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

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool.BitmapTracker
        public void add(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bitmap) == null) {
            }
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool.BitmapTracker
        public void remove(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class ThrowingBitmapTracker implements BitmapTracker {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Set<Bitmap> bitmaps;

        public ThrowingBitmapTracker() {
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
            this.bitmaps = Collections.synchronizedSet(new HashSet());
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool.BitmapTracker
        public void add(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bitmap) == null) {
                if (!this.bitmaps.contains(bitmap)) {
                    this.bitmaps.add(bitmap);
                    return;
                }
                throw new IllegalStateException("Can't add already added bitmap: " + bitmap + " [" + bitmap.getWidth() + "x" + bitmap.getHeight() + PreferencesUtil.RIGHT_MOUNT);
            }
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool.BitmapTracker
        public void remove(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap) == null) {
                if (this.bitmaps.contains(bitmap)) {
                    this.bitmaps.remove(bitmap);
                    return;
                }
                throw new IllegalStateException("Cannot remove bitmap not in tracker");
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1340515094, "Lcom/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1340515094, "Lcom/bumptech/glide/load/engine/bitmap_recycle/LruBitmapPool;");
                return;
            }
        }
        DEFAULT_CONFIG = Bitmap.Config.ARGB_8888;
    }

    public LruBitmapPool(long j2, LruPoolStrategy lruPoolStrategy, Set<Bitmap.Config> set) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j2), lruPoolStrategy, set};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.initialMaxSize = j2;
        this.maxSize = j2;
        this.strategy = lruPoolStrategy;
        this.allowedConfigs = set;
        this.tracker = new NullBitmapTracker();
    }

    @TargetApi(26)
    public static void assertNotHardwareConfig(Bitmap.Config config) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, config) == null) && Build.VERSION.SDK_INT >= 26 && config == Bitmap.Config.HARDWARE) {
            throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
        }
    }

    @NonNull
    public static Bitmap createBitmap(int i2, int i3, @Nullable Bitmap.Config config) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(65541, null, i2, i3, config)) == null) {
            if (config == null) {
                config = DEFAULT_CONFIG;
            }
            return Bitmap.createBitmap(i2, i3, config);
        }
        return (Bitmap) invokeIIL.objValue;
    }

    private void dump() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65542, this) == null) && Log.isLoggable(TAG, 2)) {
            dumpUnchecked();
        }
    }

    private void dumpUnchecked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            String str = "Hits=" + this.hits + ", misses=" + this.misses + ", puts=" + this.puts + ", evictions=" + this.evictions + ", currentSize=" + this.currentSize + ", maxSize=" + this.maxSize + "\nStrategy=" + this.strategy;
        }
    }

    private void evict() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            trimToSize(this.maxSize);
        }
    }

    @TargetApi(26)
    public static Set<Bitmap.Config> getDefaultAllowedConfigs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            HashSet hashSet = new HashSet(Arrays.asList(Bitmap.Config.values()));
            if (Build.VERSION.SDK_INT >= 19) {
                hashSet.add(null);
            }
            if (Build.VERSION.SDK_INT >= 26) {
                hashSet.remove(Bitmap.Config.HARDWARE);
            }
            return Collections.unmodifiableSet(hashSet);
        }
        return (Set) invokeV.objValue;
    }

    public static LruPoolStrategy getDefaultStrategy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            if (Build.VERSION.SDK_INT >= 19) {
                return new SizeConfigStrategy();
            }
            return new AttributeStrategy();
        }
        return (LruPoolStrategy) invokeV.objValue;
    }

    @Nullable
    private synchronized Bitmap getDirtyOrNull(int i2, int i3, @Nullable Bitmap.Config config) {
        InterceptResult invokeIIL;
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(65547, this, i2, i3, config)) == null) {
            synchronized (this) {
                assertNotHardwareConfig(config);
                bitmap = this.strategy.get(i2, i3, config != null ? config : DEFAULT_CONFIG);
                if (bitmap == null) {
                    if (Log.isLoggable(TAG, 3)) {
                        String str = "Missing bitmap=" + this.strategy.logBitmap(i2, i3, config);
                    }
                    this.misses++;
                } else {
                    this.hits++;
                    this.currentSize -= this.strategy.getSize(bitmap);
                    this.tracker.remove(bitmap);
                    normalize(bitmap);
                }
                if (Log.isLoggable(TAG, 2)) {
                    String str2 = "Get bitmap=" + this.strategy.logBitmap(i2, i3, config);
                }
                dump();
            }
            return bitmap;
        }
        return (Bitmap) invokeIIL.objValue;
    }

    @TargetApi(19)
    public static void maybeSetPreMultiplied(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65548, null, bitmap) == null) || Build.VERSION.SDK_INT < 19) {
            return;
        }
        bitmap.setPremultiplied(true);
    }

    public static void normalize(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, bitmap) == null) {
            bitmap.setHasAlpha(true);
            maybeSetPreMultiplied(bitmap);
        }
    }

    private synchronized void trimToSize(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65550, this, j2) == null) {
            synchronized (this) {
                while (this.currentSize > j2) {
                    Bitmap removeLast = this.strategy.removeLast();
                    if (removeLast == null) {
                        if (Log.isLoggable(TAG, 5)) {
                            dumpUnchecked();
                        }
                        this.currentSize = 0L;
                        return;
                    }
                    this.tracker.remove(removeLast);
                    this.currentSize -= this.strategy.getSize(removeLast);
                    this.evictions++;
                    if (Log.isLoggable(TAG, 3)) {
                        String str = "Evicting bitmap=" + this.strategy.logBitmap(removeLast);
                    }
                    dump();
                    removeLast.recycle();
                }
            }
        }
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public void clearMemory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Log.isLoggable(TAG, 3);
            trimToSize(0L);
        }
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    @NonNull
    public Bitmap get(int i2, int i3, Bitmap.Config config) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, config)) == null) {
            Bitmap dirtyOrNull = getDirtyOrNull(i2, i3, config);
            if (dirtyOrNull != null) {
                dirtyOrNull.eraseColor(0);
                return dirtyOrNull;
            }
            return createBitmap(i2, i3, config);
        }
        return (Bitmap) invokeIIL.objValue;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    @NonNull
    public Bitmap getDirty(int i2, int i3, Bitmap.Config config) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, config)) == null) {
            Bitmap dirtyOrNull = getDirtyOrNull(i2, i3, config);
            return dirtyOrNull == null ? createBitmap(i2, i3, config) : dirtyOrNull;
        }
        return (Bitmap) invokeIIL.objValue;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public long getMaxSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.maxSize : invokeV.longValue;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public synchronized void put(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bitmap) == null) {
            synchronized (this) {
                try {
                    if (bitmap != null) {
                        if (!bitmap.isRecycled()) {
                            if (bitmap.isMutable() && this.strategy.getSize(bitmap) <= this.maxSize && this.allowedConfigs.contains(bitmap.getConfig())) {
                                int size = this.strategy.getSize(bitmap);
                                this.strategy.put(bitmap);
                                this.tracker.add(bitmap);
                                this.puts++;
                                this.currentSize += size;
                                if (Log.isLoggable(TAG, 2)) {
                                    String str = "Put bitmap in pool=" + this.strategy.logBitmap(bitmap);
                                }
                                dump();
                                evict();
                                return;
                            }
                            if (Log.isLoggable(TAG, 2)) {
                                String str2 = "Reject bitmap from pool, bitmap: " + this.strategy.logBitmap(bitmap) + ", is mutable: " + bitmap.isMutable() + ", is allowed config: " + this.allowedConfigs.contains(bitmap.getConfig());
                            }
                            bitmap.recycle();
                            return;
                        }
                        throw new IllegalStateException("Cannot pool recycled bitmap");
                    }
                    throw new NullPointerException("Bitmap must not be null");
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public synchronized void setSizeMultiplier(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048581, this, f2) == null) {
            synchronized (this) {
                this.maxSize = Math.round(((float) this.initialMaxSize) * f2);
                evict();
            }
        }
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    @SuppressLint({"InlinedApi"})
    public void trimMemory(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            if (Log.isLoggable(TAG, 3)) {
                String str = "trimMemory, level=" + i2;
            }
            if (i2 >= 40) {
                clearMemory();
            } else if (i2 >= 20 || i2 == 15) {
                trimToSize(getMaxSize() / 2);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LruBitmapPool(long j2) {
        this(j2, getDefaultStrategy(), getDefaultAllowedConfigs());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Long) objArr2[0]).longValue(), (LruPoolStrategy) objArr2[1], (Set) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LruBitmapPool(long j2, Set<Bitmap.Config> set) {
        this(j2, getDefaultStrategy(), set);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j2), set};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Long) objArr2[0]).longValue(), (LruPoolStrategy) objArr2[1], (Set) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }
}
