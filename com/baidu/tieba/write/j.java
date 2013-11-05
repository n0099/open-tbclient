package com.baidu.tieba.write;

import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends BdAsyncTask<String, Integer, com.baidu.tieba.data.y> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtListActivity f2662a;
    private com.baidu.tieba.util.ag b;

    private j(AtListActivity atListActivity) {
        this.f2662a = atListActivity;
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
        progressBar = this.f2662a.n;
        progressBar.setVisibility(0);
        super.b();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        if (this.b != null) {
            this.b.h();
        }
        this.f2662a.j = null;
        progressBar = this.f2662a.n;
        progressBar.setVisibility(8);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public com.baidu.tieba.data.y a(String... strArr) {
        this.b = new com.baidu.tieba.util.ag();
        this.b.a(com.baidu.tieba.data.h.f1165a + "c/u/follow/list");
        String j = this.b.j();
        if (!this.b.c()) {
            return null;
        }
        com.baidu.tieba.data.y yVar = new com.baidu.tieba.data.y();
        yVar.a(j);
        return yVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.data.y yVar) {
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
        this.f2662a.j = null;
        progressBar = this.f2662a.n;
        progressBar.setVisibility(8);
        if (this.b.c()) {
            dVar = this.f2662a.k;
            dVar.a(yVar);
            kVar = this.f2662a.l;
            if (kVar != null) {
                editText = this.f2662a.b;
                if (editText.getText().toString().length() != 0) {
                    dVar2 = this.f2662a.k;
                    if (dVar2.b() != null) {
                        if (!yVar.b().isEmpty()) {
                            this.f2662a.a(false);
                        }
                        dVar3 = this.f2662a.k;
                        dVar3.b().a(yVar.b());
                        kVar2 = this.f2662a.l;
                        kVar2.notifyDataSetInvalidated();
                    }
                } else {
                    if (yVar.a().isEmpty()) {
                        this.f2662a.a(true);
                    } else {
                        this.f2662a.a(false);
                    }
                    AtListActivity.f2606a = yVar.a();
                    kVar3 = this.f2662a.l;
                    kVar3.a(AtListActivity.f2606a);
                    kVar4 = this.f2662a.l;
                    kVar4.notifyDataSetInvalidated();
                    listView = this.f2662a.e;
                    listView.setSelection(0);
                }
            } else {
                return;
            }
        } else {
            this.f2662a.a(this.b.g());
        }
        super.a((j) yVar);
    }
}
