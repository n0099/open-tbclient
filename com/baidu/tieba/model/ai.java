package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.data.MarkData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai extends BdAsyncTask<Boolean, Integer, Boolean> {
    final /* synthetic */ ah a;
    private com.baidu.tbadk.core.util.aq b = null;
    private boolean c;
    private com.baidu.tieba.data.av d;

    public ai(ah ahVar, boolean z) {
        this.a = ahVar;
        this.c = true;
        this.d = null;
        this.c = z;
        this.d = new com.baidu.tieba.data.av();
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
            this.b = new com.baidu.tbadk.core.util.aq(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/post/addstore");
            i iVar = new i();
            markData3 = this.a.b;
            iVar.a(markData3);
            this.b.a("data", iVar.a(0, 1));
        } else {
            this.b = new com.baidu.tbadk.core.util.aq(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/post/rmstore");
            com.baidu.tbadk.core.util.aq aqVar = this.b;
            markData = this.a.b;
            aqVar.a(com.baidu.tbadk.core.frameworkData.a.USER_ID, markData.getAccount());
            com.baidu.tbadk.core.util.aq aqVar2 = this.b;
            markData2 = this.a.b;
            aqVar2.a("tid", markData2.getId());
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
        aj ajVar;
        aj ajVar2;
        aj ajVar3;
        aj ajVar4;
        aj ajVar5;
        try {
            if (bool.booleanValue()) {
                ajVar4 = this.a.d;
                if (ajVar4 != null) {
                    ajVar5 = this.a.d;
                    ajVar5.a(true, this.c, null);
                }
            } else {
                ajVar = this.a.d;
                if (ajVar != null) {
                    if (this.b == null || this.b.a().b().b()) {
                        ajVar2 = this.a.d;
                        ajVar2.a(false, this.c, this.d.b());
                    } else {
                        ajVar3 = this.a.d;
                        ajVar3.a(false, this.c, this.b.f());
                    }
                }
            }
            this.a.c = null;
        } catch (Throwable th) {
            BdLog.e(th.toString());
        }
    }
}
