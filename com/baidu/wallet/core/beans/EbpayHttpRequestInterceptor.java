package com.baidu.wallet.core.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.restnet.rest.RestHttpRequestInterceptor;
import com.baidu.apollon.restnet.rest.d;
import com.baidu.apollon.utils.Base64Utils;
import com.baidu.apollon.utils.PhoneUtils;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.base.datamodel.AccountManager;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.paysdk.PayUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class EbpayHttpRequestInterceptor implements RestHttpRequestInterceptor {

    /* renamed from: a  reason: collision with root package name */
    public static final String f24236a = "EbpayClientHttpRequestInterceptor";

    /* renamed from: b  reason: collision with root package name */
    public static final String f24237b = "wims";

    /* renamed from: c  reason: collision with root package name */
    public static final String f24238c = "wloc";

    /* renamed from: d  reason: collision with root package name */
    public static final String f24239d = "wssn";

    /* renamed from: e  reason: collision with root package name */
    public static final String f24240e = "cuid_1";

    /* renamed from: f  reason: collision with root package name */
    public static final String f24241f = "wmip";

    private void a(StringBuffer stringBuffer) {
        stringBuffer.append("BDUSS=");
        stringBuffer.append(WalletLoginHelper.getInstance().getLoginToken());
        stringBuffer.append(";");
        stringBuffer.append("OPENBDUSS=");
        stringBuffer.append(WalletLoginHelper.getInstance().getOpenLoginToken());
        LogUtil.d("EbpayClientHttpRequestInterceptor", "setToken():" + ((Object) stringBuffer));
    }

    @Override // com.baidu.apollon.restnet.rest.RestHttpRequestInterceptor
    public void intercept(Context context, d dVar) {
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
        dVar.a().a("Accept-Encoding", AsyncHttpClient.ENCODING_GZIP);
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
