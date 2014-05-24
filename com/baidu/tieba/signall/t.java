package com.baidu.tieba.signall;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.ai;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends BdAsyncTask<String, Integer, p> {
    final /* synthetic */ r a;
    private f b = null;

    public t(r rVar) {
        this.a = rVar;
        setPriority(3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        super.onPreExecute();
        this.a.a = true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public p doInBackground(String... strArr) {
        p pVar;
        this.b = new f();
        if (UtilHelper.getNetStatusInfo(ai.c().d().getApplicationContext()) != UtilHelper.NetworkStateInfo.UNAVAIL) {
            this.a.c = a(strArr[0]);
            pVar = this.a.c;
            return pVar;
        }
        return null;
    }

    private p a(String str) {
        String a = this.b.a(str);
        if (this.b.b()) {
            p pVar = new p();
            pVar.a(a);
            return pVar;
        }
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel();
        this.b.a();
        this.b = null;
        this.a.b = null;
        this.a.a = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(p pVar) {
        s sVar;
        p pVar2;
        s sVar2;
        s sVar3;
        p pVar3;
        this.a.a = false;
        this.a.b = null;
        sVar = this.a.d;
        if (sVar != null) {
            pVar2 = this.a.c;
            if (pVar2 != null) {
                sVar3 = this.a.d;
                pVar3 = this.a.c;
                sVar3.a(pVar3);
                return;
            }
            String c = this.b != null ? this.b.c() : null;
            sVar2 = this.a.d;
            sVar2.a(c);
        }
    }
}
