package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class k1a implements lk1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public k1a() {
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
            arrayList.add(new qs7());
            arrayList.add(new rs7());
            arrayList.add(new k88());
            arrayList.add(new gu8());
            arrayList.add(new hu8());
            arrayList.add(new iu8());
            arrayList.add(new ju8());
            arrayList.add(new lu8());
            arrayList.add(new oq9());
            arrayList.add(new qq9());
            arrayList.add(new rq9());
            arrayList.add(new sq9());
            arrayList.add(new v6b());
            arrayList.add(new w6b());
            return arrayList;
        }
        return invokeV.objValue;
    }
}
