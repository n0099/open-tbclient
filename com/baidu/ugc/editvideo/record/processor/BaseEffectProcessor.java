package com.baidu.ugc.editvideo.record.processor;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.faceunity.gles.FullFrameRect;
/* loaded from: classes7.dex */
public abstract class BaseEffectProcessor implements IEffectProcessor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float mAlpha;
    public float mBlue;
    public float mGreen;
    public int mInputTextureMode;
    public int mOutputTextureMode;
    public int mPreviewHeight;
    public int mPreviewWidth;
    public float mRed;

    @Override // com.baidu.ugc.editvideo.record.IMediaLifeCycle
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    @Override // com.baidu.ugc.editvideo.record.IMediaLifeCycleIncludeGlThread
    public void onResumeInGlThread() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    @Override // com.baidu.ugc.editvideo.record.processor.IEffectProcessor
    public void onSurfaceCreate(FullFrameRect fullFrameRect, FullFrameRect fullFrameRect2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, fullFrameRect, fullFrameRect2) == null) {
        }
    }

    public abstract void release();

    public abstract void releaseInGlThread();

    public BaseEffectProcessor() {
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
        this.mOutputTextureMode = 1;
        this.mRed = 0.0f;
        this.mGreen = 0.0f;
        this.mBlue = 0.0f;
        this.mAlpha = 0.0f;
    }

    @Override // com.baidu.ugc.editvideo.record.processor.IEffectProcessor
    public int getOutputTextureMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mOutputTextureMode;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.ugc.editvideo.record.IMediaLifeCycle
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            release();
        }
    }

    @Override // com.baidu.ugc.editvideo.record.IMediaLifeCycleIncludeGlThread
    public void onDestroyInGlThread() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            releaseInGlThread();
        }
    }

    @Override // com.baidu.ugc.editvideo.record.IMediaLifeCycle
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            release();
        }
    }

    @Override // com.baidu.ugc.editvideo.record.IMediaLifeCycleIncludeGlThread
    public void onPauseInGlThread() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            releaseInGlThread();
        }
    }

    @Override // com.baidu.ugc.editvideo.record.processor.IEffectProcessor
    public void setGlClearColor(float f, float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
            this.mRed = f;
            this.mGreen = f2;
            this.mBlue = f3;
            this.mAlpha = f4;
        }
    }

    @Override // com.baidu.ugc.editvideo.record.processor.IEffectProcessor
    public void setInputTextureMode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.mInputTextureMode = i;
        }
    }

    @Override // com.baidu.ugc.editvideo.record.processor.IEffectProcessor
    public void setPreviewSize(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048588, this, i, i2) == null) {
            this.mPreviewWidth = i;
            this.mPreviewHeight = i2;
        }
    }
}
