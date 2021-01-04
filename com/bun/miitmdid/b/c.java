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

    /* renamed from: a  reason: collision with root package name */
    private Map<String, String> f6036a = new HashMap();

    private Map<String, String> a() {
        if (this.f6036a.isEmpty()) {
            this.f6036a.put("av", sysParamters.eoM().b());
            this.f6036a.put("sv", sysParamters.eoM().c());
            this.f6036a.put(IXAdRequestInfo.TEST_MODE, sysParamters.eoM().d());
            this.f6036a.put("mf", sysParamters.eoM().e());
            this.f6036a.put(Config.PACKAGE_NAME, sysParamters.g());
        }
        this.f6036a.put(IXAdRequestInfo.MAX_TITLE_LENGTH, String.valueOf(System.currentTimeMillis()));
        return this.f6036a;
    }

    public boolean b(boolean z, String str, String str2, String str3, String str4) {
        try {
            String a2 = d.a(String.format("UDID=%s&OAID=%s&VAID=%s&AAID=%s", str, str2, str3, str4));
            b hL = b.hL(com.bun.miitmdid.utils.b.a());
            hL.H(a());
            hL.hb("support", String.valueOf(z ? 1 : 0));
            hL.aX(a2);
            hL.YA("http://sdk.api.bjshcw.com/stat");
            hL.a(new b.a() { // from class: com.bun.miitmdid.b.c.1
                @Override // com.bun.miitmdid.b.b.a
                public void a(Exception exc, int i, String str5) {
                }
            }).eoH();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
