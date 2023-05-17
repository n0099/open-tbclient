package com.baidu.ugc.editvideo.data;

import com.baidu.minivideo.arface.bean.BeautyType;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrackConfig;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.ugc.bean.MusicData;
import com.baidu.ugc.editvideo.editvideo.data.MusicInfo;
import com.baidu.ugc.editvideo.filter.FilterValue;
import com.baidu.ugc.editvideo.magicmusic.VideoEffectData;
import com.baidu.ugc.editvideo.player.AudioPlayData;
import com.baidu.ugc.editvideo.player.AudioPlayTrackData;
import com.baidu.ugc.editvideo.record.transition.VideoFollowData;
import com.baidu.ugc.editvideo.subtitle.SubTitleConfig;
import com.baidu.ugc.editvideo.subtitle.SubTitleUnit;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public class VideoMuxerData implements Serializable {
    public List<AudioPlayData> audioPlayDataList;
    public String cachePath;
    public boolean isHfps;
    public boolean isKSongHuaTongMode;
    public Map<BeautyType, Object> mAREditBeautyMap;
    public Map<BeautyType, Object> mAREditBeautyMapForMale;
    public AREditSticker mAREditSticker;
    public List<AudioPlayTrackData> mAudioPlayTrackDataList;
    public boolean mCompat;
    public String mCoverColor;
    public String mCoverMode;
    public String mCoverTitle;
    public MediaTrackConfig mCurrThemeEffect;
    public boolean mCurrentEncodeHevcVideo;
    public String mDraftName;
    public boolean mEncodeHevcVideo;
    public int[] mFakeVoiceTypes;
    public String mFinalAudioPath;
    public ImageQualityData mImageQualityData;
    public boolean mIsUserNewAudioMixture;
    public String mKSongHuaTongRecordPath;
    public List<MultiMediaData> mMultiMediaDatas;
    public MusicData mMusicData;
    public MusicInfo mMusicInfo;
    public AudioPlayData mMuteAudioData;
    public String mMuxerFrom;
    public FilterValue mNewFilterValue;
    public int mOutBitRate;
    public int mOutHeight;
    public int mOutWidth;
    public int mPreviewHeight;
    public int mPreviewWidth;
    public String mRepairAudioPath;
    public List<MultiMediaData> mStickerDataList;
    public SubTitleConfig mSubTitleConfig;
    public List<SubTitleUnit> mSubTitleUnits;
    public VideoEffectData mVideoEffectData;
    public VideoFollowData mVideoFollowData;
    public String mVideoOutPath;
    public String mVideoPath;
    public int mVideoPattern;
    public float mVideoRatio;
    public String pagePreLoc;
    public String pagePreTab;
    public String pagePreTag;
    public String pageTab;
    public String pageTag;
    public boolean mComposeNecessary = true;
    public float mOriginMusicVolume = 1.0f;
    public int mVideoUploadType = -1;
    public boolean mIsDefaultBeauty = false;
    public boolean mIsDefaultMale = false;
    public int mFrameRate = 30;

    public Map<BeautyType, Object> getAREditBeautyMap() {
        return this.mAREditBeautyMap;
    }

    public Map<BeautyType, Object> getAREditBeautyMapForMale() {
        return this.mAREditBeautyMapForMale;
    }

    public AREditSticker getAREditSticker() {
        return this.mAREditSticker;
    }

    public List<AudioPlayData> getAudioPlayDataList() {
        return this.audioPlayDataList;
    }

    public List<AudioPlayTrackData> getAudioPlayTrackDataList() {
        return this.mAudioPlayTrackDataList;
    }

    public String getCachePath() {
        return this.cachePath;
    }

    public String getCoverColor() {
        return this.mCoverColor;
    }

    public String getCoverMode() {
        return this.mCoverMode;
    }

    public String getCoverTitle() {
        return this.mCoverTitle;
    }

    public MediaTrackConfig getCurrThemeEffect() {
        return this.mCurrThemeEffect;
    }

    public String getDraftName() {
        return this.mDraftName;
    }

    public int[] getFakeVoiceTypes() {
        return this.mFakeVoiceTypes;
    }

    public FilterValue getFilterValue() {
        return this.mNewFilterValue;
    }

    public String getFinalAudioPath() {
        return this.mFinalAudioPath;
    }

    public int getFrameRate() {
        return this.mFrameRate;
    }

    public ImageQualityData getImageQualityData() {
        return this.mImageQualityData;
    }

    public String getKSongHuaTongRecordPath() {
        return this.mKSongHuaTongRecordPath;
    }

    public String getLogType() {
        int i = this.mVideoUploadType;
        return i == 1 ? StatConstants.VALUE_TYPE_UPLOAD : i == 2 ? "shoot" : "unknown";
    }

    public MusicData getMusicData() {
        return this.mMusicData;
    }

    @Deprecated
    public MusicInfo getMusicInfo() {
        return this.mMusicInfo;
    }

    public AudioPlayData getMuteAudioData() {
        return this.mMuteAudioData;
    }

    public String getMuxerFrom() {
        return this.mMuxerFrom;
    }

    public float getOriginMusicVolume() {
        return this.mOriginMusicVolume;
    }

    public int getOutBitRate() {
        return this.mOutBitRate;
    }

    public int getOutHeight() {
        return this.mOutHeight;
    }

    public int getOutWidth() {
        return this.mOutWidth;
    }

    public String getPagePreLoc() {
        return this.pagePreLoc;
    }

    public String getPagePreTab() {
        return this.pagePreTab;
    }

    public String getPagePreTag() {
        return this.pagePreTag;
    }

    public String getPageTab() {
        return this.pageTab;
    }

    public String getPageTag() {
        return this.pageTag;
    }

    public List<MultiMediaData> getPhotoDataList() {
        return this.mMultiMediaDatas;
    }

    public int getPreviewHeight() {
        return this.mPreviewHeight;
    }

    public int getPreviewWidth() {
        return this.mPreviewWidth;
    }

    public String getRepairAudioPath() {
        return this.mRepairAudioPath;
    }

    public List<MultiMediaData> getStickerDataList() {
        return this.mStickerDataList;
    }

    public SubTitleConfig getSubTitleConfig() {
        return this.mSubTitleConfig;
    }

    public List<SubTitleUnit> getSubTitleUnits() {
        return this.mSubTitleUnits;
    }

    public VideoEffectData getVideoEffectData() {
        return this.mVideoEffectData;
    }

    public VideoFollowData getVideoFollowData() {
        return this.mVideoFollowData;
    }

    public String getVideoOutPath() {
        return this.mVideoOutPath;
    }

    public String getVideoPath() {
        return this.mVideoPath;
    }

    public int getVideoPattern() {
        return this.mVideoPattern;
    }

    public float getVideoRatio() {
        return this.mVideoRatio;
    }

    public int getVideoUploadType() {
        return this.mVideoUploadType;
    }

    public boolean isCompat() {
        return this.mCompat;
    }

    public boolean isComposeNecessary() {
        return this.mComposeNecessary;
    }

    public boolean isCurrentEncodeHevcVideo() {
        return this.mCurrentEncodeHevcVideo;
    }

    public boolean isDefaultBeauty() {
        return this.mIsDefaultBeauty;
    }

    public boolean isDefaultMale() {
        return this.mIsDefaultMale;
    }

    public boolean isHfps() {
        return this.isHfps;
    }

    public boolean isKSongHuaTongMode() {
        return this.isKSongHuaTongMode;
    }

    public boolean isRecordConfigEncodeHevcVideo() {
        return this.mEncodeHevcVideo;
    }

    public boolean isUserNewAudioMixture() {
        return this.mIsUserNewAudioMixture;
    }

    public void setAREditBeautyMap(Map<BeautyType, Object> map) {
        this.mAREditBeautyMap = map;
    }

    public void setAREditBeautyMapForMale(Map<BeautyType, Object> map) {
        this.mAREditBeautyMapForMale = map;
    }

    public void setAREditSticker(AREditSticker aREditSticker) {
        this.mAREditSticker = aREditSticker;
    }

    @Deprecated
    public void setAudioPlayDataList(List<AudioPlayData> list) {
        this.audioPlayDataList = list;
    }

    public void setAudioPlayTrackDataList(List<AudioPlayTrackData> list) {
        this.mAudioPlayTrackDataList = list;
    }

    public void setCachePath(String str) {
        this.cachePath = str;
    }

    public void setCompat(boolean z) {
        this.mCompat = z;
    }

    public void setComposeNecessary(boolean z) {
        this.mComposeNecessary = z;
    }

    public void setCoverColor(String str) {
        this.mCoverColor = str;
    }

    public void setCoverMode(String str) {
        this.mCoverMode = str;
    }

    public void setCoverTitle(String str) {
        this.mCoverTitle = str;
    }

    public void setCurrThemeEffect(MediaTrackConfig mediaTrackConfig) {
        this.mCurrThemeEffect = mediaTrackConfig;
    }

    public void setCurrentEncodeHevcVideo(boolean z) {
        this.mCurrentEncodeHevcVideo = z;
    }

    public void setDefaultBeauty(boolean z) {
        this.mIsDefaultBeauty = z;
    }

    public void setDefaultMale(boolean z) {
        this.mIsDefaultMale = z;
    }

    public void setDraftName(String str) {
        this.mDraftName = str;
    }

    public void setFakeVoiceTypes(int[] iArr) {
        this.mFakeVoiceTypes = iArr;
    }

    public void setFilterValue(FilterValue filterValue) {
        this.mNewFilterValue = filterValue;
    }

    public void setFinalAudioPath(String str) {
        this.mFinalAudioPath = str;
    }

    public void setFrameRate(int i) {
        this.mFrameRate = i;
    }

    public void setHfps(boolean z) {
        this.isHfps = z;
    }

    public void setImageQualityData(ImageQualityData imageQualityData) {
        this.mImageQualityData = imageQualityData;
    }

    public void setKSongHuaTongMode(boolean z) {
        this.isKSongHuaTongMode = z;
    }

    public void setKSongHuaTongRecordPath(String str) {
        this.mKSongHuaTongRecordPath = str;
    }

    public void setKSongRepairAudioPath(String str) {
        this.mRepairAudioPath = str;
    }

    public void setMusicData(MusicData musicData) {
        this.mMusicData = musicData;
    }

    @Deprecated
    public void setMusicInfo(MusicInfo musicInfo) {
        this.mMusicInfo = musicInfo;
    }

    public void setMuteAudioData(AudioPlayData audioPlayData) {
        this.mMuteAudioData = audioPlayData;
    }

    public void setMuxerFrom(String str) {
        this.mMuxerFrom = str;
    }

    public void setOriginMusicVolume(float f) {
        this.mOriginMusicVolume = f;
    }

    public void setOutBitRate(int i) {
        this.mOutBitRate = i;
    }

    public void setOutHeight(int i) {
        this.mOutHeight = i;
    }

    public void setOutWidth(int i) {
        this.mOutWidth = i;
    }

    public void setPagePreLoc(String str) {
        this.pagePreLoc = str;
    }

    public void setPagePreTab(String str) {
        this.pagePreTab = str;
    }

    public void setPagePreTag(String str) {
        this.pagePreTag = str;
    }

    public void setPageTab(String str) {
        this.pageTab = str;
    }

    public void setPageTag(String str) {
        this.pageTag = str;
    }

    public void setPhotoDataList(List<MultiMediaData> list) {
        this.mMultiMediaDatas = list;
    }

    public void setPreviewHeight(int i) {
        this.mPreviewHeight = i;
    }

    public void setPreviewWidth(int i) {
        this.mPreviewWidth = i;
    }

    public void setRecordConfigEncodeHevcVideo(boolean z) {
        this.mEncodeHevcVideo = z;
    }

    public void setStickerDataList(List<MultiMediaData> list) {
        this.mStickerDataList = list;
    }

    public void setSubTitleConfig(SubTitleConfig subTitleConfig) {
        this.mSubTitleConfig = subTitleConfig;
    }

    public void setSubTitleUnits(List<SubTitleUnit> list) {
        this.mSubTitleUnits = list;
    }

    public void setUserNewAudioMixture(boolean z) {
        this.mIsUserNewAudioMixture = z;
    }

    public void setVideoEffectData(VideoEffectData videoEffectData) {
        this.mVideoEffectData = videoEffectData;
    }

    public void setVideoFollowData(VideoFollowData videoFollowData) {
        this.mVideoFollowData = videoFollowData;
    }

    public void setVideoOutPath(String str) {
        this.mVideoOutPath = str;
    }

    public void setVideoPath(String str) {
        this.mVideoPath = str;
    }

    public void setVideoPattern(int i) {
        this.mVideoPattern = i;
    }

    public void setVideoRatio(float f) {
        this.mVideoRatio = f;
    }

    public void setVideoUploadType(int i) {
        this.mVideoUploadType = i;
    }
}
