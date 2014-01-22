package com.baidu.tieba.util;

import android.content.Context;
import com.baidu.tieba.TiebaApplication;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class i {
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

    public String a(String str) {
        if (this.f != null) {
            return str + this.f;
        }
        return str;
    }

    public void a(boolean z) {
    }

    public void a(ArrayList<BasicNameValuePair> arrayList) {
        this.h = arrayList;
    }

    public void b(boolean z) {
        this.e = z;
    }

    public void b(String str) {
        this.f = str;
    }

    public void a() {
        this.l.clear();
    }

    public com.baidu.adp.widget.ImageView.d c(String str) {
        return com.baidu.tbadk.imageManager.d.a().b(str);
    }

    public com.baidu.adp.widget.ImageView.d d(String str) {
        return com.baidu.tbadk.imageManager.d.a().c(str);
    }

    public void e(String str) {
        com.baidu.tbadk.imageManager.d.a().a(str);
    }

    public static boolean b() {
        return c();
    }

    public static boolean c() {
        return ad.a() && com.baidu.adp.gif.g.a();
    }

    public com.baidu.adp.widget.ImageView.d a(String str, String str2, String str3, boolean z, com.baidu.tbadk.imageManager.c cVar, boolean z2) {
        String a = com.baidu.tieba.data.emotions.l.a().a(str2, z);
        com.baidu.adp.widget.ImageView.d c = com.baidu.tbadk.imageManager.d.a().c(a);
        if (c == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("em_sharp_text", str2);
            hashMap.put("em_load_gif", Boolean.valueOf(z));
            if (str != null) {
                hashMap.put("em_group_id", str);
            }
            if (str3 != null) {
                hashMap.put("em_img_url", str3);
            }
            return a(a, cVar, 6, true, false, false, false, hashMap, z2);
        }
        return c;
    }

    @Deprecated
    public com.baidu.adp.widget.ImageView.d a(String str, String str2, String str3, boolean z, com.baidu.tbadk.imageManager.c cVar) {
        return a(str, str2, str3, z, cVar, false);
    }

    @Deprecated
    public com.baidu.adp.widget.ImageView.d a(String str, boolean z, com.baidu.tbadk.imageManager.c cVar) {
        return a((String) null, str, (String) null, z, cVar);
    }

    @Deprecated
    public com.baidu.adp.widget.ImageView.d a(String str, com.baidu.tbadk.imageManager.c cVar) {
        return a(str, cVar, (Integer) 1, false, false);
    }

    @Deprecated
    public com.baidu.adp.widget.ImageView.d b(String str, boolean z, com.baidu.tbadk.imageManager.c cVar) {
        return a(str, z, false, cVar, false);
    }

    public com.baidu.adp.widget.ImageView.d a(String str, boolean z, boolean z2, com.baidu.tbadk.imageManager.c cVar) {
        return a(str, cVar, 0, true, false, z, z2, null, true);
    }

    public com.baidu.adp.widget.ImageView.d a(String str, boolean z, com.baidu.tbadk.imageManager.c cVar, boolean z2) {
        return a(str, z, false, cVar, z2);
    }

    public com.baidu.adp.widget.ImageView.d b(String str, com.baidu.tbadk.imageManager.c cVar) {
        return a(str, cVar, 0, true, false, false, false, null, true);
    }

    public com.baidu.adp.widget.ImageView.d a(String str, boolean z, boolean z2, com.baidu.tbadk.imageManager.c cVar, boolean z3) {
        return a(str, cVar, 0, true, false, z, z2, null, z3);
    }

    public com.baidu.adp.widget.ImageView.d a(String str, com.baidu.tbadk.imageManager.c cVar, boolean z) {
        return a(str, cVar, 0, true, false, false, false, null, z);
    }

    public com.baidu.adp.widget.ImageView.d a(String str, com.baidu.tbadk.imageManager.c cVar, boolean z, boolean z2) {
        return a(str, cVar, 0, true, z, false, false, null, z2);
    }

    public com.baidu.adp.widget.ImageView.d c(String str, com.baidu.tbadk.imageManager.c cVar) {
        return a(str, cVar, (Integer) 1, true, true);
    }

    public com.baidu.adp.widget.ImageView.d d(String str, com.baidu.tbadk.imageManager.c cVar) {
        return a(str, cVar, (Integer) 2, true, true);
    }

    public com.baidu.adp.widget.ImageView.d e(String str, com.baidu.tbadk.imageManager.c cVar) {
        return a(str, cVar, (Integer) 5, true, true);
    }

    public com.baidu.adp.widget.ImageView.d f(String str, com.baidu.tbadk.imageManager.c cVar) {
        return a(str, cVar, (Integer) 4, true, true);
    }

    private com.baidu.adp.widget.ImageView.d a(String str, com.baidu.tbadk.imageManager.c cVar, Integer num, boolean z, boolean z2) {
        return a(str, cVar, num.intValue(), z, false, false, false, null, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.adp.widget.ImageView.d a(String str, com.baidu.tbadk.imageManager.c cVar, int i, boolean z, boolean z2, boolean z3, boolean z4, Map<String, Object> map, boolean z5) {
        com.baidu.adp.widget.ImageView.d c;
        if (str == null) {
            by.a("", -1003, "", "");
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("url=");
        sb.append(str);
        String str2 = this.f != null ? str + this.f : str;
        sb.append("cacheImgUrl=");
        sb.append(str2);
        if (i == 0 || i == 4 || i == 5) {
            c = com.baidu.tbadk.imageManager.d.a().c(str2);
        } else if (i != 1 && i != 2) {
            c = null;
        } else {
            c = com.baidu.tbadk.imageManager.d.a().b(str2);
        }
        if (c != null) {
            if (cVar != null && z5) {
                cVar.a(c, str, true);
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
                } else if (!this.k.get(i2).d().equals(str)) {
                    i2++;
                } else {
                    this.k.get(i2).a(cVar);
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
                    k kVar = new k(this, null);
                    kVar.c = cVar;
                    kVar.a = str;
                    kVar.b = i;
                    kVar.d = z;
                    kVar.e = z3;
                    kVar.f = z4;
                    kVar.g = map;
                    this.l.add(kVar);
                    return null;
                }
                com.baidu.adp.lib.e.c.a().a(this.k.get(0).c, TiebaApplication.h());
            }
            l lVar2 = lVar != null ? lVar : new l(str, i, cVar, z, z3, z4, map);
            if (lVar != lVar2) {
                this.k.add(lVar2);
            }
            com.baidu.adp.lib.e.f fVar = new com.baidu.adp.lib.e.f();
            fVar.a("ImageAsyncTaskInfo", lVar2);
            fVar.a("AsyncImageLoader", this);
            fVar.a("param_immediatelyExecut", Boolean.valueOf(z2));
            if (map != null) {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    fVar.a(entry.getKey(), entry.getValue());
                }
            }
            int i4 = 2;
            int i5 = 1;
            if (i == 0 || i == 4 || i == 5) {
                i5 = 2;
            } else if (i == 6) {
                i5 = 3;
            }
            Object a = com.baidu.adp.lib.e.c.a().a(str, i5, new j(this, lVar2), TiebaApplication.h(), fVar, (i == 0 || i == 6) ? 1 : 1);
            if (a != null && (a instanceof com.baidu.adp.widget.ImageView.d)) {
                return (com.baidu.adp.widget.ImageView.d) a;
            }
        } catch (Exception e) {
            com.baidu.adp.lib.g.e.b("AsyncImageLoader", "loadBitmap", "error = " + e.getMessage());
            by.a("", -1008, "AsyncImageLoader.loadBitmap error: " + e.toString(), sb.toString());
        }
        return null;
    }

    public void d() {
        this.l.clear();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.k.size()) {
                l lVar = this.k.get(i2);
                if (lVar != null) {
                    com.baidu.adp.lib.e.c.a().a(lVar.c, TiebaApplication.h());
                }
                i = i2 + 1;
            } else {
                this.k.clear();
                return;
            }
        }
    }

    public void a(int i, int i2) {
        this.b = i;
        this.c = i2;
    }

    public void c(boolean z) {
        this.g = z;
    }

    public boolean e() {
        return this.i;
    }

    public void d(boolean z) {
        this.i = z;
    }

    public String f() {
        return this.j;
    }

    public void f(String str) {
        this.j = str;
    }
}
