package com.baidu.tieba;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.util.DatabaseService;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z extends BdAsyncTask {
    ArrayList a;
    final /* synthetic */ LabelActivity b;
    private String d;
    private boolean f;
    private com.baidu.tieba.util.r c = null;
    private int e = 1;

    public z(LabelActivity labelActivity, String str, boolean z, ArrayList arrayList) {
        this.b = labelActivity;
        this.d = null;
        this.a = null;
        this.d = str;
        this.a = arrayList;
        this.f = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        this.b.b(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public Boolean a(Object... objArr) {
        com.baidu.tieba.model.ai aiVar;
        com.baidu.tieba.model.ai aiVar2;
        com.baidu.tieba.model.ai aiVar3;
        com.baidu.tieba.model.ai aiVar4;
        com.baidu.tieba.model.ai aiVar5;
        com.baidu.tieba.model.ai aiVar6;
        try {
            this.c = new com.baidu.tieba.util.r(this.d);
            this.c.a(this.a);
            aiVar = this.b.q;
            if (aiVar != null) {
                aiVar5 = this.b.q;
                if (aiVar5.h().size() != 0) {
                    aiVar6 = this.b.q;
                    this.c.a("tag_info", aiVar6.g());
                }
            }
            com.baidu.tieba.util.z.b("begin to get label data...url is " + this.d);
            String j = this.c.j();
            com.baidu.tieba.util.z.b("end to get label data...");
            if (this.c.c()) {
                aiVar2 = this.b.q;
                if (aiVar2 == null) {
                    this.b.q = new com.baidu.tieba.model.ai();
                }
                aiVar3 = this.b.q;
                aiVar3.a(j);
                if (this.f) {
                    aiVar4 = this.b.q;
                    aiVar4.b(DatabaseService.b(12));
                }
                com.baidu.tieba.util.z.a(getClass().getName(), "doInBackground", j);
                System.gc();
            }
            if (this.c.d()) {
                this.e = 0;
            } else {
                this.e = 1;
            }
            return true;
        } catch (Exception e) {
            com.baidu.tieba.util.z.b(getClass().getName(), "", "LabelAsyncTask.doInBackground error = " + e.getMessage());
            return false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Boolean bool) {
        this.b.b(false);
        if (bool.booleanValue() && this.e != 1) {
            this.b.o();
            this.b.c(false);
        } else {
            e();
        }
        this.b.M = null;
        System.gc();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void c() {
        super.c();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.c != null) {
            this.c.h();
        }
        super.cancel(true);
    }

    private void e() {
        this.b.a(this.c.g());
    }
}
