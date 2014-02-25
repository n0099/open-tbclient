package com.baidu.tieba.write;

import android.widget.EditText;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.MetaData;
import java.util.HashMap;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends BdAsyncTask<String, Integer, com.baidu.tieba.data.aw> {
    final /* synthetic */ AtListActivity a;
    private com.baidu.tieba.util.ba b;
    private String c;

    private l(AtListActivity atListActivity) {
        this.a = atListActivity;
        this.b = null;
        this.c = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ l(AtListActivity atListActivity, l lVar) {
        this(atListActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        ProgressBar progressBar;
        progressBar = this.a.n;
        progressBar.setVisibility(0);
        super.b();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        this.a.i = null;
        this.c = null;
        progressBar = this.a.n;
        progressBar.setVisibility(8);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public com.baidu.tieba.data.aw a(String... strArr) {
        com.baidu.tieba.model.c cVar;
        this.c = strArr[0];
        this.b = new com.baidu.tieba.util.ba();
        if (this.c == null || this.c.length() <= 0) {
            return null;
        }
        this.b.a(String.valueOf(com.baidu.tieba.data.i.a) + "c/u/follow/sug");
        this.b.a(SapiAccountManager.SESSION_UID, TiebaApplication.A());
        this.b.a("q", this.c);
        String m = this.b.m();
        if (this.b.d()) {
            com.baidu.tieba.data.aw awVar = new com.baidu.tieba.data.aw();
            cVar = this.a.k;
            com.baidu.tieba.data.w a = cVar.a();
            if (a != null) {
                awVar.a(m, a.b());
            } else {
                awVar.a(m, (HashMap<String, String>) null);
            }
            if (AtListActivity.a != null && AtListActivity.a.size() > 0) {
                Iterator<MetaData> it = awVar.a().iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    Iterator<MetaData> it2 = AtListActivity.a.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            MetaData next2 = it2.next();
                            if (next.getUserName().equals(next2.getUserName())) {
                                next.setUserId(next2.getUserId());
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
        com.baidu.tieba.model.c cVar;
        n nVar;
        n nVar2;
        BdListView bdListView;
        this.a.i = null;
        progressBar = this.a.n;
        progressBar.setVisibility(8);
        if (this.b.d() && this.c != null) {
            editText = this.a.b;
            if (editText.getText().toString().equals(this.c)) {
                if (!awVar.a().isEmpty()) {
                    this.a.a(false);
                }
                cVar = this.a.k;
                cVar.a(awVar);
                nVar = this.a.l;
                nVar.a(awVar.a());
                nVar2 = this.a.l;
                nVar2.notifyDataSetInvalidated();
                bdListView = this.a.d;
                bdListView.setSelection(0);
                super.a((l) awVar);
            }
        }
        this.a.showToast(this.b.j());
        super.a((l) awVar);
    }
}
