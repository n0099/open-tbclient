package com.baidu.tieba.write.write;

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
public class l extends BdAsyncTask<String, Integer, com.baidu.tieba.write.a.b> {
    private com.baidu.tbadk.core.util.aa ZD;
    final /* synthetic */ AtListActivity cwI;
    private String mString;

    private l(AtListActivity atListActivity) {
        this.cwI = atListActivity;
        this.ZD = null;
        this.mString = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ l(AtListActivity atListActivity, l lVar) {
        this(atListActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ProgressBar progressBar;
        progressBar = this.cwI.mProgress;
        progressBar.setVisibility(0);
        super.onPreExecute();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        this.cwI.cwy = null;
        this.mString = null;
        progressBar = this.cwI.mProgress;
        progressBar.setVisibility(8);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: A */
    public com.baidu.tieba.write.a.b doInBackground(String... strArr) {
        com.baidu.tieba.write.b.a aVar;
        this.mString = strArr[0];
        this.ZD = new com.baidu.tbadk.core.util.aa();
        if (this.mString != null && this.mString.length() > 0) {
            this.ZD.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/follow/sug");
            this.ZD.o(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
            this.ZD.o("q", this.mString);
            String rO = this.ZD.rO();
            if (this.ZD.sp().tq().pv()) {
                com.baidu.tieba.write.a.b bVar = new com.baidu.tieba.write.a.b();
                aVar = this.cwI.cwA;
                com.baidu.tieba.write.a.a aqh = aVar.aqh();
                if (aqh != null) {
                    bVar.a(rO, aqh.apX());
                    return bVar;
                }
                bVar.a(rO, (HashMap<String, String>) null);
                return bVar;
            }
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public void onPostExecute(com.baidu.tieba.write.a.b bVar) {
        ProgressBar progressBar;
        EditText editText;
        com.baidu.tieba.write.b.a aVar;
        n nVar;
        n nVar2;
        BdListView bdListView;
        this.cwI.cwy = null;
        progressBar = this.cwI.mProgress;
        progressBar.setVisibility(8);
        if (this.ZD.sp().tq().pv() && this.mString != null) {
            editText = this.cwI.mEditText;
            if (com.baidu.adp.lib.util.m.a(editText.getText(), "").equals(this.mString)) {
                if (bVar == null || bVar.apY().isEmpty()) {
                    this.cwI.jb(1);
                } else {
                    this.cwI.jb(0);
                }
                aVar = this.cwI.cwA;
                aVar.a(bVar);
                nVar = this.cwI.cwB;
                nVar.p(bVar.apY());
                nVar2 = this.cwI.cwB;
                nVar2.notifyDataSetInvalidated();
                bdListView = this.cwI.mListView;
                bdListView.setSelection(0);
                super.onPostExecute(bVar);
            }
        }
        this.cwI.showToast(this.ZD.getErrorString());
        super.onPostExecute(bVar);
    }
}
