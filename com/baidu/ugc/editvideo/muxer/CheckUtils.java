package com.baidu.ugc.editvideo.muxer;

import android.text.TextUtils;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.tieba.dgb;
import com.baidu.tieba.feb;
import com.baidu.tieba.jgb;
import com.baidu.tieba.xcb;
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
/* loaded from: classes9.dex */
public class CheckUtils {
    public static boolean checkAddMusic(VideoMuxerData videoMuxerData) {
        if (videoMuxerData == null) {
            return false;
        }
        if (dgb.e(videoMuxerData.getAudioPlayDataList())) {
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

    public static boolean checkAddSticker(VideoMuxerData videoMuxerData) {
        if (videoMuxerData == null) {
            return false;
        }
        return !dgb.e(videoMuxerData.getStickerDataList());
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00a4 A[EDGE_INSN: B:23:0x00a4->B:22:0x00a4 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean checkAllFileExist(VideoMuxerData videoMuxerData, StringBuilder sb) {
        String str;
        if (checkPhotoMovie(videoMuxerData)) {
            boolean z = true;
            for (MultiMediaData multiMediaData : videoMuxerData.getPhotoDataList()) {
                if (multiMediaData.type == 1) {
                    int f = jgb.f(multiMediaData.path);
                    if (!FileUtils.checkFile(multiMediaData.path) || f <= 0) {
                        if (sb != null) {
                            str = "sourceerror:" + multiMediaData.path + ", isexit:" + FileUtils.checkFile(multiMediaData.path) + ", draftDir exist:" + FileUtils.checkFile(new File(multiMediaData.path).getParent()) + ", duration:" + f;
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

    public static boolean checkArEdit(VideoMuxerData videoMuxerData) {
        return (videoMuxerData == null || (dgb.f(videoMuxerData.getAREditBeautyMap()) && videoMuxerData.getAREditSticker() == null && !ImageQualityData.isValidStatus(videoMuxerData.getImageQualityData()))) ? false : true;
    }

    public static boolean checkAudioDirectNext(VideoMuxerData videoMuxerData) {
        return (videoMuxerData == null || videoMuxerData.isComposeNecessary() || !checkOriginAudio(videoMuxerData) || checkAddMusic(videoMuxerData) || xcb.o(videoMuxerData.getFakeVoiceTypes()) || checkOriginVideoMute(videoMuxerData) || checkOriginVideoChangeSpeed(videoMuxerData)) ? false : true;
    }

    public static void checkAudioPlayTrackDataList(List<AudioPlayTrackData> list, VideoMuxerData videoMuxerData) {
        if (videoMuxerData == null || videoMuxerData.getPhotoDataList() == null || list == null || dgb.e(list)) {
            return;
        }
        int segmentsDuration = (int) MultiDataSourceUtil.getSegmentsDuration(videoMuxerData.getCurrThemeEffect() != null ? (MediaTrack) dgb.c(videoMuxerData.getCurrThemeEffect().mediaTracks, 0) : null);
        for (AudioPlayTrackData audioPlayTrackData : videoMuxerData.getAudioPlayTrackDataList()) {
            if (audioPlayTrackData != null && !dgb.e(audioPlayTrackData.mAudioPlayDataList)) {
                ArrayList arrayList = new ArrayList();
                int i = 0;
                while (i < segmentsDuration) {
                    Iterator<AudioPlayData> it = audioPlayTrackData.mAudioPlayDataList.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            AudioPlayData next = it.next();
                            if (next.end <= 0) {
                                next.end = jgb.f(next.audioPath);
                            }
                            int i2 = next.end;
                            int i3 = next.start;
                            if ((i2 - i3) + i > segmentsDuration) {
                                int i4 = (segmentsDuration - i) + i3;
                                next.end = i4;
                                i += i4 - i3;
                                arrayList.add(next);
                                break;
                            }
                            i += i2 - i3;
                            arrayList.add(next);
                        }
                    }
                }
                audioPlayTrackData.mAudioPlayDataList = arrayList;
            }
        }
    }

    public static boolean checkBitrate(VideoMuxerData videoMuxerData) {
        if (videoMuxerData != null && dgb.b(videoMuxerData.getPhotoDataList()) == 1) {
            MultiMediaData multiMediaData = (MultiMediaData) dgb.c(videoMuxerData.getPhotoDataList(), 0);
            if (multiMediaData.type == 1 && jgb.e(multiMediaData.path) > videoMuxerData.getOutBitRate()) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkDirectNext(VideoMuxerData videoMuxerData) {
        return videoMuxerData != null && !videoMuxerData.isComposeNecessary() && checkVideoDirectNext(videoMuxerData) && checkAudioDirectNext(videoMuxerData);
    }

    public static boolean checkEffect(VideoMuxerData videoMuxerData) {
        boolean z = false;
        if (videoMuxerData == null) {
            return false;
        }
        FilterValue filterValue = videoMuxerData.getFilterValue();
        if (filterValue != null && (filterValue.getFilterType() != 1 ? !(filterValue.getFilterType() != 2 || TextUtils.isEmpty(filterValue.getFilterPath())) : !(TextUtils.isEmpty(filterValue.getValue()) || "origin".equalsIgnoreCase(filterValue.getValue())))) {
            z = true;
        }
        if (videoMuxerData.getVideoEffectData() != null) {
            if (!dgb.e(videoMuxerData.getVideoEffectData().getMagicEffectList())) {
                z = true;
            }
            if (videoMuxerData.getVideoEffectData().getTimeEffect() != null && videoMuxerData.getVideoEffectData().getTimeEffect().effectType == EffectType.TIME_REPEAT) {
                return true;
            }
        }
        return z;
    }

    public static boolean checkFilter(VideoMuxerData videoMuxerData) {
        FilterValue filterValue;
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

    public static boolean checkMiniVideoEffect(VideoMuxerData videoMuxerData) {
        if (videoMuxerData == null || videoMuxerData.getVideoEffectData() == null) {
            return false;
        }
        boolean z = !dgb.e(videoMuxerData.getVideoEffectData().getMagicEffectList());
        if (videoMuxerData.getVideoEffectData().getTimeEffect() == null || videoMuxerData.getVideoEffectData().getTimeEffect().effectType != EffectType.TIME_REPEAT) {
            return z;
        }
        return true;
    }

    public static boolean checkMusic(VideoMuxerData videoMuxerData) {
        if (videoMuxerData == null) {
            return false;
        }
        if (videoMuxerData.getOriginMusicVolume() == 1.0f || !dgb.e(videoMuxerData.getPhotoDataList())) {
            MusicData musicData = videoMuxerData.getMusicData();
            return ((videoMuxerData.getOriginMusicVolume() == 1.0f && (musicData == null || musicData.mVolume == 0.0f)) || musicData == null || TextUtils.isEmpty(musicData.localPath)) ? false : true;
        }
        return true;
    }

    public static boolean checkOriginAudio(VideoMuxerData videoMuxerData) {
        if (videoMuxerData != null && dgb.b(videoMuxerData.getPhotoDataList()) == 1) {
            MultiMediaData multiMediaData = (MultiMediaData) dgb.c(videoMuxerData.getPhotoDataList(), 0);
            if (multiMediaData.type == 1 && multiMediaData.start == 0) {
                long j = multiMediaData.originalDuration;
                return (j == 0 || multiMediaData.end == j) && multiMediaData.volume == 1.0f;
            }
            return false;
        }
        return false;
    }

    public static boolean checkOriginSingleVideo(VideoMuxerData videoMuxerData) {
        if (videoMuxerData != null && dgb.b(videoMuxerData.getPhotoDataList()) == 1) {
            MultiMediaData multiMediaData = (MultiMediaData) dgb.c(videoMuxerData.getPhotoDataList(), 0);
            if (multiMediaData.type == 1 && multiMediaData.start == 0) {
                long j = multiMediaData.originalDuration;
                return (j == 0 || multiMediaData.end == j) && multiMediaData.angle == 0.0f && multiMediaData.scaleX == 1.0f && multiMediaData.scaleY == 1.0f && multiMediaData.x == 0.0f && multiMediaData.y == 0.0f && !multiMediaData.addDefaultEffect;
            }
            return false;
        }
        return false;
    }

    public static boolean checkOriginVideoChangeSpeed(VideoMuxerData videoMuxerData) {
        if (videoMuxerData != null && dgb.b(videoMuxerData.getPhotoDataList()) > 0) {
            Iterator<MultiMediaData> it = videoMuxerData.getPhotoDataList().iterator();
            while (it.hasNext()) {
                if (it.next().getCurrentSpeed() != 1.0f) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkOriginVideoMute(VideoMuxerData videoMuxerData) {
        if (videoMuxerData != null && dgb.b(videoMuxerData.getPhotoDataList()) == 1) {
            if (!jgb.g(((MultiMediaData) dgb.c(videoMuxerData.getPhotoDataList(), 0)).path)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkPhotoMovie(VideoMuxerData videoMuxerData) {
        return (videoMuxerData == null || videoMuxerData.getPhotoDataList() == null || videoMuxerData.getPhotoDataList().size() <= 0) ? false : true;
    }

    public static boolean checkResolution(VideoMuxerData videoMuxerData) {
        int i;
        int i2;
        if (videoMuxerData != null && dgb.b(videoMuxerData.getPhotoDataList()) == 1) {
            MultiMediaData multiMediaData = (MultiMediaData) dgb.c(videoMuxerData.getPhotoDataList(), 0);
            if (multiMediaData.type == 1) {
                float f = multiMediaData.angle;
                float f2 = multiMediaData.rotation;
                if ((f + f2) % 360.0f == 90.0f || (f + f2) % 360.0f == 270.0f) {
                    i = multiMediaData.height;
                    i2 = multiMediaData.width;
                } else {
                    i = multiMediaData.width;
                    i2 = multiMediaData.height;
                }
                return feb.g(i, i2);
            }
        }
        return false;
    }

    public static boolean checkSubtitle(VideoMuxerData videoMuxerData) {
        return (videoMuxerData == null || videoMuxerData.getSubTitleConfig() == null || dgb.b(videoMuxerData.getSubTitleUnits()) == 0) ? false : true;
    }

    public static boolean checkTheme(VideoMuxerData videoMuxerData) {
        return (videoMuxerData == null || videoMuxerData.getCurrThemeEffect() == null || TextUtils.isEmpty(videoMuxerData.getCurrThemeEffect().id) || TextUtils.isEmpty(videoMuxerData.getCurrThemeEffect().name)) ? false : true;
    }

    public static boolean checkVideoDirectNext(VideoMuxerData videoMuxerData) {
        return (videoMuxerData == null || videoMuxerData.isComposeNecessary() || !checkOriginSingleVideo(videoMuxerData) || checkFilter(videoMuxerData) || checkMiniVideoEffect(videoMuxerData) || checkSubtitle(videoMuxerData) || checkTheme(videoMuxerData) || checkArEdit(videoMuxerData) || checkResolution(videoMuxerData) || checkVideoRatio(videoMuxerData) || checkBitrate(videoMuxerData) || checkOriginVideoChangeSpeed(videoMuxerData) || checkAddSticker(videoMuxerData)) ? false : true;
    }

    public static boolean checkVideoRatio(VideoMuxerData videoMuxerData) {
        int i;
        int i2;
        if (videoMuxerData != null && dgb.b(videoMuxerData.getPhotoDataList()) == 1) {
            MultiMediaData multiMediaData = (MultiMediaData) dgb.c(videoMuxerData.getPhotoDataList(), 0);
            if (multiMediaData.type == 1) {
                float f = multiMediaData.rotation;
                if (f % 360.0f == 90.0f || f % 360.0f == 270.0f) {
                    i = multiMediaData.height;
                    i2 = multiMediaData.width;
                } else {
                    i = multiMediaData.width;
                    i2 = multiMediaData.height;
                }
                return videoMuxerData.getVideoRatio() != (((float) i2) * 1.0f) / ((float) i);
            }
            return false;
        }
        return false;
    }

    public static void syncMusicData(VideoMuxerData videoMuxerData) {
        MusicData musicData;
        int i;
        AudioPlayData audioPlayData;
        if (videoMuxerData == null || (musicData = videoMuxerData.getMusicData()) == null || musicData.mVolume <= 0.0f || videoMuxerData.getPhotoDataList() == null) {
            return;
        }
        int i2 = 0;
        int segmentsDuration = (int) MultiDataSourceUtil.getSegmentsDuration(videoMuxerData.getCurrThemeEffect() != null ? (MediaTrack) dgb.c(videoMuxerData.getCurrThemeEffect().mediaTracks, 0) : null);
        int f = jgb.f(musicData.localPath);
        ArrayList arrayList = new ArrayList();
        int i3 = musicData.startPosition;
        if (f - i3 < segmentsDuration) {
            if (f > 0 && f - i3 <= 0) {
                musicData.startPosition = 0;
            }
            if (f - musicData.startPosition > 0) {
                while (true) {
                    i = segmentsDuration - i2;
                    if (i < f - musicData.startPosition) {
                        break;
                    }
                    arrayList.add(new AudioPlayData(musicData.localPath, musicData.startPosition, f, musicData.mVolume));
                    i2 += f - musicData.startPosition;
                }
                if (i2 < segmentsDuration) {
                    String str = musicData.localPath;
                    int i4 = musicData.startPosition;
                    audioPlayData = new AudioPlayData(str, i4, i + i4, musicData.mVolume);
                }
            }
            videoMuxerData.setAudioPlayDataList(arrayList);
        }
        String str2 = musicData.localPath;
        int i5 = musicData.startPosition;
        audioPlayData = new AudioPlayData(str2, i5, segmentsDuration + i5, musicData.mVolume);
        arrayList.add(audioPlayData);
        videoMuxerData.setAudioPlayDataList(arrayList);
    }
}
