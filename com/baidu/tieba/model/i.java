package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.MarkData;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class i extends BdAsyncTask<Boolean, String, g> {
    final /* synthetic */ g b;
    private int e;
    private com.baidu.tieba.data.ay f;
    private com.baidu.tieba.util.ba c = null;
    private String d = null;
    Boolean a = false;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(g gVar) {
        g gVar2 = gVar;
        this.b.b = null;
        this.b.f = gVar2.g();
        ArrayList<MarkData> f = gVar2.f();
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
            if (this.c.c()) {
                this.b.a.a(0, this.f.b(), false);
            } else {
                this.b.a.a(3, this.c.i());
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

    public i(g gVar, int i) {
        this.b = gVar;
        this.e = 0;
        this.f = null;
        this.e = i;
        this.f = new com.baidu.tieba.data.ay();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void b() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public g a(Boolean... boolArr) {
        com.baidu.adp.lib.cache.s<String> l;
        ArrayList arrayList;
        ArrayList arrayList2;
        this.a = boolArr[0];
        g gVar = new g();
        if (this.a.booleanValue()) {
            com.baidu.adp.lib.cache.s<String> l2 = com.baidu.tieba.c.a.a().l();
            if (l2 != null) {
                c((Object[]) new String[]{l2.a(TiebaApplication.v())});
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
        this.c.a(PushConstants.EXTRA_USER_ID, TiebaApplication.v());
        this.c.a("offset", String.valueOf(this.e));
        this.c.a("rn", String.valueOf(20));
        this.d = this.c.l();
        this.f.a(this.d);
        if (this.c.c()) {
            try {
                gVar.a(new JSONObject(this.d));
            } catch (Exception e) {
                com.baidu.adp.lib.util.e.b(gVar.getClass().getName(), "parserJson", e.toString());
            }
            if (this.e == 0 && this.a.booleanValue()) {
                String str = this.d;
                String v = TiebaApplication.v();
                if (v != null && (l = com.baidu.tieba.c.a.a().l()) != null) {
                    l.a(v, str, 604800000L);
                }
            }
        }
        return gVar;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        super.cancel(true);
        if (this.c != null) {
            this.c.j();
        }
        this.b.b = null;
    }
}
