package com.bun.miitmdid.b;

import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobstat.Config;
import com.bun.miitmdid.b.b;
import com.bun.miitmdid.utils.d;
import com.bun.miitmdid.utils.sysParamters;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, String> f3873a = new HashMap();

    private Map<String, String> a() {
        if (this.f3873a.isEmpty()) {
            this.f3873a.put("av", sysParamters.enC().b());
            this.f3873a.put("sv", sysParamters.enC().c());
            this.f3873a.put(IXAdRequestInfo.TEST_MODE, sysParamters.enC().d());
            this.f3873a.put("mf", sysParamters.enC().e());
            this.f3873a.put(Config.PACKAGE_NAME, sysParamters.g());
        }
        this.f3873a.put(IXAdRequestInfo.MAX_TITLE_LENGTH, String.valueOf(System.currentTimeMillis()));
        return this.f3873a;
    }

    public boolean b(boolean z, String str, String str2, String str3, String str4) {
        try {
            String a2 = d.a(String.format("UDID=%s&OAID=%s&VAID=%s&AAID=%s", str, str2, str3, str4));
            b hL = b.hL(com.bun.miitmdid.utils.b.a());
            hL.J(a());
            hL.hj("support", String.valueOf(z ? 1 : 0));
            hL.aZ(a2);
            hL.YM("http://sdk.api.bjshcw.com/stat");
            hL.a(new b.a() { // from class: com.bun.miitmdid.b.c.1
                @Override // com.bun.miitmdid.b.b.a
                public void a(Exception exc, int i, String str5) {
                }
            }).enx();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
