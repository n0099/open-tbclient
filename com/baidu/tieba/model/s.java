package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.util.DatabaseService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ o f1379a;
    private com.baidu.tieba.util.u b = null;
    private String c;

    public s(o oVar, String str) {
        this.f1379a = oVar;
        this.c = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Boolean a(String... strArr) {
        boolean z = true;
        try {
            this.b = new com.baidu.tieba.util.u(String.valueOf(com.baidu.tieba.data.g.f1011a) + "c/s/tag/edit_tag");
            if (this.c == null || this.c.length() == 0) {
                return false;
            }
            this.b.a("add_tag_id_list", this.c);
            this.b.e(true);
            this.b.k();
            if (!this.b.e() || !this.b.d()) {
                z = false;
            }
            return Boolean.valueOf(z);
        } catch (Exception e) {
            com.baidu.tieba.util.aj.b(getClass().getName(), "", "LabelPostAsyncTask.doInBackground error = " + e.getMessage());
            return false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Boolean bool) {
        this.f1379a.d = null;
        if (this.b != null && bool.booleanValue()) {
            DatabaseService.a("", 12);
        }
    }
}
