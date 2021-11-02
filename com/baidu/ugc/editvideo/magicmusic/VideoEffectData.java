package com.baidu.ugc.editvideo.magicmusic;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.x0.j.b;
import b.a.x0.t.c;
import b.a.x0.t.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.magicmusic.effect.BaseEffect;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes10.dex */
public class VideoEffectData implements Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<BaseEffect> mMagicEffectList;
    public BaseEffect mTimeEffect;
    public List<BaseEffect> mTransitionEffectList;

    public VideoEffectData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mMagicEffectList = new CopyOnWriteArrayList();
        this.mTransitionEffectList = new CopyOnWriteArrayList();
    }

    public static boolean hasEffect(VideoEffectData videoEffectData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, videoEffectData)) == null) {
            if (videoEffectData == null) {
                return false;
            }
            return !h.e(videoEffectData.mMagicEffectList) || hasReverseTimeEffect(videoEffectData) || hasRepeatTimeEffect(videoEffectData);
        }
        return invokeL.booleanValue;
    }

    public static boolean hasMagicEffect(VideoEffectData videoEffectData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, videoEffectData)) == null) ? (videoEffectData == null || h.e(videoEffectData.getMagicEffectList())) ? false : true : invokeL.booleanValue;
    }

    public static boolean hasRepeatTimeEffect(VideoEffectData videoEffectData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, videoEffectData)) == null) ? (videoEffectData == null || videoEffectData.getTimeEffect() == null || videoEffectData.getTimeEffect().effectType != EffectType.TIME_REPEAT) ? false : true : invokeL.booleanValue;
    }

    public static boolean hasReverseTimeEffect(VideoEffectData videoEffectData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, videoEffectData)) == null) ? (videoEffectData == null || videoEffectData.getTimeEffect() == null || videoEffectData.getTimeEffect().effectType != EffectType.TIME_REVERSE) ? false : true : invokeL.booleanValue;
    }

    public static VideoEffectData parse(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                if (str.contains("SCALE_SMALL")) {
                    str = str.replace("SCALE_SMALL", "NINE_FRAME");
                }
                return (VideoEffectData) new b().b(str, VideoEffectData.class);
            } catch (Exception unused) {
                return null;
            }
        }
        return (VideoEffectData) invokeL.objValue;
    }

    public static String toJson(VideoEffectData videoEffectData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, videoEffectData)) == null) {
            if (videoEffectData == null) {
                return null;
            }
            try {
                return new b().a(videoEffectData);
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public Object clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            VideoEffectData videoEffectData = new VideoEffectData();
            try {
                if (!h.e(this.mMagicEffectList)) {
                    ArrayList arrayList = new ArrayList();
                    for (BaseEffect baseEffect : this.mMagicEffectList) {
                        arrayList.add((BaseEffect) baseEffect.clone());
                    }
                    videoEffectData.setMagicEffectList(arrayList);
                }
                if (this.mTimeEffect != null) {
                    videoEffectData.setTimeEffect((BaseEffect) this.mTimeEffect.clone());
                }
                if (!h.e(this.mTransitionEffectList)) {
                    CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                    for (BaseEffect baseEffect2 : this.mTransitionEffectList) {
                        copyOnWriteArrayList.add((BaseEffect) baseEffect2.clone());
                    }
                    videoEffectData.setTransitionEffectList(copyOnWriteArrayList);
                }
            } catch (Exception e2) {
                c.g(e2);
            }
            return videoEffectData;
        }
        return invokeV.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        EffectType effectType;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
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
                if (h.e(this.mMagicEffectList)) {
                    if (!h.e(videoEffectData.mMagicEffectList)) {
                        return false;
                    }
                } else if (h.e(videoEffectData.mMagicEffectList) || this.mMagicEffectList.size() != videoEffectData.mMagicEffectList.size()) {
                    return false;
                } else {
                    for (int i2 = 0; i2 < this.mMagicEffectList.size(); i2++) {
                        BaseEffect baseEffect4 = videoEffectData.mMagicEffectList.get(i2);
                        BaseEffect baseEffect5 = this.mMagicEffectList.get(i2);
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
        return invokeL.booleanValue;
    }

    public BaseEffect getLast() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<BaseEffect> list = this.mMagicEffectList;
            if (list == null || list.size() <= 0) {
                return null;
            }
            List<BaseEffect> list2 = this.mMagicEffectList;
            return list2.get(list2.size() - 1);
        }
        return (BaseEffect) invokeV.objValue;
    }

    public List<BaseEffect> getMagicEffectList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mMagicEffectList : (List) invokeV.objValue;
    }

    public BaseEffect getTimeEffect() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mTimeEffect : (BaseEffect) invokeV.objValue;
    }

    public List<BaseEffect> getTransitionEffectList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mTransitionEffectList : (List) invokeV.objValue;
    }

    public BaseEffect remove(int i2) {
        InterceptResult invokeI;
        List<BaseEffect> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            if (i2 < 0 || (list = this.mMagicEffectList) == null || list.size() <= i2) {
                return null;
            }
            return this.mMagicEffectList.remove(i2);
        }
        return (BaseEffect) invokeI.objValue;
    }

    public void setMagicEffectList(List<BaseEffect> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.mMagicEffectList = list;
        }
    }

    public void setTimeEffect(BaseEffect baseEffect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, baseEffect) == null) {
            this.mTimeEffect = baseEffect;
        }
    }

    public void setTransitionEffectList(List<BaseEffect> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            this.mTransitionEffectList = list;
        }
    }
}
