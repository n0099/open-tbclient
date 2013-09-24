package com.baidu.tieba.write;

import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.MetaData;
import java.util.HashMap;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends BdAsyncTask<String, Integer, com.baidu.tieba.data.be> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtListActivity f2116a;
    private com.baidu.tieba.util.z b;
    private String c;

    private i(AtListActivity atListActivity) {
        this.f2116a = atListActivity;
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
        progressBar = this.f2116a.n;
        progressBar.setVisibility(0);
        super.b();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        this.f2116a.g = null;
        this.c = null;
        progressBar = this.f2116a.n;
        progressBar.setVisibility(8);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public com.baidu.tieba.data.be a(String... strArr) {
        com.baidu.tieba.model.c cVar;
        this.c = strArr[0];
        this.b = new com.baidu.tieba.util.z();
        if (this.c == null || this.c.length() <= 0) {
            return null;
        }
        this.b.a(String.valueOf(com.baidu.tieba.data.g.f1032a) + "c/u/follow/sug");
        this.b.a("uid", TiebaApplication.C());
        this.b.a("q", this.c);
        String j = this.b.j();
        if (this.b.c()) {
            com.baidu.tieba.data.be beVar = new com.baidu.tieba.data.be();
            cVar = this.f2116a.k;
            com.baidu.tieba.data.y a2 = cVar.a();
            if (a2 != null) {
                beVar.a(j, a2.b());
            } else {
                beVar.a(j, (HashMap<String, String>) null);
            }
            if (AtListActivity.f2062a != null && AtListActivity.f2062a.size() > 0) {
                Iterator<MetaData> it = beVar.a().iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    Iterator<MetaData> it2 = AtListActivity.f2062a.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            MetaData next2 = it2.next();
                            if (next.getName().equals(next2.getName())) {
                                next.setId(next2.getId());
                                next.setName_show(next2.getName_show());
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
    public void a(com.baidu.tieba.data.be beVar) {
        ProgressBar progressBar;
        EditText editText;
        com.baidu.tieba.model.c cVar;
        k kVar;
        k kVar2;
        ListView listView;
        progressBar = this.f2116a.n;
        progressBar.setVisibility(8);
        if (this.b.c() && this.c != null) {
            editText = this.f2116a.b;
            if (editText.getText().toString().equals(this.c)) {
                if (!beVar.a().isEmpty()) {
                    this.f2116a.a(false);
                }
                cVar = this.f2116a.k;
                cVar.a(beVar);
                kVar = this.f2116a.l;
                kVar.a(beVar.a());
                kVar2 = this.f2116a.l;
                kVar2.notifyDataSetInvalidated();
                listView = this.f2116a.e;
                listView.setSelection(0);
                super.a((i) beVar);
            }
        }
        this.f2116a.a(this.b.g());
        super.a((i) beVar);
    }
}
