package com.baidu.tieba.more;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.DatabaseManager;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.model.MoreModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak extends BdAsyncTask<String, Integer, String> {
    final /* synthetic */ aj a;

    private ak(aj ajVar) {
        this.a = ajVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ak(aj ajVar, ak akVar) {
        this(ajVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(String str) {
        BaseActivity.LoadDataCallBack loadDataCallBack;
        BaseActivity.LoadDataCallBack loadDataCallBack2;
        super.onPostExecute(str);
        this.a.a = null;
        loadDataCallBack = this.a.e;
        if (loadDataCallBack == null) {
            return;
        }
        loadDataCallBack2 = this.a.e;
        loadDataCallBack2.callback(MoreModel.TaskType.DO_CACHE_CLEAR);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public String doInBackground(String... strArr) {
        new DatabaseManager(DatabaseManager.DatabaseLocation.SDCARD).b();
        com.baidu.tbadk.core.voice.a.e.a();
        try {
            bf.a().b();
            bf.a().c();
            return null;
        } catch (Exception e) {
            BdLog.e(getClass().getName(), "doInBackground", e.getMessage());
            return null;
        }
    }
}
