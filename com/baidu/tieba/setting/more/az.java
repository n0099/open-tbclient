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
public class az extends BdAsyncTask<String, Integer, String> {
    final /* synthetic */ ay ccb;

    private az(ay ayVar) {
        this.ccb = ayVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ az(ay ayVar, az azVar) {
        this(ayVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        BaseActivity.LoadDataCallBack loadDataCallBack;
        BaseActivity.LoadDataCallBack loadDataCallBack2;
        super.onPostExecute((az) str);
        this.ccb.cbZ = null;
        loadDataCallBack = this.ccb.bEn;
        if (loadDataCallBack == null) {
            return;
        }
        loadDataCallBack2 = this.ccb.bEn;
        loadDataCallBack2.callback(MoreModel.TaskType.DO_CACHE_CLEAR);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String doInBackground(String... strArr) {
        TiebaDatabase.getInstance().getSdcardMainDBDatabaseManager().dK();
        com.baidu.tbadk.core.voice.a.b.tY();
        try {
            com.baidu.tbadk.core.util.bc.sT().sU();
            com.baidu.tbadk.core.util.bc.sT().sV();
            MessageManager.getInstance().sendMessageFromBackground(new CustomMessage(2802002, ""));
            return null;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
