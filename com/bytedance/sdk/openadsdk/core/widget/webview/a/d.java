package com.bytedance.sdk.openadsdk.core.widget.webview.a;

import android.text.TextUtils;
import com.bytedance.sdk.adnet.b.i;
import com.bytedance.sdk.adnet.b.j;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.d.q;
import com.bytedance.sdk.openadsdk.core.h.m;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.u;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static volatile d f6832a;

    /* renamed from: b  reason: collision with root package name */
    private AtomicBoolean f6833b = new AtomicBoolean(false);

    public static d a() {
        if (f6832a == null) {
            synchronized (d.class) {
                if (f6832a == null) {
                    f6832a = new d();
                }
            }
        }
        return f6832a;
    }

    private d() {
    }

    public q a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return c.a().a(str);
    }

    public Set<String> b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return c.a().b(str);
    }

    private void b() {
        int i;
        if (p.h() != null) {
            int F = p.h().F();
            int i2 = F <= 0 ? 100 : F;
            List<q> b2 = c.a().b();
            if (b2.isEmpty() || i2 >= b2.size()) {
                u.b("TmplDiffManager", "end doCheckAndDeleteTask maxTplCnt,local size" + i2 + ", 目前存储的模版的个数 " + b2.size());
                return;
            }
            TreeMap treeMap = new TreeMap();
            for (q qVar : b2) {
                treeMap.put(qVar.g(), qVar);
            }
            HashSet hashSet = new HashSet();
            int size = (int) (b2.size() - (i2 * 0.75f));
            int i3 = 0;
            for (Map.Entry entry : treeMap.entrySet()) {
                if (entry != null) {
                    if (i3 < size) {
                        int i4 = i3 + 1;
                        ((Long) entry.getKey()).longValue();
                        q qVar2 = (q) entry.getValue();
                        if (qVar2 == null) {
                            i3 = i4;
                        } else {
                            hashSet.add(qVar2.b());
                            i = i4;
                        }
                    } else {
                        i = i3;
                    }
                    i3 = i;
                }
            }
            a(hashSet);
            this.f6833b.set(false);
        }
    }

    private JSONObject c(String str) {
        i eop = i.eop();
        new j(0, str, eop).setShouldCache(false).build(com.bytedance.sdk.openadsdk.i.e.a(p.a()).d());
        try {
            com.bytedance.sdk.adnet.core.p pVar = eop.get();
            if (pVar != null && pVar.a() && pVar.f6045a != 0) {
                return new JSONObject((String) pVar.f6045a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void a(l lVar) {
        if (lVar != null && lVar.B() != null) {
            String b2 = lVar.B().b();
            String d = lVar.B().d();
            String c = lVar.B().c();
            String e = lVar.B().e();
            String a2 = lVar.B().a();
            int d2 = aj.d(lVar.W());
            m e2 = m.a().a(b2).b(c).c(d).d(e).e(a2);
            u.b("TmplDiffManager", "从物料中获取模版信息进行保存 rit " + d2);
            a(e2, d2 + "");
        }
    }

    public void a(m mVar, String str) {
        if (mVar == null) {
            u.f("TmplDiffManager", "saveTemplate error: tplInfo == null");
            return;
        }
        final String str2 = mVar.f6599a;
        final String str3 = mVar.c;
        final String str4 = mVar.f6600b;
        final String str5 = mVar.d;
        final String str6 = mVar.e;
        final String e = TextUtils.isEmpty(str) ? com.bytedance.sdk.openadsdk.core.i.c().e() : str;
        if (TextUtils.isEmpty(str2)) {
            u.f("TmplDiffManager", "saveTemplate error:tmpId is empty");
        } else {
            com.bytedance.sdk.openadsdk.k.a.a().c(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.widget.webview.a.d.1
                @Override // java.lang.Runnable
                public void run() {
                    d.this.a(str2, str3, str4, str5, str6, e);
                }
            }, 10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(String str, String str2, String str3, String str4, String str5, String str6) {
        if (a(str) != null) {
            if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str3)) {
                b(str6, str, str3, str2, str4, str5);
            }
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

    private void b(String str, String str2, String str3, String str4, String str5, String str6) {
        c.a().a(new q().a(str).b(str2).c(str3).d(str4).e(str5).f(str6).a(Long.valueOf(System.currentTimeMillis())));
        b();
    }

    private void a(String str, String str2, String str3) {
        JSONObject c;
        if (!TextUtils.isEmpty(str) && (c = c(str)) != null) {
            String optString = c.optString("md5");
            String optString2 = c.optString("version");
            String optString3 = c.optString("data");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3)) {
                q a2 = new q().a(str2).b(str3).c(optString).d(str).e(optString3).f(optString2).a(Long.valueOf(System.currentTimeMillis()));
                c.a().a(a2);
                b();
                if (f.b(optString2)) {
                    a2.f(optString2);
                    b.a().a(true);
                }
            }
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
