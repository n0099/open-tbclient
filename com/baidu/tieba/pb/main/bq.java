package com.baidu.tieba.pb.main;

import android.os.Parcelable;
/* loaded from: classes.dex */
public class bq {
    private String a;
    private boolean b;
    private com.baidu.tieba.data.ai c;
    private boolean d;
    private Parcelable e;
    private boolean f;
    private boolean g;

    public static bq a() {
        bq bqVar;
        bqVar = br.a;
        return bqVar;
    }

    private bq() {
        this.a = null;
        this.b = false;
        this.c = null;
        this.d = false;
        this.e = null;
        this.f = true;
        this.g = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bq(bq bqVar) {
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

    public com.baidu.tieba.data.ai b() {
        if (!this.b) {
            this.d = false;
            return null;
        } else if (this.c != null && this.c.d() != null && this.c.d().size() > 0) {
            this.d = true;
            com.baidu.tieba.data.ai aiVar = this.c;
            this.c = null;
            return aiVar;
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

    public boolean a(com.baidu.tieba.data.ai aiVar, Parcelable parcelable, boolean z, boolean z2) {
        this.b = false;
        if (this.a == null) {
            f();
            return false;
        } else if (aiVar == null) {
            f();
            return false;
        } else if (aiVar.d() == null) {
            f();
            return false;
        } else if (aiVar.d().size() < 1) {
            f();
            return false;
        } else if (parcelable == null) {
            f();
            return false;
        } else {
            this.c = aiVar;
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
