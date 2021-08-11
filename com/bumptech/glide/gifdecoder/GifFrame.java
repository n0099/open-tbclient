package com.bumptech.glide.gifdecoder;

import androidx.annotation.ColorInt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class GifFrame {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DISPOSAL_BACKGROUND = 2;
    public static final int DISPOSAL_NONE = 1;
    public static final int DISPOSAL_PREVIOUS = 3;
    public static final int DISPOSAL_UNSPECIFIED = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public int bufferFrameStart;
    public int delay;
    public int dispose;
    public int ih;
    public boolean interlace;
    public int iw;
    public int ix;
    public int iy;
    @ColorInt
    public int[] lct;
    public int transIndex;
    public boolean transparency;

    public GifFrame() {
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
}
