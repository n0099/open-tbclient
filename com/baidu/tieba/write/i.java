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
public class i extends BdAsyncTask<String, Integer, com.baidu.tieba.data.ay> {
    final /* synthetic */ AtListActivity a;
    private com.baidu.tieba.util.at b;
    private String c;

    private i(AtListActivity atListActivity) {
        this.a = atListActivity;
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
        progressBar = this.a.k;
        progressBar.setVisibility(0);
        super.b();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        this.a.f = null;
        this.c = null;
        progressBar = this.a.k;
        progressBar.setVisibility(8);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public com.baidu.tieba.data.ay a(String... strArr) {
        com.baidu.tieba.model.d dVar;
        this.c = strArr[0];
        this.b = new com.baidu.tieba.util.at();
        if (this.c == null || this.c.length() <= 0) {
            return null;
        }
        this.b.a(com.baidu.tieba.data.h.a + "c/u/follow/sug");
        this.b.a("uid", TiebaApplication.A());
        this.b.a("q", this.c);
        String l = this.b.l();
        if (this.b.c()) {
            com.baidu.tieba.data.ay ayVar = new com.baidu.tieba.data.ay();
            dVar = this.a.h;
            com.baidu.tieba.data.x a = dVar.a();
            if (a != null) {
                ayVar.a(l, a.b());
            } else {
                ayVar.a(l, (HashMap<String, String>) null);
            }
            if (AtListActivity.a != null && AtListActivity.a.size() > 0) {
                Iterator<MetaData> it = ayVar.a().iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    Iterator<MetaData> it2 = AtListActivity.a.iterator();
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
            return ayVar;
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.data.ay ayVar) {
        ProgressBar progressBar;
        EditText editText;
        com.baidu.tieba.model.d dVar;
        k kVar;
        k kVar2;
        ListView listView;
        progressBar = this.a.k;
        progressBar.setVisibility(8);
        if (this.b.c() && this.c != null) {
            editText = this.a.b;
            if (editText.getText().toString().equals(this.c)) {
                if (!ayVar.a().isEmpty()) {
                    this.a.a(false);
                }
                dVar = this.a.h;
                dVar.a(ayVar);
                kVar = this.a.i;
                kVar.a(ayVar.a());
                kVar2 = this.a.i;
                kVar2.notifyDataSetInvalidated();
                listView = this.a.d;
                listView.setSelection(0);
                super.a((i) ayVar);
            }
        }
        this.a.showToast(this.b.i());
        super.a((i) ayVar);
    }
}
