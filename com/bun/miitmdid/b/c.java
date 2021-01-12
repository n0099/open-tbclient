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
    private Map<String, String> f5737a = new HashMap();

    private Map<String, String> a() {
        if (this.f5737a.isEmpty()) {
            this.f5737a.put("av", sysParamters.ekR().b());
            this.f5737a.put("sv", sysParamters.ekR().c());
            this.f5737a.put(IXAdRequestInfo.TEST_MODE, sysParamters.ekR().d());
            this.f5737a.put("mf", sysParamters.ekR().e());
            this.f5737a.put(Config.PACKAGE_NAME, sysParamters.g());
        }
        this.f5737a.put(IXAdRequestInfo.MAX_TITLE_LENGTH, String.valueOf(System.currentTimeMillis()));
        return this.f5737a;
    }

    public boolean b(boolean z, String str, String str2, String str3, String str4) {
        try {
            String a2 = d.a(String.format("UDID=%s&OAID=%s&VAID=%s&AAID=%s", str, str2, str3, str4));
            b hJ = b.hJ(com.bun.miitmdid.utils.b.a());
            hJ.H(a());
            hJ.ha("support", String.valueOf(z ? 1 : 0));
            hJ.aX(a2);
            hJ.Xr("http://sdk.api.bjshcw.com/stat");
            hJ.a(new b.a() { // from class: com.bun.miitmdid.b.c.1
                @Override // com.bun.miitmdid.b.b.a
                public void a(Exception exc, int i, String str5) {
                }
            }).ekM();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
