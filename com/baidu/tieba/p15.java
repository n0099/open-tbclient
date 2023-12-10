package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class p15 implements pf1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public p15() {
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

    @Override // com.baidu.tieba.pf1
    public Object get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new iw6());
            arrayList.add(new qj7());
            arrayList.add(new ln7());
            arrayList.add(new d48());
            arrayList.add(new h48());
            arrayList.add(new l48());
            arrayList.add(new p48());
            arrayList.add(new t48());
            arrayList.add(new x48());
            arrayList.add(new b58());
            arrayList.add(new f58());
            arrayList.add(new pu9());
            arrayList.add(new uu9());
            arrayList.add(new zu9());
            arrayList.add(new j0b());
            return arrayList;
        }
        return invokeV.objValue;
    }
}
