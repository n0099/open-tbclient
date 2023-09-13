package com.baidu.tieba;

import android.content.DialogInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import tv.athena.revenue.payui.view.AbsViewEventHandler;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.dialog.CancelType;
/* loaded from: classes7.dex */
public class nhc implements tkc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public ahc c;
    public AbsViewEventHandler d;
    public IYYPayAmountView e;

    @Override // com.baidu.tieba.tkc
    public boolean b(DialogInterface dialogInterface, CancelType cancelType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dialogInterface, cancelType)) == null) {
            return false;
        }
        return invokeLL.booleanValue;
    }

    public nhc(int i, int i2, ahc ahcVar, AbsViewEventHandler absViewEventHandler, IYYPayAmountView iYYPayAmountView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), ahcVar, absViewEventHandler, iYYPayAmountView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        RLog.info("AmountDialogListener", "create AmountDialogListener appId:" + i + " userChannel:" + i2);
        this.a = i;
        this.b = i2;
        this.c = ahcVar;
        this.d = absViewEventHandler;
        this.e = iYYPayAmountView;
    }

    @Override // com.baidu.tieba.tkc
    public void a(CancelType cancelType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cancelType) == null) {
            RLog.info("AmountDialogListener", "PayAmountDialog notifyCancelType clickArea:" + cancelType);
            if (cancelType == CancelType.ON_DIALOG_DISMISS) {
                this.e.release();
            }
            this.c.g(cancelType, this.d);
            fic.a(this.a, this.b, cancelType);
        }
    }
}
