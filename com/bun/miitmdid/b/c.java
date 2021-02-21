package com.bun.miitmdid.b;

import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobstat.Config;
import com.bun.miitmdid.b.b;
import com.bun.miitmdid.utils.d;
import com.bun.miitmdid.utils.sysParamters;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes15.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, String> f5739a = new HashMap();

    private Map<String, String> a() {
        if (this.f5739a.isEmpty()) {
            this.f5739a.put("av", sysParamters.ens().b());
            this.f5739a.put("sv", sysParamters.ens().c());
            this.f5739a.put(IXAdRequestInfo.TEST_MODE, sysParamters.ens().d());
            this.f5739a.put("mf", sysParamters.ens().e());
            this.f5739a.put(Config.PACKAGE_NAME, sysParamters.g());
        }
        this.f5739a.put(IXAdRequestInfo.MAX_TITLE_LENGTH, String.valueOf(System.currentTimeMillis()));
        return this.f5739a;
    }

    public boolean b(boolean z, String str, String str2, String str3, String str4) {
        try {
            String a2 = d.a(String.format("UDID=%s&OAID=%s&VAID=%s&AAID=%s", str, str2, str3, str4));
            b hM = b.hM(com.bun.miitmdid.utils.b.a());
            hM.J(a());
            hM.hj("support", String.valueOf(z ? 1 : 0));
            hM.aX(a2);
            hM.YF("http://sdk.api.bjshcw.com/stat");
            hM.a(new b.a() { // from class: com.bun.miitmdid.b.c.1
                @Override // com.bun.miitmdid.b.b.a
                public void a(Exception exc, int i, String str5) {
                }
            }).enn();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
