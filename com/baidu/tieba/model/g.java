package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.TiebaApplication;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f1405a;
    private com.baidu.tieba.util.v b = null;
    private String c;
    private int d;
    private com.baidu.tieba.data.bg e;

    public g(f fVar, String str, int i) {
        this.f1405a = fVar;
        this.c = null;
        this.d = 0;
        this.e = null;
        this.c = str;
        this.d = i;
        this.e = new com.baidu.tieba.data.bg();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Boolean a(Boolean... boolArr) {
        this.b = new com.baidu.tieba.util.v(String.valueOf(com.baidu.tieba.data.g.f1014a) + "c/c/post/rmstore");
        this.b.a(PushConstants.EXTRA_USER_ID, TiebaApplication.E());
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
        this.f1405a.d = null;
        if (this.f1405a.f1404a != null) {
            this.f1405a.f1404a.a(2, false, null);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Boolean bool) {
        ArrayList arrayList;
        ArrayList arrayList2;
        int i;
        String str = null;
        this.f1405a.d = null;
        if (bool.booleanValue()) {
            int i2 = this.d;
            arrayList = this.f1405a.e;
            if (i2 < arrayList.size()) {
                arrayList2 = this.f1405a.e;
                arrayList2.remove(this.d);
                f fVar = this.f1405a;
                i = fVar.g;
                fVar.g = i - 1;
            }
        } else if (this.b.c()) {
            str = this.e.b();
        } else {
            str = this.b.g();
        }
        if (this.f1405a.f1404a != null) {
            this.f1405a.f1404a.a(2, bool, str);
        }
    }
}
