package com.baidu.tieba.write;

import android.widget.EditText;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends BdAsyncTask<String, Integer, com.baidu.tieba.data.r> {
    final /* synthetic */ AtListActivity a;
    private com.baidu.tbadk.core.util.ae b;

    private i(AtListActivity atListActivity) {
        this.a = atListActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ i(AtListActivity atListActivity, i iVar) {
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
            this.b.f();
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
        this.b = new com.baidu.tbadk.core.util.ae();
        this.b.a(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/follow/list");
        String h = this.b.h();
        if (!this.b.a().b().b()) {
            return null;
        }
        com.baidu.tieba.data.r rVar = new com.baidu.tieba.data.r();
        rVar.a(h);
        return rVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.data.r rVar) {
        ProgressBar progressBar;
        com.baidu.tieba.model.c cVar;
        j jVar;
        EditText editText;
        com.baidu.tieba.model.c cVar2;
        com.baidu.tieba.model.c cVar3;
        j jVar2;
        j jVar3;
        j jVar4;
        BdListView bdListView;
        this.a.j = null;
        progressBar = this.a.n;
        progressBar.setVisibility(8);
        if (this.b.a().b().b()) {
            cVar = this.a.k;
            cVar.a(rVar);
            jVar = this.a.l;
            if (jVar != null) {
                editText = this.a.b;
                if (com.baidu.adp.lib.util.i.a(editText.getText(), "").length() != 0) {
                    cVar2 = this.a.k;
                    if (cVar2.b() != null) {
                        if (!rVar.b().isEmpty()) {
                            this.a.a(false);
                        }
                        cVar3 = this.a.k;
                        cVar3.b().a(rVar.b());
                        jVar2 = this.a.l;
                        jVar2.notifyDataSetInvalidated();
                    }
                } else {
                    if (rVar.a().isEmpty()) {
                        this.a.a(true);
                    } else {
                        this.a.a(false);
                    }
                    this.a.a = rVar.a();
                    jVar3 = this.a.l;
                    jVar3.a(this.a.a);
                    jVar4 = this.a.l;
                    jVar4.notifyDataSetInvalidated();
                    bdListView = this.a.d;
                    bdListView.setSelection(0);
                }
            } else {
                return;
            }
        } else {
            this.a.showToast(this.b.e());
        }
        super.onPostExecute(rVar);
    }
}
