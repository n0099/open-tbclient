package com.bytedance.sdk.openadsdk.core.widget.webview.a;

import android.text.TextUtils;
import com.bytedance.sdk.adnet.b.i;
import com.bytedance.sdk.adnet.b.j;
import com.bytedance.sdk.adnet.core.o;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.d.r;
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
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static volatile d f4633a;
    private AtomicBoolean b = new AtomicBoolean(false);

    public static d a() {
        if (f4633a == null) {
            synchronized (d.class) {
                if (f4633a == null) {
                    f4633a = new d();
                }
            }
        }
        return f4633a;
    }

    private d() {
    }

    public r a(String str) {
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
            int E = p.h().E();
            int i2 = E <= 0 ? 100 : E;
            List<r> b = c.a().b();
            if (b.isEmpty() || i2 >= b.size()) {
                u.b("TmplDiffManager", "end doCheckAndDeleteTask maxTplCnt,local size" + i2 + ", 目前存储的模版的个数 " + b.size());
                return;
            }
            TreeMap treeMap = new TreeMap();
            for (r rVar : b) {
                treeMap.put(rVar.g(), rVar);
            }
            HashSet hashSet = new HashSet();
            int size = (int) (b.size() - (i2 * 0.75f));
            int i3 = 0;
            for (Map.Entry entry : treeMap.entrySet()) {
                if (entry != null) {
                    if (i3 < size) {
                        int i4 = i3 + 1;
                        ((Long) entry.getKey()).longValue();
                        r rVar2 = (r) entry.getValue();
                        if (rVar2 == null) {
                            i3 = i4;
                        } else {
                            hashSet.add(rVar2.b());
                            i = i4;
                        }
                    } else {
                        i = i3;
                    }
                    i3 = i;
                }
            }
            a(hashSet);
            this.b.set(false);
        }
    }

    private JSONObject c(String str) {
        i eqX = i.eqX();
        new j(0, str, eqX).setShouldCache(false).build(com.bytedance.sdk.openadsdk.h.d.a(p.a()).d());
        try {
            o oVar = eqX.get();
            if (oVar != null && oVar.a() && oVar.f4049a != 0) {
                return new JSONObject((String) oVar.f4049a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void a(l lVar) {
        if (lVar != null && lVar.M() != null) {
            String b = lVar.M().b();
            String d = lVar.M().d();
            String c = lVar.M().c();
            String e = lVar.M().e();
            String a2 = lVar.M().a();
            int d2 = aj.d(lVar.aj());
            com.bytedance.sdk.openadsdk.core.h.i e2 = com.bytedance.sdk.openadsdk.core.h.i.a().a(b).b(c).c(d).d(e).e(a2);
            u.b("TmplDiffManager", "从物料中获取模版信息进行保存 rit " + d2);
            a(e2, d2 + "");
        }
    }

    public void b(l lVar) {
        if (lVar != null && lVar.N() != null) {
            String b = lVar.N().b();
            String d = lVar.N().d();
            String c = lVar.N().c();
            String e = lVar.N().e();
            a(com.bytedance.sdk.openadsdk.core.h.i.a().a(b).b(c).c(d).d(e).e(lVar.N().a()), aj.d(lVar.aj()) + "");
        }
    }

    public void a(com.bytedance.sdk.openadsdk.core.h.i iVar, String str) {
        if (iVar == null) {
            u.f("TmplDiffManager", "saveTemplate error: tplInfo == null");
            return;
        }
        final String str2 = iVar.f4460a;
        final String str3 = iVar.c;
        final String str4 = iVar.b;
        final String str5 = iVar.d;
        final String str6 = iVar.e;
        final String f = TextUtils.isEmpty(str) ? com.bytedance.sdk.openadsdk.core.i.d().f() : str;
        if (TextUtils.isEmpty(str2)) {
            u.f("TmplDiffManager", "saveTemplate error:tmpId is empty");
        } else {
            com.bytedance.sdk.openadsdk.j.e.a(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.widget.webview.a.d.1
                @Override // java.lang.Runnable
                public void run() {
                    d.this.a(str2, str3, str4, str5, str6, f);
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
        boolean b = f.b(str5);
        if (!a.e() || b) {
            b.a().a(true);
        }
    }

    private void b(String str, String str2, String str3, String str4, String str5, String str6) {
        c.a().a(new r().a(str).b(str2).c(str3).d(str4).e(str5).f(str6).a(Long.valueOf(System.currentTimeMillis())));
        b();
    }

    private void a(String str, String str2, String str3) {
        JSONObject c;
        if (!TextUtils.isEmpty(str) && (c = c(str)) != null) {
            String optString = c.optString("md5");
            String optString2 = c.optString("version");
            String optString3 = c.optString("data");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3)) {
                r a2 = new r().a(str2).b(str3).c(optString).d(str).e(optString3).f(optString2).a(Long.valueOf(System.currentTimeMillis()));
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
