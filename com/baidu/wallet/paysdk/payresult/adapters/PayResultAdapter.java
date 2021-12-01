package com.baidu.wallet.paysdk.payresult.adapters;

import android.os.Bundle;
import android.os.CountDownTimer;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.wallet.core.BaseActivity;
import java.lang.ref.WeakReference;
/* loaded from: classes12.dex */
public class PayResultAdapter extends BasePayResultAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public CountDownTimer f53529d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PayResultAdapter(BaseActivity baseActivity) {
        super(baseActivity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((BaseActivity) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new WeakReference<>(baseActivity);
    }

    @Override // com.baidu.wallet.paysdk.payresult.adapters.BasePayResultAdapter, com.baidu.wallet.paysdk.payresult.adapters.IPayResultDataAdapter
    public void handleOKBtnOnclick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            PayResultContent payResultContent = this.f53528c;
            if (payResultContent != null) {
                if (payResultContent.isPaySuccess) {
                    PayRequest payRequest = this.f53527b;
                    if (payRequest != null && BeanConstants.PAY_FROM_B_SAO_C.equals(payRequest.mPayFrom)) {
                        GlobalUtils.hideKeyboard(this.a.get().getActivity());
                        a(BeanConstants.EV_SCANCODE_EXIT, this.f53528c.notify);
                        return;
                    }
                    PayCallBackManager.callBackClientSuccess(this.a.get().getActivity(), this.f53528c.notify);
                    return;
                }
                PayCallBackManager.callBackClientPaying(this.a.get().getActivity());
                return;
            }
            PayCallBackManager.callBackClientPaying(this.a.get().getActivity());
        }
    }

    @Override // com.baidu.wallet.paysdk.payresult.adapters.BasePayResultAdapter, com.baidu.wallet.paysdk.payresult.adapters.IPayResultDataAdapter
    public boolean onCreateCheckInvalide(Bundle bundle) {
        InterceptResult invokeL;
        PayRequest payRequest;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle)) == null) {
            super.onCreateCheckInvalide(bundle);
            if (this.f53528c == null || (payRequest = this.f53527b) == null) {
                return false;
            }
            if (!BeanConstants.PAY_FROM_B_SAO_C.equals(payRequest.mPayFrom) || BaiduPay.getInstance().getScanCallback() == null) {
                return true;
            }
            CountDownTimer countDownTimer = this.f53529d;
            if (countDownTimer != null) {
                countDownTimer.cancel();
                this.f53529d = null;
            }
            CountDownTimer countDownTimer2 = new CountDownTimer(this, 3000L, 1000L) { // from class: com.baidu.wallet.paysdk.payresult.adapters.PayResultAdapter.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ PayResultAdapter a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r11, r13);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Long.valueOf(r11), Long.valueOf(r13)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super(((Long) objArr2[0]).longValue(), ((Long) objArr2[1]).longValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        GlobalUtils.hideKeyboard(this.a.a.get().getActivity());
                        PayResultAdapter payResultAdapter = this.a;
                        payResultAdapter.a(BeanConstants.EV_SCANCODE_EXIT, payResultAdapter.f53528c.notify);
                    }
                }

                @Override // android.os.CountDownTimer
                public void onTick(long j2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
                    }
                }
            };
            this.f53529d = countDownTimer2;
            countDownTimer2.start();
            return true;
        }
        return invokeL.booleanValue;
    }
}
