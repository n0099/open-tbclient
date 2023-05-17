package com.baidu.ugc.editvideo.record.source.multimedia;

import android.graphics.SurfaceTexture;
import com.baidu.minivideo.effect.core.vlogedit.MediaAEffectConfig;
import com.baidu.minivideo.effect.core.vlogedit.MediaSegment;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrackConfig;
import com.baidu.minivideo.effect.core.vlogedit.MediaTransitionConfig;
import com.baidu.minivideo.effect.core.vlogedit.ShaderConfig;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import com.baidu.ugc.editvideo.data.MultiMediaDataTrack;
import com.baidu.ugc.editvideo.record.processor.observer.EffectChangeObserver;
import com.baidu.ugc.editvideo.record.processor.observer.MediaTrackChangeObserver;
import com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol;
import com.baidu.ugc.editvideo.record.source.multimedia.utils.MultiDataSourceUtil;
import com.baidu.ugc.editvideo.sticker.StickerDataChangeType;
import com.baidu.ugc.editvideo.subtitle.SubTitleConfig;
import com.baidu.ugc.editvideo.subtitle.SubTitleUnit;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public class VlogEditManager implements IMultiMediaDataSource, IVLogCommunicateProtocol, IVlogEditManager, IVlogEditViewManager {
    public static final int STATE_ERROR = -1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_PAUSED = 4;
    public static final int STATE_PLAYBACK_COMPLETED = 5;
    public static final int STATE_PLAYING = 3;
    public static final int STATE_PREPARED = 2;
    public static final int STATE_PREPARING = 1;
    public volatile int mCurrentState;
    public MultiMediaDataSource mMultiMediaDataSource;
    public IMultiMediaDataSourceView mOnMultiMediaEntireProtocol;
    public volatile int mTargetState = 0;

    public VlogEditManager(final IMultiMediaDataSourceView iMultiMediaDataSourceView) {
        this.mCurrentState = 0;
        this.mOnMultiMediaEntireProtocol = iMultiMediaDataSourceView;
        MultiMediaDataSource multiMediaDataSource = new MultiMediaDataSource();
        this.mMultiMediaDataSource = multiMediaDataSource;
        if (iMultiMediaDataSourceView != null) {
            multiMediaDataSource.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() { // from class: com.baidu.ugc.editvideo.record.source.multimedia.VlogEditManager.1
                @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
                public void onFrameAvailable(SurfaceTexture surfaceTexture) {
                    VlogEditManager.this.notifyFrameAvailable();
                    if (surfaceTexture != null) {
                        iMultiMediaDataSourceView.seek(VlogEditManager.this.mMultiMediaDataSource.getCurrentPlayTime());
                    }
                }
            });
            setPreRunnableTask(iMultiMediaDataSourceView);
            iMultiMediaDataSourceView.setIMultiMediaDataSource(this.mMultiMediaDataSource);
        }
        this.mCurrentState = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyFrameAvailable() {
        IMultiMediaDataSourceView iMultiMediaDataSourceView = this.mOnMultiMediaEntireProtocol;
        if (iMultiMediaDataSourceView != null) {
            iMultiMediaDataSourceView.onFrameAvailable(null);
        }
    }

    public void addCoverStickerData(MultiMediaData multiMediaData) {
        IMultiMediaDataSourceView iMultiMediaDataSourceView = this.mOnMultiMediaEntireProtocol;
        if (iMultiMediaDataSourceView != null) {
            iMultiMediaDataSourceView.addCoverStickerData(multiMediaData);
        }
    }

    public void addCoverStickerDataList(List<MultiMediaData> list) {
        IMultiMediaDataSourceView iMultiMediaDataSourceView = this.mOnMultiMediaEntireProtocol;
        if (iMultiMediaDataSourceView != null) {
            iMultiMediaDataSourceView.addCoverStickerDataList(list);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void addMultiMediaData(int i, List<MultiMediaData> list) {
        MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
        if (multiMediaDataSource != null) {
            multiMediaDataSource.addMultiMediaData(i, list);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void addOneTrack(MediaTrack mediaTrack) {
        MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
        if (multiMediaDataSource != null) {
            multiMediaDataSource.addOneTrack(mediaTrack);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void addStickerData(MultiMediaData multiMediaData, String str) {
        MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
        if (multiMediaDataSource != null) {
            multiMediaDataSource.addStickerData(multiMediaData, str);
        }
        IMultiMediaDataSourceView iMultiMediaDataSourceView = this.mOnMultiMediaEntireProtocol;
        if (iMultiMediaDataSourceView != null) {
            iMultiMediaDataSourceView.notifyStickerDataChange("add");
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditViewManager
    public void cancelStickerSelected() {
        IMultiMediaDataSourceView iMultiMediaDataSourceView = this.mOnMultiMediaEntireProtocol;
        if (iMultiMediaDataSourceView != null) {
            iMultiMediaDataSourceView.cancelStickerSelected();
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditViewManager
    public Buffer captureVideoCover(int i, long j, int i2, int i3) {
        IMultiMediaDataSourceView iMultiMediaDataSourceView = this.mOnMultiMediaEntireProtocol;
        if (iMultiMediaDataSourceView != null) {
            iMultiMediaDataSourceView.capture(i, j, i2, i3);
        }
        return MultiDataSourceUtil.saveOffscreenBuffer(i2, i3, true);
    }

    public void deleteCoverStickerData(MultiMediaData multiMediaData) {
        IMultiMediaDataSourceView iMultiMediaDataSourceView = this.mOnMultiMediaEntireProtocol;
        if (iMultiMediaDataSourceView != null) {
            iMultiMediaDataSourceView.deleteCoverStickerData(multiMediaData);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void deleteMultiMediaData(int i) {
        MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
        if (multiMediaDataSource != null) {
            multiMediaDataSource.deleteMultiMediaData(i);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditViewManager
    public void deleteStickerData(MultiMediaData multiMediaData, String str) {
        IMultiMediaDataSourceView iMultiMediaDataSourceView = this.mOnMultiMediaEntireProtocol;
        if (iMultiMediaDataSourceView != null) {
            iMultiMediaDataSourceView.deleteStickerData(multiMediaData, str);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public int editOneEffect(int i, MediaAEffectConfig mediaAEffectConfig, long j, long j2) {
        MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
        if (multiMediaDataSource != null) {
            return multiMediaDataSource.editOneEffect(i, mediaAEffectConfig, j, j2);
        }
        return 0;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public String exportConfigJson(String str) {
        MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
        if (multiMediaDataSource != null) {
            return multiMediaDataSource.exportConfigJson(str);
        }
        return null;
    }

    public List<MultiMediaData> getCoverStickerDataList() {
        IMultiMediaDataSourceView iMultiMediaDataSourceView = this.mOnMultiMediaEntireProtocol;
        return iMultiMediaDataSourceView != null ? iMultiMediaDataSourceView.getCoverStickerDataList() : new ArrayList();
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource
    public int getCurrentIndex() {
        MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
        if (multiMediaDataSource != null) {
            return multiMediaDataSource.getCurrentIndex();
        }
        return 0;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource
    public long getCurrentPlayTime() {
        MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
        if (multiMediaDataSource != null) {
            return multiMediaDataSource.getCurrentPlayTime();
        }
        return 0L;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public SubTitleUnit getCurrentSubtitle() {
        MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
        if (multiMediaDataSource != null) {
            return multiMediaDataSource.getCurrentSubtitle();
        }
        return null;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource
    public long getDuration() {
        MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
        if (multiMediaDataSource != null) {
            return multiMediaDataSource.getDuration();
        }
        return 0L;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public ArrayList<MultiMediaData> getInputMultiMediaData() {
        MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
        if (multiMediaDataSource != null) {
            return multiMediaDataSource.getInputMultiMediaData();
        }
        return null;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource
    public MediaTrackConfig getMediaTrackConfig() {
        MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
        if (multiMediaDataSource != null) {
            return multiMediaDataSource.getMediaTrackConfig();
        }
        return null;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public MultiMediaData getMultiMediaData(int i) {
        MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
        if (multiMediaDataSource != null) {
            return multiMediaDataSource.getMultiMediaData(i);
        }
        return null;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource
    public List<MultiMediaDataTrack> getMultiMediaDataTrack() {
        MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
        if (multiMediaDataSource != null) {
            return multiMediaDataSource.getMultiMediaDataTrack();
        }
        return null;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public MediaTrack getOriginEffectTrack() {
        MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
        if (multiMediaDataSource != null) {
            return multiMediaDataSource.getOriginEffectTrack();
        }
        return null;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource
    public Map<String, ShaderConfig> getShaderConfigMap() {
        MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
        if (multiMediaDataSource != null) {
            return multiMediaDataSource.getShaderConfigMap();
        }
        return null;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public List<MultiMediaData> getStickerMultiMediaDataList(boolean z) {
        MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
        if (multiMediaDataSource != null) {
            return multiMediaDataSource.getStickerMultiMediaDataList(z);
        }
        return null;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public List<MediaSegment> getStickerSegmentsData(boolean z) {
        MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
        if (multiMediaDataSource != null) {
            return multiMediaDataSource.getStickerSegmentsData(z);
        }
        return null;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public List<MediaSegment> getStickerSegmentsDataByType(String str) {
        MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
        if (multiMediaDataSource != null) {
            return multiMediaDataSource.getStickerSegmentsDataByType(str);
        }
        return null;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource
    public List<MediaTrack> getUpdateMediaTracks() {
        MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
        if (multiMediaDataSource != null) {
            return multiMediaDataSource.getUpdateMediaTracks();
        }
        return null;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public float getVideoRatio() {
        MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
        if (multiMediaDataSource != null) {
            return multiMediaDataSource.getVideoRatio();
        }
        return 0.0f;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol
    public float getVolume(int i) {
        MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
        if (multiMediaDataSource != null) {
            return multiMediaDataSource.getVolume(i);
        }
        return 1.0f;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol
    public boolean isMute() {
        MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
        if (multiMediaDataSource != null) {
            return multiMediaDataSource.isMute();
        }
        return false;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource
    public boolean isPaused() {
        MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
        if (multiMediaDataSource != null) {
            return multiMediaDataSource.isPaused();
        }
        return false;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol
    public boolean isPlaying() {
        MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
        if (multiMediaDataSource != null) {
            return multiMediaDataSource.isPlaying();
        }
        return false;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource
    public boolean isResourceReady() {
        MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
        if (multiMediaDataSource != null) {
            return multiMediaDataSource.isResourceReady();
        }
        return false;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void modifyTimeByRange(long j, long j2) {
        MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
        if (multiMediaDataSource != null) {
            multiMediaDataSource.modifyTimeByRange(j, j2);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditViewManager
    public void moveBoundsCheckEnabled(boolean z) {
        IMultiMediaDataSourceView iMultiMediaDataSourceView = this.mOnMultiMediaEntireProtocol;
        if (iMultiMediaDataSourceView != null) {
            iMultiMediaDataSourceView.moveBoundsCheckEnabled(z);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void needDrawEffect(boolean z) {
        IMultiMediaDataSourceView iMultiMediaDataSourceView = this.mOnMultiMediaEntireProtocol;
        if (iMultiMediaDataSourceView != null) {
            iMultiMediaDataSourceView.needDrawEffect(z);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogLifeProtocol
    public void onDestroy() {
        MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
        if (multiMediaDataSource != null) {
            multiMediaDataSource.onDestroy();
        }
        this.mCurrentState = 0;
        this.mTargetState = 0;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource
    public void onInit() {
        MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
        if (multiMediaDataSource != null) {
            multiMediaDataSource.onInit();
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogLifeProtocol
    public void onPause() {
        MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
        if (multiMediaDataSource != null) {
            multiMediaDataSource.onPause();
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogLifeProtocol
    public void onResume() {
        MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
        if (multiMediaDataSource != null) {
            multiMediaDataSource.onResume();
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol
    public void pause() {
        this.mTargetState = 4;
        MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
        if (multiMediaDataSource != null) {
            multiMediaDataSource.pause();
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol
    public void prepareAsync() {
        MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
        if (multiMediaDataSource != null) {
            multiMediaDataSource.prepareAsync();
        }
        this.mCurrentState = 1;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public boolean rangeSegmentScope(int i, long j, long j2) {
        MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
        if (multiMediaDataSource != null) {
            return multiMediaDataSource.rangeSegmentScope(i, j, j2);
        }
        return false;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource
    public void registerObserver(EffectChangeObserver effectChangeObserver) {
        MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
        if (multiMediaDataSource != null) {
            multiMediaDataSource.registerObserver(effectChangeObserver);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource
    public void registerObserver(MediaTrackChangeObserver mediaTrackChangeObserver) {
        MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
        if (multiMediaDataSource != null) {
            multiMediaDataSource.registerObserver(mediaTrackChangeObserver);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol
    public void release() {
        MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
        if (multiMediaDataSource != null) {
            multiMediaDataSource.release();
        }
        this.mCurrentState = 0;
        this.mTargetState = 0;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaDataSource
    public void releaseTextures() {
        MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
        if (multiMediaDataSource != null) {
            multiMediaDataSource.releaseTextures();
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void removeLastEffect() {
        MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
        if (multiMediaDataSource != null) {
            multiMediaDataSource.removeLastEffect();
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void removeOneTrack(String str) {
        MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
        if (multiMediaDataSource != null) {
            multiMediaDataSource.removeOneTrack(str);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol
    public void repeatIndex(int i) {
        MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
        if (multiMediaDataSource != null) {
            multiMediaDataSource.repeatIndex(i);
        }
    }

    public void replaceCoverStickerData(MultiMediaData multiMediaData) {
        IMultiMediaDataSourceView iMultiMediaDataSourceView = this.mOnMultiMediaEntireProtocol;
        if (iMultiMediaDataSourceView != null) {
            iMultiMediaDataSourceView.replaceCoverStickerData(multiMediaData);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void replaceStickerData(int i, MultiMediaData multiMediaData, String str) {
        MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
        if (multiMediaDataSource != null) {
            multiMediaDataSource.replaceStickerData(i, multiMediaData, str);
        }
        IMultiMediaDataSourceView iMultiMediaDataSourceView = this.mOnMultiMediaEntireProtocol;
        if (iMultiMediaDataSourceView != null) {
            iMultiMediaDataSourceView.notifyStickerDataChange(StickerDataChangeType.REPLACE);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol
    public void reset() {
        MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
        if (multiMediaDataSource != null) {
            multiMediaDataSource.reset();
        }
        this.mCurrentState = 0;
        this.mTargetState = 0;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol
    public void seek(long j) {
        MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
        if (multiMediaDataSource != null) {
            multiMediaDataSource.seek(j);
        }
        IMultiMediaDataSourceView iMultiMediaDataSourceView = this.mOnMultiMediaEntireProtocol;
        if (iMultiMediaDataSourceView != null) {
            iMultiMediaDataSourceView.seek(j);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol
    public void seek(long j, int i) {
        MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
        if (multiMediaDataSource != null) {
            multiMediaDataSource.seek(j, i);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void setAngle(int i, float f) {
        MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
        if (multiMediaDataSource != null) {
            multiMediaDataSource.setAngle(i, f);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    @Deprecated
    public void setAngle(int i, int i2) {
        setAngle(i, i2);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void setAudioChangeType(int i) {
        MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
        if (multiMediaDataSource != null) {
            multiMediaDataSource.setAudioChangeType(i);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void setAudioChangeType(int[] iArr) {
        MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
        if (multiMediaDataSource != null) {
            multiMediaDataSource.setAudioChangeType(iArr);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void setAudioChangeType(int[] iArr, double[] dArr, int[] iArr2) {
        MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
        if (multiMediaDataSource != null) {
            multiMediaDataSource.setAudioChangeType(iArr, dArr, iArr2);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditViewManager
    public void setCurrentStickerData(int i, String str) {
        IMultiMediaDataSourceView iMultiMediaDataSourceView = this.mOnMultiMediaEntireProtocol;
        if (iMultiMediaDataSourceView != null) {
            iMultiMediaDataSourceView.setCurrentStickerData(i, str);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void setEffectList(List<MediaSegment> list, Map<String, ShaderConfig> map) {
        MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
        if (multiMediaDataSource != null) {
            multiMediaDataSource.setEffectList(list, map);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void setFilter(float f, String str) {
        MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
        if (multiMediaDataSource != null) {
            multiMediaDataSource.setFilter(f, str);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void setFilter(int i, float f, String str) {
        MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
        if (multiMediaDataSource != null) {
            multiMediaDataSource.setFilter(i, f, str);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void setFrameRate(int i) {
        MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
        if (multiMediaDataSource != null) {
            multiMediaDataSource.setFrameRate(i);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol
    public void setLooping(boolean z) {
        MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
        if (multiMediaDataSource != null) {
            multiMediaDataSource.setLooping(z);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void setMediaTrackConfig(MediaTrackConfig mediaTrackConfig) {
        MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
        if (multiMediaDataSource != null) {
            multiMediaDataSource.setMediaTrackConfig(mediaTrackConfig);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void setMultiMediaData(List<MultiMediaData> list) {
        MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
        if (multiMediaDataSource != null) {
            multiMediaDataSource.setMultiMediaData(list);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogCommunicateProtocol
    public void setMultiMediaStateEventListener(MultiMediaStateEventListener multiMediaStateEventListener) {
        MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
        if (multiMediaDataSource != null) {
            multiMediaDataSource.setMultiMediaStateEventListener(multiMediaStateEventListener);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogCommunicateProtocol
    public void setMultiMediaTimelineUpdateListener(MultiMediaTimelineUpdateListener multiMediaTimelineUpdateListener, boolean z) {
        MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
        if (multiMediaDataSource != null) {
            multiMediaDataSource.setMultiMediaTimelineUpdateListener(multiMediaTimelineUpdateListener, z);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol
    public void setMute(boolean z) {
        MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
        if (multiMediaDataSource != null) {
            multiMediaDataSource.setMute(z);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogCommunicateProtocol
    public void setOnFrameAvailableListener(SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener) {
        MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
        if (multiMediaDataSource != null) {
            multiMediaDataSource.setOnFrameAvailableListener(onFrameAvailableListener);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol
    public void setOnPlayStateListener(IVLogPlayControlProtocol.OnPlayStateListener onPlayStateListener) {
        MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
        if (multiMediaDataSource != null) {
            multiMediaDataSource.setOnPlayStateListener(onPlayStateListener);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogCommunicateProtocol
    public void setPreRunnableTask(OnPreRunnableTask onPreRunnableTask) {
        MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
        if (multiMediaDataSource != null) {
            multiMediaDataSource.setPreRunnableTask(onPreRunnableTask);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol
    public void setPreparedListener(final IMultiMediaPreparedListener iMultiMediaPreparedListener) {
        MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
        if (multiMediaDataSource != null) {
            multiMediaDataSource.setPreparedListener(new IMultiMediaPreparedListener() { // from class: com.baidu.ugc.editvideo.record.source.multimedia.VlogEditManager.2
                @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaPreparedListener
                public void onPrepared() {
                    IMultiMediaPreparedListener iMultiMediaPreparedListener2 = iMultiMediaPreparedListener;
                    if (iMultiMediaPreparedListener2 != null) {
                        iMultiMediaPreparedListener2.onPrepared();
                    }
                    VlogEditManager.this.mCurrentState = 2;
                }
            });
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void setScale(float f, float f2) {
        MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
        if (multiMediaDataSource != null) {
            multiMediaDataSource.setScale(f, f2);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void setScaleType(String str) {
        MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
        if (multiMediaDataSource != null) {
            multiMediaDataSource.setScaleType(str);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void setStickerDataList(List<MultiMediaData> list, List<MediaSegment> list2) {
        MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
        if (multiMediaDataSource != null) {
            multiMediaDataSource.setStickerDataList(list, list2);
        }
        IMultiMediaDataSourceView iMultiMediaDataSourceView = this.mOnMultiMediaEntireProtocol;
        if (iMultiMediaDataSourceView != null) {
            iMultiMediaDataSourceView.notifyStickerDataChange("init");
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditViewManager
    public void setStickerDeleteButton(String str, String str2) {
        IMultiMediaDataSourceView iMultiMediaDataSourceView = this.mOnMultiMediaEntireProtocol;
        if (iMultiMediaDataSourceView != null) {
            iMultiMediaDataSourceView.setStickerDeleteButton(str, str2);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditViewManager
    public void setStickerEditButton(String str, String str2) {
        IMultiMediaDataSourceView iMultiMediaDataSourceView = this.mOnMultiMediaEntireProtocol;
        if (iMultiMediaDataSourceView != null) {
            iMultiMediaDataSourceView.setStickerEditButton(str, str2);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditViewManager
    public void setStickerMaxScale(float f) {
        IMultiMediaDataSourceView iMultiMediaDataSourceView = this.mOnMultiMediaEntireProtocol;
        if (iMultiMediaDataSourceView != null) {
            iMultiMediaDataSourceView.setStickerMaxScale(f);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditViewManager
    public void setStickerMinScale(float f) {
        IMultiMediaDataSourceView iMultiMediaDataSourceView = this.mOnMultiMediaEntireProtocol;
        if (iMultiMediaDataSourceView != null) {
            iMultiMediaDataSourceView.setStickerMinScale(f);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditViewManager
    public void setStickerRotationButton(String str, String str2) {
        IMultiMediaDataSourceView iMultiMediaDataSourceView = this.mOnMultiMediaEntireProtocol;
        if (iMultiMediaDataSourceView != null) {
            iMultiMediaDataSourceView.setStickerRotationButton(str, str2);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void setSubtitle(List<SubTitleUnit> list) {
        MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
        if (multiMediaDataSource != null) {
            multiMediaDataSource.setSubtitle(list);
        }
        IMultiMediaDataSourceView iMultiMediaDataSourceView = this.mOnMultiMediaEntireProtocol;
        if (iMultiMediaDataSourceView != null) {
            iMultiMediaDataSourceView.notifyStickerDataChange("init");
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void setSubtitleConfig(SubTitleConfig subTitleConfig) {
        MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
        if (multiMediaDataSource != null) {
            multiMediaDataSource.setSubtitleConfig(subTitleConfig);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void setSubtitleOnStickerLayerTop() {
        MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
        if (multiMediaDataSource != null) {
            multiMediaDataSource.setSubtitleOnStickerLayerTop();
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void setTransitionByIndex(int i, MediaTransitionConfig mediaTransitionConfig) {
        MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
        if (multiMediaDataSource != null) {
            multiMediaDataSource.setTransitionByIndex(i, mediaTransitionConfig);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditViewManager
    public void setUpEditLayer(String str) {
        IMultiMediaDataSourceView iMultiMediaDataSourceView = this.mOnMultiMediaEntireProtocol;
        if (iMultiMediaDataSourceView != null) {
            iMultiMediaDataSourceView.setUpEditLayer(str);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void setVideoRatio(float f) {
        MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
        if (multiMediaDataSource != null) {
            multiMediaDataSource.setVideoRatio(f);
        }
        IMultiMediaDataSourceView iMultiMediaDataSourceView = this.mOnMultiMediaEntireProtocol;
        if (iMultiMediaDataSourceView != null) {
            iMultiMediaDataSourceView.setVideoRatio(f);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol
    public void setVolume(float f) {
        MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
        if (multiMediaDataSource != null) {
            multiMediaDataSource.setVolume(f);
            setMute(f == 0.0f);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol
    public void setVolume(int i, float f) {
        MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
        if (multiMediaDataSource != null) {
            multiMediaDataSource.setVolume(i, f);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void setX(float f) {
        MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
        if (multiMediaDataSource != null) {
            multiMediaDataSource.setX(f);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void setY(float f) {
        MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
        if (multiMediaDataSource != null) {
            multiMediaDataSource.setY(f);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void split(int i, long j, OnMultiMediaSplitListener onMultiMediaSplitListener) {
        MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
        if (multiMediaDataSource != null) {
            multiMediaDataSource.split(i, j, onMultiMediaSplitListener);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol
    public void start() {
        this.mTargetState = 3;
        MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
        if (multiMediaDataSource != null) {
            multiMediaDataSource.start();
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void updateInputDataOrder(List<MultiMediaData> list) {
        MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
        if (multiMediaDataSource != null) {
            multiMediaDataSource.updateInputDataOrder(list);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager
    public void updateStickerDataRange(int i, String str, long j, long j2) {
        MultiMediaDataSource multiMediaDataSource = this.mMultiMediaDataSource;
        if (multiMediaDataSource != null) {
            multiMediaDataSource.updateStickerDataRange(i, str, j, j2);
        }
        IMultiMediaDataSourceView iMultiMediaDataSourceView = this.mOnMultiMediaEntireProtocol;
        if (iMultiMediaDataSourceView != null) {
            iMultiMediaDataSourceView.notifyStickerDataChange(StickerDataChangeType.UPDATE);
        }
    }
}
