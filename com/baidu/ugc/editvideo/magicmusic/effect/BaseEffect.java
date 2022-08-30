package com.baidu.ugc.editvideo.magicmusic.effect;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.magicmusic.EffectType;
import java.io.Serializable;
/* loaded from: classes6.dex */
public class BaseEffect implements Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TYPE_FILTER = 1;
    public static final int TYPE_PARTICLE = 3;
    public static final int TYPE_TIME = 2;
    public static final int TYPE_TRANSITION = 4;
    public transient /* synthetic */ FieldHolder $fh;
    public int baseType;
    public int duration;
    public EffectType effectType;
    public double endPercentage;
    public int endTime;
    public double startPercentage;
    public int startTime;

    public BaseEffect() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public Object clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                return super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
                return null;
            }
        }
        return invokeV.objValue;
    }
}
