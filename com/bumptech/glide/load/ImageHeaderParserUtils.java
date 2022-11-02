package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
/* loaded from: classes7.dex */
public final class ImageHeaderParserUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MARK_READ_LIMIT = 5242880;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public interface OrientationReader {
        int getOrientation(ImageHeaderParser imageHeaderParser) throws IOException;
    }

    /* loaded from: classes7.dex */
    public interface TypeReader {
        ImageHeaderParser.ImageType getType(ImageHeaderParser imageHeaderParser) throws IOException;
    }

    public ImageHeaderParserUtils() {
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

    @RequiresApi(21)
    public static int getOrientation(@NonNull List<ImageHeaderParser> list, @NonNull ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, @NonNull ArrayPool arrayPool) throws IOException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, list, parcelFileDescriptorRewinder, arrayPool)) == null) {
            return getOrientationInternal(list, new OrientationReader(parcelFileDescriptorRewinder, arrayPool) { // from class: com.bumptech.glide.load.ImageHeaderParserUtils.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ArrayPool val$byteArrayPool;
                public final /* synthetic */ ParcelFileDescriptorRewinder val$parcelFileDescriptorRewinder;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {parcelFileDescriptorRewinder, arrayPool};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$parcelFileDescriptorRewinder = parcelFileDescriptorRewinder;
                    this.val$byteArrayPool = arrayPool;
                }

                @Override // com.bumptech.glide.load.ImageHeaderParserUtils.OrientationReader
                public int getOrientation(ImageHeaderParser imageHeaderParser) throws IOException {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, imageHeaderParser)) == null) {
                        RecyclableBufferedInputStream recyclableBufferedInputStream = null;
                        try {
                            RecyclableBufferedInputStream recyclableBufferedInputStream2 = new RecyclableBufferedInputStream(new FileInputStream(this.val$parcelFileDescriptorRewinder.rewindAndGet().getFileDescriptor()), this.val$byteArrayPool);
                            try {
                                int orientation = imageHeaderParser.getOrientation(recyclableBufferedInputStream2, this.val$byteArrayPool);
                                try {
                                    recyclableBufferedInputStream2.close();
                                } catch (IOException unused) {
                                }
                                this.val$parcelFileDescriptorRewinder.rewindAndGet();
                                return orientation;
                            } catch (Throwable th) {
                                th = th;
                                recyclableBufferedInputStream = recyclableBufferedInputStream2;
                                if (recyclableBufferedInputStream != null) {
                                    try {
                                        recyclableBufferedInputStream.close();
                                    } catch (IOException unused2) {
                                    }
                                }
                                this.val$parcelFileDescriptorRewinder.rewindAndGet();
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } else {
                        return invokeL.intValue;
                    }
                }
            });
        }
        return invokeLLL.intValue;
    }

    @NonNull
    @RequiresApi(21)
    public static ImageHeaderParser.ImageType getType(@NonNull List<ImageHeaderParser> list, @NonNull ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, @NonNull ArrayPool arrayPool) throws IOException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, parcelFileDescriptorRewinder, arrayPool)) == null) {
            return getTypeInternal(list, new TypeReader(parcelFileDescriptorRewinder, arrayPool) { // from class: com.bumptech.glide.load.ImageHeaderParserUtils.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ArrayPool val$byteArrayPool;
                public final /* synthetic */ ParcelFileDescriptorRewinder val$parcelFileDescriptorRewinder;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {parcelFileDescriptorRewinder, arrayPool};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$parcelFileDescriptorRewinder = parcelFileDescriptorRewinder;
                    this.val$byteArrayPool = arrayPool;
                }

                @Override // com.bumptech.glide.load.ImageHeaderParserUtils.TypeReader
                public ImageHeaderParser.ImageType getType(ImageHeaderParser imageHeaderParser) throws IOException {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, imageHeaderParser)) == null) {
                        RecyclableBufferedInputStream recyclableBufferedInputStream = null;
                        try {
                            RecyclableBufferedInputStream recyclableBufferedInputStream2 = new RecyclableBufferedInputStream(new FileInputStream(this.val$parcelFileDescriptorRewinder.rewindAndGet().getFileDescriptor()), this.val$byteArrayPool);
                            try {
                                ImageHeaderParser.ImageType type = imageHeaderParser.getType(recyclableBufferedInputStream2);
                                try {
                                    recyclableBufferedInputStream2.close();
                                } catch (IOException unused) {
                                }
                                this.val$parcelFileDescriptorRewinder.rewindAndGet();
                                return type;
                            } catch (Throwable th) {
                                th = th;
                                recyclableBufferedInputStream = recyclableBufferedInputStream2;
                                if (recyclableBufferedInputStream != null) {
                                    try {
                                        recyclableBufferedInputStream.close();
                                    } catch (IOException unused2) {
                                    }
                                }
                                this.val$parcelFileDescriptorRewinder.rewindAndGet();
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } else {
                        return (ImageHeaderParser.ImageType) invokeL.objValue;
                    }
                }
            });
        }
        return (ImageHeaderParser.ImageType) invokeLLL.objValue;
    }

    public static int getOrientation(@NonNull List<ImageHeaderParser> list, @Nullable InputStream inputStream, @NonNull ArrayPool arrayPool) throws IOException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, list, inputStream, arrayPool)) == null) {
            if (inputStream == null) {
                return -1;
            }
            if (!inputStream.markSupported()) {
                inputStream = new RecyclableBufferedInputStream(inputStream, arrayPool);
            }
            inputStream.mark(5242880);
            return getOrientationInternal(list, new OrientationReader(inputStream, arrayPool) { // from class: com.bumptech.glide.load.ImageHeaderParserUtils.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ArrayPool val$byteArrayPool;
                public final /* synthetic */ InputStream val$finalIs;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {inputStream, arrayPool};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$finalIs = inputStream;
                    this.val$byteArrayPool = arrayPool;
                }

                @Override // com.bumptech.glide.load.ImageHeaderParserUtils.OrientationReader
                public int getOrientation(ImageHeaderParser imageHeaderParser) throws IOException {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, imageHeaderParser)) == null) {
                        try {
                            return imageHeaderParser.getOrientation(this.val$finalIs, this.val$byteArrayPool);
                        } finally {
                            this.val$finalIs.reset();
                        }
                    }
                    return invokeL.intValue;
                }
            });
        }
        return invokeLLL.intValue;
    }

    public static int getOrientationInternal(@NonNull List<ImageHeaderParser> list, OrientationReader orientationReader) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, list, orientationReader)) == null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                int orientation = orientationReader.getOrientation(list.get(i));
                if (orientation != -1) {
                    return orientation;
                }
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    @NonNull
    public static ImageHeaderParser.ImageType getType(@NonNull List<ImageHeaderParser> list, @Nullable ByteBuffer byteBuffer) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, list, byteBuffer)) == null) {
            if (byteBuffer == null) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            return getTypeInternal(list, new TypeReader(byteBuffer) { // from class: com.bumptech.glide.load.ImageHeaderParserUtils.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ByteBuffer val$buffer;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {byteBuffer};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$buffer = byteBuffer;
                }

                @Override // com.bumptech.glide.load.ImageHeaderParserUtils.TypeReader
                public ImageHeaderParser.ImageType getType(ImageHeaderParser imageHeaderParser) throws IOException {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, imageHeaderParser)) == null) {
                        return imageHeaderParser.getType(this.val$buffer);
                    }
                    return (ImageHeaderParser.ImageType) invokeL.objValue;
                }
            });
        }
        return (ImageHeaderParser.ImageType) invokeLL.objValue;
    }

    @NonNull
    public static ImageHeaderParser.ImageType getTypeInternal(@NonNull List<ImageHeaderParser> list, TypeReader typeReader) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, list, typeReader)) == null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ImageHeaderParser.ImageType type = typeReader.getType(list.get(i));
                if (type != ImageHeaderParser.ImageType.UNKNOWN) {
                    return type;
                }
            }
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        return (ImageHeaderParser.ImageType) invokeLL.objValue;
    }

    @NonNull
    public static ImageHeaderParser.ImageType getType(@NonNull List<ImageHeaderParser> list, @Nullable InputStream inputStream, @NonNull ArrayPool arrayPool) throws IOException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, list, inputStream, arrayPool)) == null) {
            if (inputStream == null) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            if (!inputStream.markSupported()) {
                inputStream = new RecyclableBufferedInputStream(inputStream, arrayPool);
            }
            inputStream.mark(5242880);
            return getTypeInternal(list, new TypeReader(inputStream) { // from class: com.bumptech.glide.load.ImageHeaderParserUtils.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ InputStream val$finalIs;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {inputStream};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$finalIs = inputStream;
                }

                @Override // com.bumptech.glide.load.ImageHeaderParserUtils.TypeReader
                public ImageHeaderParser.ImageType getType(ImageHeaderParser imageHeaderParser) throws IOException {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, imageHeaderParser)) == null) {
                        try {
                            return imageHeaderParser.getType(this.val$finalIs);
                        } finally {
                            this.val$finalIs.reset();
                        }
                    }
                    return (ImageHeaderParser.ImageType) invokeL.objValue;
                }
            });
        }
        return (ImageHeaderParser.ImageType) invokeLLL.objValue;
    }
}
