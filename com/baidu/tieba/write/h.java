package com.baidu.tieba.write;

import android.widget.EditText;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends BdAsyncTask<String, Integer, com.baidu.tieba.data.av> {
    final /* synthetic */ AtListActivity a;
    private com.baidu.tbadk.core.util.ae b;
    private String c;

    private h(AtListActivity atListActivity) {
        this.a = atListActivity;
        this.b = null;
        this.c = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ h(AtListActivity atListActivity, h hVar) {
        this(atListActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ProgressBar progressBar;
        progressBar = this.a.n;
        progressBar.setVisibility(0);
        super.onPreExecute();
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
    /* renamed from: a */
    public com.baidu.tieba.data.av doInBackground(String... strArr) {
        com.baidu.tieba.model.c cVar;
        this.c = strArr[0];
        this.b = new com.baidu.tbadk.core.util.ae();
        if (this.c != null && this.c.length() > 0) {
            this.b.a(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/follow/sug");
            this.b.a(SapiAccountManager.SESSION_UID, TbadkApplication.getCurrentAccount());
            this.b.a("q", this.c);
            String h = this.b.h();
            if (this.b.a().b().b()) {
                com.baidu.tieba.data.av avVar = new com.baidu.tieba.data.av();
                cVar = this.a.k;
                com.baidu.tieba.data.r a = cVar.a();
                if (a != null) {
                    avVar.a(h, a.b());
                    return avVar;
                }
                avVar.a(h, (HashMap<String, String>) null);
                return avVar;
            }
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.data.av avVar) {
        ProgressBar progressBar;
        EditText editText;
        com.baidu.tieba.model.c cVar;
        j jVar;
        j jVar2;
        BdListView bdListView;
        this.a.i = null;
        progressBar = this.a.n;
        progressBar.setVisibility(8);
        if (this.b.a().b().b() && this.c != null) {
            editText = this.a.b;
            if (com.baidu.adp.lib.util.i.a(editText.getText(), "").equals(this.c)) {
                if (!avVar.a().isEmpty()) {
                    this.a.a(false);
                }
                cVar = this.a.k;
                cVar.a(avVar);
                jVar = this.a.l;
                jVar.a(avVar.a());
                jVar2 = this.a.l;
                jVar2.notifyDataSetInvalidated();
                bdListView = this.a.d;
                bdListView.setSelection(0);
                super.onPostExecute(avVar);
            }
        }
        this.a.showToast(this.b.e());
        super.onPostExecute(avVar);
    }
}
