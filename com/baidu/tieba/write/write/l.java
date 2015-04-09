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
    private com.baidu.tbadk.core.util.aa ZF;
    final /* synthetic */ AtListActivity cxb;
    private String mString;

    private l(AtListActivity atListActivity) {
        this.cxb = atListActivity;
        this.ZF = null;
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
        progressBar = this.cxb.mProgress;
        progressBar.setVisibility(0);
        super.onPreExecute();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        this.cxb.cwR = null;
        this.mString = null;
        progressBar = this.cxb.mProgress;
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
        this.ZF = new com.baidu.tbadk.core.util.aa();
        if (this.mString != null && this.mString.length() > 0) {
            this.ZF.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/follow/sug");
            this.ZF.o(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
            this.ZF.o("q", this.mString);
            String rO = this.ZF.rO();
            if (this.ZF.sp().tq().pv()) {
                com.baidu.tieba.write.a.b bVar = new com.baidu.tieba.write.a.b();
                aVar = this.cxb.cwT;
                com.baidu.tieba.write.a.a aqw = aVar.aqw();
                if (aqw != null) {
                    bVar.a(rO, aqw.aqm());
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
        this.cxb.cwR = null;
        progressBar = this.cxb.mProgress;
        progressBar.setVisibility(8);
        if (this.ZF.sp().tq().pv() && this.mString != null) {
            editText = this.cxb.mEditText;
            if (com.baidu.adp.lib.util.m.a(editText.getText(), "").equals(this.mString)) {
                if (bVar == null || bVar.aqn().isEmpty()) {
                    this.cxb.je(1);
                } else {
                    this.cxb.je(0);
                }
                aVar = this.cxb.cwT;
                aVar.a(bVar);
                nVar = this.cxb.cwU;
                nVar.p(bVar.aqn());
                nVar2 = this.cxb.cwU;
                nVar2.notifyDataSetInvalidated();
                bdListView = this.cxb.mListView;
                bdListView.setSelection(0);
                super.onPostExecute(bVar);
            }
        }
        this.cxb.showToast(this.ZF.getErrorString());
        super.onPostExecute(bVar);
    }
}
