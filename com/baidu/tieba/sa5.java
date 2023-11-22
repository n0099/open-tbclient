package com.baidu.tieba;

import com.baidu.tbadk.core.view.spanGroup.DownKeyChecker;
import com.baidu.tbadk.data.PluginCheck;
import com.baidu.tbadk.tracker.LogUploadConfig;
import com.baidu.tieba.hf8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class sa5 implements lf1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public sa5() {
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
            arrayList.add(new DownKeyChecker.a());
            arrayList.add(new PluginCheck.a());
            arrayList.add(new LogUploadConfig());
            arrayList.add(new o98());
            arrayList.add(new hf8.b());
            arrayList.add(new l89());
            arrayList.add(new tz9());
            arrayList.add(new mma());
            return arrayList;
        }
        return invokeV.objValue;
    }
}
