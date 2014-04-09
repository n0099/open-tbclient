package com.baidu.tieba.pb.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.data.MarkData;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
public final class bf extends com.baidu.adp.a.e {
    private static final int b = com.baidu.tieba.data.d.f() / 30;
    private static com.baidu.tieba.data.af x = new com.baidu.tieba.data.af();
    private com.baidu.tieba.data.ae v;
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
    private bh w = null;
    private bg z = null;
    private long A = 0;
    private com.baidu.adp.lib.cache.s<String> B = null;
    private com.baidu.adp.lib.cache.s<String> C = null;
    protected com.baidu.tbadk.editortool.ab a = null;
    private long D = 0;
    private long E = 0;
    private long F = 0;
    private long G = 0;
    private PraiseData H = null;

    public final long a() {
        return this.G;
    }

    public final long b() {
        return this.E;
    }

    public final long c() {
        return this.F;
    }

    public final long d() {
        return this.D;
    }

    public bf(Context context) {
        this.v = null;
        this.y = null;
        this.v = new com.baidu.tieba.data.ae();
        x.a();
        this.y = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        if (this.B == null) {
            this.B = com.baidu.tbadk.core.c.b.a().b();
        }
        if (this.C == null) {
            this.C = com.baidu.tbadk.core.c.b.a().c();
        }
    }

    public final void a(Intent intent) {
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

    public final void a(Bundle bundle) {
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

    public final void b(Bundle bundle) {
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

    public final String e() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.d);
        sb.append(this.e);
        sb.append(this.f);
        sb.append(this.g);
        sb.append(this.c);
        sb.append(this.h);
        sb.append(this.i);
        sb.append(this.j);
        sb.append(this.q);
        sb.append(this.r);
        sb.append(this.o);
        sb.append(this.p);
        sb.append(this.t);
        sb.append(this.s);
        sb.append(this.u);
        return sb.toString();
    }

    public final String f() {
        return this.d;
    }

    public final boolean g() {
        return this.f;
    }

    public final boolean h() {
        return this.g;
    }

    public final boolean i() {
        return this.q;
    }

    public final boolean j() {
        return this.r;
    }

    public final int k() {
        return this.h;
    }

    public final int l() {
        return this.i;
    }

    public final void a(int i) {
        this.h = i;
    }

    public final void b(int i) {
        this.i = i;
    }

    public final boolean m() {
        return this.p;
    }

    public final boolean n() {
        if (this.v == null) {
            return false;
        }
        return this.v.a();
    }

    public final String o() {
        if (this.v == null || !this.v.i()) {
            return null;
        }
        return this.v.j();
    }

    public final boolean c(int i) {
        this.k = i;
        if (this.k > this.v.f().a()) {
            this.k = this.v.f().a();
        }
        if (this.k <= 0) {
            this.k = 1;
        }
        if (this.d == null) {
            return false;
        }
        if (this.w != null) {
            this.w.cancel();
        }
        this.w = new bh(this, 5);
        this.w.setPriority(3);
        this.w.execute(new Object[0]);
        return true;
    }

    public final void d(int i) {
        this.k = i;
        this.l = i;
        this.m = i;
    }

    public final void e(int i) {
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

    public final com.baidu.tieba.data.ae p() {
        return this.v;
    }

    public final com.baidu.tbadk.core.data.l q() {
        if (this.v == null) {
            return null;
        }
        return this.v.f();
    }

    public final boolean r() {
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

    @Override // com.baidu.adp.a.e
    protected final boolean LoadData() {
        if (this.d == null) {
            return false;
        }
        if (this.w != null) {
            this.w.cancel();
        }
        this.w = new bh(this, 3);
        this.w.setPriority(3);
        this.w.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.a.e
    public final boolean cancelLoadData() {
        if (this.w != null) {
            this.w.cancel();
        }
        if (this.a != null) {
            this.a.c();
            this.a = null;
            return true;
        }
        return true;
    }

    public final boolean s() {
        if (this.e != null && !this.e.equals("0")) {
            if (this.d == null || this.e == null) {
                return false;
            }
            if (this.w != null) {
                this.w.cancel();
            }
            if (this.r) {
                this.w = new bh(this, 4);
            } else {
                this.w = new bh(this, 6);
            }
            this.w.setPriority(3);
            this.w.execute(new Object[0]);
            return true;
        }
        return LoadData();
    }

    public final boolean a(boolean z) {
        if (this.d == null || this.v == null) {
            return false;
        }
        if ((z || this.v.f().f() != 0) && this.w == null) {
            this.w = new bh(this, 1);
            this.w.setPriority(3);
            this.w.execute(new Object[0]);
            return true;
        }
        return false;
    }

    public final boolean b(boolean z) {
        if (this.d == null || this.v == null || this.v.e() == null || this.v.e().size() <= 0 || this.w != null) {
            return false;
        }
        this.w = new bh(this, 2);
        this.w.setPriority(3);
        this.w.execute(new Object[0]);
        return true;
    }

    public final boolean t() {
        this.f = !this.f;
        if (this.f) {
            this.g = true;
        }
        LoadData();
        return true;
    }

    public final boolean u() {
        this.g = !this.g;
        if (!this.g) {
            this.f = false;
        }
        LoadData();
        return true;
    }

    public final boolean v() {
        return (this.v == null || this.v.c() == null || this.v.d() == null) ? false : true;
    }

    public final boolean w() {
        if (this.v == null) {
            return false;
        }
        return this.v.i();
    }

    public final WriteData a(String str) {
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

    public final com.baidu.tieba.data.am a(com.baidu.tieba.data.ai aiVar) {
        if (aiVar == null) {
            return null;
        }
        com.baidu.tieba.data.am amVar = new com.baidu.tieba.data.am();
        amVar.a(this.v.c());
        amVar.a(this.v.d());
        amVar.a(aiVar);
        amVar.a(aiVar.a());
        amVar.b(aiVar.k());
        String j = this.v.j();
        String d = aiVar.d();
        if (w() && j != null && d != null && j.equals(d)) {
            amVar.a(true);
            return amVar;
        }
        amVar.a(false);
        return amVar;
    }

    public final MarkData f(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.v == null || this.v.e() == null) {
            return null;
        }
        ArrayList<com.baidu.tieba.data.ai> e = this.v.e();
        if (e.size() > 0 && i == e.size()) {
            i = e.size() - 1;
        }
        if (e.size() <= 0 || i >= e.size()) {
            return null;
        }
        return b(e.get(i));
    }

    public final MarkData x() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkApplication.E());
        markData.setThreadId(this.d);
        markData.setPostId(this.v.j());
        markData.setTime(date.getTime());
        markData.setHostMode(this.f);
        markData.setSequence(Boolean.valueOf(this.g));
        markData.setId(this.d);
        return markData;
    }

    public final MarkData b(com.baidu.tieba.data.ai aiVar) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkApplication.E());
        markData.setThreadId(this.d);
        markData.setPostId(aiVar.d());
        markData.setTime(date.getTime());
        markData.setHostMode(this.f);
        markData.setSequence(Boolean.valueOf(this.g));
        markData.setId(this.d);
        markData.setFloor(aiVar.e());
        return markData;
    }

    public final void y() {
        A();
        String B = B();
        if (this.r) {
            if (this.B != null && B != null) {
                this.B.b(B, "", 0L);
            }
        } else if (this.C != null && B != null) {
            this.C.b(B, "", 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String B() {
        String str = this.d;
        if (this.f) {
            str = String.valueOf(str) + "_host";
        }
        if (!this.g) {
            str = String.valueOf(str) + "_rev";
        }
        if (TbadkApplication.E() != null) {
            return String.valueOf(str) + TbadkApplication.E();
        }
        return str;
    }

    public final void c(boolean z) {
        if (this.v != null) {
            this.v.a(z);
        }
    }

    public final void a(bg bgVar) {
        this.z = bgVar;
    }
}
