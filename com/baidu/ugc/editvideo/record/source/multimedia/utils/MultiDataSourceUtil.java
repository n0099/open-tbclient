package com.baidu.ugc.editvideo.record.source.multimedia.utils;

import android.graphics.Bitmap;
import com.baidu.minivideo.effect.core.vlogedit.MediaAEffectConfig;
import com.baidu.minivideo.effect.core.vlogedit.MediaSegment;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrackConfig;
import com.baidu.minivideo.effect.core.vlogedit.MediaTransition;
import com.baidu.minivideo.effect.core.vlogedit.MediaTransitionConfig;
import com.baidu.minivideo.effect.core.vlogedit.ShaderConfig;
import com.baidu.tieba.afb;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import com.baidu.ugc.editvideo.data.MultiMediaDataTrack;
import java.nio.Buffer;
import java.util.List;
import java.util.Map;
/* loaded from: classes9.dex */
public class MultiDataSourceUtil {
    public static final float DEFAULT_SINGLE_MEDIA_TIME = 3.0f;
    public static String sDefaultScaleType = "center_inside";

    /* loaded from: classes9.dex */
    public interface OnInitMultiMediaListener {
        void onInitMultiMedia(MultiMediaData multiMediaData);
    }

    /* loaded from: classes9.dex */
    public interface OnReleaseMultiMediaListener {
        void onReleaseMultiMedia(MultiMediaData multiMediaData);
    }

    public static int addMultiMediaData(MultiMediaDataTrack multiMediaDataTrack, int i, MultiMediaData multiMediaData) {
        return InnerMultiDataSourceUtil.addMultiMediaData(multiMediaDataTrack, i, multiMediaData);
    }

    public static void addOneTrack(MediaTrack mediaTrack, List<MediaTrack> list, Map<String, ShaderConfig> map, List<MultiMediaDataTrack> list2, OnInitMultiMediaListener onInitMultiMediaListener) {
        InnerMultiDataSourceUtil.addOneTrack(mediaTrack, list, map, list2, onInitMultiMediaListener);
    }

    public static void applySuperpositionSegment(List<MediaTrack> list, Map<String, ShaderConfig> map, List<MultiMediaDataTrack> list2, OnInitMultiMediaListener onInitMultiMediaListener, OnReleaseMultiMediaListener onReleaseMultiMediaListener) {
        InnerMultiDataSourceUtil.applySuperpositionSegment(list, map, list2, onInitMultiMediaListener, onReleaseMultiMediaListener);
    }

    public static MediaTrack buildBlurBackgroundTrack(float f, float f2) {
        return InnerMultiDataSourceUtil.buildBlurBackgroundTrack("user_background", f, f2);
    }

    public static MediaTrack buildColorBackgroundTrack(String str, String str2, float f) {
        return InnerMultiDataSourceUtil.buildColorBackgroundTrack(str, str2, f);
    }

    public static void buildInputTrack(List<MultiMediaData> list, List<MediaTrack> list2) {
        InnerMultiDataSourceUtil.buildInputTrack(list, list2);
    }

    public static void buildMultiMediaDataSource(List<MultiMediaData> list, MediaTrackConfig mediaTrackConfig, List<MultiMediaDataTrack> list2, List<MediaTrack> list3, Map<String, ShaderConfig> map, OnInitMultiMediaListener onInitMultiMediaListener, OnReleaseMultiMediaListener onReleaseMultiMediaListener) {
        InnerMultiDataSourceUtil.buildMultiMediaDataSource(list, mediaTrackConfig, list2, list3, map, onInitMultiMediaListener, onReleaseMultiMediaListener);
    }

    public static void buildMultiMediaDataTrackList(List<MultiMediaData> list, List<MultiMediaDataTrack> list2) {
        InnerMultiDataSourceUtil.buildMultiMediaDataTrackList(list, list2);
    }

    public static MediaTrack buildResourceBackgroundTrack(String str, MultiMediaData multiMediaData, Map<String, ShaderConfig> map) {
        return InnerMultiDataSourceUtil.buildResourceBackgroundTrack(str, multiMediaData, map);
    }

    public static MediaTrack buildSubtitleAndStickerTrack(List<MediaTrack> list, List<MultiMediaDataTrack> list2) {
        return InnerMultiDataSourceUtil.buildSubtitleAndStickerTrack(list, list2);
    }

    public static Bitmap decodeBitmap(String str) {
        return InnerMultiDataSourceUtil.decodeBitmap(str);
    }

    public static int deleteMultiMediaData(List<MultiMediaDataTrack> list, int i, OnReleaseMultiMediaListener onReleaseMultiMediaListener) {
        return InnerMultiDataSourceUtil.deleteMultiMediaData(list, i, onReleaseMultiMediaListener);
    }

    public static MultiMediaData findDataByUuid(List<MultiMediaData> list, String str) {
        return InnerMultiDataSourceUtil.findDataByUuid(list, str);
    }

    public static int[] findIndexInSegments(List<MediaSegment> list, long j) {
        return InnerMultiDataSourceUtil.findIndexInSegments(list, j);
    }

    public static int findInputIndexInSegments(List<MediaSegment> list, long j) {
        return InnerMultiDataSourceUtil.findInputIndexInSegments(list, j);
    }

    public static MediaSegment findSegmentByMultiMediaData(MultiMediaData multiMediaData, List<MediaTrack> list, List<MultiMediaDataTrack> list2) {
        return InnerMultiDataSourceUtil.findSegmentByMultiMediaData(multiMediaData, list, list2);
    }

    public static MediaTrack getEffectTrack(List<MediaTrack> list) {
        return InnerMultiDataSourceUtil.getEffectTrack(list);
    }

    public static String getInputScaleType(MediaSegment mediaSegment) {
        return InnerMultiDataSourceUtil.getInputScaleType(mediaSegment);
    }

    public static long getMultiMediaDataRealEnd(MediaTrack mediaTrack, int i) {
        MediaSegment mediaSegment;
        if (i < 0 || mediaTrack == null || afb.e(mediaTrack.mediaSegments) || (mediaSegment = (MediaSegment) afb.c(mediaTrack.mediaSegments, i)) == null) {
            return 0L;
        }
        MediaTransition mediaTransition = (MediaTransition) afb.c(mediaTrack.mediaTransitions, i);
        return (mediaSegment.end - mediaSegment.start) - (mediaTransition != null ? mediaTransition.duration : 0L);
    }

    public static long getMultiMediaDataSeekTime(MultiMediaData multiMediaData, MediaSegment mediaSegment, long j) {
        return InnerMultiDataSourceUtil.getMultiMediaDataSeekTime(multiMediaData, mediaSegment, j);
    }

    public static long getSegmentsDuration(MediaTrack mediaTrack) {
        return InnerMultiDataSourceUtil.getSegmentsDuration(mediaTrack);
    }

    public static List<MediaSegment> getStickerSegmentsDataByType(MediaTrack mediaTrack, String str) {
        return InnerMultiDataSourceUtil.getStickerSegmentsDataByType(mediaTrack, str);
    }

    public static MediaTrack getSubtitleAndStickerTrack(List<MediaTrack> list) {
        return InnerMultiDataSourceUtil.getSubtitleAndStickerTrack(list);
    }

    public static MediaTrack getTrackByType(List<MediaTrack> list, String str) {
        return InnerMultiDataSourceUtil.getTrackByType(list, str);
    }

    public static void glDeleteTextures(int i) {
        InnerMultiDataSourceUtil.glDeleteTextures(i);
    }

    public static void glDeleteTextures(MultiMediaData multiMediaData) {
        InnerMultiDataSourceUtil.glDeleteTextures(multiMediaData);
    }

    public static int hasGlobalFilter(MediaTrack mediaTrack) {
        return InnerMultiDataSourceUtil.hasGlobalFilter(mediaTrack);
    }

    public static int initImageByBitmap(MultiMediaData multiMediaData, Bitmap bitmap) {
        return InnerMultiDataSourceUtil.initImageByBitmap(multiMediaData, bitmap);
    }

    public static void initVideoByPath(MultiMediaData multiMediaData) {
        InnerMultiDataSourceUtil.initVideoByPath(multiMediaData);
    }

    public static MediaAEffectConfig loadMediaAEffectConfig(String str) {
        return InnerMultiDataSourceUtil.loadMediaAEffectConfig(str);
    }

    public static MediaTransitionConfig loadMediaTransitionConfig(String str) {
        return InnerMultiDataSourceUtil.loadMediaTransitionConfig(str);
    }

    public static void modifyTimeByRange(List<MediaTrack> list, MediaTrack mediaTrack, long j, long j2) {
        InnerMultiDataSourceUtil.modifyTimeByRange(list, mediaTrack, j, j2);
    }

    public static void releaseOtherTrack(List<MediaTrack> list, List<MultiMediaDataTrack> list2, OnReleaseMultiMediaListener onReleaseMultiMediaListener) {
        InnerMultiDataSourceUtil.releaseOtherTrack(list, list2, onReleaseMultiMediaListener);
    }

    public static void removeOneTrack(MediaTrack mediaTrack, List<MediaTrack> list, List<MultiMediaDataTrack> list2, OnReleaseMultiMediaListener onReleaseMultiMediaListener) {
        InnerMultiDataSourceUtil.removeOneTrack(mediaTrack, list, list2, onReleaseMultiMediaListener);
    }

    public static Bitmap saveOffscreenBitmap(int i, int i2) {
        return saveOffscreenBitmap(i, i2, true);
    }

    public static Bitmap saveOffscreenBitmap(int i, int i2, boolean z) {
        return InnerMultiDataSourceUtil.saveOffscreenBitmap(i, i2, z);
    }

    public static Buffer saveOffscreenBuffer(int i, int i2) {
        return saveOffscreenBuffer(i, i2, true);
    }

    public static Buffer saveOffscreenBuffer(int i, int i2, boolean z) {
        return InnerMultiDataSourceUtil.saveOffscreenBuffer(i, i2, z);
    }

    public static MediaSegment transData2Segment(long j, MultiMediaData multiMediaData) {
        return InnerMultiDataSourceUtil.transData2Segment(j, multiMediaData);
    }

    public static int updateTimeline(MediaTrack mediaTrack, List<MultiMediaData> list, long j) {
        return InnerMultiDataSourceUtil.updateTimeline(mediaTrack, list, j);
    }
}
