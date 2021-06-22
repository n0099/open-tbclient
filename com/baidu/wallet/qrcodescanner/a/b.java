package com.baidu.wallet.qrcodescanner.a;

import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public interface b {

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f26612a;

        /* renamed from: b  reason: collision with root package name */
        public String f26613b;

        /* renamed from: c  reason: collision with root package name */
        public JSONObject f26614c;

        /* renamed from: d  reason: collision with root package name */
        public JSONObject f26615d;

        public String toString() {
            return "ScannerResult [type=" + this.f26612a + ", linkaddr=" + this.f26613b + ", extJson=" + this.f26614c + PreferencesUtil.RIGHT_MOUNT;
        }
    }

    void onResultFail(String str, String str2);

    void onResultSuccessCallBack(String str, a aVar, boolean z);
}
