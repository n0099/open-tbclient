package com.baidu.tieba.write;

import android.widget.EditText;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.MetaData;
import java.util.HashMap;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class l extends BdAsyncTask<String, Integer, com.baidu.tieba.data.ao> {
    final /* synthetic */ AtListActivity a;
    private com.baidu.tbadk.core.util.ak b;
    private String c;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(com.baidu.tieba.data.ao aoVar) {
        ProgressBar progressBar;
        EditText editText;
        com.baidu.tieba.model.c cVar;
        n nVar;
        n nVar2;
        BdListView bdListView;
        com.baidu.tieba.data.ao aoVar2 = aoVar;
        this.a.i = null;
        progressBar = this.a.n;
        progressBar.setVisibility(8);
        if (this.b.a().b().b() && this.c != null) {
            editText = this.a.b;
            if (editText.getText().toString().equals(this.c)) {
                if (!aoVar2.a().isEmpty()) {
                    AtListActivity.a(this.a, false);
                }
                cVar = this.a.k;
                cVar.a(aoVar2);
                nVar = this.a.l;
                nVar.a(aoVar2.a());
                nVar2 = this.a.l;
                nVar2.notifyDataSetInvalidated();
                bdListView = this.a.d;
                bdListView.setSelection(0);
                super.a((l) aoVar2);
            }
        }
        this.a.showToast(this.b.f());
        super.a((l) aoVar2);
    }

    private l(AtListActivity atListActivity) {
        this.a = atListActivity;
        this.b = null;
        this.c = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ l(AtListActivity atListActivity, byte b) {
        this(atListActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void c() {
        ProgressBar progressBar;
        progressBar = this.a.n;
        progressBar.setVisibility(0);
        super.c();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        ProgressBar progressBar;
        this.a.i = null;
        this.c = null;
        progressBar = this.a.n;
        progressBar.setVisibility(8);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public com.baidu.tieba.data.ao a(String... strArr) {
        com.baidu.tieba.model.c cVar;
        this.c = strArr[0];
        this.b = new com.baidu.tbadk.core.util.ak();
        if (this.c == null || this.c.length() <= 0) {
            return null;
        }
        this.b.a(String.valueOf(com.baidu.tbadk.core.data.n.a) + "c/u/follow/sug");
        this.b.a("uid", TbadkApplication.E());
        this.b.a("q", this.c);
        String i = this.b.i();
        if (this.b.a().b().b()) {
            com.baidu.tieba.data.ao aoVar = new com.baidu.tieba.data.ao();
            cVar = this.a.k;
            com.baidu.tieba.data.r a = cVar.a();
            if (a != null) {
                aoVar.a(i, a.b());
            } else {
                aoVar.a(i, (HashMap<String, String>) null);
            }
            if (AtListActivity.a != null && AtListActivity.a.size() > 0) {
                Iterator<MetaData> it = aoVar.a().iterator();
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
            return aoVar;
        }
        return null;
    }
}
