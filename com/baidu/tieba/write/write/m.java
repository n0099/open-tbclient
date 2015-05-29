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
    final /* synthetic */ AtListActivity cBt;
    private String mString;

    private m(AtListActivity atListActivity) {
        this.cBt = atListActivity;
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
        progressBar = this.cBt.mProgress;
        progressBar.setVisibility(0);
        super.onPreExecute();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        this.cBt.cBi = null;
        this.mString = null;
        progressBar = this.cBt.mProgress;
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
                aVar = this.cBt.cBk;
                com.baidu.tieba.write.a.a asm = aVar.asm();
                if (asm != null) {
                    bVar.a(sw, asm.asc());
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
        this.cBt.cBi = null;
        progressBar = this.cBt.mProgress;
        progressBar.setVisibility(8);
        if (this.aaG.sX().tT().qa() && this.mString != null) {
            editText = this.cBt.mEditText;
            if (com.baidu.adp.lib.util.m.a(editText.getText(), "").equals(this.mString)) {
                if (bVar == null || bVar.asd().isEmpty()) {
                    this.cBt.jA(1);
                } else {
                    this.cBt.jA(0);
                }
                aVar = this.cBt.cBk;
                aVar.a(bVar);
                oVar = this.cBt.cBl;
                oVar.setData(bVar.asd());
                oVar2 = this.cBt.cBl;
                oVar2.notifyDataSetInvalidated();
                bdListView = this.cBt.mListView;
                bdListView.setSelection(0);
                super.onPostExecute(bVar);
            }
        }
        this.cBt.showToast(this.aaG.getErrorString());
        super.onPostExecute(bVar);
    }
}
