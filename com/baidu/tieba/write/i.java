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

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtListActivity f1587a;
    private com.baidu.tieba.util.r b;
    private String c;

    private i(AtListActivity atListActivity) {
        this.f1587a = atListActivity;
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
        progressBar = this.f1587a.m;
        progressBar.setVisibility(0);
        super.b();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        this.f1587a.f = null;
        this.c = null;
        progressBar = this.f1587a.m;
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
            this.b.a(String.valueOf(com.baidu.tieba.data.g.f787a) + "c/u/follow/sug");
            this.b.a("uid", TiebaApplication.E());
            this.b.a("q", this.c);
            String j = this.b.j();
            if (this.b.c()) {
                com.baidu.tieba.data.ax axVar = new com.baidu.tieba.data.ax();
                aVar = this.f1587a.j;
                com.baidu.tieba.data.s a2 = aVar.a();
                if (a2 != null) {
                    axVar.a(j, a2.b());
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
        progressBar = this.f1587a.m;
        progressBar.setVisibility(8);
        if (this.b.c() && this.c != null) {
            editText = this.f1587a.f1538a;
            if (editText.getText().toString().equals(this.c)) {
                aVar = this.f1587a.j;
                aVar.a(axVar);
                kVar = this.f1587a.k;
                kVar.a(axVar.a());
                kVar2 = this.f1587a.k;
                kVar2.notifyDataSetInvalidated();
                listView = this.f1587a.d;
                listView.setSelection(0);
            }
        }
        super.a((Object) axVar);
    }
}
