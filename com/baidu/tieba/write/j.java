package com.baidu.tieba.write;

import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtListActivity f1903a;
    private com.baidu.tieba.util.u b;

    private j(AtListActivity atListActivity) {
        this.f1903a = atListActivity;
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
        progressBar = this.f1903a.m;
        progressBar.setVisibility(0);
        super.b();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        if (this.b != null) {
            this.b.i();
        }
        this.f1903a.g = null;
        progressBar = this.f1903a.m;
        progressBar.setVisibility(8);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public com.baidu.tieba.data.w a(String... strArr) {
        this.b = new com.baidu.tieba.util.u();
        this.b.a(String.valueOf(com.baidu.tieba.data.g.f1011a) + "c/u/follow/list");
        String k = this.b.k();
        if (!this.b.d()) {
            return null;
        }
        com.baidu.tieba.data.w wVar = new com.baidu.tieba.data.w();
        wVar.a(k);
        return wVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.data.w wVar) {
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
        this.f1903a.g = null;
        progressBar = this.f1903a.m;
        progressBar.setVisibility(8);
        if (this.b.d()) {
            aVar = this.f1903a.j;
            aVar.a(wVar);
            kVar = this.f1903a.k;
            if (kVar != null) {
                editText = this.f1903a.f1854a;
                if (editText.getText().toString().length() != 0) {
                    aVar2 = this.f1903a.j;
                    if (aVar2.b() != null) {
                        aVar3 = this.f1903a.j;
                        aVar3.b().a(wVar.b());
                        kVar2 = this.f1903a.k;
                        kVar2.notifyDataSetInvalidated();
                    }
                } else {
                    kVar3 = this.f1903a.k;
                    kVar3.a(wVar.a());
                    kVar4 = this.f1903a.k;
                    kVar4.notifyDataSetInvalidated();
                    listView = this.f1903a.d;
                    listView.setSelection(0);
                }
            } else {
                return;
            }
        }
        super.a((Object) wVar);
    }
}
