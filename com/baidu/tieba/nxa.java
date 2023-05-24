package com.baidu.tieba;

import com.fun.ad.sdk.internal.api.config.Ssp;
/* loaded from: classes6.dex */
public interface nxa {
    void onAdClicked(Ssp.Pid pid);

    void onAdClose(Ssp.Pid pid);

    void onAdLoad(Ssp.Pid pid);

    void onAdLoadError(Ssp.Pid pid, int i, String str);

    void onAdLoaded(Ssp.Pid pid);

    void onAdShow(Ssp.Pid pid);

    void onAdShowError(Ssp.Pid pid, int i, String str);

    void onRewardedVideo(Ssp.Pid pid, boolean z, int i);
}
