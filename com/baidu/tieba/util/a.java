package com.baidu.tieba.util;

import android.content.Context;
import com.baidu.tieba.TiebaApplication;
import java.util.ArrayList;
import java.util.LinkedList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f1889a;
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
        this.f1889a = context;
        this.d = true;
        this.f = null;
        this.e = false;
        this.g = false;
    }

    public String a(String str) {
        if (this.f != null) {
            return String.valueOf(str) + this.f;
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

    public com.baidu.adp.widget.a.c c(String str) {
        return com.baidu.tbadk.a.e.a().b(str);
    }

    public com.baidu.adp.widget.a.c d(String str) {
        return com.baidu.tbadk.a.e.a().c(str);
    }

    public void e(String str) {
        com.baidu.tbadk.a.e.a().a(str);
    }

    public com.baidu.adp.widget.a.c a(String str, com.baidu.tbadk.a.d dVar) {
        return a(str, dVar, 0, true);
    }

    public com.baidu.adp.widget.a.c b(String str, com.baidu.tbadk.a.d dVar) {
        return a(str, dVar, 1, true);
    }

    public com.baidu.adp.widget.a.c c(String str, com.baidu.tbadk.a.d dVar) {
        return a(str, dVar, 1, false);
    }

    public com.baidu.adp.widget.a.c d(String str, com.baidu.tbadk.a.d dVar) {
        return a(str, dVar, 2, true);
    }

    public com.baidu.adp.widget.a.c e(String str, com.baidu.tbadk.a.d dVar) {
        return a(str, dVar, 4, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.adp.widget.a.c a(String str, com.baidu.tbadk.a.d dVar, Integer num, boolean z) {
        com.baidu.adp.widget.a.c c;
        if (str == null) {
            return null;
        }
        String str2 = this.f != null ? String.valueOf(str) + this.f : str;
        if (num.intValue() == 0 || num.intValue() == 4) {
            c = com.baidu.tbadk.a.e.a().c(str2);
        } else {
            c = com.baidu.tbadk.a.e.a().b(str2);
        }
        if (c == null) {
            try {
                int size = this.j.size();
                for (int i = 0; i < size; i++) {
                    if (this.j.get(i).b().equals(str)) {
                        return null;
                    }
                }
                if (this.d && this.k != null) {
                    int size2 = this.k.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        if (this.k.get(i2).f1917a != null && this.k.get(i2).f1917a.equals(str)) {
                            return null;
                        }
                    }
                }
                if (this.j.size() >= 5) {
                    if (this.d) {
                        c cVar = new c(this, null);
                        cVar.c = dVar;
                        cVar.f1917a = str;
                        cVar.b = num.intValue();
                        cVar.d = z;
                        this.k.add(cVar);
                        return null;
                    }
                    com.baidu.adp.lib.c.c.a().a(this.j.get(0).c, TiebaApplication.g());
                }
                d dVar2 = new d(str, num.intValue(), dVar, z);
                this.j.add(dVar2);
                com.baidu.adp.lib.c.f fVar = new com.baidu.adp.lib.c.f();
                fVar.a("ImageAsyncTaskInfo", dVar2);
                fVar.a("AsyncImageLoader", this);
                Object a2 = com.baidu.adp.lib.c.c.a().a(str, (num.intValue() == 0 || num.intValue() == 4) ? 2 : 1, new b(this, dVar2), TiebaApplication.g(), fVar, num.intValue() != 0 ? 2 : 1);
                if (a2 != null && (a2 instanceof com.baidu.adp.widget.a.c)) {
                    return (com.baidu.adp.widget.a.c) a2;
                }
            } catch (Exception e) {
                av.b("AsyncImageLoader", "loadBitmap", "error = " + e.getMessage());
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
                    com.baidu.adp.lib.c.c.a().a(dVar.c, TiebaApplication.g());
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
