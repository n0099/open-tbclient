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
public class i extends BdAsyncTask<String, Integer, com.baidu.tieba.data.aw> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtListActivity f2811a;
    private com.baidu.tieba.util.am b;
    private String c;

    private i(AtListActivity atListActivity) {
        this.f2811a = atListActivity;
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
        progressBar = this.f2811a.k;
        progressBar.setVisibility(0);
        super.b();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        this.f2811a.f = null;
        this.c = null;
        progressBar = this.f2811a.k;
        progressBar.setVisibility(8);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public com.baidu.tieba.data.aw a(String... strArr) {
        com.baidu.tieba.model.d dVar;
        this.c = strArr[0];
        this.b = new com.baidu.tieba.util.am();
        if (this.c == null || this.c.length() <= 0) {
            return null;
        }
        this.b.a(com.baidu.tieba.data.h.f1248a + "c/u/follow/sug");
        this.b.a("uid", TiebaApplication.B());
        this.b.a("q", this.c);
        String l = this.b.l();
        if (this.b.c()) {
            com.baidu.tieba.data.aw awVar = new com.baidu.tieba.data.aw();
            dVar = this.f2811a.h;
            com.baidu.tieba.data.x a2 = dVar.a();
            if (a2 != null) {
                awVar.a(l, a2.b());
            } else {
                awVar.a(l, (HashMap<String, String>) null);
            }
            if (AtListActivity.f2759a != null && AtListActivity.f2759a.size() > 0) {
                Iterator<MetaData> it = awVar.a().iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    Iterator<MetaData> it2 = AtListActivity.f2759a.iterator();
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
            return awVar;
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.data.aw awVar) {
        ProgressBar progressBar;
        EditText editText;
        com.baidu.tieba.model.d dVar;
        k kVar;
        k kVar2;
        ListView listView;
        progressBar = this.f2811a.k;
        progressBar.setVisibility(8);
        if (this.b.c() && this.c != null) {
            editText = this.f2811a.b;
            if (editText.getText().toString().equals(this.c)) {
                if (!awVar.a().isEmpty()) {
                    this.f2811a.a(false);
                }
                dVar = this.f2811a.h;
                dVar.a(awVar);
                kVar = this.f2811a.i;
                kVar.a(awVar.a());
                kVar2 = this.f2811a.i;
                kVar2.notifyDataSetInvalidated();
                listView = this.f2811a.d;
                listView.setSelection(0);
                super.a((i) awVar);
            }
        }
        this.f2811a.showToast(this.b.i());
        super.a((i) awVar);
    }
}
