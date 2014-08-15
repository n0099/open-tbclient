package com.baidu.tieba.signall;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.ai;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends BdAsyncTask<String, Integer, r> {
    final /* synthetic */ t a;
    private h b = null;

    public v(t tVar) {
        this.a = tVar;
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
    public r doInBackground(String... strArr) {
        r rVar;
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
        rVar = this.a.c;
        return rVar;
    }

    private r a(String str) {
        r rVar;
        r rVar2;
        String a = this.b.a(str);
        if (this.b.b()) {
            rVar = this.a.c;
            rVar.a(a);
            rVar2 = this.a.c;
            return rVar2;
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
    public void onPostExecute(r rVar) {
        u uVar;
        r rVar2;
        u uVar2;
        u uVar3;
        r rVar3;
        this.a.a = false;
        this.a.b = null;
        uVar = this.a.d;
        if (uVar != null) {
            rVar2 = this.a.c;
            if (rVar2 != null) {
                uVar3 = this.a.d;
                rVar3 = this.a.c;
                uVar3.a(rVar3);
                return;
            }
            String c = this.b != null ? this.b.c() : null;
            uVar2 = this.a.d;
            uVar2.a(c);
        }
    }
}
