package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbadkApplication;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class l extends BdAsyncTask<Boolean, Integer, Boolean> {
    final /* synthetic */ k a;
    private com.baidu.tbadk.core.util.ak b = null;
    private String c;
    private int d;
    private com.baidu.tieba.data.aq e;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ Boolean a(Boolean... boolArr) {
        this.b = new com.baidu.tbadk.core.util.ak(String.valueOf(com.baidu.tbadk.core.data.n.a) + "c/c/post/rmstore");
        this.b.a("user_id", TbadkApplication.E());
        this.b.a("tid", this.c);
        this.e.a(this.b.i());
        return this.b.a().b().b() && this.e.a() == 0;
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
                k kVar = this.a;
                i = kVar.g;
                kVar.g = i - 1;
            }
        } else {
            str = this.b.a().b().b() ? this.e.b() : this.b.f();
        }
        if (this.a.a != null) {
            this.a.a.a(2, bool2, str);
        }
    }

    public l(k kVar, String str, int i) {
        this.a = kVar;
        this.c = null;
        this.d = 0;
        this.e = null;
        this.c = str;
        this.d = i;
        this.e = new com.baidu.tieba.data.aq();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.g();
        }
        this.a.d = null;
        if (this.a.a != null) {
            this.a.a.a(2, false, null);
        }
    }
}
