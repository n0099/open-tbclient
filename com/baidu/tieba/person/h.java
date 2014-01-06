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
    final /* synthetic */ EditBarActivity a;
    private com.baidu.tieba.util.at b;

    private h(EditBarActivity editBarActivity) {
        this.a = editBarActivity;
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
                    this.a.j = forumData.getName();
                    this.b = new com.baidu.tieba.util.at(com.baidu.tieba.data.h.a + "c/c/forum/unfavolike");
                    this.b.a("fid", forumData.getId());
                    com.baidu.tieba.util.at atVar = this.b;
                    str = this.a.j;
                    atVar.a("kw", str);
                    this.b.a("favo_type", String.valueOf(forumData.getFavo_type()));
                    this.b.e(true);
                    this.b.l();
                    return null;
                }
                return null;
            } catch (Exception e) {
                com.baidu.tieba.util.bo.b(getClass().getName(), "doInBackground", e.getMessage());
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
        com.baidu.tieba.model.h hVar;
        int i;
        int i2;
        int i3;
        String str2;
        i iVar;
        i iVar2;
        super.a((h) str);
        this.a.k = null;
        progressBar = this.a.g;
        progressBar.setVisibility(8);
        if (this.b != null) {
            if (this.b.c()) {
                hVar = this.a.a;
                ArrayList<ForumData> a = hVar.a();
                if (a != null) {
                    i = this.a.i;
                    if (i >= 0) {
                        i2 = this.a.i;
                        if (i2 < a.size()) {
                            i3 = this.a.i;
                            a.remove(i3);
                            TiebaApplication g = TiebaApplication.g();
                            str2 = this.a.j;
                            g.g(str2);
                            iVar = this.a.f;
                            if (iVar != null) {
                                this.a.a(true);
                                iVar2 = this.a.f;
                                iVar2.notifyDataSetChanged();
                            }
                        }
                    }
                }
                this.a.showToast(this.a.getString(R.string.success));
                return;
            }
            this.a.showToast(this.b.i());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        ProgressBar progressBar;
        progressBar = this.a.g;
        progressBar.setVisibility(0);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        if (this.b != null) {
            this.b.j();
            this.b = null;
        }
        progressBar = this.a.g;
        progressBar.setVisibility(8);
        this.a.k = null;
        super.cancel(true);
    }
}
