package com.baidu.tieba.pb.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.data.MarkData;
import com.baidu.tieba.pb.history.RequestPbHistoryWriteMessage;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
public class bl extends com.baidu.adp.base.e {
    private static final int a = com.baidu.tieba.data.e.f() / 30;
    private static com.baidu.tieba.data.al w = new com.baidu.tieba.data.al();
    private boolean E;
    private com.baidu.tieba.data.aj u;
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
    private boolean v = false;
    private bn y = null;
    private long z = 0;
    private long A = 0;
    private long B = 0;
    private long C = 0;
    private String D = null;
    private com.baidu.tieba.b.a F = null;
    private CustomMessageListener G = new bm(this, 2004003);
    private PraiseData H = null;

    public long a() {
        return this.C;
    }

    public long b() {
        return this.A;
    }

    public long c() {
        return this.B;
    }

    public long d() {
        return this.z;
    }

    public bl(Context context) {
        this.u = null;
        this.x = null;
        if (context instanceof PbActivity) {
            setUniqueId(((PbActivity) context).getUniqueId());
        } else {
            setUniqueId(BdUniqueId.gen());
        }
        registerListener(this.G);
        this.u = new com.baidu.tieba.data.aj();
        w.a();
        this.x = context;
    }

    private void a(String str, boolean z, String str2, int i) {
        PbPageReadLocalRequestMessage pbPageReadLocalRequestMessage = new PbPageReadLocalRequestMessage();
        pbPageReadLocalRequestMessage.setCacheKey(str);
        pbPageReadLocalRequestMessage.setContext(this.x);
        pbPageReadLocalRequestMessage.setMarkCache(z);
        pbPageReadLocalRequestMessage.setPostId(str2);
        pbPageReadLocalRequestMessage.setUpdateType(i);
        sendMessage(pbPageReadLocalRequestMessage);
    }

    public void a(Intent intent) {
        this.c = intent.getStringExtra(com.baidu.tbadk.core.frameworkData.a.THREAD_ID);
        this.d = intent.getStringExtra(com.baidu.tbadk.core.frameworkData.a.POST_ID);
        this.e = intent.getBooleanExtra("host_only", false);
        this.f = intent.getBooleanExtra("squence", true);
        this.b = intent.getStringExtra(com.baidu.tbadk.core.frameworkData.a.ST_TYPE);
        this.g = intent.getIntExtra("is_good", 0);
        this.h = intent.getIntExtra("is_top", 0);
        this.i = intent.getLongExtra("thread_time", 0L);
        this.p = intent.getBooleanExtra("from_frs", false);
        this.q = intent.getBooleanExtra("from_mark", false);
        this.n = intent.getBooleanExtra("is_ad", false);
        this.o = intent.getBooleanExtra("is_sub_pb", false);
        this.s = intent.getBooleanExtra("is_pv", false);
        this.r = intent.getLongExtra("msg_id", 0L);
        this.t = intent.getStringExtra(com.baidu.tbadk.core.frameworkData.a.FORUM_NAME);
        this.D = intent.getStringExtra("extra_pb_cache_key");
    }

    public void a(Bundle bundle) {
        this.c = bundle.getString(com.baidu.tbadk.core.frameworkData.a.THREAD_ID);
        this.d = bundle.getString(com.baidu.tbadk.core.frameworkData.a.POST_ID);
        this.e = bundle.getBoolean("host_only", false);
        this.f = bundle.getBoolean("squence", true);
        this.b = bundle.getString(com.baidu.tbadk.core.frameworkData.a.ST_TYPE);
        this.g = bundle.getInt("is_good", 0);
        this.h = bundle.getInt("is_top", 0);
        this.i = bundle.getLong("thread_time");
        this.p = bundle.getBoolean("from_frs", false);
        this.q = bundle.getBoolean("from_mark", false);
        this.n = bundle.getBoolean("is_ad", false);
        this.o = bundle.getBoolean("is_sub_pb", false);
        this.s = bundle.getBoolean("is_pv", false);
        this.r = bundle.getLong("msg_id", 0L);
        this.t = bundle.getString(com.baidu.tbadk.core.frameworkData.a.FORUM_NAME);
        this.D = bundle.getString("extra_pb_cache_key");
    }

    public void b(Bundle bundle) {
        bundle.putString(com.baidu.tbadk.core.frameworkData.a.THREAD_ID, this.c);
        bundle.putString(com.baidu.tbadk.core.frameworkData.a.POST_ID, this.d);
        bundle.putBoolean("host_only", this.e);
        bundle.putBoolean("squence", this.f);
        bundle.putString(com.baidu.tbadk.core.frameworkData.a.ST_TYPE, this.b);
        bundle.putInt("is_good", this.g);
        bundle.putInt("is_top", this.h);
        bundle.putLong("thread_time", this.i);
        bundle.putBoolean("from_frs", this.p);
        bundle.putBoolean("from_mark", this.q);
        bundle.putBoolean("is_sub_pb", this.o);
        bundle.putBoolean("is_ad", this.n);
        bundle.putBoolean("is_pv", this.s);
        bundle.putLong("msg_id", this.r);
        bundle.putString("extra_pb_cache_key", this.D);
    }

    public String e() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.c);
        sb.append(this.d);
        sb.append(this.e);
        sb.append(this.f);
        sb.append(this.b);
        sb.append(this.g);
        sb.append(this.h);
        sb.append(this.i);
        sb.append(this.p);
        sb.append(this.q);
        sb.append(this.n);
        sb.append(this.o);
        sb.append(this.s);
        sb.append(this.r);
        sb.append(this.t);
        if (this.D != null) {
            sb.append(this.D);
        }
        return sb.toString();
    }

    public String f() {
        return this.t;
    }

    public String g() {
        return this.c;
    }

    public boolean h() {
        return this.e;
    }

    public boolean i() {
        return this.f;
    }

    public boolean j() {
        return this.p;
    }

    public boolean k() {
        return this.q;
    }

    public int l() {
        return this.g;
    }

    public int m() {
        if (this.u == null || this.u.h() == null) {
            return 0;
        }
        return this.u.h().getIsMem();
    }

    public int n() {
        return this.h;
    }

    public void a(int i) {
        this.g = i;
    }

    public void b(int i) {
        this.h = i;
    }

    public boolean o() {
        return this.o;
    }

    public boolean p() {
        if (this.u == null) {
            return false;
        }
        return this.u.b();
    }

    public String q() {
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
        return f(5);
    }

    public void d(int i) {
        this.j = i;
        this.k = i;
        this.l = i;
    }

    public void e(int i) {
        if (this.k < i) {
            this.k = i;
            if (this.k - this.l >= a) {
                this.l = (this.k - a) + 1;
            }
        }
        if (this.l > i) {
            this.l = i;
            if (this.k - this.l >= a) {
                this.k = (this.l + a) - 1;
            }
        }
    }

    public com.baidu.tieba.data.aj r() {
        return this.u;
    }

    public com.baidu.tbadk.core.data.l s() {
        if (this.u == null) {
            return null;
        }
        return this.u.f();
    }

    public boolean t() {
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

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        if (this.c == null) {
            return false;
        }
        cancelLoadData();
        if (this.F == null) {
            this.F = new com.baidu.tieba.b.a("pbStat");
            this.F.a();
        }
        return f(3);
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        cancelMessage();
        return true;
    }

    public void u() {
        cancelLoadData();
        MessageManager.getInstance().unRegisterListener(this.unique_id);
        E();
    }

    private void E() {
        if (this.F != null) {
            this.F.b();
            this.F = null;
        }
    }

    public boolean v() {
        return (this.d == null || this.d.equals("0") || this.d.length() == 0) ? LoadData() : w();
    }

    public boolean f(int i) {
        if (this.v) {
            return false;
        }
        this.v = true;
        g(i);
        com.baidu.tieba.data.aj b = bp.a().b();
        if (b != null) {
            this.f = bp.a().d();
            this.e = bp.a().e();
            if (!this.f || this.e || this.q) {
                this.E = false;
            }
            a(b, 3, false, 0, "", false, 0, 0L, 0L, true);
            this.v = false;
            return false;
        }
        pbPageRequestMessage pbpagerequestmessage = new pbPageRequestMessage();
        pbpagerequestmessage.setUpdateType(i);
        if (!this.f || this.e || this.q) {
            this.E = false;
        }
        try {
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.c == null || this.c.length() == 0) {
            this.v = false;
            return false;
        }
        pbpagerequestmessage.set_kz(Long.parseLong(this.c));
        pbpagerequestmessage.set_rn(30);
        pbpagerequestmessage.set_with_floor(1);
        int b2 = com.baidu.adp.lib.util.j.b(com.baidu.tieba.ai.c().d());
        int c = com.baidu.adp.lib.util.j.c(com.baidu.tieba.ai.c().d());
        float f = com.baidu.tieba.ai.c().d().getResources().getDisplayMetrics().density;
        int i2 = com.baidu.tbadk.core.util.bb.a().d().equals(String.valueOf(0)) ? 2 : 1;
        pbpagerequestmessage.set_scr_w(Integer.valueOf(b2));
        pbpagerequestmessage.set_scr_h(Integer.valueOf(c));
        pbpagerequestmessage.set_scr_dip(f);
        pbpagerequestmessage.set_q_type(Integer.valueOf(i2));
        if (!this.f) {
            pbpagerequestmessage.set_r(1);
        }
        if (this.e) {
            pbpagerequestmessage.set_lz(1);
        }
        if (this.b != null) {
            pbpagerequestmessage.set_st_type(this.b);
        }
        if (this.s) {
            pbpagerequestmessage.set_message_id(Integer.valueOf((int) this.r));
            pbpagerequestmessage.set_message_click(TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
        }
        if (this.E) {
            pbpagerequestmessage.set_banner(1);
        }
        ArrayList<com.baidu.tieba.data.an> e2 = this.u.e();
        switch (i) {
            case 1:
                pbpagerequestmessage.set_back(0);
                if (!this.q) {
                    if (!this.f) {
                        if (this.l > 0) {
                            pbpagerequestmessage.set_pn(Integer.valueOf(this.l - 1));
                        }
                    } else if (this.k < this.m) {
                        pbpagerequestmessage.set_pn(Integer.valueOf(this.k + 1));
                    }
                }
                this.d = e2.get(e2.size() - 1).d();
                if (this.d != null && this.d.length() > 0) {
                    pbpagerequestmessage.set_pid(Long.parseLong(this.d));
                    break;
                } else if (!this.f) {
                    pbpagerequestmessage.set_last(1);
                    break;
                }
                break;
            case 2:
                this.d = e2.get(0).d();
                pbpagerequestmessage.set_back(1);
                if (this.q) {
                    if (this.f) {
                        if (this.l > 0) {
                            pbpagerequestmessage.set_pn(Integer.valueOf(this.l - 1));
                        }
                    } else if (this.k < this.m) {
                        pbpagerequestmessage.set_pn(Integer.valueOf(this.k + 1));
                    }
                }
                if (this.d != null && this.d.length() > 0) {
                    pbpagerequestmessage.set_pid(Long.parseLong(this.d));
                    break;
                }
                break;
            case 3:
                if (this.q) {
                    a(F(), true, this.d, 3);
                } else {
                    a(F(), false, this.d, 3);
                }
                pbpagerequestmessage.set_back(0);
                if (this.f) {
                    pbpagerequestmessage.set_pn(1);
                } else {
                    pbpagerequestmessage.set_last(1);
                }
                if (this.q) {
                    pbpagerequestmessage.set_st_type("store_thread");
                    break;
                }
                break;
            case 4:
                a(F(), true, this.d, 3);
                pbpagerequestmessage.set_st_type("store_thread");
                pbpagerequestmessage.set_mark(1);
                pbpagerequestmessage.set_pid(Long.parseLong(this.d));
                pbpagerequestmessage.set_back(0);
                break;
            case 5:
                pbpagerequestmessage.set_back(0);
                pbpagerequestmessage.set_pn(Integer.valueOf(this.j));
                pbpagerequestmessage.set_banner(0);
                break;
            case 6:
                pbpagerequestmessage.set_mark(1);
                pbpagerequestmessage.set_pid(Long.parseLong(this.d));
                pbpagerequestmessage.set_back(0);
                break;
        }
        pbpagerequestmessage.setIsFromMark(Boolean.valueOf(this.q));
        pbpagerequestmessage.setCacheKey(F());
        pbpagerequestmessage.setContext(this.x);
        sendMessage(pbpagerequestmessage);
        return true;
    }

    protected void g(int i) {
        boolean z = false;
        ArrayList<com.baidu.tieba.data.an> e = this.u.e();
        if (i == 1) {
            boolean z2 = false;
            while (e.size() + 30 > com.baidu.tieba.data.e.f()) {
                e.remove(0);
                z2 = true;
            }
            if (z2) {
                this.u.f().f(1);
                if (this.y != null) {
                    this.y.a(this.u);
                }
            }
        } else if (i == 2) {
            while (e.size() + 30 > com.baidu.tieba.data.e.f()) {
                e.remove(e.size() - 1);
                z = true;
            }
            if (z) {
                this.u.f().e(1);
            }
        }
    }

    public void a(com.baidu.tieba.data.aj ajVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        com.baidu.tieba.data.aj ajVar2 = z ? null : ajVar;
        this.v = false;
        if (!z) {
            w.a((int) (j + j2));
            w.b(i3);
        } else {
            w.c(1);
        }
        if (ajVar2 != null) {
            a(ajVar2);
        }
        a(ajVar2, i, z, i2, str, z2, i3, j, j2, false);
    }

    public void a(pbPageSocketResponseMessage pbpagesocketresponsemessage) {
        a(pbpagesocketresponsemessage.getPbData(), pbpagesocketresponsemessage.getUpdateType(), pbpagesocketresponsemessage.hasError(), pbpagesocketresponsemessage.getError(), pbpagesocketresponsemessage.getErrorString(), false, pbpagesocketresponsemessage.getDownSize(), 0L, pbpagesocketresponsemessage.getCostTime());
    }

    public void a(pbPageHttpResponseMessage pbpagehttpresponsemessage) {
        a(pbpagehttpresponsemessage.getPbData(), pbpagehttpresponsemessage.getUpdateType(), pbpagehttpresponsemessage.hasError(), pbpagehttpresponsemessage.getError(), pbpagehttpresponsemessage.getErrorString(), true, pbpagehttpresponsemessage.getDownSize(), pbpagehttpresponsemessage.getCostTime(), 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.data.aj ajVar) {
        String str;
        if (ajVar != null) {
            if (ajVar.d() == null || ajVar.d().q() == null) {
                str = null;
            } else {
                str = ajVar.d().q().getUserId();
            }
            com.baidu.tbadk.core.data.n d = ajVar.d();
            d.c(this.g);
            d.b(this.h);
            d.a(this.i);
            for (int i = 0; i < ajVar.e().size(); i++) {
                com.baidu.tieba.data.an anVar = ajVar.e().get(i);
                for (int i2 = 0; i2 < anVar.n_().size(); i2++) {
                    anVar.n_().get(i2).a(this.x, str.equals(anVar.n_().get(i2).g().getUserId()));
                }
            }
        }
    }

    protected void a(com.baidu.tieba.data.aj ajVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        boolean z4 = !z;
        if (this.F != null && !z3) {
            this.F.a(z2, z4, i2, str, i3, j, j2);
            this.F = null;
        }
        if (ajVar == null) {
            if (this.y != null) {
                this.y.a(false, getErrorCode(), i, 0, null, this.mErrorString, 1);
            }
        } else {
            this.s = false;
            e(ajVar.f().d());
            this.m = ajVar.f().a();
            this.m = this.m < 1 ? 1 : this.m;
            int i4 = 0;
            ArrayList<com.baidu.tieba.data.an> e = this.u.e();
            switch (i) {
                case 1:
                    this.u.a(ajVar.f(), 1);
                    e.addAll(ajVar.e());
                    break;
                case 2:
                    i4 = ajVar.e().size() + 1;
                    this.u.a(ajVar.f(), 2);
                    e.addAll(0, ajVar.e());
                    break;
                case 3:
                    if (!this.f) {
                        ajVar.f().c(ajVar.f().a());
                    }
                    b(ajVar);
                    break;
                case 4:
                    b(ajVar);
                    break;
                case 5:
                    b(ajVar);
                    break;
                case 6:
                    b(ajVar);
                    break;
            }
            if (this.u != null && this.u.d() != null) {
                PraiseData g = this.u.d().g();
                if (this.H != null && !g.isPriaseDataValid()) {
                    this.u.d().a(this.H);
                } else {
                    this.H = this.u.d().g();
                    this.H.setPostId(this.u.d().A());
                }
                this.u.d().a(ajVar.d().k());
            }
            if (this.y != null) {
                this.y.a(true, getErrorCode(), i, i4, this.u, this.mErrorString, 1);
            }
        }
        if (this.u != null && this.u.h() != null) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001200, Integer.valueOf(this.u.h().getIsMem())));
        }
        if (this.u != null && this.u.d() != null && this.u.c() != null) {
            RequestPbHistoryWriteMessage requestPbHistoryWriteMessage = new RequestPbHistoryWriteMessage();
            com.baidu.tieba.data.ak akVar = new com.baidu.tieba.data.ak();
            akVar.a(this.u.d().h());
            akVar.c(this.u.c().getName());
            akVar.b(this.u.d().j());
            requestPbHistoryWriteMessage.setData(akVar);
            MessageManager.getInstance().sendMessageFromBackground(requestPbHistoryWriteMessage);
        }
    }

    private void b(com.baidu.tieba.data.aj ajVar) {
        this.u = ajVar;
        d(ajVar.f().d());
    }

    public boolean w() {
        if (this.c == null || this.d == null) {
            return false;
        }
        cancelMessage();
        if (this.q) {
            return f(4);
        }
        return f(6);
    }

    public boolean a(boolean z) {
        if (this.c == null || this.u == null) {
            return false;
        }
        if (z || this.u.f().f() != 0) {
            return f(1);
        }
        return false;
    }

    public boolean b(boolean z) {
        if (this.c == null || this.u == null) {
            return false;
        }
        if ((z || this.u.f().g() != 0) && this.u.e() != null && this.u.e().size() >= 1) {
            return f(2);
        }
        return false;
    }

    public boolean x() {
        this.e = !this.e;
        if (this.e) {
            this.f = true;
        }
        LoadData();
        return true;
    }

    public boolean y() {
        this.f = !this.f;
        if (!this.f) {
            this.e = false;
        }
        return LoadData();
    }

    public boolean z() {
        return this.f;
    }

    public boolean A() {
        return (this.u == null || this.u.c() == null || this.u.d() == null) ? false : true;
    }

    public boolean B() {
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

    public com.baidu.tieba.data.au a(com.baidu.tieba.data.an anVar) {
        if (anVar == null) {
            return null;
        }
        com.baidu.tieba.data.au auVar = new com.baidu.tieba.data.au();
        auVar.a(this.u.c());
        auVar.a(this.u.d());
        auVar.a(anVar);
        auVar.a(anVar.n_());
        auVar.c(anVar.l());
        String j = this.u.j();
        String d = anVar.d();
        if (B() && j != null && d != null && j.equals(d)) {
            auVar.a(true);
            return auVar;
        }
        auVar.a(false);
        return auVar;
    }

    public MarkData h(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.u == null || this.u.e() == null) {
            return null;
        }
        ArrayList<com.baidu.tieba.data.an> e = this.u.e();
        if (e.size() > 0 && i == e.size()) {
            i = e.size() - 1;
        }
        if (e.size() <= 0 || i >= e.size()) {
            return null;
        }
        return b(e.get(i));
    }

    public MarkData C() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkApplication.getCurrentAccount());
        markData.setThreadId(this.c);
        markData.setPostId(this.u.j());
        markData.setTime(date.getTime());
        markData.setHostMode(this.e);
        markData.setSequence(Boolean.valueOf(this.f));
        markData.setId(this.c);
        return markData;
    }

    public MarkData b(com.baidu.tieba.data.an anVar) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkApplication.getCurrentAccount());
        markData.setThreadId(this.c);
        markData.setPostId(anVar.d());
        markData.setTime(date.getTime());
        markData.setHostMode(this.e);
        markData.setSequence(Boolean.valueOf(this.f));
        markData.setId(this.c);
        markData.setFloor(anVar.e());
        return markData;
    }

    public void D() {
        bk.a().a(F(), this.q);
    }

    private String F() {
        String str = this.c;
        if (this.e) {
            str = String.valueOf(str) + "_host";
        }
        if (!this.f) {
            str = String.valueOf(str) + "_rev";
        }
        if (TbadkApplication.getCurrentAccount() != null) {
            return String.valueOf(str) + TbadkApplication.getCurrentAccount();
        }
        return str;
    }

    public void c(boolean z) {
        if (this.u != null) {
            this.u.b(z);
        }
    }

    public void d(boolean z) {
        this.E = z;
    }

    public void a(bn bnVar) {
        this.y = bnVar;
    }
}
