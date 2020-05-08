package com.baidu.tieba.write.b.a;

import com.baidu.android.bdutil.cuid.sdk.AppCuidRuntime;
/* loaded from: classes2.dex */
public class a implements com.baidu.a.b.d {
    private static String lAa = "";

    @Override // com.baidu.a.b.d
    public String getDeviceId() {
        return AppCuidRuntime.getAppCuidManager().getCuid();
    }

    @Override // com.baidu.a.b.d
    public String sl() {
        return null;
    }

    @Override // com.baidu.a.b.d
    public String getZid() {
        return lAa;
    }

    public static void setZid(String str) {
        lAa = str;
    }

    @Override // com.baidu.a.b.d
    public String k(String str, boolean z) {
        return str;
    }

    @Override // com.baidu.a.b.d
    public String sm() {
        return null;
    }

    @Override // com.baidu.a.b.d
    public String getFrom() {
        return null;
    }

    @Override // com.baidu.a.b.d
    public String sn() {
        return null;
    }

    @Override // com.baidu.a.b.d
    public String so() {
        return null;
    }

    @Override // com.baidu.a.b.d
    public String sp() {
        return null;
    }
}
