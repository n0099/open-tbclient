package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.CardAddErrorContent;
import com.baidu.wallet.paysdk.datamodel.CardAddResponse;
import com.baidu.wallet.paysdk.fingerprint.WalletFingerprint;
import com.dxmpay.apollon.beans.BeanResponseBase;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.wallet.core.beans.BaseBean;
import com.dxmpay.wallet.core.beans.NetworkBean;
import com.dxmpay.wallet.core.domain.DomainConfig;
import com.dxmpay.wallet.utils.JsonUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
/* loaded from: classes13.dex */
public class e extends BaseBean<CardAddResponse> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public BindFastRequest f53991b;

    /* renamed from: c  reason: collision with root package name */
    public Context f53992c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(Context context) {
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
        this.a = null;
        this.f53991b = null;
        this.f53992c = context;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.a = str;
        }
    }

    @Override // com.dxmpay.apollon.beans.ApollonBean
    public void execBean() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.execBean(CardAddResponse.class, CardAddErrorContent.class);
        }
    }

    @Override // com.dxmpay.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        InterceptResult invokeV;
        List<RestNameValuePair> json2KeyValuePairs;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f53991b != null) {
                if (TextUtils.isEmpty(this.a)) {
                    json2KeyValuePairs = new ArrayList<>();
                } else {
                    json2KeyValuePairs = JsonUtil.json2KeyValuePairs(this.a);
                    if (json2KeyValuePairs == null) {
                        json2KeyValuePairs = new ArrayList<>();
                    }
                    ListIterator<RestNameValuePair> listIterator = json2KeyValuePairs.listIterator();
                    while (listIterator.hasNext()) {
                        RestNameValuePair next = listIterator.next();
                        if (next != null && "source_flag".equals(next.getName())) {
                            listIterator.remove();
                        }
                    }
                }
                String str = WalletFingerprint.getInstance(this.f53992c).isDevicesSupport() ? "1" : "0";
                String str2 = WalletFingerprint.getInstance(this.f53992c).hasEnrollFingerprint() ? "1" : "0";
                json2KeyValuePairs.add(new RestNameValuePair("device_support", str));
                json2KeyValuePairs.add(new RestNameValuePair("enroll_fingerprint", str2));
                json2KeyValuePairs.add(new RestNameValuePair("verify_type", "2"));
                json2KeyValuePairs.add(new RestNameValuePair("source_flag", "3"));
                json2KeyValuePairs.add(new RestNameValuePair("is_new_version", "1"));
                return json2KeyValuePairs;
            }
            throw new IllegalStateException("not call setBindRequest(req) method or param(req) null");
        }
        return (List) invokeV.objValue;
    }

    @Override // com.dxmpay.apollon.beans.ApollonBean
    public int getBeanId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? PayBeanFactory.BEAN_ID_CARD_ADD : invokeV.intValue;
    }

    @Override // com.dxmpay.apollon.beans.ApollonBean
    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return DomainConfig.getInstance().getAppPayHost() + BeanConstants.API_CARD_ADD;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.dxmpay.wallet.core.beans.BaseBean
    public void handleSession(BeanResponseBase.Session session) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, session) == null) {
            BindFastRequest bindFastRequest = this.f53991b;
            if (bindFastRequest != null) {
                bindFastRequest.saveSession(session);
            } else {
                NetworkBean.SessionCache.getInstance().put(null, session);
            }
        }
    }

    public void a(BindFastRequest bindFastRequest) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bindFastRequest) == null) {
            this.f53991b = bindFastRequest;
        }
    }

    public BindFastRequest a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f53991b : (BindFastRequest) invokeV.objValue;
    }
}
