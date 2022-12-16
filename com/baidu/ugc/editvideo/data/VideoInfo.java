package com.baidu.ugc.editvideo.data;

import android.content.Intent;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tbadk.core.atomData.CloudMusicActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes7.dex */
public class VideoInfo implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
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
    public transient /* synthetic */ FieldHolder $fh;
    public boolean hasUserAudio;
    public boolean isCompressedVideo;
    public boolean isRecordChoosedMusic;
    public List<String> mBeautifyListInfo;
    public String mEffectTempPath;
    public List<String> mFilterEffectListInfo;
    public List<String> mFilterListInfo;
    public long mInStepVideoDuration;
    public String mInStepVideoPath;
    public String mJoinVideoTid;
    public List<String> mMaterialListInfo;
    public int mMaxRecordDuration;
    public List<String> mMusicListInfo;
    public String mOriginMusicId;
    public String mOriginMusicPath;
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

    public VideoInfo() {
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
        this.mMaxRecordDuration = 15000;
        this.hasUserAudio = true;
        this.isRecordChoosedMusic = false;
        this.mOriginMusicId = "";
        this.mOriginMusicPath = "";
    }

    public String buildBeautify() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return buildStaticsInfo("beautify_level", this.mBeautifyListInfo);
        }
        return (String) invokeV.objValue;
    }

    public String buildFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return buildStaticsInfo("filter_id", this.mFilterListInfo);
        }
        return (String) invokeV.objValue;
    }

    public String buildFilterEffect() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return buildStaticsInfo("filter_effect", this.mFilterEffectListInfo);
        }
        return (String) invokeV.objValue;
    }

    public String buildMaterial() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return buildStaticsInfo("mMaterialId", this.mMaterialListInfo);
        }
        return (String) invokeV.objValue;
    }

    public String buildMusic() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return buildStaticsInfo(CloudMusicActivityConfig.MUSIC_ID, this.mMusicListInfo);
        }
        return (String) invokeV.objValue;
    }

    public String buildParticleEffect() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return buildStaticsInfo("magic_effect", this.mParticleEffectListInfo);
        }
        return (String) invokeV.objValue;
    }

    public String buildSpeedArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return buildStaticsInfo("speed_multiplier", this.mSpeedListInfo);
        }
        return (String) invokeV.objValue;
    }

    public String buildSticker() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return buildStaticsInfo("sticker_id", this.mStickListInfo);
        }
        return (String) invokeV.objValue;
    }

    public String buildTimeEffect() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return buildStaticsInfo("time_effect", this.mTimeEffectListInfo);
        }
        return (String) invokeV.objValue;
    }

    public String buildTransVideo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return buildStaticsInfo("transVideo_id", this.mTranEffectListInfo);
        }
        return (String) invokeV.objValue;
    }

    public List<String> getBeautifyListInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.mBeautifyListInfo;
        }
        return (List) invokeV.objValue;
    }

    public List<String> getFilterListInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.mFilterListInfo;
        }
        return (List) invokeV.objValue;
    }

    public long getInStepVideoDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.mInStepVideoDuration;
        }
        return invokeV.longValue;
    }

    public String getInStepVideoPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.mInStepVideoPath;
        }
        return (String) invokeV.objValue;
    }

    public String getJoinVideoTid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.mJoinVideoTid;
        }
        return (String) invokeV.objValue;
    }

    public List<String> getMaterialListInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.mMaterialListInfo;
        }
        return (List) invokeV.objValue;
    }

    public int getMaxRecordDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.mMaxRecordDuration;
        }
        return invokeV.intValue;
    }

    public List<String> getMusicListInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.mMusicListInfo;
        }
        return (List) invokeV.objValue;
    }

    public String getOriginalVideoPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.videoPath;
        }
        return (String) invokeV.objValue;
    }

    public List<String> getSpeedListInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.mSpeedListInfo;
        }
        return (List) invokeV.objValue;
    }

    public List<String> getStickListInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.mStickListInfo;
        }
        return (List) invokeV.objValue;
    }

    public long getThumbId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.thumbId;
        }
        return invokeV.longValue;
    }

    public String getThumbPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.thumbPath;
        }
        return (String) invokeV.objValue;
    }

    public List<String> getTranEffectListInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.mTranEffectListInfo;
        }
        return (List) invokeV.objValue;
    }

    public int getVideoDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.videoDuration;
        }
        return invokeV.intValue;
    }

    public int getVideoHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.videoHeight;
        }
        return invokeV.intValue;
    }

    public long getVideoLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.videoLength;
        }
        return invokeV.longValue;
    }

    public String getVideoMd5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.videoMd5;
        }
        return (String) invokeV.objValue;
    }

    public String getVideoPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            if (!TextUtils.isEmpty(this.mEffectTempPath)) {
                return this.mEffectTempPath;
            }
            return this.videoPath;
        }
        return (String) invokeV.objValue;
    }

    public int getVideoRecordType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.videoRecordType;
        }
        return invokeV.intValue;
    }

    public String getVideoTransPath1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.mVideoTransPath1;
        }
        return (String) invokeV.objValue;
    }

    public String getVideoTransPath2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.mVideoTransPath2;
        }
        return (String) invokeV.objValue;
    }

    public int getVideoType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return this.videoType;
        }
        return invokeV.intValue;
    }

    public String getVideoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.videoUrl;
        }
        return (String) invokeV.objValue;
    }

    public int getVideoWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return this.videoWidth;
        }
        return invokeV.intValue;
    }

    public boolean hasUpload() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            if (TextUtils.isEmpty(this.videoUrl) || TextUtils.isEmpty(this.videoMd5)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean isCompressedVideo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.isCompressedVideo;
        }
        return invokeV.booleanValue;
    }

    public boolean needUploadThunmb() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            if (!TextUtils.isEmpty(this.thumbPath) && this.thumbId <= 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean needUploadVideo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            if (TextUtils.isEmpty(this.videoUrl)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public String replaceEffectTempPath2VideoPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            if (TextUtils.isEmpty(this.mEffectTempPath)) {
                return "";
            }
            String str = this.videoPath;
            this.videoPath = this.mEffectTempPath;
            this.mEffectTempPath = null;
            return str;
        }
        return (String) invokeV.objValue;
    }

    public String buildContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "#(movideo," + this.thumbId + "," + this.videoWidth + "," + this.videoHeight + "," + this.videoMd5 + "," + this.videoUrl + "," + this.videoDuration + "," + this.videoWidth + "," + this.videoHeight + "," + this.videoLength + "," + this.videoType + ",NO)";
        }
        return (String) invokeV.objValue;
    }

    public String buildStaticsInfo(String str, List<String> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, list)) == null) {
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
        return (String) invokeLL.objValue;
    }

    public void copy(VideoInfo videoInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048588, this, videoInfo) != null) || videoInfo == null) {
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

    public boolean isAvaliable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            if (TextUtils.isEmpty(this.videoPath) || TextUtils.isEmpty(this.thumbPath) || this.videoHeight <= 0 || this.videoWidth <= 0 || !new File(this.videoPath).exists()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void parseFromIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048619, this, intent) != null) || intent == null) {
            return;
        }
        this.videoPath = intent.getStringExtra("video");
        this.thumbPath = intent.getStringExtra("image");
        this.videoDuration = (int) (intent.getLongExtra("video_l", 8000L) / 1000);
        this.videoHeight = intent.getIntExtra("video_h", 480);
        this.videoWidth = intent.getIntExtra("video_w", 480);
    }

    public void setBeautifyListInfo(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, list) == null) {
            this.mBeautifyListInfo = list;
        }
    }

    public void setEffectTempPath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, str) == null) {
            this.mEffectTempPath = str;
        }
    }

    public void setFilterEffectListInfo(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, list) == null) {
            this.mFilterEffectListInfo = list;
        }
    }

    public void setFilterListInfo(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, list) == null) {
            this.mFilterListInfo = list;
        }
    }

    public void setInStepVideoDuration(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048625, this, j) == null) {
            this.mInStepVideoDuration = j;
        }
    }

    public void setInStepVideoPath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, str) == null) {
            this.mInStepVideoPath = str;
        }
    }

    public void setIsCompressedVideo(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048627, this, z) == null) {
            this.isCompressedVideo = z;
        }
    }

    public void setJoinVideoTid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, str) == null) {
            this.mJoinVideoTid = str;
        }
    }

    public void setMaterialListInfo(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, list) == null) {
            this.mMaterialListInfo = list;
        }
    }

    public void setMaxRecordDuration(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048630, this, i) == null) {
            this.mMaxRecordDuration = i;
        }
    }

    public void setMusicListInfo(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, list) == null) {
            this.mMusicListInfo = list;
        }
    }

    public void setParticleEffectListInfo(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, list) == null) {
            this.mParticleEffectListInfo = list;
        }
    }

    public void setSpeedListInfo(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, list) == null) {
            this.mSpeedListInfo = list;
        }
    }

    public void setStickListInfo(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, list) == null) {
            this.mStickListInfo = list;
        }
    }

    public void setThumbId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048635, this, j) == null) {
            this.thumbId = j;
        }
    }

    public void setThumbPath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, str) == null) {
            this.thumbPath = str;
        }
    }

    public void setTimeEffectListInfo(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, list) == null) {
            this.mTimeEffectListInfo = list;
        }
    }

    public void setTranEffectListInfo(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, list) == null) {
            this.mTranEffectListInfo = list;
        }
    }

    public void setVideoDuration(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048639, this, i) == null) {
            this.videoDuration = i;
        }
    }

    public void setVideoHeight(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048640, this, i) == null) {
            this.videoHeight = i;
        }
    }

    public void setVideoLength(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048641, this, j) == null) {
            this.videoLength = j;
        }
    }

    public void setVideoMd5(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, str) == null) {
            this.videoMd5 = str;
        }
    }

    public void setVideoPath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, str) == null) {
            this.videoPath = str;
        }
    }

    public void setVideoRecordType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048644, this, i) == null) {
            this.videoRecordType = i;
        }
    }

    public void setVideoTransPath1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048645, this, str) == null) {
            this.mVideoTransPath1 = str;
        }
    }

    public void setVideoTransPath2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, str) == null) {
            this.mVideoTransPath2 = str;
        }
    }

    public void setVideoType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048647, this, i) == null) {
            this.videoType = i;
        }
    }

    public void setVideoUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048648, this, str) == null) {
            this.videoUrl = str;
        }
    }

    public void setVideoWidth(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048649, this, i) == null) {
            this.videoWidth = i;
        }
    }
}
