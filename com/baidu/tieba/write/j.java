package com.baidu.tieba.write;

import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends BdAsyncTask<String, Integer, com.baidu.tieba.data.x> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtListActivity f2710a;
    private com.baidu.tieba.util.ap b;

    private j(AtListActivity atListActivity) {
        this.f2710a = atListActivity;
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
        progressBar = this.f2710a.k;
        progressBar.setVisibility(0);
        super.b();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        if (this.b != null) {
            this.b.h();
        }
        this.f2710a.g = null;
        progressBar = this.f2710a.k;
        progressBar.setVisibility(8);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public com.baidu.tieba.data.x a(String... strArr) {
        this.b = new com.baidu.tieba.util.ap();
        this.b.a(com.baidu.tieba.data.h.f1196a + "c/u/follow/list");
        String j = this.b.j();
        if (!this.b.c()) {
            return null;
        }
        com.baidu.tieba.data.x xVar = new com.baidu.tieba.data.x();
        xVar.a(j);
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
        this.f2710a.g = null;
        progressBar = this.f2710a.k;
        progressBar.setVisibility(8);
        if (this.b.c()) {
            dVar = this.f2710a.h;
            dVar.a(xVar);
            kVar = this.f2710a.i;
            if (kVar != null) {
                editText = this.f2710a.b;
                if (editText.getText().toString().length() != 0) {
                    dVar2 = this.f2710a.h;
                    if (dVar2.b() != null) {
                        if (!xVar.b().isEmpty()) {
                            this.f2710a.a(false);
                        }
                        dVar3 = this.f2710a.h;
                        dVar3.b().a(xVar.b());
                        kVar2 = this.f2710a.i;
                        kVar2.notifyDataSetInvalidated();
                    }
                } else {
                    if (xVar.a().isEmpty()) {
                        this.f2710a.a(true);
                    } else {
                        this.f2710a.a(false);
                    }
                    AtListActivity.f2658a = xVar.a();
                    kVar3 = this.f2710a.i;
                    kVar3.a(AtListActivity.f2658a);
                    kVar4 = this.f2710a.i;
                    kVar4.notifyDataSetInvalidated();
                    listView = this.f2710a.d;
                    listView.setSelection(0);
                }
            } else {
                return;
            }
        } else {
            this.f2710a.showToast(this.b.g());
        }
        super.a((j) xVar);
    }
}
