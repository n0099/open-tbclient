package com.baidu.tieba.write;

import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends BdAsyncTask {
    final /* synthetic */ AtListActivity a;
    private com.baidu.tieba.util.r b;
    private String c;

    private i(AtListActivity atListActivity) {
        this.a = atListActivity;
        this.b = null;
        this.c = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ i(AtListActivity atListActivity, i iVar) {
        this(atListActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        ProgressBar progressBar;
        progressBar = this.a.m;
        progressBar.setVisibility(0);
        super.b();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        this.a.f = null;
        this.c = null;
        progressBar = this.a.m;
        progressBar.setVisibility(8);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public com.baidu.tieba.data.ax a(String... strArr) {
        com.baidu.tieba.model.a aVar;
        this.c = strArr[0];
        this.b = new com.baidu.tieba.util.r();
        if (this.c != null && this.c.length() > 0) {
            this.b.a(String.valueOf(com.baidu.tieba.data.g.a) + "c/u/follow/sug");
            this.b.a("uid", TiebaApplication.E());
            this.b.a("q", this.c);
            String j = this.b.j();
            if (this.b.c()) {
                com.baidu.tieba.data.ax axVar = new com.baidu.tieba.data.ax();
                aVar = this.a.j;
                com.baidu.tieba.data.s a = aVar.a();
                if (a != null) {
                    axVar.a(j, a.b());
                    return axVar;
                }
                axVar.a(j, (HashMap) null);
                return axVar;
            }
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.data.ax axVar) {
        ProgressBar progressBar;
        EditText editText;
        com.baidu.tieba.model.a aVar;
        k kVar;
        k kVar2;
        ListView listView;
        progressBar = this.a.m;
        progressBar.setVisibility(8);
        if (this.b.c() && this.c != null) {
            editText = this.a.a;
            if (editText.getText().toString().equals(this.c)) {
                aVar = this.a.j;
                aVar.a(axVar);
                kVar = this.a.k;
                kVar.a(axVar.a());
                kVar2 = this.a.k;
                kVar2.notifyDataSetInvalidated();
                listView = this.a.d;
                listView.setSelection(0);
            }
        }
        super.a((Object) axVar);
    }
}
