package com.baidu.tieba.write;

import android.widget.EditText;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends BdAsyncTask<String, Integer, com.baidu.tieba.data.r> {
    final /* synthetic */ AtListActivity a;
    private com.baidu.tbadk.core.util.al b;

    private m(AtListActivity atListActivity) {
        this.a = atListActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ m(AtListActivity atListActivity, m mVar) {
        this(atListActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ProgressBar progressBar;
        progressBar = this.a.n;
        progressBar.setVisibility(0);
        super.onPreExecute();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        if (this.b != null) {
            this.b.g();
        }
        this.a.j = null;
        progressBar = this.a.n;
        progressBar.setVisibility(8);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public com.baidu.tieba.data.r doInBackground(String... strArr) {
        this.b = new com.baidu.tbadk.core.util.al();
        this.b.a(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/follow/list");
        String i = this.b.i();
        if (!this.b.a().b().b()) {
            return null;
        }
        com.baidu.tieba.data.r rVar = new com.baidu.tieba.data.r();
        rVar.a(i);
        return rVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.data.r rVar) {
        ProgressBar progressBar;
        com.baidu.tieba.model.c cVar;
        n nVar;
        EditText editText;
        com.baidu.tieba.model.c cVar2;
        com.baidu.tieba.model.c cVar3;
        n nVar2;
        n nVar3;
        n nVar4;
        BdListView bdListView;
        this.a.j = null;
        progressBar = this.a.n;
        progressBar.setVisibility(8);
        if (this.b.a().b().b()) {
            cVar = this.a.k;
            cVar.a(rVar);
            nVar = this.a.l;
            if (nVar != null) {
                editText = this.a.b;
                if (editText.getText().toString().length() != 0) {
                    cVar2 = this.a.k;
                    if (cVar2.b() != null) {
                        if (!rVar.b().isEmpty()) {
                            this.a.a(false);
                        }
                        cVar3 = this.a.k;
                        cVar3.b().a(rVar.b());
                        nVar2 = this.a.l;
                        nVar2.notifyDataSetInvalidated();
                    }
                } else {
                    if (rVar.a().isEmpty()) {
                        this.a.a(true);
                    } else {
                        this.a.a(false);
                    }
                    AtListActivity.a = rVar.a();
                    nVar3 = this.a.l;
                    nVar3.a(AtListActivity.a);
                    nVar4 = this.a.l;
                    nVar4.notifyDataSetInvalidated();
                    bdListView = this.a.d;
                    bdListView.setSelection(0);
                }
            } else {
                return;
            }
        } else {
            this.a.showToast(this.b.f());
        }
        super.onPostExecute(rVar);
    }
}
