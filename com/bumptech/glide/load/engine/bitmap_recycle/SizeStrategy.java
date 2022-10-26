package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.util.Util;
import java.util.NavigableMap;
/* loaded from: classes7.dex */
public final class SizeStrategy implements LruPoolStrategy {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MAX_SIZE_MULTIPLE = 8;
    public transient /* synthetic */ FieldHolder $fh;
    public final GroupedLinkedMap groupedMap;
    public final KeyPool keyPool;
    public final NavigableMap sortedSizes;

    /* loaded from: classes7.dex */
    public final class Key implements Poolable {
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
                if (!(obj instanceof Key) || this.size != ((Key) obj).size) {
                    return false;
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        public void init(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                this.size = i;
            }
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.size;
            }
            return invokeV.intValue;
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
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return SizeStrategy.getBitmapString(this.size);
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class KeyPool extends BaseKeyPool {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bumptech.glide.load.engine.bitmap_recycle.BaseKeyPool
        public Key create() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return new Key(this);
            }
            return (Key) invokeV.objValue;
        }

        public Key get(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                Key key = (Key) super.get();
                key.init(i);
                return key;
            }
            return (Key) invokeI.objValue;
        }
    }

    public SizeStrategy() {
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
        this.keyPool = new KeyPool();
        this.groupedMap = new GroupedLinkedMap();
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

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public void put(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bitmap) == null) {
            Key key = this.keyPool.get(Util.getBitmapByteSize(bitmap));
            this.groupedMap.put(key, bitmap);
            Integer num = (Integer) this.sortedSizes.get(Integer.valueOf(key.size));
            NavigableMap navigableMap = this.sortedSizes;
            Integer valueOf = Integer.valueOf(key.size);
            int i = 1;
            if (num != null) {
                i = 1 + num.intValue();
            }
            navigableMap.put(valueOf, Integer.valueOf(i));
        }
    }

    public static String getBitmapString(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            return PreferencesUtil.LEFT_MOUNT + i + PreferencesUtil.RIGHT_MOUNT;
        }
        return (String) invokeI.objValue;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public int getSize(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap)) == null) {
            return Util.getBitmapByteSize(bitmap);
        }
        return invokeL.intValue;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public String logBitmap(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bitmap)) == null) {
            return getBitmapString(bitmap);
        }
        return (String) invokeL.objValue;
    }

    public static String getBitmapString(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bitmap)) == null) {
            return getBitmapString(Util.getBitmapByteSize(bitmap));
        }
        return (String) invokeL.objValue;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public Bitmap get(int i, int i2, Bitmap.Config config) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i, i2, config)) == null) {
            int bitmapByteSize = Util.getBitmapByteSize(i, i2, config);
            Key key = this.keyPool.get(bitmapByteSize);
            Integer num = (Integer) this.sortedSizes.ceilingKey(Integer.valueOf(bitmapByteSize));
            if (num != null && num.intValue() != bitmapByteSize && num.intValue() <= bitmapByteSize * 8) {
                this.keyPool.offer(key);
                key = this.keyPool.get(num.intValue());
            }
            Bitmap bitmap = (Bitmap) this.groupedMap.get(key);
            if (bitmap != null) {
                bitmap.reconfigure(i, i2, config);
                decrementBitmapOfSize(num);
            }
            return bitmap;
        }
        return (Bitmap) invokeIIL.objValue;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public String logBitmap(int i, int i2, Bitmap.Config config) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, config)) == null) {
            return getBitmapString(Util.getBitmapByteSize(i, i2, config));
        }
        return (String) invokeIIL.objValue;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public Bitmap removeLast() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            Bitmap bitmap = (Bitmap) this.groupedMap.removeLast();
            if (bitmap != null) {
                decrementBitmapOfSize(Integer.valueOf(Util.getBitmapByteSize(bitmap)));
            }
            return bitmap;
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
}
