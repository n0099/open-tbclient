package com.baidu.tieba.person;

import android.text.TextUtils;
import android.widget.ProgressBar;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.ForumData;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends BdAsyncTask<ForumData, Integer, String> {
    final /* synthetic */ EditBarActivity a;
    private com.baidu.tbadk.core.util.al b;
    private ForumData c;

    private f(EditBarActivity editBarActivity) {
        this.a = editBarActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ f(EditBarActivity editBarActivity, f fVar) {
        this(editBarActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public String doInBackground(ForumData... forumDataArr) {
        String str;
        this.c = forumDataArr[0];
        try {
            if (this.c != null && this.c.getId() != null && this.c.getName() != null) {
                this.a.m = this.c.getName();
                this.b = new com.baidu.tbadk.core.util.al(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/forum/unfavolike");
                this.b.a("fid", this.c.getId());
                com.baidu.tbadk.core.util.al alVar = this.b;
                str = this.a.m;
                alVar.a("kw", str);
                this.b.a("favo_type", String.valueOf(this.c.getFavo_type()));
                this.b.a().a().a = true;
                this.b.i();
                return null;
            }
            return null;
        } catch (Exception e) {
            BdLog.e(getClass().getName(), "doInBackground", e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(String str) {
        ProgressBar progressBar;
        com.baidu.tieba.model.d dVar;
        com.baidu.tieba.model.d dVar2;
        int i;
        int i2;
        int i3;
        int i4;
        String str2;
        g gVar;
        g gVar2;
        com.baidu.tieba.model.d dVar3;
        super.onPostExecute(str);
        this.a.n = null;
        progressBar = this.a.j;
        progressBar.setVisibility(8);
        if (this.b != null) {
            if (this.b.a().b().b()) {
                dVar = this.a.a;
                ArrayList<ForumData> b = dVar.b();
                dVar2 = this.a.a;
                int a = dVar2.a();
                i = this.a.l;
                if (i < a) {
                    dVar3 = this.a.a;
                    dVar3.a(a - 1);
                }
                if (b != null) {
                    i2 = this.a.l;
                    if (i2 >= 0) {
                        i3 = this.a.l;
                        if (i3 < b.size()) {
                            i4 = this.a.l;
                            b.remove(i4);
                            com.baidu.tieba.ad c = com.baidu.tieba.ad.c();
                            str2 = this.a.m;
                            c.f(str2);
                            gVar = this.a.i;
                            if (gVar != null) {
                                this.a.a(true);
                                gVar2 = this.a.i;
                                gVar2.notifyDataSetChanged();
                            }
                        }
                    }
                }
                this.a.showToast(this.a.getString(com.baidu.tieba.u.success));
                if (this.c != null && !TextUtils.isEmpty(this.c.getId())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2005004, this.c.getId()));
                    return;
                }
                return;
            }
            this.a.showToast(this.b.f());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ProgressBar progressBar;
        progressBar = this.a.j;
        progressBar.setVisibility(0);
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
        this.a.n = null;
        super.cancel(true);
    }
}
