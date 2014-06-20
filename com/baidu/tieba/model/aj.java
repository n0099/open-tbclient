package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.data.MarkData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj extends BdAsyncTask<Boolean, Integer, Boolean> {
    final /* synthetic */ ai a;
    private com.baidu.tbadk.core.util.an b = null;
    private boolean c;
    private com.baidu.tieba.data.as d;

    public aj(ai aiVar, boolean z) {
        this.a = aiVar;
        this.c = true;
        this.d = null;
        this.c = z;
        this.d = new com.baidu.tieba.data.as();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public Boolean doInBackground(Boolean... boolArr) {
        MarkData markData;
        MarkData markData2;
        MarkData markData3;
        if (this.c) {
            this.b = new com.baidu.tbadk.core.util.an(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/post/addstore");
            k kVar = new k();
            markData3 = this.a.b;
            kVar.a(markData3);
            this.b.a("data", kVar.a(0, 1));
        } else {
            this.b = new com.baidu.tbadk.core.util.an(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/post/rmstore");
            com.baidu.tbadk.core.util.an anVar = this.b;
            markData = this.a.b;
            anVar.a(com.baidu.tbadk.core.frameworkData.a.USER_ID, markData.getAccount());
            com.baidu.tbadk.core.util.an anVar2 = this.b;
            markData2 = this.a.b;
            anVar2.a("tid", markData2.getId());
        }
        this.d.a(this.b.i());
        boolean z = this.d.a() == 0;
        if (this.b.a().b().b() && z) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.g();
        }
        this.a.c = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(Boolean bool) {
        ak akVar;
        ak akVar2;
        ak akVar3;
        ak akVar4;
        ak akVar5;
        try {
            if (bool.booleanValue()) {
                akVar4 = this.a.d;
                if (akVar4 != null) {
                    akVar5 = this.a.d;
                    akVar5.a(true, this.c, null);
                }
            } else {
                akVar = this.a.d;
                if (akVar != null) {
                    if (this.b == null || this.b.a().b().b()) {
                        akVar2 = this.a.d;
                        akVar2.a(false, this.c, this.d.b());
                    } else {
                        akVar3 = this.a.d;
                        akVar3.a(false, this.c, this.b.f());
                    }
                }
            }
            this.a.c = null;
        } catch (Throwable th) {
            BdLog.e(th.toString());
        }
    }
}
