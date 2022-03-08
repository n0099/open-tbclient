package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.util.Util;
import java.util.NavigableMap;
@RequiresApi(19)
/* loaded from: classes7.dex */
public final class SizeStrategy implements LruPoolStrategy {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MAX_SIZE_MULTIPLE = 8;
    public transient /* synthetic */ FieldHolder $fh;
    public final GroupedLinkedMap<Key, Bitmap> groupedMap;
    public final KeyPool keyPool;
    public final NavigableMap<Integer, Integer> sortedSizes;

    @VisibleForTesting
    /* loaded from: classes7.dex */
    public static final class Key implements Poolable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final KeyPool pool;
        public int size;

        public Key(KeyPool keyPool) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {keyPool};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) ? (obj instanceof Key) && this.size == ((Key) obj).size : invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.size : invokeV.intValue;
        }

        public void init(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                this.size = i2;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? SizeStrategy.getBitmapString(this.size) : (String) invokeV.objValue;
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public Key get(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                Key key = (Key) super.get();
                key.init(i2);
                return key;
            }
            return (Key) invokeI.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bumptech.glide.load.engine.bitmap_recycle.BaseKeyPool
        public Key create() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new Key(this) : (Key) invokeV.objValue;
        }
    }

    public SizeStrategy() {
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
        this.keyPool = new KeyPool();
        this.groupedMap = new GroupedLinkedMap<>();
        this.sortedSizes = new PrettyPrintTreeMap();
    }

    private void decrementBitmapOfSize(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, num) == null) {
            Integer num2 = (Integer) this.sortedSizes.get(num);
            if (num2.intValue() == 1) {
                this.sortedSizes.remove(num);
            } else {
                this.sortedSizes.put(num, Integer.valueOf(num2.intValue() - 1));
            }
        }
    }

    public static String getBitmapString(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bitmap)) == null) ? getBitmapString(Util.getBitmapByteSize(bitmap)) : (String) invokeL.objValue;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    @Nullable
    public Bitmap get(int i2, int i3, Bitmap.Config config) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i2, i3, config)) == null) {
            int bitmapByteSize = Util.getBitmapByteSize(i2, i3, config);
            Key key = this.keyPool.get(bitmapByteSize);
            Integer ceilingKey = this.sortedSizes.ceilingKey(Integer.valueOf(bitmapByteSize));
            if (ceilingKey != null && ceilingKey.intValue() != bitmapByteSize && ceilingKey.intValue() <= bitmapByteSize * 8) {
                this.keyPool.offer(key);
                key = this.keyPool.get(ceilingKey.intValue());
            }
            Bitmap bitmap = this.groupedMap.get(key);
            if (bitmap != null) {
                bitmap.reconfigure(i2, i3, config);
                decrementBitmapOfSize(ceilingKey);
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
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bitmap)) == null) ? getBitmapString(bitmap) : (String) invokeL.objValue;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public void put(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bitmap) == null) {
            Key key = this.keyPool.get(Util.getBitmapByteSize(bitmap));
            this.groupedMap.put(key, bitmap);
            Integer num = (Integer) this.sortedSizes.get(Integer.valueOf(key.size));
            this.sortedSizes.put(Integer.valueOf(key.size), Integer.valueOf(num != null ? 1 + num.intValue() : 1));
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
                decrementBitmapOfSize(Integer.valueOf(Util.getBitmapByteSize(removeLast)));
            }
            return removeLast;
        }
        return (Bitmap) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return "SizeStrategy:\n  " + this.groupedMap + "\n  SortedSizes" + this.sortedSizes;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public String logBitmap(int i2, int i3, Bitmap.Config config) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, config)) == null) ? getBitmapString(Util.getBitmapByteSize(i2, i3, config)) : (String) invokeIIL.objValue;
    }

    public static String getBitmapString(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            return PreferencesUtil.LEFT_MOUNT + i2 + PreferencesUtil.RIGHT_MOUNT;
        }
        return (String) invokeI.objValue;
    }
}
