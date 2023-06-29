package com.baidu.tieba;

import android.view.TextureView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class rob {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextureView.SurfaceTextureListener a;

    public void a(TextureView.SurfaceTextureListener surfaceTextureListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, surfaceTextureListener) == null) {
            this.a = surfaceTextureListener;
        }
    }
}
