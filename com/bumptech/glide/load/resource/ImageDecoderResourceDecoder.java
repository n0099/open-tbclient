package com.bumptech.glide.load.resource;

import android.annotation.SuppressLint;
import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.os.Build;
import android.util.Log;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.PreferredColorSpace;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.load.resource.bitmap.HardwareConfigState;
import java.io.IOException;
@RequiresApi(api = 28)
/* loaded from: classes7.dex */
public abstract class ImageDecoderResourceDecoder<T> implements ResourceDecoder<ImageDecoder.Source, T> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "ImageDecoder";
    public transient /* synthetic */ FieldHolder $fh;
    public final HardwareConfigState hardwareConfigState;

    public abstract Resource<T> decode(ImageDecoder.Source source, int i, int i2, ImageDecoder.OnHeaderDecodedListener onHeaderDecodedListener) throws IOException;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bumptech.glide.load.ResourceDecoder
    public final boolean handles(@NonNull ImageDecoder.Source source, @NonNull Options options) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, source, options)) == null) {
            return true;
        }
        return invokeLL.booleanValue;
    }

    public ImageDecoderResourceDecoder() {
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
        this.hardwareConfigState = HardwareConfigState.getInstance();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bumptech.glide.load.ResourceDecoder
    @Nullable
    public final Resource<T> decode(@NonNull ImageDecoder.Source source, int i, int i2, @NonNull Options options) throws IOException {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{source, Integer.valueOf(i), Integer.valueOf(i2), options})) == null) {
            DecodeFormat decodeFormat = (DecodeFormat) options.get(Downsampler.DECODE_FORMAT);
            DownsampleStrategy downsampleStrategy = (DownsampleStrategy) options.get(DownsampleStrategy.OPTION);
            if (options.get(Downsampler.ALLOW_HARDWARE_CONFIG) != null && ((Boolean) options.get(Downsampler.ALLOW_HARDWARE_CONFIG)).booleanValue()) {
                z = true;
            } else {
                z = false;
            }
            return decode(source, i, i2, new ImageDecoder.OnHeaderDecodedListener(this, i, i2, z, decodeFormat, downsampleStrategy, (PreferredColorSpace) options.get(Downsampler.PREFERRED_COLOR_SPACE)) { // from class: com.bumptech.glide.load.resource.ImageDecoderResourceDecoder.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ImageDecoderResourceDecoder this$0;
                public final /* synthetic */ DecodeFormat val$decodeFormat;
                public final /* synthetic */ boolean val$isHardwareConfigAllowed;
                public final /* synthetic */ PreferredColorSpace val$preferredColorSpace;
                public final /* synthetic */ int val$requestedHeight;
                public final /* synthetic */ int val$requestedWidth;
                public final /* synthetic */ DownsampleStrategy val$strategy;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), decodeFormat, downsampleStrategy, r12};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$requestedWidth = i;
                    this.val$requestedHeight = i2;
                    this.val$isHardwareConfigAllowed = z;
                    this.val$decodeFormat = decodeFormat;
                    this.val$strategy = downsampleStrategy;
                    this.val$preferredColorSpace = r12;
                }

                @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
                @SuppressLint({"Override"})
                public void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source2) {
                    ColorSpace.Named named;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLL(1048576, this, imageDecoder, imageInfo, source2) == null) {
                        boolean z2 = false;
                        if (this.this$0.hardwareConfigState.isHardwareConfigAllowed(this.val$requestedWidth, this.val$requestedHeight, this.val$isHardwareConfigAllowed, false)) {
                            imageDecoder.setAllocator(3);
                        } else {
                            imageDecoder.setAllocator(1);
                        }
                        if (this.val$decodeFormat == DecodeFormat.PREFER_RGB_565) {
                            imageDecoder.setMemorySizePolicy(0);
                        }
                        imageDecoder.setOnPartialImageListener(new ImageDecoder.OnPartialImageListener(this) { // from class: com.bumptech.glide.load.resource.ImageDecoderResourceDecoder.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass1 this$1;

                            @Override // android.graphics.ImageDecoder.OnPartialImageListener
                            public boolean onPartialImage(@NonNull ImageDecoder.DecodeException decodeException) {
                                InterceptResult invokeL;
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || (invokeL = interceptable3.invokeL(1048576, this, decodeException)) == null) {
                                    return false;
                                }
                                return invokeL.booleanValue;
                            }

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i3 = newInitContext.flag;
                                    if ((i3 & 1) != 0) {
                                        int i4 = i3 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$1 = this;
                            }
                        });
                        Size size = imageInfo.getSize();
                        int i3 = this.val$requestedWidth;
                        if (i3 == Integer.MIN_VALUE) {
                            i3 = size.getWidth();
                        }
                        int i4 = this.val$requestedHeight;
                        if (i4 == Integer.MIN_VALUE) {
                            i4 = size.getHeight();
                        }
                        float scaleFactor = this.val$strategy.getScaleFactor(size.getWidth(), size.getHeight(), i3, i4);
                        int round = Math.round(size.getWidth() * scaleFactor);
                        int round2 = Math.round(size.getHeight() * scaleFactor);
                        if (Log.isLoggable(ImageDecoderResourceDecoder.TAG, 2)) {
                            Log.v(ImageDecoderResourceDecoder.TAG, "Resizing from [" + size.getWidth() + "x" + size.getHeight() + "] to [" + round + "x" + round2 + "] scaleFactor: " + scaleFactor);
                        }
                        imageDecoder.setTargetSize(round, round2);
                        int i5 = Build.VERSION.SDK_INT;
                        if (i5 >= 28) {
                            if (this.val$preferredColorSpace == PreferredColorSpace.DISPLAY_P3 && imageInfo.getColorSpace() != null && imageInfo.getColorSpace().isWideGamut()) {
                                z2 = true;
                            }
                            if (z2) {
                                named = ColorSpace.Named.DISPLAY_P3;
                            } else {
                                named = ColorSpace.Named.SRGB;
                            }
                            imageDecoder.setTargetColorSpace(ColorSpace.get(named));
                        } else if (i5 >= 26) {
                            imageDecoder.setTargetColorSpace(ColorSpace.get(ColorSpace.Named.SRGB));
                        }
                    }
                }
            });
        }
        return (Resource) invokeCommon.objValue;
    }
}
