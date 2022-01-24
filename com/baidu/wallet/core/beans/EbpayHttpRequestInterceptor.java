package com.baidu.wallet.core.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.restnet.rest.RestHttpRequestInterceptor;
import com.baidu.apollon.restnet.rest.d;
import com.baidu.apollon.utils.Base64Utils;
import com.baidu.apollon.utils.PhoneUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.base.datamodel.AccountManager;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.paysdk.PayUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes13.dex */
public class EbpayHttpRequestInterceptor implements RestHttpRequestInterceptor {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "EbpayClientHttpRequestInterceptor";

    /* renamed from: b  reason: collision with root package name */
    public static final String f50971b = "wims";

    /* renamed from: c  reason: collision with root package name */
    public static final String f50972c = "wloc";

    /* renamed from: d  reason: collision with root package name */
    public static final String f50973d = "wssn";

    /* renamed from: e  reason: collision with root package name */
    public static final String f50974e = "cuid_1";

    /* renamed from: f  reason: collision with root package name */
    public static final String f50975f = "wmip";
    public transient /* synthetic */ FieldHolder $fh;

    public EbpayHttpRequestInterceptor() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private void a(StringBuffer stringBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, stringBuffer) == null) {
            stringBuffer.append(BeanConstants.COOKIE_OPENBDUSS);
            stringBuffer.append("=");
            stringBuffer.append(WalletLoginHelper.getInstance().getOpenLoginToken());
            LogUtil.d("EbpayClientHttpRequestInterceptor", "setToken():" + ((Object) stringBuffer));
        }
    }

    @Override // com.baidu.apollon.restnet.rest.RestHttpRequestInterceptor
    public void intercept(Context context, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, dVar) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            a(stringBuffer);
            if (!TextUtils.isEmpty(AccountManager.getInstance(context).getBfbToken())) {
                stringBuffer.append(";");
                stringBuffer.append("token=");
                stringBuffer.append(AccountManager.getInstance(context).getBfbToken());
            }
            dVar.a().a("Cookie", stringBuffer.toString());
            LogUtil.i("EbpayClientHttpRequestInterceptor", "intercept. X_BAIDU_IE = " + dVar.e());
            dVar.a().a("X_BAIDU_IE", dVar.e());
            dVar.a().a("Accept-Encoding", "gzip");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("wims", "");
                jSONObject.put("wmip", PayUtils.encrypt("phone_number", PhoneUtils.getIpInfo()));
                jSONObject.put("wloc", PayUtils.encrypt("phone_number", PhoneUtils.getGPSLocation(context)));
                jSONObject.put("wssn", "");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            dVar.a().a("wcp", new String(Base64Utils.encode(jSONObject.toString().getBytes())));
        }
    }
}
