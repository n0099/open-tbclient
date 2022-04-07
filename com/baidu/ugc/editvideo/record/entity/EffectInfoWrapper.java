package com.baidu.ugc.editvideo.record.entity;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.List;
/* loaded from: classes4.dex */
public class EffectInfoWrapper implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TYPE_BLOCKBUSTER = 0;
    public static final int TYPE_KSONG_MUSIC = 2;
    public static final int TYPE_STICKING_POINT = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public List<EffectInfo> data;
    public String name;
    public int type;

    public EffectInfoWrapper() {
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
}
