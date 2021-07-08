package com.bytedance.sdk.openadsdk;

import android.app.Activity;
import androidx.annotation.MainThread;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.Map;
/* loaded from: classes5.dex */
public interface TTFullScreenVideoAd {

    /* loaded from: classes5.dex */
    public interface FullScreenVideoAdInteractionListener {
        void onAdClose();

        void onAdShow();

        void onAdVideoBarClick();

        void onSkippedVideo();

        void onVideoComplete();
    }

    int getFullVideoAdType();

    int getInteractionType();

    Map<String, Object> getMediaExtraInfo();

    void setDownloadListener(TTAppDownloadListener tTAppDownloadListener);

    void setFullScreenVideoAdInteractionListener(FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener);

    void setShowDownLoadBar(boolean z);

    @MainThread
    void showFullScreenVideoAd(Activity activity);

    void showFullScreenVideoAd(Activity activity, TTAdConstant.RitScenes ritScenes, String str);
}
