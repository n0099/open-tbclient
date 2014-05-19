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
public class bc extends com.baidu.adp.base.d {
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
    private be w = null;
    private bd z = null;
    private long A = 0;
    private com.baidu.adp.lib.cache.s<String> B = null;
    private com.baidu.adp.lib.cache.s<String> C = null;
    protected com.baidu.tbadk.editortool.ab a = null;
    private long D = 0;
    private long E = 0;
    private long F = 0;
    private long G = 0;
    private String H = null;
    private PraiseData I = null;

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

    public bc(Context context) {
        this.v = null;
        this.y = null;
        this.v = new com.baidu.tieba.data.ae();
        x.a();
        this.y = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
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
        return this.d;
    }

    public boolean g() {
        return this.f;
    }

    public boolean h() {
        return this.g;
    }

    public boolean i() {
        return this.q;
    }

    public boolean j() {
        return this.r;
    }

    public int k() {
        return this.h;
    }

    public int l() {
        return this.i;
    }

    public void a(int i) {
        this.h = i;
    }

    public void b(int i) {
        this.i = i;
    }

    public boolean m() {
        return this.p;
    }

    public boolean n() {
        if (this.v == null) {
            return false;
        }
        return this.v.a();
    }

    public String o() {
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
        this.w = new be(this, 5);
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

    public com.baidu.tieba.data.ae p() {
        return this.v;
    }

    public com.baidu.tbadk.core.data.m q() {
        if (this.v == null) {
            return null;
        }
        return this.v.f();
    }

    public boolean r() {
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

    @Override // com.baidu.adp.base.d
    protected boolean LoadData() {
        if (this.d == null) {
            return false;
        }
        if (this.w != null) {
            this.w.cancel();
        }
        this.w = new be(this, 3);
        this.w.setPriority(3);
        this.w.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.base.d
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

    public boolean s() {
        return (this.e == null || this.e.equals("0")) ? LoadData() : t();
    }

    public boolean t() {
        if (this.d == null || this.e == null) {
            return false;
        }
        if (this.w != null) {
            this.w.cancel();
        }
        if (this.r) {
            this.w = new be(this, 4);
        } else {
            this.w = new be(this, 6);
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
            this.w = new be(this, 1);
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
            this.w = new be(this, 2);
            this.w.setPriority(3);
            this.w.execute(new Object[0]);
            return true;
        }
        return false;
    }

    public boolean u() {
        this.f = !this.f;
        if (this.f) {
            this.g = true;
        }
        LoadData();
        return true;
    }

    public boolean v() {
        this.g = !this.g;
        if (!this.g) {
            this.f = false;
        }
        LoadData();
        return true;
    }

    public boolean w() {
        return (this.v == null || this.v.c() == null || this.v.d() == null) ? false : true;
    }

    public boolean x() {
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

    public com.baidu.tieba.data.ao a(com.baidu.tieba.data.ah ahVar) {
        if (ahVar == null) {
            return null;
        }
        com.baidu.tieba.data.ao aoVar = new com.baidu.tieba.data.ao();
        aoVar.a(this.v.c());
        aoVar.a(this.v.d());
        aoVar.a(ahVar);
        aoVar.a(ahVar.a());
        aoVar.c(ahVar.k());
        String j = this.v.j();
        String d = ahVar.d();
        if (x() && j != null && d != null && j.equals(d)) {
            aoVar.a(true);
            return aoVar;
        }
        aoVar.a(false);
        return aoVar;
    }

    public MarkData f(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.v == null || this.v.e() == null) {
            return null;
        }
        ArrayList<com.baidu.tieba.data.ah> e = this.v.e();
        if (e.size() > 0 && i == e.size()) {
            i = e.size() - 1;
        }
        if (e.size() <= 0 || i >= e.size()) {
            return null;
        }
        return b(e.get(i));
    }

    public MarkData y() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkApplication.getCurrentAccount());
        markData.setThreadId(this.d);
        markData.setPostId(this.v.j());
        markData.setTime(date.getTime());
        markData.setHostMode(this.f);
        markData.setSequence(Boolean.valueOf(this.g));
        markData.setId(this.d);
        return markData;
    }

    public MarkData b(com.baidu.tieba.data.ah ahVar) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkApplication.getCurrentAccount());
        markData.setThreadId(this.d);
        markData.setPostId(ahVar.d());
        markData.setTime(date.getTime());
        markData.setHostMode(this.f);
        markData.setSequence(Boolean.valueOf(this.g));
        markData.setId(this.d);
        markData.setFloor(ahVar.e());
        return markData;
    }

    public void z() {
        B();
        String C = C();
        if (this.r) {
            if (this.B != null && C != null) {
                this.B.b(C, "", 0L);
            }
        } else if (this.C != null && C != null) {
            this.C.b(C, "", 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String C() {
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

    public void a(bd bdVar) {
        this.z = bdVar;
    }
}
