package com.baidu.wallet.qrcodescanner.a;

import org.json.JSONObject;
/* loaded from: classes5.dex */
public interface b {

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f26753a;

        /* renamed from: b  reason: collision with root package name */
        public String f26754b;

        /* renamed from: c  reason: collision with root package name */
        public JSONObject f26755c;

        /* renamed from: d  reason: collision with root package name */
        public JSONObject f26756d;

        public String toString() {
            return "ScannerResult [type=" + this.f26753a + ", linkaddr=" + this.f26754b + ", extJson=" + this.f26755c + "]";
        }
    }

    void onResultFail(String str, String str2);

    void onResultSuccessCallBack(String str, a aVar, boolean z);
}
