package com.baidu.tieba.write;

import android.widget.EditText;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.widget.ListView.BdListView;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class m extends BdAsyncTask<String, Integer, com.baidu.tieba.data.r> {
    final /* synthetic */ AtListActivity a;
    private com.baidu.tbadk.core.util.ak b;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ com.baidu.tieba.data.r a(String... strArr) {
        return a();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(com.baidu.tieba.data.r rVar) {
        ProgressBar progressBar;
        com.baidu.tieba.model.c cVar;
        n nVar;
        EditText editText;
        com.baidu.tieba.model.c cVar2;
        com.baidu.tieba.model.c cVar3;
        n nVar2;
        n nVar3;
        n nVar4;
        BdListView bdListView;
        com.baidu.tieba.data.r rVar2 = rVar;
        this.a.j = null;
        progressBar = this.a.n;
        progressBar.setVisibility(8);
        if (this.b.a().b().b()) {
            cVar = this.a.k;
            cVar.a(rVar2);
            nVar = this.a.l;
            if (nVar == null) {
                return;
            }
            editText = this.a.b;
            if (editText.getText().toString().length() != 0) {
                cVar2 = this.a.k;
                if (cVar2.b() != null) {
                    if (!rVar2.b().isEmpty()) {
                        AtListActivity.a(this.a, false);
                    }
                    cVar3 = this.a.k;
                    cVar3.b().a(rVar2.b());
                    nVar2 = this.a.l;
                    nVar2.notifyDataSetInvalidated();
                }
            } else {
                if (rVar2.a().isEmpty()) {
                    AtListActivity.a(this.a, true);
                } else {
                    AtListActivity.a(this.a, false);
                }
                AtListActivity.a = rVar2.a();
                nVar3 = this.a.l;
                nVar3.a(AtListActivity.a);
                nVar4 = this.a.l;
                nVar4.notifyDataSetInvalidated();
                bdListView = this.a.d;
                bdListView.setSelection(0);
            }
        } else {
            this.a.showToast(this.b.f());
        }
        super.a((m) rVar2);
    }

    private m(AtListActivity atListActivity) {
        this.a = atListActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ m(AtListActivity atListActivity, byte b) {
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
        if (this.b != null) {
            this.b.g();
        }
        this.a.j = null;
        progressBar = this.a.n;
        progressBar.setVisibility(8);
        super.cancel(true);
    }

    private com.baidu.tieba.data.r a() {
        this.b = new com.baidu.tbadk.core.util.ak();
        com.baidu.tieba.data.r rVar = null;
        this.b.a(String.valueOf(com.baidu.tbadk.core.data.n.a) + "c/u/follow/list");
        String i = this.b.i();
        if (this.b.a().b().b()) {
            rVar = new com.baidu.tieba.data.r();
            try {
                rVar.a(new JSONObject(i), true);
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b("FriendData", "parserFreindJson", "error = " + e.getMessage());
            }
        }
        return rVar;
    }
}
