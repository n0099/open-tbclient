package com.baidu.ugc.editvideo.record.source.multimedia;

import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import java.util.List;
/* loaded from: classes6.dex */
public interface IMultiMediaDataSourceView extends SurfaceTexture.OnFrameAvailableListener, GLSurfaceView.Renderer, IVLogLifeProtocol, OnMultiMediaCaptureCallback, OnPreRunnableTask {
    void addCoverStickerData(MultiMediaData multiMediaData);

    void addCoverStickerDataList(List<MultiMediaData> list);

    void cancelStickerSelected();

    void deleteCoverStickerData(MultiMediaData multiMediaData);

    void deleteStickerData(MultiMediaData multiMediaData, String str);

    List<MultiMediaData> getCoverStickerDataList();

    void moveBoundsCheckEnabled(boolean z);

    void notifyStickerDataChange(String str);

    void replaceCoverStickerData(MultiMediaData multiMediaData);

    void seek(long j);

    void setCurrentStickerData(int i2, String str);

    void setIMultiMediaDataSource(IMultiMediaDataSource iMultiMediaDataSource);

    void setStickerDeleteButton(String str, String str2);

    void setStickerEditButton(String str, String str2);

    void setStickerMaxScale(float f2);

    void setStickerMinScale(float f2);

    void setStickerRotationButton(String str, String str2);

    void setUpEditLayer(String str);

    void setVideoRatio(float f2);
}
