package com.baidu.ugc.editvideo.data;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.arface.bean.BeautyType;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrackConfig;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes7.dex */
public class VideoMuxerData implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<AudioPlayData> audioPlayDataList;
    public String cachePath;
    public boolean isHfps;
    public boolean isKSongHuaTongMode;
    public Map<BeautyType, Object> mAREditBeautyMap;
    public Map<BeautyType, Object> mAREditBeautyMapForMale;
    public AREditSticker mAREditSticker;
    public List<AudioPlayTrackData> mAudioPlayTrackDataList;
    public boolean mCompat;
    public boolean mComposeNecessary;
    public String mCoverColor;
    public String mCoverMode;
    public String mCoverTitle;
    public MediaTrackConfig mCurrThemeEffect;
    public boolean mCurrentEncodeHevcVideo;
    public String mDraftName;
    public boolean mEncodeHevcVideo;
    public int[] mFakeVoiceTypes;
    public String mFinalAudioPath;
    public int mFrameRate;
    public ImageQualityData mImageQualityData;
    public boolean mIsDefaultBeauty;
    public boolean mIsDefaultMale;
    public boolean mIsUserNewAudioMixture;
    public String mKSongHuaTongRecordPath;
    public List<MultiMediaData> mMultiMediaDatas;
    public MusicData mMusicData;
    public MusicInfo mMusicInfo;
    public AudioPlayData mMuteAudioData;
    public String mMuxerFrom;
    public FilterValue mNewFilterValue;
    public float mOriginMusicVolume;
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
    public int mVideoUploadType;
    public String pagePreLoc;
    public String pagePreTab;
    public String pagePreTag;
    public String pageTab;
    public String pageTag;

    public VideoMuxerData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mComposeNecessary = true;
        this.mOriginMusicVolume = 1.0f;
        this.mVideoUploadType = -1;
        this.mIsDefaultBeauty = false;
        this.mIsDefaultMale = false;
        this.mFrameRate = 30;
    }

    public Map<BeautyType, Object> getAREditBeautyMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mAREditBeautyMap : (Map) invokeV.objValue;
    }

    public Map<BeautyType, Object> getAREditBeautyMapForMale() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mAREditBeautyMapForMale : (Map) invokeV.objValue;
    }

    public AREditSticker getAREditSticker() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mAREditSticker : (AREditSticker) invokeV.objValue;
    }

    public List<AudioPlayData> getAudioPlayDataList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.audioPlayDataList : (List) invokeV.objValue;
    }

    public List<AudioPlayTrackData> getAudioPlayTrackDataList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mAudioPlayTrackDataList : (List) invokeV.objValue;
    }

    public String getCachePath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.cachePath : (String) invokeV.objValue;
    }

    public String getCoverColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mCoverColor : (String) invokeV.objValue;
    }

    public String getCoverMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mCoverMode : (String) invokeV.objValue;
    }

    public String getCoverTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mCoverTitle : (String) invokeV.objValue;
    }

    public MediaTrackConfig getCurrThemeEffect() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mCurrThemeEffect : (MediaTrackConfig) invokeV.objValue;
    }

    public String getDraftName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mDraftName : (String) invokeV.objValue;
    }

    public int[] getFakeVoiceTypes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mFakeVoiceTypes : (int[]) invokeV.objValue;
    }

    public FilterValue getFilterValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mNewFilterValue : (FilterValue) invokeV.objValue;
    }

    public String getFinalAudioPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mFinalAudioPath : (String) invokeV.objValue;
    }

    public int getFrameRate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mFrameRate : invokeV.intValue;
    }

    public ImageQualityData getImageQualityData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.mImageQualityData : (ImageQualityData) invokeV.objValue;
    }

    public String getKSongHuaTongRecordPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.mKSongHuaTongRecordPath : (String) invokeV.objValue;
    }

    public String getLogType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            int i = this.mVideoUploadType;
            return i == 1 ? StatConstants.VALUE_TYPE_UPLOAD : i == 2 ? "shoot" : "unknown";
        }
        return (String) invokeV.objValue;
    }

    public MusicData getMusicData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.mMusicData : (MusicData) invokeV.objValue;
    }

    @Deprecated
    public MusicInfo getMusicInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.mMusicInfo : (MusicInfo) invokeV.objValue;
    }

    public AudioPlayData getMuteAudioData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.mMuteAudioData : (AudioPlayData) invokeV.objValue;
    }

    public String getMuxerFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.mMuxerFrom : (String) invokeV.objValue;
    }

    public float getOriginMusicVolume() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.mOriginMusicVolume : invokeV.floatValue;
    }

    public int getOutBitRate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.mOutBitRate : invokeV.intValue;
    }

    public int getOutHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.mOutHeight : invokeV.intValue;
    }

    public int getOutWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.mOutWidth : invokeV.intValue;
    }

    public String getPagePreLoc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.pagePreLoc : (String) invokeV.objValue;
    }

    public String getPagePreTab() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.pagePreTab : (String) invokeV.objValue;
    }

    public String getPagePreTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.pagePreTag : (String) invokeV.objValue;
    }

    public String getPageTab() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.pageTab : (String) invokeV.objValue;
    }

    public String getPageTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.pageTag : (String) invokeV.objValue;
    }

    public List<MultiMediaData> getPhotoDataList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.mMultiMediaDatas : (List) invokeV.objValue;
    }

    public int getPreviewHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.mPreviewHeight : invokeV.intValue;
    }

    public int getPreviewWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.mPreviewWidth : invokeV.intValue;
    }

    public String getRepairAudioPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.mRepairAudioPath : (String) invokeV.objValue;
    }

    public List<MultiMediaData> getStickerDataList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.mStickerDataList : (List) invokeV.objValue;
    }

    public SubTitleConfig getSubTitleConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.mSubTitleConfig : (SubTitleConfig) invokeV.objValue;
    }

    public List<SubTitleUnit> getSubTitleUnits() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.mSubTitleUnits : (List) invokeV.objValue;
    }

    public VideoEffectData getVideoEffectData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.mVideoEffectData : (VideoEffectData) invokeV.objValue;
    }

    public VideoFollowData getVideoFollowData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.mVideoFollowData : (VideoFollowData) invokeV.objValue;
    }

    public String getVideoOutPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.mVideoOutPath : (String) invokeV.objValue;
    }

    public String getVideoPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.mVideoPath : (String) invokeV.objValue;
    }

    public int getVideoPattern() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.mVideoPattern : invokeV.intValue;
    }

    public float getVideoRatio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.mVideoRatio : invokeV.floatValue;
    }

    public int getVideoUploadType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.mVideoUploadType : invokeV.intValue;
    }

    public boolean isCompat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.mCompat : invokeV.booleanValue;
    }

    public boolean isComposeNecessary() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.mComposeNecessary : invokeV.booleanValue;
    }

    public boolean isCurrentEncodeHevcVideo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.mCurrentEncodeHevcVideo : invokeV.booleanValue;
    }

    public boolean isDefaultBeauty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.mIsDefaultBeauty : invokeV.booleanValue;
    }

    public boolean isDefaultMale() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.mIsDefaultMale : invokeV.booleanValue;
    }

    public boolean isHfps() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? this.isHfps : invokeV.booleanValue;
    }

    public boolean isKSongHuaTongMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.isKSongHuaTongMode : invokeV.booleanValue;
    }

    public boolean isRecordConfigEncodeHevcVideo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.mEncodeHevcVideo : invokeV.booleanValue;
    }

    public boolean isUserNewAudioMixture() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? this.mIsUserNewAudioMixture : invokeV.booleanValue;
    }

    public void setAREditBeautyMap(Map<BeautyType, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, map) == null) {
            this.mAREditBeautyMap = map;
        }
    }

    public void setAREditBeautyMapForMale(Map<BeautyType, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, map) == null) {
            this.mAREditBeautyMapForMale = map;
        }
    }

    public void setAREditSticker(AREditSticker aREditSticker) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, aREditSticker) == null) {
            this.mAREditSticker = aREditSticker;
        }
    }

    @Deprecated
    public void setAudioPlayDataList(List<AudioPlayData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, list) == null) {
            this.audioPlayDataList = list;
        }
    }

    public void setAudioPlayTrackDataList(List<AudioPlayTrackData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, list) == null) {
            this.mAudioPlayTrackDataList = list;
        }
    }

    public void setCachePath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, str) == null) {
            this.cachePath = str;
        }
    }

    public void setCompat(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048636, this, z) == null) {
            this.mCompat = z;
        }
    }

    public void setComposeNecessary(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048637, this, z) == null) {
            this.mComposeNecessary = z;
        }
    }

    public void setCoverColor(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, str) == null) {
            this.mCoverColor = str;
        }
    }

    public void setCoverMode(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, str) == null) {
            this.mCoverMode = str;
        }
    }

    public void setCoverTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, str) == null) {
            this.mCoverTitle = str;
        }
    }

    public void setCurrThemeEffect(MediaTrackConfig mediaTrackConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, mediaTrackConfig) == null) {
            this.mCurrThemeEffect = mediaTrackConfig;
        }
    }

    public void setCurrentEncodeHevcVideo(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048642, this, z) == null) {
            this.mCurrentEncodeHevcVideo = z;
        }
    }

    public void setDefaultBeauty(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048643, this, z) == null) {
            this.mIsDefaultBeauty = z;
        }
    }

    public void setDefaultMale(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048644, this, z) == null) {
            this.mIsDefaultMale = z;
        }
    }

    public void setDraftName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048645, this, str) == null) {
            this.mDraftName = str;
        }
    }

    public void setFakeVoiceTypes(int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, iArr) == null) {
            this.mFakeVoiceTypes = iArr;
        }
    }

    public void setFilterValue(FilterValue filterValue) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048647, this, filterValue) == null) {
            this.mNewFilterValue = filterValue;
        }
    }

    public void setFinalAudioPath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048648, this, str) == null) {
            this.mFinalAudioPath = str;
        }
    }

    public void setFrameRate(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048649, this, i) == null) {
            this.mFrameRate = i;
        }
    }

    public void setHfps(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048650, this, z) == null) {
            this.isHfps = z;
        }
    }

    public void setImageQualityData(ImageQualityData imageQualityData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048651, this, imageQualityData) == null) {
            this.mImageQualityData = imageQualityData;
        }
    }

    public void setKSongHuaTongMode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048652, this, z) == null) {
            this.isKSongHuaTongMode = z;
        }
    }

    public void setKSongHuaTongRecordPath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048653, this, str) == null) {
            this.mKSongHuaTongRecordPath = str;
        }
    }

    public void setKSongRepairAudioPath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048654, this, str) == null) {
            this.mRepairAudioPath = str;
        }
    }

    public void setMusicData(MusicData musicData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048655, this, musicData) == null) {
            this.mMusicData = musicData;
        }
    }

    @Deprecated
    public void setMusicInfo(MusicInfo musicInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048656, this, musicInfo) == null) {
            this.mMusicInfo = musicInfo;
        }
    }

    public void setMuteAudioData(AudioPlayData audioPlayData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048657, this, audioPlayData) == null) {
            this.mMuteAudioData = audioPlayData;
        }
    }

    public void setMuxerFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048658, this, str) == null) {
            this.mMuxerFrom = str;
        }
    }

    public void setOriginMusicVolume(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048659, this, f) == null) {
            this.mOriginMusicVolume = f;
        }
    }

    public void setOutBitRate(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048660, this, i) == null) {
            this.mOutBitRate = i;
        }
    }

    public void setOutHeight(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048661, this, i) == null) {
            this.mOutHeight = i;
        }
    }

    public void setOutWidth(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048662, this, i) == null) {
            this.mOutWidth = i;
        }
    }

    public void setPagePreLoc(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048663, this, str) == null) {
            this.pagePreLoc = str;
        }
    }

    public void setPagePreTab(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048664, this, str) == null) {
            this.pagePreTab = str;
        }
    }

    public void setPagePreTag(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048665, this, str) == null) {
            this.pagePreTag = str;
        }
    }

    public void setPageTab(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048666, this, str) == null) {
            this.pageTab = str;
        }
    }

    public void setPageTag(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048667, this, str) == null) {
            this.pageTag = str;
        }
    }

    public void setPhotoDataList(List<MultiMediaData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048668, this, list) == null) {
            this.mMultiMediaDatas = list;
        }
    }

    public void setPreviewHeight(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048669, this, i) == null) {
            this.mPreviewHeight = i;
        }
    }

    public void setPreviewWidth(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048670, this, i) == null) {
            this.mPreviewWidth = i;
        }
    }

    public void setRecordConfigEncodeHevcVideo(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048671, this, z) == null) {
            this.mEncodeHevcVideo = z;
        }
    }

    public void setStickerDataList(List<MultiMediaData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048672, this, list) == null) {
            this.mStickerDataList = list;
        }
    }

    public void setSubTitleConfig(SubTitleConfig subTitleConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048673, this, subTitleConfig) == null) {
            this.mSubTitleConfig = subTitleConfig;
        }
    }

    public void setSubTitleUnits(List<SubTitleUnit> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048674, this, list) == null) {
            this.mSubTitleUnits = list;
        }
    }

    public void setUserNewAudioMixture(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048675, this, z) == null) {
            this.mIsUserNewAudioMixture = z;
        }
    }

    public void setVideoEffectData(VideoEffectData videoEffectData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048676, this, videoEffectData) == null) {
            this.mVideoEffectData = videoEffectData;
        }
    }

    public void setVideoFollowData(VideoFollowData videoFollowData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048677, this, videoFollowData) == null) {
            this.mVideoFollowData = videoFollowData;
        }
    }

    public void setVideoOutPath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048678, this, str) == null) {
            this.mVideoOutPath = str;
        }
    }

    public void setVideoPath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048679, this, str) == null) {
            this.mVideoPath = str;
        }
    }

    public void setVideoPattern(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048680, this, i) == null) {
            this.mVideoPattern = i;
        }
    }

    public void setVideoRatio(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048681, this, f) == null) {
            this.mVideoRatio = f;
        }
    }

    public void setVideoUploadType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048682, this, i) == null) {
            this.mVideoUploadType = i;
        }
    }
}
