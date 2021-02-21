package com.baidu.yuyinala.privatemessage.implugin.f;

import android.content.Context;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes11.dex */
public class f extends i {
    private String mKey;
    private long mUid;
    private final String paN = "http://ext.baidu.com/";

    public f(Context context, long j, String str) {
        this.mKey = "";
        this.mUid = j;
        this.mKey = str;
        this.mContext = context;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        return Ys("http://ext.baidu.com/") + "api/subscribe/v1/relation/get";
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        if (i == 200) {
            k.hC(this.mContext).a(i, new String(bArr), this.mUid, this.mKey);
        } else {
            ListenerManager.getInstance().removeListener(this.mKey);
        }
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        ListenerManager.getInstance().removeListener(this.mKey);
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        StringBuilder sb = new StringBuilder();
        sb.append("third_id=").append(ExtraParamsManager.getEncryptionUserId(this.mUid + ""));
        sb.append("&store=").append("uid");
        sb.append("&type=").append("ugc");
        sb.append("&sfrom=").append("mingame");
        sb.append("&source=").append("imsdk");
        return sb.toString().getBytes();
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        return "application/x-www-form-urlencoded";
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        return false;
    }
}
