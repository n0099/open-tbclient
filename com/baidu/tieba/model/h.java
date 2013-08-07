package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.DatabaseService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f1370a;
    private com.baidu.tieba.util.u b = null;
    private String c = null;
    private int d;
    private com.baidu.tieba.data.bk e;

    public h(f fVar, int i) {
        this.f1370a = fVar;
        this.d = 0;
        this.e = null;
        this.d = i;
        this.e = new com.baidu.tieba.data.bk();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public f a(Boolean... boolArr) {
        this.b = new com.baidu.tieba.util.u(String.valueOf(com.baidu.tieba.data.g.f1011a) + "c/f/post/threadstore");
        this.b.a(PushConstants.EXTRA_USER_ID, TiebaApplication.E());
        this.b.a("offset", String.valueOf(this.d));
        this.b.a("rn", String.valueOf(20));
        this.c = this.b.k();
        this.e.a(this.c);
        f fVar = new f();
        if (this.b.d() || this.e.a() == 0) {
            fVar.a(this.c);
            if (this.d == 0) {
                DatabaseService.k(this.c);
            }
        } else {
            this.c = DatabaseService.f();
            fVar.a(this.c);
        }
        return fVar;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.i();
        }
        this.f1370a.b = null;
        if (this.f1370a.f1368a != null) {
            this.f1370a.f1368a.a(0, null);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(f fVar) {
        String h;
        this.f1370a.b = null;
        this.f1370a.f = fVar.c();
        this.f1370a.b(fVar.b());
        if (this.f1370a.f1368a != null) {
            if (this.b.d()) {
                h = this.e.b();
            } else {
                h = this.b.h();
            }
            this.f1370a.f1368a.a(0, h);
        }
    }
}
