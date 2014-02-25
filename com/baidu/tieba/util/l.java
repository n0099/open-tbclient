package com.baidu.tieba.util;

import android.graphics.Bitmap;
import java.util.HashSet;
import java.util.Map;
/* loaded from: classes.dex */
public class l {
    public HashSet<com.baidu.tbadk.imageManager.d> b;
    public String c;
    public volatile int d;
    public volatile Bitmap e;
    public boolean g;
    public volatile com.baidu.adp.widget.ImageView.b i;
    public boolean o;
    public boolean p;
    public Map<String, Object> q;
    public volatile ba a = null;
    public boolean f = false;
    public volatile boolean h = false;
    public byte[] j = null;
    public String k = null;
    public String l = null;
    public String m = null;
    public boolean n = false;
    private boolean r = false;

    public boolean a() {
        return this.r;
    }

    public void a(boolean z) {
        this.r = z;
    }

    public l(String str, int i, com.baidu.tbadk.imageManager.d dVar, boolean z, boolean z2, boolean z3, Map<String, Object> map) {
        this.b = null;
        this.c = null;
        this.d = 0;
        this.e = null;
        this.g = false;
        this.o = false;
        this.p = false;
        this.c = str;
        this.d = i;
        this.b = new HashSet<>();
        this.b.add(dVar);
        this.e = null;
        this.g = z;
        this.p = z2;
        this.o = z3;
        this.q = map;
    }

    public String b() {
        Object obj;
        return (this.d != 6 || this.q == null || (obj = this.q.get("em_sharp_text")) == null) ? this.c : obj.toString();
    }

    public void a(com.baidu.tbadk.imageManager.d dVar) {
        if (this.b == null) {
            this.b = new HashSet<>();
        }
        this.b.add(dVar);
    }

    public void c() {
        this.n = true;
        if (this.a != null) {
            this.a.k();
        }
    }

    public String d() {
        return this.c;
    }
}
