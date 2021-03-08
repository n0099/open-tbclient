package com.baidu.yuyinala.privatemessage.implugin.f;

import android.text.TextUtils;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.utils.BaseHttpRequest;
import com.baidu.yuyinala.privatemessage.implugin.util.Base64Encoder;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.cookie.SM;
/* loaded from: classes10.dex */
public abstract class i extends BaseHttpRequest {
    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public Map<String, String> getHeaders() {
        HashMap hashMap = new HashMap();
        if (!AccountManager.isCuidLogin(this.mContext)) {
            hashMap.put(SM.COOKIE, "BDUSS=" + com.baidu.yuyinala.privatemessage.implugin.d.b.eke().getBduss(this.mContext));
        } else {
            try {
                hashMap.put(SM.COOKIE, "BAIDUCUID=" + URLEncoder.encode(new String(Base64Encoder.b64Encode(com.baidu.yuyinala.privatemessage.implugin.d.b.eke().getCuid(this.mContext).getBytes())), "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return hashMap;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getMethod() {
        return "GET";
    }

    public String Yz(String str) {
        switch (com.baidu.yuyinala.privatemessage.implugin.d.b.eke().hx(this.mContext)) {
            case 0:
                return "https://ext.baidu.com/";
            case 1:
            case 2:
                return TextUtils.isEmpty(str) ? "http://cp01-yanmeng01.epc.baidu.com:8220/" : str;
            default:
                return "https://ext.baidu.com/";
        }
    }
}
