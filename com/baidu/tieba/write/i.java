package com.baidu.tieba.write;

import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.bi;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtListActivity f1902a;
    private com.baidu.tieba.util.u b;
    private String c;

    private i(AtListActivity atListActivity) {
        this.f1902a = atListActivity;
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
        progressBar = this.f1902a.m;
        progressBar.setVisibility(0);
        super.b();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        this.f1902a.f = null;
        this.c = null;
        progressBar = this.f1902a.m;
        progressBar.setVisibility(8);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public bi a(String... strArr) {
        com.baidu.tieba.model.a aVar;
        this.c = strArr[0];
        this.b = new com.baidu.tieba.util.u();
        if (this.c != null && this.c.length() > 0) {
            this.b.a(String.valueOf(com.baidu.tieba.data.g.f1011a) + "c/u/follow/sug");
            this.b.a("uid", TiebaApplication.E());
            this.b.a("q", this.c);
            String k = this.b.k();
            if (this.b.d()) {
                bi biVar = new bi();
                aVar = this.f1902a.j;
                com.baidu.tieba.data.w a2 = aVar.a();
                if (a2 != null) {
                    biVar.a(k, a2.b());
                    return biVar;
                }
                biVar.a(k, (HashMap) null);
                return biVar;
            }
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(bi biVar) {
        ProgressBar progressBar;
        EditText editText;
        com.baidu.tieba.model.a aVar;
        k kVar;
        k kVar2;
        ListView listView;
        progressBar = this.f1902a.m;
        progressBar.setVisibility(8);
        if (this.b.d() && this.c != null) {
            editText = this.f1902a.f1854a;
            if (editText.getText().toString().equals(this.c)) {
                aVar = this.f1902a.j;
                aVar.a(biVar);
                kVar = this.f1902a.k;
                kVar.a(biVar.a());
                kVar2 = this.f1902a.k;
                kVar2.notifyDataSetInvalidated();
                listView = this.f1902a.d;
                listView.setSelection(0);
            }
        }
        super.a((Object) biVar);
    }
}
