package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
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
import com.bumptech.glide.Glide;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.gifdecoder.GifHeader;
import com.bumptech.glide.gifdecoder.GifHeaderParser;
import com.bumptech.glide.gifdecoder.StandardGifDecoder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.UnitTransformation;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Util;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Queue;
/* loaded from: classes7.dex */
public class ByteBufferGifDecoder implements ResourceDecoder {
    public static /* synthetic */ Interceptable $ic = null;
    public static final GifDecoderFactory GIF_DECODER_FACTORY;
    public static final GifHeaderParserPool PARSER_POOL;
    public static final String TAG = "BufferGifDecoder";
    public transient /* synthetic */ FieldHolder $fh;
    public final Context context;
    public final GifDecoderFactory gifDecoderFactory;
    public final GifHeaderParserPool parserPool;
    public final List parsers;
    public final GifBitmapProvider provider;

    /* loaded from: classes7.dex */
    public class GifDecoderFactory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public GifDecoderFactory() {
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

        public GifDecoder build(GifDecoder.BitmapProvider bitmapProvider, GifHeader gifHeader, ByteBuffer byteBuffer, int i) {
            InterceptResult invokeLLLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048576, this, bitmapProvider, gifHeader, byteBuffer, i)) == null) {
                return new StandardGifDecoder(bitmapProvider, gifHeader, byteBuffer, i);
            }
            return (GifDecoder) invokeLLLI.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class GifHeaderParserPool {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Queue pool;

        public GifHeaderParserPool() {
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
            this.pool = Util.createQueue(0);
        }

        public synchronized GifHeaderParser obtain(ByteBuffer byteBuffer) {
            InterceptResult invokeL;
            GifHeaderParser data;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, byteBuffer)) == null) {
                synchronized (this) {
                    GifHeaderParser gifHeaderParser = (GifHeaderParser) this.pool.poll();
                    if (gifHeaderParser == null) {
                        gifHeaderParser = new GifHeaderParser();
                    }
                    data = gifHeaderParser.setData(byteBuffer);
                }
                return data;
            }
            return (GifHeaderParser) invokeL.objValue;
        }

        public synchronized void release(GifHeaderParser gifHeaderParser) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gifHeaderParser) == null) {
                synchronized (this) {
                    gifHeaderParser.clear();
                    this.pool.offer(gifHeaderParser);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1733513251, "Lcom/bumptech/glide/load/resource/gif/ByteBufferGifDecoder;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1733513251, "Lcom/bumptech/glide/load/resource/gif/ByteBufferGifDecoder;");
                return;
            }
        }
        GIF_DECODER_FACTORY = new GifDecoderFactory();
        PARSER_POOL = new GifHeaderParserPool();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ByteBufferGifDecoder(Context context) {
        this(context, Glide.get(context).getRegistry().getImageHeaderParsers(), Glide.get(context).getBitmapPool(), Glide.get(context).getArrayPool());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (List) objArr2[1], (BitmapPool) objArr2[2], (ArrayPool) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ByteBufferGifDecoder(Context context, List list, BitmapPool bitmapPool, ArrayPool arrayPool) {
        this(context, list, bitmapPool, arrayPool, PARSER_POOL, GIF_DECODER_FACTORY);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, list, bitmapPool, arrayPool};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (List) objArr2[1], (BitmapPool) objArr2[2], (ArrayPool) objArr2[3], (GifHeaderParserPool) objArr2[4], (GifDecoderFactory) objArr2[5]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public ByteBufferGifDecoder(Context context, List list, BitmapPool bitmapPool, ArrayPool arrayPool, GifHeaderParserPool gifHeaderParserPool, GifDecoderFactory gifDecoderFactory) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, list, bitmapPool, arrayPool, gifHeaderParserPool, gifDecoderFactory};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.context = context.getApplicationContext();
        this.parsers = list;
        this.gifDecoderFactory = gifDecoderFactory;
        this.provider = new GifBitmapProvider(bitmapPool, arrayPool);
        this.parserPool = gifHeaderParserPool;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE]}, finally: {[INVOKE, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, IF] complete} */
    private GifDrawableResource decode(ByteBuffer byteBuffer, int i, int i2, GifHeaderParser gifHeaderParser, Options options) {
        InterceptResult invokeCommon;
        Bitmap.Config config;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{byteBuffer, Integer.valueOf(i), Integer.valueOf(i2), gifHeaderParser, options})) == null) {
            long logTime = LogTime.getLogTime();
            try {
                GifHeader parseHeader = gifHeaderParser.parseHeader();
                if (parseHeader.getNumFrames() > 0 && parseHeader.getStatus() == 0) {
                    if (options.get(GifOptions.DECODE_FORMAT) == DecodeFormat.PREFER_RGB_565) {
                        config = Bitmap.Config.RGB_565;
                    } else {
                        config = Bitmap.Config.ARGB_8888;
                    }
                    GifDecoder build = this.gifDecoderFactory.build(this.provider, parseHeader, byteBuffer, getSampleSize(parseHeader, i, i2));
                    build.setDefaultBitmapConfig(config);
                    build.advance();
                    Bitmap nextFrame = build.getNextFrame();
                    if (nextFrame == null) {
                        return null;
                    }
                    GifDrawableResource gifDrawableResource = new GifDrawableResource(new GifDrawable(this.context, build, UnitTransformation.get(), i, i2, nextFrame));
                    if (Log.isLoggable(TAG, 2)) {
                        Log.v(TAG, "Decoded GIF from stream in " + LogTime.getElapsedMillis(logTime));
                    }
                    return gifDrawableResource;
                }
                if (Log.isLoggable(TAG, 2)) {
                    Log.v(TAG, "Decoded GIF from stream in " + LogTime.getElapsedMillis(logTime));
                }
                return null;
            } finally {
                if (Log.isLoggable(TAG, 2)) {
                    Log.v(TAG, "Decoded GIF from stream in " + LogTime.getElapsedMillis(logTime));
                }
            }
        }
        return (GifDrawableResource) invokeCommon.objValue;
    }

    public static int getSampleSize(GifHeader gifHeader, int i, int i2) {
        InterceptResult invokeLII;
        int highestOneBit;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65541, null, gifHeader, i, i2)) == null) {
            int min = Math.min(gifHeader.getHeight() / i2, gifHeader.getWidth() / i);
            if (min == 0) {
                highestOneBit = 0;
            } else {
                highestOneBit = Integer.highestOneBit(min);
            }
            int max = Math.max(1, highestOneBit);
            if (Log.isLoggable(TAG, 2) && max > 1) {
                Log.v(TAG, "Downsampling GIF, sampleSize: " + max + ", target dimens: [" + i + "x" + i2 + "], actual dimens: [" + gifHeader.getWidth() + "x" + gifHeader.getHeight() + PreferencesUtil.RIGHT_MOUNT);
            }
            return max;
        }
        return invokeLII.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bumptech.glide.load.ResourceDecoder
    public GifDrawableResource decode(ByteBuffer byteBuffer, int i, int i2, Options options) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{byteBuffer, Integer.valueOf(i), Integer.valueOf(i2), options})) == null) {
            GifHeaderParser obtain = this.parserPool.obtain(byteBuffer);
            try {
                return decode(byteBuffer, i, i2, obtain, options);
            } finally {
                this.parserPool.release(obtain);
            }
        }
        return (GifDrawableResource) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(ByteBuffer byteBuffer, Options options) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, byteBuffer, options)) == null) {
            if (!((Boolean) options.get(GifOptions.DISABLE_ANIMATION)).booleanValue() && ImageHeaderParserUtils.getType(this.parsers, byteBuffer) == ImageHeaderParser.ImageType.GIF) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
