package com.baidu.tieba.model;

import android.content.Context;
import com.baidu.tieba.data.PersonChangeData;
import com.baidu.tieba.data.UserData;
/* loaded from: classes.dex */
public class bi extends com.baidu.adp.a.c {
    private long c;
    private long d;
    private long e;
    private long f;
    private String g;
    private com.baidu.tieba.util.a k;
    private bk l = null;
    private bj m = null;
    private boolean a = true;
    private String b = null;
    private UserData j = null;
    private boolean h = false;
    private boolean i = false;

    public bi(Context context) {
        a(0L);
        c(0L);
        d(0L);
        b(0L);
        this.k = new com.baidu.tieba.util.a(context);
    }

    public String a() {
        return this.b;
    }

    public void a(String str) {
        this.b = str;
    }

    public void a(boolean z) {
        this.a = z;
    }

    public boolean b() {
        return this.a;
    }

    public void a(UserData userData) {
        this.j = userData;
    }

    public UserData c() {
        return this.j;
    }

    public void a(PersonChangeData personChangeData) {
        c().setSex(personChangeData.getSex());
        c().setName(personChangeData.getName());
        c().setIntro(personChangeData.getIntro());
    }

    public void a(boolean z, boolean z2) {
        if (this.l == null) {
            this.l = new bk(this, null);
            this.l.setPriority(3);
            this.l.execute(Boolean.valueOf(z), Boolean.valueOf(z2));
        }
    }

    public void d() {
        if (c() != null && this.m == null) {
            this.m = new bj(this, null);
            this.m.setPriority(2);
            if (c().getHave_attention() == 1) {
                this.m.execute(1);
            } else {
                this.m.execute(0);
            }
        }
    }

    public com.baidu.tieba.util.a e() {
        return this.k;
    }

    public void b(String str) {
        this.g = str;
    }

    public String f() {
        return this.g;
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

    public long h() {
        return this.f;
    }

    public void c(long j) {
        this.d = j;
    }

    public long i() {
        return this.d;
    }

    public long j() {
        return this.d + this.e;
    }

    public void d(long j) {
        this.e = j;
    }

    public long k() {
        return this.e;
    }

    public void b(boolean z) {
        this.h = z;
    }

    public boolean l() {
        return this.h;
    }

    public void c(boolean z) {
        this.i = z;
    }

    public boolean m() {
        return this.i;
    }

    @Override // com.baidu.adp.a.c
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.c
    public boolean cancelLoadData() {
        return false;
    }

    public void n() {
        if (this.l != null) {
            this.l.cancel();
        }
        if (this.m != null) {
            this.m.cancel();
        }
        if (this.k != null) {
            this.k.b();
        }
    }
}
