package com.baidu.tieba.person;

import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.ForumData;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class k extends BdAsyncTask<ForumData, Integer, String> {
    final /* synthetic */ EditBarActivity a;
    private com.baidu.tieba.util.ba b;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(String str) {
        ProgressBar progressBar;
        com.baidu.tieba.model.f fVar;
        int i;
        int i2;
        int i3;
        String str2;
        l lVar;
        l lVar2;
        super.a((k) str);
        this.a.n = null;
        progressBar = this.a.j;
        progressBar.setVisibility(8);
        if (this.b != null) {
            if (!this.b.c()) {
                this.a.showToast(this.b.i());
                return;
            }
            fVar = this.a.a;
            ArrayList<ForumData> a = fVar.a();
            if (a != null) {
                i = this.a.l;
                if (i >= 0) {
                    i2 = this.a.l;
                    if (i2 < a.size()) {
                        i3 = this.a.l;
                        a.remove(i3);
                        TiebaApplication g = TiebaApplication.g();
                        str2 = this.a.m;
                        g.f(str2);
                        lVar = this.a.i;
                        if (lVar != null) {
                            EditBarActivity.a(this.a, true);
                            lVar2 = this.a.i;
                            lVar2.notifyDataSetChanged();
                        }
                    }
                }
            }
            this.a.showToast(this.a.getString(R.string.success));
        }
    }

    private k(EditBarActivity editBarActivity) {
        this.a = editBarActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ k(EditBarActivity editBarActivity, byte b) {
        this(editBarActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(ForumData... forumDataArr) {
        String str;
        ForumData forumData = forumDataArr[0];
        if (forumData != null) {
            try {
                if (forumData.getId() != null && forumData.getName() != null) {
                    this.a.m = forumData.getName();
                    this.b = new com.baidu.tieba.util.ba(String.valueOf(com.baidu.tieba.data.i.a) + "c/c/forum/unfavolike");
                    this.b.a("fid", forumData.getId());
                    com.baidu.tieba.util.ba baVar = this.b;
                    str = this.a.m;
                    baVar.a("kw", str);
                    this.b.a("favo_type", String.valueOf(forumData.getFavo_type()));
                    this.b.e(true);
                    this.b.l();
                    return null;
                }
                return null;
            } catch (Exception e) {
                com.baidu.adp.lib.util.e.b(getClass().getName(), "doInBackground", e.getMessage());
                return null;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void b() {
        ProgressBar progressBar;
        progressBar = this.a.j;
        progressBar.setVisibility(0);
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
        this.a.n = null;
        super.cancel(true);
    }
}
