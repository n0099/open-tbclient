package com.baidu.ugc.editvideo.record.source.multimedia;

import com.baidu.minivideo.effect.core.vlogedit.MediaAEffectConfig;
import com.baidu.minivideo.effect.core.vlogedit.MediaSegment;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrackConfig;
import com.baidu.minivideo.effect.core.vlogedit.MediaTransitionConfig;
import com.baidu.minivideo.effect.core.vlogedit.ShaderConfig;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import com.baidu.ugc.editvideo.subtitle.SubTitleConfig;
import com.baidu.ugc.editvideo.subtitle.SubTitleUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public interface IVlogEditManager extends IVLogLifeProtocol, IVLogPlayControlProtocol {
    public static final String FILTER_ORIGINAL = "FILTER_ORIGINAL";

    void addMultiMediaData(int i2, List<MultiMediaData> list);

    void addStickerData(MultiMediaData multiMediaData, String str);

    void deleteMultiMediaData(int i2);

    int editOneEffect(int i2, MediaAEffectConfig mediaAEffectConfig, long j, long j2);

    String exportConfigJson(String str);

    SubTitleUnit getCurrentSubtitle();

    ArrayList<MultiMediaData> getInputMultiMediaData();

    MultiMediaData getMultiMediaData(int i2);

    MediaTrack getOriginEffectTrack();

    List<MultiMediaData> getStickerMultiMediaDataList(boolean z);

    List<MediaSegment> getStickerSegmentsData(boolean z);

    List<MediaSegment> getStickerSegmentsDataByType(String str);

    float getVideoRatio();

    void modifyTimeByRange(long j, long j2);

    void needDrawEffect(boolean z);

    boolean rangeSegmentScope(int i2, long j, long j2);

    void removeLastEffect();

    void replaceStickerData(int i2, MultiMediaData multiMediaData, String str);

    void setAngle(int i2, float f2);

    @Deprecated
    void setAngle(int i2, int i3);

    void setAudioChangeType(int i2);

    void setAudioChangeType(int[] iArr);

    void setEffectList(List<MediaSegment> list, Map<String, ShaderConfig> map);

    void setFilter(float f2, String str);

    void setFilter(int i2, float f2, String str);

    void setFrameRate(int i2);

    void setMediaTrackConfig(MediaTrackConfig mediaTrackConfig);

    void setMultiMediaData(List<MultiMediaData> list);

    void setScale(float f2, float f3);

    void setScaleType(String str);

    void setStickerDataList(List<MultiMediaData> list, List<MediaSegment> list2);

    void setSubtitle(List<SubTitleUnit> list);

    void setSubtitleConfig(SubTitleConfig subTitleConfig);

    void setSubtitleOnStickerLayerTop();

    void setTransitionByIndex(int i2, MediaTransitionConfig mediaTransitionConfig);

    void setVideoRatio(float f2);

    void setX(float f2);

    void setY(float f2);

    void split(int i2, long j, OnMultiMediaSplitListener onMultiMediaSplitListener);

    void updateInputDataOrder(List<MultiMediaData> list);

    void updateStickerDataRange(int i2, String str, long j, long j2);
}
