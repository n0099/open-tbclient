package com.baidu.ugc.editvideo.sticker;

import com.baidu.ugc.editvideo.data.MultiMediaData;
/* loaded from: classes8.dex */
public interface OnChangeStickerListener {
    void onAutoAdjust(String str);

    void onChangeSticker(int i2, MultiMediaData multiMediaData, String str);

    void onClickSticker(MultiMediaData multiMediaData, String str, boolean z);

    void onClickStickerOutside(String str);

    void onDeleteSticker(MultiMediaData multiMediaData, int i2, String str, boolean z);

    void onEditSticker(MultiMediaData multiMediaData, String str);

    void onStickerDataChanged(String str, MultiMediaData multiMediaData, String str2);
}
