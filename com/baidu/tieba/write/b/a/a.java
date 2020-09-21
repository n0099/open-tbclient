package com.baidu.tieba.write.b.a;

import com.baidu.android.bdutil.cuid.sdk.AppCuidRuntime;
/* loaded from: classes3.dex */
public class a implements com.baidu.d.c.d {
    private static String mZA = "";

    @Override // com.baidu.d.c.d
    public String getDeviceId() {
        return AppCuidRuntime.getAppCuidManager().getCuid();
    }

    @Override // com.baidu.d.c.d
    public String uO() {
        return null;
    }

    @Override // com.baidu.d.c.d
    public String getZid() {
        return mZA;
    }

    public static void setZid(String str) {
        mZA = str;
    }

    @Override // com.baidu.d.c.d
    public String k(String str, boolean z) {
        return str;
    }

    @Override // com.baidu.d.c.d
    public String uP() {
        return null;
    }

    @Override // com.baidu.d.c.d
    public String getFrom() {
        return null;
    }

    @Override // com.baidu.d.c.d
    public String uQ() {
        return null;
    }

    @Override // com.baidu.d.c.d
    public String uR() {
        return null;
    }

    @Override // com.baidu.d.c.d
    public String uS() {
        return null;
    }
}
