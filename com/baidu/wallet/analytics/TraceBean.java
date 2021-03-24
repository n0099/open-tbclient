package com.baidu.wallet.analytics;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.apollon.restnet.converter.b;
import com.baidu.apollon.restnet.rest.RestHttpRequestInterceptor;
import com.baidu.apollon.restnet.rest.d;
import com.baidu.apollon.utils.Md5Utils;
import com.baidu.apollon.utils.PhoneUtils;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.core.beans.BaseBean;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class TraceBean extends BaseBean {
    public static final String SALT = "0B4rMozbYb^R2pN04QwGa*JkTxA9EmQ5";
    public static String sBaiduCUIDHash = "";
    public static String sCUIDHash = "";
    public static String sUnionIdHash = "";
    public String mHttpMethod;
    public List<RestNameValuePair> mParams;

    /* loaded from: classes5.dex */
    public class CustomInterceptors implements RestHttpRequestInterceptor {
        public CustomInterceptors() {
        }

        @Override // com.baidu.apollon.restnet.rest.RestHttpRequestInterceptor
        public void intercept(Context context, d dVar) {
            if (!TextUtils.isEmpty(TraceBean.sUnionIdHash)) {
                dVar.a().b("Cookie", "unionIdHash=" + TraceBean.sUnionIdHash);
            }
            dVar.a().b("Cookie", "cuidHash=" + TraceBean.sCUIDHash);
            dVar.a().b("Cookie", "baiducuidHash=" + TraceBean.sBaiduCUIDHash);
            List<String> list = dVar.a().get("Cookie");
            String str = "";
            for (int i = 0; i < list.size(); i++) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(list.get(i).endsWith(";") ? "" : ";" + list.get(i));
                str = sb.toString();
            }
            dVar.a().a("Cookie", str.substring(1));
        }
    }

    public TraceBean(Context context) {
        super(context);
        this.mHttpMethod = "GET";
        if (TextUtils.isEmpty(sCUIDHash)) {
            sCUIDHash = Md5Utils.toMD5(PhoneUtils.getCUID(context) + SALT, "UTF-8");
        }
        if (TextUtils.isEmpty(sBaiduCUIDHash)) {
            sBaiduCUIDHash = Md5Utils.toMD5(PhoneUtils.getCUID2(context) + SALT, "UTF-8");
        }
        if (WalletLoginHelper.getInstance().isLogin()) {
            sUnionIdHash = Md5Utils.toMD5(WalletLoginHelper.getInstance().getUnionId() + SALT, "UTF-8");
        }
    }

    public TraceBean buildParams(List<RestNameValuePair> list, String str) {
        if (this.mParams == null) {
            this.mParams = new ArrayList();
        }
        this.mParams.addAll(list);
        this.mHttpMethod = str;
        return this;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        super.execBean(null);
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        if ("GET".equalsIgnoreCase(this.mHttpMethod)) {
            return null;
        }
        return this.mParams;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getBeanId() {
        return 0;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getHttpMethod() {
        return !"GET".equalsIgnoreCase(this.mHttpMethod) ? 1 : 0;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getUrl() {
        if ("GET".equalsIgnoreCase(this.mHttpMethod)) {
            Uri.Builder buildUpon = Uri.parse("https://qianbao.baidu.com/tongji/performance/stat.jpg").buildUpon();
            for (int i = 0; i < this.mParams.size(); i++) {
                buildUpon.appendQueryParameter(this.mParams.get(i).getName(), this.mParams.get(i).getValue());
            }
            return buildUpon.build().toString();
        }
        return "https://qianbao.baidu.com/tongji/performance/stat.jpg";
    }

    @Override // com.baidu.wallet.core.beans.BaseBean, com.baidu.apollon.beans.ApollonBean
    public void prepareRestTemplate() {
        super.prepareRestTemplate();
        this.mRestTemplate.a().add(new CustomInterceptors());
        this.mRestTemplate.setMessageConverter(new b());
    }
}
