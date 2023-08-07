package com.baidu.tieba;

import com.yy.transvod.player.common.AlphaChannelData;
import com.yy.transvod.player.common.MixAudioExtraInfo;
import com.yy.transvod.player.common.MixVideoExtraInfo;
import com.yy.transvod.player.common.VideoExtraInfo;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public interface vtb {
    @Deprecated
    void onDSEMixAudioExtraInfoV1(oub oubVar, ArrayList<MixAudioExtraInfo> arrayList);

    void onSEIAlphaChannelInfo(oub oubVar, int i, ArrayList<AlphaChannelData> arrayList);

    @Deprecated
    void onSEIAudioExtraInfoV0(oub oubVar, ArrayList<Long> arrayList);

    void onSEIAudioOriginalData(oub oubVar, byte[] bArr, int i);

    void onSEIMixVideoExtraInfo(oub oubVar, int i, ArrayList<MixVideoExtraInfo> arrayList);

    void onSEIVideoExtraInfo(oub oubVar, int i, ArrayList<VideoExtraInfo> arrayList);

    void onSEIVideoOriginalData(oub oubVar, byte[] bArr, int i);
}
