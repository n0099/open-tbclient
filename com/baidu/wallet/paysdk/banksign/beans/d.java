package com.baidu.wallet.paysdk.banksign.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.dxmpay.apollon.armor.SecurePay;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.wallet.base.datamodel.UserData;
import com.dxmpay.wallet.core.beans.BaseBean;
import com.dxmpay.wallet.core.beans.NetworkBean;
import com.dxmpay.wallet.core.domain.DomainConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes10.dex */
public class d extends BaseBean<QueryResponse> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f59549a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Context context) {
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
        this.f59549a = null;
    }

    @Override // com.dxmpay.apollon.beans.ApollonBean
    public void execBean() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.execBean(QueryResponse.class);
        }
    }

    @Override // com.dxmpay.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        InterceptResult invokeV;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList arrayList = new ArrayList();
            DirectPayContentResponse payResponse = PayDataCache.getInstance().getPayResponse();
            if (payResponse != null) {
                UserData.SP sp = payResponse.sp;
                str2 = (sp == null || TextUtils.isEmpty(sp.serial_num)) ? null : payResponse.sp.serial_num;
                Map<String, String> map = payResponse.cashdesk;
                str = (map == null || map.isEmpty() || TextUtils.isEmpty(payResponse.cashdesk.get("session_no"))) ? null : payResponse.cashdesk.get("session_no");
            } else {
                str = null;
                str2 = null;
            }
            if (!TextUtils.isEmpty(str2)) {
                arrayList.add(new RestNameValuePair("serial_num", str2));
            }
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(new RestNameValuePair("precashier_session_no", str));
            }
            String b2 = com.baidu.wallet.paysdk.banksign.a.a.a().b();
            if (!TextUtils.isEmpty(b2)) {
                this.f59549a = b2;
            } else if (PayDataCache.getInstance().isFromPreCashier()) {
                this.f59549a = PayDataCache.getInstance().getSelectedCardNo();
            } else {
                CardData.BondCard selectCard = PayRequestCache.getInstance().getSelectCard();
                if (selectCard != null) {
                    this.f59549a = selectCard.account_no;
                }
            }
            if (!TextUtils.isEmpty(this.f59549a)) {
                arrayList.add(new RestNameValuePair("selected_card_no", this.f59549a));
            }
            String sessionId = NetworkBean.SessionCache.getInstance().getSessionId(null);
            if (!TextUtils.isEmpty(sessionId)) {
                arrayList.add(new RestNameValuePair("session_id", sessionId));
            }
            arrayList.add(new RestNameValuePair("sign_request_type", "1"));
            String encryptProxy = SecurePay.getInstance().encryptProxy(com.baidu.wallet.paysdk.banksign.a.a.a().l());
            String str3 = SecurePay.getInstance().getpwProxy();
            arrayList.add(new RestNameValuePair("agreement_trans_id", encryptProxy));
            arrayList.add(new RestNameValuePair("key", str3));
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.dxmpay.apollon.beans.ApollonBean
    public int getBeanId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? BankSignFactory.BEAN_ID_QUERY : invokeV.intValue;
    }

    @Override // com.dxmpay.apollon.beans.ApollonBean
    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return DomainConfig.getInstance().getAppPayHost() + "/cashdesk/wireless/banksign/query";
        }
        return (String) invokeV.objValue;
    }
}
