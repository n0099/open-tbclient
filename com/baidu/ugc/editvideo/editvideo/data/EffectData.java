package com.baidu.ugc.editvideo.editvideo.data;

import com.baidu.minivideo.effect.core.vlogedit.MediaAEffectConfig;
import com.baidu.ugc.editvideo.magicmusic.EffectType;
/* loaded from: classes8.dex */
public class EffectData {
    public int baseType;
    public EffectType effectType;
    public int imgBgRes;
    public int imgRes;
    public boolean isSame;
    public MediaAEffectConfig mSpecialEffectData;
    public String name;

    public EffectData(int i, int i2, String str, EffectType effectType) {
        this(i, i2, str, effectType, -1, null);
    }

    public EffectData(int i, int i2, String str, EffectType effectType, int i3) {
        this(i, i2, str, effectType, i3, null);
    }

    public EffectData(int i, int i2, String str, EffectType effectType, int i3, MediaAEffectConfig mediaAEffectConfig) {
        this.imgRes = i;
        this.baseType = i2;
        this.name = str;
        this.effectType = effectType;
        this.imgBgRes = i3;
        this.mSpecialEffectData = mediaAEffectConfig;
    }
}
