package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aa;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends BdAsyncTask<Boolean, Integer, Boolean> {
    private aa OE = null;
    private i bHx;
    final /* synthetic */ a bHy;
    private int pos;
    private String tid;

    public b(a aVar, String str, int i) {
        this.bHy = aVar;
        this.tid = null;
        this.pos = 0;
        this.bHx = null;
        this.tid = str;
        this.pos = i;
        this.bHx = new i();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public Boolean doInBackground(Boolean... boolArr) {
        this.OE = new aa(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.MARK_DELSTORE);
        this.OE.o("user_id", TbadkCoreApplication.getCurrentAccount());
        this.OE.o("tid", this.tid);
        this.bHx.parserJson(this.OE.sw());
        return this.OE.sX().tT().qa() && this.bHx.getErrorCode() == 0;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.OE != null) {
            this.OE.gS();
        }
        this.bHy.bHr = null;
        if (this.bHy.bHw != null) {
            this.bHy.bHw.callback(2, false, null);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public void onPostExecute(Boolean bool) {
        ArrayList arrayList;
        ArrayList arrayList2;
        int i;
        String str = null;
        this.bHy.bHr = null;
        if (bool.booleanValue()) {
            int i2 = this.pos;
            arrayList = this.bHy.bHs;
            if (i2 < arrayList.size()) {
                arrayList2 = this.bHy.bHs;
                arrayList2.remove(this.pos);
                a aVar = this.bHy;
                i = aVar.bHu;
                aVar.bHu = i - 1;
            }
        } else if (this.OE.sX().tT().qa()) {
            str = this.bHx.getErrorString();
        } else {
            str = this.OE.getErrorString();
        }
        if (this.bHy.bHw != null) {
            this.bHy.bHw.callback(2, bool, str);
        }
    }
}
