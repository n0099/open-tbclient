package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends BdAsyncTask<j, Integer, Boolean> {
    private com.baidu.tieba.data.at boC;
    final /* synthetic */ j boD;
    private com.baidu.tbadk.core.util.ac mNetWork;

    private m(j jVar) {
        this.boD = jVar;
        this.mNetWork = null;
        this.boC = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ m(j jVar, m mVar) {
        this(jVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        this.boC = new com.baidu.tieba.data.at();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public Boolean doInBackground(j... jVarArr) {
        j jVar = new j();
        try {
            jVar.Tn();
            this.mNetWork = new com.baidu.tbadk.core.util.ac();
            this.mNetWork.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/post/addstore");
            int To = this.boD.To();
            if (jVar.getCount() - 1 <= To) {
                To = jVar.getCount() - 1;
            }
            while (To >= 0) {
                String T = jVar.T(To, 20);
                this.mNetWork.h(new ArrayList<>());
                this.mNetWork.k("data", T);
                this.boC.parserJson(this.mNetWork.lA());
                if (!this.mNetWork.mc().nb().jq() || this.boC.getErrorCode() != 0) {
                    break;
                }
                To -= 20;
            }
            this.boD.gC(To);
            if (To >= 0) {
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
        if (this.mNetWork != null) {
            this.mNetWork.dM();
        }
        this.boD.box = null;
        if (this.boD.ats != null) {
            this.boD.ats.callback(1, false, null, false);
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
        this.boD.box = null;
        if (bool.booleanValue()) {
            arrayList = this.boD.boz;
            arrayList.clear();
            str = null;
            z = false;
        } else if (this.mNetWork.mc().nb().jq()) {
            str = this.boC.getErrorString();
            z = false;
        } else {
            str = null;
            z = true;
        }
        if (this.boD.ats != null) {
            this.boD.ats.callback(1, bool, str, Boolean.valueOf(z));
        }
    }
}
