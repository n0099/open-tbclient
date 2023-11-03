package com.baidu.tieba;

import com.baidu.tbadk.switchs.BaiduBqtInitSwitch;
import com.baidu.tbadk.switchs.BaiduBqtPrivacySwitch;
import com.baidu.tbadk.switchs.CheckWebResProxySwitch;
import com.baidu.tbadk.switchs.GdtInitSwitch;
import com.baidu.tbadk.switchs.KsInitSwitch;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class ka implements lf1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ka() {
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

    @Override // com.baidu.tieba.lf1
    public Object get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new l25());
            arrayList.add(new yf5());
            arrayList.add(new ch5());
            arrayList.add(new BaiduBqtInitSwitch());
            arrayList.add(new BaiduBqtPrivacySwitch());
            arrayList.add(new CheckWebResProxySwitch());
            arrayList.add(new GdtInitSwitch());
            arrayList.add(new KsInitSwitch());
            arrayList.add(new e56());
            arrayList.add(new f56());
            arrayList.add(new dh6());
            arrayList.add(new eh6());
            arrayList.add(new fh6());
            arrayList.add(new vf8());
            arrayList.add(new wf8());
            arrayList.add(new u39());
            arrayList.add(new bfa());
            return arrayList;
        }
        return invokeV.objValue;
    }
}
