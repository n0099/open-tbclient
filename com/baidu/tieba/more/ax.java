package com.baidu.tieba.more;

import android.content.Context;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.model.MoreModel;
import com.baidu.tieba.switchs.SwitchKey;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ax extends BdAsyncTask<String, String, String> {
    final /* synthetic */ au a;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ String a(String... strArr) {
        Context context;
        String d = com.baidu.tieba.util.af.d();
        long a = com.baidu.tieba.util.af.a(String.valueOf(d) + "image", false) + com.baidu.tieba.util.af.a(String.valueOf(d) + SwitchKey.VOICE, false) + com.baidu.tieba.util.af.k(String.valueOf(d) + "tieba_database.db");
        float f = 0.0f + ((float) a);
        if (a >= 10485.76d) {
            StringBuilder sb = new StringBuilder(String.valueOf(String.format("%.2f", Float.valueOf(f / 1048576.0f))));
            context = this.a.d;
            return sb.append(context.getString(R.string.mebibyte)).toString();
        }
        return "";
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ void a(String str) {
        com.baidu.tieba.i iVar;
        com.baidu.tieba.i iVar2;
        String str2 = str;
        super.a((ax) str2);
        this.a.c = null;
        iVar = this.a.e;
        if (iVar != null) {
            iVar2 = this.a.e;
            iVar2.a(MoreModel.TaskType.GET_SIZE, str2);
        }
    }

    private ax(au auVar) {
        this.a = auVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ax(au auVar, byte b) {
        this(auVar);
    }
}
