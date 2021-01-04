package com.bytedance.sdk.openadsdk;
/* loaded from: classes4.dex */
public interface TTAdDislike {

    /* loaded from: classes4.dex */
    public interface DislikeInteractionCallback {
        void onCancel();

        void onRefuse();

        void onSelected(int i, String str);
    }

    void sendDislikeSource(String str);

    void setDislikeInteractionCallback(DislikeInteractionCallback dislikeInteractionCallback);

    void setIsInteractionAd();

    void showDislikeDialog();

    void showDislikeDialog(int i);
}
