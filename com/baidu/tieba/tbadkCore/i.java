package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends BdAsyncTask<Object, e, Void> {
    final /* synthetic */ e bTS;
    FRSPageRequestMessage bTZ;
    private final WeakReference<BaseActivity> bUa;
    private int btQ;
    private String mName;

    public i(e eVar, BaseActivity baseActivity, FRSPageRequestMessage fRSPageRequestMessage, int i, String str) {
        this.bTS = eVar;
        this.mName = null;
        this.btQ = 3;
        this.bUa = new WeakReference<>(baseActivity);
        this.bTZ = fRSPageRequestMessage;
        this.mName = str;
        this.btQ = i;
        setSelfExecute(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        x xVar;
        x xVar2;
        xVar = this.bTS.bTJ;
        if (xVar != null) {
            xVar2 = this.bTS.bTJ;
            xVar2.eL(this.btQ);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Object... objArr) {
        boolean z;
        try {
            z = this.bTS.bTO;
            if (z && d.aeC().hY(this.mName)) {
                if (!d.aeC().isSameDay(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + this.mName)) {
                    d.aeC().getForumModel().aeI().getSignData().setIsSigned(0);
                }
                publishProgress(d.aeC().getForumModel());
            }
            this.bTS.bul = System.currentTimeMillis();
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
    public void onProgressUpdate(e... eVarArr) {
        x xVar;
        x xVar2;
        xVar = this.bTS.bTJ;
        if (xVar != null) {
            xVar2 = this.bTS.bTJ;
            xVar2.d(eVarArr.length > 0 ? eVarArr[0] : null);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public void onPostExecute(Void r3) {
        boolean z;
        this.bTZ.setUpdateType(this.btQ);
        FRSPageRequestMessage fRSPageRequestMessage = this.bTZ;
        z = this.bTS.bTO;
        fRSPageRequestMessage.setNeedCache(z);
        if (this.bUa != null && this.bUa.get() != null) {
            this.bUa.get().sendMessage(this.bTZ);
        }
        this.bTS.bTM = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onCancelled() {
        super.onCancelled();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        x xVar;
        x xVar2;
        super.cancel(true);
        xVar = this.bTS.bTJ;
        if (xVar != null) {
            xVar2 = this.bTS.bTJ;
            xVar2.a(this.btQ, true, null);
        }
    }
}
