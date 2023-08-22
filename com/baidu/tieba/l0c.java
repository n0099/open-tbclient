package com.baidu.tieba;

import com.yy.transvod.player.common.AlphaChannelData;
import com.yy.transvod.player.common.MixAudioExtraInfo;
import com.yy.transvod.player.common.MixVideoExtraInfo;
import com.yy.transvod.player.common.VideoExtraInfo;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public interface l0c {
    @Deprecated
    void onDSEMixAudioExtraInfoV1(e1c e1cVar, ArrayList<MixAudioExtraInfo> arrayList);

    void onSEIAlphaChannelInfo(e1c e1cVar, int i, ArrayList<AlphaChannelData> arrayList);

    @Deprecated
    void onSEIAudioExtraInfoV0(e1c e1cVar, ArrayList<Long> arrayList);

    void onSEIAudioOriginalData(e1c e1cVar, byte[] bArr, int i);

    void onSEIMixVideoExtraInfo(e1c e1cVar, int i, ArrayList<MixVideoExtraInfo> arrayList);

    void onSEIVideoExtraInfo(e1c e1cVar, int i, ArrayList<VideoExtraInfo> arrayList);

    void onSEIVideoOriginalData(e1c e1cVar, byte[] bArr, int i);
}
