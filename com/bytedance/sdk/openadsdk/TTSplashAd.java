package com.bytedance.sdk.openadsdk;

import android.view.View;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import java.util.Map;
/* loaded from: classes6.dex */
public interface TTSplashAd {

    /* loaded from: classes6.dex */
    public interface AdInteractionListener {
        void onAdClicked(View view, int i);

        void onAdShow(View view, int i);

        void onAdSkip();

        void onAdTimeOver();
    }

    int getInteractionType();

    Map<String, Object> getMediaExtraInfo();

    @NonNull
    View getSplashView();

    void renderExpressAd(TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener);

    void setDownloadListener(TTAppDownloadListener tTAppDownloadListener);

    void setNotAllowSdkCountdown();

    void setSplashInteractionListener(AdInteractionListener adInteractionListener);
}
