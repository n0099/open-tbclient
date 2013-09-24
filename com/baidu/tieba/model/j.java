package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.MarkData;
import java.util.ArrayList;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends BdAsyncTask<Boolean, String, h> {
    final /* synthetic */ h b;
    private int e;
    private com.baidu.tieba.data.bg f;
    private com.baidu.tieba.util.z c = null;
    private String d = null;

    /* renamed from: a  reason: collision with root package name */
    Boolean f1447a = false;

    public j(h hVar, int i) {
        this.b = hVar;
        this.e = 0;
        this.f = null;
        this.e = i;
        this.f = new com.baidu.tieba.data.bg();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public h a(Boolean... boolArr) {
        ArrayList arrayList;
        ArrayList arrayList2;
        String a2;
        this.f1447a = boolArr[0];
        h hVar = new h();
        if (this.f1447a.booleanValue()) {
            com.baidu.adp.lib.cache.q<String> g = com.baidu.tieba.b.a.a().g();
            if (g != null && (a2 = g.a(TiebaApplication.C())) != null) {
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
        this.c = new com.baidu.tieba.util.z(String.valueOf(com.baidu.tieba.data.g.f1032a) + "c/f/post/threadstore");
        this.c.a(PushConstants.EXTRA_USER_ID, TiebaApplication.C());
        this.c.a("offset", String.valueOf(this.e));
        this.c.a("rn", String.valueOf(20));
        this.d = this.c.j();
        this.f.a(this.d);
        if (this.c.c()) {
            hVar.a(this.d);
            if (this.e == 0 && this.f1447a.booleanValue()) {
                a(this.d);
            }
        }
        return hVar;
    }

    private void a(String str) {
        com.baidu.adp.lib.cache.q<String> g;
        String C = TiebaApplication.C();
        if (C != null && (g = com.baidu.tieba.b.a.a().g()) != null) {
            g.a(C, str, 604800000L);
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
            if (this.f1447a.booleanValue()) {
                this.b.a(b);
            } else {
                this.b.b(b);
            }
        }
        this.b.f1445a.a(0, null, true);
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
    public void a(h hVar) {
        this.b.b = null;
        this.b.f = hVar.d();
        ArrayList<MarkData> c = hVar.c();
        if (this.f1447a.booleanValue()) {
            this.b.a(c);
        } else {
            this.b.b(c);
        }
        Iterator<MarkData> it = c.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next().getNewCounts() > 0) {
                int i2 = i + 1;
                this.b.a(i2);
                i = i2;
            }
        }
        if (this.b.f1445a != null) {
            if (this.c.c()) {
                String b = this.f.b();
                TiebaApplication.g().a((Boolean) true);
                this.b.f1445a.a(0, b, false);
                return;
            }
            this.b.f1445a.a(3, this.c.g());
        }
    }
}
