package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.TiebaApplication;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class h extends BdAsyncTask<Boolean, Integer, Boolean> {
    final /* synthetic */ g a;
    private com.baidu.tieba.util.ba b = null;
    private String c;
    private int d;
    private com.baidu.tieba.data.ay e;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ Boolean a(Boolean... boolArr) {
        this.b = new com.baidu.tieba.util.ba(String.valueOf(com.baidu.tieba.data.i.a) + "c/c/post/rmstore");
        this.b.a(PushConstants.EXTRA_USER_ID, TiebaApplication.v());
        this.b.a("tid", this.c);
        this.e.a(this.b.l());
        return this.b.c() && this.e.a() == 0;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(Boolean bool) {
        ArrayList arrayList;
        ArrayList arrayList2;
        int i;
        String str = null;
        Boolean bool2 = bool;
        this.a.d = null;
        if (bool2.booleanValue()) {
            int i2 = this.d;
            arrayList = this.a.e;
            if (i2 < arrayList.size()) {
                arrayList2 = this.a.e;
                arrayList2.remove(this.d);
                g gVar = this.a;
                i = gVar.g;
                gVar.g = i - 1;
            }
        } else {
            str = this.b.c() ? this.e.b() : this.b.i();
        }
        if (this.a.a != null) {
            this.a.a.a(2, bool2, str);
        }
    }

    public h(g gVar, String str, int i) {
        this.a = gVar;
        this.c = null;
        this.d = 0;
        this.e = null;
        this.c = str;
        this.d = i;
        this.e = new com.baidu.tieba.data.ay();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.j();
        }
        this.a.d = null;
        if (this.a.a != null) {
            this.a.a.a(2, false, null);
        }
    }
}
