package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.util.DatabaseService;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends BdAsyncTask<Object, com.baidu.tieba.data.t, com.baidu.tieba.data.t> {
    final /* synthetic */ x a;
    private com.baidu.tieba.util.ax b = null;
    private boolean c;
    private boolean d;
    private boolean e;
    private String f;

    public y(x xVar, Boolean bool, Boolean bool2, Boolean bool3, String str) {
        this.a = xVar;
        this.c = false;
        this.d = false;
        this.e = true;
        this.f = null;
        this.c = bool.booleanValue();
        this.d = bool2.booleanValue();
        this.e = bool3.booleanValue();
        this.f = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00eb A[ADDED_TO_REGION] */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.baidu.tieba.data.t a(Object... objArr) {
        com.baidu.tieba.data.t tVar;
        Exception e;
        com.baidu.tieba.data.t tVar2;
        String g;
        boolean z;
        try {
            if (this.c) {
                if (this.e) {
                    g = DatabaseService.c();
                } else {
                    g = DatabaseService.g(SocialConstants.FALSE);
                }
                if (g == null || g.length() <= 0) {
                    z = false;
                    tVar2 = null;
                } else {
                    tVar2 = new com.baidu.tieba.data.t();
                    try {
                        tVar2.a(g);
                        if (!tVar2.a()) {
                            com.baidu.adp.lib.g.e.a("Like_Recommend_AsyncTask", "doInBackground", "cache data format err");
                            if (this.e) {
                                DatabaseService.b();
                                z = false;
                                tVar2 = null;
                            } else {
                                DatabaseService.e(SocialConstants.FALSE);
                                z = false;
                                tVar2 = null;
                            }
                        } else {
                            c((Object[]) new com.baidu.tieba.data.t[]{tVar2});
                            com.baidu.adp.lib.g.e.a("Like_Recommend_AsyncTask", "doInBackground", "cache data.size: " + String.valueOf(g.length()));
                            z = true;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        tVar = tVar2;
                        com.baidu.adp.lib.g.e.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
                        if (this.a.getLoadDataMode() == 1) {
                            z.a().b(this.f);
                        }
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
            stringBuffer.append(com.baidu.tieba.data.h.a);
            stringBuffer.append("c/f/forum/favocommend");
            ArrayList<BasicNameValuePair> arrayList = new ArrayList<>();
            arrayList.add(new BasicNameValuePair("ctime", String.valueOf(System.currentTimeMillis())));
            this.b = new com.baidu.tieba.util.ax(stringBuffer.toString());
            this.b.a(arrayList);
            String m = this.b.m();
            if (!this.b.d() || m == null) {
                tVar = null;
            } else {
                tVar = new com.baidu.tieba.data.t();
                try {
                    tVar.a(m);
                    if (tVar.a()) {
                        this.e = tVar.b() == 1;
                        if (this.e) {
                            DatabaseService.c(m);
                        } else {
                            DatabaseService.a(m, SocialConstants.FALSE);
                        }
                    } else {
                        tVar = null;
                    }
                } catch (Exception e4) {
                    e = e4;
                    com.baidu.adp.lib.g.e.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
                    if (this.a.getLoadDataMode() == 1) {
                    }
                    return tVar;
                }
            }
            if (this.a.getLoadDataMode() == 1 && tVar != null) {
                z.a().b(this.f);
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
        this.a.a = tVarArr[0];
        this.a.mLoadDataMode = 2;
        gVar = this.a.mLoadDataCallBack;
        gVar.a(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.data.t tVar) {
        com.baidu.adp.a.g gVar;
        boolean z = true;
        this.a.mLoadDataMode = 1;
        if (tVar == null) {
            z = false;
            if (this.b != null) {
                this.a.mErrorString = this.b.j();
            }
        } else {
            this.a.a = tVar;
        }
        this.a.b = null;
        gVar = this.a.mLoadDataCallBack;
        gVar.a(Boolean.valueOf(z));
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.a.g gVar;
        if (this.b != null) {
            this.b.k();
            this.b = null;
        }
        this.a.b = null;
        super.cancel(true);
        gVar = this.a.mLoadDataCallBack;
        gVar.a(false);
    }
}
