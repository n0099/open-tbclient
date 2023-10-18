package com.baidu.tieba;

import com.baidu.tbadk.core.view.spanGroup.DownKeyChecker;
import com.baidu.tbadk.data.PluginCheck;
import com.baidu.tbadk.tracker.LogUploadConfig;
import com.baidu.tieba.l28;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class x95 implements ue1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public x95() {
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
            arrayList.add(new DownKeyChecker.a());
            arrayList.add(new PluginCheck.a());
            arrayList.add(new LogUploadConfig());
            arrayList.add(new sw7());
            arrayList.add(new l28.b());
            arrayList.add(new gv8());
            arrayList.add(new nm9());
            arrayList.add(new g9a());
            return arrayList;
        }
        return invokeV.objValue;
    }
}
