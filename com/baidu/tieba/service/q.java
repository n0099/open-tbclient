package com.baidu.tieba.service;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.data.ab;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends BdAsyncTask<String, Integer, ab> {
    int b;
    final /* synthetic */ TiebaMessageService c;
    an a = null;
    private final TbadkApplication d = TbadkApplication.m252getInst();
    private final String e = TbadkApplication.getCurrentAccount();

    public q(TiebaMessageService tiebaMessageService, int i) {
        this.c = tiebaMessageService;
        this.b = 0;
        this.b = i;
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
    public ab doInBackground(String... strArr) {
        ab abVar;
        Exception e;
        try {
        } catch (Exception e2) {
            abVar = null;
            e = e2;
        }
        if (this.d.isMsgRemindOn() && this.e != null && this.e.length() > 0) {
            this.a = new an(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/msg");
            if (this.b == 2) {
                this.a.a("bookmark", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
            }
            String i = this.a.i();
            if (this.a.a().b().b()) {
                abVar = new ab();
                try {
                    abVar.a(i);
                } catch (Exception e3) {
                    e = e3;
                    BdLog.e(getClass().getName(), "doInBackground", e.getMessage());
                    return abVar;
                }
            } else {
                abVar = null;
            }
            return abVar;
        }
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.c.mMessageAsyncTask = null;
        this.c.mBookmarkAsyncTask = null;
        if (this.a != null) {
            this.a.g();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(ab abVar) {
        try {
            super.onPostExecute(abVar);
            this.c.mMessageAsyncTask = null;
            this.c.mBookmarkAsyncTask = null;
            if (abVar != null) {
                this.c.mData = abVar;
                if (this.e != null && this.e.length() > 0) {
                    this.c.broadcastMsg(this.b);
                }
            }
        } catch (Exception e) {
            BdLog.e(getClass().getName(), "onPostExecute", e.getMessage());
        }
    }
}
