package com.baidu.ugc.editvideo.magicmusic.effect;

import com.baidu.ugc.editvideo.magicmusic.EffectType;
import java.io.Serializable;
/* loaded from: classes9.dex */
public class BaseEffect implements Serializable, Cloneable {
    public static final int TYPE_FILTER = 1;
    public static final int TYPE_PARTICLE = 3;
    public static final int TYPE_TIME = 2;
    public static final int TYPE_TRANSITION = 4;
    public int baseType;
    public int duration;
    public EffectType effectType;
    public double endPercentage;
    public int endTime;
    public double startPercentage;
    public int startTime;

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
