package com.baidu.tieba;

import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.fe4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public abstract class ya4<T> extends za4<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ya4() {
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

    public abstract void l(PMSAppInfo pMSAppInfo);

    public abstract void o(fe4.a aVar, PMSAppInfo pMSAppInfo, fc4 fc4Var);

    public abstract void p(PMSAppInfo pMSAppInfo, PMSAppInfo pMSAppInfo2);
}
