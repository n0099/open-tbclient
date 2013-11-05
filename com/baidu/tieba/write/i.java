package com.baidu.tieba.write;

import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.MetaData;
import java.util.HashMap;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends BdAsyncTask<String, Integer, com.baidu.tieba.data.bc> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtListActivity f2661a;
    private com.baidu.tieba.util.ag b;
    private String c;

    private i(AtListActivity atListActivity) {
        this.f2661a = atListActivity;
        this.b = null;
        this.c = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ i(AtListActivity atListActivity, a aVar) {
        this(atListActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        ProgressBar progressBar;
        progressBar = this.f2661a.n;
        progressBar.setVisibility(0);
        super.b();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        this.f2661a.g = null;
        this.c = null;
        progressBar = this.f2661a.n;
        progressBar.setVisibility(8);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public com.baidu.tieba.data.bc a(String... strArr) {
        com.baidu.tieba.model.d dVar;
        this.c = strArr[0];
        this.b = new com.baidu.tieba.util.ag();
        if (this.c == null || this.c.length() <= 0) {
            return null;
        }
        this.b.a(com.baidu.tieba.data.h.f1165a + "c/u/follow/sug");
        this.b.a("uid", TiebaApplication.C());
        this.b.a("q", this.c);
        String j = this.b.j();
        if (this.b.c()) {
            com.baidu.tieba.data.bc bcVar = new com.baidu.tieba.data.bc();
            dVar = this.f2661a.k;
            com.baidu.tieba.data.y a2 = dVar.a();
            if (a2 != null) {
                bcVar.a(j, a2.b());
            } else {
                bcVar.a(j, (HashMap<String, String>) null);
            }
            if (AtListActivity.f2606a != null && AtListActivity.f2606a.size() > 0) {
                Iterator<MetaData> it = bcVar.a().iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    Iterator<MetaData> it2 = AtListActivity.f2606a.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            MetaData next2 = it2.next();
                            if (next.getName().equals(next2.getName())) {
                                next.setId(next2.getId());
                                next.setName_show(next2.getName_show());
                                break;
                            }
                        }
                    }
                }
            }
            return bcVar;
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.data.bc bcVar) {
        ProgressBar progressBar;
        EditText editText;
        com.baidu.tieba.model.d dVar;
        k kVar;
        k kVar2;
        ListView listView;
        progressBar = this.f2661a.n;
        progressBar.setVisibility(8);
        if (this.b.c() && this.c != null) {
            editText = this.f2661a.b;
            if (editText.getText().toString().equals(this.c)) {
                if (!bcVar.a().isEmpty()) {
                    this.f2661a.a(false);
                }
                dVar = this.f2661a.k;
                dVar.a(bcVar);
                kVar = this.f2661a.l;
                kVar.a(bcVar.a());
                kVar2 = this.f2661a.l;
                kVar2.notifyDataSetInvalidated();
                listView = this.f2661a.e;
                listView.setSelection(0);
                super.a((i) bcVar);
            }
        }
        this.f2661a.a(this.b.g());
        super.a((i) bcVar);
    }
}
