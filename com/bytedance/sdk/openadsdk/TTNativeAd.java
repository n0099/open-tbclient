package com.bytedance.sdk.openadsdk;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public interface TTNativeAd {

    /* loaded from: classes4.dex */
    public interface AdInteractionListener {
        void onAdClicked(View view, TTNativeAd tTNativeAd);

        void onAdCreativeClick(View view, TTNativeAd tTNativeAd);

        void onAdShow(TTNativeAd tTNativeAd);
    }

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

    String getSource();

    String getTitle();

    @Nullable
    TTImage getVideoCoverImage();

    void registerViewForInteraction(@NonNull ViewGroup viewGroup, @NonNull View view, AdInteractionListener adInteractionListener);

    void registerViewForInteraction(@NonNull ViewGroup viewGroup, @NonNull List<View> list, @Nullable List<View> list2, @Nullable View view, AdInteractionListener adInteractionListener);

    void registerViewForInteraction(@NonNull ViewGroup viewGroup, @NonNull List<View> list, @Nullable List<View> list2, AdInteractionListener adInteractionListener);

    void registerViewForInteraction(@NonNull ViewGroup viewGroup, @NonNull List<View> list, @NonNull List<View> list2, @Nullable List<View> list3, @Nullable View view, AdInteractionListener adInteractionListener);

    void setActivityForDownloadApp(@NonNull Activity activity);

    void setDownloadListener(TTAppDownloadListener tTAppDownloadListener);
}
