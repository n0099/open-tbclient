package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
class ck extends BdAsyncTask<Integer, Integer, Integer> {
    private com.baidu.tieba.util.at a = null;
    private String b;
    private long c;
    private String d;
    private WeakReference<cj> e;

    public ck(String str, long j, String str2, cj cjVar) {
        this.b = null;
        this.c = 0L;
        this.e = null;
        this.b = str;
        this.c = j;
        this.e = new WeakReference<>(cjVar);
        this.d = str2;
        setPriority(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Integer a(Integer... numArr) {
        try {
            if (this.c != 0 && this.b != null) {
                this.a = new com.baidu.tieba.util.at(com.baidu.tieba.data.h.a + "c/c/forum/unfavolike");
                this.a.a("fid", String.valueOf(this.c));
                this.a.a("kw", this.b);
                this.a.a("favo_type", SocialConstants.TRUE);
                this.a.a("st_type", this.d);
                this.a.e(true);
                this.a.l();
            }
            return 1;
        } catch (Exception e) {
            com.baidu.tieba.util.bo.b(getClass().getName(), "doInBackground", e.getMessage());
            return 0;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Integer num) {
        cj cjVar;
        super.a((ck) num);
        if (this.e != null && (cjVar = this.e.get()) != null) {
            if (this.a != null) {
                if (this.a.c()) {
                    if (num.intValue() == 1) {
                        TiebaApplication.g().g(this.b);
                        cjVar.a(this.b, this.c);
                        return;
                    }
                    cjVar.b(this.b, this.c);
                    return;
                }
                cjVar.b(this.b, this.c);
                return;
            }
            cjVar.b(this.b, this.c);
        }
    }
}
