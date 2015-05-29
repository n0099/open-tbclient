package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.aa;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends BdAsyncTask<a, Integer, Boolean> {
    private aa OE;
    private i bHw;
    final /* synthetic */ a bHx;

    private d(a aVar) {
        this.bHx = aVar;
        this.OE = null;
        this.bHw = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ d(a aVar, d dVar) {
        this(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        this.bHw = new i();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public Boolean doInBackground(a... aVarArr) {
        a aVar = new a();
        try {
            aVar.ZL();
            this.OE = new aa();
            this.OE.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.MARK_ADDSTORE);
            int ZM = this.bHx.ZM();
            if (aVar.getCount() - 1 <= ZM) {
                ZM = aVar.getCount() - 1;
            }
            while (ZM >= 0) {
                String af = aVar.af(ZM, 20);
                this.OE.n(new ArrayList<>());
                this.OE.o("data", af);
                this.bHw.parserJson(this.OE.sw());
                if (!this.OE.sX().tT().qa() || this.bHw.getErrorCode() != 0) {
                    break;
                }
                ZM -= 20;
            }
            this.bHx.hs(ZM);
            if (ZM >= 0) {
                return false;
            }
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.OE != null) {
            this.OE.gS();
        }
        this.bHx.bHp = null;
        if (this.bHx.bHv != null) {
            this.bHx.bHv.callback(1, false, null, false);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public void onPostExecute(Boolean bool) {
        String str;
        boolean z;
        ArrayList arrayList;
        this.bHx.bHp = null;
        if (bool.booleanValue()) {
            arrayList = this.bHx.bHr;
            arrayList.clear();
            str = null;
            z = false;
        } else if (this.OE.sX().tT().qa()) {
            str = this.bHw.getErrorString();
            z = false;
        } else {
            str = null;
            z = true;
        }
        if (this.bHx.bHv != null) {
            this.bHx.bHv.callback(1, bool, str, Boolean.valueOf(z));
        }
    }
}
