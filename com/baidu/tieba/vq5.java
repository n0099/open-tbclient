package com.baidu.tieba;

import com.baidu.tbadk.data.HotEventData;
import com.baidu.tbadk.mutiprocess.hotevent.HotEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class vq5 implements eq5<HotEvent> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public vq5() {
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
    @Override // com.baidu.tieba.eq5
    /* renamed from: a */
    public boolean onEvent(HotEvent hotEvent) {
        InterceptResult invokeL;
        HotEventData hotEventData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, hotEvent)) == null) {
            if (hotEvent != null && (hotEventData = hotEvent.hotEventData) != null) {
                eg5.u(hotEventData);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
