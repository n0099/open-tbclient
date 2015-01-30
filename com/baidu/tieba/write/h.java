package com.baidu.tieba.write;

import android.widget.EditText;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends BdAsyncTask<String, Integer, com.baidu.tieba.data.q> {
    private com.baidu.tbadk.core.util.ad CX;
    final /* synthetic */ AtListActivity cfy;
    private String mString;

    private h(AtListActivity atListActivity) {
        this.cfy = atListActivity;
        this.CX = null;
        this.mString = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ h(AtListActivity atListActivity, h hVar) {
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
        this.cfy.cfo = null;
        this.mString = null;
        progressBar = this.cfy.mProgress;
        progressBar.setVisibility(8);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: C */
    public com.baidu.tieba.data.q doInBackground(String... strArr) {
        com.baidu.tieba.model.c cVar;
        this.mString = strArr[0];
        this.CX = new com.baidu.tbadk.core.util.ad();
        if (this.mString != null && this.mString.length() > 0) {
            this.CX.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/follow/sug");
            this.CX.o(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
            this.CX.o("q", this.mString);
            String oy = this.CX.oy();
            if (this.CX.oZ().qh().ma()) {
                com.baidu.tieba.data.q qVar = new com.baidu.tieba.data.q();
                cVar = this.cfy.cfq;
                com.baidu.tieba.data.h Uv = cVar.Uv();
                if (Uv != null) {
                    qVar.a(oy, Uv.CR());
                    return qVar;
                }
                qVar.a(oy, (HashMap<String, String>) null);
                return qVar;
            }
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public void onPostExecute(com.baidu.tieba.data.q qVar) {
        ProgressBar progressBar;
        EditText editText;
        com.baidu.tieba.model.c cVar;
        j jVar;
        j jVar2;
        BdListView bdListView;
        this.cfy.cfo = null;
        progressBar = this.cfy.mProgress;
        progressBar.setVisibility(8);
        if (this.CX.oZ().qh().ma() && this.mString != null) {
            editText = this.cfy.mEditText;
            if (com.baidu.adp.lib.util.k.a(editText.getText(), "").equals(this.mString)) {
                if (!qVar.CY().isEmpty()) {
                    this.cfy.eO(false);
                }
                cVar = this.cfy.cfq;
                cVar.a(qVar);
                jVar = this.cfy.cfr;
                jVar.s(qVar.CY());
                jVar2 = this.cfy.cfr;
                jVar2.notifyDataSetInvalidated();
                bdListView = this.cfy.mListView;
                bdListView.setSelection(0);
                super.onPostExecute(qVar);
            }
        }
        this.cfy.showToast(this.CX.getErrorString());
        super.onPostExecute(qVar);
    }
}
