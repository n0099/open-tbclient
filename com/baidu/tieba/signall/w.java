package com.baidu.tieba.signall;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.ai;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends BdAsyncTask<String, Integer, s> {
    final /* synthetic */ u a;
    private h b = null;

    public w(u uVar) {
        this.a = uVar;
        setPriority(3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        super.onPreExecute();
        this.a.a = true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public s doInBackground(String... strArr) {
        s sVar;
        if (strArr[0] == null) {
            return null;
        }
        String[] split = strArr[0].split(",");
        int ceil = (int) Math.ceil(split.length / 50.0f);
        for (int i = 0; i < ceil; i++) {
            int i2 = i * 50;
            StringBuilder sb = new StringBuilder();
            for (int i3 = 0; i3 < 50 && i2 + i3 < split.length; i3++) {
                if (i2 + i3 == split.length - 1) {
                    sb.append(split[i2 + i3]);
                } else {
                    sb.append(String.valueOf(split[i2 + i3]) + ",");
                }
            }
            this.b = new h();
            if (UtilHelper.getNetStatusInfo(ai.c().d().getApplicationContext()) != UtilHelper.NetworkStateInfo.UNAVAIL) {
                a(sb.toString());
            }
        }
        sVar = this.a.c;
        return sVar;
    }

    private s a(String str) {
        s sVar;
        s sVar2;
        String a = this.b.a(str);
        if (this.b.b()) {
            sVar = this.a.c;
            sVar.a(a);
            sVar2 = this.a.c;
            return sVar2;
        }
        this.a.c = null;
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel();
        this.b.a();
        this.b = null;
        this.a.b = null;
        this.a.a = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(s sVar) {
        v vVar;
        s sVar2;
        v vVar2;
        v vVar3;
        s sVar3;
        this.a.a = false;
        this.a.b = null;
        vVar = this.a.d;
        if (vVar != null) {
            sVar2 = this.a.c;
            if (sVar2 != null) {
                vVar3 = this.a.d;
                sVar3 = this.a.c;
                vVar3.a(sVar3);
                return;
            }
            String c = this.b != null ? this.b.c() : null;
            vVar2 = this.a.d;
            vVar2.a(c);
        }
    }
}
