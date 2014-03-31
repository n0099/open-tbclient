package com.baidu.tieba.recommend;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class z extends BdAsyncTask<String, Integer, com.baidu.tieba.data.k> {
    final /* synthetic */ y a;
    private com.baidu.tieba.b.e b;
    private int c;
    private String d;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ com.baidu.tieba.data.k a(String... strArr) {
        String str;
        String a;
        switch (this.c) {
            case 0:
            case 2:
                this.b = new com.baidu.tieba.b.e(this.c == 0);
                com.baidu.tieba.b.e eVar = this.b;
                String str2 = this.d;
                str = this.a.g;
                a = eVar.a(str2, str);
                break;
            case 1:
                com.baidu.adp.lib.cache.s<String> K = com.baidu.tieba.r.c().K();
                if (K != null) {
                    a = K.a("dailyrecommend");
                    break;
                }
            default:
                a = null;
                break;
        }
        if (a != null) {
            if (this.c == 1 || this.b == null || !this.b.b()) {
                if (this.c == 1) {
                    return a(a);
                }
            } else if (this.b.c() == 0) {
                if (this.c == 0) {
                    y.a(this.a, a);
                }
                return a(a);
            }
        }
        return null;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(com.baidu.tieba.data.k kVar) {
        aa aaVar;
        aa aaVar2;
        com.baidu.tieba.data.k kVar2;
        aa aaVar3;
        com.baidu.tieba.data.k kVar3;
        boolean z;
        com.baidu.tieba.data.k kVar4;
        aa aaVar4;
        aa aaVar5;
        com.baidu.tieba.data.k kVar5;
        com.baidu.tieba.data.k kVar6 = kVar;
        super.a((z) kVar6);
        if (kVar6 != null) {
            if (this.c == 1) {
                this.a.c = kVar6;
                this.a.f = true;
            } else {
                z = this.a.f;
                if (z) {
                    this.a.c = new com.baidu.tieba.data.k();
                    this.a.f = false;
                }
                if (this.c == 0) {
                    this.a.c = kVar6;
                } else {
                    kVar4 = this.a.c;
                    kVar4.a(kVar6);
                }
            }
            aaVar4 = this.a.b;
            if (aaVar4 != null) {
                aaVar5 = this.a.b;
                kVar5 = this.a.c;
                aaVar5.a(true, null, kVar5, this.c);
                return;
            }
            return;
        }
        aaVar = this.a.b;
        if (aaVar != null) {
            if (this.c != 1) {
                aaVar3 = this.a.b;
                String sb = new StringBuilder(String.valueOf(this.b.c())).toString();
                kVar3 = this.a.c;
                aaVar3.a(false, sb, kVar3, this.c);
                return;
            }
            aaVar2 = this.a.b;
            kVar2 = this.a.c;
            aaVar2.a(false, "db no data!", kVar2, this.c);
        }
    }

    public z(y yVar, int i, String str) {
        this.a = yVar;
        this.c = i;
        this.d = str;
        setPriority(3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void c() {
        aa aaVar;
        aa unused;
        super.c();
        aaVar = this.a.b;
        if (aaVar != null) {
            unused = this.a.b;
        }
    }

    private com.baidu.tieba.data.k a(String str) {
        com.baidu.tieba.data.k kVar = new com.baidu.tieba.data.k();
        try {
            kVar.a(new JSONObject(str));
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(kVar.getClass().getName(), "parserJson", e.toString());
        }
        if (this.c == 0 && kVar.b().size() > 0) {
            kVar.b().get(0).a(true);
        }
        return kVar;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.a();
            this.b = null;
        }
    }
}
