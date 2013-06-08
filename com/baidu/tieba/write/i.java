package com.baidu.tieba.write;

import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import com.baidu.tieba.TiebaApplication;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends com.baidu.adp.lib.a.a {
    final /* synthetic */ AtListActivity a;
    private com.baidu.tieba.d.t b;
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
        this.a.h = null;
        this.c = null;
        progressBar = this.a.m;
        progressBar.setVisibility(8);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public com.baidu.tieba.a.az a(String... strArr) {
        com.baidu.tieba.c.a aVar;
        this.c = strArr[0];
        this.b = new com.baidu.tieba.d.t();
        if (this.c != null && this.c.length() > 0) {
            this.b.a(String.valueOf(com.baidu.tieba.a.i.e) + "c/u/follow/sug");
            this.b.a("uid", TiebaApplication.B());
            this.b.a("q", this.c);
            String i = this.b.i();
            if (this.b.b()) {
                com.baidu.tieba.a.az azVar = new com.baidu.tieba.a.az();
                aVar = this.a.j;
                com.baidu.tieba.a.t a = aVar.a();
                if (a != null) {
                    azVar.a(i, a.b());
                    return azVar;
                }
                azVar.a(i, (HashMap) null);
                return azVar;
            }
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void a(com.baidu.tieba.a.az azVar) {
        ProgressBar progressBar;
        EditText editText;
        com.baidu.tieba.c.a aVar;
        k kVar;
        k kVar2;
        ListView listView;
        progressBar = this.a.m;
        progressBar.setVisibility(8);
        if (this.b.b() && this.c != null) {
            editText = this.a.c;
            if (editText.getText().toString().equals(this.c)) {
                aVar = this.a.j;
                aVar.a(azVar);
                kVar = this.a.k;
                kVar.a(azVar.a());
                kVar2 = this.a.k;
                kVar2.notifyDataSetInvalidated();
                listView = this.a.f;
                listView.setSelection(0);
            }
        }
        super.a((Object) azVar);
    }
}
