package com.baidu.tieba.write.b.a;

import com.baidu.android.bdutil.cuid.sdk.AppCuidRuntime;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes3.dex */
public class a implements com.baidu.e.c.d {
    private static String nXc = "";

    @Override // com.baidu.e.c.d
    public String getDeviceId() {
        return AppCuidRuntime.getAppCuidManager().getCuid();
    }

    @Override // com.baidu.e.c.d
    public String getBDVCInfo() {
        return null;
    }

    @Override // com.baidu.e.c.d
    public String getZid() {
        return nXc;
    }

    public static void setZid(String str) {
        nXc = str;
    }

    @Override // com.baidu.e.c.d
    public String k(String str, boolean z) {
        return str;
    }

    @Override // com.baidu.e.c.d
    public String getSid() {
        return null;
    }

    @Override // com.baidu.e.c.d
    public String getFrom() {
        return TbConfig.getCurrentFrom();
    }

    @Override // com.baidu.e.c.d
    public String getCfrom() {
        return TbConfig.getCurrentFrom();
    }

    @Override // com.baidu.e.c.d
    public String getC3Aid() {
        return null;
    }

    @Override // com.baidu.e.c.d
    public String getSchemeHeader() {
        return null;
    }
}
