package com.baidu.ugc.editvideo.record.processor.glrender;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.dc9;
import com.baidu.tieba.yb9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import com.baidu.ugc.editvideo.data.MultiMediaDataTrack;
import com.baidu.ugc.editvideo.faceunity.gles.GlUtil;
import com.baidu.ugc.editvideo.record.processor.MultiMediaPreProcessor;
import com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource;
import com.baidu.ugc.editvideo.record.source.multimedia.OnDrawUpdateTextureListener;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class MultiMediaPreGlRenderer extends BaseGlRenderer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public IMultiMediaDataSource iMultiMediaDataSource;
    public MultiMediaPreProcessor mPreProcessor;
    public OnDrawUpdateTextureListener mUpdateTextureListener;

    public MultiMediaPreGlRenderer() {
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
        this.mPreProcessor = new MultiMediaPreProcessor();
    }

    public LinkedList<Runnable> getRunOnDrawList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.runOnProcess : (LinkedList) invokeV.objValue;
    }

    @Override // com.baidu.ugc.editvideo.record.processor.glrender.BaseGlRenderer, com.baidu.ugc.editvideo.record.processor.glrender.IGlRenderer
    public void initProgram() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.initProgram();
            IMultiMediaDataSource iMultiMediaDataSource = this.iMultiMediaDataSource;
            if (iMultiMediaDataSource != null) {
                iMultiMediaDataSource.releaseTextures();
                this.iMultiMediaDataSource.onInit();
            }
        }
    }

    public int onPreProcess(int i, long j) {
        InterceptResult invokeCommon;
        MultiMediaData multiMediaData;
        OnDrawUpdateTextureListener onDrawUpdateTextureListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)})) == null) {
            List<MultiMediaDataTrack> multiMediaDataTrack = this.iMultiMediaDataSource.getMultiMediaDataTrack();
            if ((!dc9.e(multiMediaDataTrack) && dc9.b(multiMediaDataTrack.get(0).multiMediaDataList) <= i) || (multiMediaData = (MultiMediaData) dc9.c(multiMediaDataTrack.get(0).multiMediaDataList, i)) == null || (onDrawUpdateTextureListener = this.mUpdateTextureListener) == null || onDrawUpdateTextureListener.getFullFrameRect2D() == null || this.mUpdateTextureListener.getFullFrameRectEXT() == null) {
                return -1;
            }
            MultiMediaPreProcessor multiMediaPreProcessor = this.mPreProcessor;
            if (multiMediaPreProcessor == null) {
                this.mUpdateTextureListener.setUpdateTexture(multiMediaData.textureId, multiMediaData.mtx, multiMediaData.textureMode);
                return multiMediaData.textureId;
            }
            multiMediaPreProcessor.initFrameBuffers(this.mOutWidth, this.mOutHeight);
            this.mPreProcessor.setShaderConfigMap(this.iMultiMediaDataSource.getShaderConfigMap());
            this.mPreProcessor.setUpdateMediaTracks(this.iMultiMediaDataSource.getUpdateMediaTracks());
            this.mPreProcessor.setMediaTrackConfig(this.iMultiMediaDataSource.getMediaTrackConfig());
            int preProcess = this.mPreProcessor.preProcess(multiMediaDataTrack, i, j, this.mUpdateTextureListener);
            this.mUpdateTextureListener.setUpdateTexture(preProcess, GlUtil.IDENTITY_MATRIX, multiMediaData.textureMode);
            return preProcess;
        }
        return invokeCommon.intValue;
    }

    @Override // com.baidu.ugc.editvideo.record.processor.glrender.BaseGlRenderer, com.baidu.ugc.editvideo.record.processor.glrender.IGlRenderer
    public void onPreProcess() {
        IMultiMediaDataSource iMultiMediaDataSource;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (iMultiMediaDataSource = this.iMultiMediaDataSource) == null || iMultiMediaDataSource.getMultiMediaDataTrack() == null || this.mUpdateTextureListener == null) {
            return;
        }
        super.onPreProcess();
        onPreProcess(this.iMultiMediaDataSource.getCurrentIndex(), this.iMultiMediaDataSource.getCurrentPlayTime());
    }

    @Override // com.baidu.ugc.editvideo.record.processor.glrender.BaseGlRenderer, com.baidu.ugc.editvideo.record.processor.glrender.IGlRenderer
    public void onSizeChange(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) {
            super.onSizeChange(i, i2);
            yb9.b("check ar size ：width = " + this.mOutWidth + " , height = " + this.mOutHeight);
            OnDrawUpdateTextureListener onDrawUpdateTextureListener = this.mUpdateTextureListener;
            if (onDrawUpdateTextureListener != null) {
                onDrawUpdateTextureListener.onSizeChange(i, i2);
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.processor.glrender.BaseGlRenderer, com.baidu.ugc.editvideo.record.processor.glrender.IGlRenderer
    public void releaseProgram() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            MultiMediaPreProcessor multiMediaPreProcessor = this.mPreProcessor;
            if (multiMediaPreProcessor != null) {
                multiMediaPreProcessor.destroyFramebuffers();
            }
            IMultiMediaDataSource iMultiMediaDataSource = this.iMultiMediaDataSource;
            if (iMultiMediaDataSource != null) {
                iMultiMediaDataSource.releaseTextures();
            }
        }
    }

    public void setCompat(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.mPreProcessor.setCompat(z);
        }
    }

    public void setMultiMediaDataSource(IMultiMediaDataSource iMultiMediaDataSource) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, iMultiMediaDataSource) == null) {
            this.iMultiMediaDataSource = iMultiMediaDataSource;
        }
    }

    public void setOnDrawUpdateTextureListener(OnDrawUpdateTextureListener onDrawUpdateTextureListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onDrawUpdateTextureListener) == null) {
            this.mUpdateTextureListener = onDrawUpdateTextureListener;
        }
    }

    public void setPreviewSize(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048585, this, i, i2) == null) {
            this.mPreProcessor.setPreviewSize(i, i2);
        }
    }
}
