package com.baidu.tieba.write.b.a;

import com.baidu.android.bdutil.cuid.sdk.AppCuidRuntime;
/* loaded from: classes3.dex */
public class a implements com.baidu.e.c.d {
    private static String nIU = "";

    @Override // com.baidu.e.c.d
    public String getDeviceId() {
        return AppCuidRuntime.getAppCuidManager().getCuid();
    }

    @Override // com.baidu.e.c.d
    public String uW() {
        return null;
    }

    @Override // com.baidu.e.c.d
    public String getZid() {
        return nIU;
    }

    public static void setZid(String str) {
        nIU = str;
    }

    @Override // com.baidu.e.c.d
    public String k(String str, boolean z) {
        return str;
    }

    @Override // com.baidu.e.c.d
    public String uX() {
        return null;
    }

    @Override // com.baidu.e.c.d
    public String getFrom() {
        return null;
    }

    @Override // com.baidu.e.c.d
    public String uY() {
        return null;
    }

    @Override // com.baidu.e.c.d
    public String uZ() {
        return null;
    }

    @Override // com.baidu.e.c.d
    public String va() {
        return null;
    }
}
