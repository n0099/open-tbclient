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
/* loaded from: classes8.dex */
public class u9 implements ue1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public u9() {
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
            arrayList.add(new r15());
            arrayList.add(new pf5());
            arrayList.add(new BaiduBqtInitSwitch());
            arrayList.add(new BaiduBqtPrivacySwitch());
            arrayList.add(new CheckWebResProxySwitch());
            arrayList.add(new GdtInitSwitch());
            arrayList.add(new KsInitSwitch());
            arrayList.add(new k36());
            arrayList.add(new l36());
            arrayList.add(new if6());
            arrayList.add(new jf6());
            arrayList.add(new a38());
            arrayList.add(new b38());
            arrayList.add(new qq8());
            arrayList.add(new w1a());
            return arrayList;
        }
        return invokeV.objValue;
    }
}
