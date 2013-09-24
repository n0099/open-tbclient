package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
class ch extends BdAsyncTask<Integer, Integer, Integer> {

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.tieba.util.z f1440a = null;
    private String b;
    private long c;
    private String d;
    private WeakReference<cg> e;

    public ch(String str, long j, String str2, cg cgVar) {
        this.b = null;
        this.c = 0L;
        this.e = null;
        this.b = str;
        this.c = j;
        this.e = new WeakReference<>(cgVar);
        this.d = str2;
        setPriority(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Integer a(Integer... numArr) {
        try {
            if (this.c != 0 && this.b != null) {
                this.f1440a = new com.baidu.tieba.util.z(String.valueOf(com.baidu.tieba.data.g.f1032a) + "c/c/forum/unfavolike");
                this.f1440a.a("fid", String.valueOf(this.c));
                this.f1440a.a("kw", this.b);
                this.f1440a.a("favo_type", "1");
                this.f1440a.a("st_type", this.d);
                this.f1440a.e(true);
                this.f1440a.j();
            }
            return 1;
        } catch (Exception e) {
            com.baidu.tieba.util.av.b(getClass().getName(), "doInBackground", e.getMessage());
            return 0;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Integer num) {
        super.a((ch) num);
        if (this.e != null) {
            cg cgVar = this.e.get();
            if (this.f1440a != null) {
                if (this.f1440a.c()) {
                    if (num.intValue() == 1) {
                        TiebaApplication.g().f(this.b);
                        cgVar.a(this.b, this.c);
                        return;
                    }
                    cgVar.b(this.b, this.c);
                    return;
                }
                cgVar.b(this.b, this.c);
                return;
            }
            cgVar.b(this.b, this.c);
        }
    }
}
