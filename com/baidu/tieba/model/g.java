package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.TiebaApplication;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends BdAsyncTask {
    final /* synthetic */ f a;
    private com.baidu.tieba.util.r b = null;
    private String c;
    private int d;
    private com.baidu.tieba.data.ay e;

    public g(f fVar, String str, int i) {
        this.a = fVar;
        this.c = null;
        this.d = 0;
        this.e = null;
        this.c = str;
        this.d = i;
        this.e = new com.baidu.tieba.data.ay();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Boolean a(Boolean... boolArr) {
        this.b = new com.baidu.tieba.util.r(String.valueOf(com.baidu.tieba.data.g.a) + "c/c/post/rmstore");
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
        this.a.d = null;
        if (this.a.a != null) {
            this.a.a.a(2, false, null);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Boolean bool) {
        ArrayList arrayList;
        ArrayList arrayList2;
        String str = null;
        this.a.d = null;
        if (bool.booleanValue()) {
            int i = this.d;
            arrayList = this.a.e;
            if (i < arrayList.size()) {
                arrayList2 = this.a.e;
                arrayList2.remove(this.d);
            }
        } else if (this.b.c()) {
            str = this.e.b();
        } else {
            str = this.b.g();
        }
        if (this.a.a != null) {
            this.a.a.a(2, bool, str);
        }
    }
}
