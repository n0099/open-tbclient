package com.bytedance.sdk.openadsdk;

import android.app.Activity;
import android.os.Bundle;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.Map;
/* loaded from: classes7.dex */
public interface TTRewardVideoAd extends TTClientBidding {
    public static final String REWARD_EXTRA_KEY_ERROR_CODE = "reward_extra_key_error_code";
    public static final String REWARD_EXTRA_KEY_ERROR_MSG = "reward_extra_key_error_msg";
    public static final String REWARD_EXTRA_KEY_HAS_VIDEO_COMPLETE_REWARD = "reward_extra_key_has_video_complete_reward";
    public static final String REWARD_EXTRA_KEY_REWARD_AMOUNT = "reward_extra_key_reward_amount";
    public static final String REWARD_EXTRA_KEY_REWARD_NAME = "reward_extra_key_reward_name";
    public static final String REWARD_EXTRA_KEY_REWARD_PROPOSE = "reward_extra_key_reward_propose";
    public static final int REWARD_TYPE_DEFAULT = 0;
    public static final int REWARD_TYPE_INTERACT = 1;
    public static final int REWARD_TYPE_VIDEO_COMPLETE = 2;

    /* loaded from: classes7.dex */
    public interface RewardAdInteractionListener {
        void onAdClose();

        void onAdShow();

        void onAdVideoBarClick();

        void onRewardArrived(boolean z, int i, Bundle bundle);

        @Deprecated
        void onRewardVerify(boolean z, int i, String str, int i2, String str2);

        void onSkippedVideo();

        void onVideoComplete();

        void onVideoError();
    }

    long getExpirationTimestamp();

    int getInteractionType();

    Map getMediaExtraInfo();

    int getRewardVideoAdType();

    void setDownloadListener(TTAppDownloadListener tTAppDownloadListener);

    void setRewardAdInteractionListener(RewardAdInteractionListener rewardAdInteractionListener);

    void setRewardPlayAgainInteractionListener(RewardAdInteractionListener rewardAdInteractionListener);

    void setShowDownLoadBar(boolean z);

    void showRewardVideoAd(Activity activity);

    void showRewardVideoAd(Activity activity, TTAdConstant.RitScenes ritScenes, String str);
}
