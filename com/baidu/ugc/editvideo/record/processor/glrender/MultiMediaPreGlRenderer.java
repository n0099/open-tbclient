package com.baidu.ugc.editvideo.record.processor.glrender;

import com.baidu.tieba.dha;
import com.baidu.tieba.iha;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import com.baidu.ugc.editvideo.data.MultiMediaDataTrack;
import com.baidu.ugc.editvideo.faceunity.gles.GlUtil;
import com.baidu.ugc.editvideo.record.processor.MultiMediaPreProcessor;
import com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource;
import com.baidu.ugc.editvideo.record.source.multimedia.OnDrawUpdateTextureListener;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes7.dex */
public class MultiMediaPreGlRenderer extends BaseGlRenderer {
    public IMultiMediaDataSource iMultiMediaDataSource;
    public MultiMediaPreProcessor mPreProcessor = new MultiMediaPreProcessor();
    public OnDrawUpdateTextureListener mUpdateTextureListener;

    public LinkedList<Runnable> getRunOnDrawList() {
        return this.runOnProcess;
    }

    @Override // com.baidu.ugc.editvideo.record.processor.glrender.BaseGlRenderer, com.baidu.ugc.editvideo.record.processor.glrender.IGlRenderer
    public void initProgram() {
        super.initProgram();
        IMultiMediaDataSource iMultiMediaDataSource = this.iMultiMediaDataSource;
        if (iMultiMediaDataSource != null) {
            iMultiMediaDataSource.releaseTextures();
            this.iMultiMediaDataSource.onInit();
        }
    }

    public int onPreProcess(int i, long j) {
        MultiMediaData multiMediaData;
        OnDrawUpdateTextureListener onDrawUpdateTextureListener;
        List<MultiMediaDataTrack> multiMediaDataTrack = this.iMultiMediaDataSource.getMultiMediaDataTrack();
        if ((!iha.e(multiMediaDataTrack) && iha.b(multiMediaDataTrack.get(0).multiMediaDataList) <= i) || (multiMediaData = (MultiMediaData) iha.c(multiMediaDataTrack.get(0).multiMediaDataList, i)) == null || (onDrawUpdateTextureListener = this.mUpdateTextureListener) == null || onDrawUpdateTextureListener.getFullFrameRect2D() == null || this.mUpdateTextureListener.getFullFrameRectEXT() == null) {
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

    @Override // com.baidu.ugc.editvideo.record.processor.glrender.BaseGlRenderer, com.baidu.ugc.editvideo.record.processor.glrender.IGlRenderer
    public void onPreProcess() {
        IMultiMediaDataSource iMultiMediaDataSource = this.iMultiMediaDataSource;
        if (iMultiMediaDataSource == null || iMultiMediaDataSource.getMultiMediaDataTrack() == null || this.mUpdateTextureListener == null) {
            return;
        }
        super.onPreProcess();
        onPreProcess(this.iMultiMediaDataSource.getCurrentIndex(), this.iMultiMediaDataSource.getCurrentPlayTime());
    }

    @Override // com.baidu.ugc.editvideo.record.processor.glrender.BaseGlRenderer, com.baidu.ugc.editvideo.record.processor.glrender.IGlRenderer
    public void onSizeChange(int i, int i2) {
        super.onSizeChange(i, i2);
        dha.b("check ar size ：width = " + this.mOutWidth + " , height = " + this.mOutHeight);
        OnDrawUpdateTextureListener onDrawUpdateTextureListener = this.mUpdateTextureListener;
        if (onDrawUpdateTextureListener != null) {
            onDrawUpdateTextureListener.onSizeChange(i, i2);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.processor.glrender.BaseGlRenderer, com.baidu.ugc.editvideo.record.processor.glrender.IGlRenderer
    public void releaseProgram() {
        MultiMediaPreProcessor multiMediaPreProcessor = this.mPreProcessor;
        if (multiMediaPreProcessor != null) {
            multiMediaPreProcessor.destroyFramebuffers();
        }
        IMultiMediaDataSource iMultiMediaDataSource = this.iMultiMediaDataSource;
        if (iMultiMediaDataSource != null) {
            iMultiMediaDataSource.releaseTextures();
        }
    }

    public void setCompat(boolean z) {
        this.mPreProcessor.setCompat(z);
    }

    public void setMultiMediaDataSource(IMultiMediaDataSource iMultiMediaDataSource) {
        this.iMultiMediaDataSource = iMultiMediaDataSource;
    }

    public void setOnDrawUpdateTextureListener(OnDrawUpdateTextureListener onDrawUpdateTextureListener) {
        this.mUpdateTextureListener = onDrawUpdateTextureListener;
    }

    public void setPreviewSize(int i, int i2) {
        this.mPreProcessor.setPreviewSize(i, i2);
    }
}
