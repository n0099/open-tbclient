package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.MarkData;
import java.util.ArrayList;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends BdAsyncTask<Boolean, String, g> {
    final /* synthetic */ g b;
    private int e;
    private com.baidu.tieba.data.ay f;
    private com.baidu.tieba.util.ba c = null;
    private String d = null;
    Boolean a = false;

    public i(g gVar, int i) {
        this.b = gVar;
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
    public g a(Boolean... boolArr) {
        ArrayList arrayList;
        ArrayList arrayList2;
        this.a = boolArr[0];
        g gVar = new g();
        if (this.a.booleanValue()) {
            com.baidu.adp.lib.cache.s<String> l = com.baidu.tieba.c.a.a().l();
            if (l != null) {
                c((Object[]) new String[]{l.a(TiebaApplication.A())});
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
        this.c = new com.baidu.tieba.util.ba(String.valueOf(com.baidu.tieba.data.i.a) + "c/f/post/threadstore");
        this.c.a(PushConstants.EXTRA_USER_ID, TiebaApplication.A());
        this.c.a("offset", String.valueOf(this.e));
        this.c.a("rn", String.valueOf(20));
        this.d = this.c.m();
        this.f.a(this.d);
        if (this.c.d()) {
            gVar.a(this.d);
            if (this.e == 0 && this.a.booleanValue()) {
                a(this.d);
            }
        }
        return gVar;
    }

    private void a(String str) {
        com.baidu.adp.lib.cache.s<String> l;
        String A = TiebaApplication.A();
        if (A != null && (l = com.baidu.tieba.c.a.a().l()) != null) {
            l.a(A, str, 604800000L);
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
            if (this.a.booleanValue()) {
                this.b.a(b);
            } else {
                this.b.b(b);
            }
        } else {
            this.b.a(arrayList);
        }
        this.b.a.a(0, null, true);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.c != null) {
            this.c.k();
        }
        this.b.b = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(g gVar) {
        this.b.b = null;
        this.b.f = gVar.g();
        ArrayList<MarkData> f = gVar.f();
        if (this.a.booleanValue()) {
            this.b.a(f);
        } else {
            this.b.b(f);
        }
        Iterator<MarkData> it = f.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next().getNewCounts() > 0) {
                int i2 = i + 1;
                this.b.a(i2);
                i = i2;
            }
        }
        if (this.b.a != null) {
            if (this.c.d()) {
                this.b.a.a(0, this.f.b(), false);
            } else {
                this.b.a.a(3, this.c.j());
            }
        }
        this.b.h = false;
    }
}
