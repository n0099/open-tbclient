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
    final /* synthetic */ AtListActivity f2693a;
    private com.baidu.tieba.util.ap b;
    private String c;

    private i(AtListActivity atListActivity) {
        this.f2693a = atListActivity;
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
        progressBar = this.f2693a.k;
        progressBar.setVisibility(0);
        super.b();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        this.f2693a.f = null;
        this.c = null;
        progressBar = this.f2693a.k;
        progressBar.setVisibility(8);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public com.baidu.tieba.data.aw a(String... strArr) {
        com.baidu.tieba.model.d dVar;
        this.c = strArr[0];
        this.b = new com.baidu.tieba.util.ap();
        if (this.c == null || this.c.length() <= 0) {
            return null;
        }
        this.b.a(com.baidu.tieba.data.h.f1201a + "c/u/follow/sug");
        this.b.a("uid", TiebaApplication.A());
        this.b.a("q", this.c);
        String j = this.b.j();
        if (this.b.c()) {
            com.baidu.tieba.data.aw awVar = new com.baidu.tieba.data.aw();
            dVar = this.f2693a.h;
            com.baidu.tieba.data.x a2 = dVar.a();
            if (a2 != null) {
                awVar.a(j, a2.b());
            } else {
                awVar.a(j, (HashMap<String, String>) null);
            }
            if (AtListActivity.f2641a != null && AtListActivity.f2641a.size() > 0) {
                Iterator<MetaData> it = awVar.a().iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    Iterator<MetaData> it2 = AtListActivity.f2641a.iterator();
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
        progressBar = this.f2693a.k;
        progressBar.setVisibility(8);
        if (this.b.c() && this.c != null) {
            editText = this.f2693a.b;
            if (editText.getText().toString().equals(this.c)) {
                if (!awVar.a().isEmpty()) {
                    this.f2693a.a(false);
                }
                dVar = this.f2693a.h;
                dVar.a(awVar);
                kVar = this.f2693a.i;
                kVar.a(awVar.a());
                kVar2 = this.f2693a.i;
                kVar2.notifyDataSetInvalidated();
                listView = this.f2693a.d;
                listView.setSelection(0);
                super.a((i) awVar);
            }
        }
        this.f2693a.showToast(this.b.g());
        super.a((i) awVar);
    }
}
