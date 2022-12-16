package com.baidu.ugc.editvideo.record.source.multimedia;

import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrackConfig;
import com.baidu.minivideo.effect.core.vlogedit.ShaderConfig;
import com.baidu.ugc.editvideo.data.MultiMediaDataTrack;
import com.baidu.ugc.editvideo.record.processor.observer.EffectChangeObserver;
import com.baidu.ugc.editvideo.record.processor.observer.MediaTrackChangeObserver;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public interface IMultiMediaDataSource {
    public static final int PROGRESS_TOUCH_END = 2;
    public static final int PROGRESS_TOUCH_IGNORE = 4;
    public static final int PROGRESS_TOUCH_ING = 1;
    public static final int PROGRESS_TOUCH_PROGRAM = 3;
    public static final int PROGRESS_TOUCH_START = 0;

    int getCurrentIndex();

    long getCurrentPlayTime();

    long getDuration();

    MediaTrackConfig getMediaTrackConfig();

    List<MultiMediaDataTrack> getMultiMediaDataTrack();

    Map<String, ShaderConfig> getShaderConfigMap();

    List<MediaTrack> getUpdateMediaTracks();

    boolean isPaused();

    boolean isResourceReady();

    void onInit();

    void registerObserver(EffectChangeObserver effectChangeObserver);

    void registerObserver(MediaTrackChangeObserver mediaTrackChangeObserver);

    void releaseTextures();
}
