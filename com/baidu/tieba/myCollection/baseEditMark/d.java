package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.aa;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends BdAsyncTask<a, Integer, Boolean> {
    private aa Oi;
    private i bEo;
    final /* synthetic */ a bEp;

    private d(a aVar) {
        this.bEp = aVar;
        this.Oi = null;
        this.bEo = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ d(a aVar, d dVar) {
        this(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        this.bEo = new i();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public Boolean doInBackground(a... aVarArr) {
        a aVar = new a();
        try {
            aVar.XZ();
            this.Oi = new aa();
            this.Oi.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.MARK_ADDSTORE);
            int Ya = this.bEp.Ya();
            if (aVar.getCount() - 1 <= Ya) {
                Ya = aVar.getCount() - 1;
            }
            while (Ya >= 0) {
                String ad = aVar.ad(Ya, 20);
                this.Oi.o(new ArrayList<>());
                this.Oi.o("data", ad);
                this.bEo.parserJson(this.Oi.rO());
                if (!this.Oi.sp().tq().pv() || this.bEo.getErrorCode() != 0) {
                    break;
                }
                Ya -= 20;
            }
            this.bEp.gZ(Ya);
            if (Ya >= 0) {
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
        if (this.Oi != null) {
            this.Oi.hh();
        }
        this.bEp.bEh = null;
        if (this.bEp.bEn != null) {
            this.bEp.bEn.callback(1, false, null, false);
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
        this.bEp.bEh = null;
        if (bool.booleanValue()) {
            arrayList = this.bEp.bEj;
            arrayList.clear();
            str = null;
            z = false;
        } else if (this.Oi.sp().tq().pv()) {
            str = this.bEo.getErrorString();
            z = false;
        } else {
            str = null;
            z = true;
        }
        if (this.bEp.bEn != null) {
            this.bEp.bEn.callback(1, bool, str, Boolean.valueOf(z));
        }
    }
}
