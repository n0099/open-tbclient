package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse;
import com.baidu.wallet.paysdk.datamodel.DirectPayErrorContent;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.fingerprint.WalletFingerprint;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.wallet.core.beans.BaseBean;
import com.dxmpay.wallet.core.domain.DomainConfig;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.StatHelper;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes10.dex */
public class s extends BaseBean<DirectPayContentResponse> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PayRequest f60531a;

    /* renamed from: b  reason: collision with root package name */
    public String f60532b;

    /* renamed from: c  reason: collision with root package name */
    public String f60533c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public <T> s(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f60531a = null;
        this.f60532b = null;
        this.f60533c = null;
        this.f60531a = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.f60532b = str;
        }
    }

    @Override // com.dxmpay.apollon.beans.ApollonBean
    public void execBean() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (BeanConstants.API_GET_PAY_ORDER.equals(this.f60533c)) {
                List<String> collectData = StatHelper.collectData(StatHelper.getOrderNo(), StatHelper.getSpNo());
                HashMap hashMap = new HashMap();
                hashMap.put("sp_no", StatHelper.getSpNo());
                hashMap.put("pay_amount", StatHelper.getPayAmount());
                StatisticManager.onEventWithValues(PayStatServiceEvent.PAY_ORDER_COLLATION, collectData, hashMap);
            }
            super.execBean(DirectPayContentResponse.class, DirectPayErrorContent.class);
        }
    }

    @Override // com.dxmpay.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.dxmpay.apollon.beans.ApollonBean
    public int getBeanId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.dxmpay.apollon.beans.ApollonBean
    public String getEncode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "gbk" : (String) invokeV.objValue;
    }

    @Override // com.dxmpay.apollon.beans.ApollonBean
    public int getHttpMethod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.dxmpay.apollon.beans.ApollonBean
    public String getUrl() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            this.f60533c = BeanConstants.API_GET_PAY_ORDER;
            if (this.f60531a.hasCashDeskCode()) {
                this.f60533c = BeanConstants.API_GET_PAY_ORDER_PREPAY;
            } else if (BaiduPay.PAY_FROM_HUA_ZHUAN_ZHANG.equals(this.f60531a.getPayFrom())) {
                this.f60533c = BeanConstants.API_GET_PAY_ORDER_TRANSFER;
            } else if (BaiduPay.PAY_FROM_HUA_FEI.equals(this.f60531a.getPayFrom())) {
                this.f60533c = BeanConstants.API_GET_PAY_ORDER_CHARGE;
            } else if (BaiduPay.PAY_FROM_BIND_CARD.equals(this.f60531a.getPayFrom())) {
                this.f60533c = BeanConstants.API_CARD_ADD;
            } else if (BaiduPay.PAY_FROM_AUTHORIZE.equals(this.f60531a.getPayFrom())) {
                this.f60533c = BeanConstants.API_AUTHORIZE_ORDER;
            } else if (PayDataCache.getInstance().isFromPreCashier()) {
                this.f60533c = BeanConstants.API_GET_PRE_PAY_ORDER;
            }
            if (PayDataCache.getInstance().isFromPreCashier()) {
                str = DomainConfig.getInstance().getAppPayHost() + this.f60533c + "?" + this.f60531a.mParams + "&" + this.f60532b;
            } else {
                str = DomainConfig.getInstance().getAppPayHost() + this.f60533c + "?" + this.f60531a.mParams;
            }
            if (WalletFingerprint.getInstance(this.mContext).hasEnrollFingerprint()) {
                str = str + "&enroll_fingerprint=1";
            }
            if (TextUtils.isEmpty(this.f60531a.mSecurityParams)) {
                return str;
            }
            return str + "&security_sdk_param=" + this.f60531a.mSecurityParams;
        }
        return (String) invokeV.objValue;
    }
}
