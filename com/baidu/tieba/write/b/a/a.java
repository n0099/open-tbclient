package com.baidu.tieba.write.b.a;

import com.baidu.android.bdutil.cuid.sdk.AppCuidRuntime;
/* loaded from: classes3.dex */
public class a implements com.baidu.d.b.d {
    private static String mPl = "";

    @Override // com.baidu.d.b.d
    public String getDeviceId() {
        return AppCuidRuntime.getAppCuidManager().getCuid();
    }

    @Override // com.baidu.d.b.d
    public String uA() {
        return null;
    }

    @Override // com.baidu.d.b.d
    public String getZid() {
        return mPl;
    }

    public static void setZid(String str) {
        mPl = str;
    }

    @Override // com.baidu.d.b.d
    public String k(String str, boolean z) {
        return str;
    }

    @Override // com.baidu.d.b.d
    public String uB() {
        return null;
    }

    @Override // com.baidu.d.b.d
    public String getFrom() {
        return null;
    }

    @Override // com.baidu.d.b.d
    public String uC() {
        return null;
    }

    @Override // com.baidu.d.b.d
    public String uD() {
        return null;
    }

    @Override // com.baidu.d.b.d
    public String uE() {
        return null;
    }
}
