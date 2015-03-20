package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aa;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends BdAsyncTask<Boolean, Integer, Boolean> {
    private aa Oi = null;
    private i bEo;
    final /* synthetic */ a bEp;
    private int pos;
    private String tid;

    public b(a aVar, String str, int i) {
        this.bEp = aVar;
        this.tid = null;
        this.pos = 0;
        this.bEo = null;
        this.tid = str;
        this.pos = i;
        this.bEo = new i();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public Boolean doInBackground(Boolean... boolArr) {
        this.Oi = new aa(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.MARK_DELSTORE);
        this.Oi.o("user_id", TbadkCoreApplication.getCurrentAccount());
        this.Oi.o("tid", this.tid);
        this.bEo.parserJson(this.Oi.rO());
        return this.Oi.sp().tq().pv() && this.bEo.getErrorCode() == 0;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.Oi != null) {
            this.Oi.hh();
        }
        this.bEp.bEi = null;
        if (this.bEp.bEn != null) {
            this.bEp.bEn.callback(2, false, null);
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
        this.bEp.bEi = null;
        if (bool.booleanValue()) {
            int i2 = this.pos;
            arrayList = this.bEp.bEj;
            if (i2 < arrayList.size()) {
                arrayList2 = this.bEp.bEj;
                arrayList2.remove(this.pos);
                a aVar = this.bEp;
                i = aVar.bEl;
                aVar.bEl = i - 1;
            }
        } else if (this.Oi.sp().tq().pv()) {
            str = this.bEo.getErrorString();
        } else {
            str = this.Oi.getErrorString();
        }
        if (this.bEp.bEn != null) {
            this.bEp.bEn.callback(2, bool, str);
        }
    }
}
