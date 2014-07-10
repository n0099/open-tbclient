package com.baidu.tieba.signall;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.ai;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends BdAsyncTask<String, Integer, o> {
    final /* synthetic */ q a;
    private f b = null;

    public s(q qVar) {
        this.a = qVar;
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
    public o doInBackground(String... strArr) {
        o oVar;
        this.b = new f();
        if (UtilHelper.getNetStatusInfo(ai.c().d().getApplicationContext()) != UtilHelper.NetworkStateInfo.UNAVAIL) {
            this.a.c = a(strArr[0]);
            oVar = this.a.c;
            return oVar;
        }
        return null;
    }

    private o a(String str) {
        String a = this.b.a(str);
        if (this.b.b()) {
            o oVar = new o();
            oVar.a(a);
            return oVar;
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
    public void onPostExecute(o oVar) {
        r rVar;
        o oVar2;
        r rVar2;
        r rVar3;
        o oVar3;
        this.a.a = false;
        this.a.b = null;
        rVar = this.a.d;
        if (rVar != null) {
            oVar2 = this.a.c;
            if (oVar2 != null) {
                rVar3 = this.a.d;
                oVar3 = this.a.c;
                rVar3.a(oVar3);
                return;
            }
            String c = this.b != null ? this.b.c() : null;
            rVar2 = this.a.d;
            rVar2.a(c);
        }
    }
}
