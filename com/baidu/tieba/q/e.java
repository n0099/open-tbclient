package com.baidu.tieba.q;

import com.baidu.android.bdutil.cuid.sdk.AppCuidRuntime;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class e implements com.baidu.d.c.d {
    private static String ncO = "";

    @Override // com.baidu.d.c.d
    public String getDeviceId() {
        return AppCuidRuntime.getAppCuidManager().getCuid();
    }

    @Override // com.baidu.d.c.d
    public String getBDVCInfo() {
        return null;
    }

    @Override // com.baidu.d.c.d
    public String getZid() {
        return ncO;
    }

    @Override // com.baidu.d.c.d
    public String k(String str, boolean z) {
        return str;
    }

    @Override // com.baidu.d.c.d
    public String getSid() {
        return null;
    }

    @Override // com.baidu.d.c.d
    public String getFrom() {
        return TbConfig.getCurrentFrom();
    }

    @Override // com.baidu.d.c.d
    public String getCfrom() {
        return TbConfig.getCurrentFrom();
    }

    @Override // com.baidu.d.c.d
    public String getC3Aid() {
        return null;
    }

    @Override // com.baidu.d.c.d
    public String getSchemeHeader() {
        return null;
    }
}
