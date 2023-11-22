package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class re0 implements lf1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public re0() {
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

    @Override // com.baidu.tieba.lf1
    public Object get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new uc0());
            arrayList.add(new vc0());
            arrayList.add(new wc0());
            arrayList.add(new xc0());
            arrayList.add(new yc0());
            arrayList.add(new zc0());
            arrayList.add(new bd0());
            arrayList.add(new wd0());
            arrayList.add(new ei0());
            arrayList.add(new bl0());
            arrayList.add(new cl0());
            arrayList.add(new el0());
            arrayList.add(new ml0());
            arrayList.add(new u01());
            arrayList.add(new i41());
            arrayList.add(new k61());
            arrayList.add(new g26());
            return arrayList;
        }
        return invokeV.objValue;
    }
}
