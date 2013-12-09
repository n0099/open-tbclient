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

    /* renamed from: a  reason: collision with root package name */
    private static final int f2010a = com.baidu.tieba.data.h.c() / 30;
    private static com.baidu.tieba.data.ao w = new com.baidu.tieba.data.ao();
    private com.baidu.adp.lib.cache.s<String> A;
    private com.baidu.adp.lib.cache.s<String> B;
    private com.baidu.tieba.data.an u;
    private Context x;
    private String b = null;
    private String c = null;
    private String d = null;
    private boolean e = false;
    private boolean f = true;
    private int g = 0;
    private int h = 0;
    private long i = 0;
    private int j = 1;
    private int k = 1;
    private int l = 1;
    private int m = 1;
    private boolean n = false;
    private boolean o = false;
    private boolean p = false;
    private boolean q = false;
    private long r = 0;
    private boolean s = false;
    private String t = null;
    private bo v = null;
    private bn y = null;
    private long z = 0;

    public bm(Context context) {
        this.u = null;
        this.x = null;
        this.A = null;
        this.B = null;
        this.u = new com.baidu.tieba.data.an();
        w.a();
        this.x = context;
        this.A = com.baidu.tieba.b.a.a().b();
        this.B = com.baidu.tieba.b.a.a().c();
    }

    public void a(Intent intent) {
        this.c = intent.getStringExtra("thread_id");
        this.d = intent.getStringExtra("post_id");
        this.e = intent.getBooleanExtra("host_only", false);
        this.f = intent.getBooleanExtra("squence", true);
        this.b = intent.getStringExtra("st_type");
        this.g = intent.getIntExtra("is_good", 0);
        this.h = intent.getIntExtra("is_top", 0);
        this.i = intent.getLongExtra("thread_time", 0L);
        this.p = intent.getBooleanExtra("from_frs", false);
        this.q = intent.getBooleanExtra("from_mark", false);
        this.n = intent.getBooleanExtra("is_ad", false);
        this.o = intent.getBooleanExtra("is_sub_pb", false);
        this.s = intent.getBooleanExtra("is_pv", false);
        this.r = intent.getLongExtra("msg_id", 0L);
        this.t = intent.getStringExtra("forum_name");
    }

    public void a(Bundle bundle) {
        this.c = bundle.getString("thread_id");
        this.d = bundle.getString("post_id");
        this.e = bundle.getBoolean("host_only", false);
        this.f = bundle.getBoolean("squence", true);
        this.b = bundle.getString("st_type");
        this.g = bundle.getInt("is_good", 0);
        this.h = bundle.getInt("is_top", 0);
        this.i = bundle.getLong("thread_time");
        this.p = bundle.getBoolean("from_frs", false);
        this.q = bundle.getBoolean("from_mark", false);
        this.n = bundle.getBoolean("is_ad", false);
        this.o = bundle.getBoolean("is_sub_pb", false);
        this.s = bundle.getBoolean("is_pv", false);
        this.r = bundle.getLong("msg_id", 0L);
        this.t = bundle.getString("forum_name");
    }

    public void b(Bundle bundle) {
        bundle.putString("thread_id", this.c);
        bundle.putString("post_id", this.d);
        bundle.putBoolean("host_only", this.e);
        bundle.putBoolean("squence", this.f);
        bundle.putString("st_type", this.b);
        bundle.putInt("is_good", this.g);
        bundle.putInt("is_top", this.h);
        bundle.putLong("thread_time", this.i);
        bundle.putBoolean("from_frs", this.p);
        bundle.putBoolean("from_mark", this.q);
        bundle.putBoolean("is_sub_pb", this.o);
        bundle.putBoolean("is_ad", this.n);
        bundle.putBoolean("is_pv", this.s);
        bundle.putLong("msg_id", this.r);
    }

    public String a() {
        return this.t;
    }

    public String b() {
        return this.c;
    }

    public boolean c() {
        return this.e;
    }

    public boolean d() {
        return this.f;
    }

    public boolean e() {
        return this.p;
    }

    public boolean f() {
        return this.q;
    }

    public int g() {
        return this.g;
    }

    public int h() {
        return this.h;
    }

    public void a(int i) {
        this.g = i;
    }

    public void b(int i) {
        this.h = i;
    }

    public boolean i() {
        return this.o;
    }

    public boolean j() {
        if (this.u == null) {
            return false;
        }
        return this.u.a();
    }

    public String k() {
        if (this.u == null || !this.u.i()) {
            return null;
        }
        return this.u.j();
    }

    public boolean c(int i) {
        this.j = i;
        if (this.j > this.u.f().a()) {
            this.j = this.u.f().a();
        }
        if (this.j < 1) {
            this.j = 1;
        }
        if (this.c == null) {
            return false;
        }
        if (this.v != null) {
            this.v.cancel();
        }
        this.v = new bo(this, 5);
        this.v.setPriority(3);
        this.v.execute(new Object[0]);
        return true;
    }

    public void d(int i) {
        this.j = i;
        this.k = i;
        this.l = i;
    }

    public void e(int i) {
        if (this.k < i) {
            this.k = i;
            if (this.k - this.l >= f2010a) {
                this.l = (this.k - f2010a) + 1;
            }
        }
        if (this.l > i) {
            this.l = i;
            if (this.k - this.l >= f2010a) {
                this.k = (this.l + f2010a) - 1;
            }
        }
    }

    public com.baidu.tieba.data.an l() {
        return this.u;
    }

    public com.baidu.tieba.data.am m() {
        if (this.u == null) {
            return null;
        }
        return this.u.f();
    }

    public boolean n() {
        if (this.f) {
            if (this.u.f().f() == 0) {
                a(true);
                return true;
            }
        } else if (this.u.f().g() == 0) {
            b(true);
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.a.d
    protected boolean LoadData() {
        if (this.c == null) {
            return false;
        }
        if (this.v != null) {
            this.v.cancel();
        }
        this.v = new bo(this, 3);
        this.v.setPriority(3);
        this.v.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.a.d
    public boolean cancelLoadData() {
        if (this.v != null) {
            this.v.cancel();
            return true;
        }
        return true;
    }

    public boolean o() {
        return (this.d == null || this.d.equals(SocialConstants.FALSE)) ? LoadData() : p();
    }

    public boolean p() {
        if (this.c == null || this.d == null) {
            return false;
        }
        if (this.v != null) {
            this.v.cancel();
        }
        if (this.q) {
            this.v = new bo(this, 4);
        } else {
            this.v = new bo(this, 6);
        }
        this.v.setPriority(3);
        this.v.execute(new Object[0]);
        return true;
    }

    public boolean a(boolean z) {
        if (this.c == null || this.u == null) {
            return false;
        }
        if ((z || this.u.f().f() != 0) && this.v == null) {
            this.v = new bo(this, 1);
            this.v.setPriority(3);
            this.v.execute(new Object[0]);
            return true;
        }
        return false;
    }

    public boolean b(boolean z) {
        if (this.c == null || this.u == null) {
            return false;
        }
        if ((z || this.u.f().g() != 0) && this.u.e() != null && this.u.e().size() >= 1 && this.v == null) {
            this.v = new bo(this, 2);
            this.v.setPriority(3);
            this.v.execute(new Object[0]);
            return true;
        }
        return false;
    }

    public boolean q() {
        this.e = !this.e;
        if (this.e) {
            this.f = true;
        }
        LoadData();
        return true;
    }

    public boolean r() {
        this.f = !this.f;
        if (!this.f) {
            this.e = false;
        }
        LoadData();
        return true;
    }

    public boolean s() {
        return (this.u == null || this.u.c() == null || this.u.d() == null) ? false : true;
    }

    public boolean t() {
        if (this.u == null) {
            return false;
        }
        return this.u.i();
    }

    public WriteData a(String str) {
        if (this.u == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumId(this.u.c().getId());
        writeData.setForumName(this.u.c().getName());
        writeData.setThreadId(this.c);
        writeData.setIsAd(this.n);
        if (str == null) {
            writeData.setType(1);
            return writeData;
        }
        writeData.setType(2);
        writeData.setFloor(str);
        writeData.setFloorNum(0);
        return writeData;
    }

    public com.baidu.tieba.data.av a(com.baidu.tieba.data.ar arVar) {
        if (arVar == null) {
            return null;
        }
        com.baidu.tieba.data.av avVar = new com.baidu.tieba.data.av();
        avVar.a(this.u.c());
        avVar.a(this.u.d());
        avVar.a(arVar);
        avVar.a(arVar.a());
        avVar.c(arVar.j());
        String j = this.u.j();
        String d = arVar.d();
        if (t() && j != null && d != null && j.equals(d)) {
            avVar.a(true);
            return avVar;
        }
        avVar.a(false);
        return avVar;
    }

    public MarkData f(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.u == null || this.u.e() == null) {
            return null;
        }
        ArrayList<com.baidu.tieba.data.ar> e = this.u.e();
        if (e.size() <= 0 || i >= e.size()) {
            return null;
        }
        return b(e.get(i));
    }

    public MarkData u() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TiebaApplication.B());
        markData.setThreadId(this.c);
        markData.setPostId(this.u.j());
        markData.setTime(date.getTime());
        markData.setHostMode(this.e);
        markData.setSequence(Boolean.valueOf(this.f));
        markData.setId(this.c);
        return markData;
    }

    public MarkData b(com.baidu.tieba.data.ar arVar) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TiebaApplication.B());
        markData.setThreadId(this.c);
        markData.setPostId(arVar.d());
        markData.setTime(date.getTime());
        markData.setHostMode(this.e);
        markData.setSequence(Boolean.valueOf(this.f));
        markData.setId(this.c);
        markData.setFloor(arVar.e());
        return markData;
    }

    public void v() {
        String x = x();
        if (this.q) {
            if (this.A != null && x != null) {
                this.A.b(x, "", 0L);
            }
        } else if (this.B != null && x != null) {
            this.B.b(x, "", 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String x() {
        String str = this.c;
        if (this.e) {
            str = str + "_host";
        }
        if (!this.f) {
            str = str + "_rev";
        }
        if (TiebaApplication.B() != null) {
            return str + TiebaApplication.B();
        }
        return str;
    }

    public void c(boolean z) {
        if (this.u != null) {
            this.u.a(z);
        }
    }

    public void a(bn bnVar) {
        this.y = bnVar;
    }
}
