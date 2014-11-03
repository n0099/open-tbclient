package com.baidu.tieba.more;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TiebaDatabase;
import com.baidu.tbadk.pluginArch.Plugin;
import com.baidu.tbadk.pluginArch.PluginCenter;
import com.baidu.tbadk.pluginArch.PluginNameList;
import com.baidu.tbadk.plugins.BaobaoSdkDelegate;
import com.baidu.tieba.model.MoreModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw extends BdAsyncTask<String, Integer, String> {
    final /* synthetic */ av bta;

    private aw(av avVar) {
        this.bta = avVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ aw(av avVar, aw awVar) {
        this(avVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        BaseActivity.LoadDataCallBack loadDataCallBack;
        BaseActivity.LoadDataCallBack loadDataCallBack2;
        super.onPostExecute((aw) str);
        this.bta.bsY = null;
        loadDataCallBack = this.bta.ats;
        if (loadDataCallBack == null) {
            return;
        }
        loadDataCallBack2 = this.bta.ats;
        loadDataCallBack2.callback(MoreModel.TaskType.DO_CACHE_CLEAR);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: h */
    public String doInBackground(String... strArr) {
        BaobaoSdkDelegate baobaoSdkDelegate;
        TiebaDatabase.getInstance().getSdcardMainDBDatabaseManager().R();
        com.baidu.tbadk.core.voice.a.b.nJ();
        try {
            com.baidu.tbadk.core.util.ay.my().mz();
            com.baidu.tbadk.core.util.ay.my().mA();
            Plugin pluginByName = PluginCenter.getInstance().getPluginByName(PluginNameList.NAME_BAOBAO);
            if (pluginByName != null && (baobaoSdkDelegate = (BaobaoSdkDelegate) pluginByName.getClassInstance(BaobaoSdkDelegate.class)) != null) {
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
