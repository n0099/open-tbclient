package com.baidu.tieba.util;

import android.content.Context;
import com.baidu.tieba.TiebaApplication;
import java.util.ArrayList;
import java.util.LinkedList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f2411a;
    public boolean d;
    public boolean e;
    public String f;
    public boolean g;
    private boolean i = false;
    public ArrayList<BasicNameValuePair> h = null;
    public int b = 0;
    public int c = 0;
    private LinkedList<d> j = new LinkedList<>();
    private LinkedList<c> k = new LinkedList<>();

    public a(Context context) {
        this.d = false;
        this.e = false;
        this.f = null;
        this.g = false;
        this.f2411a = context;
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
        this.k.clear();
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
        return a(str, cVar, 0, true, z, z2);
    }

    public com.baidu.adp.widget.ImageView.e a(String str, com.baidu.tbadk.imageManager.c cVar) {
        return a(str, cVar, (Integer) 0, true);
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
        return a(str, cVar, (Integer) 4, true);
    }

    private com.baidu.adp.widget.ImageView.e a(String str, com.baidu.tbadk.imageManager.c cVar, Integer num, boolean z) {
        return a(str, cVar, num, z, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.adp.widget.ImageView.e a(String str, com.baidu.tbadk.imageManager.c cVar, Integer num, boolean z, boolean z2, boolean z3) {
        com.baidu.adp.widget.ImageView.e c;
        if (str == null) {
            return null;
        }
        String str2 = this.f != null ? str + this.f : str;
        if (num.intValue() == 0 || num.intValue() == 4) {
            c = com.baidu.tbadk.imageManager.d.a().c(str2);
        } else {
            c = com.baidu.tbadk.imageManager.d.a().b(str2);
        }
        if (c == null) {
            try {
                int size = this.j.size();
                for (int i = 0; i < size; i++) {
                    if (this.j.get(i).b().equals(str)) {
                        this.j.get(i).a(cVar);
                        return null;
                    }
                }
                if (this.d && this.k != null) {
                    int size2 = this.k.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        if (this.k.get(i2).f2447a != null && this.k.get(i2).f2447a.equals(str)) {
                            return null;
                        }
                    }
                }
                if (this.j.size() >= 5) {
                    if (this.d) {
                        c cVar2 = new c(this, null);
                        cVar2.c = cVar;
                        cVar2.f2447a = str;
                        cVar2.b = num.intValue();
                        cVar2.d = z;
                        cVar2.e = z2;
                        cVar2.f = z3;
                        this.k.add(cVar2);
                        return null;
                    }
                    com.baidu.adp.lib.e.c.a().a(this.j.get(0).c, TiebaApplication.g());
                }
                d dVar = new d(str, num.intValue(), cVar, z, z2, z3);
                this.j.add(dVar);
                com.baidu.adp.lib.e.f fVar = new com.baidu.adp.lib.e.f();
                fVar.a("ImageAsyncTaskInfo", dVar);
                fVar.a("AsyncImageLoader", this);
                int i3 = 2;
                int i4 = 1;
                i4 = (num.intValue() == 0 || num.intValue() == 4) ? 2 : 2;
                if (num.intValue() == 0) {
                    i3 = 1;
                }
                Object a2 = com.baidu.adp.lib.e.c.a().a(str, i4, new b(this, dVar), TiebaApplication.g(), fVar, i3);
                if (a2 != null && (a2 instanceof com.baidu.adp.widget.ImageView.e)) {
                    return (com.baidu.adp.widget.ImageView.e) a2;
                }
            } catch (Exception e) {
                be.b("AsyncImageLoader", "loadBitmap", "error = " + e.getMessage());
            }
            return null;
        }
        return c;
    }

    public void b() {
        this.k.clear();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.j.size()) {
                d dVar = this.j.get(i2);
                if (dVar != null) {
                    com.baidu.adp.lib.e.c.a().a(dVar.c, TiebaApplication.g());
                }
                i = i2 + 1;
            } else {
                this.j.clear();
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
}
