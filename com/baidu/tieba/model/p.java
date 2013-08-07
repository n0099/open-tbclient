package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ o f1377a;
    private String b;
    private String c;
    private String d;
    private com.baidu.tieba.a.g e = null;

    public p(o oVar, String str, String str2, String str3) {
        this.f1377a = oVar;
        this.b = null;
        this.c = null;
        this.d = null;
        this.b = str;
        this.c = str2;
        this.d = str3;
        setSelfExecute(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public com.baidu.tieba.data.ac a(Object... objArr) {
        String e;
        com.baidu.adp.lib.cache.q bm;
        try {
            this.e = new com.baidu.tieba.a.g();
            String E = TiebaApplication.E();
            if ((E == null || E.length() == 0) && (e = aq.e()) != null && e.length() > 0) {
                this.e.a("tag_info", e);
            }
            String a2 = this.e.a(this.b, this.c, this.d);
            if (this.e.c()) {
                com.baidu.tieba.data.ac acVar = new com.baidu.tieba.data.ac();
                acVar.a(a2);
                if (this.d.equals("1") && (bm = TiebaApplication.f().bm()) != null && this.e.e() == 0) {
                    bm.a("home_interest", a2, 100000000L);
                    return acVar;
                }
                return acVar;
            }
        } catch (Exception e2) {
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.data.ac acVar) {
        com.baidu.adp.a.e eVar;
        com.baidu.tieba.data.ac acVar2;
        int i;
        int i2;
        com.baidu.tieba.data.ac acVar3;
        com.baidu.tieba.data.ac acVar4;
        com.baidu.adp.a.e eVar2;
        this.f1377a.setErrorCode(this.e.e());
        this.f1377a.setErrorString(this.e.f());
        if (acVar == null) {
            eVar2 = this.f1377a.mLoadDataCallBack;
            eVar2.a(null);
        } else {
            try {
                i = this.f1377a.f1376a;
                if (i != 1) {
                    i2 = this.f1377a.f1376a;
                    if (i2 == 2) {
                        acVar3 = this.f1377a.f;
                        if (acVar3 == null) {
                            this.f1377a.f = acVar;
                        } else {
                            acVar4 = this.f1377a.f;
                            acVar4.a(acVar, true);
                        }
                    }
                } else {
                    this.f1377a.f = acVar;
                }
            } catch (Exception e) {
            }
            eVar = this.f1377a.mLoadDataCallBack;
            acVar2 = this.f1377a.f;
            eVar.a(acVar2);
        }
        this.e.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void c() {
        super.c();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.e != null) {
            this.e.a();
        }
    }
}
