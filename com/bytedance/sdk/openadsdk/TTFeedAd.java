package com.bytedance.sdk.openadsdk;
/* loaded from: classes9.dex */
public interface TTFeedAd extends TTNativeAd {

    /* loaded from: classes9.dex */
    public interface CustomizeVideo {
        String getVideoUrl();

        void reportVideoAutoStart();

        void reportVideoBreak(long j2);

        void reportVideoContinue(long j2);

        void reportVideoError(long j2, int i2, int i3);

        void reportVideoFinish();

        void reportVideoPause(long j2);

        void reportVideoStart();

        void reportVideoStartError(int i2, int i3);
    }

    /* loaded from: classes9.dex */
    public interface VideoAdListener {
        void onProgressUpdate(long j2, long j3);

        void onVideoAdComplete(TTFeedAd tTFeedAd);

        void onVideoAdContinuePlay(TTFeedAd tTFeedAd);

        void onVideoAdPaused(TTFeedAd tTFeedAd);

        void onVideoAdStartPlay(TTFeedAd tTFeedAd);

        void onVideoError(int i2, int i3);

        void onVideoLoad(TTFeedAd tTFeedAd);
    }

    int getAdViewHeight();

    int getAdViewWidth();

    CustomizeVideo getCustomVideo();

    double getVideoDuration();

    void setVideoAdListener(VideoAdListener videoAdListener);
}
