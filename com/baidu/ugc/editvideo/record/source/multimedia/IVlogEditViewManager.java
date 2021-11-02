package com.baidu.ugc.editvideo.record.source.multimedia;

import com.baidu.ugc.editvideo.data.MultiMediaData;
import java.nio.Buffer;
/* loaded from: classes10.dex */
public interface IVlogEditViewManager {
    void cancelStickerSelected();

    Buffer captureVideoCover(int i2, long j, int i3, int i4);

    void deleteStickerData(MultiMediaData multiMediaData, String str);

    void moveBoundsCheckEnabled(boolean z);

    void setCurrentStickerData(int i2, String str);

    void setStickerDeleteButton(String str, String str2);

    void setStickerEditButton(String str, String str2);

    void setStickerMaxScale(float f2);

    void setStickerMinScale(float f2);

    void setStickerRotationButton(String str, String str2);

    void setUpEditLayer(String str);
}
