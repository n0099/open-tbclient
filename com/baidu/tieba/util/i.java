package com.baidu.tieba.util;

import android.content.Context;
import com.baidu.tieba.TiebaApplication;
import java.util.ArrayList;
import java.util.LinkedList;
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

    public com.baidu.adp.widget.ImageView.e c(String str) {
        return com.baidu.tbadk.imageManager.d.a().b(str);
    }

    public com.baidu.adp.widget.ImageView.e d(String str) {
        return com.baidu.tbadk.imageManager.d.a().c(str);
    }

    public void e(String str) {
        com.baidu.tbadk.imageManager.d.a().a(str);
    }

    public com.baidu.adp.widget.ImageView.e a(String str, boolean z, com.baidu.tbadk.imageManager.c cVar) {
        return a(str, z, false, cVar);
    }

    public com.baidu.adp.widget.ImageView.e a(String str, boolean z, boolean z2, com.baidu.tbadk.imageManager.c cVar) {
        return a(str, cVar, 0, true, false, z, z2);
    }

    public com.baidu.adp.widget.ImageView.e a(String str, com.baidu.tbadk.imageManager.c cVar) {
        return a(str, cVar, 0, true, false, false, false);
    }

    public com.baidu.adp.widget.ImageView.e a(String str, com.baidu.tbadk.imageManager.c cVar, boolean z) {
        return a(str, cVar, 0, true, z, false, false);
    }

    public com.baidu.adp.widget.ImageView.e b(String str, com.baidu.tbadk.imageManager.c cVar) {
        return a(str, cVar, (Integer) 1, true);
    }

    public com.baidu.adp.widget.ImageView.e c(String str, com.baidu.tbadk.imageManager.c cVar) {
        return a(str, cVar, (Integer) 1, false);
    }

    public com.baidu.adp.widget.ImageView.e d(String str, com.baidu.tbadk.imageManager.c cVar) {
        return a(str, cVar, (Integer) 2, true);
    }

    public com.baidu.adp.widget.ImageView.e e(String str, com.baidu.tbadk.imageManager.c cVar) {
        return a(str, cVar, (Integer) 5, true);
    }

    public com.baidu.adp.widget.ImageView.e f(String str, com.baidu.tbadk.imageManager.c cVar) {
        return a(str, cVar, (Integer) 4, true);
    }

    private com.baidu.adp.widget.ImageView.e a(String str, com.baidu.tbadk.imageManager.c cVar, Integer num, boolean z) {
        return a(str, cVar, num, z, false, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.adp.widget.ImageView.e a(String str, com.baidu.tbadk.imageManager.c cVar, Integer num, boolean z, boolean z2, boolean z3, boolean z4) {
        com.baidu.adp.widget.ImageView.e c;
        if (str == null) {
            return null;
        }
        String str2 = this.f != null ? str + this.f : str;
        if (num.intValue() == 0 || num.intValue() == 4 || num.intValue() == 5) {
            c = com.baidu.tbadk.imageManager.d.a().c(str2);
        } else {
            c = com.baidu.tbadk.imageManager.d.a().b(str2);
        }
        if (c == null) {
            l lVar = null;
            try {
                int size = this.k.size();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        break;
                    } else if (!this.k.get(i).b().equals(str)) {
                        i++;
                    } else {
                        this.k.get(i).a(cVar);
                        if (z2) {
                            lVar = this.k.get(i);
                        } else {
                            return null;
                        }
                    }
                }
                if (this.d && this.l != null) {
                    int size2 = this.l.size();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= size2) {
                            break;
                        } else if (this.l.get(i2).a == null || !this.l.get(i2).a.equals(str)) {
                            i2++;
                        } else if (z2) {
                            this.l.remove(i2);
                        } else {
                            return null;
                        }
                    }
                }
                if (!z2 && this.k.size() >= 5) {
                    if (this.d) {
                        k kVar = new k(this, null);
                        kVar.c = cVar;
                        kVar.a = str;
                        kVar.b = num.intValue();
                        kVar.d = z;
                        kVar.e = z3;
                        kVar.f = z4;
                        this.l.add(kVar);
                        return null;
                    }
                    com.baidu.adp.lib.e.c.a().a(this.k.get(0).c, TiebaApplication.h());
                }
                l lVar2 = lVar != null ? lVar : new l(str, num.intValue(), cVar, z, z3, z4);
                if (lVar != lVar2) {
                    this.k.add(lVar2);
                }
                com.baidu.adp.lib.e.f fVar = new com.baidu.adp.lib.e.f();
                fVar.a("ImageAsyncTaskInfo", lVar2);
                fVar.a("AsyncImageLoader", this);
                fVar.a("param_immediatelyExecut", Boolean.valueOf(z2));
                int i3 = 2;
                int i4 = 1;
                i4 = (num.intValue() == 0 || num.intValue() == 4 || num.intValue() == 5) ? 2 : 2;
                if (num.intValue() == 0) {
                    i3 = 1;
                }
                Object a = com.baidu.adp.lib.e.c.a().a(str, i4, new j(this, lVar2), TiebaApplication.h(), fVar, i3);
                if (a != null && (a instanceof com.baidu.adp.widget.ImageView.e)) {
                    return (com.baidu.adp.widget.ImageView.e) a;
                }
            } catch (Exception e) {
                be.b("AsyncImageLoader", "loadBitmap", "error = " + e.getMessage());
            }
            return null;
        }
        return c;
    }

    public void b() {
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

    public boolean c() {
        return this.i;
    }

    public void d(boolean z) {
        this.i = z;
    }

    public String d() {
        return this.j;
    }

    public void f(String str) {
        this.j = str;
    }
}
