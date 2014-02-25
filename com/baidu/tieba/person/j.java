package com.baidu.tieba.person;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends BdAsyncTask<Object, String, com.baidu.tieba.model.f> {
    final /* synthetic */ EditBarActivity a;
    private com.baidu.tieba.util.ba b;

    private j(EditBarActivity editBarActivity) {
        this.a = editBarActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ j(EditBarActivity editBarActivity, j jVar) {
        this(editBarActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        ProgressBar progressBar;
        progressBar = this.a.j;
        progressBar.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public com.baidu.tieba.model.f a(Object... objArr) {
        com.baidu.tieba.model.f fVar;
        Exception e;
        String str;
        String str2;
        String str3;
        String str4;
        com.baidu.adp.lib.cache.s<String> n;
        try {
            str = this.a.r;
            if (str == null && (n = com.baidu.tieba.c.a.a().n()) != null) {
                c((Object[]) new String[]{n.a(TiebaApplication.A())});
            }
            this.b = new com.baidu.tieba.util.ba(String.valueOf(com.baidu.tieba.data.i.a) + "c/f/forum/like");
            str2 = this.a.r;
            if (str2 != null) {
                com.baidu.tieba.util.ba baVar = this.b;
                str4 = this.a.r;
                baVar.a(SapiAccountManager.SESSION_UID, str4);
            }
            String m = this.b.m();
            if (!this.b.d()) {
                return null;
            }
            fVar = new com.baidu.tieba.model.f();
            try {
                fVar.a(m);
                str3 = this.a.r;
                if (str3 == null) {
                    a(m);
                    return fVar;
                }
                return fVar;
            } catch (Exception e2) {
                e = e2;
                com.baidu.adp.lib.util.f.b(getClass().getName(), "doInBackground", e.getMessage());
                return fVar;
            }
        } catch (Exception e3) {
            fVar = null;
            e = e3;
        }
    }

    private void a(String str) {
        com.baidu.adp.lib.cache.s<String> n;
        String A = TiebaApplication.A();
        if (A != null && (n = com.baidu.tieba.c.a.a().n()) != null) {
            n.a(A, str, 604800000L);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void b(String... strArr) {
        com.baidu.tieba.model.f fVar;
        l lVar;
        l lVar2;
        super.b((Object[]) strArr);
        String str = strArr[0];
        com.baidu.tieba.model.f fVar2 = new com.baidu.tieba.model.f();
        fVar2.a(str);
        fVar = this.a.a;
        fVar.a(fVar2.a());
        lVar = this.a.i;
        if (lVar == null) {
            return;
        }
        this.a.a(false);
        lVar2 = this.a.i;
        lVar2.notifyDataSetChanged();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.model.f fVar) {
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
        progressBar = this.a.j;
        progressBar.setVisibility(8);
        this.a.k = null;
        if (this.b != null) {
            if (this.b.d() && fVar != null) {
                fVar2 = this.a.a;
                fVar2.a(fVar.a());
                lVar = this.a.i;
                if (lVar == null) {
                    return;
                }
                this.a.a(true);
                lVar2 = this.a.i;
                lVar2.notifyDataSetChanged();
                str = this.a.r;
                if (str != null) {
                    i = this.a.s;
                    if (i != 2) {
                        i2 = this.a.s;
                        if (i2 == 1) {
                            string = this.a.getString(R.string.he_attention_prefix);
                        } else {
                            string = this.a.getString(R.string.its_attention_prefix);
                        }
                    } else {
                        string = this.a.getString(R.string.she_attention_prefix);
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
            this.a.a(true);
            view = this.a.c;
            view.setVisibility(8);
            this.a.showToast(this.b.j());
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        if (this.b != null) {
            this.b.k();
            this.b = null;
        }
        progressBar = this.a.j;
        progressBar.setVisibility(8);
        this.a.k = null;
        super.cancel(true);
    }
}
