package com.baidu.tieba.write;

import android.widget.EditText;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends BdAsyncTask<String, Integer, com.baidu.tieba.data.w> {
    final /* synthetic */ AtListActivity a;
    private com.baidu.tieba.util.ba b;

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
    public void b() {
        ProgressBar progressBar;
        progressBar = this.a.n;
        progressBar.setVisibility(0);
        super.b();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        if (this.b != null) {
            this.b.k();
        }
        this.a.j = null;
        progressBar = this.a.n;
        progressBar.setVisibility(8);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public com.baidu.tieba.data.w a(String... strArr) {
        this.b = new com.baidu.tieba.util.ba();
        this.b.a(String.valueOf(com.baidu.tieba.data.i.a) + "c/u/follow/list");
        String m = this.b.m();
        if (!this.b.d()) {
            return null;
        }
        com.baidu.tieba.data.w wVar = new com.baidu.tieba.data.w();
        wVar.a(m);
        return wVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.data.w wVar) {
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
        if (this.b.d()) {
            cVar = this.a.k;
            cVar.a(wVar);
            nVar = this.a.l;
            if (nVar != null) {
                editText = this.a.b;
                if (editText.getText().toString().length() != 0) {
                    cVar2 = this.a.k;
                    if (cVar2.b() != null) {
                        if (!wVar.b().isEmpty()) {
                            this.a.a(false);
                        }
                        cVar3 = this.a.k;
                        cVar3.b().a(wVar.b());
                        nVar2 = this.a.l;
                        nVar2.notifyDataSetInvalidated();
                    }
                } else {
                    if (wVar.a().isEmpty()) {
                        this.a.a(true);
                    } else {
                        this.a.a(false);
                    }
                    AtListActivity.a = wVar.a();
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
            this.a.showToast(this.b.j());
        }
        super.a((m) wVar);
    }
}
