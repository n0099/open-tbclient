package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.TiebaApplication;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f1371a;
    private com.baidu.tieba.util.u b = null;
    private String c;
    private int d;
    private com.baidu.tieba.data.bk e;

    public g(f fVar, String str, int i) {
        this.f1371a = fVar;
        this.c = null;
        this.d = 0;
        this.e = null;
        this.c = str;
        this.d = i;
        this.e = new com.baidu.tieba.data.bk();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Boolean a(Boolean... boolArr) {
        this.b = new com.baidu.tieba.util.u(String.valueOf(com.baidu.tieba.data.g.f1013a) + "c/c/post/rmstore");
        this.b.a(PushConstants.EXTRA_USER_ID, TiebaApplication.E());
        this.b.a("tid", this.c);
        this.e.a(this.b.k());
        return this.b.d() && this.e.a() == 0;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.i();
        }
        this.f1371a.d = null;
        if (this.f1371a.f1370a != null) {
            this.f1371a.f1370a.a(2, false, null);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Boolean bool) {
        ArrayList arrayList;
        ArrayList arrayList2;
        String str = null;
        this.f1371a.d = null;
        if (bool.booleanValue()) {
            int i = this.d;
            arrayList = this.f1371a.e;
            if (i < arrayList.size()) {
                arrayList2 = this.f1371a.e;
                arrayList2.remove(this.d);
            }
        } else if (this.b.d()) {
            str = this.e.b();
        } else {
            str = this.b.h();
        }
        if (this.f1371a.f1370a != null) {
            this.f1371a.f1370a.a(2, bool, str);
        }
    }
}
