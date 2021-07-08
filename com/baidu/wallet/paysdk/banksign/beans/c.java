package com.baidu.wallet.paysdk.banksign.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.datamodel.UserData;
import com.baidu.wallet.core.beans.NetworkBean;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.paysdk.banksign.datamodel.PollingResponse;
import com.baidu.wallet.paysdk.beans.PayBaseBean;
import com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class c extends PayBaseBean<PollingResponse> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context context) {
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
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.execBean(PollingResponse.class);
        }
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList arrayList = new ArrayList();
            String str2 = null;
            String sessionId = NetworkBean.SessionCache.getInstance().getSessionId(null);
            DirectPayContentResponse payResponse = PayDataCache.getInstance().getPayResponse();
            if (payResponse != null) {
                UserData.SP sp = payResponse.sp;
                String str3 = (sp == null || TextUtils.isEmpty(sp.serial_num)) ? null : payResponse.sp.serial_num;
                Map<String, String> map = payResponse.cashdesk;
                if (map != null && !map.isEmpty() && !TextUtils.isEmpty(payResponse.cashdesk.get("session_no"))) {
                    str2 = payResponse.cashdesk.get("session_no");
                }
                str = str2;
                str2 = str3;
            } else {
                str = null;
            }
            String encryptProxy = SafePay.getInstance().encryptProxy(com.baidu.wallet.paysdk.banksign.a.a.a().l());
            String str4 = SafePay.getInstance().getpwProxy();
            arrayList.add(new RestNameValuePair("agreement_trans_id", encryptProxy));
            arrayList.add(new RestNameValuePair("key", str4));
            if (!TextUtils.isEmpty(sessionId)) {
                arrayList.add(new RestNameValuePair("session_id", sessionId));
            }
            if (!TextUtils.isEmpty(str2)) {
                arrayList.add(new RestNameValuePair("serial_num", str2));
            }
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(new RestNameValuePair("precashier_session_no", str));
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getBeanId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return 769;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return DomainConfig.getInstance().getAppPayHost() + "/cashdesk/wireless/banksign/polling";
        }
        return (String) invokeV.objValue;
    }
}
