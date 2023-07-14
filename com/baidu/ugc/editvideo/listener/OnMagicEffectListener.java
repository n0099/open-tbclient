package com.baidu.ugc.editvideo.listener;

import com.baidu.ugc.editvideo.editvideo.data.EffectData;
import com.baidu.ugc.editvideo.magicmusic.EffectType;
import com.baidu.ugc.editvideo.magicmusic.effect.BaseEffect;
/* loaded from: classes9.dex */
public interface OnMagicEffectListener {
    void onClickEffect(EffectType effectType, EffectData effectData);

    void onStartMagicEffect(BaseEffect baseEffect, EffectData effectData);

    void onStopMagicEffect(EffectType effectType, EffectData effectData);
}
