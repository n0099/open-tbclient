package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.mutiprocess.share.ShareToastEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class pn5 implements om5<ShareToastEvent> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public pn5() {
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
    @Override // com.baidu.tieba.om5
    /* renamed from: a */
    public boolean onEvent(ShareToastEvent shareToastEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, shareToastEvent)) == null) {
            if (!TbadkCoreApplication.getInst().isMainProcess(true) || shareToastEvent == null) {
                return false;
            }
            BdToast makeText = BdToast.makeText(TbadkCoreApplication.getInst(), shareToastEvent.getToastStr());
            if (shareToastEvent.getToastIcon() != null) {
                makeText.setIcon(shareToastEvent.getToastIcon());
            }
            makeText.show();
            return true;
        }
        return invokeL.booleanValue;
    }
}
