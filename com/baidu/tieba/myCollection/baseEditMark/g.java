package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.util.aa;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends BdAsyncTask<Boolean, Integer, Boolean> {
    private aa Ok = null;
    private boolean aBq;
    private i bEB;
    final /* synthetic */ f bEK;

    public g(f fVar, boolean z) {
        this.bEK = fVar;
        this.aBq = true;
        this.bEB = null;
        this.aBq = z;
        this.bEB = new i();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public Boolean doInBackground(Boolean... boolArr) {
        MarkData markData;
        MarkData markData2;
        MarkData markData3;
        if (this.aBq) {
            this.Ok = new aa(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.MARK_ADDSTORE);
            a aVar = new a();
            markData3 = this.bEK.bEH;
            aVar.b(markData3);
            this.Ok.o("data", aVar.ad(0, 1));
        } else {
            this.Ok = new aa(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.MARK_DELSTORE);
            aa aaVar = this.Ok;
            markData = this.bEK.bEH;
            aaVar.o("user_id", markData.getAccount());
            aa aaVar2 = this.Ok;
            markData2 = this.bEK.bEH;
            aaVar2.o("tid", markData2.getId());
        }
        this.bEB.parserJson(this.Ok.rO());
        boolean z = this.bEB.getErrorCode() == 0;
        if (this.Ok.sp().tq().pv() && z) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.Ok != null) {
            this.Ok.hh();
        }
        this.bEK.bEI = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public void onPostExecute(Boolean bool) {
        com.baidu.tbadk.baseEditMark.b bVar;
        com.baidu.tbadk.baseEditMark.b bVar2;
        com.baidu.tbadk.baseEditMark.b bVar3;
        com.baidu.tbadk.baseEditMark.b bVar4;
        com.baidu.tbadk.baseEditMark.b bVar5;
        try {
            if (bool.booleanValue()) {
                bVar4 = this.bEK.bEJ;
                if (bVar4 != null) {
                    bVar5 = this.bEK.bEJ;
                    bVar5.a(true, this.aBq, null);
                }
            } else {
                bVar = this.bEK.bEJ;
                if (bVar != null) {
                    if (this.Ok == null || this.Ok.sp().tq().pv()) {
                        bVar2 = this.bEK.bEJ;
                        bVar2.a(false, this.aBq, this.bEB.getErrorString());
                    } else {
                        bVar3 = this.bEK.bEJ;
                        bVar3.a(false, this.aBq, this.Ok.getErrorString());
                    }
                }
            }
            this.bEK.bEI = null;
        } catch (Throwable th) {
            BdLog.e(th.toString());
        }
    }
}
