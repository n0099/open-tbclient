package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.paysdk.datamodel.ErrorContentResponse;
import com.baidu.wallet.paysdk.datamodel.VerifyByBankResponse;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class ag extends PayBaseBean<VerifyByBankResponse> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f26126a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final List f26127b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1519457068, "Lcom/baidu/wallet/paysdk/beans/ag;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1519457068, "Lcom/baidu/wallet/paysdk/beans/ag;");
                return;
            }
        }
        f26126a = new String[]{"coupon_id", "activity_id", "stage_number", "need_bind_card", "sms_vcode", "seed", "mobile_pwd", "confirm_mobile_pwd", "mobile_pwd_psp", "open_passfree", "fp_code", "fp_num", "need_open_passfree", "need_open_authorize", "message_vcode", "is_pay_sms"};
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ag(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f26127b = Arrays.asList(f26126a);
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.execBean(VerifyByBankResponse.class, ErrorContentResponse.class);
        }
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList arrayList = new ArrayList(PayDataCache.getInstance().getPrePayRequestParams());
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (this.f26127b.indexOf(((RestNameValuePair) it.next()).getName()) != -1) {
                    it.remove();
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getBeanId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? PayBeanFactory.BEAN_ID_SEND_SMS_FOR_VERIFY_BY_BANK : invokeV.intValue;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return DomainConfig.getInstance().getAppPayHost() + BeanConstants.API_APPLY_VERIFY_SMS_BY_BANK;
        }
        return (String) invokeV.objValue;
    }
}
