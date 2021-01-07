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
    private Map<String, String> f6037a = new HashMap();

    private Map<String, String> a() {
        if (this.f6037a.isEmpty()) {
            this.f6037a.put("av", sysParamters.eoN().b());
            this.f6037a.put("sv", sysParamters.eoN().c());
            this.f6037a.put(IXAdRequestInfo.TEST_MODE, sysParamters.eoN().d());
            this.f6037a.put("mf", sysParamters.eoN().e());
            this.f6037a.put(Config.PACKAGE_NAME, sysParamters.g());
        }
        this.f6037a.put(IXAdRequestInfo.MAX_TITLE_LENGTH, String.valueOf(System.currentTimeMillis()));
        return this.f6037a;
    }

    public boolean b(boolean z, String str, String str2, String str3, String str4) {
        try {
            String a2 = d.a(String.format("UDID=%s&OAID=%s&VAID=%s&AAID=%s", str, str2, str3, str4));
            b hL = b.hL(com.bun.miitmdid.utils.b.a());
            hL.H(a());
            hL.hb("support", String.valueOf(z ? 1 : 0));
            hL.aX(a2);
            hL.Yz("http://sdk.api.bjshcw.com/stat");
            hL.a(new b.a() { // from class: com.bun.miitmdid.b.c.1
                @Override // com.bun.miitmdid.b.b.a
                public void a(Exception exc, int i, String str5) {
                }
            }).eoI();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
