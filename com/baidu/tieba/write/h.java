package com.baidu.tieba.write;

import android.widget.EditText;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends BdAsyncTask<String, Integer, com.baidu.tieba.data.as> {
    final /* synthetic */ AtListActivity bSE;
    private String bSF;
    private com.baidu.tbadk.core.util.ac yV;

    private h(AtListActivity atListActivity) {
        this.bSE = atListActivity;
        this.yV = null;
        this.bSF = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ h(AtListActivity atListActivity, h hVar) {
        this(atListActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ProgressBar progressBar;
        progressBar = this.bSE.mProgress;
        progressBar.setVisibility(0);
        super.onPreExecute();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        this.bSE.bSu = null;
        this.bSF = null;
        progressBar = this.bSE.mProgress;
        progressBar.setVisibility(8);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: C */
    public com.baidu.tieba.data.as doInBackground(String... strArr) {
        com.baidu.tieba.model.c cVar;
        this.bSF = strArr[0];
        this.yV = new com.baidu.tbadk.core.util.ac();
        if (this.bSF != null && this.bSF.length() > 0) {
            this.yV.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/follow/sug");
            this.yV.k(SapiAccountManager.SESSION_UID, TbadkApplication.getCurrentAccount());
            this.yV.k("q", this.bSF);
            String lA = this.yV.lA();
            if (this.yV.mc().nb().jq()) {
                com.baidu.tieba.data.as asVar = new com.baidu.tieba.data.as();
                cVar = this.bSE.bSw;
                com.baidu.tieba.data.r Tb = cVar.Tb();
                if (Tb != null) {
                    asVar.a(lA, Tb.ze());
                    return asVar;
                }
                asVar.a(lA, (HashMap<String, String>) null);
                return asVar;
            }
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public void onPostExecute(com.baidu.tieba.data.as asVar) {
        ProgressBar progressBar;
        EditText editText;
        com.baidu.tieba.model.c cVar;
        j jVar;
        j jVar2;
        BdListView bdListView;
        this.bSE.bSu = null;
        progressBar = this.bSE.mProgress;
        progressBar.setVisibility(8);
        if (this.yV.mc().nb().jq() && this.bSF != null) {
            editText = this.bSE.mEditText;
            if (com.baidu.adp.lib.util.l.a(editText.getText(), "").equals(this.bSF)) {
                if (!asVar.Az().isEmpty()) {
                    this.bSE.eK(false);
                }
                cVar = this.bSE.bSw;
                cVar.a(asVar);
                jVar = this.bSE.bSx;
                jVar.setData(asVar.Az());
                jVar2 = this.bSE.bSx;
                jVar2.notifyDataSetInvalidated();
                bdListView = this.bSE.vl;
                bdListView.setSelection(0);
                super.onPostExecute(asVar);
            }
        }
        this.bSE.showToast(this.yV.getErrorString());
        super.onPostExecute(asVar);
    }
}
