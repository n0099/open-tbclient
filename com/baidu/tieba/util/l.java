package com.baidu.tieba.util;

import android.graphics.Bitmap;
import java.util.HashSet;
import java.util.Map;
/* loaded from: classes.dex */
public class l {
    public HashSet<com.baidu.tbadk.imageManager.c> b;
    public String c;
    public volatile int d;
    public volatile Bitmap e;
    public boolean g;
    public volatile com.baidu.adp.widget.ImageView.d i;
    public boolean k;
    public boolean l;
    public Map<String, Object> m;
    public volatile at a = null;
    public boolean f = true;
    public volatile boolean h = false;
    public boolean j = false;
    private boolean n = false;

    public boolean a() {
        return this.n;
    }

    public void a(boolean z) {
        this.n = z;
    }

    public l(String str, int i, com.baidu.tbadk.imageManager.c cVar, boolean z, boolean z2, boolean z3, Map<String, Object> map) {
        this.b = null;
        this.c = null;
        this.d = 0;
        this.e = null;
        this.g = false;
        this.k = false;
        this.l = false;
        this.c = str;
        this.d = i;
        this.b = new HashSet<>();
        this.b.add(cVar);
        this.e = null;
        this.g = z;
        this.l = z2;
        this.k = z3;
        this.m = map;
    }

    public String b() {
        Object obj;
        return (this.d != 6 || this.m == null || (obj = this.m.get("em_sharp_text")) == null) ? this.c : obj.toString();
    }

    public void a(com.baidu.tbadk.imageManager.c cVar) {
        if (this.b == null) {
            this.b = new HashSet<>();
        }
        this.b.add(cVar);
    }

    public void c() {
        this.j = true;
        if (this.a != null) {
            this.a.j();
        }
    }

    public String d() {
        return this.c;
    }
}
