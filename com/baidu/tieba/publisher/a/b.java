package com.baidu.tieba.publisher.a;

import com.baidu.android.bdutil.cuid.sdk.AppCuidRuntime;
/* loaded from: classes12.dex */
public class b implements com.baidu.b.b.d {
    private static String jAE = "";

    @Override // com.baidu.b.b.d
    public String getDeviceId() {
        return AppCuidRuntime.getAppCuidManager().getCuid();
    }

    @Override // com.baidu.b.b.d
    public String nm() {
        return null;
    }

    @Override // com.baidu.b.b.d
    public String getZid() {
        return jAE;
    }

    public static void setZid(String str) {
        jAE = str;
    }

    @Override // com.baidu.b.b.d
    public String g(String str, boolean z) {
        return str;
    }

    @Override // com.baidu.b.b.d
    public String nn() {
        return null;
    }

    @Override // com.baidu.b.b.d
    public String getFrom() {
        return null;
    }

    @Override // com.baidu.b.b.d
    public String no() {
        return null;
    }
}
