package com.baidu.tieba.publisher.a;

import com.baidu.android.bdutil.cuid.sdk.AppCuidRuntime;
/* loaded from: classes11.dex */
public class b implements com.baidu.b.b.d {
    private static String jxc = "";

    @Override // com.baidu.b.b.d
    public String getDeviceId() {
        return AppCuidRuntime.getAppCuidManager().getCuid();
    }

    @Override // com.baidu.b.b.d
    public String nl() {
        return null;
    }

    @Override // com.baidu.b.b.d
    public String getZid() {
        return jxc;
    }

    public static void setZid(String str) {
        jxc = str;
    }

    @Override // com.baidu.b.b.d
    public String g(String str, boolean z) {
        return str;
    }

    @Override // com.baidu.b.b.d
    public String nm() {
        return null;
    }

    @Override // com.baidu.b.b.d
    public String getFrom() {
        return null;
    }

    @Override // com.baidu.b.b.d
    public String nn() {
        return null;
    }
}
