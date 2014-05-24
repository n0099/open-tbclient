package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bf extends BdAsyncTask<Integer, Integer, Integer> {
    private com.baidu.tbadk.core.util.al a = null;
    private String b;
    private long c;
    private String d;
    private WeakReference<be> e;

    public bf(String str, long j, String str2, be beVar) {
        this.b = null;
        this.c = 0L;
        this.e = null;
        this.b = str;
        this.c = j;
        this.e = new WeakReference<>(beVar);
        this.d = str2;
        setPriority(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public Integer doInBackground(Integer... numArr) {
        try {
            if (this.c != 0 && this.b != null) {
                this.a = new com.baidu.tbadk.core.util.al(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/forum/unfavolike");
                this.a.a("fid", String.valueOf(this.c));
                this.a.a("kw", this.b);
                this.a.a("favo_type", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
                this.a.a(com.baidu.tbadk.core.frameworkData.a.ST_TYPE, this.d);
                this.a.a().a().a = true;
                this.a.i();
            }
            return 1;
        } catch (Exception e) {
            BdLog.e(getClass().getName(), "doInBackground", e.getMessage());
            return 0;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(Integer num) {
        be beVar;
        super.onPostExecute(num);
        if (this.e != null && (beVar = this.e.get()) != null) {
            if (this.a != null) {
                if (this.a.a().b().b()) {
                    if (num.intValue() == 1) {
                        com.baidu.tieba.ai.c().f(this.b);
                        beVar.a(this.b, this.c);
                        return;
                    }
                    beVar.b(this.b, this.c);
                    return;
                }
                beVar.b(this.b, this.c);
                return;
            }
            beVar.b(this.b, this.c);
        }
    }
}
