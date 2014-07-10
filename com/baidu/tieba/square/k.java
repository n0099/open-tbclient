package com.baidu.tieba.square;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends BdAsyncTask<Object, Integer, o> {
    final /* synthetic */ BarFolderSecondDirActivity a;
    private com.baidu.tbadk.core.util.aq b;

    private k(BarFolderSecondDirActivity barFolderSecondDirActivity) {
        this.a = barFolderSecondDirActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ k(BarFolderSecondDirActivity barFolderSecondDirActivity, k kVar) {
        this(barFolderSecondDirActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public o doInBackground(Object... objArr) {
        l lVar;
        String str;
        String str2;
        String str3;
        lVar = this.a.i;
        o a = lVar.a();
        try {
            this.b = new com.baidu.tbadk.core.util.aq(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/forum/seconddir");
            com.baidu.tbadk.core.util.aq aqVar = this.b;
            str = this.a.k;
            aqVar.a("menu_name", str);
            com.baidu.tbadk.core.util.aq aqVar2 = this.b;
            str2 = this.a.l;
            aqVar2.a("menu_type", str2);
            com.baidu.tbadk.core.util.aq aqVar3 = this.b;
            str3 = this.a.m;
            aqVar3.a("menu_id", str3);
            String i = this.b.i();
            if (this.b.a().b().b()) {
                a.b(i);
            } else {
                a.a(this.b.f());
            }
        } catch (Exception e) {
            a.a(e.getMessage());
            BdLog.e(e.getMessage());
        }
        return a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(o oVar) {
        this.a.a(oVar, false);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.g();
            this.b = null;
        }
        this.a.a(null, true);
    }
}
