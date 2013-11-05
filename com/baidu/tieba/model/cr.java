package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
class cr extends BdAsyncTask<Integer, Integer, Integer> {

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.tieba.util.ag f1943a = null;
    private String b;
    private long c;
    private String d;
    private WeakReference<cq> e;

    public cr(String str, long j, String str2, cq cqVar) {
        this.b = null;
        this.c = 0L;
        this.e = null;
        this.b = str;
        this.c = j;
        this.e = new WeakReference<>(cqVar);
        this.d = str2;
        setPriority(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Integer a(Integer... numArr) {
        try {
            if (this.c != 0 && this.b != null) {
                this.f1943a = new com.baidu.tieba.util.ag(com.baidu.tieba.data.h.f1165a + "c/c/forum/unfavolike");
                this.f1943a.a("fid", String.valueOf(this.c));
                this.f1943a.a("kw", this.b);
                this.f1943a.a("favo_type", SocialConstants.TRUE);
                this.f1943a.a("st_type", this.d);
                this.f1943a.e(true);
                this.f1943a.j();
            }
            return 1;
        } catch (Exception e) {
            com.baidu.tieba.util.be.b(getClass().getName(), "doInBackground", e.getMessage());
            return 0;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Integer num) {
        super.a((cr) num);
        if (this.e != null) {
            cq cqVar = this.e.get();
            if (this.f1943a != null && cqVar != null) {
                if (this.f1943a.c()) {
                    if (num.intValue() == 1) {
                        TiebaApplication.g().f(this.b);
                        if (cqVar != null) {
                            cqVar.a(this.b, this.c);
                            return;
                        }
                        return;
                    }
                    cqVar.b(this.b, this.c);
                    return;
                }
                cqVar.b(this.b, this.c);
                return;
            }
            cqVar.b(this.b, this.c);
        }
    }
}
