package com.baidu.ugc.editvideo.magicmusic;

import com.baidu.tieba.m1b;
import com.baidu.ugc.editvideo.magicmusic.effect.BaseEffect;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class EffectUtil {
    public static void addEffect(BaseEffect baseEffect, List<BaseEffect> list) {
        int i;
        int i2;
        if (baseEffect == null || list == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (BaseEffect baseEffect2 : list) {
            int i3 = baseEffect2.startTime;
            int i4 = baseEffect.startTime;
            if (i3 > i4 || (i2 = baseEffect2.endTime) < i4) {
                int i5 = baseEffect2.startTime;
                if (i5 > baseEffect.startTime && i5 < (i = baseEffect.endTime)) {
                    if (baseEffect2.effectType != baseEffect.effectType) {
                        if (baseEffect2.endTime > i) {
                            baseEffect2 = (BaseEffect) baseEffect2.clone();
                            baseEffect2.startTime = baseEffect.endTime;
                        }
                    } else if (baseEffect2.endTime > i) {
                        baseEffect2 = (BaseEffect) baseEffect2.clone();
                        baseEffect2.startTime = baseEffect.endTime;
                    }
                }
            } else if (baseEffect2.effectType != baseEffect.effectType) {
                BaseEffect baseEffect3 = (BaseEffect) baseEffect2.clone();
                baseEffect3.endTime = baseEffect.startTime;
                arrayList.add(baseEffect3);
                if (baseEffect2.endTime > baseEffect.endTime) {
                    baseEffect2 = (BaseEffect) baseEffect2.clone();
                    baseEffect2.startTime = baseEffect.endTime;
                }
            } else {
                baseEffect.startTime = i3;
                if (i2 > baseEffect.endTime) {
                    baseEffect2 = (BaseEffect) baseEffect2.clone();
                    baseEffect2.startTime = baseEffect.endTime;
                }
            }
            arrayList.add(baseEffect2);
        }
        list.clear();
        list.addAll(arrayList);
        list.add(baseEffect);
    }

    public static BaseEffect getEffectInList(int i, List<BaseEffect> list) {
        if (m1b.e(list)) {
            return null;
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            BaseEffect baseEffect = list.get(size);
            if (baseEffect.startTime <= i && baseEffect.endTime >= i) {
                return baseEffect;
            }
        }
        return null;
    }
}
