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
            this.a.put("av", sysParamters.dxY().b());
            this.a.put("sv", sysParamters.dxY().c());
            this.a.put(IXAdRequestInfo.TEST_MODE, sysParamters.dxY().d());
            this.a.put("mf", sysParamters.dxY().e());
            this.a.put(Config.PACKAGE_NAME, sysParamters.g());
        }
        this.a.put(IXAdRequestInfo.MAX_TITLE_LENGTH, String.valueOf(System.currentTimeMillis()));
        return this.a;
    }

    public boolean a(boolean z, String str, String str2, String str3, String str4) {
        try {
            String a = d.a(String.format("UDID=%s&OAID=%s&VAID=%s&AAID=%s", str, str2, str3, str4));
            b fR = b.fR(com.bun.miitmdid.utils.b.a());
            fR.w(a());
            fR.fQ("support", String.valueOf(z ? 1 : 0));
            fR.aL(a);
            fR.Qr("http://sdk.api.bjshcw.com/stat");
            fR.a(new b.a() { // from class: com.bun.miitmdid.b.c.1
                @Override // com.bun.miitmdid.b.b.a
                public void a(Exception exc, int i, String str5) {
                }
            }).dxS();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
