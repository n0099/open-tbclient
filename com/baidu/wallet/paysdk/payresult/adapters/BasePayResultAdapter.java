package com.baidu.wallet.paysdk.payresult.adapters;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.a.b;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.dxmpay.apollon.eventbus.EventBus;
import com.dxmpay.wallet.core.BaseActivity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes13.dex */
public class BasePayResultAdapter implements IPayResultDataAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public WeakReference<BaseActivity> a;

    /* renamed from: b  reason: collision with root package name */
    public PayRequest f54107b;

    /* renamed from: c  reason: collision with root package name */
    public PayResultContent f54108c;
    public HashMap<String, String> contents;

    public BasePayResultAdapter(BaseActivity baseActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.contents = new HashMap<>();
        this.a = new WeakReference<>(baseActivity);
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            EventBus eventBus = EventBus.getInstance();
            eventBus.getClass();
            EventBus.getInstance().post(new EventBus.Event(eventBus, str, null));
        }
    }

    @Override // com.baidu.wallet.paysdk.payresult.adapters.IPayResultDataAdapter
    public void clearDataOnDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            PayDataCache.getInstance().setPayReslutContent(null);
        }
    }

    @Override // com.baidu.wallet.paysdk.payresult.adapters.IPayResultDataAdapter
    public String getActionBarTextId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.paysdk.payresult.adapters.IPayResultDataAdapter
    public String getAuthorizeMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f54108c.authorize_msg : (String) invokeV.objValue;
    }

    public ArrayList<String> getCouponContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            PayResultContent payResultContent = this.f54108c;
            if (payResultContent == null || TextUtils.isEmpty(payResultContent.coupon_msg)) {
                return null;
            }
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(this.f54108c.coupon_msg);
            arrayList.add(this.f54108c.coupon_find_prompt);
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    @Override // com.baidu.wallet.paysdk.payresult.adapters.IPayResultDataAdapter
    public ArrayList<String> getEventValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            PayRequest payRequest = this.f54107b;
            arrayList.add(payRequest != null ? payRequest.mSpNO : "");
            PayRequest payRequest2 = this.f54107b;
            arrayList.add(payRequest2 != null ? payRequest2.mOrderNo : "");
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    @Override // com.baidu.wallet.paysdk.payresult.adapters.IPayResultDataAdapter
    public String getExpectedTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    public String getFpOpenMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f54108c.fp_open_or_update_msg : (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.paysdk.payresult.adapters.IPayResultDataAdapter
    public String getLBSPayText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? isShowLBSPayText() ? this.f54107b.mRemotePayHostName : "" : (String) invokeV.objValue;
    }

    public ArrayList<String> getOKBtnOnClickEventValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            PayRequest payRequest = this.f54107b;
            arrayList.add(payRequest != null ? payRequest.mSpNO : "");
            PayRequest payRequest2 = this.f54107b;
            arrayList.add(payRequest2 != null ? payRequest2.mOrderNo : "");
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    @Override // com.baidu.wallet.paysdk.payresult.adapters.IPayResultDataAdapter
    public PayResultContent getPayResultContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f54108c : (PayResultContent) invokeV.objValue;
    }

    @Override // com.baidu.wallet.paysdk.payresult.adapters.IPayResultDataAdapter
    public HashMap<String, String> getPaySuccessContents() {
        InterceptResult invokeV;
        PayRequest payRequest;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            this.contents.clear();
            PayResultContent payResultContent = this.f54108c;
            if (payResultContent == null || (payRequest = this.f54107b) == null) {
                return null;
            }
            if (payResultContent.isPaySuccess) {
                if (!TextUtils.isEmpty(payRequest.withholding_auth) && this.f54107b.withholding_auth.equals("1")) {
                    this.contents.put("mainTip", "dxm_wallet_withhold_success");
                } else {
                    this.contents.put("mainTip", "ebpay_pay_success");
                }
                this.contents.put("statusDrawableName", "wallet_base_result_main_success");
                this.contents.put("okBtnText", "dxm_ebpay_result_btn_success");
                this.contents.put("payDetailInfo", this.f54108c.pay_detail_info);
            }
            return this.contents;
        }
        return (HashMap) invokeV.objValue;
    }

    @Override // com.baidu.wallet.paysdk.payresult.adapters.IPayResultDataAdapter
    public HashMap<String, String> getPayingContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            this.contents.clear();
            PayResultContent payResultContent = this.f54108c;
            if (payResultContent == null || this.f54107b == null) {
                return null;
            }
            if (!payResultContent.isPaySuccess) {
                this.contents.put("statusDrawableName", "dxm_wallet_base_result_paying");
                this.contents.put("mainTip", b.a() ? "ebpay_sign_paying" : "ebpay_pay_paying");
                this.contents.put("errorMsg", this.f54108c.mErrorMsg);
            }
            return this.contents;
        }
        return (HashMap) invokeV.objValue;
    }

    @Override // com.baidu.wallet.paysdk.payresult.adapters.IPayResultDataAdapter
    public void handleOKBtnOnclick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
        }
    }

    @Override // com.baidu.wallet.paysdk.payresult.adapters.IPayResultDataAdapter
    public boolean isBelongPaySdk() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.payresult.adapters.IPayResultDataAdapter
    public boolean isPaySuccess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            PayResultContent payResultContent = this.f54108c;
            if (payResultContent == null || this.f54107b == null) {
                return false;
            }
            return payResultContent.isPaySuccess;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.payresult.adapters.IPayResultDataAdapter
    public boolean isShowLBSPayText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? PayDataCache.getInstance().isRemotePay() && !TextUtils.isEmpty(this.f54107b.mRemotePayHostName) : invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.payresult.adapters.IPayResultDataAdapter
    public boolean onCreateCheckInvalide(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, bundle)) == null) {
            if (bundle != null) {
                this.f54108c = (PayResultContent) bundle.getSerializable("mPayModle");
                this.f54107b = (PayRequest) bundle.getSerializable("mPayRequest");
                return true;
            }
            this.f54108c = PayDataCache.getInstance().getPayStateContent();
            this.f54107b = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.payresult.adapters.IPayResultDataAdapter
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bundle) == null) {
            PayResultContent payResultContent = this.f54108c;
            if (payResultContent != null) {
                bundle.putSerializable("mPayModle", payResultContent);
            }
            PayRequest payRequest = this.f54107b;
            if (payRequest != null) {
                bundle.putSerializable("mPayRequest", payRequest);
            }
        }
    }

    public boolean showCashbackDetail() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            PayResultContent payResultContent = this.f54108c;
            return (payResultContent == null || payResultContent.payResultCashbackDetail == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean showMonkeylayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            PayResultContent payResultContent = this.f54108c;
            if (payResultContent != null) {
                if (TextUtils.isEmpty(payResultContent.total_amount) && TextUtils.isEmpty(this.f54108c.cash_amount) && TextUtils.isEmpty(this.f54108c.discount_amount)) {
                    String[][] strArr = this.f54108c.paytype_info;
                    return strArr != null && strArr.length > 0;
                }
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.payresult.adapters.IPayResultDataAdapter
    public boolean showResultPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            PayResultContent payResultContent = this.f54108c;
            return (payResultContent == null || "0".equalsIgnoreCase(payResultContent.redirect_sp_succpage_remain_time)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            EventBus eventBus = EventBus.getInstance();
            eventBus.getClass();
            EventBus.getInstance().post(new EventBus.Event(eventBus, str, str2));
        }
    }
}
