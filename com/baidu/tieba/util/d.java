package com.baidu.tieba.util;

import android.graphics.Bitmap;
/* loaded from: classes.dex */
public class d {
    public com.baidu.tbadk.a.d b;
    public String c;
    public volatile int d;
    public volatile Bitmap e;
    public boolean g;
    public volatile com.baidu.adp.widget.a.c i;

    /* renamed from: a  reason: collision with root package name */
    public volatile z f1918a = null;
    public boolean f = true;
    public volatile boolean h = false;
    public boolean j = false;

    public d(String str, int i, com.baidu.tbadk.a.d dVar, boolean z) {
        this.b = null;
        this.c = null;
        this.d = 0;
        this.e = null;
        this.g = false;
        this.c = str;
        this.d = i;
        this.b = dVar;
        this.e = null;
        this.g = z;
    }

    public void a() {
        this.j = true;
        if (this.f1918a != null) {
            this.f1918a.h();
        }
    }

    public String b() {
        return this.c;
    }
}
