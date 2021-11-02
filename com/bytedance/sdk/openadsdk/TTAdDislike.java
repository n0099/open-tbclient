package com.bytedance.sdk.openadsdk;
/* loaded from: classes11.dex */
public interface TTAdDislike {

    /* loaded from: classes11.dex */
    public interface DislikeInteractionCallback {
        void onCancel();

        void onSelected(int i2, String str, boolean z);

        void onShow();
    }

    boolean isShow();

    void resetDislikeStatus();

    void setDislikeInteractionCallback(DislikeInteractionCallback dislikeInteractionCallback);

    void setDislikeSource(String str);

    void showDislikeDialog();
}
