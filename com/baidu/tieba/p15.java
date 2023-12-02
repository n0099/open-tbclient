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
            arrayList.add(new pj7());
            arrayList.add(new kn7());
            arrayList.add(new c48());
            arrayList.add(new g48());
            arrayList.add(new k48());
            arrayList.add(new o48());
            arrayList.add(new s48());
            arrayList.add(new w48());
            arrayList.add(new a58());
            arrayList.add(new e58());
            arrayList.add(new ou9());
            arrayList.add(new tu9());
            arrayList.add(new yu9());
            arrayList.add(new i0b());
            return arrayList;
        }
        return invokeV.objValue;
    }
}
