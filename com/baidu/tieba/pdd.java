package com.baidu.tieba;

import android.content.DialogInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.wcd;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import tv.athena.revenue.payui.view.dialog.CancelType;
/* loaded from: classes7.dex */
public class pdd implements rgd {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public wcd.a a;

    @Override // com.baidu.tieba.rgd
    public boolean b(DialogInterface dialogInterface, CancelType cancelType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dialogInterface, cancelType)) == null) {
            return false;
        }
        return invokeLL.booleanValue;
    }

    public pdd(wcd.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = aVar;
    }

    @Override // com.baidu.tieba.rgd
    public void a(CancelType cancelType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cancelType) == null) {
            RLog.info("PayConfirmDialogListener", "createConfirmFinishDialog cancel clickArea:" + cancelType);
            wcd.a aVar = this.a;
            if (aVar != null) {
                aVar.a(cancelType);
            }
        }
    }
}
