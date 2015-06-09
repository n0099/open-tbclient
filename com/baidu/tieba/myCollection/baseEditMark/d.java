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
    private i bHx;
    final /* synthetic */ a bHy;

    private d(a aVar) {
        this.bHy = aVar;
        this.OE = null;
        this.bHx = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ d(a aVar, d dVar) {
        this(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        this.bHx = new i();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public Boolean doInBackground(a... aVarArr) {
        a aVar = new a();
        try {
            aVar.ZM();
            this.OE = new aa();
            this.OE.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.MARK_ADDSTORE);
            int ZN = this.bHy.ZN();
            if (aVar.getCount() - 1 <= ZN) {
                ZN = aVar.getCount() - 1;
            }
            while (ZN >= 0) {
                String af = aVar.af(ZN, 20);
                this.OE.n(new ArrayList<>());
                this.OE.o("data", af);
                this.bHx.parserJson(this.OE.sw());
                if (!this.OE.sX().tT().qa() || this.bHx.getErrorCode() != 0) {
                    break;
                }
                ZN -= 20;
            }
            this.bHy.hs(ZN);
            if (ZN >= 0) {
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
        this.bHy.bHq = null;
        if (this.bHy.bHw != null) {
            this.bHy.bHw.callback(1, false, null, false);
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
        this.bHy.bHq = null;
        if (bool.booleanValue()) {
            arrayList = this.bHy.bHs;
            arrayList.clear();
            str = null;
            z = false;
        } else if (this.OE.sX().tT().qa()) {
            str = this.bHx.getErrorString();
            z = false;
        } else {
            str = null;
            z = true;
        }
        if (this.bHy.bHw != null) {
            this.bHy.bHw.callback(1, bool, str, Boolean.valueOf(z));
        }
    }
}
