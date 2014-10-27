package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends BdAsyncTask<j, Integer, Boolean> {
    private com.baidu.tieba.data.at boo;
    final /* synthetic */ j bop;
    private com.baidu.tbadk.core.util.ac mNetWork;

    private m(j jVar) {
        this.bop = jVar;
        this.mNetWork = null;
        this.boo = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ m(j jVar, m mVar) {
        this(jVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        this.boo = new com.baidu.tieba.data.at();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public Boolean doInBackground(j... jVarArr) {
        j jVar = new j();
        try {
            jVar.Tk();
            this.mNetWork = new com.baidu.tbadk.core.util.ac();
            this.mNetWork.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/post/addstore");
            int Tl = this.bop.Tl();
            if (jVar.getCount() - 1 <= Tl) {
                Tl = jVar.getCount() - 1;
            }
            while (Tl >= 0) {
                String T = jVar.T(Tl, 20);
                this.mNetWork.h(new ArrayList<>());
                this.mNetWork.k("data", T);
                this.boo.parserJson(this.mNetWork.lA());
                if (!this.mNetWork.mc().nb().jq() || this.boo.getErrorCode() != 0) {
                    break;
                }
                Tl -= 20;
            }
            this.bop.gC(Tl);
            if (Tl >= 0) {
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
        this.bop.boj = null;
        if (this.bop.atj != null) {
            this.bop.atj.callback(1, false, null, false);
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
        this.bop.boj = null;
        if (bool.booleanValue()) {
            arrayList = this.bop.bol;
            arrayList.clear();
            str = null;
            z = false;
        } else if (this.mNetWork.mc().nb().jq()) {
            str = this.boo.getErrorString();
            z = false;
        } else {
            str = null;
            z = true;
        }
        if (this.bop.atj != null) {
            this.bop.atj.callback(1, bool, str, Boolean.valueOf(z));
        }
    }
}
