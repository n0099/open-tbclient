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
/* loaded from: classes6.dex */
public interface IVlogEditManager extends IVLogLifeProtocol, IVLogPlayControlProtocol {
    public static final String FILTER_ORIGINAL = "FILTER_ORIGINAL";

    void addMultiMediaData(int i, List<MultiMediaData> list);

    void addOneTrack(MediaTrack mediaTrack);

    void addStickerData(MultiMediaData multiMediaData, String str);

    void deleteMultiMediaData(int i);

    int editOneEffect(int i, MediaAEffectConfig mediaAEffectConfig, long j, long j2);

    String exportConfigJson(String str);

    SubTitleUnit getCurrentSubtitle();

    ArrayList<MultiMediaData> getInputMultiMediaData();

    MultiMediaData getMultiMediaData(int i);

    MediaTrack getOriginEffectTrack();

    List<MultiMediaData> getStickerMultiMediaDataList(boolean z);

    List<MediaSegment> getStickerSegmentsData(boolean z);

    List<MediaSegment> getStickerSegmentsDataByType(String str);

    float getVideoRatio();

    void modifyTimeByRange(long j, long j2);

    void needDrawEffect(boolean z);

    boolean rangeSegmentScope(int i, long j, long j2);

    void removeLastEffect();

    void removeOneTrack(String str);

    void replaceStickerData(int i, MultiMediaData multiMediaData, String str);

    void setAngle(int i, float f);

    @Deprecated
    void setAngle(int i, int i2);

    void setAudioChangeType(int i);

    void setAudioChangeType(int[] iArr);

    void setAudioChangeType(int[] iArr, double[] dArr, int[] iArr2);

    void setEffectList(List<MediaSegment> list, Map<String, ShaderConfig> map);

    void setFilter(float f, String str);

    void setFilter(int i, float f, String str);

    void setFrameRate(int i);

    void setMediaTrackConfig(MediaTrackConfig mediaTrackConfig);

    void setMultiMediaData(List<MultiMediaData> list);

    void setScale(float f, float f2);

    void setScaleType(String str);

    void setStickerDataList(List<MultiMediaData> list, List<MediaSegment> list2);

    void setSubtitle(List<SubTitleUnit> list);

    void setSubtitleConfig(SubTitleConfig subTitleConfig);

    void setSubtitleOnStickerLayerTop();

    void setTransitionByIndex(int i, MediaTransitionConfig mediaTransitionConfig);

    void setVideoRatio(float f);

    void setX(float f);

    void setY(float f);

    void split(int i, long j, OnMultiMediaSplitListener onMultiMediaSplitListener);

    void updateInputDataOrder(List<MultiMediaData> list);

    void updateStickerDataRange(int i, String str, long j, long j2);
}
