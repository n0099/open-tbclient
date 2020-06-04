package com.bun.miitmdid.b;

import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobstat.Config;
import com.bun.miitmdid.b.b;
import com.bun.miitmdid.utils.d;
import com.bun.miitmdid.utils.sysParamters;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class c {
    private Map<String, String> a = new HashMap();

    private Map<String, String> a() {
        if (this.a.isEmpty()) {
            this.a.put("av", sysParamters.dtv().b());
            this.a.put("sv", sysParamters.dtv().c());
            this.a.put(IXAdRequestInfo.TEST_MODE, sysParamters.dtv().d());
            this.a.put("mf", sysParamters.dtv().e());
            this.a.put(Config.PACKAGE_NAME, sysParamters.g());
        }
        this.a.put(IXAdRequestInfo.MAX_TITLE_LENGTH, String.valueOf(System.currentTimeMillis()));
        return this.a;
    }

    public boolean a(boolean z, String str, String str2, String str3, String str4) {
        try {
            String a = d.a(String.format("UDID=%s&OAID=%s&VAID=%s&AAID=%s", str, str2, str3, str4));
            b fQ = b.fQ(com.bun.miitmdid.utils.b.a());
            fQ.v(a());
            fQ.fG("support", String.valueOf(z ? 1 : 0));
            fQ.aK(a);
            fQ.PF("http://sdk.api.bjshcw.com/stat");
            fQ.a(new b.a() { // from class: com.bun.miitmdid.b.c.1
                @Override // com.bun.miitmdid.b.b.a
                public void a(Exception exc, int i, String str5) {
                }
            }).dtp();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
