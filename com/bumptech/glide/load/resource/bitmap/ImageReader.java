package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.ParcelFileDescriptor;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.data.InputStreamRewinder;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.util.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
/* loaded from: classes7.dex */
public interface ImageReader {
    @Nullable
    Bitmap decodeBitmap(BitmapFactory.Options options) throws IOException;

    int getImageOrientation() throws IOException;

    ImageHeaderParser.ImageType getImageType() throws IOException;

    void stopGrowingBuffers();

    /* loaded from: classes7.dex */
    public static final class InputStreamImageReader implements ImageReader {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ArrayPool byteArrayPool;
        public final InputStreamRewinder dataRewinder;
        public final List<ImageHeaderParser> parsers;

        public InputStreamImageReader(InputStream inputStream, List<ImageHeaderParser> list, ArrayPool arrayPool) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {inputStream, list, arrayPool};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.byteArrayPool = (ArrayPool) Preconditions.checkNotNull(arrayPool);
            this.parsers = (List) Preconditions.checkNotNull(list);
            this.dataRewinder = new InputStreamRewinder(inputStream, arrayPool);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        @Nullable
        public Bitmap decodeBitmap(BitmapFactory.Options options) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, options)) == null) {
                return BitmapFactory.decodeStream(this.dataRewinder.rewindAndGet(), null, options);
            }
            return (Bitmap) invokeL.objValue;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public int getImageOrientation() throws IOException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return ImageHeaderParserUtils.getOrientation(this.parsers, this.dataRewinder.rewindAndGet(), this.byteArrayPool);
            }
            return invokeV.intValue;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public ImageHeaderParser.ImageType getImageType() throws IOException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return ImageHeaderParserUtils.getType(this.parsers, this.dataRewinder.rewindAndGet(), this.byteArrayPool);
            }
            return (ImageHeaderParser.ImageType) invokeV.objValue;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public void stopGrowingBuffers() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.dataRewinder.fixMarkLimits();
            }
        }
    }

    @RequiresApi(21)
    /* loaded from: classes7.dex */
    public static final class ParcelFileDescriptorImageReader implements ImageReader {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ArrayPool byteArrayPool;
        public final ParcelFileDescriptorRewinder dataRewinder;
        public final List<ImageHeaderParser> parsers;

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public void stopGrowingBuffers() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            }
        }

        public ParcelFileDescriptorImageReader(ParcelFileDescriptor parcelFileDescriptor, List<ImageHeaderParser> list, ArrayPool arrayPool) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcelFileDescriptor, list, arrayPool};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.byteArrayPool = (ArrayPool) Preconditions.checkNotNull(arrayPool);
            this.parsers = (List) Preconditions.checkNotNull(list);
            this.dataRewinder = new ParcelFileDescriptorRewinder(parcelFileDescriptor);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        @Nullable
        public Bitmap decodeBitmap(BitmapFactory.Options options) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, options)) == null) {
                return BitmapFactory.decodeFileDescriptor(this.dataRewinder.rewindAndGet().getFileDescriptor(), null, options);
            }
            return (Bitmap) invokeL.objValue;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public int getImageOrientation() throws IOException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return ImageHeaderParserUtils.getOrientation(this.parsers, this.dataRewinder, this.byteArrayPool);
            }
            return invokeV.intValue;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ImageReader
        public ImageHeaderParser.ImageType getImageType() throws IOException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return ImageHeaderParserUtils.getType(this.parsers, this.dataRewinder, this.byteArrayPool);
            }
            return (ImageHeaderParser.ImageType) invokeV.objValue;
        }
    }
}
