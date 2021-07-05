package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
/* loaded from: classes6.dex */
public final class ImageHeaderParserUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MARK_POSITION = 5242880;
    public transient /* synthetic */ FieldHolder $fh;

    public ImageHeaderParserUtils() {
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

    public static int getOrientation(@NonNull List<ImageHeaderParser> list, @Nullable InputStream inputStream, @NonNull ArrayPool arrayPool) throws IOException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, list, inputStream, arrayPool)) == null) {
            if (inputStream == null) {
                return -1;
            }
            if (!inputStream.markSupported()) {
                inputStream = new RecyclableBufferedInputStream(inputStream, arrayPool);
            }
            inputStream.mark(5242880);
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                try {
                    int orientation = list.get(i2).getOrientation(inputStream, arrayPool);
                    if (orientation != -1) {
                        return orientation;
                    }
                    inputStream.reset();
                } finally {
                    inputStream.reset();
                }
            }
            return -1;
        }
        return invokeLLL.intValue;
    }

    @NonNull
    public static ImageHeaderParser.ImageType getType(@NonNull List<ImageHeaderParser> list, @Nullable InputStream inputStream, @NonNull ArrayPool arrayPool) throws IOException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, list, inputStream, arrayPool)) == null) {
            if (inputStream == null) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            if (!inputStream.markSupported()) {
                inputStream = new RecyclableBufferedInputStream(inputStream, arrayPool);
            }
            inputStream.mark(5242880);
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                try {
                    ImageHeaderParser.ImageType type = list.get(i2).getType(inputStream);
                    if (type != ImageHeaderParser.ImageType.UNKNOWN) {
                        return type;
                    }
                    inputStream.reset();
                } finally {
                    inputStream.reset();
                }
            }
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        return (ImageHeaderParser.ImageType) invokeLLL.objValue;
    }

    @NonNull
    public static ImageHeaderParser.ImageType getType(@NonNull List<ImageHeaderParser> list, @Nullable ByteBuffer byteBuffer) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, list, byteBuffer)) == null) {
            if (byteBuffer == null) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                ImageHeaderParser.ImageType type = list.get(i2).getType(byteBuffer);
                if (type != ImageHeaderParser.ImageType.UNKNOWN) {
                    return type;
                }
            }
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        return (ImageHeaderParser.ImageType) invokeLL.objValue;
    }
}
