package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.util.DatabaseService;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ m f1058a;
    private com.baidu.tieba.util.r b = null;
    private boolean c;
    private boolean d;
    private boolean e;

    public n(m mVar, Boolean bool, Boolean bool2, Boolean bool3) {
        this.f1058a = mVar;
        this.c = false;
        this.d = false;
        this.e = true;
        this.c = bool.booleanValue();
        this.d = bool2.booleanValue();
        this.e = bool3.booleanValue();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public com.baidu.tieba.data.p a(Object... objArr) {
        com.baidu.tieba.data.p pVar;
        Exception e;
        com.baidu.tieba.data.p pVar2;
        String h;
        boolean z;
        try {
            if (this.c) {
                if (this.e) {
                    h = DatabaseService.d();
                } else {
                    h = DatabaseService.h("0");
                }
                if (h == null || h.length() <= 0) {
                    z = false;
                    pVar2 = null;
                } else {
                    pVar2 = new com.baidu.tieba.data.p();
                    try {
                        pVar2.a(h);
                        if (!pVar2.a()) {
                            com.baidu.tieba.util.z.a("Like_Recommend_AsyncTask", "doInBackground", "cache data format err");
                            if (this.e) {
                                DatabaseService.b();
                                z = false;
                                pVar2 = null;
                            } else {
                                DatabaseService.f("0");
                                z = false;
                                pVar2 = null;
                            }
                        } else {
                            c(pVar2);
                            com.baidu.tieba.util.z.a("Like_Recommend_AsyncTask", "doInBackground", "cache data.size: " + String.valueOf(h.length()));
                            z = true;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        pVar = pVar2;
                        com.baidu.tieba.util.z.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
                        return pVar;
                    }
                }
                if (!z) {
                    this.d = true;
                }
            } else {
                pVar2 = null;
            }
        } catch (Exception e3) {
            pVar = null;
            e = e3;
        }
        if (this.d) {
            StringBuffer stringBuffer = new StringBuffer(30);
            stringBuffer.append(com.baidu.tieba.data.g.f787a);
            stringBuffer.append("c/f/forum/favocommend");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new BasicNameValuePair("ctime", String.valueOf(System.currentTimeMillis())));
            this.b = new com.baidu.tieba.util.r(stringBuffer.toString());
            this.b.a(arrayList);
            String j = this.b.j();
            if (!this.b.c() || j == null) {
                pVar = null;
            } else {
                pVar = new com.baidu.tieba.data.p();
                try {
                    pVar.a(j);
                    if (pVar.a()) {
                        this.e = pVar.b() == 1;
                        if (this.e) {
                            DatabaseService.d(j);
                        } else {
                            DatabaseService.a(j, "0");
                        }
                    } else {
                        pVar = null;
                    }
                } catch (Exception e4) {
                    e = e4;
                    com.baidu.tieba.util.z.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
                    return pVar;
                }
            }
            return pVar;
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void b(com.baidu.tieba.data.p... pVarArr) {
        com.baidu.adp.a.e eVar;
        this.f1058a.f1057a = pVarArr[0];
        this.f1058a.mLoadDataMode = 2;
        eVar = this.f1058a.mLoadDataCallBack;
        eVar.a(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.data.p pVar) {
        com.baidu.adp.a.e eVar;
        boolean z = true;
        this.f1058a.mLoadDataMode = 1;
        if (pVar == null) {
            z = false;
            if (this.b != null) {
                this.f1058a.mErrorString = this.b.g();
            }
        } else {
            this.f1058a.f1057a = pVar;
        }
        this.f1058a.b = null;
        eVar = this.f1058a.mLoadDataCallBack;
        eVar.a(Boolean.valueOf(z));
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.a.e eVar;
        if (this.b != null) {
            this.b.h();
            this.b = null;
        }
        this.f1058a.b = null;
        super.cancel(true);
        eVar = this.f1058a.mLoadDataCallBack;
        eVar.a(false);
    }
}
