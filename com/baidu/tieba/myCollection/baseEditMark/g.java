package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.util.aa;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends BdAsyncTask<Boolean, Integer, Boolean> {
    private aa Oi = null;
    private boolean aBi;
    private i bEo;
    final /* synthetic */ f bEx;

    public g(f fVar, boolean z) {
        this.bEx = fVar;
        this.aBi = true;
        this.bEo = null;
        this.aBi = z;
        this.bEo = new i();
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
        if (this.aBi) {
            this.Oi = new aa(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.MARK_ADDSTORE);
            a aVar = new a();
            markData3 = this.bEx.bEu;
            aVar.b(markData3);
            this.Oi.o("data", aVar.ad(0, 1));
        } else {
            this.Oi = new aa(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.MARK_DELSTORE);
            aa aaVar = this.Oi;
            markData = this.bEx.bEu;
            aaVar.o("user_id", markData.getAccount());
            aa aaVar2 = this.Oi;
            markData2 = this.bEx.bEu;
            aaVar2.o("tid", markData2.getId());
        }
        this.bEo.parserJson(this.Oi.rO());
        boolean z = this.bEo.getErrorCode() == 0;
        if (this.Oi.sp().tq().pv() && z) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.Oi != null) {
            this.Oi.hh();
        }
        this.bEx.bEv = null;
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
                bVar4 = this.bEx.bEw;
                if (bVar4 != null) {
                    bVar5 = this.bEx.bEw;
                    bVar5.a(true, this.aBi, null);
                }
            } else {
                bVar = this.bEx.bEw;
                if (bVar != null) {
                    if (this.Oi == null || this.Oi.sp().tq().pv()) {
                        bVar2 = this.bEx.bEw;
                        bVar2.a(false, this.aBi, this.bEo.getErrorString());
                    } else {
                        bVar3 = this.bEx.bEw;
                        bVar3.a(false, this.aBi, this.Oi.getErrorString());
                    }
                }
            }
            this.bEx.bEv = null;
        } catch (Throwable th) {
            BdLog.e(th.toString());
        }
    }
}
