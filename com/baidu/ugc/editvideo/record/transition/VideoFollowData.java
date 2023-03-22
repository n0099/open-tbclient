package com.baidu.ugc.editvideo.record.transition;

import android.text.TextUtils;
import com.baidu.tieba.y4a;
import java.io.Serializable;
/* loaded from: classes7.dex */
public class VideoFollowData implements Serializable {
    public static final int AUDIO_TYPE_FOLLOW = 0;
    public static final int AUDIO_TYPE_MIX = 2;
    public static final int AUDIO_TYPE_RECORD = 1;
    public static final String FOLLOW_TYPE_BIG_SMALL = "1";
    public static final String FOLLOW_TYPE_LEFT_RIGHT = "0";
    public static final String FOLLOW_TYPE_SAME_STYLE = "2";
    public static final int PREVIEW_SCALE_TYPE_CENTER_CROP = 0;
    public static final int PREVIEW_SCALE_TYPE_CENTER_INSIDE = 1;
    public static final int VIDEO_HORIZONTAL_MODE = 1;
    public static final int VIDEO_VERTICAL_MODE = 0;
    public int mAudioType;
    public String mFollowMusicId;
    public String mFollowRecordAudioPath;
    public String mFollowRecordVideoPath;
    public String mFollowType;
    public String mFollowVid;
    public boolean mNeedSmallWindowWhiteEdge = true;
    public int mOritation;
    public int mPreviewScaleType;
    public int mPreviewSmallWindowHeight;
    public int mPreviewSmallWindowWidth;
    public int mPreviewSmallWindowX;
    public int mPreviewSmallWindowY;
    public int mRecordSmallWindowHeight;
    public int mRecordSmallWindowWidth;
    public int mRecordSmallWindowX;
    public int mRecordSmallWindowY;
    public String mRecordVideoPath;

    public int getAudioType() {
        return this.mAudioType;
    }

    public String getFollowMusicId() {
        return this.mFollowMusicId;
    }

    public String getFollowRecordAudioPath() {
        return this.mFollowRecordAudioPath;
    }

    public String getFollowRecordVideoPath() {
        return this.mFollowRecordVideoPath;
    }

    public String getFollowType() {
        return this.mFollowType;
    }

    public String getFollowVid() {
        return this.mFollowVid;
    }

    public int getOritation() {
        return this.mOritation;
    }

    public int getPreviewScaleType() {
        return this.mPreviewScaleType;
    }

    public String getRecordVideoPath() {
        return this.mRecordVideoPath;
    }

    public boolean isNeedSmallWindowWhiteEdge() {
        return this.mNeedSmallWindowWhiteEdge;
    }

    public static boolean isBigSmallFollowType(String str) {
        return TextUtils.equals("1", str);
    }

    public static boolean isFollowType(String str) {
        if (!isBigSmallFollowType(str) && !isLeftRightFollowType(str) && !isSameStyleFollowType(str)) {
            return false;
        }
        return true;
    }

    public static boolean isLeftRightFollowType(String str) {
        return TextUtils.equals("0", str);
    }

    public static boolean isSameStyleFollowType(String str) {
        return TextUtils.equals("2", str);
    }

    public static VideoFollowData parse(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return (VideoFollowData) new y4a().b(str, VideoFollowData.class);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String toJson(VideoFollowData videoFollowData) {
        if (videoFollowData == null) {
            return null;
        }
        try {
            return new y4a().a(videoFollowData);
        } catch (Exception unused) {
            return null;
        }
    }

    public void setAudioType(int i) {
        this.mAudioType = i;
    }

    public void setFollowMusicId(String str) {
        this.mFollowMusicId = str;
    }

    public void setFollowRecordAudioPath(String str) {
        this.mFollowRecordAudioPath = str;
    }

    public void setFollowRecordVideoPath(String str) {
        this.mFollowRecordVideoPath = str;
    }

    public void setFollowType(String str) {
        this.mFollowType = str;
    }

    public void setFollowVid(String str) {
        this.mFollowVid = str;
    }

    public void setNeedSmallWindowWhiteEdge(boolean z) {
        this.mNeedSmallWindowWhiteEdge = z;
    }

    public void setOritation(int i) {
        this.mOritation = i;
    }

    public void setPreviewScaleType(int i) {
        this.mPreviewScaleType = i;
    }

    public void setRecordVideoPath(String str) {
        this.mRecordVideoPath = str;
    }
}
