package com.baidu.tieba.write;

import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends com.baidu.adp.lib.a.a {
    final /* synthetic */ AtListActivity a;
    private com.baidu.tieba.d.t b;

    private j(AtListActivity atListActivity) {
        this.a = atListActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ j(AtListActivity atListActivity, j jVar) {
        this(atListActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void b() {
        ProgressBar progressBar;
        progressBar = this.a.m;
        progressBar.setVisibility(0);
        super.b();
    }

    @Override // com.baidu.adp.lib.a.a
    public void cancel() {
        ProgressBar progressBar;
        if (this.b != null) {
            this.b.g();
        }
        this.a.i = null;
        progressBar = this.a.m;
        progressBar.setVisibility(8);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public com.baidu.tieba.a.t a(String... strArr) {
        this.b = new com.baidu.tieba.d.t();
        this.b.a(String.valueOf(com.baidu.tieba.a.i.e) + "c/u/follow/list");
        String i = this.b.i();
        if (!this.b.b()) {
            return null;
        }
        com.baidu.tieba.a.t tVar = new com.baidu.tieba.a.t();
        tVar.a(i);
        return tVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void a(com.baidu.tieba.a.t tVar) {
        ProgressBar progressBar;
        com.baidu.tieba.c.a aVar;
        k kVar;
        EditText editText;
        com.baidu.tieba.c.a aVar2;
        com.baidu.tieba.c.a aVar3;
        k kVar2;
        k kVar3;
        k kVar4;
        ListView listView;
        this.a.i = null;
        progressBar = this.a.m;
        progressBar.setVisibility(8);
        if (this.b.b()) {
            aVar = this.a.j;
            aVar.a(tVar);
            kVar = this.a.k;
            if (kVar != null) {
                editText = this.a.c;
                if (editText.getText().toString().length() != 0) {
                    aVar2 = this.a.j;
                    if (aVar2.b() != null) {
                        aVar3 = this.a.j;
                        aVar3.b().a(tVar.b());
                        kVar2 = this.a.k;
                        kVar2.notifyDataSetInvalidated();
                    }
                } else {
                    kVar3 = this.a.k;
                    kVar3.a(tVar.a());
                    kVar4 = this.a.k;
                    kVar4.notifyDataSetInvalidated();
                    listView = this.a.f;
                    listView.setSelection(0);
                }
            } else {
                return;
            }
        }
        super.a((Object) tVar);
    }
}
