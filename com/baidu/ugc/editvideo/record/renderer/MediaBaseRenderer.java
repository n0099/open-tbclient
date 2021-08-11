package com.baidu.ugc.editvideo.record.renderer;

import android.opengl.GLES20;
import androidx.core.view.InputDeviceCompat;
import c.a.z.b.a.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.faceunity.gles.FullFrameRect;
import com.baidu.ugc.editvideo.faceunity.gles.GlUtil;
import com.baidu.ugc.editvideo.record.entity.GLViewPortLocation;
import com.baidu.wallet.paysdk.banksign.beans.BankSignFactory;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes8.dex */
public class MediaBaseRenderer implements IMediaRenderer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float mAlpha;
    public float mBlue;
    public FullFrameRect mFullScreen2D;
    public FullFrameRect mFullScreenEXT;
    public GLViewPortLocation mGLViewPortLocation;
    public float mGreen;
    public float[] mMtx;
    public int mPreviewHeight;
    public int mPreviewWidth;
    public float mRatio;
    public float mRed;
    public float mScaleX;
    public float mScaleY;
    public int mSurfaceViewHeight;
    public int mSurfaceViewWidth;
    public int mTextureId;
    public int mTextureMode;
    public float mTx;
    public float mTy;

    public MediaBaseRenderer() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mScaleX = 1.0f;
        this.mScaleY = 1.0f;
        this.mTx = 0.0f;
        this.mTy = 0.0f;
        this.mRed = 0.0f;
        this.mGreen = 0.0f;
        this.mBlue = 0.0f;
        this.mAlpha = 0.0f;
    }

    @Override // com.baidu.ugc.editvideo.record.IMediaLifeCycle
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // com.baidu.ugc.editvideo.record.IMediaLifeCycleIncludeGlThread
    public void onDestroyInGlThread() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.IMediaRenderer
    public void onDrawFrame(e eVar, int i2, float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, eVar, i2, fArr) == null) {
            this.mTextureId = i2;
            this.mMtx = fArr;
            GLViewPortLocation gLViewPortLocation = this.mGLViewPortLocation;
            GLES20.glViewport(gLViewPortLocation.x, gLViewPortLocation.y, gLViewPortLocation.width, gLViewPortLocation.height);
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(BankSignFactory.BEAN_ID_QUERY, BankSignFactory.BEAN_ID_BIND_CARD);
            if (this.mTextureMode == 1) {
                this.mFullScreen2D.setVertexPoint(GlUtil.IDENTITY_MATRIX);
                this.mFullScreen2D.setScaleAndTranslate(this.mScaleX, this.mScaleY, this.mTx, this.mTy);
                this.mFullScreen2D.drawFrame(i2, fArr);
                this.mFullScreen2D.setScaleAndTranslate(1.0f, 1.0f, 0.0f, 0.0f);
            } else {
                this.mFullScreenEXT.setScaleAndTranslate(this.mScaleX, this.mScaleY, this.mTx, this.mTy);
                this.mFullScreenEXT.drawFrame(i2, fArr);
                this.mFullScreenEXT.setScaleAndTranslate(1.0f, 1.0f, 0.0f, 0.0f);
            }
            GLES20.glDisable(3042);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.IMediaRenderer
    public void onGLLocation(GLViewPortLocation gLViewPortLocation) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, gLViewPortLocation) == null) {
            this.mGLViewPortLocation = gLViewPortLocation;
        }
    }

    @Override // com.baidu.ugc.editvideo.record.IMediaLifeCycle
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    @Override // com.baidu.ugc.editvideo.record.IMediaLifeCycleIncludeGlThread
    public void onPauseInGlThread() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    @Override // com.baidu.ugc.editvideo.record.IMediaLifeCycle
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    @Override // com.baidu.ugc.editvideo.record.IMediaLifeCycleIncludeGlThread
    public void onResumeInGlThread() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.IMediaRenderer
    public void onSurfaceChanged(GL10 gl10, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(InputDeviceCompat.SOURCE_TOUCHPAD, this, gl10, i2, i3) == null) {
            this.mSurfaceViewWidth = i2;
            this.mSurfaceViewHeight = i3;
        }
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.IMediaRenderer
    public void onSurfaceCreate(FullFrameRect fullFrameRect, FullFrameRect fullFrameRect2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, fullFrameRect, fullFrameRect2) == null) {
            this.mFullScreenEXT = fullFrameRect;
            this.mFullScreen2D = fullFrameRect2;
        }
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.IMediaRenderer
    public void setEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
        }
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.IMediaRenderer
    public void setGlClearColor(float f2, float f3, float f4, float f5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
            this.mRed = f2;
            this.mGreen = f3;
            this.mBlue = f4;
            this.mAlpha = f5;
        }
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.IMediaRenderer
    public void setPreviewSize(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048588, this, i2, i3) == null) {
            this.mPreviewWidth = i2;
            this.mPreviewHeight = i3;
        }
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.IMediaRenderer
    public void setResolutionRatio(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048589, this, f2) == null) {
            this.mRatio = f2;
        }
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.IMediaRenderer
    public void setScaleAndTranslate(float f2, float f3, float f4, float f5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
            this.mScaleX = f2;
            this.mScaleY = f3;
            this.mTx = f4;
            this.mTy = f5;
        }
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.IMediaRenderer
    public void setTextureMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.mTextureMode = i2;
        }
    }
}
