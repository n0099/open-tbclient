package com.baidu.tieba.model;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.MarkData;
import com.baidu.tieba.data.WriteData;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
public class bm extends com.baidu.adp.a.d {
    private static final int b = com.baidu.tieba.data.h.c() / 30;
    private static com.baidu.tieba.data.ap x = new com.baidu.tieba.data.ap();
    private com.baidu.tieba.data.ao v;
    private Context y;
    private String c = null;
    private String d = null;
    private String e = null;
    private boolean f = false;
    private boolean g = true;
    private int h = 0;
    private int i = 0;
    private long j = 0;
    private int k = 1;
    private int l = 1;
    private int m = 1;
    private int n = 1;
    private boolean o = false;
    private boolean p = false;
    private boolean q = false;
    private boolean r = false;
    private long s = 0;
    private boolean t = false;
    private String u = null;
    private bo w = null;
    private bn z = null;
    private long A = 0;
    private com.baidu.adp.lib.cache.s<String> B = null;
    private com.baidu.adp.lib.cache.s<String> C = null;
    protected com.baidu.tieba.util.i a = null;

    public bm(Context context) {
        this.v = null;
        this.y = null;
        this.v = new com.baidu.tieba.data.ao();
        x.a();
        this.y = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        if (this.B == null) {
            this.B = com.baidu.tieba.b.a.a().b();
        }
        if (this.C == null) {
            this.C = com.baidu.tieba.b.a.a().c();
        }
    }

    public void a(Intent intent) {
        this.d = intent.getStringExtra("thread_id");
        this.e = intent.getStringExtra("post_id");
        this.f = intent.getBooleanExtra("host_only", false);
        this.g = intent.getBooleanExtra("squence", true);
        this.c = intent.getStringExtra("st_type");
        this.h = intent.getIntExtra("is_good", 0);
        this.i = intent.getIntExtra("is_top", 0);
        this.j = intent.getLongExtra("thread_time", 0L);
        this.q = intent.getBooleanExtra("from_frs", false);
        this.r = intent.getBooleanExtra("from_mark", false);
        this.o = intent.getBooleanExtra("is_ad", false);
        this.p = intent.getBooleanExtra("is_sub_pb", false);
        this.t = intent.getBooleanExtra("is_pv", false);
        this.s = intent.getLongExtra("msg_id", 0L);
        this.u = intent.getStringExtra("forum_name");
    }

    public void a(Bundle bundle) {
        this.d = bundle.getString("thread_id");
        this.e = bundle.getString("post_id");
        this.f = bundle.getBoolean("host_only", false);
        this.g = bundle.getBoolean("squence", true);
        this.c = bundle.getString("st_type");
        this.h = bundle.getInt("is_good", 0);
        this.i = bundle.getInt("is_top", 0);
        this.j = bundle.getLong("thread_time");
        this.q = bundle.getBoolean("from_frs", false);
        this.r = bundle.getBoolean("from_mark", false);
        this.o = bundle.getBoolean("is_ad", false);
        this.p = bundle.getBoolean("is_sub_pb", false);
        this.t = bundle.getBoolean("is_pv", false);
        this.s = bundle.getLong("msg_id", 0L);
        this.u = bundle.getString("forum_name");
    }

    public void b(Bundle bundle) {
        bundle.putString("thread_id", this.d);
        bundle.putString("post_id", this.e);
        bundle.putBoolean("host_only", this.f);
        bundle.putBoolean("squence", this.g);
        bundle.putString("st_type", this.c);
        bundle.putInt("is_good", this.h);
        bundle.putInt("is_top", this.i);
        bundle.putLong("thread_time", this.j);
        bundle.putBoolean("from_frs", this.q);
        bundle.putBoolean("from_mark", this.r);
        bundle.putBoolean("is_sub_pb", this.p);
        bundle.putBoolean("is_ad", this.o);
        bundle.putBoolean("is_pv", this.t);
        bundle.putLong("msg_id", this.s);
    }

    public String a() {
        return this.u;
    }

    public String b() {
        return this.d;
    }

    public boolean c() {
        return this.f;
    }

    public boolean d() {
        return this.g;
    }

    public boolean e() {
        return this.q;
    }

    public boolean f() {
        return this.r;
    }

    public int g() {
        return this.h;
    }

    public int h() {
        return this.i;
    }

    public void a(int i) {
        this.h = i;
    }

    public void b(int i) {
        this.i = i;
    }

    public boolean i() {
        return this.p;
    }

    public boolean j() {
        if (this.v == null) {
            return false;
        }
        return this.v.a();
    }

    public String k() {
        if (this.v == null || !this.v.i()) {
            return null;
        }
        return this.v.j();
    }

    public boolean c(int i) {
        this.k = i;
        if (this.k > this.v.f().a()) {
            this.k = this.v.f().a();
        }
        if (this.k < 1) {
            this.k = 1;
        }
        if (this.d == null) {
            return false;
        }
        if (this.w != null) {
            this.w.cancel();
        }
        this.w = new bo(this, 5);
        this.w.setPriority(3);
        this.w.execute(new Object[0]);
        return true;
    }

    public void d(int i) {
        this.k = i;
        this.l = i;
        this.m = i;
    }

    public void e(int i) {
        if (this.l < i) {
            this.l = i;
            if (this.l - this.m >= b) {
                this.m = (this.l - b) + 1;
            }
        }
        if (this.m > i) {
            this.m = i;
            if (this.l - this.m >= b) {
                this.l = (this.m + b) - 1;
            }
        }
    }

    public com.baidu.tieba.data.ao l() {
        return this.v;
    }

    public com.baidu.tieba.data.an m() {
        if (this.v == null) {
            return null;
        }
        return this.v.f();
    }

    public boolean n() {
        if (this.g) {
            if (this.v.f().f() == 0) {
                a(true);
                return true;
            }
        } else if (this.v.f().g() == 0) {
            b(true);
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.a.d
    protected boolean LoadData() {
        if (this.d == null) {
            return false;
        }
        if (this.w != null) {
            this.w.cancel();
        }
        this.w = new bo(this, 3);
        this.w.setPriority(3);
        this.w.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.a.d
    public boolean cancelLoadData() {
        if (this.w != null) {
            this.w.cancel();
        }
        if (this.a != null) {
            this.a.d();
            this.a = null;
            return true;
        }
        return true;
    }

    public boolean o() {
        return (this.e == null || this.e.equals(SocialConstants.FALSE)) ? LoadData() : p();
    }

    public boolean p() {
        if (this.d == null || this.e == null) {
            return false;
        }
        if (this.w != null) {
            this.w.cancel();
        }
        if (this.r) {
            this.w = new bo(this, 4);
        } else {
            this.w = new bo(this, 6);
        }
        this.w.setPriority(3);
        this.w.execute(new Object[0]);
        return true;
    }

    public boolean a(boolean z) {
        if (this.d == null || this.v == null) {
            return false;
        }
        if ((z || this.v.f().f() != 0) && this.w == null) {
            this.w = new bo(this, 1);
            this.w.setPriority(3);
            this.w.execute(new Object[0]);
            return true;
        }
        return false;
    }

    public boolean b(boolean z) {
        if (this.d == null || this.v == null) {
            return false;
        }
        if ((z || this.v.f().g() != 0) && this.v.e() != null && this.v.e().size() >= 1 && this.w == null) {
            this.w = new bo(this, 2);
            this.w.setPriority(3);
            this.w.execute(new Object[0]);
            return true;
        }
        return false;
    }

    public boolean q() {
        this.f = !this.f;
        if (this.f) {
            this.g = true;
        }
        LoadData();
        return true;
    }

    public boolean r() {
        this.g = !this.g;
        if (!this.g) {
            this.f = false;
        }
        LoadData();
        return true;
    }

    public boolean s() {
        return (this.v == null || this.v.c() == null || this.v.d() == null) ? false : true;
    }

    public boolean t() {
        if (this.v == null) {
            return false;
        }
        return this.v.i();
    }

    public WriteData a(String str) {
        if (this.v == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumId(this.v.c().getId());
        writeData.setForumName(this.v.c().getName());
        writeData.setThreadId(this.d);
        writeData.setIsAd(this.o);
        if (str == null) {
            writeData.setType(1);
            return writeData;
        }
        writeData.setType(2);
        writeData.setFloor(str);
        writeData.setFloorNum(0);
        return writeData;
    }

    public com.baidu.tieba.data.ax a(com.baidu.tieba.data.as asVar) {
        if (asVar == null) {
            return null;
        }
        com.baidu.tieba.data.ax axVar = new com.baidu.tieba.data.ax();
        axVar.a(this.v.c());
        axVar.a(this.v.d());
        axVar.a(asVar);
        axVar.a(asVar.a());
        axVar.c(asVar.j());
        String j = this.v.j();
        String d = asVar.d();
        if (t() && j != null && d != null && j.equals(d)) {
            axVar.a(true);
            return axVar;
        }
        axVar.a(false);
        return axVar;
    }

    public MarkData f(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.v == null || this.v.e() == null) {
            return null;
        }
        ArrayList<com.baidu.tieba.data.as> e = this.v.e();
        if (e.size() <= 0 || i >= e.size()) {
            return null;
        }
        return b(e.get(i));
    }

    public MarkData u() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TiebaApplication.A());
        markData.setThreadId(this.d);
        markData.setPostId(this.v.j());
        markData.setTime(date.getTime());
        markData.setHostMode(this.f);
        markData.setSequence(Boolean.valueOf(this.g));
        markData.setId(this.d);
        return markData;
    }

    public MarkData b(com.baidu.tieba.data.as asVar) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TiebaApplication.A());
        markData.setThreadId(this.d);
        markData.setPostId(asVar.d());
        markData.setTime(date.getTime());
        markData.setHostMode(this.f);
        markData.setSequence(Boolean.valueOf(this.g));
        markData.setId(this.d);
        markData.setFloor(asVar.e());
        return markData;
    }

    public void v() {
        x();
        String y = y();
        if (this.r) {
            if (this.B != null && y != null) {
                this.B.b(y, "", 0L);
            }
        } else if (this.C != null && y != null) {
            this.C.b(y, "", 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String y() {
        String str = this.d;
        if (this.f) {
            str = str + "_host";
        }
        if (!this.g) {
            str = str + "_rev";
        }
        if (TiebaApplication.A() != null) {
            return str + TiebaApplication.A();
        }
        return str;
    }

    public void c(boolean z) {
        if (this.v != null) {
            this.v.a(z);
        }
    }

    public void a(bn bnVar) {
        this.z = bnVar;
    }
}
