package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
class cl extends BdAsyncTask<Integer, Integer, Integer> {

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.tieba.util.ap f1917a = null;
    private String b;
    private long c;
    private String d;
    private WeakReference<ck> e;

    public cl(String str, long j, String str2, ck ckVar) {
        this.b = null;
        this.c = 0L;
        this.e = null;
        this.b = str;
        this.c = j;
        this.e = new WeakReference<>(ckVar);
        this.d = str2;
        setPriority(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Integer a(Integer... numArr) {
        try {
            if (this.c != 0 && this.b != null) {
                this.f1917a = new com.baidu.tieba.util.ap(com.baidu.tieba.data.h.f1201a + "c/c/forum/unfavolike");
                this.f1917a.a("fid", String.valueOf(this.c));
                this.f1917a.a("kw", this.b);
                this.f1917a.a("favo_type", SocialConstants.TRUE);
                this.f1917a.a("st_type", this.d);
                this.f1917a.e(true);
                this.f1917a.l();
            }
            return 1;
        } catch (Exception e) {
            com.baidu.tieba.util.bg.b(getClass().getName(), "doInBackground", e.getMessage());
            return 0;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Integer num) {
        ck ckVar;
        super.a((cl) num);
        if (this.e != null && (ckVar = this.e.get()) != null) {
            if (this.f1917a != null) {
                if (this.f1917a.c()) {
                    if (num.intValue() == 1) {
                        TiebaApplication.g().f(this.b);
                        ckVar.a(this.b, this.c);
                        return;
                    }
                    ckVar.b(this.b, this.c);
                    return;
                }
                ckVar.b(this.b, this.c);
                return;
            }
            ckVar.b(this.b, this.c);
        }
    }
}
