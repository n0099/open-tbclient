package com.baidu.ugc.editvideo.record.source.multimedia;

import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import java.util.List;
/* loaded from: classes8.dex */
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

    void setCurrentStickerData(int i, String str);

    void setIMultiMediaDataSource(IMultiMediaDataSource iMultiMediaDataSource);

    void setStickerDeleteButton(String str, String str2);

    void setStickerEditButton(String str, String str2);

    void setStickerMaxScale(float f);

    void setStickerMinScale(float f);

    void setStickerRotationButton(String str, String str2);

    void setUpEditLayer(String str);

    void setVideoRatio(float f);
}
