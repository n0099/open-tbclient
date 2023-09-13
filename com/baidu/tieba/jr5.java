package com.baidu.tieba;

import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.data.TopNotifyData;
import com.baidu.tbadk.mutiprocess.toptip.TopNotifyEvent;
import com.baidu.tieba.yt6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class jr5 implements eq5<TopNotifyEvent> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements yt6.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(jr5 jr5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jr5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.yt6.e
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                YunDialogManager.unMarkShowingDialogName("topNotify");
            }
        }
    }

    public jr5() {
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
    public boolean onEvent(TopNotifyEvent topNotifyEvent) {
        InterceptResult invokeL;
        TopNotifyData topNotifyData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, topNotifyEvent)) == null) {
            if (topNotifyEvent != null && (topNotifyData = topNotifyEvent.topNotifyData) != null) {
                mg5.a.i(topNotifyData, new a(this));
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
