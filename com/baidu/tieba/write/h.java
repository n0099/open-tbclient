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
    private com.baidu.tbadk.core.util.ad CU;
    final /* synthetic */ AtListActivity cfx;
    private String mString;

    private h(AtListActivity atListActivity) {
        this.cfx = atListActivity;
        this.CU = null;
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
        progressBar = this.cfx.mProgress;
        progressBar.setVisibility(0);
        super.onPreExecute();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        this.cfx.cfn = null;
        this.mString = null;
        progressBar = this.cfx.mProgress;
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
        this.CU = new com.baidu.tbadk.core.util.ad();
        if (this.mString != null && this.mString.length() > 0) {
            this.CU.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/follow/sug");
            this.CU.o(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
            this.CU.o("q", this.mString);
            String or = this.CU.or();
            if (this.CU.oS().qa().lT()) {
                com.baidu.tieba.data.q qVar = new com.baidu.tieba.data.q();
                cVar = this.cfx.cfp;
                com.baidu.tieba.data.h Uq = cVar.Uq();
                if (Uq != null) {
                    qVar.a(or, Uq.CL());
                    return qVar;
                }
                qVar.a(or, (HashMap<String, String>) null);
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
        this.cfx.cfn = null;
        progressBar = this.cfx.mProgress;
        progressBar.setVisibility(8);
        if (this.CU.oS().qa().lT() && this.mString != null) {
            editText = this.cfx.mEditText;
            if (com.baidu.adp.lib.util.k.a(editText.getText(), "").equals(this.mString)) {
                if (!qVar.CS().isEmpty()) {
                    this.cfx.eO(false);
                }
                cVar = this.cfx.cfp;
                cVar.a(qVar);
                jVar = this.cfx.cfq;
                jVar.s(qVar.CS());
                jVar2 = this.cfx.cfq;
                jVar2.notifyDataSetInvalidated();
                bdListView = this.cfx.mListView;
                bdListView.setSelection(0);
                super.onPostExecute(qVar);
            }
        }
        this.cfx.showToast(this.CU.getErrorString());
        super.onPostExecute(qVar);
    }
}
