package com.baidu.tieba.setting.more;

import android.content.Context;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.setting.model.MoreModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb extends BdAsyncTask<String, String, String> {
    final /* synthetic */ az cgT;

    private bb(az azVar) {
        this.cgT = azVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bb(az azVar, bb bbVar) {
        this(azVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String doInBackground(String... strArr) {
        Context context;
        String st = com.baidu.tbadk.core.util.o.st();
        long k = com.baidu.tbadk.core.util.o.k(TbConfig.IMAGE_CACHE_DIR_NAME, false) + com.baidu.tbadk.core.util.o.k(String.valueOf(st) + TbConfig.TMP_PIC_DIR_NAME, false) + com.baidu.tbadk.core.util.o.k(String.valueOf(st) + "voice", false) + com.baidu.tbadk.core.util.o.cI(String.valueOf(st) + TbConfig.TMP_DATABASE_NAME);
        float f = 0.0f + ((float) k);
        if (k < 10485.76d) {
            return "";
        }
        StringBuilder sb = new StringBuilder(String.valueOf(String.format("%.2f", Float.valueOf(f / 1048576.0f))));
        context = this.cgT.mContext;
        return sb.append(context.getString(com.baidu.tieba.t.mebibyte)).toString();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        BaseActivity.LoadDataCallBack loadDataCallBack;
        BaseActivity.LoadDataCallBack loadDataCallBack2;
        super.onPostExecute((bb) str);
        this.cgT.cgS = null;
        loadDataCallBack = this.cgT.bHv;
        if (loadDataCallBack == null) {
            return;
        }
        loadDataCallBack2 = this.cgT.bHv;
        loadDataCallBack2.callback(MoreModel.TaskType.GET_SIZE, str);
    }
}
