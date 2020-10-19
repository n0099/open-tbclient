package com.baidu.tieba.write.b.a;

import com.baidu.android.bdutil.cuid.sdk.AppCuidRuntime;
/* loaded from: classes3.dex */
public class a implements com.baidu.d.c.d {
    private static String npa = "";

    @Override // com.baidu.d.c.d
    public String getDeviceId() {
        return AppCuidRuntime.getAppCuidManager().getCuid();
    }

    @Override // com.baidu.d.c.d
    public String uX() {
        return null;
    }

    @Override // com.baidu.d.c.d
    public String getZid() {
        return npa;
    }

    public static void setZid(String str) {
        npa = str;
    }

    @Override // com.baidu.d.c.d
    public String k(String str, boolean z) {
        return str;
    }

    @Override // com.baidu.d.c.d
    public String uY() {
        return null;
    }

    @Override // com.baidu.d.c.d
    public String getFrom() {
        return null;
    }

    @Override // com.baidu.d.c.d
    public String uZ() {
        return null;
    }

    @Override // com.baidu.d.c.d
    public String va() {
        return null;
    }

    @Override // com.baidu.d.c.d
    public String vb() {
        return null;
    }
}
