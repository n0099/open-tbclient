package com.baidu.tieba.person;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
final class e extends BdAsyncTask<Object, String, com.baidu.tieba.model.d> {
    final /* synthetic */ EditBarActivity a;
    private com.baidu.tbadk.core.util.ak b;

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ com.baidu.tieba.model.d a(Object... objArr) {
        return a();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(com.baidu.tieba.model.d dVar) {
        ProgressBar progressBar;
        View view;
        com.baidu.tieba.model.d dVar2;
        com.baidu.tieba.model.d dVar3;
        g gVar;
        g gVar2;
        String str;
        String string;
        View view2;
        TextView textView;
        com.baidu.tieba.model.d dVar4;
        int i;
        int i2;
        com.baidu.tieba.model.d dVar5 = dVar;
        progressBar = this.a.j;
        progressBar.setVisibility(8);
        this.a.k = null;
        if (this.b != null) {
            if (this.b.a().b().b() && dVar5 != null) {
                dVar2 = this.a.a;
                dVar2.a(dVar5.b());
                dVar3 = this.a.a;
                dVar3.a(dVar5.a());
                gVar = this.a.i;
                if (gVar != null) {
                    EditBarActivity.a(this.a, true);
                    gVar2 = this.a.i;
                    gVar2.notifyDataSetChanged();
                    str = this.a.r;
                    if (str != null) {
                        i = this.a.s;
                        if (i == 2) {
                            string = this.a.getString(com.baidu.tieba.a.k.she_attention_prefix);
                        } else {
                            i2 = this.a.s;
                            string = i2 == 1 ? this.a.getString(com.baidu.tieba.a.k.he_attention_prefix) : this.a.getString(com.baidu.tieba.a.k.its_attention_prefix);
                        }
                    } else {
                        string = this.a.getString(com.baidu.tieba.a.k.my_attention_prefix);
                    }
                    String string2 = this.a.getString(com.baidu.tieba.a.k.top_rec_like_finish_b);
                    view2 = this.a.c;
                    view2.setVisibility(0);
                    textView = this.a.e;
                    StringBuilder sb = new StringBuilder(String.valueOf(string));
                    dVar4 = this.a.a;
                    textView.setText(sb.append(String.valueOf(dVar4.b().size())).append(string2).toString());
                    return;
                }
                return;
            }
            EditBarActivity.a(this.a, true);
            view = this.a.c;
            view.setVisibility(8);
            this.a.showToast(this.b.f());
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void b(String... strArr) {
        com.baidu.tieba.model.d dVar;
        com.baidu.tieba.model.d dVar2;
        g gVar;
        g gVar2;
        String[] strArr2 = strArr;
        super.b((Object[]) strArr2);
        String str = strArr2[0];
        com.baidu.tieba.model.d dVar3 = new com.baidu.tieba.model.d();
        dVar3.a(str);
        dVar = this.a.a;
        dVar.a(dVar3.b());
        dVar2 = this.a.a;
        dVar2.a(dVar3.a());
        gVar = this.a.i;
        if (gVar != null) {
            EditBarActivity.a(this.a, false);
            gVar2 = this.a.i;
            gVar2.notifyDataSetChanged();
        }
    }

    private e(EditBarActivity editBarActivity) {
        this.a = editBarActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ e(EditBarActivity editBarActivity, byte b) {
        this(editBarActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void c() {
        ProgressBar progressBar;
        progressBar = this.a.j;
        progressBar.setVisibility(0);
    }

    private com.baidu.tieba.model.d a() {
        com.baidu.tieba.model.d dVar;
        Exception e;
        String str;
        String str2;
        String str3;
        String E;
        com.baidu.adp.lib.cache.s<String> n;
        String str4;
        com.baidu.adp.lib.cache.s<String> n2;
        try {
            str = this.a.r;
            if (str == null && (n2 = com.baidu.tbadk.core.c.b.a().n()) != null) {
                c((Object[]) new String[]{n2.a(TbadkApplication.E())});
            }
            this.b = new com.baidu.tbadk.core.util.ak(String.valueOf(com.baidu.tbadk.core.data.n.a) + "c/f/forum/like");
            str2 = this.a.r;
            if (str2 != null) {
                com.baidu.tbadk.core.util.ak akVar = this.b;
                str4 = this.a.r;
                akVar.a("uid", str4);
            }
            String i = this.b.i();
            if (!this.b.a().b().b()) {
                return null;
            }
            dVar = new com.baidu.tieba.model.d();
            try {
                dVar.a(i);
                str3 = this.a.r;
                if (str3 != null || (E = TbadkApplication.E()) == null || (n = com.baidu.tbadk.core.c.b.a().n()) == null) {
                    return dVar;
                }
                n.a(E, i, 604800000L);
                return dVar;
            } catch (Exception e2) {
                e = e2;
                com.baidu.adp.lib.util.f.b(getClass().getName(), "doInBackground", e.getMessage());
                return dVar;
            }
        } catch (Exception e3) {
            dVar = null;
            e = e3;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        ProgressBar progressBar;
        if (this.b != null) {
            this.b.g();
            this.b = null;
        }
        progressBar = this.a.j;
        progressBar.setVisibility(8);
        this.a.k = null;
        super.cancel(true);
    }
}
