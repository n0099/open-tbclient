package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.util.ExceptionCatchingInputStream;
import com.bumptech.glide.util.MarkEnforcingInputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes4.dex */
public class StreamBitmapDecoder implements ResourceDecoder<InputStream, Bitmap> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayPool byteArrayPool;
    public final Downsampler downsampler;

    /* loaded from: classes4.dex */
    public static class UntrustedCallbacks implements Downsampler.DecodeCallbacks {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final RecyclableBufferedInputStream bufferedStream;
        public final ExceptionCatchingInputStream exceptionStream;

        public UntrustedCallbacks(RecyclableBufferedInputStream recyclableBufferedInputStream, ExceptionCatchingInputStream exceptionCatchingInputStream) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recyclableBufferedInputStream, exceptionCatchingInputStream};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.bufferedStream = recyclableBufferedInputStream;
            this.exceptionStream = exceptionCatchingInputStream;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks
        public void onDecodeComplete(BitmapPool bitmapPool, Bitmap bitmap) throws IOException {
            IOException exception;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, bitmapPool, bitmap) == null) || (exception = this.exceptionStream.getException()) == null) {
                return;
            }
            if (bitmap != null) {
                bitmapPool.put(bitmap);
            }
            throw exception;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks
        public void onObtainBounds() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.bufferedStream.fixMarkLimit();
            }
        }
    }

    public StreamBitmapDecoder(Downsampler downsampler, ArrayPool arrayPool) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {downsampler, arrayPool};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.downsampler = downsampler;
        this.byteArrayPool = arrayPool;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bumptech.glide.load.ResourceDecoder
    public Resource<Bitmap> decode(@NonNull InputStream inputStream, int i, int i2, @NonNull Options options) throws IOException {
        InterceptResult invokeCommon;
        RecyclableBufferedInputStream recyclableBufferedInputStream;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{inputStream, Integer.valueOf(i), Integer.valueOf(i2), options})) == null) {
            if (inputStream instanceof RecyclableBufferedInputStream) {
                recyclableBufferedInputStream = (RecyclableBufferedInputStream) inputStream;
                z = false;
            } else {
                recyclableBufferedInputStream = new RecyclableBufferedInputStream(inputStream, this.byteArrayPool);
                z = true;
            }
            ExceptionCatchingInputStream obtain = ExceptionCatchingInputStream.obtain(recyclableBufferedInputStream);
            try {
                return this.downsampler.decode(new MarkEnforcingInputStream(obtain), i, i2, options, new UntrustedCallbacks(recyclableBufferedInputStream, obtain));
            } finally {
                obtain.release();
                if (z) {
                    recyclableBufferedInputStream.release();
                }
            }
        }
        return (Resource) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(@NonNull InputStream inputStream, @NonNull Options options) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, inputStream, options)) == null) ? this.downsampler.handles(inputStream) : invokeLL.booleanValue;
    }
}
