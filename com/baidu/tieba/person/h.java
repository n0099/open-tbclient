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
    final /* synthetic */ EditBarActivity f2215a;
    private com.baidu.tieba.util.ag b;

    private h(EditBarActivity editBarActivity) {
        this.f2215a = editBarActivity;
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
                    this.f2215a.l = forumData.getName();
                    this.b = new com.baidu.tieba.util.ag(com.baidu.tieba.data.h.f1165a + "c/c/forum/unfavolike");
                    this.b.a("fid", forumData.getId());
                    com.baidu.tieba.util.ag agVar = this.b;
                    str = this.f2215a.l;
                    agVar.a("kw", str);
                    this.b.a("favo_type", String.valueOf(forumData.getFavo_type()));
                    this.b.e(true);
                    this.b.j();
                    return null;
                }
                return null;
            } catch (Exception e) {
                com.baidu.tieba.util.be.b(getClass().getName(), "doInBackground", e.getMessage());
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
        this.f2215a.m = null;
        progressBar = this.f2215a.g;
        progressBar.setVisibility(8);
        if (this.b != null) {
            if (this.b.c()) {
                eVar = this.f2215a.f2156a;
                ArrayList<ForumData> a2 = eVar.a();
                if (a2 != null) {
                    i = this.f2215a.k;
                    if (i >= 0) {
                        i2 = this.f2215a.k;
                        if (i2 < a2.size()) {
                            i3 = this.f2215a.k;
                            a2.remove(i3);
                            TiebaApplication g = TiebaApplication.g();
                            str2 = this.f2215a.l;
                            g.f(str2);
                            iVar = this.f2215a.f;
                            if (iVar != null) {
                                this.f2215a.e();
                                iVar2 = this.f2215a.f;
                                iVar2.notifyDataSetChanged();
                            }
                        }
                    }
                }
                this.f2215a.a(this.f2215a.getString(R.string.success));
                return;
            }
            this.f2215a.a(this.b.g());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        ProgressBar progressBar;
        progressBar = this.f2215a.g;
        progressBar.setVisibility(0);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        if (this.b != null) {
            this.b.h();
            this.b = null;
        }
        progressBar = this.f2215a.g;
        progressBar.setVisibility(8);
        this.f2215a.m = null;
        super.cancel(true);
    }
}
