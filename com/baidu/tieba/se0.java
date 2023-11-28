package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class se0 implements mf1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public se0() {
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

    @Override // com.baidu.tieba.mf1
    public Object get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new vc0());
            arrayList.add(new wc0());
            arrayList.add(new xc0());
            arrayList.add(new yc0());
            arrayList.add(new zc0());
            arrayList.add(new ad0());
            arrayList.add(new cd0());
            arrayList.add(new xd0());
            arrayList.add(new fi0());
            arrayList.add(new cl0());
            arrayList.add(new dl0());
            arrayList.add(new fl0());
            arrayList.add(new nl0());
            arrayList.add(new v01());
            arrayList.add(new j41());
            arrayList.add(new l61());
            arrayList.add(new n26());
            return arrayList;
        }
        return invokeV.objValue;
    }
}
