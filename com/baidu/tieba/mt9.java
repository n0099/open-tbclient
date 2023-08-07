package com.baidu.tieba;

import com.baidu.cyberplayer.sdk.context.CyberMediaContextDef;
import com.baidu.cyberplayer.sdk.context.ICyberGlobalOptions;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class mt9 extends CyberMediaContextDef {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public cu9 a;

    public mt9() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new cu9();
    }

    @Override // com.baidu.cyberplayer.sdk.context.CyberMediaContextDef, com.baidu.cyberplayer.sdk.context.ICyberMediaContext
    public ICyberGlobalOptions getCyberGlobalOptions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (ICyberGlobalOptions) invokeV.objValue;
    }
}
