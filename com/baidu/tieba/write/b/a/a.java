package com.baidu.tieba.write.b.a;

import com.baidu.android.bdutil.cuid.sdk.AppCuidRuntime;
/* loaded from: classes2.dex */
public class a implements com.baidu.a.b.d {
    private static String lUA = "";

    @Override // com.baidu.a.b.d
    public String getDeviceId() {
        return AppCuidRuntime.getAppCuidManager().getCuid();
    }

    @Override // com.baidu.a.b.d
    public String sv() {
        return null;
    }

    @Override // com.baidu.a.b.d
    public String getZid() {
        return lUA;
    }

    public static void setZid(String str) {
        lUA = str;
    }

    @Override // com.baidu.a.b.d
    public String k(String str, boolean z) {
        return str;
    }

    @Override // com.baidu.a.b.d
    public String sw() {
        return null;
    }

    @Override // com.baidu.a.b.d
    public String getFrom() {
        return null;
    }

    @Override // com.baidu.a.b.d
    public String sx() {
        return null;
    }

    @Override // com.baidu.a.b.d
    public String sy() {
        return null;
    }

    @Override // com.baidu.a.b.d
    public String sz() {
        return null;
    }
}
