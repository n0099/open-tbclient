package com.baidu.tieba.pb.main;

import android.os.Parcelable;
/* loaded from: classes.dex */
public final class bj {
    private String a;
    private boolean b;
    private com.baidu.tieba.data.ae c;
    private boolean d;
    private Parcelable e;
    private boolean f;
    private boolean g;

    public static bj a() {
        bj bjVar;
        bjVar = bk.a;
        return bjVar;
    }

    private bj() {
        this.a = null;
        this.b = false;
        this.c = null;
        this.d = false;
        this.e = null;
        this.f = true;
        this.g = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bj(byte b) {
        this();
    }

    public final void a(String str, boolean z) {
        this.b = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() <= 0) {
            f();
            this.a = null;
        } else if (!str.equals(this.a)) {
            f();
            this.a = str;
        } else {
            this.b = true;
        }
    }

    public final com.baidu.tieba.data.ae b() {
        if (!this.b) {
            this.d = false;
            return null;
        } else if (this.c != null && this.c.e() != null && this.c.e().size() > 0) {
            this.d = true;
            com.baidu.tieba.data.ae aeVar = this.c;
            this.c = null;
            return aeVar;
        } else {
            this.d = false;
            this.c = null;
            return null;
        }
    }

    public final Parcelable c() {
        if (this.d) {
            this.d = false;
            Parcelable parcelable = this.e;
            this.e = null;
            return parcelable;
        }
        this.e = null;
        return null;
    }

    public final boolean d() {
        return this.f;
    }

    public final boolean e() {
        return this.g;
    }

    public final boolean a(com.baidu.tieba.data.ae aeVar, Parcelable parcelable, boolean z, boolean z2) {
        this.b = false;
        if (this.a == null) {
            f();
            return false;
        } else if (aeVar == null) {
            f();
            return false;
        } else if (aeVar.e() == null) {
            f();
            return false;
        } else if (aeVar.e().size() <= 0) {
            f();
            return false;
        } else if (parcelable == null) {
            f();
            return false;
        } else {
            this.c = aeVar;
            this.d = false;
            this.e = parcelable;
            this.f = z;
            this.g = z2;
            return true;
        }
    }

    public final void f() {
        this.b = false;
        this.c = null;
        this.d = false;
        this.e = null;
    }
}
