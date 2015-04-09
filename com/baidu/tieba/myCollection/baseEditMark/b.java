package com.baidu.tieba.myCollection.baseEditMark;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aa;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends BdAsyncTask<Boolean, Integer, Boolean> {
    private aa Ok = null;
    private i bEB;
    final /* synthetic */ a bEC;
    private int pos;
    private String tid;

    public b(a aVar, String str, int i) {
        this.bEC = aVar;
        this.tid = null;
        this.pos = 0;
        this.bEB = null;
        this.tid = str;
        this.pos = i;
        this.bEB = new i();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public Boolean doInBackground(Boolean... boolArr) {
        this.Ok = new aa(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.MARK_DELSTORE);
        this.Ok.o("user_id", TbadkCoreApplication.getCurrentAccount());
        this.Ok.o("tid", this.tid);
        this.bEB.parserJson(this.Ok.rO());
        return this.Ok.sp().tq().pv() && this.bEB.getErrorCode() == 0;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.Ok != null) {
            this.Ok.hh();
        }
        this.bEC.bEv = null;
        if (this.bEC.bEA != null) {
            this.bEC.bEA.callback(2, false, null);
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
        this.bEC.bEv = null;
        if (bool.booleanValue()) {
            int i2 = this.pos;
            arrayList = this.bEC.bEw;
            if (i2 < arrayList.size()) {
                arrayList2 = this.bEC.bEw;
                arrayList2.remove(this.pos);
                a aVar = this.bEC;
                i = aVar.bEy;
                aVar.bEy = i - 1;
            }
        } else if (this.Ok.sp().tq().pv()) {
            str = this.bEB.getErrorString();
        } else {
            str = this.Ok.getErrorString();
        }
        if (this.bEC.bEA != null) {
            this.bEC.bEA.callback(2, bool, str);
        }
    }
}
