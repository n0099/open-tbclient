package com.baidu.tieba;

import android.app.Activity;
import android.content.DialogInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import tv.athena.revenue.payui.view.AbsViewEventHandler;
import tv.athena.revenue.payui.view.dialog.CancelType;
/* loaded from: classes9.dex */
public class zhc implements tkc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity a;
    public AbsViewEventHandler b;
    public ahc c;
    public ikc d;

    @Override // com.baidu.tieba.tkc
    public boolean b(DialogInterface dialogInterface, CancelType cancelType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dialogInterface, cancelType)) == null) {
            return false;
        }
        return invokeLL.booleanValue;
    }

    public zhc(int i, int i2, Activity activity, AbsViewEventHandler absViewEventHandler, ahc ahcVar, ikc ikcVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), activity, absViewEventHandler, ahcVar, ikcVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = activity;
        this.b = absViewEventHandler;
        this.c = ahcVar;
        this.d = ikcVar;
    }

    @Override // com.baidu.tieba.tkc
    public void a(CancelType cancelType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cancelType) == null) {
            if (cancelType == CancelType.BUTTOM_AREA_CLICK) {
                this.d.a();
            }
            RLog.info("PayWayDialogListener", "PaySplitOrderDialog notifyCancelType clickArea:" + cancelType);
            this.c.g(cancelType, this.b);
        }
    }
}
