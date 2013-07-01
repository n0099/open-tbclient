package com.baidu.tieba.write;

import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtListActivity f1588a;
    private com.baidu.tieba.util.r b;

    private j(AtListActivity atListActivity) {
        this.f1588a = atListActivity;
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
        progressBar = this.f1588a.m;
        progressBar.setVisibility(0);
        super.b();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        if (this.b != null) {
            this.b.h();
        }
        this.f1588a.g = null;
        progressBar = this.f1588a.m;
        progressBar.setVisibility(8);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public com.baidu.tieba.data.s a(String... strArr) {
        this.b = new com.baidu.tieba.util.r();
        this.b.a(String.valueOf(com.baidu.tieba.data.g.f787a) + "c/u/follow/list");
        String j = this.b.j();
        if (!this.b.c()) {
            return null;
        }
        com.baidu.tieba.data.s sVar = new com.baidu.tieba.data.s();
        sVar.a(j);
        return sVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.data.s sVar) {
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
        this.f1588a.g = null;
        progressBar = this.f1588a.m;
        progressBar.setVisibility(8);
        if (this.b.c()) {
            aVar = this.f1588a.j;
            aVar.a(sVar);
            kVar = this.f1588a.k;
            if (kVar != null) {
                editText = this.f1588a.f1538a;
                if (editText.getText().toString().length() != 0) {
                    aVar2 = this.f1588a.j;
                    if (aVar2.b() != null) {
                        aVar3 = this.f1588a.j;
                        aVar3.b().a(sVar.b());
                        kVar2 = this.f1588a.k;
                        kVar2.notifyDataSetInvalidated();
                    }
                } else {
                    kVar3 = this.f1588a.k;
                    kVar3.a(sVar.a());
                    kVar4 = this.f1588a.k;
                    kVar4.notifyDataSetInvalidated();
                    listView = this.f1588a.d;
                    listView.setSelection(0);
                }
            } else {
                return;
            }
        }
        super.a((Object) sVar);
    }
}
