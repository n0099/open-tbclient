package com.baidu.tieba.model;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.MarkData;
import com.baidu.tieba.data.WriteData;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
public class ax extends com.baidu.adp.a.c {

    /* renamed from: a  reason: collision with root package name */
    private static final int f1029a = com.baidu.tieba.data.g.b() / 30;
    private static com.baidu.tieba.data.ak v = new com.baidu.tieba.data.ak();
    private com.baidu.tieba.data.aj t;
    private Context w;
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
    private az u = null;
    private ay x = null;
    private long y = 0;

    public ax(Context context) {
        this.t = null;
        this.w = null;
        this.t = new com.baidu.tieba.data.aj();
        v.a();
        this.w = context;
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
        return this.c;
    }

    public boolean b() {
        return this.e;
    }

    public boolean c() {
        return this.f;
    }

    public boolean d() {
        return this.p;
    }

    public boolean e() {
        return this.q;
    }

    public int f() {
        return this.g;
    }

    public int g() {
        return this.h;
    }

    public void a(int i) {
        this.g = i;
    }

    public void b(int i) {
        this.h = i;
    }

    public boolean h() {
        return this.o;
    }

    public String i() {
        if (this.t == null || !this.t.g()) {
            return null;
        }
        return this.t.h();
    }

    public boolean c(int i) {
        this.j = i;
        if (this.j > this.t.e().a()) {
            this.j = this.t.e().a();
        }
        if (this.j < 1) {
            this.j = 1;
        }
        if (this.c == null) {
            return false;
        }
        if (this.u != null) {
            this.u.cancel();
        }
        this.u = new az(this, 5);
        this.u.setPriority(3);
        this.u.execute(new Object[0]);
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
            if (this.k - this.l >= f1029a) {
                this.l = (this.k - f1029a) + 1;
            }
        }
        if (this.l > i) {
            this.l = i;
            if (this.k - this.l >= f1029a) {
                this.k = (this.l + f1029a) - 1;
            }
        }
    }

    public com.baidu.tieba.data.aj j() {
        return this.t;
    }

    public com.baidu.tieba.data.ai k() {
        if (this.t == null) {
            return null;
        }
        return this.t.e();
    }

    public boolean l() {
        if (this.f) {
            if (this.t.e().f() == 0) {
                a(true);
                return true;
            }
        } else if (this.t.e().g() == 0) {
            b(true);
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.a.c
    protected boolean LoadData() {
        if (this.c == null) {
            return false;
        }
        if (this.u != null) {
            this.u.cancel();
        }
        this.u = new az(this, 3);
        this.u.setPriority(3);
        this.u.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.a.c
    public boolean cancelLoadData() {
        if (this.u != null) {
            this.u.cancel();
            return true;
        }
        return true;
    }

    public boolean m() {
        return (this.d == null || this.d.equals("0")) ? LoadData() : n();
    }

    public boolean n() {
        if (this.c == null || this.d == null) {
            return false;
        }
        if (this.u != null) {
            this.u.cancel();
        }
        if (this.q) {
            this.u = new az(this, 4);
        } else {
            this.u = new az(this, 6);
        }
        this.u.setPriority(3);
        this.u.execute(new Object[0]);
        return true;
    }

    public boolean a(boolean z) {
        if (this.c == null || this.t == null) {
            return false;
        }
        if ((z || this.t.e().f() != 0) && this.u == null) {
            this.u = new az(this, 1);
            this.u.setPriority(3);
            this.u.execute(new Object[0]);
            return true;
        }
        return false;
    }

    public boolean b(boolean z) {
        if (this.c == null || this.t == null) {
            return false;
        }
        if ((z || this.t.e().g() != 0) && this.t.d() != null && this.t.d().size() >= 1 && this.u == null) {
            this.u = new az(this, 2);
            this.u.setPriority(3);
            this.u.execute(new Object[0]);
            return true;
        }
        return false;
    }

    public boolean o() {
        this.e = !this.e;
        if (this.e) {
            this.f = true;
        }
        LoadData();
        return true;
    }

    public boolean p() {
        this.f = !this.f;
        if (!this.f) {
            this.e = false;
        }
        LoadData();
        return true;
    }

    public void q() {
        if (this.t != null && this.t.a() != null && this.t.b() != null) {
            if (TiebaApplication.f().t()) {
                StatService.onEvent(this.w, "pb_share", "pbclick", 1);
            }
            String b = this.t.a().b();
            com.baidu.tieba.util.ab.a(this.w, "client_share", this.c, this.t.b().b(), b);
        }
    }

    public boolean r() {
        if (this.t == null) {
            return false;
        }
        return this.t.g();
    }

    public WriteData a(String str) {
        if (this.t == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumId(this.t.a().a());
        writeData.setForumName(this.t.a().b());
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

    public com.baidu.tieba.data.aw a(com.baidu.tieba.data.an anVar) {
        if (anVar == null) {
            return null;
        }
        com.baidu.tieba.data.aw awVar = new com.baidu.tieba.data.aw();
        awVar.a(this.t.a());
        awVar.a(this.t.b());
        awVar.a(anVar);
        awVar.a(anVar.a());
        awVar.b(anVar.k());
        String h = this.t.h();
        String d = anVar.d();
        if (r() && h != null && d != null && h.equals(d)) {
            awVar.a(true);
            return awVar;
        }
        awVar.a(false);
        return awVar;
    }

    public MarkData f(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.t == null || this.t.d() == null) {
            return null;
        }
        ArrayList d = this.t.d();
        if (d.size() <= 0 || i >= d.size()) {
            return null;
        }
        return b((com.baidu.tieba.data.an) d.get(i));
    }

    public MarkData b(com.baidu.tieba.data.an anVar) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TiebaApplication.E());
        markData.setThreadId(this.c);
        markData.setPostId(anVar.d());
        markData.setTime(date.getTime());
        markData.setHostMode(this.e);
        markData.setSequence(Boolean.valueOf(this.f));
        markData.setId(this.c);
        markData.setFloor(anVar.f());
        return markData;
    }

    public void c(boolean z) {
        if (this.t != null) {
            this.t.a(z);
        }
    }

    public void a(ay ayVar) {
        this.x = ayVar;
    }
}
