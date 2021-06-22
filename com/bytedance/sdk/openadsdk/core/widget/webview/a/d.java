package com.bytedance.sdk.openadsdk.core.widget.webview.a;

import android.text.TextUtils;
import com.baidu.searchbox.pms.db.PackageTable;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.d.t;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.l.g;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.u;
import d.b.c.b.b.i;
import d.b.c.b.b.j;
import d.b.c.b.d.o;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static volatile d f28928a;

    /* renamed from: b  reason: collision with root package name */
    public AtomicBoolean f28929b = new AtomicBoolean(false);

    private JSONObject c(String str) {
        i c2 = i.c();
        new j(0, str, c2).setShouldCache(false).build(com.bytedance.sdk.openadsdk.i.e.c().e());
        try {
            o oVar = c2.get();
            if (oVar == null || !oVar.f() || oVar.f69644a == 0) {
                return null;
            }
            return new JSONObject((String) oVar.f69644a);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public Set<String> b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return c.a().b(str);
    }

    public static d a() {
        if (f28928a == null) {
            synchronized (d.class) {
                if (f28928a == null) {
                    f28928a = new d();
                }
            }
        }
        return f28928a;
    }

    private void b() {
        if (p.h() == null) {
            return;
        }
        int E = p.h().E();
        if (E <= 0) {
            E = 100;
        }
        List<t> b2 = c.a().b();
        if (!b2.isEmpty() && E < b2.size()) {
            TreeMap treeMap = new TreeMap();
            for (t tVar : b2) {
                treeMap.put(tVar.g(), tVar);
            }
            HashSet hashSet = new HashSet();
            int size = (int) (b2.size() - (E * 0.75f));
            int i2 = 0;
            for (Map.Entry entry : treeMap.entrySet()) {
                if (entry != null && i2 < size) {
                    i2++;
                    ((Long) entry.getKey()).longValue();
                    t tVar2 = (t) entry.getValue();
                    if (tVar2 != null) {
                        hashSet.add(tVar2.b());
                    }
                }
            }
            a(hashSet);
            this.f28929b.set(false);
            return;
        }
        u.b("TmplDiffManager", "end doCheckAndDeleteTask maxTplCnt,local size" + E + ", 目前存储的模版的个数 " + b2.size());
    }

    public t a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return c.a().a(str);
    }

    public void a(l lVar) {
        if (lVar == null || lVar.S() == null) {
            return;
        }
        String b2 = lVar.S().b();
        String d2 = lVar.S().d();
        String c2 = lVar.S().c();
        String e2 = lVar.S().e();
        String a2 = lVar.S().a();
        int d3 = ak.d(lVar.ap());
        com.bytedance.sdk.openadsdk.core.h.i e3 = com.bytedance.sdk.openadsdk.core.h.i.a().a(b2).b(c2).c(d2).d(e2).e(a2);
        u.b("TmplDiffManager", "从物料中获取模版信息进行保存 rit " + d3);
        a(e3, d3 + "");
    }

    public void b(l lVar) {
        if (lVar == null || lVar.T() == null) {
            return;
        }
        String b2 = lVar.T().b();
        String d2 = lVar.T().d();
        String c2 = lVar.T().c();
        String e2 = lVar.T().e();
        String a2 = lVar.T().a();
        int d3 = ak.d(lVar.ap());
        com.bytedance.sdk.openadsdk.core.h.i e3 = com.bytedance.sdk.openadsdk.core.h.i.a().a(b2).b(c2).c(d2).d(e2).e(a2);
        a(e3, d3 + "");
    }

    public void a(com.bytedance.sdk.openadsdk.core.h.i iVar, String str) {
        if (iVar == null) {
            u.f("TmplDiffManager", "saveTemplate error: tplInfo == null");
            return;
        }
        final String str2 = iVar.f28343a;
        final String str3 = iVar.f28345c;
        final String str4 = iVar.f28344b;
        final String str5 = iVar.f28346d;
        final String str6 = iVar.f28347e;
        if (TextUtils.isEmpty(str)) {
            str = com.bytedance.sdk.openadsdk.core.i.d().g();
        }
        final String str7 = str;
        if (TextUtils.isEmpty(str2)) {
            u.f("TmplDiffManager", "saveTemplate error:tmpId is empty");
        } else {
            com.bytedance.sdk.openadsdk.l.e.a(new g("saveTemplate") { // from class: com.bytedance.sdk.openadsdk.core.widget.webview.a.d.1
                @Override // java.lang.Runnable
                public void run() {
                    d.this.a(str2, str3, str4, str5, str6, str7);
                }
            }, 10);
        }
    }

    private void b(String str, String str2, String str3, String str4, String str5, String str6) {
        c.a().a(new t().a(str).b(str2).c(str3).d(str4).e(str5).f(str6).a(Long.valueOf(System.currentTimeMillis())));
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(String str, String str2, String str3, String str4, String str5, String str6) {
        if (a(str) != null) {
            if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str3)) {
                b(str6, str, str3, str2, str4, str5);
            }
            return;
        } else if (TextUtils.isEmpty(str4)) {
            a(str2, str6, str);
        } else if (TextUtils.isEmpty(str3)) {
            a(str2, str6, str);
        } else {
            b(str6, str, str3, str2, str4, str5);
        }
        boolean b2 = f.b(str5);
        if (!a.e() || b2) {
            b.a().a(true);
        }
    }

    private void a(String str, String str2, String str3) {
        JSONObject c2;
        if (TextUtils.isEmpty(str) || (c2 = c(str)) == null) {
            return;
        }
        String optString = c2.optString(PackageTable.MD5);
        String optString2 = c2.optString("version");
        String optString3 = c2.optString("data");
        if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2) || TextUtils.isEmpty(optString3)) {
            return;
        }
        t a2 = new t().a(str2).b(str3).c(optString).d(str).e(optString3).f(optString2).a(Long.valueOf(System.currentTimeMillis()));
        c.a().a(a2);
        b();
        if (f.b(optString2)) {
            a2.f(optString2);
            b.a().a(true);
        }
    }

    public void a(Set<String> set) {
        try {
            c.a().a(set);
        } catch (Throwable th) {
            u.b("TmplDiffManager", th.getMessage());
        }
    }
}
