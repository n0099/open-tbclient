package com.baidu.tieba.write;

import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends BdAsyncTask<String, Integer, com.baidu.tieba.data.x> {
    final /* synthetic */ AtListActivity a;
    private com.baidu.tieba.util.ax b;

    private j(AtListActivity atListActivity) {
        this.a = atListActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ j(AtListActivity atListActivity, a aVar) {
        this(atListActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        ProgressBar progressBar;
        progressBar = this.a.k;
        progressBar.setVisibility(0);
        super.b();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        if (this.b != null) {
            this.b.k();
        }
        this.a.g = null;
        progressBar = this.a.k;
        progressBar.setVisibility(8);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public com.baidu.tieba.data.x a(String... strArr) {
        this.b = new com.baidu.tieba.util.ax();
        this.b.a(com.baidu.tieba.data.h.a + "c/u/follow/list");
        String m = this.b.m();
        if (!this.b.d()) {
            return null;
        }
        com.baidu.tieba.data.x xVar = new com.baidu.tieba.data.x();
        xVar.a(m);
        return xVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.data.x xVar) {
        ProgressBar progressBar;
        com.baidu.tieba.model.d dVar;
        k kVar;
        EditText editText;
        com.baidu.tieba.model.d dVar2;
        com.baidu.tieba.model.d dVar3;
        k kVar2;
        k kVar3;
        k kVar4;
        ListView listView;
        this.a.g = null;
        progressBar = this.a.k;
        progressBar.setVisibility(8);
        if (this.b.d()) {
            dVar = this.a.h;
            dVar.a(xVar);
            kVar = this.a.i;
            if (kVar != null) {
                editText = this.a.b;
                if (editText.getText().toString().length() != 0) {
                    dVar2 = this.a.h;
                    if (dVar2.b() != null) {
                        if (!xVar.b().isEmpty()) {
                            this.a.a(false);
                        }
                        dVar3 = this.a.h;
                        dVar3.b().a(xVar.b());
                        kVar2 = this.a.i;
                        kVar2.notifyDataSetInvalidated();
                    }
                } else {
                    if (xVar.a().isEmpty()) {
                        this.a.a(true);
                    } else {
                        this.a.a(false);
                    }
                    AtListActivity.a = xVar.a();
                    kVar3 = this.a.i;
                    kVar3.a(AtListActivity.a);
                    kVar4 = this.a.i;
                    kVar4.notifyDataSetInvalidated();
                    listView = this.a.d;
                    listView.setSelection(0);
                }
            } else {
                return;
            }
        } else {
            this.a.showToast(this.b.j());
        }
        super.a((j) xVar);
    }
}
