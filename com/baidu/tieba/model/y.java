package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.util.DatabaseService;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends BdAsyncTask<Object, com.baidu.tieba.data.t, com.baidu.tieba.data.t> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ x f1937a;
    private com.baidu.tieba.util.ap b = null;
    private boolean c;
    private boolean d;
    private boolean e;

    public y(x xVar, Boolean bool, Boolean bool2, Boolean bool3) {
        this.f1937a = xVar;
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
        String i;
        boolean z;
        try {
            if (this.c) {
                if (this.e) {
                    i = DatabaseService.c();
                } else {
                    i = DatabaseService.i(SocialConstants.FALSE);
                }
                if (i == null || i.length() <= 0) {
                    z = false;
                    tVar2 = null;
                } else {
                    tVar2 = new com.baidu.tieba.data.t();
                    try {
                        tVar2.a(i);
                        if (!tVar2.a()) {
                            com.baidu.tieba.util.bg.a("Like_Recommend_AsyncTask", "doInBackground", "cache data format err");
                            if (this.e) {
                                DatabaseService.b();
                                z = false;
                                tVar2 = null;
                            } else {
                                DatabaseService.g(SocialConstants.FALSE);
                                z = false;
                                tVar2 = null;
                            }
                        } else {
                            c((Object[]) new com.baidu.tieba.data.t[]{tVar2});
                            com.baidu.tieba.util.bg.a("Like_Recommend_AsyncTask", "doInBackground", "cache data.size: " + String.valueOf(i.length()));
                            z = true;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        tVar = tVar2;
                        com.baidu.tieba.util.bg.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
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
            stringBuffer.append(com.baidu.tieba.data.h.f1201a);
            stringBuffer.append("c/f/forum/favocommend");
            ArrayList<BasicNameValuePair> arrayList = new ArrayList<>();
            arrayList.add(new BasicNameValuePair("ctime", String.valueOf(System.currentTimeMillis())));
            this.b = new com.baidu.tieba.util.ap(stringBuffer.toString());
            this.b.a(arrayList);
            String l = this.b.l();
            if (!this.b.c() || l == null) {
                tVar = null;
            } else {
                tVar = new com.baidu.tieba.data.t();
                try {
                    tVar.a(l);
                    if (tVar.a()) {
                        this.e = tVar.b() == 1;
                        if (this.e) {
                            DatabaseService.e(l);
                        } else {
                            DatabaseService.a(l, SocialConstants.FALSE);
                        }
                    } else {
                        tVar = null;
                    }
                } catch (Exception e4) {
                    e = e4;
                    com.baidu.tieba.util.bg.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
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
        com.baidu.adp.a.g gVar;
        this.f1937a.f1936a = tVarArr[0];
        this.f1937a.mLoadDataMode = 2;
        gVar = this.f1937a.mLoadDataCallBack;
        gVar.a(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.data.t tVar) {
        com.baidu.adp.a.g gVar;
        boolean z = true;
        this.f1937a.mLoadDataMode = 1;
        if (tVar == null) {
            z = false;
            if (this.b != null) {
                this.f1937a.mErrorString = this.b.i();
            }
        } else {
            this.f1937a.f1936a = tVar;
        }
        this.f1937a.b = null;
        gVar = this.f1937a.mLoadDataCallBack;
        gVar.a(Boolean.valueOf(z));
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.a.g gVar;
        if (this.b != null) {
            this.b.j();
            this.b = null;
        }
        this.f1937a.b = null;
        super.cancel(true);
        gVar = this.f1937a.mLoadDataCallBack;
        gVar.a(false);
    }
}
