package com.baidu.tieba.person;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
final class j extends BdAsyncTask<Object, String, com.baidu.tieba.model.f> {
    final /* synthetic */ EditBarActivity a;
    private com.baidu.tieba.util.ba b;

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ com.baidu.tieba.model.f a(Object... objArr) {
        return d();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(com.baidu.tieba.model.f fVar) {
        ProgressBar progressBar;
        View view;
        com.baidu.tieba.model.f fVar2;
        l lVar;
        l lVar2;
        String str;
        String string;
        View view2;
        TextView textView;
        com.baidu.tieba.model.f fVar3;
        int i;
        int i2;
        com.baidu.tieba.model.f fVar4 = fVar;
        progressBar = this.a.j;
        progressBar.setVisibility(8);
        this.a.k = null;
        if (this.b != null) {
            if (this.b.c() && fVar4 != null) {
                fVar2 = this.a.a;
                fVar2.a(fVar4.a());
                lVar = this.a.i;
                if (lVar != null) {
                    EditBarActivity.a(this.a, true);
                    lVar2 = this.a.i;
                    lVar2.notifyDataSetChanged();
                    str = this.a.r;
                    if (str != null) {
                        i = this.a.s;
                        if (i == 2) {
                            string = this.a.getString(R.string.she_attention_prefix);
                        } else {
                            i2 = this.a.s;
                            string = i2 == 1 ? this.a.getString(R.string.he_attention_prefix) : this.a.getString(R.string.its_attention_prefix);
                        }
                    } else {
                        string = this.a.getString(R.string.my_attention_prefix);
                    }
                    String string2 = this.a.getString(R.string.top_rec_like_finish_b);
                    view2 = this.a.c;
                    view2.setVisibility(0);
                    textView = this.a.e;
                    StringBuilder sb = new StringBuilder(String.valueOf(string));
                    fVar3 = this.a.a;
                    textView.setText(sb.append(String.valueOf(fVar3.a().size())).append(string2).toString());
                    return;
                }
                return;
            }
            EditBarActivity.a(this.a, true);
            view = this.a.c;
            view.setVisibility(8);
            this.a.showToast(this.b.i());
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void b(String... strArr) {
        com.baidu.tieba.model.f fVar;
        l lVar;
        l lVar2;
        String[] strArr2 = strArr;
        super.b((Object[]) strArr2);
        String str = strArr2[0];
        com.baidu.tieba.model.f fVar2 = new com.baidu.tieba.model.f();
        fVar2.a(str);
        fVar = this.a.a;
        fVar.a(fVar2.a());
        lVar = this.a.i;
        if (lVar != null) {
            EditBarActivity.a(this.a, false);
            lVar2 = this.a.i;
            lVar2.notifyDataSetChanged();
        }
    }

    private j(EditBarActivity editBarActivity) {
        this.a = editBarActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ j(EditBarActivity editBarActivity, byte b) {
        this(editBarActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void b() {
        ProgressBar progressBar;
        progressBar = this.a.j;
        progressBar.setVisibility(0);
    }

    private com.baidu.tieba.model.f d() {
        com.baidu.tieba.model.f fVar;
        Exception e;
        String str;
        String str2;
        String str3;
        String v;
        com.baidu.adp.lib.cache.s<String> n;
        String str4;
        com.baidu.adp.lib.cache.s<String> n2;
        try {
            str = this.a.r;
            if (str == null && (n2 = com.baidu.tieba.c.a.a().n()) != null) {
                c((Object[]) new String[]{n2.a(TiebaApplication.v())});
            }
            this.b = new com.baidu.tieba.util.ba(String.valueOf(com.baidu.tieba.data.i.a) + "c/f/forum/like");
            str2 = this.a.r;
            if (str2 != null) {
                com.baidu.tieba.util.ba baVar = this.b;
                str4 = this.a.r;
                baVar.a(SapiAccountManager.SESSION_UID, str4);
            }
            String l = this.b.l();
            if (!this.b.c()) {
                return null;
            }
            fVar = new com.baidu.tieba.model.f();
            try {
                fVar.a(l);
                str3 = this.a.r;
                if (str3 != null || (v = TiebaApplication.v()) == null || (n = com.baidu.tieba.c.a.a().n()) == null) {
                    return fVar;
                }
                n.a(v, l, 604800000L);
                return fVar;
            } catch (Exception e2) {
                e = e2;
                com.baidu.adp.lib.util.e.b(getClass().getName(), "doInBackground", e.getMessage());
                return fVar;
            }
        } catch (Exception e3) {
            fVar = null;
            e = e3;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        ProgressBar progressBar;
        if (this.b != null) {
            this.b.j();
            this.b = null;
        }
        progressBar = this.a.j;
        progressBar.setVisibility(8);
        this.a.k = null;
        super.cancel(true);
    }
}
