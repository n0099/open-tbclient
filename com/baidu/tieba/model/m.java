package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.data.MarkData;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class m extends BdAsyncTask<Boolean, String, k> {
    final /* synthetic */ k b;
    private int e;
    private com.baidu.tieba.data.aq f;
    private com.baidu.tbadk.core.util.ak c = null;
    private String d = null;
    Boolean a = false;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(k kVar) {
        k kVar2 = kVar;
        this.b.b = null;
        this.b.f = kVar2.g();
        ArrayList<MarkData> f = kVar2.f();
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
            if (this.c.a().b().b()) {
                this.b.a.a(0, this.f.b(), false);
            } else {
                this.b.a.a(3, this.c.f());
            }
        }
        this.b.h = false;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void b(String... strArr) {
        String[] strArr2 = strArr;
        super.b((Object[]) strArr2);
        String str = strArr2[0];
        ArrayList<MarkData> arrayList = new ArrayList<>();
        if (str != null) {
            arrayList = this.b.a(str);
            if (!this.a.booleanValue()) {
                this.b.b(arrayList);
                this.b.a.a(0, null, true);
            }
        }
        this.b.a(arrayList);
        this.b.a.a(0, null, true);
    }

    public m(k kVar, int i) {
        this.b = kVar;
        this.e = 0;
        this.f = null;
        this.e = i;
        this.f = new com.baidu.tieba.data.aq();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void c() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public k a(Boolean... boolArr) {
        com.baidu.adp.lib.cache.s<String> l;
        ArrayList arrayList;
        ArrayList arrayList2;
        this.a = boolArr[0];
        k kVar = new k();
        if (this.a.booleanValue()) {
            com.baidu.adp.lib.cache.s<String> l2 = com.baidu.tbadk.core.c.b.a().l();
            if (l2 != null) {
                c((Object[]) new String[]{l2.a(TbadkApplication.E())});
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
        this.c = new com.baidu.tbadk.core.util.ak(String.valueOf(com.baidu.tbadk.core.data.n.a) + "c/f/post/threadstore");
        this.c.a("user_id", TbadkApplication.E());
        this.c.a("offset", String.valueOf(this.e));
        this.c.a("rn", String.valueOf(20));
        this.d = this.c.i();
        this.f.a(this.d);
        if (this.c.a().b().b()) {
            try {
                kVar.a(new JSONObject(this.d));
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b(kVar.getClass().getName(), "parserJson", e.toString());
            }
            if (this.e == 0 && this.a.booleanValue()) {
                String str = this.d;
                String E = TbadkApplication.E();
                if (E != null && (l = com.baidu.tbadk.core.c.b.a().l()) != null) {
                    l.a(E, str, 604800000L);
                }
            }
        }
        return kVar;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        super.cancel(true);
        if (this.c != null) {
            this.c.g();
        }
        this.b.b = null;
    }
}
