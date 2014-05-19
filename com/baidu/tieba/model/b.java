package com.baidu.tieba.model;

import android.content.Context;
import android.os.Build;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends BdAsyncTask<String, Integer, bb> {
    com.baidu.tbadk.core.util.al a;
    final /* synthetic */ a b;

    private b(a aVar) {
        this.b = aVar;
        this.a = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ b(a aVar, b bVar) {
        this(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        super.onPreExecute();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public bb doInBackground(String... strArr) {
        bb bbVar;
        Exception e;
        Context context;
        try {
            this.a = new com.baidu.tbadk.core.util.al(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/sync");
            this.a.a("_os_version", Build.VERSION.RELEASE);
            StringBuffer stringBuffer = new StringBuffer(15);
            stringBuffer.append(String.valueOf(com.baidu.adp.lib.util.h.b(com.baidu.tieba.ad.c().d())));
            stringBuffer.append(",");
            stringBuffer.append(String.valueOf(com.baidu.adp.lib.util.h.c(com.baidu.tieba.ad.c().d())));
            this.a.a("_phone_screen", stringBuffer.toString());
            if (TbadkApplication.m252getInst().getMsgFrequency() > 0) {
                this.a.a("_msg_status", "0");
            } else {
                this.a.a("_msg_status", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
            }
            String i = this.a.i();
            if (!this.a.a().b().b()) {
                return null;
            }
            bbVar = new bb();
            try {
                bbVar.a(i);
                if (TbadkApplication.getClientId() == null && bbVar.d().a() != null && bbVar.d().a().length() > 0) {
                    context = this.b.c;
                    TbadkApplication.saveClientId(context, bbVar.d().a());
                    TbadkApplication.setClientId(bbVar.d().a());
                    return bbVar;
                }
                return bbVar;
            } catch (Exception e2) {
                e = e2;
                BdLog.e(getClass().getName(), "doInBackground", e.getMessage());
                return bbVar;
            }
        } catch (Exception e3) {
            bbVar = null;
            e = e3;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.b.b = null;
        if (this.a != null) {
            this.a.g();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(bb bbVar) {
        super.onPostExecute(bbVar);
        this.b.b = null;
        this.b.a.a(bbVar);
    }
}
