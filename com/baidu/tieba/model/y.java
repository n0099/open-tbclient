package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.util.DatabaseService;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends BdAsyncTask<Object, com.baidu.tieba.data.u, com.baidu.tieba.data.u> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ x f1963a;
    private com.baidu.tieba.util.ag b = null;
    private boolean c;
    private boolean d;
    private boolean e;

    public y(x xVar, Boolean bool, Boolean bool2, Boolean bool3) {
        this.f1963a = xVar;
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
    public com.baidu.tieba.data.u a(Object... objArr) {
        com.baidu.tieba.data.u uVar;
        Exception e;
        com.baidu.tieba.data.u uVar2;
        String h;
        boolean z;
        try {
            if (this.c) {
                if (this.e) {
                    h = DatabaseService.c();
                } else {
                    h = DatabaseService.h(SocialConstants.FALSE);
                }
                if (h == null || h.length() <= 0) {
                    z = false;
                    uVar2 = null;
                } else {
                    uVar2 = new com.baidu.tieba.data.u();
                    try {
                        uVar2.a(h);
                        if (!uVar2.a()) {
                            com.baidu.tieba.util.be.a("Like_Recommend_AsyncTask", "doInBackground", "cache data format err");
                            if (this.e) {
                                DatabaseService.b();
                                z = false;
                                uVar2 = null;
                            } else {
                                DatabaseService.f(SocialConstants.FALSE);
                                z = false;
                                uVar2 = null;
                            }
                        } else {
                            c((Object[]) new com.baidu.tieba.data.u[]{uVar2});
                            com.baidu.tieba.util.be.a("Like_Recommend_AsyncTask", "doInBackground", "cache data.size: " + String.valueOf(h.length()));
                            z = true;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        uVar = uVar2;
                        com.baidu.tieba.util.be.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
                        return uVar;
                    }
                }
                if (!z) {
                    this.d = true;
                }
            } else {
                uVar2 = null;
            }
        } catch (Exception e3) {
            uVar = null;
            e = e3;
        }
        if (this.d) {
            StringBuffer stringBuffer = new StringBuffer(30);
            stringBuffer.append(com.baidu.tieba.data.h.f1165a);
            stringBuffer.append("c/f/forum/favocommend");
            ArrayList<BasicNameValuePair> arrayList = new ArrayList<>();
            arrayList.add(new BasicNameValuePair("ctime", String.valueOf(System.currentTimeMillis())));
            this.b = new com.baidu.tieba.util.ag(stringBuffer.toString());
            this.b.a(arrayList);
            String j = this.b.j();
            if (!this.b.c() || j == null) {
                uVar = null;
            } else {
                uVar = new com.baidu.tieba.data.u();
                try {
                    uVar.a(j);
                    if (uVar.a()) {
                        this.e = uVar.b() == 1;
                        if (this.e) {
                            DatabaseService.d(j);
                        } else {
                            DatabaseService.a(j, SocialConstants.FALSE);
                        }
                    } else {
                        uVar = null;
                    }
                } catch (Exception e4) {
                    e = e4;
                    com.baidu.tieba.util.be.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
                    return uVar;
                }
            }
            return uVar;
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void b(com.baidu.tieba.data.u... uVarArr) {
        com.baidu.adp.a.g gVar;
        this.f1963a.f1962a = uVarArr[0];
        this.f1963a.mLoadDataMode = 2;
        gVar = this.f1963a.mLoadDataCallBack;
        gVar.a(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.data.u uVar) {
        com.baidu.adp.a.g gVar;
        boolean z = true;
        this.f1963a.mLoadDataMode = 1;
        if (uVar == null) {
            z = false;
            if (this.b != null) {
                this.f1963a.mErrorString = this.b.g();
            }
        } else {
            this.f1963a.f1962a = uVar;
        }
        this.f1963a.b = null;
        gVar = this.f1963a.mLoadDataCallBack;
        gVar.a(Boolean.valueOf(z));
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.a.g gVar;
        if (this.b != null) {
            this.b.h();
            this.b = null;
        }
        this.f1963a.b = null;
        super.cancel(true);
        gVar = this.f1963a.mLoadDataCallBack;
        gVar.a(false);
    }
}
