package com.baidu.tieba.write;

import android.widget.EditText;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends BdAsyncTask<String, Integer, com.baidu.tieba.data.h> {
    private com.baidu.tbadk.core.util.ad CX;
    final /* synthetic */ AtListActivity cfy;

    private i(AtListActivity atListActivity) {
        this.cfy = atListActivity;
        this.CX = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ i(AtListActivity atListActivity, i iVar) {
        this(atListActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ProgressBar progressBar;
        progressBar = this.cfy.mProgress;
        progressBar.setVisibility(0);
        super.onPreExecute();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        if (this.CX != null) {
            this.CX.dJ();
        }
        this.cfy.cfp = null;
        progressBar = this.cfy.mProgress;
        progressBar.setVisibility(8);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: D */
    public com.baidu.tieba.data.h doInBackground(String... strArr) {
        this.CX = new com.baidu.tbadk.core.util.ad();
        this.CX.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/follow/list");
        String oy = this.CX.oy();
        if (!this.CX.oZ().qh().ma()) {
            return null;
        }
        com.baidu.tieba.data.h hVar = new com.baidu.tieba.data.h();
        hVar.fd(oy);
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
        this.cfy.cfp = null;
        progressBar = this.cfy.mProgress;
        progressBar.setVisibility(8);
        if (this.CX.oZ().qh().ma()) {
            cVar = this.cfy.cfq;
            cVar.a(hVar);
            jVar = this.cfy.cfr;
            if (jVar != null) {
                editText = this.cfy.mEditText;
                if (com.baidu.adp.lib.util.k.a(editText.getText(), "").length() != 0) {
                    cVar2 = this.cfy.cfq;
                    if (cVar2.Uw() != null) {
                        if (!hVar.CR().isEmpty()) {
                            this.cfy.eO(false);
                        }
                        cVar3 = this.cfy.cfq;
                        cVar3.Uw().d(hVar.CR());
                        jVar2 = this.cfy.cfr;
                        jVar2.notifyDataSetInvalidated();
                    }
                } else {
                    if (hVar.CQ().isEmpty()) {
                        this.cfy.eO(true);
                    } else {
                        this.cfy.eO(false);
                    }
                    this.cfy.cfl = hVar.CQ();
                    jVar3 = this.cfy.cfr;
                    jVar3.s(this.cfy.cfl);
                    jVar4 = this.cfy.cfr;
                    jVar4.notifyDataSetInvalidated();
                    bdListView = this.cfy.mListView;
                    bdListView.setSelection(0);
                }
            } else {
                return;
            }
        } else {
            this.cfy.showToast(this.CX.getErrorString());
        }
        super.onPostExecute(hVar);
    }
}
