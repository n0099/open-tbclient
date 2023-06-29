package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class zj0 implements gl1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public zj0() {
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

    @Override // com.baidu.tieba.gl1
    public Object get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new ei0());
            arrayList.add(new fi0());
            arrayList.add(new gi0());
            arrayList.add(new hi0());
            arrayList.add(new ii0());
            arrayList.add(new ji0());
            arrayList.add(new li0());
            arrayList.add(new gj0());
            arrayList.add(new zp0());
            arrayList.add(new aq0());
            arrayList.add(new gq0());
            arrayList.add(new sa1());
            arrayList.add(new nb1());
            arrayList.add(new c66());
            return arrayList;
        }
        return invokeV.objValue;
    }
}
