package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class sh0 implements zi1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public sh0() {
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

    @Override // com.baidu.tieba.zi1
    public Object get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new xf0());
            arrayList.add(new yf0());
            arrayList.add(new zf0());
            arrayList.add(new ag0());
            arrayList.add(new bg0());
            arrayList.add(new cg0());
            arrayList.add(new eg0());
            arrayList.add(new zg0());
            arrayList.add(new sn0());
            arrayList.add(new tn0());
            arrayList.add(new zn0());
            arrayList.add(new l81());
            arrayList.add(new g91());
            arrayList.add(new wx5());
            return arrayList;
        }
        return invokeV.objValue;
    }
}
