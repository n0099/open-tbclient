package com.baidu.tieba.more;

import android.content.Context;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.model.MoreModel;
import com.baidu.tieba.switchs.SwitchKey;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax extends BdAsyncTask<String, String, String> {
    final /* synthetic */ au a;

    private ax(au auVar) {
        this.a = auVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ax(au auVar, ax axVar) {
        this(auVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(String... strArr) {
        Context context;
        String d = com.baidu.tieba.util.af.d();
        long a = com.baidu.tieba.util.af.a(String.valueOf(d) + "image", false) + com.baidu.tieba.util.af.a(String.valueOf(d) + SwitchKey.VOICE, false) + com.baidu.tieba.util.af.k(String.valueOf(d) + "tieba_database.db");
        float f = 0.0f + ((float) a);
        if (a < 10485.76d) {
            return "";
        }
        StringBuilder sb = new StringBuilder(String.valueOf(String.format("%.2f", Float.valueOf(f / 1048576.0f))));
        context = this.a.d;
        return sb.append(context.getString(R.string.mebibyte)).toString();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        com.baidu.tieba.i iVar;
        com.baidu.tieba.i iVar2;
        super.a((ax) str);
        this.a.c = null;
        iVar = this.a.e;
        if (iVar == null) {
            return;
        }
        iVar2 = this.a.e;
        iVar2.a(MoreModel.TaskType.GET_SIZE, str);
    }
}
