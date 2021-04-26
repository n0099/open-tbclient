package com.bytedance.sdk.openadsdk;

import android.view.View;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import java.util.Map;
/* loaded from: classes5.dex */
public interface TTBannerAd {

    /* loaded from: classes5.dex */
    public interface AdInteractionListener {
        void onAdClicked(View view, int i2);

        void onAdShow(View view, int i2);
    }

    View getBannerView();

    TTAdDislike getDislikeDialog(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback);

    int getInteractionType();

    Map<String, Object> getMediaExtraInfo();

    void setBannerInteractionListener(AdInteractionListener adInteractionListener);

    void setDownloadListener(TTAppDownloadListener tTAppDownloadListener);

    void setShowDislikeIcon(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback);

    void setSlideIntervalTime(int i2);
}
