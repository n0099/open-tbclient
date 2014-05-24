package com.baidu.tieba.write;

import android.widget.EditText;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.MetaData;
import java.util.HashMap;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends BdAsyncTask<String, Integer, com.baidu.tieba.data.aq> {
    final /* synthetic */ AtListActivity a;
    private com.baidu.tbadk.core.util.al b;
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
    public com.baidu.tieba.data.aq doInBackground(String... strArr) {
        com.baidu.tieba.model.c cVar;
        this.c = strArr[0];
        this.b = new com.baidu.tbadk.core.util.al();
        if (this.c == null || this.c.length() <= 0) {
            return null;
        }
        this.b.a(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/u/follow/sug");
        this.b.a(SapiAccountManager.SESSION_UID, TbadkApplication.getCurrentAccount());
        this.b.a("q", this.c);
        String i = this.b.i();
        if (this.b.a().b().b()) {
            com.baidu.tieba.data.aq aqVar = new com.baidu.tieba.data.aq();
            cVar = this.a.k;
            com.baidu.tieba.data.r a = cVar.a();
            if (a != null) {
                aqVar.a(i, a.b());
            } else {
                aqVar.a(i, (HashMap<String, String>) null);
            }
            if (AtListActivity.a != null && AtListActivity.a.size() > 0) {
                Iterator<MetaData> it = aqVar.a().iterator();
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
            return aqVar;
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.data.aq aqVar) {
        ProgressBar progressBar;
        EditText editText;
        com.baidu.tieba.model.c cVar;
        n nVar;
        n nVar2;
        BdListView bdListView;
        this.a.i = null;
        progressBar = this.a.n;
        progressBar.setVisibility(8);
        if (this.b.a().b().b() && this.c != null) {
            editText = this.a.b;
            if (editText.getText().toString().equals(this.c)) {
                if (!aqVar.a().isEmpty()) {
                    this.a.a(false);
                }
                cVar = this.a.k;
                cVar.a(aqVar);
                nVar = this.a.l;
                nVar.a(aqVar.a());
                nVar2 = this.a.l;
                nVar2.notifyDataSetInvalidated();
                bdListView = this.a.d;
                bdListView.setSelection(0);
                super.onPostExecute(aqVar);
            }
        }
        this.a.showToast(this.b.f());
        super.onPostExecute(aqVar);
    }
}
