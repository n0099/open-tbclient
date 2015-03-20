package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends BdAsyncTask<Object, u, Void> {
    private int bDm;
    final /* synthetic */ e ckm;
    FRSPageRequestMessage ckt;
    private final WeakReference<BaseActivity> cku;
    private String mName;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        aa aaVar;
        aa aaVar2;
        aaVar = this.ckm.cke;
        if (aaVar != null) {
            aaVar2 = this.ckm.cke;
            aaVar2.eG(this.bDm);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Object... objArr) {
        boolean z;
        try {
            z = this.ckm.ckj;
            if (z && d.ako().is(this.mName)) {
                if (!d.ako().isSameDay(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + this.mName)) {
                    d.ako().getResponseData().YO().getSignData().setIsSigned(0);
                }
                publishProgress(d.ako().getResponseData());
            }
            this.ckm.aDj = System.currentTimeMillis();
            return null;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onProgressUpdate(u... uVarArr) {
        aa aaVar;
        aa aaVar2;
        aaVar = this.ckm.cke;
        if (aaVar != null) {
            aaVar2 = this.ckm.cke;
            aaVar2.b(uVarArr.length > 0 ? uVarArr[0] : null);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public void onPostExecute(Void r3) {
        boolean z;
        this.ckt.setUpdateType(this.bDm);
        FRSPageRequestMessage fRSPageRequestMessage = this.ckt;
        z = this.ckm.ckj;
        fRSPageRequestMessage.setNeedCache(z);
        if (this.cku != null && this.cku.get() != null) {
            this.cku.get().sendMessage(this.ckt);
        }
        this.ckm.ckh = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onCancelled() {
        super.onCancelled();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        aa aaVar;
        aa aaVar2;
        super.cancel(true);
        aaVar = this.ckm.cke;
        if (aaVar != null) {
            aaVar2 = this.ckm.cke;
            aaVar2.a(this.bDm, true, null);
        }
    }
}
