package com.baidu.tieba.pb.sub;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ah;
import com.baidu.tieba.ai;
import com.baidu.tieba.data.an;
import com.baidu.tieba.data.au;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.base.e {
    private static BdAsyncTaskParallel i = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
    protected Context e;
    protected au f;
    private ArrayList<au> j;
    private SubPbRequestMessage m;
    protected int a = 0;
    protected String b = null;
    protected String c = null;
    protected String d = null;
    protected g g = null;
    private int h = 0;
    private boolean k = false;
    private com.baidu.tieba.b.a l = null;
    private com.baidu.adp.framework.listener.a n = new f(this, 1002100, 302002);

    static {
        q();
    }

    public void a(Intent intent) {
        if (intent != null) {
            this.b = intent.getStringExtra(com.baidu.tbadk.core.frameworkData.a.THREAD_ID);
            this.c = intent.getStringExtra(com.baidu.tbadk.core.frameworkData.a.POST_ID);
            this.d = intent.getStringExtra(com.baidu.tbadk.core.frameworkData.a.ST_TYPE);
        }
    }

    public void a(Bundle bundle) {
        if (bundle != null) {
            this.b = bundle.getString(com.baidu.tbadk.core.frameworkData.a.THREAD_ID);
            this.c = bundle.getString(com.baidu.tbadk.core.frameworkData.a.POST_ID);
            this.d = bundle.getString(com.baidu.tbadk.core.frameworkData.a.ST_TYPE);
        }
    }

    public void b(Bundle bundle) {
        if (bundle != null) {
            bundle.putString(com.baidu.tbadk.core.frameworkData.a.THREAD_ID, this.b);
            bundle.putString(com.baidu.tbadk.core.frameworkData.a.POST_ID, this.c);
            bundle.putString(com.baidu.tbadk.core.frameworkData.a.ST_TYPE, this.d);
        }
    }

    public e(Context context) {
        this.e = null;
        this.f = null;
        this.j = null;
        this.e = context;
        this.j = new ArrayList<>();
        this.f = new au();
        setUniqueId(BdUniqueId.gen());
        r();
    }

    public void a(String str) {
        this.b = str;
    }

    public String a() {
        return this.b;
    }

    public void b(String str) {
        this.c = str;
    }

    public String b() {
        return this.c;
    }

    public String c() {
        return this.d;
    }

    public void d() {
        this.f = new au();
    }

    public au e() {
        return this.f;
    }

    public WriteData f() {
        if (this.f == null || this.f.i() == null || this.f.n() == null || this.f.b() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumName(this.f.i().getName());
        writeData.setForumId(this.f.i().getId());
        writeData.setFloor(this.f.b().d());
        writeData.setType(2);
        writeData.setThreadId(this.f.n().h());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void a(g gVar) {
        this.g = gVar;
    }

    public void g() {
        cancelMessage();
        s();
        o();
    }

    private void o() {
        if (this.l != null) {
            this.l.b();
            this.l = null;
        }
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    public int h() {
        return this.a;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        cancelMessage();
        return true;
    }

    public void c(String str) {
        if (!TextUtils.isEmpty(str) && this.f != null && this.f.d() != null) {
            ArrayList<an> d = this.f.d();
            int size = d.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (str.equals(d.get(i2).d())) {
                    d.remove(i2);
                    this.h++;
                    this.f.c(this.f.f() - 1);
                    return;
                }
            }
        }
    }

    protected int i() {
        int h = this.f.h();
        if (h == 0) {
            return h + 1;
        }
        if (this.a == 0) {
            return h + 1;
        }
        if (this.a == 2 && this.f.d().size() % this.f.g() == 0) {
            return h + 1;
        }
        if (this.a == 3 && h > 0) {
            return this.f.c() - 1;
        }
        return h;
    }

    private SubPbRequestMessage p() {
        this.k = true;
        return a((Integer) null);
    }

    private SubPbRequestMessage a(Integer num) {
        long j;
        int intValue;
        long j2 = 0;
        float f = ai.c().d().getResources().getDisplayMetrics().density;
        int b = com.baidu.adp.lib.util.j.b(ai.c().d());
        int c = com.baidu.adp.lib.util.j.c(ai.c().d());
        if (1 != this.a) {
            j = Long.parseLong(this.c);
        } else {
            j = 0;
            j2 = Long.parseLong(this.c);
        }
        if (num == null) {
            intValue = i();
        } else {
            intValue = num.intValue();
        }
        return new SubPbRequestMessage(this.e, Long.parseLong(this.b), j, j2, intValue, b, c, f, this.d);
    }

    public boolean j() {
        if (this.k) {
            return false;
        }
        cancelMessage();
        if (this.b == null || this.c == null) {
            this.k = false;
            return false;
        }
        l();
        this.a = 0;
        this.m = p();
        sendMessage(this.m);
        return true;
    }

    public boolean k() {
        if (this.k) {
            return false;
        }
        cancelMessage();
        if (this.b == null || this.c == null) {
            this.k = false;
            return false;
        } else if (this.f.m()) {
            return false;
        } else {
            l();
            this.a = 2;
            this.m = p();
            sendMessage(this.m);
            return true;
        }
    }

    public void l() {
        int g;
        if (this.h > 0 && this.f != null && (g = this.f.g()) > 0) {
            int h = this.f.h();
            for (int i2 = (((this.h + g) - 1) / g) - 1; i2 >= 0; i2--) {
                this.m = a(Integer.valueOf(h - i2));
                this.m.setTreatDelPage(true);
                sendMessage(this.m);
            }
        }
        this.h = 0;
    }

    public boolean m() {
        if (this.k) {
            return false;
        }
        cancelMessage();
        if (this.b == null || this.c == null) {
            this.k = false;
            return false;
        }
        l();
        this.a = 1;
        this.m = p();
        sendMessage(this.m);
        return true;
    }

    public boolean n() {
        if (this.k) {
            return false;
        }
        cancelMessage();
        if (this.b == null || this.c == null) {
            this.k = false;
            return false;
        }
        l();
        this.a = 3;
        this.m = p();
        sendMessage(this.m);
        return true;
    }

    private static void q() {
        com.baidu.tbadk.task.b a = ah.a(302002, SubPbSocketResponseMessage.class, false, false);
        TbHttpMessageTask a2 = ah.a(302002, 1002100, "c/f/pb/floor", SubPbHttpResponseMessage.class, false, false, false, false);
        a.setParallel(i);
        a2.setParallel(i);
    }

    private void r() {
        MessageManager.getInstance().unRegisterListener(this.n);
        MessageManager.getInstance().registerListener(this.n);
    }

    private void s() {
        MessageManager.getInstance().unRegisterListener(this.n);
    }

    public void a(au auVar) {
        String str;
        if (auVar.n() == null || auVar.n().q() == null) {
            str = null;
        } else {
            str = auVar.n().q().getUserId();
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < auVar.d().size()) {
                auVar.d().get(i3).a(this.e, str.equals(auVar.d().get(i3).g().getUserId()));
                i2 = i3 + 1;
            } else {
                this.j.add(auVar);
                return;
            }
        }
    }
}
