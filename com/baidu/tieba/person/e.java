package com.baidu.tieba.person;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends BdAsyncTask<Object, String, com.baidu.tieba.model.d> {
    final /* synthetic */ EditBarActivity a;
    private com.baidu.tbadk.core.util.al b;

    private e(EditBarActivity editBarActivity) {
        this.a = editBarActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ e(EditBarActivity editBarActivity, e eVar) {
        this(editBarActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ProgressBar progressBar;
        progressBar = this.a.j;
        progressBar.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public com.baidu.tieba.model.d doInBackground(Object... objArr) {
        com.baidu.tieba.model.d dVar;
        Exception e;
        String str;
        String str2;
        String str3;
        String str4;
        com.baidu.adp.lib.cache.s<String> q;
        try {
            str = this.a.r;
            if (str == null && (q = com.baidu.tbadk.core.a.b.a().q()) != null) {
                publishProgress(q.a(TbadkApplication.getCurrentAccount()));
            }
            this.b = new com.baidu.tbadk.core.util.al(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/forum/like");
            str2 = this.a.r;
            if (str2 != null) {
                com.baidu.tbadk.core.util.al alVar = this.b;
                str4 = this.a.r;
                alVar.a(SapiAccountManager.SESSION_UID, str4);
            }
            String i = this.b.i();
            if (!this.b.a().b().b()) {
                return null;
            }
            dVar = new com.baidu.tieba.model.d();
            try {
                dVar.a(i);
                str3 = this.a.r;
                if (str3 == null) {
                    a(i);
                    return dVar;
                }
                return dVar;
            } catch (Exception e2) {
                e = e2;
                BdLog.e(getClass().getName(), "doInBackground", e.getMessage());
                return dVar;
            }
        } catch (Exception e3) {
            dVar = null;
            e = e3;
        }
    }

    private void a(String str) {
        com.baidu.adp.lib.cache.s<String> q;
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount != null && (q = com.baidu.tbadk.core.a.b.a().q()) != null) {
            q.a(currentAccount, str, 604800000L);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onProgressUpdate(String... strArr) {
        com.baidu.tieba.model.d dVar;
        com.baidu.tieba.model.d dVar2;
        g gVar;
        g gVar2;
        super.onProgressUpdate(strArr);
        String str = strArr[0];
        com.baidu.tieba.model.d dVar3 = new com.baidu.tieba.model.d();
        dVar3.a(str);
        dVar = this.a.a;
        dVar.a(dVar3.b());
        dVar2 = this.a.a;
        dVar2.a(dVar3.a());
        gVar = this.a.i;
        if (gVar == null) {
            return;
        }
        this.a.a(false);
        gVar2 = this.a.i;
        gVar2.notifyDataSetChanged();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.model.d dVar) {
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
        progressBar = this.a.j;
        progressBar.setVisibility(8);
        this.a.k = null;
        if (this.b != null) {
            if (this.b.a().b().b() && dVar != null) {
                dVar2 = this.a.a;
                dVar2.a(dVar.b());
                dVar3 = this.a.a;
                dVar3.a(dVar.a());
                gVar = this.a.i;
                if (gVar == null) {
                    return;
                }
                this.a.a(true);
                gVar2 = this.a.i;
                gVar2.notifyDataSetChanged();
                str = this.a.r;
                if (str != null) {
                    i = this.a.s;
                    if (i != 2) {
                        i2 = this.a.s;
                        if (i2 == 1) {
                            string = this.a.getString(com.baidu.tieba.y.he_attention_prefix);
                        } else {
                            string = this.a.getString(com.baidu.tieba.y.its_attention_prefix);
                        }
                    } else {
                        string = this.a.getString(com.baidu.tieba.y.she_attention_prefix);
                    }
                } else {
                    string = this.a.getString(com.baidu.tieba.y.my_attention_prefix);
                }
                String string2 = this.a.getString(com.baidu.tieba.y.top_rec_like_finish_b);
                view2 = this.a.c;
                view2.setVisibility(0);
                textView = this.a.e;
                StringBuilder sb = new StringBuilder(String.valueOf(string));
                dVar4 = this.a.a;
                textView.setText(sb.append(String.valueOf(dVar4.b().size())).append(string2).toString());
                return;
            }
            this.a.a(true);
            view = this.a.c;
            view.setVisibility(8);
            this.a.showToast(this.b.f());
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
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
