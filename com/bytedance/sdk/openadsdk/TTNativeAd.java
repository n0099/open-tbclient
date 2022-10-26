package com.bytedance.sdk.openadsdk;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public interface TTNativeAd extends TTClientBidding {

    /* loaded from: classes7.dex */
    public interface AdInteractionListener {
        void onAdClicked(View view2, TTNativeAd tTNativeAd);

        void onAdCreativeClick(View view2, TTNativeAd tTNativeAd);

        void onAdShow(TTNativeAd tTNativeAd);
    }

    /* loaded from: classes7.dex */
    public interface ExpressRenderListener {
        void onRenderSuccess(View view2, float f, float f2, boolean z);
    }

    void destroy();

    Bitmap getAdLogo();

    View getAdView();

    int getAppCommentNum();

    int getAppScore();

    int getAppSize();

    String getButtonText();

    ComplianceInfo getComplianceInfo();

    String getDescription();

    TTAdDislike getDislikeDialog(Activity activity);

    TTAdDislike getDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract);

    DislikeInfo getDislikeInfo();

    DownloadStatusController getDownloadStatusController();

    TTImage getIcon();

    List getImageList();

    int getImageMode();

    int getInteractionType();

    Map getMediaExtraInfo();

    String getSource();

    String getTitle();

    TTImage getVideoCoverImage();

    void registerViewForInteraction(ViewGroup viewGroup, View view2, AdInteractionListener adInteractionListener);

    void registerViewForInteraction(ViewGroup viewGroup, List list, List list2, View view2, AdInteractionListener adInteractionListener);

    void registerViewForInteraction(ViewGroup viewGroup, List list, List list2, AdInteractionListener adInteractionListener);

    void registerViewForInteraction(ViewGroup viewGroup, List list, List list2, List list3, View view2, AdInteractionListener adInteractionListener);

    void registerViewForInteraction(ViewGroup viewGroup, List list, List list2, List list3, List list4, View view2, AdInteractionListener adInteractionListener);

    void render();

    void setActivityForDownloadApp(Activity activity);

    void setDislikeCallback(Activity activity, TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback);

    void setDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract);

    void setDownloadListener(TTAppDownloadListener tTAppDownloadListener);

    void setExpressRenderListener(ExpressRenderListener expressRenderListener);

    void showInteractionExpressAd(Activity activity);
}
