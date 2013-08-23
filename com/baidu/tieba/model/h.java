package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.MarkData;
import java.util.ArrayList;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends BdAsyncTask {
    final /* synthetic */ f b;
    private int e;
    private com.baidu.tieba.data.bg f;
    private com.baidu.tieba.util.v c = null;
    private String d = null;

    /* renamed from: a  reason: collision with root package name */
    Boolean f1406a = false;

    public h(f fVar, int i) {
        this.b = fVar;
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
    public f a(Boolean... boolArr) {
        ArrayList arrayList;
        ArrayList arrayList2;
        String str;
        this.f1406a = boolArr[0];
        f fVar = new f();
        if (this.f1406a.booleanValue()) {
            com.baidu.adp.lib.cache.q g = com.baidu.tieba.b.a.a().g();
            if (g != null && (str = (String) g.a(TiebaApplication.E())) != null) {
                c((Object[]) new String[]{str});
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
        this.c = new com.baidu.tieba.util.v(String.valueOf(com.baidu.tieba.data.g.f1014a) + "c/f/post/threadstore");
        this.c.a(PushConstants.EXTRA_USER_ID, TiebaApplication.E());
        this.c.a("offset", String.valueOf(this.e));
        this.c.a("rn", String.valueOf(20));
        this.d = this.c.j();
        this.f.a(this.d);
        if (this.c.c()) {
            fVar.a(this.d);
            if (this.e == 0 && this.f1406a.booleanValue()) {
                a(this.d);
            }
        }
        return fVar;
    }

    private void a(String str) {
        com.baidu.adp.lib.cache.q g;
        String E = TiebaApplication.E();
        if (E != null && (g = com.baidu.tieba.b.a.a().g()) != null) {
            g.a(E, str, 604800000L);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void b(String... strArr) {
        ArrayList b;
        super.b((Object[]) strArr);
        String str = strArr[0];
        b = this.b.b(str);
        if (str != null) {
            if (this.f1406a.booleanValue()) {
                this.b.a(b);
            } else {
                this.b.b(b);
            }
        }
        this.b.f1404a.a(0, null, true);
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
    public void a(f fVar) {
        this.b.b = null;
        this.b.f = fVar.d();
        ArrayList c = fVar.c();
        if (this.f1406a.booleanValue()) {
            this.b.a(c);
        } else {
            this.b.b(c);
        }
        Iterator it = c.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (((MarkData) it.next()).getNewCounts() > 0) {
                int i2 = i + 1;
                this.b.a(i2);
                i = i2;
            }
        }
        if (this.b.f1404a != null) {
            if (this.c.c()) {
                String b = this.f.b();
                TiebaApplication.g().a((Boolean) true);
                this.b.f1404a.a(0, b, false);
                return;
            }
            this.b.f1404a.a(3, this.c.g());
        }
    }
}
