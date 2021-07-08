package com.bytedance.sdk.openadsdk;

import android.app.Activity;
import android.view.View;
import androidx.annotation.MainThread;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.multipro.b.a;
import java.util.Map;
/* loaded from: classes5.dex */
public interface TTNativeExpressAd {

    /* loaded from: classes5.dex */
    public interface AdInteractionListener extends ExpressAdInteractionListener {
        void onAdDismiss();
    }

    /* loaded from: classes5.dex */
    public interface ExpressAdInteractionListener {
        void onAdClicked(View view, int i2);

        void onAdShow(View view, int i2);

        void onRenderFail(View view, String str, int i2);

        void onRenderSuccess(View view, float f2, float f3);
    }

    /* loaded from: classes5.dex */
    public interface ExpressVideoAdListener {
        void onClickRetry();

        void onProgressUpdate(long j, long j2);

        void onVideoAdComplete();

        void onVideoAdContinuePlay();

        void onVideoAdPaused();

        void onVideoAdStartPlay();

        void onVideoError(int i2, int i3);

        void onVideoLoad();
    }

    void destroy();

    TTAdDislike getDislikeDialog(Activity activity);

    DislikeInfo getDislikeInfo();

    View getExpressAdView();

    int getImageMode();

    int getInteractionType();

    Map<String, Object> getMediaExtraInfo();

    a getVideoModel();

    void render();

    void setCanInterruptVideoPlay(boolean z);

    void setDislikeCallback(Activity activity, TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback);

    void setDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract);

    void setDownloadListener(TTAppDownloadListener tTAppDownloadListener);

    void setExpressInteractionListener(AdInteractionListener adInteractionListener);

    void setExpressInteractionListener(ExpressAdInteractionListener expressAdInteractionListener);

    void setSlideIntervalTime(int i2);

    void setVideoAdListener(ExpressVideoAdListener expressVideoAdListener);

    @MainThread
    void showInteractionExpressAd(Activity activity);
}
