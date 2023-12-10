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
public class la implements pf1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public la() {
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
            arrayList.add(new b5());
            arrayList.add(new r25());
            arrayList.add(new m35());
            arrayList.add(new ig5());
            arrayList.add(new mh5());
            arrayList.add(new BaiduBqtInitSwitch());
            arrayList.add(new BaiduBqtPrivacySwitch());
            arrayList.add(new CheckWebResProxySwitch());
            arrayList.add(new GdtInitSwitch());
            arrayList.add(new KsInitSwitch());
            arrayList.add(new r56());
            arrayList.add(new s56());
            arrayList.add(new qh6());
            arrayList.add(new rh6());
            arrayList.add(new sh6());
            arrayList.add(new yi8());
            arrayList.add(new zi8());
            arrayList.add(new j79());
            arrayList.add(new aka());
            return arrayList;
        }
        return invokeV.objValue;
    }
}
