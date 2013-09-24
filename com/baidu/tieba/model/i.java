package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.TiebaApplication;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends BdAsyncTask<Boolean, Integer, Boolean> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f1446a;
    private com.baidu.tieba.util.z b = null;
    private String c;
    private int d;
    private com.baidu.tieba.data.bg e;

    public i(h hVar, String str, int i) {
        this.f1446a = hVar;
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
        this.b = new com.baidu.tieba.util.z(String.valueOf(com.baidu.tieba.data.g.f1032a) + "c/c/post/rmstore");
        this.b.a(PushConstants.EXTRA_USER_ID, TiebaApplication.C());
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
        this.f1446a.d = null;
        if (this.f1446a.f1445a != null) {
            this.f1446a.f1445a.a(2, false, null);
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
        this.f1446a.d = null;
        if (bool.booleanValue()) {
            int i2 = this.d;
            arrayList = this.f1446a.e;
            if (i2 < arrayList.size()) {
                arrayList2 = this.f1446a.e;
                arrayList2.remove(this.d);
                h hVar = this.f1446a;
                i = hVar.g;
                hVar.g = i - 1;
            }
        } else if (this.b.c()) {
            str = this.e.b();
        } else {
            str = this.b.g();
        }
        if (this.f1446a.f1445a != null) {
            this.f1446a.f1445a.a(2, bool, str);
        }
    }
}
