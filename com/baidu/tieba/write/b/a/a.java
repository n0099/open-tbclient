package com.baidu.tieba.write.b.a;

import com.baidu.android.bdutil.cuid.sdk.AppCuidRuntime;
/* loaded from: classes2.dex */
public class a implements com.baidu.a.b.d {
    private static String moX = "";

    @Override // com.baidu.a.b.d
    public String getDeviceId() {
        return AppCuidRuntime.getAppCuidManager().getCuid();
    }

    @Override // com.baidu.a.b.d
    public String sQ() {
        return null;
    }

    @Override // com.baidu.a.b.d
    public String getZid() {
        return moX;
    }

    public static void setZid(String str) {
        moX = str;
    }

    @Override // com.baidu.a.b.d
    public String k(String str, boolean z) {
        return str;
    }

    @Override // com.baidu.a.b.d
    public String sR() {
        return null;
    }

    @Override // com.baidu.a.b.d
    public String getFrom() {
        return null;
    }

    @Override // com.baidu.a.b.d
    public String sS() {
        return null;
    }

    @Override // com.baidu.a.b.d
    public String sT() {
        return null;
    }

    @Override // com.baidu.a.b.d
    public String sU() {
        return null;
    }
}
