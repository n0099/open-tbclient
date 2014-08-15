package com.baidu.tieba.pb.main;

import android.os.Parcelable;
/* loaded from: classes.dex */
public class bp {
    private String a;
    private boolean b;
    private com.baidu.tieba.data.aj c;
    private boolean d;
    private Parcelable e;
    private boolean f;
    private boolean g;

    public static bp a() {
        bp bpVar;
        bpVar = bq.a;
        return bpVar;
    }

    private bp() {
        this.a = null;
        this.b = false;
        this.c = null;
        this.d = false;
        this.e = null;
        this.f = true;
        this.g = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bp(bp bpVar) {
        this();
    }

    public void a(String str, boolean z) {
        this.b = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            f();
            this.a = null;
        } else if (!str.equals(this.a)) {
            f();
            this.a = str;
        } else {
            this.b = true;
        }
    }

    public com.baidu.tieba.data.aj b() {
        if (!this.b) {
            this.d = false;
            return null;
        } else if (this.c != null && this.c.e() != null && this.c.e().size() > 0) {
            this.d = true;
            com.baidu.tieba.data.aj ajVar = this.c;
            this.c = null;
            return ajVar;
        } else {
            this.d = false;
            this.c = null;
            return null;
        }
    }

    public Parcelable c() {
        if (this.d) {
            this.d = false;
            Parcelable parcelable = this.e;
            this.e = null;
            return parcelable;
        }
        this.e = null;
        return null;
    }

    public boolean d() {
        return this.f;
    }

    public boolean e() {
        return this.g;
    }

    public boolean a(com.baidu.tieba.data.aj ajVar, Parcelable parcelable, boolean z, boolean z2) {
        this.b = false;
        if (this.a == null) {
            f();
            return false;
        } else if (ajVar == null) {
            f();
            return false;
        } else if (ajVar.e() == null) {
            f();
            return false;
        } else if (ajVar.e().size() < 1) {
            f();
            return false;
        } else if (parcelable == null) {
            f();
            return false;
        } else {
            this.c = ajVar;
            this.d = false;
            this.e = parcelable;
            this.f = z;
            this.g = z2;
            return true;
        }
    }

    public void f() {
        this.b = false;
        this.c = null;
        this.d = false;
        this.e = null;
    }
}
