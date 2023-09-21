package com.baidu.ugc.editvideo.magicmusic;

import android.text.TextUtils;
import com.baidu.tieba.akb;
import com.baidu.tieba.fkb;
import com.baidu.tieba.mhb;
import com.baidu.ugc.editvideo.magicmusic.effect.BaseEffect;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes9.dex */
public class VideoEffectData implements Serializable, Cloneable {
    public BaseEffect mTimeEffect;
    public List<BaseEffect> mMagicEffectList = new CopyOnWriteArrayList();
    public List<BaseEffect> mTransitionEffectList = new CopyOnWriteArrayList();

    public static boolean hasEffect(VideoEffectData videoEffectData) {
        if (videoEffectData == null) {
            return false;
        }
        return !fkb.e(videoEffectData.mMagicEffectList) || hasReverseTimeEffect(videoEffectData) || hasRepeatTimeEffect(videoEffectData);
    }

    public static boolean hasMagicEffect(VideoEffectData videoEffectData) {
        return (videoEffectData == null || fkb.e(videoEffectData.getMagicEffectList())) ? false : true;
    }

    public static boolean hasRepeatTimeEffect(VideoEffectData videoEffectData) {
        return (videoEffectData == null || videoEffectData.getTimeEffect() == null || videoEffectData.getTimeEffect().effectType != EffectType.TIME_REPEAT) ? false : true;
    }

    public static boolean hasReverseTimeEffect(VideoEffectData videoEffectData) {
        return (videoEffectData == null || videoEffectData.getTimeEffect() == null || videoEffectData.getTimeEffect().effectType != EffectType.TIME_REVERSE) ? false : true;
    }

    public static VideoEffectData parse(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            if (str.contains("SCALE_SMALL")) {
                str = str.replace("SCALE_SMALL", "NINE_FRAME");
            }
            return (VideoEffectData) new mhb().b(str, VideoEffectData.class);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String toJson(VideoEffectData videoEffectData) {
        if (videoEffectData == null) {
            return null;
        }
        try {
            return new mhb().a(videoEffectData);
        } catch (Exception unused) {
            return null;
        }
    }

    public Object clone() {
        VideoEffectData videoEffectData = new VideoEffectData();
        try {
            if (!fkb.e(this.mMagicEffectList)) {
                ArrayList arrayList = new ArrayList();
                for (BaseEffect baseEffect : this.mMagicEffectList) {
                    arrayList.add((BaseEffect) baseEffect.clone());
                }
                videoEffectData.setMagicEffectList(arrayList);
            }
            if (this.mTimeEffect != null) {
                videoEffectData.setTimeEffect((BaseEffect) this.mTimeEffect.clone());
            }
            if (!fkb.e(this.mTransitionEffectList)) {
                CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                for (BaseEffect baseEffect2 : this.mTransitionEffectList) {
                    copyOnWriteArrayList.add((BaseEffect) baseEffect2.clone());
                }
                videoEffectData.setTransitionEffectList(copyOnWriteArrayList);
            }
        } catch (Exception e) {
            akb.g(e);
        }
        return videoEffectData;
    }

    public boolean equals(Object obj) {
        EffectType effectType;
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof VideoEffectData) {
            VideoEffectData videoEffectData = (VideoEffectData) obj;
            BaseEffect baseEffect = this.mTimeEffect;
            if (baseEffect != null) {
                BaseEffect baseEffect2 = videoEffectData.mTimeEffect;
                if (baseEffect2 == null || (effectType = baseEffect.effectType) != baseEffect2.effectType) {
                    return false;
                }
                if (effectType == EffectType.TIME_REPEAT && (baseEffect.startTime != baseEffect2.startTime || baseEffect.endTime != baseEffect2.endTime)) {
                    return false;
                }
            } else {
                BaseEffect baseEffect3 = videoEffectData.mTimeEffect;
                if (baseEffect3 != null && baseEffect3.effectType != EffectType.NO) {
                    return false;
                }
            }
            if (fkb.e(this.mMagicEffectList)) {
                if (!fkb.e(videoEffectData.mMagicEffectList)) {
                    return false;
                }
            } else if (fkb.e(videoEffectData.mMagicEffectList) || this.mMagicEffectList.size() != videoEffectData.mMagicEffectList.size()) {
                return false;
            } else {
                for (int i = 0; i < this.mMagicEffectList.size(); i++) {
                    BaseEffect baseEffect4 = videoEffectData.mMagicEffectList.get(i);
                    BaseEffect baseEffect5 = this.mMagicEffectList.get(i);
                    if (baseEffect4 != null) {
                        if (baseEffect5 == null || baseEffect4.effectType != baseEffect5.effectType || baseEffect4.startTime != baseEffect5.startTime || baseEffect4.endTime != baseEffect5.endTime) {
                            return false;
                        }
                    } else if (baseEffect5 != null) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

    public BaseEffect getLast() {
        List<BaseEffect> list = this.mMagicEffectList;
        if (list == null || list.size() <= 0) {
            return null;
        }
        List<BaseEffect> list2 = this.mMagicEffectList;
        return list2.get(list2.size() - 1);
    }

    public List<BaseEffect> getMagicEffectList() {
        return this.mMagicEffectList;
    }

    public BaseEffect getTimeEffect() {
        return this.mTimeEffect;
    }

    public List<BaseEffect> getTransitionEffectList() {
        return this.mTransitionEffectList;
    }

    public BaseEffect remove(int i) {
        List<BaseEffect> list;
        if (i < 0 || (list = this.mMagicEffectList) == null || list.size() <= i) {
            return null;
        }
        return this.mMagicEffectList.remove(i);
    }

    public void setMagicEffectList(List<BaseEffect> list) {
        this.mMagicEffectList = list;
    }

    public void setTimeEffect(BaseEffect baseEffect) {
        this.mTimeEffect = baseEffect;
    }

    public void setTransitionEffectList(List<BaseEffect> list) {
        this.mTransitionEffectList = list;
    }
}
