package com.baidu.tieba.more;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.DatabaseManager;
import com.baidu.tbadk.core.util.bl;
import com.baidu.tbadk.plugins.BaobaoSdkDelegate;
import com.baidu.tieba.model.MoreModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar extends BdAsyncTask<String, Integer, String> {
    final /* synthetic */ aq a;

    private ar(aq aqVar) {
        this.a = aqVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ar(aq aqVar, ar arVar) {
        this(aqVar);
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
        loadDataCallBack = this.a.d;
        if (loadDataCallBack == null) {
            return;
        }
        loadDataCallBack2 = this.a.d;
        loadDataCallBack2.callback(MoreModel.TaskType.DO_CACHE_CLEAR);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public String doInBackground(String... strArr) {
        new DatabaseManager(DatabaseManager.DatabaseLocation.SDCARD).b();
        com.baidu.tbadk.core.voice.a.b.a();
        try {
            bl.a().b();
            bl.a().c();
            BaobaoSdkDelegate baobaoSdkDelegate = (BaobaoSdkDelegate) com.baidu.tbadk.tbplugin.m.a().b(BaobaoSdkDelegate.class);
            if (baobaoSdkDelegate != null) {
                baobaoSdkDelegate.clearImage();
                return null;
            }
            return null;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }
}
