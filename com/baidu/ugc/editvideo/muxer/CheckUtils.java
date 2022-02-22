package com.baidu.ugc.editvideo.muxer;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.b1.i.c;
import c.a.b1.l.a;
import c.a.b1.t.h;
import c.a.b1.t.n;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.bean.MusicData;
import com.baidu.ugc.editvideo.data.ImageQualityData;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import com.baidu.ugc.editvideo.data.VideoMuxerData;
import com.baidu.ugc.editvideo.filter.FilterValue;
import com.baidu.ugc.editvideo.magicmusic.EffectType;
import com.baidu.ugc.editvideo.player.AudioPlayData;
import com.baidu.ugc.editvideo.player.AudioPlayTrackData;
import com.baidu.ugc.editvideo.record.source.multimedia.utils.MultiDataSourceUtil;
import com.baidu.ugc.utils.FileUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes13.dex */
public class CheckUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public CheckUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static boolean checkAddMusic(VideoMuxerData videoMuxerData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, videoMuxerData)) == null) {
            if (videoMuxerData == null) {
                return false;
            }
            if (h.e(videoMuxerData.getAudioPlayDataList())) {
                MusicData musicData = videoMuxerData.getMusicData();
                return musicData != null && musicData.mVolume > 0.0f && FileUtils.isExists(musicData.localPath);
            }
            for (AudioPlayData audioPlayData : videoMuxerData.getAudioPlayDataList()) {
                if (audioPlayData != null && audioPlayData.volume > 0.0f && FileUtils.isExists(audioPlayData.audioPath)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean checkAddSticker(VideoMuxerData videoMuxerData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, videoMuxerData)) == null) {
            if (videoMuxerData == null) {
                return false;
            }
            return !h.e(videoMuxerData.getStickerDataList());
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00a8 A[EDGE_INSN: B:29:0x00a8->B:24:0x00a8 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean checkAllFileExist(VideoMuxerData videoMuxerData, StringBuilder sb) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, videoMuxerData, sb)) == null) {
            if (checkPhotoMovie(videoMuxerData)) {
                boolean z = true;
                for (MultiMediaData multiMediaData : videoMuxerData.getPhotoDataList()) {
                    if (multiMediaData.type == 1) {
                        int f2 = n.f(multiMediaData.path);
                        if (!FileUtils.checkFile(multiMediaData.path) || f2 <= 0) {
                            if (sb != null) {
                                str = "sourceerror:" + multiMediaData.path + ", isexit:" + FileUtils.checkFile(multiMediaData.path) + ", draftDir exist:" + FileUtils.checkFile(new File(multiMediaData.path).getParent()) + ", duration:" + f2;
                                sb.append(str);
                            }
                            z = false;
                            continue;
                            if (!z) {
                                break;
                            }
                        } else if (!z) {
                        }
                    } else if (FileUtils.checkFile(multiMediaData.path)) {
                        continue;
                        if (!z) {
                        }
                    } else {
                        if (sb != null) {
                            sb.append("sourceerror:");
                            sb.append(multiMediaData.path);
                            sb.append(", draftDir exist:");
                            sb.append(FileUtils.checkFile(new File(multiMediaData.path).getParent()));
                            str = ", notexit;";
                            sb.append(str);
                        }
                        z = false;
                        continue;
                        if (!z) {
                        }
                    }
                }
                return z;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean checkArEdit(VideoMuxerData videoMuxerData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, videoMuxerData)) == null) ? (videoMuxerData == null || (h.f(videoMuxerData.getAREditBeautyMap()) && videoMuxerData.getAREditSticker() == null && !ImageQualityData.isValidStatus(videoMuxerData.getImageQualityData()))) ? false : true : invokeL.booleanValue;
    }

    public static boolean checkAudioDirectNext(VideoMuxerData videoMuxerData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, videoMuxerData)) == null) ? (videoMuxerData == null || videoMuxerData.isComposeNecessary() || !checkOriginAudio(videoMuxerData) || checkAddMusic(videoMuxerData) || c.o(videoMuxerData.getFakeVoiceTypes()) || checkOriginVideoMute(videoMuxerData) || checkOriginVideoChangeSpeed(videoMuxerData)) ? false : true : invokeL.booleanValue;
    }

    public static void checkAudioPlayTrackDataList(List<AudioPlayTrackData> list, VideoMuxerData videoMuxerData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65542, null, list, videoMuxerData) == null) || videoMuxerData == null || videoMuxerData.getPhotoDataList() == null || list == null || h.e(list)) {
            return;
        }
        int segmentsDuration = (int) MultiDataSourceUtil.getSegmentsDuration(videoMuxerData.getCurrThemeEffect() != null ? (MediaTrack) h.c(videoMuxerData.getCurrThemeEffect().mediaTracks, 0) : null);
        for (AudioPlayTrackData audioPlayTrackData : videoMuxerData.getAudioPlayTrackDataList()) {
            if (audioPlayTrackData != null && !h.e(audioPlayTrackData.mAudioPlayDataList)) {
                ArrayList arrayList = new ArrayList();
                int i2 = 0;
                while (i2 < segmentsDuration) {
                    Iterator<AudioPlayData> it = audioPlayTrackData.mAudioPlayDataList.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            AudioPlayData next = it.next();
                            if (next.end <= 0) {
                                next.end = n.f(next.audioPath);
                            }
                            int i3 = next.end;
                            int i4 = next.start;
                            if ((i3 - i4) + i2 > segmentsDuration) {
                                int i5 = (segmentsDuration - i2) + i4;
                                next.end = i5;
                                i2 += i5 - i4;
                                arrayList.add(next);
                                break;
                            }
                            i2 += i3 - i4;
                            arrayList.add(next);
                        }
                    }
                }
                audioPlayTrackData.mAudioPlayDataList = arrayList;
            }
        }
    }

    public static boolean checkBitrate(VideoMuxerData videoMuxerData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, videoMuxerData)) == null) {
            if (videoMuxerData != null && h.b(videoMuxerData.getPhotoDataList()) == 1) {
                MultiMediaData multiMediaData = (MultiMediaData) h.c(videoMuxerData.getPhotoDataList(), 0);
                if (multiMediaData.type == 1 && n.e(multiMediaData.path) > videoMuxerData.getOutBitRate()) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean checkDirectNext(VideoMuxerData videoMuxerData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, videoMuxerData)) == null) ? videoMuxerData != null && !videoMuxerData.isComposeNecessary() && checkVideoDirectNext(videoMuxerData) && checkAudioDirectNext(videoMuxerData) : invokeL.booleanValue;
    }

    public static boolean checkEffect(VideoMuxerData videoMuxerData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, videoMuxerData)) == null) {
            boolean z = false;
            if (videoMuxerData == null) {
                return false;
            }
            FilterValue filterValue = videoMuxerData.getFilterValue();
            if (filterValue != null && (filterValue.getFilterType() != 1 ? !(filterValue.getFilterType() != 2 || TextUtils.isEmpty(filterValue.getFilterPath())) : !(TextUtils.isEmpty(filterValue.getValue()) || "origin".equalsIgnoreCase(filterValue.getValue())))) {
                z = true;
            }
            if (videoMuxerData.getVideoEffectData() != null) {
                if (!h.e(videoMuxerData.getVideoEffectData().getMagicEffectList())) {
                    z = true;
                }
                if (videoMuxerData.getVideoEffectData().getTimeEffect() != null && videoMuxerData.getVideoEffectData().getTimeEffect().effectType == EffectType.TIME_REPEAT) {
                    return true;
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public static boolean checkFilter(VideoMuxerData videoMuxerData) {
        InterceptResult invokeL;
        FilterValue filterValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, videoMuxerData)) == null) {
            if (videoMuxerData == null || (filterValue = videoMuxerData.getFilterValue()) == null) {
                return false;
            }
            if (filterValue.getFilterType() == 1) {
                if (TextUtils.isEmpty(filterValue.getValue()) || "origin".equalsIgnoreCase(filterValue.getValue())) {
                    return false;
                }
            } else if (filterValue.getFilterType() != 2 || TextUtils.isEmpty(filterValue.getFilterPath())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean checkMiniVideoEffect(VideoMuxerData videoMuxerData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, videoMuxerData)) == null) {
            if (videoMuxerData == null || videoMuxerData.getVideoEffectData() == null) {
                return false;
            }
            boolean z = !h.e(videoMuxerData.getVideoEffectData().getMagicEffectList());
            if (videoMuxerData.getVideoEffectData().getTimeEffect() == null || videoMuxerData.getVideoEffectData().getTimeEffect().effectType != EffectType.TIME_REPEAT) {
                return z;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean checkMusic(VideoMuxerData videoMuxerData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, videoMuxerData)) == null) {
            if (videoMuxerData == null) {
                return false;
            }
            if (videoMuxerData.getOriginMusicVolume() == 1.0f || !h.e(videoMuxerData.getPhotoDataList())) {
                MusicData musicData = videoMuxerData.getMusicData();
                return ((videoMuxerData.getOriginMusicVolume() == 1.0f && (musicData == null || musicData.mVolume == 0.0f)) || musicData == null || TextUtils.isEmpty(musicData.localPath)) ? false : true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean checkOriginAudio(VideoMuxerData videoMuxerData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, videoMuxerData)) == null) {
            if (videoMuxerData != null && h.b(videoMuxerData.getPhotoDataList()) == 1) {
                MultiMediaData multiMediaData = (MultiMediaData) h.c(videoMuxerData.getPhotoDataList(), 0);
                if (multiMediaData.type == 1 && multiMediaData.start == 0) {
                    long j2 = multiMediaData.originalDuration;
                    return (j2 == 0 || multiMediaData.end == j2) && multiMediaData.volume == 1.0f;
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean checkOriginSingleVideo(VideoMuxerData videoMuxerData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, videoMuxerData)) == null) {
            if (videoMuxerData != null && h.b(videoMuxerData.getPhotoDataList()) == 1) {
                MultiMediaData multiMediaData = (MultiMediaData) h.c(videoMuxerData.getPhotoDataList(), 0);
                if (multiMediaData.type == 1 && multiMediaData.start == 0) {
                    long j2 = multiMediaData.originalDuration;
                    return (j2 == 0 || multiMediaData.end == j2) && multiMediaData.angle == 0.0f && multiMediaData.scaleX == 1.0f && multiMediaData.scaleY == 1.0f && multiMediaData.x == 0.0f && multiMediaData.y == 0.0f && !multiMediaData.addDefaultEffect;
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean checkOriginVideoChangeSpeed(VideoMuxerData videoMuxerData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, videoMuxerData)) == null) {
            if (videoMuxerData != null && h.b(videoMuxerData.getPhotoDataList()) > 0) {
                Iterator<MultiMediaData> it = videoMuxerData.getPhotoDataList().iterator();
                while (it.hasNext()) {
                    if (it.next().getCurrentSpeed() != 1.0f) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean checkOriginVideoMute(VideoMuxerData videoMuxerData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, videoMuxerData)) == null) {
            if (videoMuxerData != null && h.b(videoMuxerData.getPhotoDataList()) == 1) {
                if (!n.g(((MultiMediaData) h.c(videoMuxerData.getPhotoDataList(), 0)).path)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean checkPhotoMovie(VideoMuxerData videoMuxerData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65553, null, videoMuxerData)) == null) ? (videoMuxerData == null || videoMuxerData.getPhotoDataList() == null || videoMuxerData.getPhotoDataList().size() <= 0) ? false : true : invokeL.booleanValue;
    }

    public static boolean checkResolution(VideoMuxerData videoMuxerData) {
        InterceptResult invokeL;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, videoMuxerData)) == null) {
            if (videoMuxerData != null && h.b(videoMuxerData.getPhotoDataList()) == 1) {
                MultiMediaData multiMediaData = (MultiMediaData) h.c(videoMuxerData.getPhotoDataList(), 0);
                if (multiMediaData.type == 1) {
                    float f2 = multiMediaData.angle;
                    float f3 = multiMediaData.rotation;
                    if ((f2 + f3) % 360.0f == 90.0f || (f2 + f3) % 360.0f == 270.0f) {
                        i2 = multiMediaData.height;
                        i3 = multiMediaData.width;
                    } else {
                        i2 = multiMediaData.width;
                        i3 = multiMediaData.height;
                    }
                    return a.g(i2, i3);
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean checkSubtitle(VideoMuxerData videoMuxerData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65555, null, videoMuxerData)) == null) ? (videoMuxerData == null || videoMuxerData.getSubTitleConfig() == null || h.b(videoMuxerData.getSubTitleUnits()) == 0) ? false : true : invokeL.booleanValue;
    }

    public static boolean checkTheme(VideoMuxerData videoMuxerData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65556, null, videoMuxerData)) == null) ? (videoMuxerData == null || videoMuxerData.getCurrThemeEffect() == null || TextUtils.isEmpty(videoMuxerData.getCurrThemeEffect().id) || TextUtils.isEmpty(videoMuxerData.getCurrThemeEffect().name)) ? false : true : invokeL.booleanValue;
    }

    public static boolean checkVideoDirectNext(VideoMuxerData videoMuxerData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65557, null, videoMuxerData)) == null) ? (videoMuxerData == null || videoMuxerData.isComposeNecessary() || !checkOriginSingleVideo(videoMuxerData) || checkFilter(videoMuxerData) || checkMiniVideoEffect(videoMuxerData) || checkSubtitle(videoMuxerData) || checkTheme(videoMuxerData) || checkArEdit(videoMuxerData) || checkResolution(videoMuxerData) || checkVideoRatio(videoMuxerData) || checkBitrate(videoMuxerData) || checkOriginVideoChangeSpeed(videoMuxerData) || checkAddSticker(videoMuxerData)) ? false : true : invokeL.booleanValue;
    }

    public static boolean checkVideoRatio(VideoMuxerData videoMuxerData) {
        InterceptResult invokeL;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, videoMuxerData)) == null) {
            if (videoMuxerData != null && h.b(videoMuxerData.getPhotoDataList()) == 1) {
                MultiMediaData multiMediaData = (MultiMediaData) h.c(videoMuxerData.getPhotoDataList(), 0);
                if (multiMediaData.type == 1) {
                    float f2 = multiMediaData.rotation;
                    if (f2 % 360.0f == 90.0f || f2 % 360.0f == 270.0f) {
                        i2 = multiMediaData.height;
                        i3 = multiMediaData.width;
                    } else {
                        i2 = multiMediaData.width;
                        i3 = multiMediaData.height;
                    }
                    return videoMuxerData.getVideoRatio() != (((float) i3) * 1.0f) / ((float) i2);
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void syncMusicData(VideoMuxerData videoMuxerData) {
        MusicData musicData;
        int i2;
        AudioPlayData audioPlayData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65559, null, videoMuxerData) == null) || videoMuxerData == null || (musicData = videoMuxerData.getMusicData()) == null || musicData.mVolume <= 0.0f || videoMuxerData.getPhotoDataList() == null) {
            return;
        }
        int i3 = 0;
        int segmentsDuration = (int) MultiDataSourceUtil.getSegmentsDuration(videoMuxerData.getCurrThemeEffect() != null ? (MediaTrack) h.c(videoMuxerData.getCurrThemeEffect().mediaTracks, 0) : null);
        int f2 = n.f(musicData.localPath);
        ArrayList arrayList = new ArrayList();
        int i4 = musicData.startPosition;
        if (f2 - i4 < segmentsDuration) {
            if (f2 > 0 && f2 - i4 <= 0) {
                musicData.startPosition = 0;
            }
            if (f2 - musicData.startPosition > 0) {
                while (true) {
                    i2 = segmentsDuration - i3;
                    if (i2 < f2 - musicData.startPosition) {
                        break;
                    }
                    arrayList.add(new AudioPlayData(musicData.localPath, musicData.startPosition, f2, musicData.mVolume));
                    i3 += f2 - musicData.startPosition;
                }
                if (i3 < segmentsDuration) {
                    String str = musicData.localPath;
                    int i5 = musicData.startPosition;
                    audioPlayData = new AudioPlayData(str, i5, i2 + i5, musicData.mVolume);
                }
            }
            videoMuxerData.setAudioPlayDataList(arrayList);
        }
        String str2 = musicData.localPath;
        int i6 = musicData.startPosition;
        audioPlayData = new AudioPlayData(str2, i6, segmentsDuration + i6, musicData.mVolume);
        arrayList.add(audioPlayData);
        videoMuxerData.setAudioPlayDataList(arrayList);
    }
}
