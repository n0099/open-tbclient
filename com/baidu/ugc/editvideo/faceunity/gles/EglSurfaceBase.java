package com.baidu.ugc.editvideo.faceunity.gles;

import android.graphics.Bitmap;
import android.opengl.EGL14;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.faceunity.gles.GeneratedTexture;
import com.repackage.rb9;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/* loaded from: classes4.dex */
public class EglSurfaceBase {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "Grafika";
    public transient /* synthetic */ FieldHolder $fh;
    public EGLSurface mEGLSurface;
    public EglCore mEglCore;
    public int mHeight;
    public int mWidth;

    public EglSurfaceBase(EglCore eglCore) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eglCore};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mEGLSurface = EGL14.EGL_NO_SURFACE;
        this.mWidth = -1;
        this.mHeight = -1;
        this.mEglCore = eglCore;
    }

    public void createOffscreenSurface(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
            if (this.mEGLSurface == EGL14.EGL_NO_SURFACE) {
                this.mEGLSurface = this.mEglCore.createOffscreenSurface(i, i2);
                this.mWidth = i;
                this.mHeight = i2;
                return;
            }
            throw new IllegalStateException("surface already created");
        }
    }

    public void createWindowSurface(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
            if (this.mEGLSurface == EGL14.EGL_NO_SURFACE) {
                this.mEGLSurface = this.mEglCore.createWindowSurface(obj);
                return;
            }
            throw new IllegalStateException("surface already created");
        }
    }

    public int getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int i = this.mHeight;
            return i < 0 ? this.mEglCore.querySurface(this.mEGLSurface, 12374) : i;
        }
        return invokeV.intValue;
    }

    public int getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int i = this.mWidth;
            return i < 0 ? this.mEglCore.querySurface(this.mEGLSurface, 12375) : i;
        }
        return invokeV.intValue;
    }

    public void makeCurrent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.mEglCore.makeCurrent(this.mEGLSurface);
        }
    }

    public void makeCurrentReadFrom(EglSurfaceBase eglSurfaceBase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, eglSurfaceBase) == null) {
            this.mEglCore.makeCurrent(this.mEGLSurface, eglSurfaceBase.mEGLSurface);
        }
    }

    public void releaseEglSurface() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.mEglCore.releaseSurface(this.mEGLSurface);
            this.mEGLSurface = EGL14.EGL_NO_SURFACE;
            this.mHeight = -1;
            this.mWidth = -1;
        }
    }

    public void saveFrame(File file) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048583, this, file) != null) {
            return;
        }
        if (this.mEglCore.isCurrent(this.mEGLSurface)) {
            String file2 = file.toString();
            int width = getWidth();
            int height = getHeight();
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(width * height * 4);
            allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
            GLES20.glReadPixels(0, 0, width, height, GeneratedTexture.FORMAT, 5121, allocateDirect);
            GlUtil.checkGlError("glReadPixels");
            allocateDirect.rewind();
            BufferedOutputStream bufferedOutputStream = null;
            try {
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file2));
                try {
                    Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                    createBitmap.copyPixelsFromBuffer(allocateDirect);
                    createBitmap.compress(Bitmap.CompressFormat.PNG, 90, bufferedOutputStream2);
                    createBitmap.recycle();
                    bufferedOutputStream2.close();
                    rb9.c("Grafika", "Saved " + width + "x" + height + " frame as '" + file2 + "'");
                } catch (Throwable th) {
                    th = th;
                    bufferedOutputStream = bufferedOutputStream2;
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            throw new RuntimeException("Expected EGL context/surface is not current");
        }
    }

    public void setPresentationTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j) == null) {
            this.mEglCore.setPresentationTime(this.mEGLSurface, j);
        }
    }

    public boolean swapBuffers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            boolean swapBuffers = this.mEglCore.swapBuffers(this.mEGLSurface);
            if (!swapBuffers) {
                rb9.c("Grafika", "WARNING: swapBuffers() failed");
            }
            return swapBuffers;
        }
        return invokeV.booleanValue;
    }
}
