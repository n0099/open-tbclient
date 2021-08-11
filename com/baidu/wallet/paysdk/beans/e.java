package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.lbspay.channelpay.alipay.LBSPayAli;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.datamodel.PayData;
import com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class e extends f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public <T> e(Context context) {
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

    private boolean a(DirectPayContentResponse directPayContentResponse) {
        InterceptResult invokeL;
        PayData.DirectPayPay directPayPay;
        PayData.EasyPay easyPay;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, this, directPayContentResponse)) == null) ? (directPayContentResponse == null || (directPayPay = directPayContentResponse.pay) == null || (easyPay = directPayPay.easypay) == null || TextUtils.isEmpty(easyPay.getService())) ? false : true : invokeL.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.beans.f, com.dxmpay.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList arrayList = new ArrayList(super.generateRequestParam());
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if ("request_type".indexOf(((RestNameValuePair) it.next()).getName()) != -1) {
                    it.remove();
                }
            }
            arrayList.add(new RestNameValuePair("request_type", Constants.VIA_REPORT_TYPE_WPA_STATE));
            if (com.baidu.wallet.paysdk.a.b.a()) {
                DirectPayContentResponse payResponse = PayDataCache.getInstance().getPayResponse();
                if (a(payResponse)) {
                    arrayList.add(new RestNameValuePair("service", payResponse.pay.easypay.getService()));
                } else {
                    if (com.baidu.wallet.paysdk.a.b.c()) {
                        arrayList.add(new RestNameValuePair("service", LBSPayAli.ALI_AUTH_PAY));
                    }
                    if (com.baidu.wallet.paysdk.a.b.b()) {
                        arrayList.add(new RestNameValuePair("service", "authorize_pure"));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.wallet.paysdk.beans.f, com.dxmpay.apollon.beans.ApollonBean
    public int getBeanId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 17;
        }
        return invokeV.intValue;
    }
}
