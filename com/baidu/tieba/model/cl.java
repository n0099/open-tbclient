package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
class cl extends BdAsyncTask<Integer, Integer, Integer> {

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.tieba.util.am f2030a = null;
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
                this.f2030a = new com.baidu.tieba.util.am(com.baidu.tieba.data.h.f1248a + "c/c/forum/unfavolike");
                this.f2030a.a("fid", String.valueOf(this.c));
                this.f2030a.a("kw", this.b);
                this.f2030a.a("favo_type", SocialConstants.TRUE);
                this.f2030a.a("st_type", this.d);
                this.f2030a.e(true);
                this.f2030a.l();
            }
            return 1;
        } catch (Exception e) {
            com.baidu.tieba.util.bd.b(getClass().getName(), "doInBackground", e.getMessage());
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
            if (this.f2030a != null) {
                if (this.f2030a.c()) {
                    if (num.intValue() == 1) {
                        TiebaApplication.h().g(this.b);
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
