package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class vx9 implements ue1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public vx9() {
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

    @Override // com.baidu.tieba.ue1
    public Object get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new an7());
            arrayList.add(new bn7());
            arrayList.add(new x28());
            arrayList.add(new eq8());
            arrayList.add(new fq8());
            arrayList.add(new gq8());
            arrayList.add(new hq8());
            arrayList.add(new jq8());
            arrayList.add(new ym9());
            arrayList.add(new an9());
            arrayList.add(new bn9());
            arrayList.add(new cn9());
            arrayList.add(new i3b());
            arrayList.add(new j3b());
            return arrayList;
        }
        return invokeV.objValue;
    }
}
