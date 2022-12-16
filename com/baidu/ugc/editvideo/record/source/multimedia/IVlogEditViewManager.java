package com.baidu.ugc.editvideo.record.source.multimedia;

import com.baidu.ugc.editvideo.data.MultiMediaData;
import java.nio.Buffer;
/* loaded from: classes7.dex */
public interface IVlogEditViewManager {
    void cancelStickerSelected();

    Buffer captureVideoCover(int i, long j, int i2, int i3);

    void deleteStickerData(MultiMediaData multiMediaData, String str);

    void moveBoundsCheckEnabled(boolean z);

    void setCurrentStickerData(int i, String str);

    void setStickerDeleteButton(String str, String str2);

    void setStickerEditButton(String str, String str2);

    void setStickerMaxScale(float f);

    void setStickerMinScale(float f);

    void setStickerRotationButton(String str, String str2);

    void setUpEditLayer(String str);
}
