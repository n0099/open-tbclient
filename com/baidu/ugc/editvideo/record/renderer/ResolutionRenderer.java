package com.baidu.ugc.editvideo.record.renderer;

import android.opengl.GLES20;
import b.a.a0.b.a.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mProgress = 1.0f;
        this.mDuration = 200;
    }

    private void checkRatio(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65537, this, f2) == null) {
            int i2 = this.mSurfaceViewWidth;
            this.mResolutionWidth = i2;
            this.mResolutionHeight = (int) (i2 * f2);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.MediaBaseRenderer, com.baidu.ugc.editvideo.record.renderer.IMediaRenderer
    public void onDrawFrame(e eVar, int i2, float[] fArr) {
        int i3;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048576, this, eVar, i2, fArr) == null) || this.mRatio == 0.0f) {
            return;
        }
        if (!(this.mResolutionWidth == this.mSurfaceViewWidth && this.mResolutionHeight == this.mSurfaceViewHeight) && (i3 = (this.mSurfaceViewHeight - this.mResolutionHeight) / 2) > 1) {
            long currentTimeMillis = System.currentTimeMillis() - this.mLastTimeStamp;
            int i6 = this.mDuration;
            if (currentTimeMillis >= i6) {
                this.mProgress = 1.0f;
            } else {
                this.mProgress = (((float) currentTimeMillis) * 1.0f) / i6;
            }
            GLES20.glEnable(3089);
            float f2 = this.mProgress;
            if (f2 != 1.0f) {
                int i7 = (int) ((((this.mSurfaceViewHeight - this.mLastResolutionHeight) / 2) * 0.466f) / 0.5f);
                i4 = (int) (i7 + ((((int) ((i3 * 0.466f) / 0.5f)) - i7) * f2));
            } else {
                i4 = (int) ((i3 * 0.466f) / 0.5f);
            }
            GLES20.glScissor(0, this.mSurfaceViewHeight - i4, this.mResolutionWidth, i4);
            GLES20.glClearColor(this.mRed, this.mGreen, this.mBlue, this.mAlpha);
            GLES20.glClear(16640);
            float f3 = this.mProgress;
            if (f3 != 1.0f) {
                int i8 = (int) ((((this.mSurfaceViewHeight - this.mLastResolutionHeight) / 2) * 0.53400004f) / 0.5f);
                i5 = (int) (i8 + ((((int) ((i3 * 0.53400004f) / 0.5f)) - i8) * f3));
            } else {
                i5 = (int) ((i3 * 0.53400004f) / 0.5f);
            }
            GLES20.glScissor(0, 0, this.mResolutionWidth, i5);
            GLES20.glClearColor(this.mRed, this.mGreen, this.mBlue, this.mAlpha);
            GLES20.glClear(16640);
            GLES20.glDisable(3089);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.renderer.MediaBaseRenderer, com.baidu.ugc.editvideo.record.renderer.IMediaRenderer
    public void setResolutionRatio(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2) == null) {
            super.setResolutionRatio(f2);
            this.mLastResolutionHeight = this.mResolutionHeight;
            checkRatio(f2);
            if (this.mLastResolutionHeight != this.mResolutionHeight) {
                this.mProgress = 0.0f;
                this.mLastTimeStamp = System.currentTimeMillis();
            }
        }
    }
}
