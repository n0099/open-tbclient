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
    private com.baidu.tbadk.core.util.aa ZF;
    final /* synthetic */ AtListActivity cxb;

    private m(AtListActivity atListActivity) {
        this.cxb = atListActivity;
        this.ZF = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ m(AtListActivity atListActivity, m mVar) {
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
        if (this.ZF != null) {
            this.ZF.hh();
        }
        this.cxb.cwS = null;
        progressBar = this.cxb.mProgress;
        progressBar.setVisibility(8);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: B */
    public com.baidu.tieba.write.a.a doInBackground(String... strArr) {
        this.ZF = new com.baidu.tbadk.core.util.aa();
        this.ZF.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/follow/list");
        String rO = this.ZF.rO();
        if (!this.ZF.sp().tq().pv()) {
            return null;
        }
        com.baidu.tieba.write.a.a aVar = new com.baidu.tieba.write.a.a();
        aVar.jh(rO);
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
        this.cxb.cwS = null;
        progressBar = this.cxb.mProgress;
        progressBar.setVisibility(8);
        linearLayout = this.cxb.btc;
        if (linearLayout != null) {
            linearLayout2 = this.cxb.btc;
            if (linearLayout2.getVisibility() == 0) {
                view = this.cxb.cwW;
                view.setVisibility(0);
            }
        }
        if (this.ZF.sp().tq().pv()) {
            aVar2 = this.cxb.cwT;
            aVar2.a(aVar);
            nVar = this.cxb.cwU;
            if (nVar != null) {
                editText = this.cxb.mEditText;
                if (com.baidu.adp.lib.util.m.a(editText.getText(), "").length() != 0) {
                    aVar3 = this.cxb.cwT;
                    if (aVar3.aqx() != null) {
                        if (aVar != null && aVar.aqm() != null && !aVar.aqm().isEmpty()) {
                            this.cxb.je(2);
                        }
                        aVar4 = this.cxb.cwT;
                        aVar4.aqx().f(aVar.aqm());
                        nVar2 = this.cxb.cwU;
                        nVar2.notifyDataSetInvalidated();
                    }
                } else {
                    if (aVar == null || aVar.aql() == null || !aVar.aql().isEmpty()) {
                        this.cxb.je(0);
                    } else {
                        this.cxb.je(2);
                    }
                    this.cxb.cwO = aVar.aql();
                    nVar3 = this.cxb.cwU;
                    nVar3.p(this.cxb.cwO);
                    nVar4 = this.cxb.cwU;
                    nVar4.notifyDataSetInvalidated();
                    bdListView = this.cxb.mListView;
                    bdListView.setSelection(0);
                }
            } else {
                return;
            }
        } else {
            this.cxb.showToast(this.ZF.getErrorString());
        }
        super.onPostExecute(aVar);
    }
}
