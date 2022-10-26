package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.util.Log;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPoolAdapter;
import com.bumptech.glide.load.resource.ImageDecoderResourceDecoder;
import java.io.IOException;
/* loaded from: classes7.dex */
public final class BitmapImageDecoderResourceDecoder extends ImageDecoderResourceDecoder {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "BitmapImageDecoder";
    public transient /* synthetic */ FieldHolder $fh;
    public final BitmapPool bitmapPool;

    public BitmapImageDecoderResourceDecoder() {
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
        this.bitmapPool = new BitmapPoolAdapter();
    }

    @Override // com.bumptech.glide.load.resource.ImageDecoderResourceDecoder
    public Resource decode(ImageDecoder.Source source, int i, int i2, ImageDecoder.OnHeaderDecodedListener onHeaderDecodedListener) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{source, Integer.valueOf(i), Integer.valueOf(i2), onHeaderDecodedListener})) == null) {
            Bitmap decodeBitmap = ImageDecoder.decodeBitmap(source, onHeaderDecodedListener);
            if (Log.isLoggable(TAG, 2)) {
                Log.v(TAG, "Decoded [" + decodeBitmap.getWidth() + "x" + decodeBitmap.getHeight() + "] for [" + i + "x" + i2 + PreferencesUtil.RIGHT_MOUNT);
            }
            return new BitmapResource(decodeBitmap, this.bitmapPool);
        }
        return (Resource) invokeCommon.objValue;
    }
}
