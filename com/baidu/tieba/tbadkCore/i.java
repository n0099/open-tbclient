package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends BdAsyncTask<Object, u, Void> {
    private int bGu;
    final /* synthetic */ e coC;
    FRSPageRequestMessage coJ;
    private final WeakReference<BaseActivity> coK;
    private String mName;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        aa aaVar;
        aa aaVar2;
        aaVar = this.coC.cou;
        if (aaVar != null) {
            aaVar2 = this.coC.cou;
            aaVar2.eU(this.bGu);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Object... objArr) {
        boolean z;
        try {
            z = this.coC.coz;
            if (z && d.amo().jo(this.mName)) {
                if (!d.amo().isSameDay(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + this.mName)) {
                    d.amo().getResponseData().aar().getSignData().setIsSigned(0);
                }
                publishProgress(d.amo().getResponseData());
            }
            this.coC.aFt = System.currentTimeMillis();
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
        aaVar = this.coC.cou;
        if (aaVar != null) {
            aaVar2 = this.coC.cou;
            aaVar2.b(uVarArr.length > 0 ? uVarArr[0] : null);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public void onPostExecute(Void r3) {
        boolean z;
        this.coJ.setUpdateType(this.bGu);
        FRSPageRequestMessage fRSPageRequestMessage = this.coJ;
        z = this.coC.coz;
        fRSPageRequestMessage.setNeedCache(z);
        if (this.coK != null && this.coK.get() != null) {
            this.coK.get().sendMessage(this.coJ);
        }
        this.coC.cox = null;
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
        aaVar = this.coC.cou;
        if (aaVar != null) {
            aaVar2 = this.coC.cou;
            aaVar2.a(this.bGu, true, null);
        }
    }
}
