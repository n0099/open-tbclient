package com.baidu.tieba.write;

import android.widget.EditText;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends BdAsyncTask<String, Integer, com.baidu.tieba.data.h> {
    private com.baidu.tbadk.core.util.ad CV;
    final /* synthetic */ AtListActivity cdZ;

    private i(AtListActivity atListActivity) {
        this.cdZ = atListActivity;
        this.CV = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ i(AtListActivity atListActivity, i iVar) {
        this(atListActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ProgressBar progressBar;
        progressBar = this.cdZ.mProgress;
        progressBar.setVisibility(0);
        super.onPreExecute();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        if (this.CV != null) {
            this.CV.dL();
        }
        this.cdZ.cdQ = null;
        progressBar = this.cdZ.mProgress;
        progressBar.setVisibility(8);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: D */
    public com.baidu.tieba.data.h doInBackground(String... strArr) {
        this.CV = new com.baidu.tbadk.core.util.ad();
        this.CV.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/follow/list");
        String ov = this.CV.ov();
        if (!this.CV.oW().pW().ma()) {
            return null;
        }
        com.baidu.tieba.data.h hVar = new com.baidu.tieba.data.h();
        hVar.eY(ov);
        return hVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public void onPostExecute(com.baidu.tieba.data.h hVar) {
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
        this.cdZ.cdQ = null;
        progressBar = this.cdZ.mProgress;
        progressBar.setVisibility(8);
        if (this.CV.oW().pW().ma()) {
            cVar = this.cdZ.cdR;
            cVar.a(hVar);
            jVar = this.cdZ.cdS;
            if (jVar != null) {
                editText = this.cdZ.mEditText;
                if (com.baidu.adp.lib.util.k.a(editText.getText(), "").length() != 0) {
                    cVar2 = this.cdZ.cdR;
                    if (cVar2.TY() != null) {
                        if (!hVar.Cs().isEmpty()) {
                            this.cdZ.eJ(false);
                        }
                        cVar3 = this.cdZ.cdR;
                        cVar3.TY().d(hVar.Cs());
                        jVar2 = this.cdZ.cdS;
                        jVar2.notifyDataSetInvalidated();
                    }
                } else {
                    if (hVar.Cr().isEmpty()) {
                        this.cdZ.eJ(true);
                    } else {
                        this.cdZ.eJ(false);
                    }
                    this.cdZ.cdM = hVar.Cr();
                    jVar3 = this.cdZ.cdS;
                    jVar3.r(this.cdZ.cdM);
                    jVar4 = this.cdZ.cdS;
                    jVar4.notifyDataSetInvalidated();
                    bdListView = this.cdZ.mListView;
                    bdListView.setSelection(0);
                }
            } else {
                return;
            }
        } else {
            this.cdZ.showToast(this.CV.getErrorString());
        }
        super.onPostExecute(hVar);
    }
}
