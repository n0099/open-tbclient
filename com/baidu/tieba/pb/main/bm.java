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
public class bm extends com.baidu.adp.base.e {
    private static final int b = com.baidu.tieba.data.e.f() / 30;
    private static com.baidu.tieba.data.ak x = new com.baidu.tieba.data.ak();
    private boolean I;
    private com.baidu.tieba.data.ai v;
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
    protected com.baidu.tbadk.editortool.aa a = null;
    private long D = 0;
    private long E = 0;
    private long F = 0;
    private long G = 0;
    private String H = null;
    private com.baidu.tieba.b.a J = null;
    private PraiseData K = null;

    public long a() {
        return this.G;
    }

    public long b() {
        return this.E;
    }

    public long c() {
        return this.F;
    }

    public long d() {
        return this.D;
    }

    public bm(Context context) {
        this.v = null;
        this.y = null;
        this.v = new com.baidu.tieba.data.ai();
        x.a();
        this.y = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        if (this.B == null) {
            this.B = com.baidu.tbadk.core.a.b.a().b();
        }
        if (this.C == null) {
            this.C = com.baidu.tbadk.core.a.b.a().c();
        }
    }

    public void a(Intent intent) {
        this.d = intent.getStringExtra(com.baidu.tbadk.core.frameworkData.a.THREAD_ID);
        this.e = intent.getStringExtra(com.baidu.tbadk.core.frameworkData.a.POST_ID);
        this.f = intent.getBooleanExtra("host_only", false);
        this.g = intent.getBooleanExtra("squence", true);
        this.c = intent.getStringExtra(com.baidu.tbadk.core.frameworkData.a.ST_TYPE);
        this.h = intent.getIntExtra("is_good", 0);
        this.i = intent.getIntExtra("is_top", 0);
        this.j = intent.getLongExtra("thread_time", 0L);
        this.q = intent.getBooleanExtra("from_frs", false);
        this.r = intent.getBooleanExtra("from_mark", false);
        this.o = intent.getBooleanExtra("is_ad", false);
        this.p = intent.getBooleanExtra("is_sub_pb", false);
        this.t = intent.getBooleanExtra("is_pv", false);
        this.s = intent.getLongExtra("msg_id", 0L);
        this.u = intent.getStringExtra(com.baidu.tbadk.core.frameworkData.a.FORUM_NAME);
        this.H = intent.getStringExtra("extra_pb_cache_key");
    }

    public void a(Bundle bundle) {
        this.d = bundle.getString(com.baidu.tbadk.core.frameworkData.a.THREAD_ID);
        this.e = bundle.getString(com.baidu.tbadk.core.frameworkData.a.POST_ID);
        this.f = bundle.getBoolean("host_only", false);
        this.g = bundle.getBoolean("squence", true);
        this.c = bundle.getString(com.baidu.tbadk.core.frameworkData.a.ST_TYPE);
        this.h = bundle.getInt("is_good", 0);
        this.i = bundle.getInt("is_top", 0);
        this.j = bundle.getLong("thread_time");
        this.q = bundle.getBoolean("from_frs", false);
        this.r = bundle.getBoolean("from_mark", false);
        this.o = bundle.getBoolean("is_ad", false);
        this.p = bundle.getBoolean("is_sub_pb", false);
        this.t = bundle.getBoolean("is_pv", false);
        this.s = bundle.getLong("msg_id", 0L);
        this.u = bundle.getString(com.baidu.tbadk.core.frameworkData.a.FORUM_NAME);
        this.H = bundle.getString("extra_pb_cache_key");
    }

    public void b(Bundle bundle) {
        bundle.putString(com.baidu.tbadk.core.frameworkData.a.THREAD_ID, this.d);
        bundle.putString(com.baidu.tbadk.core.frameworkData.a.POST_ID, this.e);
        bundle.putBoolean("host_only", this.f);
        bundle.putBoolean("squence", this.g);
        bundle.putString(com.baidu.tbadk.core.frameworkData.a.ST_TYPE, this.c);
        bundle.putInt("is_good", this.h);
        bundle.putInt("is_top", this.i);
        bundle.putLong("thread_time", this.j);
        bundle.putBoolean("from_frs", this.q);
        bundle.putBoolean("from_mark", this.r);
        bundle.putBoolean("is_sub_pb", this.p);
        bundle.putBoolean("is_ad", this.o);
        bundle.putBoolean("is_pv", this.t);
        bundle.putLong("msg_id", this.s);
        bundle.putString("extra_pb_cache_key", this.H);
    }

    public String e() {
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
        if (this.H != null) {
            sb.append(this.H);
        }
        return sb.toString();
    }

    public String f() {
        return this.u;
    }

    public String g() {
        return this.d;
    }

    public boolean h() {
        return this.f;
    }

    public boolean i() {
        return this.g;
    }

    public boolean j() {
        return this.q;
    }

    public boolean k() {
        return this.r;
    }

    public int l() {
        return this.h;
    }

    public int m() {
        if (this.v == null || this.v.g() == null) {
            return 0;
        }
        return this.v.g().getIsMem();
    }

    public int n() {
        return this.i;
    }

    public void a(int i) {
        this.h = i;
    }

    public void b(int i) {
        this.i = i;
    }

    public boolean o() {
        return this.p;
    }

    public boolean p() {
        if (this.v == null) {
            return false;
        }
        return this.v.a();
    }

    public String q() {
        if (this.v == null || !this.v.h()) {
            return null;
        }
        return this.v.i();
    }

    public boolean c(int i) {
        this.k = i;
        if (this.k > this.v.e().a()) {
            this.k = this.v.e().a();
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

    public com.baidu.tieba.data.ai r() {
        return this.v;
    }

    public com.baidu.tbadk.core.data.k s() {
        if (this.v == null) {
            return null;
        }
        return this.v.e();
    }

    public boolean t() {
        if (this.g) {
            if (this.v.e().e() == 0) {
                a(true);
                return true;
            }
        } else if (this.v.e().f() == 0) {
            b(true);
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        if (this.d == null) {
            return false;
        }
        if (this.w != null) {
            this.w.cancel();
        }
        if (this.J == null) {
            this.J = new com.baidu.tieba.b.a("pbStat");
            this.J.a();
        }
        this.w = new bo(this, 3);
        this.w.setPriority(3);
        this.w.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.base.e
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

    public void u() {
        G();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        if (this.J != null) {
            this.J.b();
            this.J = null;
        }
    }

    public boolean v() {
        return (this.e == null || this.e.equals("0")) ? LoadData() : w();
    }

    public boolean w() {
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
        if ((z || this.v.e().e() != 0) && this.w == null) {
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
        if ((z || this.v.e().f() != 0) && this.v.d() != null && this.v.d().size() >= 1 && this.w == null) {
            this.w = new bo(this, 2);
            this.w.setPriority(3);
            this.w.execute(new Object[0]);
            return true;
        }
        return false;
    }

    public boolean x() {
        this.f = !this.f;
        if (this.f) {
            this.g = true;
        }
        LoadData();
        return true;
    }

    public boolean y() {
        this.g = !this.g;
        if (!this.g) {
            this.f = false;
        }
        LoadData();
        return true;
    }

    public boolean z() {
        return this.g;
    }

    public boolean A() {
        return (this.v == null || this.v.b() == null || this.v.c() == null) ? false : true;
    }

    public boolean B() {
        if (this.v == null) {
            return false;
        }
        return this.v.h();
    }

    public WriteData a(String str) {
        if (this.v == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumId(this.v.b().getId());
        writeData.setForumName(this.v.b().getName());
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

    public com.baidu.tieba.data.at a(com.baidu.tieba.data.am amVar) {
        if (amVar == null) {
            return null;
        }
        com.baidu.tieba.data.at atVar = new com.baidu.tieba.data.at();
        atVar.a(this.v.b());
        atVar.a(this.v.c());
        atVar.a(amVar);
        atVar.a(amVar.i());
        atVar.c(amVar.t());
        String i = this.v.i();
        String l = amVar.l();
        if (B() && i != null && l != null && i.equals(l)) {
            atVar.a(true);
            return atVar;
        }
        atVar.a(false);
        return atVar;
    }

    public MarkData f(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.v == null || this.v.d() == null) {
            return null;
        }
        ArrayList<com.baidu.tieba.data.am> d = this.v.d();
        if (d.size() > 0 && i == d.size()) {
            i = d.size() - 1;
        }
        if (d.size() <= 0 || i >= d.size()) {
            return null;
        }
        return b(d.get(i));
    }

    public MarkData C() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkApplication.getCurrentAccount());
        markData.setThreadId(this.d);
        markData.setPostId(this.v.i());
        markData.setTime(date.getTime());
        markData.setHostMode(this.f);
        markData.setSequence(Boolean.valueOf(this.g));
        markData.setId(this.d);
        return markData;
    }

    public MarkData b(com.baidu.tieba.data.am amVar) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkApplication.getCurrentAccount());
        markData.setThreadId(this.d);
        markData.setPostId(amVar.l());
        markData.setTime(date.getTime());
        markData.setHostMode(this.f);
        markData.setSequence(Boolean.valueOf(this.g));
        markData.setId(this.d);
        markData.setFloor(amVar.m());
        return markData;
    }

    public void D() {
        F();
        String H = H();
        if (this.r) {
            if (this.B != null && H != null) {
                this.B.b(H, "", 0L);
            }
        } else if (this.C != null && H != null) {
            this.C.b(H, "", 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String H() {
        String str = this.d;
        if (this.f) {
            str = String.valueOf(str) + "_host";
        }
        if (!this.g) {
            str = String.valueOf(str) + "_rev";
        }
        if (TbadkApplication.getCurrentAccount() != null) {
            return String.valueOf(str) + TbadkApplication.getCurrentAccount();
        }
        return str;
    }

    public void c(boolean z) {
        if (this.v != null) {
            this.v.a(z);
        }
    }

    public void d(boolean z) {
        this.I = z;
    }

    public void a(bn bnVar) {
        this.z = bnVar;
    }
}
