package com.bytedance.sdk.openadsdk;

import android.app.Activity;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.Map;
/* loaded from: classes4.dex */
public interface TTFullScreenVideoAd {

    /* loaded from: classes4.dex */
    public interface FullScreenVideoAdInteractionListener {
        void onAdClose();

        void onAdShow();

        void onAdVideoBarClick();

        void onSkippedVideo();

        void onVideoComplete();
    }

    long getExpirationTimestamp();

    int getFullVideoAdType();

    int getInteractionType();

    Map<String, Object> getMediaExtraInfo();

    void setDownloadListener(TTAppDownloadListener tTAppDownloadListener);

    void setFullScreenVideoAdInteractionListener(FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener);

    void setShowDownLoadBar(boolean z);

    void showFullScreenVideoAd(Activity activity);

    void showFullScreenVideoAd(Activity activity, TTAdConstant.RitScenes ritScenes, String str);
}
