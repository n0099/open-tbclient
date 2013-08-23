package com.baidu.tieba.write;

import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.MetaData;
import com.baidu.tieba.data.be;
import java.util.HashMap;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtListActivity f1933a;
    private com.baidu.tieba.util.v b;
    private String c;

    private i(AtListActivity atListActivity) {
        this.f1933a = atListActivity;
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
        progressBar = this.f1933a.n;
        progressBar.setVisibility(0);
        super.b();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        this.f1933a.g = null;
        this.c = null;
        progressBar = this.f1933a.n;
        progressBar.setVisibility(8);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public be a(String... strArr) {
        com.baidu.tieba.model.a aVar;
        this.c = strArr[0];
        this.b = new com.baidu.tieba.util.v();
        if (this.c == null || this.c.length() <= 0) {
            return null;
        }
        this.b.a(String.valueOf(com.baidu.tieba.data.g.f1014a) + "c/u/follow/sug");
        this.b.a("uid", TiebaApplication.E());
        this.b.a("q", this.c);
        String j = this.b.j();
        if (this.b.c()) {
            be beVar = new be();
            aVar = this.f1933a.k;
            com.baidu.tieba.data.y a2 = aVar.a();
            if (a2 != null) {
                beVar.a(j, a2.b());
            } else {
                beVar.a(j, (HashMap) null);
            }
            if (AtListActivity.f1885a != null && AtListActivity.f1885a.size() > 0) {
                Iterator it = beVar.a().iterator();
                while (it.hasNext()) {
                    MetaData metaData = (MetaData) it.next();
                    Iterator it2 = AtListActivity.f1885a.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            MetaData metaData2 = (MetaData) it2.next();
                            if (metaData.getName().equals(metaData2.getName())) {
                                metaData.setId(metaData2.getId());
                                metaData.setName_show(metaData2.getName_show());
                                break;
                            }
                        }
                    }
                }
            }
            return beVar;
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(be beVar) {
        ProgressBar progressBar;
        EditText editText;
        com.baidu.tieba.model.a aVar;
        k kVar;
        k kVar2;
        ListView listView;
        progressBar = this.f1933a.n;
        progressBar.setVisibility(8);
        if (this.b.c() && this.c != null) {
            editText = this.f1933a.b;
            if (editText.getText().toString().equals(this.c)) {
                if (!beVar.a().isEmpty()) {
                    this.f1933a.a(false);
                }
                aVar = this.f1933a.k;
                aVar.a(beVar);
                kVar = this.f1933a.l;
                kVar.a(beVar.a());
                kVar2 = this.f1933a.l;
                kVar2.notifyDataSetInvalidated();
                listView = this.f1933a.e;
                listView.setSelection(0);
                super.a((Object) beVar);
            }
        }
        this.f1933a.a(this.b.g());
        super.a((Object) beVar);
    }
}
