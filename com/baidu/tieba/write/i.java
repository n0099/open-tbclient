package com.baidu.tieba.write;

import android.widget.EditText;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends BdAsyncTask<String, Integer, com.baidu.tieba.data.r> {
    final /* synthetic */ AtListActivity bST;
    private com.baidu.tbadk.core.util.ac yV;

    private i(AtListActivity atListActivity) {
        this.bST = atListActivity;
        this.yV = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ i(AtListActivity atListActivity, i iVar) {
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
        if (this.yV != null) {
            this.yV.dM();
        }
        this.bST.bSK = null;
        progressBar = this.bST.mProgress;
        progressBar.setVisibility(8);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: D */
    public com.baidu.tieba.data.r doInBackground(String... strArr) {
        this.yV = new com.baidu.tbadk.core.util.ac();
        this.yV.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/follow/list");
        String lA = this.yV.lA();
        if (!this.yV.mc().nb().jq()) {
            return null;
        }
        com.baidu.tieba.data.r rVar = new com.baidu.tieba.data.r();
        rVar.es(lA);
        return rVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public void onPostExecute(com.baidu.tieba.data.r rVar) {
        ProgressBar progressBar;
        com.baidu.tieba.model.c cVar;
        j jVar;
        EditText editText;
        com.baidu.tieba.model.c cVar2;
        com.baidu.tieba.model.c cVar3;
        j jVar2;
        j jVar3;
        j jVar4;
        BdListView bdListView;
        this.bST.bSK = null;
        progressBar = this.bST.mProgress;
        progressBar.setVisibility(8);
        if (this.yV.mc().nb().jq()) {
            cVar = this.bST.bSL;
            cVar.a(rVar);
            jVar = this.bST.bSM;
            if (jVar != null) {
                editText = this.bST.mEditText;
                if (com.baidu.adp.lib.util.l.a(editText.getText(), "").length() != 0) {
                    cVar2 = this.bST.bSL;
                    if (cVar2.Tf() != null) {
                        if (!rVar.zg().isEmpty()) {
                            this.bST.eK(false);
                        }
                        cVar3 = this.bST.bSL;
                        cVar3.Tf().c(rVar.zg());
                        jVar2 = this.bST.bSM;
                        jVar2.notifyDataSetInvalidated();
                    }
                } else {
                    if (rVar.zf().isEmpty()) {
                        this.bST.eK(true);
                    } else {
                        this.bST.eK(false);
                    }
                    this.bST.bSG = rVar.zf();
                    jVar3 = this.bST.bSM;
                    jVar3.setData(this.bST.bSG);
                    jVar4 = this.bST.bSM;
                    jVar4.notifyDataSetInvalidated();
                    bdListView = this.bST.vl;
                    bdListView.setSelection(0);
                }
            } else {
                return;
            }
        } else {
            this.bST.showToast(this.yV.getErrorString());
        }
        super.onPostExecute(rVar);
    }
}
