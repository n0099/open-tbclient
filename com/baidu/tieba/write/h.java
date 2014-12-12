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
    private com.baidu.tbadk.core.util.ad CV;
    final /* synthetic */ AtListActivity cdZ;
    private String mString;

    private h(AtListActivity atListActivity) {
        this.cdZ = atListActivity;
        this.CV = null;
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
        progressBar = this.cdZ.mProgress;
        progressBar.setVisibility(0);
        super.onPreExecute();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        this.cdZ.cdP = null;
        this.mString = null;
        progressBar = this.cdZ.mProgress;
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
        this.CV = new com.baidu.tbadk.core.util.ad();
        if (this.mString != null && this.mString.length() > 0) {
            this.CV.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/follow/sug");
            this.CV.o(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
            this.CV.o("q", this.mString);
            String ov = this.CV.ov();
            if (this.CV.oW().pW().ma()) {
                com.baidu.tieba.data.q qVar = new com.baidu.tieba.data.q();
                cVar = this.cdZ.cdR;
                com.baidu.tieba.data.h TX = cVar.TX();
                if (TX != null) {
                    qVar.a(ov, TX.Cs());
                    return qVar;
                }
                qVar.a(ov, (HashMap<String, String>) null);
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
        this.cdZ.cdP = null;
        progressBar = this.cdZ.mProgress;
        progressBar.setVisibility(8);
        if (this.CV.oW().pW().ma() && this.mString != null) {
            editText = this.cdZ.mEditText;
            if (com.baidu.adp.lib.util.k.a(editText.getText(), "").equals(this.mString)) {
                if (!qVar.Cz().isEmpty()) {
                    this.cdZ.eJ(false);
                }
                cVar = this.cdZ.cdR;
                cVar.a(qVar);
                jVar = this.cdZ.cdS;
                jVar.r(qVar.Cz());
                jVar2 = this.cdZ.cdS;
                jVar2.notifyDataSetInvalidated();
                bdListView = this.cdZ.mListView;
                bdListView.setSelection(0);
                super.onPostExecute(qVar);
            }
        }
        this.cdZ.showToast(this.CV.getErrorString());
        super.onPostExecute(qVar);
    }
}
