package com.bun.miitmdid.b;

import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobstat.Config;
import com.bun.miitmdid.b.b;
import com.bun.miitmdid.utils.d;
import com.bun.miitmdid.utils.sysParamters;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes18.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, String> f3981a = new HashMap();

    private Map<String, String> a() {
        if (this.f3981a.isEmpty()) {
            this.f3981a.put("av", sysParamters.eow().b());
            this.f3981a.put("sv", sysParamters.eow().c());
            this.f3981a.put(IXAdRequestInfo.TEST_MODE, sysParamters.eow().d());
            this.f3981a.put("mf", sysParamters.eow().e());
            this.f3981a.put(Config.PACKAGE_NAME, sysParamters.g());
        }
        this.f3981a.put(IXAdRequestInfo.MAX_TITLE_LENGTH, String.valueOf(System.currentTimeMillis()));
        return this.f3981a;
    }

    public boolean b(boolean z, String str, String str2, String str3, String str4) {
        try {
            String a2 = d.a(String.format("UDID=%s&OAID=%s&VAID=%s&AAID=%s", str, str2, str3, str4));
            b hx = b.hx(com.bun.miitmdid.utils.b.a());
            hx.G(a());
            hx.hd("support", String.valueOf(z ? 1 : 0));
            hx.aX(a2);
            hx.YQ("http://sdk.api.bjshcw.com/stat");
            hx.a(new b.a() { // from class: com.bun.miitmdid.b.c.1
                @Override // com.bun.miitmdid.b.b.a
                public void a(Exception exc, int i, String str5) {
                }
            }).eoq();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
