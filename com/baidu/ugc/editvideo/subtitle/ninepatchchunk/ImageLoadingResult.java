package com.baidu.ugc.editvideo.subtitle.ninepatchchunk;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ImageLoadingResult {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Bitmap bitmap;
    public final NinePatchChunk chunk;

    public ImageLoadingResult(Bitmap bitmap, NinePatchChunk ninePatchChunk) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bitmap, ninePatchChunk};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.bitmap = bitmap;
        this.chunk = ninePatchChunk;
    }

    public NinePatchDrawable getNinePatchDrawable(Resources resources, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, resources, str)) == null) {
            if (this.bitmap == null) {
                return null;
            }
            return this.chunk == null ? new NinePatchDrawable(resources, this.bitmap, null, new Rect(), str) : new NinePatchDrawable(resources, this.bitmap, this.chunk.toBytes(), this.chunk.padding, str);
        }
        return (NinePatchDrawable) invokeLL.objValue;
    }
}
