package com.bytedance.sdk.openadsdk;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public interface TTNativeAd {

    /* loaded from: classes5.dex */
    public interface AdInteractionListener {
        void onAdClicked(View view, TTNativeAd tTNativeAd);

        void onAdCreativeClick(View view, TTNativeAd tTNativeAd);

        void onAdShow(TTNativeAd tTNativeAd);
    }

    /* loaded from: classes5.dex */
    public interface ExpressRenderListener {
        void onRenderSuccess(View view, float f2, float f3, boolean z);
    }

    void destroy();

    Bitmap getAdLogo();

    View getAdView();

    int getAppCommentNum();

    int getAppScore();

    int getAppSize();

    String getButtonText();

    String getDescription();

    TTAdDislike getDislikeDialog(Activity activity);

    TTAdDislike getDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract);

    DownloadStatusController getDownloadStatusController();

    List<FilterWord> getFilterWords();

    TTImage getIcon();

    List<TTImage> getImageList();

    int getImageMode();

    int getInteractionType();

    Map<String, Object> getMediaExtraInfo();

    PersonalizationPrompt getPersonalizationPrompt();

    String getSource();

    String getTitle();

    @Nullable
    TTImage getVideoCoverImage();

    void registerViewForInteraction(@NonNull ViewGroup viewGroup, @NonNull View view, AdInteractionListener adInteractionListener);

    void registerViewForInteraction(@NonNull ViewGroup viewGroup, @NonNull List<View> list, @Nullable List<View> list2, @Nullable View view, AdInteractionListener adInteractionListener);

    void registerViewForInteraction(@NonNull ViewGroup viewGroup, @NonNull List<View> list, @Nullable List<View> list2, AdInteractionListener adInteractionListener);

    void registerViewForInteraction(@NonNull ViewGroup viewGroup, @NonNull List<View> list, @NonNull List<View> list2, @Nullable List<View> list3, @Nullable View view, AdInteractionListener adInteractionListener);

    void render();

    void setActivityForDownloadApp(@NonNull Activity activity);

    void setDislikeCallback(Activity activity, TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback);

    void setDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract);

    void setDownloadListener(TTAppDownloadListener tTAppDownloadListener);

    void setExpressRenderListener(ExpressRenderListener expressRenderListener);

    @MainThread
    void showInteractionExpressAd(Activity activity);
}
