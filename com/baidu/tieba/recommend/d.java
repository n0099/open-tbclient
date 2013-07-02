package com.baidu.tieba.recommend;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.LabelActivity;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.r;
import com.baidu.tieba.util.z;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends BdAsyncTask {
    final /* synthetic */ NewHomeActivity a;
    private r b = null;
    private String c;

    public d(NewHomeActivity newHomeActivity, String str) {
        this.a = newHomeActivity;
        this.c = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Boolean a(String... strArr) {
        boolean z = true;
        try {
            this.b = new r(String.valueOf(com.baidu.tieba.data.g.a) + "c/s/tag/edit_tag");
            if (this.c == null || this.c.length() == 0) {
                return false;
            }
            this.b.a("add_tag_id_list", this.c);
            this.b.a("st_type", LabelActivity.a);
            this.b.d(true);
            this.b.j();
            if (!this.b.d() || !this.b.c()) {
                z = false;
            }
            return Boolean.valueOf(z);
        } catch (Exception e) {
            z.b(getClass().getName(), "", "AddFanAsyncTask.doInBackground error = " + e.getMessage());
            return false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Boolean bool) {
        this.a.y = null;
        if (this.b != null && bool.booleanValue()) {
            DatabaseService.a("", 12);
        }
    }
}
