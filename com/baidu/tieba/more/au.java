package com.baidu.tieba.more;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TiebaDatabase;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.model.MoreModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au extends BdAsyncTask<String, Integer, String> {
    final /* synthetic */ at bwx;

    private au(at atVar) {
        this.bwx = atVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ au(at atVar, au auVar) {
        this(atVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        BaseActivity.LoadDataCallBack loadDataCallBack;
        BaseActivity.LoadDataCallBack loadDataCallBack2;
        super.onPostExecute((au) str);
        this.bwx.bwv = null;
        loadDataCallBack = this.bwx.AQ;
        if (loadDataCallBack == null) {
            return;
        }
        loadDataCallBack2 = this.bwx.AQ;
        loadDataCallBack2.callback(MoreModel.TaskType.DO_CACHE_CLEAR);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: l */
    public String doInBackground(String... strArr) {
        TiebaDatabase.getInstance().getSdcardMainDBDatabaseManager().am();
        com.baidu.tbadk.core.voice.a.b.qK();
        try {
            az.ps().pt();
            az.ps().pu();
            MessageManager.getInstance().sendMessageFromBackground(new CustomMessage(2802002, ""));
            return null;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
