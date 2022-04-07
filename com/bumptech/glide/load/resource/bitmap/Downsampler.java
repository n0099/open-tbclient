package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import androidx.annotation.Nullable;
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
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
/* loaded from: classes4.dex */
public final class Downsampler {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Option<Boolean> ALLOW_HARDWARE_CONFIG;
    public static final Option<DecodeFormat> DECODE_FORMAT;
    @Deprecated
    public static final Option<DownsampleStrategy> DOWNSAMPLE_STRATEGY;
    public static final DecodeCallbacks EMPTY_CALLBACKS;
    public static final Option<Boolean> FIX_BITMAP_SIZE_TO_REQUESTED_DIMENSIONS;
    public static final String ICO_MIME_TYPE = "image/x-ico";
    public static final int MARK_POSITION = 10485760;
    public static final Set<String> NO_DOWNSAMPLE_PRE_N_MIME_TYPES;
    public static final Queue<BitmapFactory.Options> OPTIONS_QUEUE;
    public static final String TAG = "Downsampler";
    public static final Set<ImageHeaderParser.ImageType> TYPES_THAT_USE_POOL_PRE_KITKAT;
    public static final String WBMP_MIME_TYPE = "image/vnd.wap.wbmp";
    public transient /* synthetic */ FieldHolder $fh;
    public final BitmapPool bitmapPool;
    public final ArrayPool byteArrayPool;
    public final DisplayMetrics displayMetrics;
    public final HardwareConfigState hardwareConfigState;
    public final List<ImageHeaderParser> parsers;

    /* loaded from: classes4.dex */
    public interface DecodeCallbacks {
        void onDecodeComplete(BitmapPool bitmapPool, Bitmap bitmap) throws IOException;

        void onObtainBounds();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1226925878, "Lcom/bumptech/glide/load/resource/bitmap/Downsampler;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1226925878, "Lcom/bumptech/glide/load/resource/bitmap/Downsampler;");
                return;
            }
        }
        DECODE_FORMAT = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", DecodeFormat.DEFAULT);
        DOWNSAMPLE_STRATEGY = DownsampleStrategy.OPTION;
        FIX_BITMAP_SIZE_TO_REQUESTED_DIMENSIONS = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", Boolean.FALSE);
        ALLOW_HARDWARE_CONFIG = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", Boolean.FALSE);
        NO_DOWNSAMPLE_PRE_N_MIME_TYPES = Collections.unmodifiableSet(new HashSet(Arrays.asList(WBMP_MIME_TYPE, ICO_MIME_TYPE)));
        EMPTY_CALLBACKS = new DecodeCallbacks() { // from class: com.bumptech.glide.load.resource.bitmap.Downsampler.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks
            public void onDecodeComplete(BitmapPool bitmapPool, Bitmap bitmap) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, bitmapPool, bitmap) == null) {
                }
            }

            @Override // com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks
            public void onObtainBounds() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                }
            }
        };
        TYPES_THAT_USE_POOL_PRE_KITKAT = Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));
        OPTIONS_QUEUE = Util.createQueue(0);
    }

    public Downsampler(List<ImageHeaderParser> list, DisplayMetrics displayMetrics, BitmapPool bitmapPool, ArrayPool arrayPool) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, displayMetrics, bitmapPool, arrayPool};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.hardwareConfigState = HardwareConfigState.getInstance();
        this.parsers = list;
        this.displayMetrics = (DisplayMetrics) Preconditions.checkNotNull(displayMetrics);
        this.bitmapPool = (BitmapPool) Preconditions.checkNotNull(bitmapPool);
        this.byteArrayPool = (ArrayPool) Preconditions.checkNotNull(arrayPool);
    }

    public static int adjustTargetDensityForError(double d) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Double.valueOf(d)})) == null) {
            int densityMultiplier = getDensityMultiplier(d);
            int round = round(densityMultiplier * d);
            return round((d / (round / densityMultiplier)) * round);
        }
        return invokeCommon.intValue;
    }

    private void calculateConfig(InputStream inputStream, DecodeFormat decodeFormat, boolean z, boolean z2, BitmapFactory.Options options, int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{inputStream, decodeFormat, Boolean.valueOf(z), Boolean.valueOf(z2), options, Integer.valueOf(i), Integer.valueOf(i2)}) == null) || this.hardwareConfigState.setHardwareConfigIfAllowed(i, i2, options, decodeFormat, z, z2)) {
            return;
        }
        if (decodeFormat != DecodeFormat.PREFER_ARGB_8888 && Build.VERSION.SDK_INT != 16) {
            boolean z3 = false;
            try {
                z3 = ImageHeaderParserUtils.getType(this.parsers, inputStream, this.byteArrayPool).hasAlpha();
            } catch (IOException e) {
                if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "Cannot determine whether the image has alpha or not from header, format " + decodeFormat, e);
                }
            }
            Bitmap.Config config = z3 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
            options.inPreferredConfig = config;
            if (config == Bitmap.Config.RGB_565) {
                options.inDither = true;
                return;
            }
            return;
        }
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
    }

    public static void calculateScaling(ImageHeaderParser.ImageType imageType, InputStream inputStream, DecodeCallbacks decodeCallbacks, BitmapPool bitmapPool, DownsampleStrategy downsampleStrategy, int i, int i2, int i3, int i4, int i5, BitmapFactory.Options options) throws IOException {
        float scaleFactor;
        int min;
        int max;
        int floor;
        double floor2;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{imageType, inputStream, decodeCallbacks, bitmapPool, downsampleStrategy, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), options}) == null) {
            if (i2 <= 0 || i3 <= 0) {
                if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "Unable to determine dimensions for: " + imageType + " with target [" + i4 + "x" + i5 + PreferencesUtil.RIGHT_MOUNT);
                    return;
                }
                return;
            }
            if (i != 90 && i != 270) {
                scaleFactor = downsampleStrategy.getScaleFactor(i2, i3, i4, i5);
            } else {
                scaleFactor = downsampleStrategy.getScaleFactor(i3, i2, i4, i5);
            }
            if (scaleFactor > 0.0f) {
                DownsampleStrategy.SampleSizeRounding sampleSizeRounding = downsampleStrategy.getSampleSizeRounding(i2, i3, i4, i5);
                if (sampleSizeRounding != null) {
                    float f = i2;
                    float f2 = i3;
                    int round = i2 / round(scaleFactor * f);
                    int round2 = i3 / round(scaleFactor * f2);
                    if (sampleSizeRounding == DownsampleStrategy.SampleSizeRounding.MEMORY) {
                        min = Math.max(round, round2);
                    } else {
                        min = Math.min(round, round2);
                    }
                    if (Build.VERSION.SDK_INT > 23 || !NO_DOWNSAMPLE_PRE_N_MIME_TYPES.contains(options.outMimeType)) {
                        max = Math.max(1, Integer.highestOneBit(min));
                        if (sampleSizeRounding == DownsampleStrategy.SampleSizeRounding.MEMORY && max < 1.0f / scaleFactor) {
                            max <<= 1;
                        }
                    } else {
                        max = 1;
                    }
                    options.inSampleSize = max;
                    if (imageType == ImageHeaderParser.ImageType.JPEG) {
                        float min2 = Math.min(max, 8);
                        floor = (int) Math.ceil(f / min2);
                        i6 = (int) Math.ceil(f2 / min2);
                        int i7 = max / 8;
                        if (i7 > 0) {
                            floor /= i7;
                            i6 /= i7;
                        }
                    } else {
                        if (imageType != ImageHeaderParser.ImageType.PNG && imageType != ImageHeaderParser.ImageType.PNG_A) {
                            if (imageType != ImageHeaderParser.ImageType.WEBP && imageType != ImageHeaderParser.ImageType.WEBP_A) {
                                if (i2 % max == 0 && i3 % max == 0) {
                                    floor = i2 / max;
                                    i6 = i3 / max;
                                } else {
                                    int[] dimensions = getDimensions(inputStream, options, decodeCallbacks, bitmapPool);
                                    int i8 = dimensions[0];
                                    i6 = dimensions[1];
                                    floor = i8;
                                }
                            } else if (Build.VERSION.SDK_INT >= 24) {
                                float f3 = max;
                                floor = Math.round(f / f3);
                                i6 = Math.round(f2 / f3);
                            } else {
                                float f4 = max;
                                floor = (int) Math.floor(f / f4);
                                floor2 = Math.floor(f2 / f4);
                            }
                        } else {
                            float f5 = max;
                            floor = (int) Math.floor(f / f5);
                            floor2 = Math.floor(f2 / f5);
                        }
                        i6 = (int) floor2;
                    }
                    double scaleFactor2 = downsampleStrategy.getScaleFactor(floor, i6, i4, i5);
                    if (Build.VERSION.SDK_INT >= 19) {
                        options.inTargetDensity = adjustTargetDensityForError(scaleFactor2);
                        options.inDensity = getDensityMultiplier(scaleFactor2);
                    }
                    if (isScaling(options)) {
                        options.inScaled = true;
                    } else {
                        options.inTargetDensity = 0;
                        options.inDensity = 0;
                    }
                    if (Log.isLoggable(TAG, 2)) {
                        Log.v(TAG, "Calculate scaling, source: [" + i2 + "x" + i3 + "], target: [" + i4 + "x" + i5 + "], power of two scaled: [" + floor + "x" + i6 + "], exact scale factor: " + scaleFactor + ", power of 2 sample size: " + max + ", adjusted scale factor: " + scaleFactor2 + ", target density: " + options.inTargetDensity + ", density: " + options.inDensity);
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("Cannot round with null rounding");
            }
            throw new IllegalArgumentException("Cannot scale with factor: " + scaleFactor + " from: " + downsampleStrategy + ", source: [" + i2 + "x" + i3 + "], target: [" + i4 + "x" + i5 + PreferencesUtil.RIGHT_MOUNT);
        }
    }

    private Bitmap decodeFromWrappedStreams(InputStream inputStream, BitmapFactory.Options options, DownsampleStrategy downsampleStrategy, DecodeFormat decodeFormat, boolean z, int i, int i2, boolean z2, DecodeCallbacks decodeCallbacks) throws IOException {
        InterceptResult invokeCommon;
        Downsampler downsampler;
        int round;
        int round2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, this, new Object[]{inputStream, options, downsampleStrategy, decodeFormat, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z2), decodeCallbacks})) == null) {
            long logTime = LogTime.getLogTime();
            int[] dimensions = getDimensions(inputStream, options, decodeCallbacks, this.bitmapPool);
            int i4 = dimensions[0];
            int i5 = dimensions[1];
            String str = options.outMimeType;
            boolean z3 = (i4 == -1 || i5 == -1) ? false : z;
            int orientation = ImageHeaderParserUtils.getOrientation(this.parsers, inputStream, this.byteArrayPool);
            int exifOrientationDegrees = TransformationUtils.getExifOrientationDegrees(orientation);
            boolean isExifOrientationRequired = TransformationUtils.isExifOrientationRequired(orientation);
            int i6 = i == Integer.MIN_VALUE ? i4 : i;
            int i7 = i2 == Integer.MIN_VALUE ? i5 : i2;
            ImageHeaderParser.ImageType type = ImageHeaderParserUtils.getType(this.parsers, inputStream, this.byteArrayPool);
            calculateScaling(type, inputStream, decodeCallbacks, this.bitmapPool, downsampleStrategy, exifOrientationDegrees, i4, i5, i6, i7, options);
            calculateConfig(inputStream, decodeFormat, z3, isExifOrientationRequired, options, i6, i7);
            boolean z4 = Build.VERSION.SDK_INT >= 19;
            if (options.inSampleSize == 1 || z4) {
                downsampler = this;
                if (downsampler.shouldUsePool(type)) {
                    if (i4 < 0 || i5 < 0 || !z2 || !z4) {
                        float f = isScaling(options) ? options.inTargetDensity / options.inDensity : 1.0f;
                        int i8 = options.inSampleSize;
                        float f2 = i8;
                        round = Math.round(((int) Math.ceil(i4 / f2)) * f);
                        round2 = Math.round(((int) Math.ceil(i5 / f2)) * f);
                        if (Log.isLoggable(TAG, 2)) {
                            Log.v(TAG, "Calculated target [" + round + "x" + round2 + "] for source [" + i4 + "x" + i5 + "], sampleSize: " + i8 + ", targetDensity: " + options.inTargetDensity + ", density: " + options.inDensity + ", density multiplier: " + f);
                        }
                    } else {
                        round = i6;
                        round2 = i7;
                    }
                    if (round > 0 && round2 > 0) {
                        setInBitmap(options, downsampler.bitmapPool, round, round2);
                    }
                }
            } else {
                downsampler = this;
            }
            Bitmap decodeStream = decodeStream(inputStream, options, decodeCallbacks, downsampler.bitmapPool);
            decodeCallbacks.onDecodeComplete(downsampler.bitmapPool, decodeStream);
            if (Log.isLoggable(TAG, 2)) {
                i3 = orientation;
                logDecode(i4, i5, str, options, decodeStream, i, i2, logTime);
            } else {
                i3 = orientation;
            }
            Bitmap bitmap = null;
            if (decodeStream != null) {
                decodeStream.setDensity(downsampler.displayMetrics.densityDpi);
                bitmap = TransformationUtils.rotateImageExif(downsampler.bitmapPool, decodeStream, i3);
                if (!decodeStream.equals(bitmap)) {
                    downsampler.bitmapPool.put(decodeStream);
                }
            }
            return bitmap;
        }
        return (Bitmap) invokeCommon.objValue;
    }

    public static Bitmap decodeStream(InputStream inputStream, BitmapFactory.Options options, DecodeCallbacks decodeCallbacks, BitmapPool bitmapPool) throws IOException {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65542, null, inputStream, options, decodeCallbacks, bitmapPool)) == null) {
            if (options.inJustDecodeBounds) {
                inputStream.mark(10485760);
            } else {
                decodeCallbacks.onObtainBounds();
            }
            int i = options.outWidth;
            int i2 = options.outHeight;
            String str = options.outMimeType;
            TransformationUtils.getBitmapDrawableLock().lock();
            try {
                try {
                    Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, null, options);
                    TransformationUtils.getBitmapDrawableLock().unlock();
                    if (options.inJustDecodeBounds) {
                        inputStream.reset();
                    }
                    return decodeStream;
                } catch (IllegalArgumentException e) {
                    IOException newIoExceptionForInBitmapAssertion = newIoExceptionForInBitmapAssertion(e, i, i2, str, options);
                    if (Log.isLoggable(TAG, 3)) {
                        Log.d(TAG, "Failed to decode with inBitmap, trying again without Bitmap re-use", newIoExceptionForInBitmapAssertion);
                    }
                    if (options.inBitmap != null) {
                        try {
                            inputStream.reset();
                            bitmapPool.put(options.inBitmap);
                            options.inBitmap = null;
                            Bitmap decodeStream2 = decodeStream(inputStream, options, decodeCallbacks, bitmapPool);
                            TransformationUtils.getBitmapDrawableLock().unlock();
                            return decodeStream2;
                        } catch (IOException unused) {
                            throw newIoExceptionForInBitmapAssertion;
                        }
                    }
                    throw newIoExceptionForInBitmapAssertion;
                }
            } catch (Throwable th) {
                TransformationUtils.getBitmapDrawableLock().unlock();
                throw th;
            }
        }
        return (Bitmap) invokeLLLL.objValue;
    }

    @Nullable
    @TargetApi(19)
    public static String getBitmapString(Bitmap bitmap) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, bitmap)) == null) {
            if (bitmap == null) {
                return null;
            }
            if (Build.VERSION.SDK_INT >= 19) {
                str = " (" + bitmap.getAllocationByteCount() + SmallTailInfo.EMOTION_SUFFIX;
            } else {
                str = "";
            }
            return PreferencesUtil.LEFT_MOUNT + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig() + str;
        }
        return (String) invokeL.objValue;
    }

    public static synchronized BitmapFactory.Options getDefaultOptions() {
        InterceptResult invokeV;
        BitmapFactory.Options poll;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            synchronized (Downsampler.class) {
                synchronized (OPTIONS_QUEUE) {
                    poll = OPTIONS_QUEUE.poll();
                }
                if (poll == null) {
                    poll = new BitmapFactory.Options();
                    resetOptions(poll);
                }
            }
            return poll;
        }
        return (BitmapFactory.Options) invokeV.objValue;
    }

    public static int getDensityMultiplier(double d) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{Double.valueOf(d)})) == null) {
            if (d > 1.0d) {
                d = 1.0d / d;
            }
            return (int) Math.round(d * 2.147483647E9d);
        }
        return invokeCommon.intValue;
    }

    public static int[] getDimensions(InputStream inputStream, BitmapFactory.Options options, DecodeCallbacks decodeCallbacks, BitmapPool bitmapPool) throws IOException {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65546, null, inputStream, options, decodeCallbacks, bitmapPool)) == null) {
            options.inJustDecodeBounds = true;
            decodeStream(inputStream, options, decodeCallbacks, bitmapPool);
            options.inJustDecodeBounds = false;
            return new int[]{options.outWidth, options.outHeight};
        }
        return (int[]) invokeLLLL.objValue;
    }

    public static String getInBitmapString(BitmapFactory.Options options) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, options)) == null) ? getBitmapString(options.inBitmap) : (String) invokeL.objValue;
    }

    public static boolean isScaling(BitmapFactory.Options options) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, options)) == null) {
            int i2 = options.inTargetDensity;
            return i2 > 0 && (i = options.inDensity) > 0 && i2 != i;
        }
        return invokeL.booleanValue;
    }

    public static void logDecode(int i, int i2, String str, BitmapFactory.Options options, Bitmap bitmap, int i3, int i4, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, options, bitmap, Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j)}) == null) {
            Log.v(TAG, "Decoded " + getBitmapString(bitmap) + " from [" + i + "x" + i2 + "] " + str + " with inBitmap " + getInBitmapString(options) + " for [" + i3 + "x" + i4 + "], sample size: " + options.inSampleSize + ", density: " + options.inDensity + ", target density: " + options.inTargetDensity + ", thread: " + Thread.currentThread().getName() + ", duration: " + LogTime.getElapsedMillis(j));
        }
    }

    public static IOException newIoExceptionForInBitmapAssertion(IllegalArgumentException illegalArgumentException, int i, int i2, String str, BitmapFactory.Options options) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65550, null, new Object[]{illegalArgumentException, Integer.valueOf(i), Integer.valueOf(i2), str, options})) == null) {
            return new IOException("Exception decoding bitmap, outWidth: " + i + ", outHeight: " + i2 + ", outMimeType: " + str + ", inBitmap: " + getInBitmapString(options), illegalArgumentException);
        }
        return (IOException) invokeCommon.objValue;
    }

    public static void releaseOptions(BitmapFactory.Options options) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, options) == null) {
            resetOptions(options);
            synchronized (OPTIONS_QUEUE) {
                OPTIONS_QUEUE.offer(options);
            }
        }
    }

    public static void resetOptions(BitmapFactory.Options options) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, options) == null) {
            options.inTempStorage = null;
            options.inDither = false;
            options.inScaled = false;
            options.inSampleSize = 1;
            options.inPreferredConfig = null;
            options.inJustDecodeBounds = false;
            options.inDensity = 0;
            options.inTargetDensity = 0;
            options.outWidth = 0;
            options.outHeight = 0;
            options.outMimeType = null;
            options.inBitmap = null;
            options.inMutable = true;
        }
    }

    public static int round(double d) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65553, null, new Object[]{Double.valueOf(d)})) == null) ? (int) (d + 0.5d) : invokeCommon.intValue;
    }

    @TargetApi(26)
    public static void setInBitmap(BitmapFactory.Options options, BitmapPool bitmapPool, int i, int i2) {
        Bitmap.Config config;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65554, null, options, bitmapPool, i, i2) == null) {
            if (Build.VERSION.SDK_INT < 26) {
                config = null;
            } else if (options.inPreferredConfig == Bitmap.Config.HARDWARE) {
                return;
            } else {
                config = options.outConfig;
            }
            if (config == null) {
                config = options.inPreferredConfig;
            }
            options.inBitmap = bitmapPool.getDirty(i, i2, config);
        }
    }

    private boolean shouldUsePool(ImageHeaderParser.ImageType imageType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, this, imageType)) == null) {
            if (Build.VERSION.SDK_INT >= 19) {
                return true;
            }
            return TYPES_THAT_USE_POOL_PRE_KITKAT.contains(imageType);
        }
        return invokeL.booleanValue;
    }

    public Resource<Bitmap> decode(InputStream inputStream, int i, int i2, Options options) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{inputStream, Integer.valueOf(i), Integer.valueOf(i2), options})) == null) ? decode(inputStream, i, i2, options, EMPTY_CALLBACKS) : (Resource) invokeCommon.objValue;
    }

    public boolean handles(InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, inputStream)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean handles(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, byteBuffer)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    public Resource<Bitmap> decode(InputStream inputStream, int i, int i2, Options options, DecodeCallbacks decodeCallbacks) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{inputStream, Integer.valueOf(i), Integer.valueOf(i2), options, decodeCallbacks})) == null) {
            Preconditions.checkArgument(inputStream.markSupported(), "You must provide an InputStream that supports mark()");
            byte[] bArr = (byte[]) this.byteArrayPool.get(65536, byte[].class);
            BitmapFactory.Options defaultOptions = getDefaultOptions();
            defaultOptions.inTempStorage = bArr;
            DecodeFormat decodeFormat = (DecodeFormat) options.get(DECODE_FORMAT);
            try {
                return BitmapResource.obtain(decodeFromWrappedStreams(inputStream, defaultOptions, (DownsampleStrategy) options.get(DownsampleStrategy.OPTION), decodeFormat, options.get(ALLOW_HARDWARE_CONFIG) != null && ((Boolean) options.get(ALLOW_HARDWARE_CONFIG)).booleanValue(), i, i2, ((Boolean) options.get(FIX_BITMAP_SIZE_TO_REQUESTED_DIMENSIONS)).booleanValue(), decodeCallbacks), this.bitmapPool);
            } finally {
                releaseOptions(defaultOptions);
                this.byteArrayPool.put(bArr);
            }
        }
        return (Resource) invokeCommon.objValue;
    }
}
