package com.baidu.tieba.write;

import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtListActivity f1934a;
    private com.baidu.tieba.util.v b;

    private j(AtListActivity atListActivity) {
        this.f1934a = atListActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ j(AtListActivity atListActivity, j jVar) {
        this(atListActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        ProgressBar progressBar;
        progressBar = this.f1934a.n;
        progressBar.setVisibility(0);
        super.b();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        if (this.b != null) {
            this.b.h();
        }
        this.f1934a.j = null;
        progressBar = this.f1934a.n;
        progressBar.setVisibility(8);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public com.baidu.tieba.data.y a(String... strArr) {
        this.b = new com.baidu.tieba.util.v();
        this.b.a(String.valueOf(com.baidu.tieba.data.g.f1014a) + "c/u/follow/list");
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
        com.baidu.tieba.model.a aVar;
        k kVar;
        EditText editText;
        com.baidu.tieba.model.a aVar2;
        com.baidu.tieba.model.a aVar3;
        k kVar2;
        k kVar3;
        k kVar4;
        ListView listView;
        this.f1934a.j = null;
        progressBar = this.f1934a.n;
        progressBar.setVisibility(8);
        if (this.b.c()) {
            aVar = this.f1934a.k;
            aVar.a(yVar);
            kVar = this.f1934a.l;
            if (kVar != null) {
                editText = this.f1934a.b;
                if (editText.getText().toString().length() != 0) {
                    aVar2 = this.f1934a.k;
                    if (aVar2.b() != null) {
                        if (!yVar.b().isEmpty()) {
                            this.f1934a.a(false);
                        }
                        aVar3 = this.f1934a.k;
                        aVar3.b().a(yVar.b());
                        kVar2 = this.f1934a.l;
                        kVar2.notifyDataSetInvalidated();
                    }
                } else {
                    if (yVar.a().isEmpty()) {
                        this.f1934a.a(true);
                    } else {
                        this.f1934a.a(false);
                    }
                    AtListActivity.f1885a = yVar.a();
                    kVar3 = this.f1934a.l;
                    kVar3.a(AtListActivity.f1885a);
                    kVar4 = this.f1934a.l;
                    kVar4.notifyDataSetInvalidated();
                    listView = this.f1934a.e;
                    listView.setSelection(0);
                }
            } else {
                return;
            }
        } else {
            this.f1934a.a(this.b.g());
        }
        super.a((Object) yVar);
    }
}
