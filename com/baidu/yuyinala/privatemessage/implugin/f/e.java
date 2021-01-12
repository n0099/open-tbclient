package com.baidu.yuyinala.privatemessage.implugin.f;

import android.content.Context;
import com.baidu.android.imsdk.internal.ListenerManager;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes10.dex */
public class e extends i {
    private String mKey;
    private long mPaid;

    public e(Context context, long j, String str) {
        this.mKey = "";
        this.mPaid = j;
        this.mKey = str;
        this.mContext = context;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        return Xe(null) + "api/subscribe/v1/resource/pauid_thirdid";
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        if (i == 200) {
            k.hz(this.mContext).a(i, new String(bArr), this.mPaid, this.mKey);
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
        sb.append("pa_uid=").append(this.mPaid);
        sb.append("&store=").append("uid_cuid");
        sb.append("&sfrom=").append("im");
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
