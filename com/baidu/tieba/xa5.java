package com.baidu.tieba;

import com.baidu.tbadk.core.view.spanGroup.DownKeyChecker;
import com.baidu.tbadk.data.PluginCheck;
import com.baidu.tbadk.data.WebViewWhitePageList;
import com.baidu.tbadk.tracker.LogUploadConfig;
import com.baidu.tieba.ei8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class xa5 implements mf1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public xa5() {
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

    @Override // com.baidu.tieba.mf1
    public Object get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new DownKeyChecker.a());
            arrayList.add(new PluginCheck.a());
            arrayList.add(new WebViewWhitePageList.a());
            arrayList.add(new LogUploadConfig());
            arrayList.add(new jc8());
            arrayList.add(new ei8.b());
            arrayList.add(new wb9());
            arrayList.add(new p4a());
            arrayList.add(new fra());
            return arrayList;
        }
        return invokeV.objValue;
    }
}
