package com.baidu.ugc.editvideo.record.renderer;

import android.opengl.GLES20;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.tieba.eg0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.faceunity.gles.FullFrameRect;
import com.baidu.ugc.editvideo.faceunity.gles.GlUtil;
import com.baidu.ugc.editvideo.record.entity.GLViewPortLocation;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes6.dex */
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
    public void setEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
        }
    }

    public MediaBaseRenderer() {
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
        this.mScaleX = 1.0f;
        this.mScaleY = 1.0f;
        this.mTx = 0.0f;
        this.mTy = 0.0f;
        this.mRed = 0.0f;
        this.mGreen = 0.0f;
        this.mBlue = 0.0f;
        this.mAlpha = 0.0f;
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.IMediaRenderer
    public void onDrawFrame(eg0 eg0Var, int i, float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, eg0Var, i, fArr) == null) {
            this.mTextureId = i;
            this.mMtx = fArr;
            GLViewPortLocation gLViewPortLocation = this.mGLViewPortLocation;
            GLES20.glViewport(gLViewPortLocation.x, gLViewPortLocation.y, gLViewPortLocation.width, gLViewPortLocation.height);
            GLES20.glEnable(SpeedStatsStampTable.MAINACTIVITY_ONRESUME_END_STAMP_KEY);
            GLES20.glBlendFunc(770, 771);
            if (this.mTextureMode == 1) {
                this.mFullScreen2D.setVertexPoint(GlUtil.IDENTITY_MATRIX);
                this.mFullScreen2D.setScaleAndTranslate(this.mScaleX, this.mScaleY, this.mTx, this.mTy);
                this.mFullScreen2D.drawFrame(i, fArr);
                this.mFullScreen2D.setScaleAndTranslate(1.0f, 1.0f, 0.0f, 0.0f);
            } else {
                this.mFullScreenEXT.setScaleAndTranslate(this.mScaleX, this.mScaleY, this.mTx, this.mTy);
                this.mFullScreenEXT.drawFrame(i, fArr);
                this.mFullScreenEXT.setScaleAndTranslate(1.0f, 1.0f, 0.0f, 0.0f);
            }
            GLES20.glDisable(SpeedStatsStampTable.MAINACTIVITY_ONRESUME_END_STAMP_KEY);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.IMediaRenderer
    public void onGLLocation(GLViewPortLocation gLViewPortLocation) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, gLViewPortLocation) == null) {
            this.mGLViewPortLocation = gLViewPortLocation;
        }
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.IMediaRenderer
    public void setResolutionRatio(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048589, this, f) == null) {
            this.mRatio = f;
        }
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.IMediaRenderer
    public void setTextureMode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.mTextureMode = i;
        }
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.IMediaRenderer
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(InputDeviceCompat.SOURCE_TOUCHPAD, this, gl10, i, i2) == null) {
            this.mSurfaceViewWidth = i;
            this.mSurfaceViewHeight = i2;
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
    public void setPreviewSize(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048588, this, i, i2) == null) {
            this.mPreviewWidth = i;
            this.mPreviewHeight = i2;
        }
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.IMediaRenderer
    public void setGlClearColor(float f, float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
            this.mRed = f;
            this.mGreen = f2;
            this.mBlue = f3;
            this.mAlpha = f4;
        }
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.IMediaRenderer
    public void setScaleAndTranslate(float f, float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
            this.mScaleX = f;
            this.mScaleY = f2;
            this.mTx = f3;
            this.mTy = f4;
        }
    }
}
