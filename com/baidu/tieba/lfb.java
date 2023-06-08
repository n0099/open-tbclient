package com.baidu.tieba;

import com.yy.transvod.player.common.AlphaChannelData;
import com.yy.transvod.player.common.MixAudioExtraInfo;
import com.yy.transvod.player.common.MixVideoExtraInfo;
import com.yy.transvod.player.common.VideoExtraInfo;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public interface lfb {
    @Deprecated
    void onDSEMixAudioExtraInfoV1(egb egbVar, ArrayList<MixAudioExtraInfo> arrayList);

    void onSEIAlphaChannelInfo(egb egbVar, int i, ArrayList<AlphaChannelData> arrayList);

    @Deprecated
    void onSEIAudioExtraInfoV0(egb egbVar, ArrayList<Long> arrayList);

    void onSEIAudioOriginalData(egb egbVar, byte[] bArr, int i);

    void onSEIMixVideoExtraInfo(egb egbVar, int i, ArrayList<MixVideoExtraInfo> arrayList);

    void onSEIVideoExtraInfo(egb egbVar, int i, ArrayList<VideoExtraInfo> arrayList);

    void onSEIVideoOriginalData(egb egbVar, byte[] bArr, int i);
}
