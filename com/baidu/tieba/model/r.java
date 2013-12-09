package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.MarkData;
import java.util.ArrayList;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends BdAsyncTask<Boolean, String, o> {
    final /* synthetic */ o b;
    private int e;
    private com.baidu.tieba.data.ay f;
    private com.baidu.tieba.util.am c = null;
    private String d = null;

    /* renamed from: a  reason: collision with root package name */
    Boolean f2044a = false;

    public r(o oVar, int i) {
        this.b = oVar;
        this.e = 0;
        this.f = null;
        this.e = i;
        this.f = new com.baidu.tieba.data.ay();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public o a(Boolean... boolArr) {
        ArrayList arrayList;
        ArrayList arrayList2;
        this.f2044a = boolArr[0];
        o oVar = new o();
        if (this.f2044a.booleanValue()) {
            com.baidu.adp.lib.cache.s<String> l = com.baidu.tieba.b.a.a().l();
            if (l != null) {
                c((Object[]) new String[]{l.a(TiebaApplication.B())});
            }
            arrayList = this.b.e;
            if (arrayList == null) {
                this.b.e = new ArrayList();
            } else {
                arrayList2 = this.b.e;
                arrayList2.clear();
            }
            this.b.f = 0;
        }
        this.c = new com.baidu.tieba.util.am(com.baidu.tieba.data.h.f1248a + "c/f/post/threadstore");
        this.c.a(PushConstants.EXTRA_USER_ID, TiebaApplication.B());
        this.c.a("offset", String.valueOf(this.e));
        this.c.a("rn", String.valueOf(20));
        this.d = this.c.l();
        this.f.a(this.d);
        if (this.c.c()) {
            oVar.a(this.d);
            if (this.e == 0 && this.f2044a.booleanValue()) {
                a(this.d);
            }
        }
        return oVar;
    }

    private void a(String str) {
        com.baidu.adp.lib.cache.s<String> l;
        String B = TiebaApplication.B();
        if (B != null && (l = com.baidu.tieba.b.a.a().l()) != null) {
            l.a(B, str, 604800000L);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void b(String... strArr) {
        ArrayList<MarkData> b;
        super.b((Object[]) strArr);
        String str = strArr[0];
        ArrayList<MarkData> arrayList = new ArrayList<>();
        if (str != null) {
            b = this.b.b(str);
            if (this.f2044a.booleanValue()) {
                this.b.a(b);
            } else {
                this.b.b(b);
            }
        } else {
            this.b.a(arrayList);
        }
        this.b.f2042a.a(0, null, true);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.c != null) {
            this.c.j();
        }
        this.b.b = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(o oVar) {
        int i;
        this.b.b = null;
        this.b.f = oVar.d();
        ArrayList<MarkData> c = oVar.c();
        if (this.f2044a.booleanValue()) {
            this.b.a(c);
        } else {
            this.b.b(c);
        }
        Iterator<MarkData> it = c.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            if (it.next().getNewCounts() > 0) {
                i = i2 + 1;
                this.b.a(i);
            } else {
                i = i2;
            }
            i2 = i;
        }
        if (this.b.f2042a != null) {
            if (this.c.c()) {
                String b = this.f.b();
                TiebaApplication.h().a((Boolean) true);
                this.b.f2042a.a(0, b, false);
                return;
            }
            this.b.f2042a.a(3, this.c.i());
        }
    }
}
