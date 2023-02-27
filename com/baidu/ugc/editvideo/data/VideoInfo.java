package com.baidu.ugc.editvideo.data;

import android.content.Intent;
import android.text.TextUtils;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tbadk.core.atomData.CloudMusicActivityConfig;
import java.io.File;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes7.dex */
public class VideoInfo implements Serializable {
    public static final String DRAFT_JSON_NAME = "new_video_info";
    public static final String KEY_VIDEO_DURATION = "video_l";
    public static final String KEY_VIDEO_HEIGHT = "video_h";
    public static final String KEY_VIDEO_PATH = "video";
    public static final String KEY_VIDEO_THUMB_PATH = "image";
    public static final String KEY_VIDEO_WIDTH = "video_w";
    public static final String VIDEO_CONTENT_PREFFIX = "#(movideo,";
    public static final int VIDEO_TYPE_RECORD = 12;
    public static final int VIDEO_TYPE_UPLOAD = 13;
    public static final long serialVersionUID = 4168698601975684150L;
    public boolean isCompressedVideo;
    public List<String> mBeautifyListInfo;
    public String mEffectTempPath;
    public List<String> mFilterEffectListInfo;
    public List<String> mFilterListInfo;
    public long mInStepVideoDuration;
    public String mInStepVideoPath;
    public String mJoinVideoTid;
    public List<String> mMaterialListInfo;
    public List<String> mMusicListInfo;
    public List<String> mParticleEffectListInfo;
    public List<String> mSpeedListInfo;
    public List<String> mStickListInfo;
    public List<String> mTimeEffectListInfo;
    public List<String> mTranEffectListInfo;
    public String mVideoTransPath1;
    public String mVideoTransPath2;
    public long thumbId;
    public String thumbPath;
    public int videoDuration;
    public int videoHeight;
    public long videoLength;
    public String videoMd5;
    public String videoPath;
    public int videoRecordType;
    public int videoType;
    public String videoUrl;
    public int videoWidth;
    public int mMaxRecordDuration = 15000;
    public boolean hasUserAudio = true;
    public boolean isRecordChoosedMusic = false;
    public String mOriginMusicId = "";
    public String mOriginMusicPath = "";

    public String buildBeautify() {
        return buildStaticsInfo("beautify_level", this.mBeautifyListInfo);
    }

    public String buildFilter() {
        return buildStaticsInfo("filter_id", this.mFilterListInfo);
    }

    public String buildFilterEffect() {
        return buildStaticsInfo("filter_effect", this.mFilterEffectListInfo);
    }

    public String buildMaterial() {
        return buildStaticsInfo("mMaterialId", this.mMaterialListInfo);
    }

    public String buildMusic() {
        return buildStaticsInfo(CloudMusicActivityConfig.MUSIC_ID, this.mMusicListInfo);
    }

    public String buildParticleEffect() {
        return buildStaticsInfo("magic_effect", this.mParticleEffectListInfo);
    }

    public String buildSpeedArray() {
        return buildStaticsInfo("speed_multiplier", this.mSpeedListInfo);
    }

    public String buildSticker() {
        return buildStaticsInfo("sticker_id", this.mStickListInfo);
    }

    public String buildTimeEffect() {
        return buildStaticsInfo("time_effect", this.mTimeEffectListInfo);
    }

    public String buildTransVideo() {
        return buildStaticsInfo("transVideo_id", this.mTranEffectListInfo);
    }

    public List<String> getBeautifyListInfo() {
        return this.mBeautifyListInfo;
    }

    public List<String> getFilterListInfo() {
        return this.mFilterListInfo;
    }

    public long getInStepVideoDuration() {
        return this.mInStepVideoDuration;
    }

    public String getInStepVideoPath() {
        return this.mInStepVideoPath;
    }

    public String getJoinVideoTid() {
        return this.mJoinVideoTid;
    }

    public List<String> getMaterialListInfo() {
        return this.mMaterialListInfo;
    }

    public int getMaxRecordDuration() {
        return this.mMaxRecordDuration;
    }

    public List<String> getMusicListInfo() {
        return this.mMusicListInfo;
    }

    public String getOriginalVideoPath() {
        return this.videoPath;
    }

    public List<String> getSpeedListInfo() {
        return this.mSpeedListInfo;
    }

    public List<String> getStickListInfo() {
        return this.mStickListInfo;
    }

    public long getThumbId() {
        return this.thumbId;
    }

    public String getThumbPath() {
        return this.thumbPath;
    }

    public List<String> getTranEffectListInfo() {
        return this.mTranEffectListInfo;
    }

    public int getVideoDuration() {
        return this.videoDuration;
    }

    public int getVideoHeight() {
        return this.videoHeight;
    }

    public long getVideoLength() {
        return this.videoLength;
    }

    public String getVideoMd5() {
        return this.videoMd5;
    }

    public String getVideoPath() {
        if (!TextUtils.isEmpty(this.mEffectTempPath)) {
            return this.mEffectTempPath;
        }
        return this.videoPath;
    }

    public int getVideoRecordType() {
        return this.videoRecordType;
    }

    public String getVideoTransPath1() {
        return this.mVideoTransPath1;
    }

    public String getVideoTransPath2() {
        return this.mVideoTransPath2;
    }

    public int getVideoType() {
        return this.videoType;
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public int getVideoWidth() {
        return this.videoWidth;
    }

    public boolean hasUpload() {
        if (TextUtils.isEmpty(this.videoUrl) || TextUtils.isEmpty(this.videoMd5)) {
            return false;
        }
        return true;
    }

    public boolean isAvaliable() {
        if (TextUtils.isEmpty(this.videoPath) || TextUtils.isEmpty(this.thumbPath) || this.videoHeight <= 0 || this.videoWidth <= 0 || !new File(this.videoPath).exists()) {
            return false;
        }
        return true;
    }

    public boolean isCompressedVideo() {
        return this.isCompressedVideo;
    }

    public boolean needUploadThunmb() {
        if (!TextUtils.isEmpty(this.thumbPath) && this.thumbId <= 0) {
            return true;
        }
        return false;
    }

    public boolean needUploadVideo() {
        if (TextUtils.isEmpty(this.videoUrl)) {
            return true;
        }
        return false;
    }

    public String replaceEffectTempPath2VideoPath() {
        if (TextUtils.isEmpty(this.mEffectTempPath)) {
            return "";
        }
        String str = this.videoPath;
        this.videoPath = this.mEffectTempPath;
        this.mEffectTempPath = null;
        return str;
    }

    public String buildContent() {
        return "#(movideo," + this.thumbId + "," + this.videoWidth + "," + this.videoHeight + "," + this.videoMd5 + "," + this.videoUrl + "," + this.videoDuration + "," + this.videoWidth + "," + this.videoHeight + "," + this.videoLength + "," + this.videoType + ",NO)";
    }

    public String buildStaticsInfo(String str, List<String> list) {
        if (list != null && list.size() != 0) {
            HashSet hashSet = new HashSet();
            StringBuilder sb = new StringBuilder();
            sb.append("\"" + str + "\":[");
            for (String str2 : list) {
                if (!hashSet.contains(str2)) {
                    sb.append("\"");
                    sb.append(str2);
                    sb.append("\"");
                    sb.append(",");
                    hashSet.add(str2);
                }
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append(PreferencesUtil.RIGHT_MOUNT);
            return sb.toString();
        }
        return null;
    }

    public void copy(VideoInfo videoInfo) {
        if (videoInfo == null) {
            return;
        }
        this.videoPath = videoInfo.videoPath;
        this.thumbPath = videoInfo.thumbPath;
        this.videoDuration = videoInfo.videoDuration;
        this.videoHeight = videoInfo.videoHeight;
        this.videoWidth = videoInfo.videoWidth;
        this.videoMd5 = videoInfo.videoMd5;
        this.videoUrl = videoInfo.videoUrl;
        this.thumbId = videoInfo.thumbId;
        this.videoLength = videoInfo.videoLength;
        this.videoType = videoInfo.videoType;
        this.mBeautifyListInfo = videoInfo.mBeautifyListInfo;
        this.mFilterListInfo = videoInfo.mFilterListInfo;
        this.mMusicListInfo = videoInfo.mMusicListInfo;
        this.mStickListInfo = videoInfo.mStickListInfo;
        this.hasUserAudio = videoInfo.hasUserAudio;
        this.mOriginMusicId = videoInfo.mOriginMusicId;
        this.mOriginMusicPath = videoInfo.mOriginMusicPath;
    }

    public void parseFromIntent(Intent intent) {
        if (intent == null) {
            return;
        }
        this.videoPath = intent.getStringExtra("video");
        this.thumbPath = intent.getStringExtra("image");
        this.videoDuration = (int) (intent.getLongExtra("video_l", 8000L) / 1000);
        this.videoHeight = intent.getIntExtra("video_h", 480);
        this.videoWidth = intent.getIntExtra("video_w", 480);
    }

    public void setBeautifyListInfo(List<String> list) {
        this.mBeautifyListInfo = list;
    }

    public void setEffectTempPath(String str) {
        this.mEffectTempPath = str;
    }

    public void setFilterEffectListInfo(List<String> list) {
        this.mFilterEffectListInfo = list;
    }

    public void setFilterListInfo(List<String> list) {
        this.mFilterListInfo = list;
    }

    public void setInStepVideoDuration(long j) {
        this.mInStepVideoDuration = j;
    }

    public void setInStepVideoPath(String str) {
        this.mInStepVideoPath = str;
    }

    public void setIsCompressedVideo(boolean z) {
        this.isCompressedVideo = z;
    }

    public void setJoinVideoTid(String str) {
        this.mJoinVideoTid = str;
    }

    public void setMaterialListInfo(List<String> list) {
        this.mMaterialListInfo = list;
    }

    public void setMaxRecordDuration(int i) {
        this.mMaxRecordDuration = i;
    }

    public void setMusicListInfo(List<String> list) {
        this.mMusicListInfo = list;
    }

    public void setParticleEffectListInfo(List<String> list) {
        this.mParticleEffectListInfo = list;
    }

    public void setSpeedListInfo(List<String> list) {
        this.mSpeedListInfo = list;
    }

    public void setStickListInfo(List<String> list) {
        this.mStickListInfo = list;
    }

    public void setThumbId(long j) {
        this.thumbId = j;
    }

    public void setThumbPath(String str) {
        this.thumbPath = str;
    }

    public void setTimeEffectListInfo(List<String> list) {
        this.mTimeEffectListInfo = list;
    }

    public void setTranEffectListInfo(List<String> list) {
        this.mTranEffectListInfo = list;
    }

    public void setVideoDuration(int i) {
        this.videoDuration = i;
    }

    public void setVideoHeight(int i) {
        this.videoHeight = i;
    }

    public void setVideoLength(long j) {
        this.videoLength = j;
    }

    public void setVideoMd5(String str) {
        this.videoMd5 = str;
    }

    public void setVideoPath(String str) {
        this.videoPath = str;
    }

    public void setVideoRecordType(int i) {
        this.videoRecordType = i;
    }

    public void setVideoTransPath1(String str) {
        this.mVideoTransPath1 = str;
    }

    public void setVideoTransPath2(String str) {
        this.mVideoTransPath2 = str;
    }

    public void setVideoType(int i) {
        this.videoType = i;
    }

    public void setVideoUrl(String str) {
        this.videoUrl = str;
    }

    public void setVideoWidth(int i) {
        this.videoWidth = i;
    }
}
