package com.baidu.tieba.util;

import android.content.Context;
import com.baidu.tieba.TiebaApplication;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public final class i {
    public Context a;
    public boolean d;
    public boolean e;
    public String f;
    public boolean g;
    private boolean i = false;
    private String j = "other";
    public ArrayList<BasicNameValuePair> h = null;
    public int b = 0;
    public int c = 0;
    private LinkedList<l> k = new LinkedList<>();
    private LinkedList<k> l = new LinkedList<>();

    public i(Context context) {
        this.d = false;
        this.e = false;
        this.f = null;
        this.g = false;
        this.a = context;
        this.d = true;
        this.f = null;
        this.e = false;
        this.g = false;
    }

    public final String a(String str) {
        if (this.f != null) {
            return String.valueOf(str) + this.f;
        }
        return str;
    }

    public final void a() {
        this.l.clear();
    }

    public static boolean b() {
        return af.a() && com.baidu.adp.gif.f.a();
    }

    @Deprecated
    public final com.baidu.adp.widget.ImageView.b a(String str, String str2, String str3, boolean z, com.baidu.tbadk.imageManager.d dVar) {
        String a = com.baidu.tieba.data.emotions.l.a().a(str2, z);
        com.baidu.adp.widget.ImageView.b c = com.baidu.tbadk.imageManager.e.a().c(a);
        if (c != null) {
            return c;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("em_sharp_text", str2);
        hashMap.put("em_load_gif", Boolean.valueOf(z));
        if (str != null) {
            hashMap.put("em_group_id", str);
        }
        if (str3 != null) {
            hashMap.put("em_img_url", str3);
        }
        return a(a, dVar, 6, true, false, false, false, hashMap, false);
    }

    @Deprecated
    public final com.baidu.adp.widget.ImageView.b a(String str, boolean z, com.baidu.tbadk.imageManager.d dVar) {
        return a((String) null, str, (String) null, z, dVar);
    }

    @Deprecated
    public final com.baidu.adp.widget.ImageView.b a(String str, com.baidu.tbadk.imageManager.d dVar) {
        return a(str, dVar, (Integer) 1, false, false);
    }

    @Deprecated
    public final com.baidu.adp.widget.ImageView.b b(String str, boolean z, com.baidu.tbadk.imageManager.d dVar) {
        return a(str, true, false, dVar, false);
    }

    public final com.baidu.adp.widget.ImageView.b a(String str, boolean z, boolean z2, com.baidu.tbadk.imageManager.d dVar) {
        return a(str, dVar, 0, true, false, false, true, null, true);
    }

    public final com.baidu.adp.widget.ImageView.b b(String str, com.baidu.tbadk.imageManager.d dVar) {
        return a(str, dVar, 0, true, false, false, false, null, true);
    }

    public final com.baidu.adp.widget.ImageView.b a(String str, boolean z, boolean z2, com.baidu.tbadk.imageManager.d dVar, boolean z3) {
        return a(str, dVar, 0, true, false, z, false, null, z3);
    }

    public final com.baidu.adp.widget.ImageView.b a(String str, com.baidu.tbadk.imageManager.d dVar, boolean z) {
        return a(str, dVar, 0, true, false, false, false, null, false);
    }

    public final com.baidu.adp.widget.ImageView.b a(String str, com.baidu.tbadk.imageManager.d dVar, boolean z, boolean z2) {
        return a(str, dVar, 0, true, true, false, false, null, true);
    }

    public final com.baidu.adp.widget.ImageView.b c(String str, com.baidu.tbadk.imageManager.d dVar) {
        return a(str, dVar, (Integer) 1, true, true);
    }

    public final com.baidu.adp.widget.ImageView.b d(String str, com.baidu.tbadk.imageManager.d dVar) {
        return a(str, dVar, (Integer) 2, true, true);
    }

    public final com.baidu.adp.widget.ImageView.b e(String str, com.baidu.tbadk.imageManager.d dVar) {
        return a(str, dVar, (Integer) 5, true, true);
    }

    public final com.baidu.adp.widget.ImageView.b f(String str, com.baidu.tbadk.imageManager.d dVar) {
        return a(str, dVar, (Integer) 4, true, true);
    }

    private com.baidu.adp.widget.ImageView.b a(String str, com.baidu.tbadk.imageManager.d dVar, Integer num, boolean z, boolean z2) {
        return a(str, dVar, num.intValue(), z, false, false, false, null, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.adp.widget.ImageView.b a(String str, com.baidu.tbadk.imageManager.d dVar, int i, boolean z, boolean z2, boolean z3, boolean z4, Map<String, Object> map, boolean z5) {
        com.baidu.adp.widget.ImageView.b c;
        if (str == null) {
            cb.a("", -1003, "", "");
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("url=");
        sb.append(str);
        String str2 = this.f != null ? String.valueOf(str) + this.f : str;
        sb.append("cacheImgUrl=");
        sb.append(str2);
        if (i == 0 || i == 4 || i == 5) {
            c = com.baidu.tbadk.imageManager.e.a().c(str2);
        } else if (i != 1 && i != 2) {
            c = null;
        } else {
            c = com.baidu.tbadk.imageManager.e.a().b(str2);
        }
        if (c != null) {
            if (dVar != null && z5) {
                dVar.a(c, str, true);
                return c;
            }
            return c;
        }
        boolean z6 = i == 6;
        l lVar = null;
        try {
            int size = this.k.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    break;
                } else if (!this.k.get(i2).c.equals(str)) {
                    i2++;
                } else {
                    l lVar2 = this.k.get(i2);
                    if (lVar2.b == null) {
                        lVar2.b = new HashSet<>();
                    }
                    lVar2.b.add(dVar);
                    if (z2) {
                        lVar = this.k.get(i2);
                    } else {
                        return null;
                    }
                }
            }
            if ((z6 || this.d) && this.l != null) {
                int size2 = this.l.size();
                int i3 = 0;
                while (true) {
                    if (i3 >= size2) {
                        break;
                    } else if (this.l.get(i3).a == null || !this.l.get(i3).a.equals(str)) {
                        i3++;
                    } else if (z2) {
                        this.l.remove(i3);
                    } else {
                        return null;
                    }
                }
            }
            if (!z2 && this.k.size() >= 5) {
                if (this.d || z6) {
                    k kVar = new k(this, (byte) 0);
                    kVar.c = dVar;
                    kVar.a = str;
                    kVar.b = i;
                    kVar.d = z;
                    kVar.e = z3;
                    kVar.f = z4;
                    kVar.g = map;
                    this.l.add(kVar);
                    return null;
                }
                com.baidu.adp.lib.e.c.a().a(this.k.get(0).c, TiebaApplication.g().b());
            }
            l lVar3 = lVar != null ? lVar : new l(str, i, dVar, z, z3, z4, map);
            if (lVar != lVar3) {
                this.k.add(lVar3);
            }
            com.baidu.adp.lib.e.h hVar = new com.baidu.adp.lib.e.h();
            hVar.a("ImageAsyncTaskInfo", lVar3);
            hVar.a("AsyncImageLoader", this);
            hVar.a("param_immediatelyExecut", Boolean.valueOf(z2));
            if (map != null) {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    hVar.a(entry.getKey(), entry.getValue());
                }
            }
            int i4 = 2;
            int i5 = 1;
            if (i == 0 || i == 4 || i == 5) {
                i5 = 2;
            } else if (i == 6) {
                i5 = 3;
            }
            Object a = com.baidu.adp.lib.e.c.a().a(str, i5, new j(this, lVar3), TiebaApplication.g().b(), hVar, (i == 0 || i == 6) ? 1 : 1);
            if (a != null && (a instanceof com.baidu.adp.widget.ImageView.b)) {
                return (com.baidu.adp.widget.ImageView.b) a;
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b("AsyncImageLoader", "loadBitmap", "error = " + e.getMessage());
            cb.a("", -1008, "AsyncImageLoader.loadBitmap error: " + e.toString(), sb.toString());
        }
        return null;
    }

    public final void c() {
        this.l.clear();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.k.size()) {
                l lVar = this.k.get(i2);
                if (lVar != null) {
                    com.baidu.adp.lib.e.c.a().a(lVar.c, TiebaApplication.g().b());
                }
                i = i2 + 1;
            } else {
                this.k.clear();
                return;
            }
        }
    }

    public final void a(int i, int i2) {
        this.b = i;
        this.c = i2;
    }

    public final boolean d() {
        return this.i;
    }

    public final void a(boolean z) {
        this.i = z;
    }

    public final String e() {
        return this.j;
    }

    public final void b(String str) {
        this.j = str;
    }
}
