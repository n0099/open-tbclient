package com.baidu.tieba.person;

import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.ForumData;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends BdAsyncTask<ForumData, Integer, String> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EditBarActivity f2354a;
    private com.baidu.tieba.util.am b;

    private h(EditBarActivity editBarActivity) {
        this.f2354a = editBarActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ h(EditBarActivity editBarActivity, d dVar) {
        this(editBarActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(ForumData... forumDataArr) {
        String str;
        ForumData forumData = forumDataArr[0];
        if (forumData != null) {
            try {
                if (forumData.getId() != null && forumData.getName() != null) {
                    this.f2354a.j = forumData.getName();
                    this.b = new com.baidu.tieba.util.am(com.baidu.tieba.data.h.f1248a + "c/c/forum/unfavolike");
                    this.b.a("fid", forumData.getId());
                    com.baidu.tieba.util.am amVar = this.b;
                    str = this.f2354a.j;
                    amVar.a("kw", str);
                    this.b.a("favo_type", String.valueOf(forumData.getFavo_type()));
                    this.b.e(true);
                    this.b.l();
                    return null;
                }
                return null;
            } catch (Exception e) {
                com.baidu.tieba.util.bd.b(getClass().getName(), "doInBackground", e.getMessage());
                return null;
            }
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        ProgressBar progressBar;
        com.baidu.tieba.model.e eVar;
        int i;
        int i2;
        int i3;
        String str2;
        i iVar;
        i iVar2;
        super.a((h) str);
        this.f2354a.k = null;
        progressBar = this.f2354a.g;
        progressBar.setVisibility(8);
        if (this.b != null) {
            if (this.b.c()) {
                eVar = this.f2354a.f2290a;
                ArrayList<ForumData> a2 = eVar.a();
                if (a2 != null) {
                    i = this.f2354a.i;
                    if (i >= 0) {
                        i2 = this.f2354a.i;
                        if (i2 < a2.size()) {
                            i3 = this.f2354a.i;
                            a2.remove(i3);
                            TiebaApplication h = TiebaApplication.h();
                            str2 = this.f2354a.j;
                            h.g(str2);
                            iVar = this.f2354a.f;
                            if (iVar != null) {
                                this.f2354a.a(true);
                                iVar2 = this.f2354a.f;
                                iVar2.notifyDataSetChanged();
                            }
                        }
                    }
                }
                this.f2354a.showToast(this.f2354a.getString(R.string.success));
                return;
            }
            this.f2354a.showToast(this.b.i());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        ProgressBar progressBar;
        progressBar = this.f2354a.g;
        progressBar.setVisibility(0);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        if (this.b != null) {
            this.b.j();
            this.b = null;
        }
        progressBar = this.f2354a.g;
        progressBar.setVisibility(8);
        this.f2354a.k = null;
        super.cancel(true);
    }
}
