package com.baidu.tieba.util;

import android.graphics.Bitmap;
import java.util.HashSet;
/* loaded from: classes.dex */
public class l {
    public HashSet<com.baidu.tbadk.imageManager.c> b;
    public String c;
    public volatile int d;
    public volatile Bitmap e;
    public boolean g;
    public volatile com.baidu.adp.widget.ImageView.e i;
    public boolean k;
    public boolean l;

    /* renamed from: a  reason: collision with root package name */
    public volatile ap f2495a = null;
    public boolean f = true;
    public volatile boolean h = false;
    public boolean j = false;

    public l(String str, int i, com.baidu.tbadk.imageManager.c cVar, boolean z, boolean z2, boolean z3) {
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
    }

    public void a(com.baidu.tbadk.imageManager.c cVar) {
        if (this.b == null) {
            this.b = new HashSet<>();
        }
        this.b.add(cVar);
    }

    public void a() {
        this.j = true;
        if (this.f2495a != null) {
            this.f2495a.h();
        }
    }

    public String b() {
        return this.c;
    }
}
