package com.baidu.tieba.publisher.a;

import com.baidu.android.bdutil.cuid.sdk.AppCuidRuntime;
/* loaded from: classes2.dex */
public class b implements com.baidu.b.b.d {
    private static String jBN = "";

    @Override // com.baidu.b.b.d
    public String getDeviceId() {
        return AppCuidRuntime.getAppCuidManager().getCuid();
    }

    @Override // com.baidu.b.b.d
    public String nU() {
        return null;
    }

    @Override // com.baidu.b.b.d
    public String getZid() {
        return jBN;
    }

    public static void setZid(String str) {
        jBN = str;
    }

    @Override // com.baidu.b.b.d
    public String g(String str, boolean z) {
        return str;
    }

    @Override // com.baidu.b.b.d
    public String nV() {
        return null;
    }

    @Override // com.baidu.b.b.d
    public String getFrom() {
        return null;
    }

    @Override // com.baidu.b.b.d
    public String nW() {
        return null;
    }
}
