package com.bun.miitmdid.b;

import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobstat.Config;
import com.bun.miitmdid.b.b;
import com.bun.miitmdid.utils.d;
import com.bun.miitmdid.utils.sysParamters;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes11.dex */
public class c {
    private Map<String, String> a = new HashMap();

    private Map<String, String> a() {
        if (this.a.isEmpty()) {
            this.a.put("av", sysParamters.dRk().b());
            this.a.put("sv", sysParamters.dRk().c());
            this.a.put(IXAdRequestInfo.TEST_MODE, sysParamters.dRk().d());
            this.a.put("mf", sysParamters.dRk().e());
            this.a.put(Config.PACKAGE_NAME, sysParamters.g());
        }
        this.a.put(IXAdRequestInfo.MAX_TITLE_LENGTH, String.valueOf(System.currentTimeMillis()));
        return this.a;
    }

    public boolean b(boolean z, String str, String str2, String str3, String str4) {
        try {
            String a = d.a(String.format("UDID=%s&OAID=%s&VAID=%s&AAID=%s", str, str2, str3, str4));
            b go = b.go(com.bun.miitmdid.utils.b.a());
            go.w(a());
            go.gw("support", String.valueOf(z ? 1 : 0));
            go.aP(a);
            go.UF("http://sdk.api.bjshcw.com/stat");
            go.a(new b.a() { // from class: com.bun.miitmdid.b.c.1
                @Override // com.bun.miitmdid.b.b.a
                public void a(Exception exc, int i, String str5) {
                }
            }).dRe();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
