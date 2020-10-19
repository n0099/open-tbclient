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

    /* renamed from: a  reason: collision with root package name */
    private Map<String, String> f3978a = new HashMap();

    private Map<String, String> a() {
        if (this.f3978a.isEmpty()) {
            this.f3978a.put("av", sysParamters.dUV().b());
            this.f3978a.put("sv", sysParamters.dUV().c());
            this.f3978a.put(IXAdRequestInfo.TEST_MODE, sysParamters.dUV().d());
            this.f3978a.put("mf", sysParamters.dUV().e());
            this.f3978a.put(Config.PACKAGE_NAME, sysParamters.g());
        }
        this.f3978a.put(IXAdRequestInfo.MAX_TITLE_LENGTH, String.valueOf(System.currentTimeMillis()));
        return this.f3978a;
    }

    public boolean b(boolean z, String str, String str2, String str3, String str4) {
        try {
            String a2 = d.a(String.format("UDID=%s&OAID=%s&VAID=%s&AAID=%s", str, str2, str3, str4));
            b gv = b.gv(com.bun.miitmdid.utils.b.a());
            gv.G(a());
            gv.gD("support", String.valueOf(z ? 1 : 0));
            gv.aS(a2);
            gv.Vt("http://sdk.api.bjshcw.com/stat");
            gv.a(new b.a() { // from class: com.bun.miitmdid.b.c.1
                @Override // com.bun.miitmdid.b.b.a
                public void a(Exception exc, int i, String str5) {
                }
            }).dUP();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
