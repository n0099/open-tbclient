package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class w65 implements lk1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public w65() {
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

    @Override // com.baidu.tieba.lk1
    public Object get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new pz6());
            arrayList.add(new cu7());
            arrayList.add(new gu7());
            arrayList.add(new ku7());
            arrayList.add(new ou7());
            arrayList.add(new su7());
            arrayList.add(new wu7());
            arrayList.add(new av7());
            arrayList.add(new ev7());
            arrayList.add(new sh9());
            arrayList.add(new xh9());
            arrayList.add(new ci9());
            arrayList.add(new jda());
            arrayList.add(new hna());
            return arrayList;
        }
        return invokeV.objValue;
    }
}
