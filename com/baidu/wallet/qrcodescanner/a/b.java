package com.baidu.wallet.qrcodescanner.a;

import org.json.JSONObject;
/* loaded from: classes5.dex */
public interface b {

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f27253a;

        /* renamed from: b  reason: collision with root package name */
        public String f27254b;

        /* renamed from: c  reason: collision with root package name */
        public JSONObject f27255c;

        /* renamed from: d  reason: collision with root package name */
        public JSONObject f27256d;

        public String toString() {
            return "ScannerResult [type=" + this.f27253a + ", linkaddr=" + this.f27254b + ", extJson=" + this.f27255c + "]";
        }
    }

    void onResultFail(String str, String str2);

    void onResultSuccessCallBack(String str, a aVar, boolean z);
}
