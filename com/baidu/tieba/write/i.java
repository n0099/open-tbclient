package com.baidu.tieba.write;

import android.widget.EditText;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends BdAsyncTask<String, Integer, com.baidu.tieba.data.h> {
    private com.baidu.tbadk.core.util.ad CU;
    final /* synthetic */ AtListActivity cfx;

    private i(AtListActivity atListActivity) {
        this.cfx = atListActivity;
        this.CU = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ i(AtListActivity atListActivity, i iVar) {
        this(atListActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ProgressBar progressBar;
        progressBar = this.cfx.mProgress;
        progressBar.setVisibility(0);
        super.onPreExecute();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        if (this.CU != null) {
            this.CU.dJ();
        }
        this.cfx.cfo = null;
        progressBar = this.cfx.mProgress;
        progressBar.setVisibility(8);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: D */
    public com.baidu.tieba.data.h doInBackground(String... strArr) {
        this.CU = new com.baidu.tbadk.core.util.ad();
        this.CU.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/follow/list");
        String or = this.CU.or();
        if (!this.CU.oS().qa().lT()) {
            return null;
        }
        com.baidu.tieba.data.h hVar = new com.baidu.tieba.data.h();
        hVar.fa(or);
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
        this.cfx.cfo = null;
        progressBar = this.cfx.mProgress;
        progressBar.setVisibility(8);
        if (this.CU.oS().qa().lT()) {
            cVar = this.cfx.cfp;
            cVar.a(hVar);
            jVar = this.cfx.cfq;
            if (jVar != null) {
                editText = this.cfx.mEditText;
                if (com.baidu.adp.lib.util.k.a(editText.getText(), "").length() != 0) {
                    cVar2 = this.cfx.cfp;
                    if (cVar2.Ur() != null) {
                        if (!hVar.CL().isEmpty()) {
                            this.cfx.eO(false);
                        }
                        cVar3 = this.cfx.cfp;
                        cVar3.Ur().d(hVar.CL());
                        jVar2 = this.cfx.cfq;
                        jVar2.notifyDataSetInvalidated();
                    }
                } else {
                    if (hVar.CK().isEmpty()) {
                        this.cfx.eO(true);
                    } else {
                        this.cfx.eO(false);
                    }
                    this.cfx.cfk = hVar.CK();
                    jVar3 = this.cfx.cfq;
                    jVar3.s(this.cfx.cfk);
                    jVar4 = this.cfx.cfq;
                    jVar4.notifyDataSetInvalidated();
                    bdListView = this.cfx.mListView;
                    bdListView.setSelection(0);
                }
            } else {
                return;
            }
        } else {
            this.cfx.showToast(this.CU.getErrorString());
        }
        super.onPostExecute(hVar);
    }
}
