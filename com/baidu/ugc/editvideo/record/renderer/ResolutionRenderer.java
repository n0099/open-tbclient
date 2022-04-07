package com.baidu.ugc.editvideo.record.renderer;

import android.opengl.GLES20;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.pf0;
/* loaded from: classes4.dex */
public class ResolutionRenderer extends MediaBaseRenderer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int mDuration;
    public int mLastResolutionHeight;
    public long mLastTimeStamp;
    public float mProgress;
    public int mResolutionHeight;
    public int mResolutionWidth;

    public ResolutionRenderer() {
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
        this.mProgress = 1.0f;
        this.mDuration = 200;
    }

    private void checkRatio(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65537, this, f) == null) {
            int i = this.mSurfaceViewWidth;
            this.mResolutionWidth = i;
            this.mResolutionHeight = (int) (i * f);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.MediaBaseRenderer, com.baidu.ugc.editvideo.record.renderer.IMediaRenderer
    public void onDrawFrame(pf0 pf0Var, int i, float[] fArr) {
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048576, this, pf0Var, i, fArr) == null) || this.mRatio == 0.0f) {
            return;
        }
        if (!(this.mResolutionWidth == this.mSurfaceViewWidth && this.mResolutionHeight == this.mSurfaceViewHeight) && (i2 = (this.mSurfaceViewHeight - this.mResolutionHeight) / 2) > 1) {
            long currentTimeMillis = System.currentTimeMillis() - this.mLastTimeStamp;
            int i5 = this.mDuration;
            if (currentTimeMillis >= i5) {
                this.mProgress = 1.0f;
            } else {
                this.mProgress = (((float) currentTimeMillis) * 1.0f) / i5;
            }
            GLES20.glEnable(3089);
            float f = this.mProgress;
            if (f != 1.0f) {
                int i6 = (int) ((((this.mSurfaceViewHeight - this.mLastResolutionHeight) / 2) * 0.466f) / 0.5f);
                i3 = (int) (i6 + ((((int) ((i2 * 0.466f) / 0.5f)) - i6) * f));
            } else {
                i3 = (int) ((i2 * 0.466f) / 0.5f);
            }
            GLES20.glScissor(0, this.mSurfaceViewHeight - i3, this.mResolutionWidth, i3);
            GLES20.glClearColor(this.mRed, this.mGreen, this.mBlue, this.mAlpha);
            GLES20.glClear(16640);
            float f2 = this.mProgress;
            if (f2 != 1.0f) {
                int i7 = (int) ((((this.mSurfaceViewHeight - this.mLastResolutionHeight) / 2) * 0.53400004f) / 0.5f);
                i4 = (int) (i7 + ((((int) ((i2 * 0.53400004f) / 0.5f)) - i7) * f2));
            } else {
                i4 = (int) ((i2 * 0.53400004f) / 0.5f);
            }
            GLES20.glScissor(0, 0, this.mResolutionWidth, i4);
            GLES20.glClearColor(this.mRed, this.mGreen, this.mBlue, this.mAlpha);
            GLES20.glClear(16640);
            GLES20.glDisable(3089);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.MediaBaseRenderer, com.baidu.ugc.editvideo.record.renderer.IMediaRenderer
    public void setResolutionRatio(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f) == null) {
            super.setResolutionRatio(f);
            this.mLastResolutionHeight = this.mResolutionHeight;
            checkRatio(f);
            if (this.mLastResolutionHeight != this.mResolutionHeight) {
                this.mProgress = 0.0f;
                this.mLastTimeStamp = System.currentTimeMillis();
            }
        }
    }
}
