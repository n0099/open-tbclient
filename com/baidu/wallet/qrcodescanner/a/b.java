package com.baidu.wallet.qrcodescanner.a;

import org.json.JSONObject;
/* loaded from: classes5.dex */
public interface b {

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f26752a;

        /* renamed from: b  reason: collision with root package name */
        public String f26753b;

        /* renamed from: c  reason: collision with root package name */
        public JSONObject f26754c;

        /* renamed from: d  reason: collision with root package name */
        public JSONObject f26755d;

        public String toString() {
            return "ScannerResult [type=" + this.f26752a + ", linkaddr=" + this.f26753b + ", extJson=" + this.f26754c + "]";
        }
    }

    void onResultFail(String str, String str2);

    void onResultSuccessCallBack(String str, a aVar, boolean z);
}
