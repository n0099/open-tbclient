package com.baidu.tieba;

import com.baidu.tbadk.switchs.CheckWebResProxySwitch;
import com.baidu.tbadk.switchs.CsjInitSwitch;
import com.baidu.tbadk.switchs.GdtInitSwitch;
import com.baidu.tbadk.switchs.KsInitSwitch;
import com.baidu.tbadk.switchs.PicCaptureModeSwitch;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class ve implements hk1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ve() {
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

    @Override // com.baidu.tieba.hk1
    public Object get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new mk5());
            arrayList.add(new CheckWebResProxySwitch());
            arrayList.add(new CsjInitSwitch());
            arrayList.add(new GdtInitSwitch());
            arrayList.add(new KsInitSwitch());
            arrayList.add(new PicCaptureModeSwitch());
            arrayList.add(new xj6());
            arrayList.add(new yj6());
            arrayList.add(new lt8());
            arrayList.add(new dx8());
            arrayList.add(new ex8());
            arrayList.add(new fx8());
            arrayList.add(new u3a());
            return arrayList;
        }
        return invokeV.objValue;
    }
}
