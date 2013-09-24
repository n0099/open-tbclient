package com.baidu.tieba.write;

import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends BdAsyncTask<String, Integer, com.baidu.tieba.data.y> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtListActivity f2117a;
    private com.baidu.tieba.util.z b;

    private j(AtListActivity atListActivity) {
        this.f2117a = atListActivity;
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
        progressBar = this.f2117a.n;
        progressBar.setVisibility(0);
        super.b();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        if (this.b != null) {
            this.b.h();
        }
        this.f2117a.j = null;
        progressBar = this.f2117a.n;
        progressBar.setVisibility(8);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public com.baidu.tieba.data.y a(String... strArr) {
        this.b = new com.baidu.tieba.util.z();
        this.b.a(String.valueOf(com.baidu.tieba.data.g.f1032a) + "c/u/follow/list");
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
        com.baidu.tieba.model.c cVar;
        k kVar;
        EditText editText;
        com.baidu.tieba.model.c cVar2;
        com.baidu.tieba.model.c cVar3;
        k kVar2;
        k kVar3;
        k kVar4;
        ListView listView;
        this.f2117a.j = null;
        progressBar = this.f2117a.n;
        progressBar.setVisibility(8);
        if (this.b.c()) {
            cVar = this.f2117a.k;
            cVar.a(yVar);
            kVar = this.f2117a.l;
            if (kVar != null) {
                editText = this.f2117a.b;
                if (editText.getText().toString().length() != 0) {
                    cVar2 = this.f2117a.k;
                    if (cVar2.b() != null) {
                        if (!yVar.b().isEmpty()) {
                            this.f2117a.a(false);
                        }
                        cVar3 = this.f2117a.k;
                        cVar3.b().a(yVar.b());
                        kVar2 = this.f2117a.l;
                        kVar2.notifyDataSetInvalidated();
                    }
                } else {
                    if (yVar.a().isEmpty()) {
                        this.f2117a.a(true);
                    } else {
                        this.f2117a.a(false);
                    }
                    AtListActivity.f2062a = yVar.a();
                    kVar3 = this.f2117a.l;
                    kVar3.a(AtListActivity.f2062a);
                    kVar4 = this.f2117a.l;
                    kVar4.notifyDataSetInvalidated();
                    listView = this.f2117a.e;
                    listView.setSelection(0);
                }
            } else {
                return;
            }
        } else {
            this.f2117a.a(this.b.g());
        }
        super.a((j) yVar);
    }
}
