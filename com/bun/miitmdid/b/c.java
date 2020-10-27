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
    private Map<String, String> f3976a = new HashMap();

    private Map<String, String> a() {
        if (this.f3976a.isEmpty()) {
            this.f3976a.put("av", sysParamters.eeT().b());
            this.f3976a.put("sv", sysParamters.eeT().c());
            this.f3976a.put(IXAdRequestInfo.TEST_MODE, sysParamters.eeT().d());
            this.f3976a.put("mf", sysParamters.eeT().e());
            this.f3976a.put(Config.PACKAGE_NAME, sysParamters.g());
        }
        this.f3976a.put(IXAdRequestInfo.MAX_TITLE_LENGTH, String.valueOf(System.currentTimeMillis()));
        return this.f3976a;
    }

    public boolean b(boolean z, String str, String str2, String str3, String str4) {
        try {
            String a2 = d.a(String.format("UDID=%s&OAID=%s&VAID=%s&AAID=%s", str, str2, str3, str4));
            b gQ = b.gQ(com.bun.miitmdid.utils.b.a());
            gQ.G(a());
            gQ.gT("support", String.valueOf(z ? 1 : 0));
            gQ.aW(a2);
            gQ.Xg("http://sdk.api.bjshcw.com/stat");
            gQ.a(new b.a() { // from class: com.bun.miitmdid.b.c.1
                @Override // com.bun.miitmdid.b.b.a
                public void a(Exception exc, int i, String str5) {
                }
            }).eeN();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
