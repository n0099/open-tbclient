package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class ov9 implements ck1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ov9() {
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

    @Override // com.baidu.tieba.ck1
    public Object get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new mp7());
            arrayList.add(new np7());
            arrayList.add(new d58());
            arrayList.add(new fp8());
            arrayList.add(new gp8());
            arrayList.add(new hp8());
            arrayList.add(new ip8());
            arrayList.add(new kp8());
            arrayList.add(new sk9());
            arrayList.add(new uk9());
            arrayList.add(new vk9());
            arrayList.add(new wk9());
            arrayList.add(new wxa());
            arrayList.add(new xxa());
            return arrayList;
        }
        return invokeV.objValue;
    }
}
