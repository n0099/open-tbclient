package com.bumptech.glide.load.engine.prefill;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.VisibleForTesting;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.prefill.PreFillType;
import com.bumptech.glide.util.Util;
import java.util.HashMap;
/* loaded from: classes9.dex */
public final class BitmapPreFiller {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BitmapPool bitmapPool;
    public BitmapPreFillRunner current;
    public final DecodeFormat defaultFormat;
    public final Handler handler;
    public final MemoryCache memoryCache;

    public BitmapPreFiller(MemoryCache memoryCache, BitmapPool bitmapPool, DecodeFormat decodeFormat) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {memoryCache, bitmapPool, decodeFormat};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.handler = new Handler(Looper.getMainLooper());
        this.memoryCache = memoryCache;
        this.bitmapPool = bitmapPool;
        this.defaultFormat = decodeFormat;
    }

    public static int getSizeInBytes(PreFillType preFillType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, preFillType)) == null) ? Util.getBitmapByteSize(preFillType.getWidth(), preFillType.getHeight(), preFillType.getConfig()) : invokeL.intValue;
    }

    @VisibleForTesting
    public PreFillQueue generateAllocationOrder(PreFillType... preFillTypeArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, preFillTypeArr)) == null) {
            long maxSize = (this.memoryCache.getMaxSize() - this.memoryCache.getCurrentSize()) + this.bitmapPool.getMaxSize();
            int i2 = 0;
            for (PreFillType preFillType : preFillTypeArr) {
                i2 += preFillType.getWeight();
            }
            float f2 = ((float) maxSize) / i2;
            HashMap hashMap = new HashMap();
            for (PreFillType preFillType2 : preFillTypeArr) {
                hashMap.put(preFillType2, Integer.valueOf(Math.round(preFillType2.getWeight() * f2) / getSizeInBytes(preFillType2)));
            }
            return new PreFillQueue(hashMap);
        }
        return (PreFillQueue) invokeL.objValue;
    }

    public void preFill(PreFillType.Builder... builderArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, builderArr) == null) {
            BitmapPreFillRunner bitmapPreFillRunner = this.current;
            if (bitmapPreFillRunner != null) {
                bitmapPreFillRunner.cancel();
            }
            PreFillType[] preFillTypeArr = new PreFillType[builderArr.length];
            for (int i2 = 0; i2 < builderArr.length; i2++) {
                PreFillType.Builder builder = builderArr[i2];
                if (builder.getConfig() == null) {
                    builder.setConfig(this.defaultFormat == DecodeFormat.PREFER_ARGB_8888 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
                }
                preFillTypeArr[i2] = builder.build();
            }
            BitmapPreFillRunner bitmapPreFillRunner2 = new BitmapPreFillRunner(this.bitmapPool, this.memoryCache, generateAllocationOrder(preFillTypeArr));
            this.current = bitmapPreFillRunner2;
            this.handler.post(bitmapPreFillRunner2);
        }
    }
}
