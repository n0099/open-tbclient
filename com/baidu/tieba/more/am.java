package com.baidu.tieba.more;

import android.content.Context;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.model.MoreModel;
import com.baidu.tieba.switchs.features.VoiceSwitchStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class am extends BdAsyncTask<String, String, String> {
    final /* synthetic */ aj a;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ String a(String... strArr) {
        Context context;
        String d = com.baidu.tbadk.core.util.w.d();
        long a = com.baidu.tbadk.core.util.w.a(String.valueOf(d) + "image", false) + com.baidu.tbadk.core.util.w.a(String.valueOf(d) + VoiceSwitchStatic.VOICE, false) + com.baidu.tbadk.core.util.w.k(String.valueOf(d) + "tieba_database.db");
        float f = 0.0f + ((float) a);
        if (a >= 10485.76d) {
            StringBuilder sb = new StringBuilder(String.valueOf(String.format("%.2f", Float.valueOf(f / 1048576.0f))));
            context = this.a.d;
            return sb.append(context.getString(com.baidu.tieba.a.k.mebibyte)).toString();
        }
        return "";
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ void a(String str) {
        com.baidu.tbadk.d dVar;
        com.baidu.tbadk.d dVar2;
        String str2 = str;
        super.a((am) str2);
        this.a.c = null;
        dVar = this.a.e;
        if (dVar != null) {
            dVar2 = this.a.e;
            dVar2.a(MoreModel.TaskType.GET_SIZE, str2);
        }
    }

    private am(aj ajVar) {
        this.a = ajVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ am(aj ajVar, byte b) {
        this(ajVar);
    }
}
