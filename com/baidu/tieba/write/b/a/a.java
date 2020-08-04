package com.baidu.tieba.write.b.a;

import com.baidu.android.bdutil.cuid.sdk.AppCuidRuntime;
/* loaded from: classes3.dex */
public class a implements com.baidu.b.b.d {
    private static String mwY = "";

    @Override // com.baidu.b.b.d
    public String getDeviceId() {
        return AppCuidRuntime.getAppCuidManager().getCuid();
    }

    @Override // com.baidu.b.b.d
    public String sS() {
        return null;
    }

    @Override // com.baidu.b.b.d
    public String getZid() {
        return mwY;
    }

    public static void setZid(String str) {
        mwY = str;
    }

    @Override // com.baidu.b.b.d
    public String k(String str, boolean z) {
        return str;
    }

    @Override // com.baidu.b.b.d
    public String sT() {
        return null;
    }

    @Override // com.baidu.b.b.d
    public String getFrom() {
        return null;
    }

    @Override // com.baidu.b.b.d
    public String sU() {
        return null;
    }

    @Override // com.baidu.b.b.d
    public String sV() {
        return null;
    }

    @Override // com.baidu.b.b.d
    public String sW() {
        return null;
    }
}
