package com.bytedance.sdk.openadsdk;

import android.app.Activity;
import android.view.View;
import androidx.annotation.MainThread;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.multipro.b.a;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public interface TTNativeExpressAd {

    /* loaded from: classes5.dex */
    public interface AdInteractionListener extends ExpressAdInteractionListener {
        void onAdDismiss();
    }

    /* loaded from: classes5.dex */
    public interface ExpressAdInteractionListener {
        void onAdClicked(View view, int i);

        void onAdShow(View view, int i);

        void onRenderFail(View view, String str, int i);

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

        void onVideoError(int i, int i2);

        void onVideoLoad();
    }

    void destroy();

    TTAdDislike getDislikeDialog(Activity activity);

    View getExpressAdView();

    List<FilterWord> getFilterWords();

    int getImageMode();

    int getInteractionType();

    Map<String, Object> getMediaExtraInfo();

    PersonalizationPrompt getPersonalizationPrompt();

    a getVideoModel();

    void render();

    void setCanInterruptVideoPlay(boolean z);

    void setDislikeCallback(Activity activity, TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback);

    void setDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract);

    void setDownloadListener(TTAppDownloadListener tTAppDownloadListener);

    void setExpressInteractionListener(AdInteractionListener adInteractionListener);

    void setExpressInteractionListener(ExpressAdInteractionListener expressAdInteractionListener);

    void setSlideIntervalTime(int i);

    void setVideoAdListener(ExpressVideoAdListener expressVideoAdListener);

    @MainThread
    void showInteractionExpressAd(Activity activity);
}
