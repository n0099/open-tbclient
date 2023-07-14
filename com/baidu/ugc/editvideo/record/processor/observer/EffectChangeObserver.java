package com.baidu.ugc.editvideo.record.processor.observer;

import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.minivideo.effect.core.vlogedit.ShaderConfig;
import java.util.List;
import java.util.Map;
/* loaded from: classes9.dex */
public interface EffectChangeObserver {
    void onChanged(Map<String, ShaderConfig> map, List<MediaTrack> list);
}
