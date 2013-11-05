package com.baidu.tieba.model;

import android.content.Context;
import com.baidu.tieba.data.PersonChangeData;
import com.baidu.tieba.data.UserData;
/* loaded from: classes.dex */
public class bw extends com.baidu.adp.a.d {
    private long c;
    private long d;
    private long e;
    private long f;
    private long g;
    private String h;
    private com.baidu.tieba.util.a l;
    private Context o;
    private bz m = null;
    private by n = null;

    /* renamed from: a  reason: collision with root package name */
    private boolean f1927a = true;
    private String b = null;
    private UserData k = null;
    private boolean i = false;
    private boolean j = false;

    public bw(Context context) {
        this.o = null;
        this.o = context;
        a(0L);
        d(0L);
        e(0L);
        b(0L);
        c(0L);
        this.l = new com.baidu.tieba.util.a(context);
    }

    public String a() {
        return this.b;
    }

    public void a(String str) {
        this.b = str;
    }

    public void a(boolean z) {
        this.f1927a = z;
    }

    public boolean b() {
        return this.f1927a;
    }

    public void a(UserData userData) {
        this.k = userData;
    }

    public UserData c() {
        return this.k;
    }

    public void a(PersonChangeData personChangeData) {
        c().setSex(personChangeData.getSex());
        c().setName(personChangeData.getName());
        c().setIntro(personChangeData.getIntro());
    }

    public void a(boolean z, boolean z2) {
        if (this.m == null) {
            this.m = new bz(this);
            this.m.setPriority(3);
            this.m.execute(Boolean.valueOf(z), Boolean.valueOf(z2));
        }
    }

    public void d() {
        if (c() != null && this.n == null) {
            this.n = new by(this);
            this.n.setPriority(2);
            if (c().getHave_attention() == 1) {
                this.n.execute(1);
            } else {
                this.n.execute(0);
            }
        }
    }

    public com.baidu.tieba.util.a e() {
        return this.l;
    }

    public void b(String str) {
        this.h = str;
    }

    public String f() {
        return this.h;
    }

    public void a(long j) {
        this.c = j;
    }

    public long g() {
        return this.c;
    }

    public void b(long j) {
        this.f = j;
    }

    public void c(long j) {
        this.g = j;
    }

    public long h() {
        return this.g;
    }

    public void d(long j) {
        this.d = j;
    }

    public void e(long j) {
        this.e = j;
    }

    public void b(boolean z) {
        this.i = z;
    }

    public boolean i() {
        return this.i;
    }

    public void c(boolean z) {
        this.j = z;
    }

    public boolean j() {
        return this.j;
    }

    @Override // com.baidu.adp.a.d
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.d
    public boolean cancelLoadData() {
        return false;
    }

    public void k() {
        if (this.m != null) {
            this.m.cancel();
        }
        if (this.n != null) {
            this.n.cancel();
        }
        if (this.l != null) {
            this.l.b();
        }
    }
}
