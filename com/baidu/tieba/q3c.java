package com.baidu.tieba;

import com.yy.transvod.player.common.AlphaChannelData;
import com.yy.transvod.player.common.MixAudioExtraInfo;
import com.yy.transvod.player.common.MixVideoExtraInfo;
import com.yy.transvod.player.common.VideoExtraInfo;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public interface q3c {
    @Deprecated
    void onDSEMixAudioExtraInfoV1(j4c j4cVar, ArrayList<MixAudioExtraInfo> arrayList);

    void onSEIAlphaChannelInfo(j4c j4cVar, int i, ArrayList<AlphaChannelData> arrayList);

    @Deprecated
    void onSEIAudioExtraInfoV0(j4c j4cVar, ArrayList<Long> arrayList);

    void onSEIAudioOriginalData(j4c j4cVar, byte[] bArr, int i);

    void onSEIMixVideoExtraInfo(j4c j4cVar, int i, ArrayList<MixVideoExtraInfo> arrayList);

    void onSEIVideoExtraInfo(j4c j4cVar, int i, ArrayList<VideoExtraInfo> arrayList);

    void onSEIVideoOriginalData(j4c j4cVar, byte[] bArr, int i);
}
