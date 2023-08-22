package com.baidu.tieba;

import com.baidu.tbadk.mutiprocess.write.NewWritePageStateEvent;
import com.baidu.tieba.tbadkCore.writeModel.WriteMsgHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class rq5 implements lp5<NewWritePageStateEvent> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public rq5() {
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
    @Override // com.baidu.tieba.lp5
    /* renamed from: a */
    public boolean onEvent(NewWritePageStateEvent newWritePageStateEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, newWritePageStateEvent)) == null) {
            if (newWritePageStateEvent == null) {
                return false;
            }
            WriteMsgHolder.isH5PageShowing = newWritePageStateEvent.isShowing;
            return true;
        }
        return invokeL.booleanValue;
    }
}
