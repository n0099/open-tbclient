package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends BdAsyncTask<j, Integer, Boolean> {
    final /* synthetic */ j a;
    private com.baidu.tbadk.core.util.ae b;
    private com.baidu.tieba.data.ax c;

    private m(j jVar) {
        this.a = jVar;
        this.b = null;
        this.c = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ m(j jVar, m mVar) {
        this(jVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        this.c = new com.baidu.tieba.data.ax();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public Boolean doInBackground(j... jVarArr) {
        j jVar = new j();
        try {
            jVar.i();
            this.b = new com.baidu.tbadk.core.util.ae();
            this.b.a(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/post/addstore");
            int k = this.a.k();
            if (jVar.g() - 1 <= k) {
                k = jVar.g() - 1;
            }
            while (k >= 0) {
                String a = jVar.a(k, 20);
                this.b.a(new ArrayList<>());
                this.b.a("data", a);
                this.c.a(this.b.h());
                if (!this.b.a().b().b() || this.c.a() != 0) {
                    break;
                }
                k -= 20;
            }
            this.a.c(k);
            if (k >= 0) {
                return false;
            }
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.f();
        }
        this.a.c = null;
        if (this.a.a != null) {
            this.a.a.callback(1, false, null, false);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(Boolean bool) {
        String str;
        boolean z;
        ArrayList arrayList;
        this.a.c = null;
        if (bool.booleanValue()) {
            arrayList = this.a.e;
            arrayList.clear();
            str = null;
            z = false;
        } else if (this.b.a().b().b()) {
            str = this.c.b();
            z = false;
        } else {
            str = null;
            z = true;
        }
        if (this.a.a != null) {
            this.a.a.callback(1, bool, str, Boolean.valueOf(z));
        }
    }
}
