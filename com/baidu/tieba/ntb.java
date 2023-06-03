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
/* loaded from: classes7.dex */
public class ntb implements fwb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public Activity c;
    public vvb d;
    public AbsViewEventHandler e;
    public msb f;

    public ntb(int i, int i2, Activity activity, vvb vvbVar, AbsViewEventHandler absViewEventHandler, msb msbVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), activity, vvbVar, absViewEventHandler, msbVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        RLog.info("PayWayDialogListener", "create PayWayDialogListener appId:" + i + " userChannel:" + i2);
        this.a = i;
        this.b = i2;
        this.c = activity;
        this.d = vvbVar;
        this.e = absViewEventHandler;
        this.f = msbVar;
    }

    @Override // com.baidu.tieba.fwb
    public void a(CancelType cancelType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cancelType) == null) {
            RLog.info("PayWayDialogListener", "PayWayDialog notifyCancelType clickArea:" + cancelType);
            if (cancelType == CancelType.BUTTOM_AREA_CLICK) {
                this.d.a();
            }
            this.f.g(cancelType, this.e);
            rtb.b(this.a, this.b, cancelType);
        }
    }

    @Override // com.baidu.tieba.fwb
    public boolean b(DialogInterface dialogInterface, CancelType cancelType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dialogInterface, cancelType)) == null) {
            if (cancelType == CancelType.BUTTOM_AREA_CLICK && this.d.d()) {
                RLog.info("PayWayDialogListener", "PayWayDialog interceptDialogClose  ShowSplitOrderView clickArea:" + cancelType);
                return true;
            }
            return this.f.s(this.c, this.d, this.e);
        }
        return invokeLL.booleanValue;
    }
}
