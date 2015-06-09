package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.util.aa;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends BdAsyncTask<Boolean, Integer, Boolean> {
    private aa OE = null;
    private boolean aDe;
    final /* synthetic */ f bHG;
    private i bHx;

    public g(f fVar, boolean z) {
        this.bHG = fVar;
        this.aDe = true;
        this.bHx = null;
        this.aDe = z;
        this.bHx = new i();
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
        if (this.aDe) {
            this.OE = new aa(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.MARK_ADDSTORE);
            a aVar = new a();
            markData3 = this.bHG.bHD;
            aVar.b(markData3);
            this.OE.o("data", aVar.af(0, 1));
        } else {
            this.OE = new aa(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.MARK_DELSTORE);
            aa aaVar = this.OE;
            markData = this.bHG.bHD;
            aaVar.o("user_id", markData.getAccount());
            aa aaVar2 = this.OE;
            markData2 = this.bHG.bHD;
            aaVar2.o("tid", markData2.getId());
        }
        this.bHx.parserJson(this.OE.sw());
        boolean z = this.bHx.getErrorCode() == 0;
        if (this.OE.sX().tT().qa() && z) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.OE != null) {
            this.OE.gS();
        }
        this.bHG.bHE = null;
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
                bVar4 = this.bHG.bHF;
                if (bVar4 != null) {
                    bVar5 = this.bHG.bHF;
                    bVar5.a(true, this.aDe, null);
                }
            } else {
                bVar = this.bHG.bHF;
                if (bVar != null) {
                    if (this.OE == null || this.OE.sX().tT().qa()) {
                        bVar2 = this.bHG.bHF;
                        bVar2.a(false, this.aDe, this.bHx.getErrorString());
                    } else {
                        bVar3 = this.bHG.bHF;
                        bVar3.a(false, this.aDe, this.OE.getErrorString());
                    }
                }
            }
            this.bHG.bHE = null;
        } catch (Throwable th) {
            BdLog.e(th.toString());
        }
    }
}
