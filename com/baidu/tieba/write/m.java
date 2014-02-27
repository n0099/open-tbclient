package com.baidu.tieba.write;

import android.widget.EditText;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.widget.ListView.BdListView;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class m extends BdAsyncTask<String, Integer, com.baidu.tieba.data.w> {
    final /* synthetic */ AtListActivity a;
    private com.baidu.tieba.util.ba b;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ com.baidu.tieba.data.w a(String... strArr) {
        return d();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(com.baidu.tieba.data.w wVar) {
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
        com.baidu.tieba.data.w wVar2 = wVar;
        this.a.j = null;
        progressBar = this.a.n;
        progressBar.setVisibility(8);
        if (this.b.c()) {
            cVar = this.a.k;
            cVar.a(wVar2);
            nVar = this.a.l;
            if (nVar == null) {
                return;
            }
            editText = this.a.b;
            if (editText.getText().toString().length() != 0) {
                cVar2 = this.a.k;
                if (cVar2.b() != null) {
                    if (!wVar2.b().isEmpty()) {
                        this.a.a(false);
                    }
                    cVar3 = this.a.k;
                    cVar3.b().a(wVar2.b());
                    nVar2 = this.a.l;
                    nVar2.notifyDataSetInvalidated();
                }
            } else {
                if (wVar2.a().isEmpty()) {
                    this.a.a(true);
                } else {
                    this.a.a(false);
                }
                AtListActivity.a = wVar2.a();
                nVar3 = this.a.l;
                nVar3.a(AtListActivity.a);
                nVar4 = this.a.l;
                nVar4.notifyDataSetInvalidated();
                bdListView = this.a.d;
                bdListView.setSelection(0);
            }
        } else {
            this.a.showToast(this.b.i());
        }
        super.a((m) wVar2);
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
    public final void b() {
        ProgressBar progressBar;
        progressBar = this.a.n;
        progressBar.setVisibility(0);
        super.b();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        ProgressBar progressBar;
        if (this.b != null) {
            this.b.j();
        }
        this.a.j = null;
        progressBar = this.a.n;
        progressBar.setVisibility(8);
        super.cancel(true);
    }

    private com.baidu.tieba.data.w d() {
        this.b = new com.baidu.tieba.util.ba();
        com.baidu.tieba.data.w wVar = null;
        this.b.a(String.valueOf(com.baidu.tieba.data.i.a) + "c/u/follow/list");
        String l = this.b.l();
        if (this.b.c()) {
            wVar = new com.baidu.tieba.data.w();
            try {
                wVar.a(new JSONObject(l), true);
            } catch (Exception e) {
                com.baidu.adp.lib.util.e.b("FriendData", "parserFreindJson", "error = " + e.getMessage());
            }
        }
        return wVar;
    }
}
