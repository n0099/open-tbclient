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
    final /* synthetic */ AtListActivity cBu;

    private n(AtListActivity atListActivity) {
        this.cBu = atListActivity;
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
        progressBar = this.cBu.mProgress;
        progressBar.setVisibility(0);
        super.onPreExecute();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        if (this.aaG != null) {
            this.aaG.gS();
        }
        this.cBu.cBk = null;
        progressBar = this.cBu.mProgress;
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
        this.cBu.cBk = null;
        progressBar = this.cBu.mProgress;
        progressBar.setVisibility(8);
        linearLayout = this.cBu.bvN;
        if (linearLayout != null) {
            linearLayout2 = this.cBu.bvN;
            if (linearLayout2.getVisibility() == 0) {
                view = this.cBu.cBo;
                view.setVisibility(0);
            }
        }
        if (this.aaG.sX().tT().qa()) {
            aVar2 = this.cBu.cBl;
            aVar2.a(aVar);
            oVar = this.cBu.cBm;
            if (oVar != null) {
                editText = this.cBu.mEditText;
                if (com.baidu.adp.lib.util.m.a(editText.getText(), "").length() != 0) {
                    aVar3 = this.cBu.cBl;
                    if (aVar3.aso() != null) {
                        if (aVar != null && aVar.asd() != null && !aVar.asd().isEmpty()) {
                            this.cBu.jA(2);
                        }
                        aVar4 = this.cBu.cBl;
                        aVar4.aso().f(aVar.asd());
                        oVar2 = this.cBu.cBm;
                        oVar2.notifyDataSetInvalidated();
                    }
                } else {
                    if (aVar == null || aVar.asc() == null || !aVar.asc().isEmpty()) {
                        this.cBu.jA(0);
                    } else {
                        this.cBu.jA(2);
                    }
                    this.cBu.cBg = aVar.asc();
                    oVar3 = this.cBu.cBm;
                    oVar3.setData(this.cBu.cBg);
                    oVar4 = this.cBu.cBm;
                    oVar4.notifyDataSetInvalidated();
                    bdListView = this.cBu.mListView;
                    bdListView.setSelection(0);
                }
            } else {
                return;
            }
        } else {
            this.cBu.showToast(this.aaG.getErrorString());
        }
        super.onPostExecute(aVar);
    }
}
