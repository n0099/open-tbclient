package com.baidu.yuyinala.privatemessage.implugin.f;

import android.content.Context;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.yuyinala.privatemessage.implugin.util.Base64Encoder;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.cookie.SM;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b extends i {
    private String mKey;
    private String mType;
    private long oUx;

    public b(Context context, String str, long j, String str2) {
        this.mKey = "";
        this.oUx = j;
        this.mKey = str2;
        this.mContext = context;
        this.mType = str;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        return Ym(null) + "api/subscribe/v1/relation/receive";
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        boolean z;
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("AddSubscribeRequest", "errorCode: " + i + " resultContent: " + new String(bArr));
        if (i == 200) {
            try {
                z = new JSONObject(new String(bArr)).optInt(BaseJsonData.TAG_ERRNO) == 0;
            } catch (JSONException e) {
                LogUtils.e("AddSubscribeRequest", "AddSubscribeRequest JSONException", e);
                z = false;
            }
        } else {
            z = false;
        }
        k.hB(this.mContext).a(i, new String(bArr), this.oUx, this.mKey, z);
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        k.hB(this.mContext).a(i, new String(bArr), this.oUx, this.mKey, false);
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.f.i, com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public Map<String, String> getHeaders() {
        HashMap hashMap = new HashMap();
        if (!AccountManager.isCuidLogin(this.mContext)) {
            hashMap.put(SM.COOKIE, "BDUSS=" + com.baidu.yuyinala.privatemessage.implugin.d.b.elm().getBduss(this.mContext));
        } else {
            try {
                hashMap.put(SM.COOKIE, "BAIDUCUID=" + URLEncoder.encode(new String(Base64Encoder.b64Encode(com.baidu.yuyinala.privatemessage.implugin.d.b.elm().getCuid(this.mContext).getBytes())), "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return hashMap;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        return false;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        StringBuilder sb = new StringBuilder();
        sb.append("op_type=").append(elo());
        sb.append("&type=").append(this.mType);
        sb.append("&third_id=").append(this.oUx);
        sb.append("&sfrom=").append("imsdk");
        sb.append("&source=").append("im_b2cchat");
        sb.append("&store=").append("uid_cuid");
        a(sb);
        return sb.toString().getBytes();
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        return "application/x-www-form-urlencoded";
    }

    public String elo() {
        return IMTrack.DbBuilder.ACTION_ADD;
    }

    public void a(StringBuilder sb) {
    }
}
