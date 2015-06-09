package com.baidu.tieba.write.write;

import android.widget.EditText;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends BdAsyncTask<String, Integer, com.baidu.tieba.write.a.b> {
    private com.baidu.tbadk.core.util.aa aaG;
    final /* synthetic */ AtListActivity cBu;
    private String mString;

    private m(AtListActivity atListActivity) {
        this.cBu = atListActivity;
        this.aaG = null;
        this.mString = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ m(AtListActivity atListActivity, m mVar) {
        this(atListActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ProgressBar progressBar;
        progressBar = this.cBu.mProgress;
        progressBar.setVisibility(0);
        super.onPreExecute();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        this.cBu.cBj = null;
        this.mString = null;
        progressBar = this.cBu.mProgress;
        progressBar.setVisibility(8);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: B */
    public com.baidu.tieba.write.a.b doInBackground(String... strArr) {
        com.baidu.tieba.write.b.a aVar;
        this.mString = strArr[0];
        this.aaG = new com.baidu.tbadk.core.util.aa();
        if (this.mString != null && this.mString.length() > 0) {
            this.aaG.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/follow/sug");
            this.aaG.o("uid", TbadkCoreApplication.getCurrentAccount());
            this.aaG.o("q", this.mString);
            String sw = this.aaG.sw();
            if (this.aaG.sX().tT().qa()) {
                com.baidu.tieba.write.a.b bVar = new com.baidu.tieba.write.a.b();
                aVar = this.cBu.cBl;
                com.baidu.tieba.write.a.a asn = aVar.asn();
                if (asn != null) {
                    bVar.a(sw, asn.asd());
                    return bVar;
                }
                bVar.a(sw, (HashMap<String, String>) null);
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
        o oVar;
        o oVar2;
        BdListView bdListView;
        this.cBu.cBj = null;
        progressBar = this.cBu.mProgress;
        progressBar.setVisibility(8);
        if (this.aaG.sX().tT().qa() && this.mString != null) {
            editText = this.cBu.mEditText;
            if (com.baidu.adp.lib.util.m.a(editText.getText(), "").equals(this.mString)) {
                if (bVar == null || bVar.ase().isEmpty()) {
                    this.cBu.jA(1);
                } else {
                    this.cBu.jA(0);
                }
                aVar = this.cBu.cBl;
                aVar.a(bVar);
                oVar = this.cBu.cBm;
                oVar.setData(bVar.ase());
                oVar2 = this.cBu.cBm;
                oVar2.notifyDataSetInvalidated();
                bdListView = this.cBu.mListView;
                bdListView.setSelection(0);
                super.onPostExecute(bVar);
            }
        }
        this.cBu.showToast(this.aaG.getErrorString());
        super.onPostExecute(bVar);
    }
}
