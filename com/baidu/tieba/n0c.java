package com.baidu.tieba;

import com.yy.transvod.player.common.AlphaChannelData;
import com.yy.transvod.player.common.MixAudioExtraInfo;
import com.yy.transvod.player.common.MixVideoExtraInfo;
import com.yy.transvod.player.common.VideoExtraInfo;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public interface n0c {
    @Deprecated
    void onDSEMixAudioExtraInfoV1(g1c g1cVar, ArrayList<MixAudioExtraInfo> arrayList);

    void onSEIAlphaChannelInfo(g1c g1cVar, int i, ArrayList<AlphaChannelData> arrayList);

    @Deprecated
    void onSEIAudioExtraInfoV0(g1c g1cVar, ArrayList<Long> arrayList);

    void onSEIAudioOriginalData(g1c g1cVar, byte[] bArr, int i);

    void onSEIMixVideoExtraInfo(g1c g1cVar, int i, ArrayList<MixVideoExtraInfo> arrayList);

    void onSEIVideoExtraInfo(g1c g1cVar, int i, ArrayList<VideoExtraInfo> arrayList);

    void onSEIVideoOriginalData(g1c g1cVar, byte[] bArr, int i);
}
