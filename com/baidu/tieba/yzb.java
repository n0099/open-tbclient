package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.n2c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.PayCallBackBean;
import com.yy.mobile.framework.revenuesdk.baseapi.PurchaseStatus;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
/* loaded from: classes8.dex */
public class yzb implements IPayCallback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public IPayCallback<CurrencyChargeMessage> c;
    public Activity d;
    public Dialog e;
    public g2c f;
    public izb g;
    public a1c h;
    public n2c.b i;
    public ezb j;
    public w0c k;

    public yzb(int i, int i2, IPayCallback<CurrencyChargeMessage> iPayCallback, Activity activity, Dialog dialog, g2c g2cVar, izb izbVar, a1c a1cVar, n2c.b bVar, ezb ezbVar, w0c w0cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), iPayCallback, activity, dialog, g2cVar, izbVar, a1cVar, bVar, ezbVar, w0cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        RLog.info("PayInternalCallback", "create PayInternalCallback appId:" + i + " userChannel:" + i2);
        this.a = i;
        this.b = i2;
        this.c = iPayCallback;
        this.d = activity;
        this.e = dialog;
        this.f = g2cVar;
        this.g = izbVar;
        this.h = a1cVar;
        this.i = bVar;
        this.j = ezbVar;
        this.k = w0cVar;
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
    public void onFail(int i, String str, PayCallBackBean payCallBackBean) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, payCallBackBean) == null) {
            RLog.info("PayInternalCallback", "requestPayInternal onFail code:" + i + " failReason:" + str + " payCallBackBean:" + payCallBackBean);
            IPayCallback<CurrencyChargeMessage> iPayCallback = this.c;
            if (iPayCallback != null) {
                iPayCallback.onFail(i, str, payCallBackBean);
            }
            this.j.e(i, str, payCallBackBean);
            e1c.b(this.a, this.b, i, str);
            this.g.i(i, str, this.d, this.e, this.f, this.i, this.k, this.h, payCallBackBean, this.c);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IPayCallback
    public void onPayStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            RLog.info("PayInternalCallback", "requestPayInternal onPayStart");
            IPayCallback<CurrencyChargeMessage> iPayCallback = this.c;
            if (iPayCallback != null) {
                iPayCallback.onPayStart();
            }
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.IPayCallback
    public void onPayStatus(PurchaseStatus purchaseStatus, PayCallBackBean payCallBackBean) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, purchaseStatus, payCallBackBean) == null) {
            RLog.info("PayInternalCallback", "requestPayInternal onPayStatus code " + purchaseStatus.getCode() + " msg: " + purchaseStatus.getMessage());
            this.g.f(this.d, this.e, this.f, purchaseStatus);
            IPayCallback<CurrencyChargeMessage> iPayCallback = this.c;
            if (iPayCallback != null) {
                iPayCallback.onPayStatus(purchaseStatus, payCallBackBean);
            }
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
    public void onSuccess(Object obj, PayCallBackBean payCallBackBean) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, obj, payCallBackBean) == null) {
            RLog.info("PayInternalCallback", "requestPayInternal onSuccess");
            this.g.o(this.d, this.h, this.e, this.f);
        }
    }
}
