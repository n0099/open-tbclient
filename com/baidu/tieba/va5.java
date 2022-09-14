package com.baidu.tieba;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.mutiprocess.soloader.SoLoaderEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public class va5 implements u95<SoLoaderEvent> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public va5() {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.u95
    /* renamed from: a */
    public boolean onEvent(SoLoaderEvent soLoaderEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, soLoaderEvent)) == null) {
            if (soLoaderEvent == null || StringUtils.isNull(soLoaderEvent.name)) {
                return false;
            }
            if (wm.a(BdBaseApplication.getInst().getContext(), um.a(soLoaderEvent.name))) {
                ConcurrentHashMap<String, String> resHashMap = BdBaseApplication.getInst().getResHashMap();
                String str = soLoaderEvent.name;
                resHashMap.put(str, um.a(str));
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
