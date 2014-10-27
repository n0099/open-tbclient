package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends BdAsyncTask<Boolean, Integer, Boolean> {
    private com.baidu.tieba.data.at boo;
    final /* synthetic */ j bop;
    private com.baidu.tbadk.core.util.ac mNetWork = null;
    private int pos;
    private String tid;

    public k(j jVar, String str, int i) {
        this.bop = jVar;
        this.tid = null;
        this.pos = 0;
        this.boo = null;
        this.tid = str;
        this.pos = i;
        this.boo = new com.baidu.tieba.data.at();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public Boolean doInBackground(Boolean... boolArr) {
        this.mNetWork = new com.baidu.tbadk.core.util.ac(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/post/rmstore");
        this.mNetWork.k(com.baidu.tbadk.core.frameworkData.a.USER_ID, TbadkApplication.getCurrentAccount());
        this.mNetWork.k("tid", this.tid);
        this.boo.parserJson(this.mNetWork.lA());
        return this.mNetWork.mc().nb().jq() && this.boo.getErrorCode() == 0;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.mNetWork != null) {
            this.mNetWork.dM();
        }
        this.bop.bok = null;
        if (this.bop.atj != null) {
            this.bop.atj.callback(2, false, null);
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
        this.bop.bok = null;
        if (bool.booleanValue()) {
            int i2 = this.pos;
            arrayList = this.bop.bol;
            if (i2 < arrayList.size()) {
                arrayList2 = this.bop.bol;
                arrayList2.remove(this.pos);
                j jVar = this.bop;
                i = jVar.bon;
                jVar.bon = i - 1;
            }
        } else if (this.mNetWork.mc().nb().jq()) {
            str = this.boo.getErrorString();
        } else {
            str = this.mNetWork.getErrorString();
        }
        if (this.bop.atj != null) {
            this.bop.atj.callback(2, bool, str);
        }
    }
}
