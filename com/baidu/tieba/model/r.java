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
    private com.baidu.tieba.data.be f;
    private com.baidu.tieba.util.ag c = null;
    private String d = null;

    /* renamed from: a  reason: collision with root package name */
    Boolean f1957a = false;

    public r(o oVar, int i) {
        this.b = oVar;
        this.e = 0;
        this.f = null;
        this.e = i;
        this.f = new com.baidu.tieba.data.be();
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
        String a2;
        this.f1957a = boolArr[0];
        o oVar = new o();
        if (this.f1957a.booleanValue()) {
            com.baidu.adp.lib.cache.s<String> h = com.baidu.tieba.b.a.a().h();
            if (h != null && (a2 = h.a(TiebaApplication.C())) != null) {
                c((Object[]) new String[]{a2});
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
        this.c = new com.baidu.tieba.util.ag(com.baidu.tieba.data.h.f1165a + "c/f/post/threadstore");
        this.c.a(PushConstants.EXTRA_USER_ID, TiebaApplication.C());
        this.c.a("offset", String.valueOf(this.e));
        this.c.a("rn", String.valueOf(20));
        this.d = this.c.j();
        this.f.a(this.d);
        if (this.c.c()) {
            oVar.a(this.d);
            if (this.e == 0 && this.f1957a.booleanValue()) {
                a(this.d);
            }
        }
        return oVar;
    }

    private void a(String str) {
        com.baidu.adp.lib.cache.s<String> h;
        String C = TiebaApplication.C();
        if (C != null && (h = com.baidu.tieba.b.a.a().h()) != null) {
            h.a(C, str, 604800000L);
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
        b = this.b.b(str);
        if (str != null) {
            if (this.f1957a.booleanValue()) {
                this.b.a(b);
            } else {
                this.b.b(b);
            }
        }
        this.b.f1955a.a(0, null, true);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.c != null) {
            this.c.h();
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
        if (this.f1957a.booleanValue()) {
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
        if (this.b.f1955a != null) {
            if (this.c.c()) {
                String b = this.f.b();
                TiebaApplication.g().a((Boolean) true);
                this.b.f1955a.a(0, b, false);
                return;
            }
            this.b.f1955a.a(3, this.c.g());
        }
    }
}
