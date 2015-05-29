package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends BdAsyncTask<String, Integer, com.baidu.tieba.write.a.a> {
    private com.baidu.tbadk.core.util.aa aaG;
    final /* synthetic */ AtListActivity cBt;

    private n(AtListActivity atListActivity) {
        this.cBt = atListActivity;
        this.aaG = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ n(AtListActivity atListActivity, n nVar) {
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
        if (this.aaG != null) {
            this.aaG.gS();
        }
        this.cBt.cBj = null;
        progressBar = this.cBt.mProgress;
        progressBar.setVisibility(8);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: C */
    public com.baidu.tieba.write.a.a doInBackground(String... strArr) {
        this.aaG = new com.baidu.tbadk.core.util.aa();
        this.aaG.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/follow/list");
        String sw = this.aaG.sw();
        if (!this.aaG.sX().tT().qa()) {
            return null;
        }
        com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
        aVar.ka(sw);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public void onPostExecute(com.baidu.tieba.write.a.a aVar) {
        ProgressBar progressBar;
        LinearLayout linearLayout;
        com.baidu.tieba.write.b.a aVar2;
        o oVar;
        EditText editText;
        com.baidu.tieba.write.b.a aVar3;
        com.baidu.tieba.write.b.a aVar4;
        o oVar2;
        o oVar3;
        o oVar4;
        BdListView bdListView;
        LinearLayout linearLayout2;
        View view;
        this.cBt.cBj = null;
        progressBar = this.cBt.mProgress;
        progressBar.setVisibility(8);
        linearLayout = this.cBt.bvM;
        if (linearLayout != null) {
            linearLayout2 = this.cBt.bvM;
            if (linearLayout2.getVisibility() == 0) {
                view = this.cBt.cBn;
                view.setVisibility(0);
            }
        }
        if (this.aaG.sX().tT().qa()) {
            aVar2 = this.cBt.cBk;
            aVar2.a(aVar);
            oVar = this.cBt.cBl;
            if (oVar != null) {
                editText = this.cBt.mEditText;
                if (com.baidu.adp.lib.util.m.a(editText.getText(), "").length() != 0) {
                    aVar3 = this.cBt.cBk;
                    if (aVar3.asn() != null) {
                        if (aVar != null && aVar.asc() != null && !aVar.asc().isEmpty()) {
                            this.cBt.jA(2);
                        }
                        aVar4 = this.cBt.cBk;
                        aVar4.asn().f(aVar.asc());
                        oVar2 = this.cBt.cBl;
                        oVar2.notifyDataSetInvalidated();
                    }
                } else {
                    if (aVar == null || aVar.asb() == null || !aVar.asb().isEmpty()) {
                        this.cBt.jA(0);
                    } else {
                        this.cBt.jA(2);
                    }
                    this.cBt.cBf = aVar.asb();
                    oVar3 = this.cBt.cBl;
                    oVar3.setData(this.cBt.cBf);
                    oVar4 = this.cBt.cBl;
                    oVar4.notifyDataSetInvalidated();
                    bdListView = this.cBt.mListView;
                    bdListView.setSelection(0);
                }
            } else {
                return;
            }
        } else {
            this.cBt.showToast(this.aaG.getErrorString());
        }
        super.onPostExecute(aVar);
    }
}
