package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.util.DatabaseService;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ m f1375a;
    private com.baidu.tieba.util.u b = null;
    private boolean c;
    private boolean d;
    private boolean e;

    public n(m mVar, Boolean bool, Boolean bool2, Boolean bool3) {
        this.f1375a = mVar;
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
    public com.baidu.tieba.data.t a(Object... objArr) {
        com.baidu.tieba.data.t tVar;
        Exception e;
        com.baidu.tieba.data.t tVar2;
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
                    tVar2 = null;
                } else {
                    tVar2 = new com.baidu.tieba.data.t();
                    try {
                        tVar2.a(h);
                        if (!tVar2.a()) {
                            com.baidu.tieba.util.aj.a("Like_Recommend_AsyncTask", "doInBackground", "cache data format err");
                            if (this.e) {
                                DatabaseService.b();
                                z = false;
                                tVar2 = null;
                            } else {
                                DatabaseService.f("0");
                                z = false;
                                tVar2 = null;
                            }
                        } else {
                            c(tVar2);
                            com.baidu.tieba.util.aj.a("Like_Recommend_AsyncTask", "doInBackground", "cache data.size: " + String.valueOf(h.length()));
                            z = true;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        tVar = tVar2;
                        com.baidu.tieba.util.aj.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
                        return tVar;
                    }
                }
                if (!z) {
                    this.d = true;
                }
            } else {
                tVar2 = null;
            }
        } catch (Exception e3) {
            tVar = null;
            e = e3;
        }
        if (this.d) {
            StringBuffer stringBuffer = new StringBuffer(30);
            stringBuffer.append(com.baidu.tieba.data.g.f1011a);
            stringBuffer.append("c/f/forum/favocommend");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new BasicNameValuePair("ctime", String.valueOf(System.currentTimeMillis())));
            this.b = new com.baidu.tieba.util.u(stringBuffer.toString());
            this.b.a(arrayList);
            String k = this.b.k();
            if (!this.b.d() || k == null) {
                tVar = null;
            } else {
                tVar = new com.baidu.tieba.data.t();
                try {
                    tVar.a(k);
                    if (tVar.a()) {
                        this.e = tVar.b() == 1;
                        if (this.e) {
                            DatabaseService.d(k);
                        } else {
                            DatabaseService.a(k, "0");
                        }
                    } else {
                        tVar = null;
                    }
                } catch (Exception e4) {
                    e = e4;
                    com.baidu.tieba.util.aj.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
                    return tVar;
                }
            }
            return tVar;
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void b(com.baidu.tieba.data.t... tVarArr) {
        com.baidu.adp.a.e eVar;
        this.f1375a.f1374a = tVarArr[0];
        this.f1375a.mLoadDataMode = 2;
        eVar = this.f1375a.mLoadDataCallBack;
        eVar.a(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.data.t tVar) {
        com.baidu.adp.a.e eVar;
        boolean z = true;
        this.f1375a.mLoadDataMode = 1;
        if (tVar == null) {
            z = false;
            if (this.b != null) {
                this.f1375a.mErrorString = this.b.h();
            }
        } else {
            this.f1375a.f1374a = tVar;
        }
        this.f1375a.b = null;
        eVar = this.f1375a.mLoadDataCallBack;
        eVar.a(Boolean.valueOf(z));
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.a.e eVar;
        if (this.b != null) {
            this.b.i();
            this.b = null;
        }
        this.f1375a.b = null;
        super.cancel(true);
        eVar = this.f1375a.mLoadDataCallBack;
        eVar.a(false);
    }
}
