package com.baidu.ugc.editvideo.faceunity.gles;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class WindowSurface extends EglSurfaceBase {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mReleaseSurface;
    public Surface mSurface;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WindowSurface(EglCore eglCore, Surface surface, boolean z) {
        super(eglCore);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eglCore, surface, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((EglCore) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        createWindowSurface(surface);
        this.mSurface = surface;
        this.mReleaseSurface = z;
    }

    public void recreate(EglCore eglCore) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, eglCore) == null) {
            Surface surface = this.mSurface;
            if (surface != null) {
                this.mEglCore = eglCore;
                createWindowSurface(surface);
                return;
            }
            throw new RuntimeException("not yet implemented for SurfaceTexture");
        }
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            releaseEglSurface();
            Surface surface = this.mSurface;
            if (surface != null) {
                if (this.mReleaseSurface) {
                    surface.release();
                }
                this.mSurface = null;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WindowSurface(EglCore eglCore, SurfaceTexture surfaceTexture) {
        super(eglCore);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eglCore, surfaceTexture};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((EglCore) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        createWindowSurface(surfaceTexture);
    }
}
