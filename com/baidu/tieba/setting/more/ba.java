package com.baidu.tieba.setting.more;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TiebaDatabase;
import com.baidu.tieba.setting.model.MoreModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba extends BdAsyncTask<String, Integer, String> {
    final /* synthetic */ az cgT;

    private ba(az azVar) {
        this.cgT = azVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ba(az azVar, ba baVar) {
        this(azVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        BaseActivity.LoadDataCallBack loadDataCallBack;
        BaseActivity.LoadDataCallBack loadDataCallBack2;
        super.onPostExecute((ba) str);
        this.cgT.cgR = null;
        loadDataCallBack = this.cgT.bHv;
        if (loadDataCallBack == null) {
            return;
        }
        loadDataCallBack2 = this.cgT.bHv;
        loadDataCallBack2.callback(MoreModel.TaskType.DO_CACHE_CLEAR);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String doInBackground(String... strArr) {
        TiebaDatabase.getInstance().getSdcardMainDBDatabaseManager().dM();
        com.baidu.tbadk.core.voice.a.b.uH();
        try {
            com.baidu.tbadk.core.util.ba.tw().tx();
            com.baidu.tbadk.core.util.ba.tw().ty();
            MessageManager.getInstance().sendMessageFromBackground(new CustomMessage(2802002, ""));
            return null;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
