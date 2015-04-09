package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.aa;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends BdAsyncTask<a, Integer, Boolean> {
    private aa Ok;
    private i bEB;
    final /* synthetic */ a bEC;

    private d(a aVar) {
        this.bEC = aVar;
        this.Ok = null;
        this.bEB = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ d(a aVar, d dVar) {
        this(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        this.bEB = new i();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public Boolean doInBackground(a... aVarArr) {
        a aVar = new a();
        try {
            aVar.Yl();
            this.Ok = new aa();
            this.Ok.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.MARK_ADDSTORE);
            int Ym = this.bEC.Ym();
            if (aVar.getCount() - 1 <= Ym) {
                Ym = aVar.getCount() - 1;
            }
            while (Ym >= 0) {
                String ad = aVar.ad(Ym, 20);
                this.Ok.o(new ArrayList<>());
                this.Ok.o("data", ad);
                this.bEB.parserJson(this.Ok.rO());
                if (!this.Ok.sp().tq().pv() || this.bEB.getErrorCode() != 0) {
                    break;
                }
                Ym -= 20;
            }
            this.bEC.hb(Ym);
            if (Ym >= 0) {
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
        if (this.Ok != null) {
            this.Ok.hh();
        }
        this.bEC.bEu = null;
        if (this.bEC.bEA != null) {
            this.bEC.bEA.callback(1, false, null, false);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public void onPostExecute(Boolean bool) {
        String str;
        boolean z;
        ArrayList arrayList;
        this.bEC.bEu = null;
        if (bool.booleanValue()) {
            arrayList = this.bEC.bEw;
            arrayList.clear();
            str = null;
            z = false;
        } else if (this.Ok.sp().tq().pv()) {
            str = this.bEB.getErrorString();
            z = false;
        } else {
            str = null;
            z = true;
        }
        if (this.bEC.bEA != null) {
            this.bEC.bEA.callback(1, bool, str, Boolean.valueOf(z));
        }
    }
}
