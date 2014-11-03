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
    final /* synthetic */ AtListActivity bST;
    private String bSU;
    private com.baidu.tbadk.core.util.ac yV;

    private h(AtListActivity atListActivity) {
        this.bST = atListActivity;
        this.yV = null;
        this.bSU = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ h(AtListActivity atListActivity, h hVar) {
        this(atListActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ProgressBar progressBar;
        progressBar = this.bST.mProgress;
        progressBar.setVisibility(0);
        super.onPreExecute();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        this.bST.bSJ = null;
        this.bSU = null;
        progressBar = this.bST.mProgress;
        progressBar.setVisibility(8);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: C */
    public com.baidu.tieba.data.as doInBackground(String... strArr) {
        com.baidu.tieba.model.c cVar;
        this.bSU = strArr[0];
        this.yV = new com.baidu.tbadk.core.util.ac();
        if (this.bSU != null && this.bSU.length() > 0) {
            this.yV.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/follow/sug");
            this.yV.k(SapiAccountManager.SESSION_UID, TbadkApplication.getCurrentAccount());
            this.yV.k("q", this.bSU);
            String lA = this.yV.lA();
            if (this.yV.mc().nb().jq()) {
                com.baidu.tieba.data.as asVar = new com.baidu.tieba.data.as();
                cVar = this.bST.bSL;
                com.baidu.tieba.data.r Te = cVar.Te();
                if (Te != null) {
                    asVar.a(lA, Te.zg());
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
        this.bST.bSJ = null;
        progressBar = this.bST.mProgress;
        progressBar.setVisibility(8);
        if (this.yV.mc().nb().jq() && this.bSU != null) {
            editText = this.bST.mEditText;
            if (com.baidu.adp.lib.util.l.a(editText.getText(), "").equals(this.bSU)) {
                if (!asVar.AB().isEmpty()) {
                    this.bST.eK(false);
                }
                cVar = this.bST.bSL;
                cVar.a(asVar);
                jVar = this.bST.bSM;
                jVar.setData(asVar.AB());
                jVar2 = this.bST.bSM;
                jVar2.notifyDataSetInvalidated();
                bdListView = this.bST.vl;
                bdListView.setSelection(0);
                super.onPostExecute(asVar);
            }
        }
        this.bST.showToast(this.yV.getErrorString());
        super.onPostExecute(asVar);
    }
}
