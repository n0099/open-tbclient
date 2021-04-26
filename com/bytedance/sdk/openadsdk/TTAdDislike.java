package com.bytedance.sdk.openadsdk;
/* loaded from: classes5.dex */
public interface TTAdDislike {

    /* loaded from: classes5.dex */
    public interface DislikeInteractionCallback {
        void onCancel();

        void onRefuse();

        void onSelected(int i2, String str);
    }

    void sendDislikeSource(String str);

    void setDislikeInteractionCallback(DislikeInteractionCallback dislikeInteractionCallback);

    void setIsInteractionAd();

    void showDislikeDialog();

    void showDislikeDialog(int i2);
}
