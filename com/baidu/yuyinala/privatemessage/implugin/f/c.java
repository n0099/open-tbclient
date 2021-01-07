package com.baidu.yuyinala.privatemessage.implugin.f;

import android.content.Context;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.yuyinala.privatemessage.implugin.common.ChatInfo;
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
public class c extends i {
    private String mKey;
    private String mType;
    private final String oUC = "http://cp01-zhangsukun.epc.baidu.com:8220/";
    private long oUx;

    public c(Context context, String str, long j, String str2) {
        this.mKey = "";
        this.oUx = j;
        this.mKey = str2;
        this.mContext = context;
        this.mType = str;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        return Ym("http://cp01-zhangsukun.epc.baidu.com:8220/") + "api/subscribe/v1/relation/receive";
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        boolean z;
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("AddUserSubscribeRequest", "errorCode: " + i + " resultContent: " + new String(bArr));
        if (i == 200) {
            try {
                z = new JSONObject(new String(bArr)).optInt(BaseJsonData.TAG_ERRNO) == 0;
            } catch (JSONException e) {
                LogUtils.e("AddUserSubscribeRequest", "AddUserSubscribeRequest JSONException", e);
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
        sb.append("op_type=").append(IMTrack.DbBuilder.ACTION_ADD);
        sb.append("&type=").append(this.mType);
        sb.append("&third_id=").append(ExtraParamsManager.getEncryptionUserId(this.oUx + ""));
        sb.append("&sfrom=").append("mingame");
        if (ChatInfo.oTS) {
            sb.append("&source=").append("im_c2cchat_sgame");
        } else {
            sb.append("&source=").append("im_c2cchat");
        }
        sb.append("&store=").append("uid");
        return sb.toString().getBytes();
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        return "application/x-www-form-urlencoded";
    }
}
