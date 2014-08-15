package com.baidu.tieba.more;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.plugins.BaobaoSdkDelegate;
import com.baidu.tieba.model.MoreModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw extends BdAsyncTask<String, Integer, String> {
    final /* synthetic */ av a;

    private aw(av avVar) {
        this.a = avVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ aw(av avVar, aw awVar) {
        this(avVar);
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
        BaobaoSdkDelegate baobaoSdkDelegate;
        com.baidu.tbadk.j.a().c().c();
        com.baidu.tbadk.core.voice.a.b.a();
        try {
            az.a().b();
            az.a().c();
            com.baidu.tbadk.pluginArch.c a = com.baidu.tbadk.pluginArch.d.a().a("baobao");
            if (a != null && (baobaoSdkDelegate = (BaobaoSdkDelegate) a.a(BaobaoSdkDelegate.class)) != null) {
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
