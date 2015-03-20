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
public class m extends BdAsyncTask<String, Integer, com.baidu.tieba.write.a.a> {
    private com.baidu.tbadk.core.util.aa ZD;
    final /* synthetic */ AtListActivity cwI;

    private m(AtListActivity atListActivity) {
        this.cwI = atListActivity;
        this.ZD = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ m(AtListActivity atListActivity, m mVar) {
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
        if (this.ZD != null) {
            this.ZD.hh();
        }
        this.cwI.cwz = null;
        progressBar = this.cwI.mProgress;
        progressBar.setVisibility(8);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: B */
    public com.baidu.tieba.write.a.a doInBackground(String... strArr) {
        this.ZD = new com.baidu.tbadk.core.util.aa();
        this.ZD.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/follow/list");
        String rO = this.ZD.rO();
        if (!this.ZD.sp().tq().pv()) {
            return null;
        }
        com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
        aVar.je(rO);
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
        n nVar;
        EditText editText;
        com.baidu.tieba.write.b.a aVar3;
        com.baidu.tieba.write.b.a aVar4;
        n nVar2;
        n nVar3;
        n nVar4;
        BdListView bdListView;
        LinearLayout linearLayout2;
        View view;
        this.cwI.cwz = null;
        progressBar = this.cwI.mProgress;
        progressBar.setVisibility(8);
        linearLayout = this.cwI.bsM;
        if (linearLayout != null) {
            linearLayout2 = this.cwI.bsM;
            if (linearLayout2.getVisibility() == 0) {
                view = this.cwI.cwD;
                view.setVisibility(0);
            }
        }
        if (this.ZD.sp().tq().pv()) {
            aVar2 = this.cwI.cwA;
            aVar2.a(aVar);
            nVar = this.cwI.cwB;
            if (nVar != null) {
                editText = this.cwI.mEditText;
                if (com.baidu.adp.lib.util.m.a(editText.getText(), "").length() != 0) {
                    aVar3 = this.cwI.cwA;
                    if (aVar3.aqi() != null) {
                        if (aVar != null && aVar.apX() != null && !aVar.apX().isEmpty()) {
                            this.cwI.jb(2);
                        }
                        aVar4 = this.cwI.cwA;
                        aVar4.aqi().f(aVar.apX());
                        nVar2 = this.cwI.cwB;
                        nVar2.notifyDataSetInvalidated();
                    }
                } else {
                    if (aVar == null || aVar.apW() == null || !aVar.apW().isEmpty()) {
                        this.cwI.jb(0);
                    } else {
                        this.cwI.jb(2);
                    }
                    this.cwI.cwv = aVar.apW();
                    nVar3 = this.cwI.cwB;
                    nVar3.p(this.cwI.cwv);
                    nVar4 = this.cwI.cwB;
                    nVar4.notifyDataSetInvalidated();
                    bdListView = this.cwI.mListView;
                    bdListView.setSelection(0);
                }
            } else {
                return;
            }
        } else {
            this.cwI.showToast(this.ZD.getErrorString());
        }
        super.onPostExecute(aVar);
    }
}
