package com.baidu.ugc.editvideo.magicmusic;

import c.a.v0.t.h;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.magicmusic.effect.BaseEffect;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class EffectUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public EffectUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void addEffect(BaseEffect baseEffect, List<BaseEffect> list) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, baseEffect, list) == null) || baseEffect == null || list == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (BaseEffect baseEffect2 : list) {
            int i4 = baseEffect2.startTime;
            int i5 = baseEffect.startTime;
            if (i4 > i5 || (i3 = baseEffect2.endTime) < i5) {
                int i6 = baseEffect2.startTime;
                if (i6 > baseEffect.startTime && i6 < (i2 = baseEffect.endTime)) {
                    if (baseEffect2.effectType != baseEffect.effectType) {
                        if (baseEffect2.endTime > i2) {
                            baseEffect2 = (BaseEffect) baseEffect2.clone();
                            baseEffect2.startTime = baseEffect.endTime;
                        }
                    } else if (baseEffect2.endTime > i2) {
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
                baseEffect.startTime = i4;
                if (i3 > baseEffect.endTime) {
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

    public static BaseEffect getEffectInList(int i2, List<BaseEffect> list) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65538, null, i2, list)) == null) {
            if (h.e(list)) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                BaseEffect baseEffect = list.get(size);
                if (baseEffect.startTime <= i2 && baseEffect.endTime >= i2) {
                    return baseEffect;
                }
            }
            return null;
        }
        return (BaseEffect) invokeIL.objValue;
    }
}
