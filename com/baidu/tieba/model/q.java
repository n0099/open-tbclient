package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.TiebaApplication;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends BdAsyncTask<Boolean, Integer, Boolean> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ o f1947a;
    private com.baidu.tieba.util.ap b = null;
    private String c;
    private int d;
    private com.baidu.tieba.data.az e;

    public q(o oVar, String str, int i) {
        this.f1947a = oVar;
        this.c = null;
        this.d = 0;
        this.e = null;
        this.c = str;
        this.d = i;
        this.e = new com.baidu.tieba.data.az();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Boolean a(Boolean... boolArr) {
        this.b = new com.baidu.tieba.util.ap(com.baidu.tieba.data.h.f1196a + "c/c/post/rmstore");
        this.b.a(PushConstants.EXTRA_USER_ID, TiebaApplication.A());
        this.b.a("tid", this.c);
        this.e.a(this.b.j());
        return this.b.c() && this.e.a() == 0;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.h();
        }
        this.f1947a.d = null;
        if (this.f1947a.f1946a != null) {
            this.f1947a.f1946a.a(2, false, null);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Boolean bool) {
        ArrayList arrayList;
        ArrayList arrayList2;
        String str = null;
        this.f1947a.d = null;
        if (bool.booleanValue()) {
            int i = this.d;
            arrayList = this.f1947a.e;
            if (i < arrayList.size()) {
                arrayList2 = this.f1947a.e;
                arrayList2.remove(this.d);
                o.b(this.f1947a);
            }
        } else if (this.b.c()) {
            str = this.e.b();
        } else {
            str = this.b.g();
        }
        if (this.f1947a.f1946a != null) {
            this.f1947a.f1946a.a(2, bool, str);
        }
    }
}
