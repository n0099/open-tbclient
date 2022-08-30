package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import android.os.Build;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.util.Util;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
@RequiresApi(19)
/* loaded from: classes7.dex */
public class SizeConfigStrategy implements LruPoolStrategy {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Bitmap.Config[] ALPHA_8_IN_CONFIGS;
    public static final Bitmap.Config[] ARGB_4444_IN_CONFIGS;
    public static final Bitmap.Config[] ARGB_8888_IN_CONFIGS;
    public static final int MAX_SIZE_MULTIPLE = 8;
    public static final Bitmap.Config[] RGBA_F16_IN_CONFIGS;
    public static final Bitmap.Config[] RGB_565_IN_CONFIGS;
    public transient /* synthetic */ FieldHolder $fh;
    public final GroupedLinkedMap<Key, Bitmap> groupedMap;
    public final KeyPool keyPool;
    public final Map<Bitmap.Config, NavigableMap<Integer, Integer>> sortedSizes;

    /* renamed from: com.bumptech.glide.load.engine.bitmap_recycle.SizeConfigStrategy$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$android$graphics$Bitmap$Config;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(529323555, "Lcom/bumptech/glide/load/engine/bitmap_recycle/SizeConfigStrategy$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(529323555, "Lcom/bumptech/glide/load/engine/bitmap_recycle/SizeConfigStrategy$1;");
                    return;
                }
            }
            int[] iArr = new int[Bitmap.Config.values().length];
            $SwitchMap$android$graphics$Bitmap$Config = iArr;
            try {
                iArr[Bitmap.Config.ARGB_8888.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.ALPHA_8.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @VisibleForTesting
    /* loaded from: classes7.dex */
    public static class KeyPool extends BaseKeyPool<Key> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public KeyPool() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public Key get(int i, Bitmap.Config config) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, config)) == null) {
                Key key = get();
                key.init(i, config);
                return key;
            }
            return (Key) invokeIL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bumptech.glide.load.engine.bitmap_recycle.BaseKeyPool
        public Key create() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new Key(this) : (Key) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1505592752, "Lcom/bumptech/glide/load/engine/bitmap_recycle/SizeConfigStrategy;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1505592752, "Lcom/bumptech/glide/load/engine/bitmap_recycle/SizeConfigStrategy;");
                return;
            }
        }
        Bitmap.Config[] configArr = {Bitmap.Config.ARGB_8888, null};
        if (Build.VERSION.SDK_INT >= 26) {
            configArr = (Bitmap.Config[]) Arrays.copyOf(configArr, 3);
            configArr[configArr.length - 1] = Bitmap.Config.RGBA_F16;
        }
        ARGB_8888_IN_CONFIGS = configArr;
        RGBA_F16_IN_CONFIGS = configArr;
        RGB_565_IN_CONFIGS = new Bitmap.Config[]{Bitmap.Config.RGB_565};
        ARGB_4444_IN_CONFIGS = new Bitmap.Config[]{Bitmap.Config.ARGB_4444};
        ALPHA_8_IN_CONFIGS = new Bitmap.Config[]{Bitmap.Config.ALPHA_8};
    }

    public SizeConfigStrategy() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.keyPool = new KeyPool();
        this.groupedMap = new GroupedLinkedMap<>();
        this.sortedSizes = new HashMap();
    }

    private void decrementBitmapOfSize(Integer num, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, num, bitmap) == null) {
            NavigableMap<Integer, Integer> sizesForConfig = getSizesForConfig(bitmap.getConfig());
            Integer num2 = (Integer) sizesForConfig.get(num);
            if (num2 != null) {
                if (num2.intValue() == 1) {
                    sizesForConfig.remove(num);
                    return;
                } else {
                    sizesForConfig.put(num, Integer.valueOf(num2.intValue() - 1));
                    return;
                }
            }
            throw new NullPointerException("Tried to decrement empty size, size: " + num + ", removed: " + logBitmap(bitmap) + ", this: " + this);
        }
    }

    private Key findBestKey(int i, Bitmap.Config config) {
        InterceptResult invokeIL;
        Bitmap.Config[] inConfigs;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65539, this, i, config)) == null) {
            Key key = this.keyPool.get(i, config);
            for (Bitmap.Config config2 : getInConfigs(config)) {
                Integer ceilingKey = getSizesForConfig(config2).ceilingKey(Integer.valueOf(i));
                if (ceilingKey != null && ceilingKey.intValue() <= i * 8) {
                    if (ceilingKey.intValue() == i) {
                        if (config2 == null) {
                            if (config == null) {
                                return key;
                            }
                        } else if (config2.equals(config)) {
                            return key;
                        }
                    }
                    this.keyPool.offer(key);
                    return this.keyPool.get(ceilingKey.intValue(), config2);
                }
            }
            return key;
        }
        return (Key) invokeIL.objValue;
    }

    public static String getBitmapString(int i, Bitmap.Config config) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(InputDeviceCompat.SOURCE_TRACKBALL, null, i, config)) == null) {
            return PreferencesUtil.LEFT_MOUNT + i + "](" + config + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeIL.objValue;
    }

    public static Bitmap.Config[] getInConfigs(Bitmap.Config config) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, config)) == null) {
            if (Build.VERSION.SDK_INT >= 26 && Bitmap.Config.RGBA_F16.equals(config)) {
                return RGBA_F16_IN_CONFIGS;
            }
            int i = AnonymousClass1.$SwitchMap$android$graphics$Bitmap$Config[config.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return i != 4 ? new Bitmap.Config[]{config} : ALPHA_8_IN_CONFIGS;
                    }
                    return ARGB_4444_IN_CONFIGS;
                }
                return RGB_565_IN_CONFIGS;
            }
            return ARGB_8888_IN_CONFIGS;
        }
        return (Bitmap.Config[]) invokeL.objValue;
    }

    private NavigableMap<Integer, Integer> getSizesForConfig(Bitmap.Config config) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, config)) == null) {
            NavigableMap<Integer, Integer> navigableMap = this.sortedSizes.get(config);
            if (navigableMap == null) {
                TreeMap treeMap = new TreeMap();
                this.sortedSizes.put(config, treeMap);
                return treeMap;
            }
            return navigableMap;
        }
        return (NavigableMap) invokeL.objValue;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    @Nullable
    public Bitmap get(int i, int i2, Bitmap.Config config) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i, i2, config)) == null) {
            Key findBestKey = findBestKey(Util.getBitmapByteSize(i, i2, config), config);
            Bitmap bitmap = this.groupedMap.get(findBestKey);
            if (bitmap != null) {
                decrementBitmapOfSize(Integer.valueOf(findBestKey.size), bitmap);
                bitmap.reconfigure(i, i2, bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888);
            }
            return bitmap;
        }
        return (Bitmap) invokeIIL.objValue;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public int getSize(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap)) == null) ? Util.getBitmapByteSize(bitmap) : invokeL.intValue;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public String logBitmap(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bitmap)) == null) ? getBitmapString(Util.getBitmapByteSize(bitmap), bitmap.getConfig()) : (String) invokeL.objValue;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public void put(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bitmap) == null) {
            Key key = this.keyPool.get(Util.getBitmapByteSize(bitmap), bitmap.getConfig());
            this.groupedMap.put(key, bitmap);
            NavigableMap<Integer, Integer> sizesForConfig = getSizesForConfig(bitmap.getConfig());
            Integer num = (Integer) sizesForConfig.get(Integer.valueOf(key.size));
            sizesForConfig.put(Integer.valueOf(key.size), Integer.valueOf(num != null ? 1 + num.intValue() : 1));
        }
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    @Nullable
    public Bitmap removeLast() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            Bitmap removeLast = this.groupedMap.removeLast();
            if (removeLast != null) {
                decrementBitmapOfSize(Integer.valueOf(Util.getBitmapByteSize(removeLast)), removeLast);
            }
            return removeLast;
        }
        return (Bitmap) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("SizeConfigStrategy{groupedMap=");
            sb.append(this.groupedMap);
            sb.append(", sortedSizes=(");
            for (Map.Entry<Bitmap.Config, NavigableMap<Integer, Integer>> entry : this.sortedSizes.entrySet()) {
                sb.append(entry.getKey());
                sb.append('[');
                sb.append(entry.getValue());
                sb.append("], ");
            }
            if (!this.sortedSizes.isEmpty()) {
                sb.replace(sb.length() - 2, sb.length(), "");
            }
            sb.append(")}");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    @VisibleForTesting
    /* loaded from: classes7.dex */
    public static final class Key implements Poolable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Bitmap.Config config;
        public final KeyPool pool;
        public int size;

        public Key(KeyPool keyPool) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {keyPool};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.pool = keyPool;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (obj instanceof Key) {
                    Key key = (Key) obj;
                    return this.size == key.size && Util.bothNullOrEqual(this.config, key.config);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                int i = this.size * 31;
                Bitmap.Config config = this.config;
                return i + (config != null ? config.hashCode() : 0);
            }
            return invokeV.intValue;
        }

        public void init(int i, Bitmap.Config config) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, config) == null) {
                this.size = i;
                this.config = config;
            }
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.Poolable
        public void offer() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.pool.offer(this);
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? SizeConfigStrategy.getBitmapString(this.size, this.config) : (String) invokeV.objValue;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        @VisibleForTesting
        public Key(KeyPool keyPool, int i, Bitmap.Config config) {
            this(keyPool);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {keyPool, Integer.valueOf(i), config};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    this((KeyPool) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            init(i, config);
        }
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public String logBitmap(int i, int i2, Bitmap.Config config) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, config)) == null) ? getBitmapString(Util.getBitmapByteSize(i, i2, config), config) : (String) invokeIIL.objValue;
    }
}
