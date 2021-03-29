package com.bun.miitmdid.b;

import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobstat.Config;
import com.bun.miitmdid.b.b;
import com.bun.miitmdid.utils.d;
import com.bun.miitmdid.utils.sysParamters;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public Map<String, String> f27077a = new HashMap();

    private Map<String, String> a() {
        if (this.f27077a.isEmpty()) {
            this.f27077a.put(com.alipay.sdk.sys.a.k, sysParamters.a().b());
            this.f27077a.put("sv", sysParamters.a().c());
            this.f27077a.put(IXAdRequestInfo.TEST_MODE, sysParamters.a().d());
            this.f27077a.put("mf", sysParamters.a().e());
            this.f27077a.put(Config.PACKAGE_NAME, sysParamters.g());
        }
        this.f27077a.put(IXAdRequestInfo.MAX_TITLE_LENGTH, String.valueOf(System.currentTimeMillis()));
        return this.f27077a;
    }

    public boolean a(boolean z, String str, String str2, String str3, String str4) {
        try {
            String a2 = d.a(String.format("UDID=%s&OAID=%s&VAID=%s&AAID=%s", str, str2, str3, str4));
            b a3 = b.a(com.bun.miitmdid.utils.b.a());
            a3.a(a());
            a3.a("support", String.valueOf(z ? 1 : 0));
            a3.a((Object) a2);
            a3.a("http://sdk.api.bjshcw.com/stat");
            a3.a(new b.a() { // from class: com.bun.miitmdid.b.c.1
                @Override // com.bun.miitmdid.b.b.a
                public void a(Exception exc, int i, String str5) {
                }
            }).a();
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
