package com.baidu.tieba.setting.more;

import android.content.Context;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.setting.model.MoreModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba extends BdAsyncTask<String, String, String> {
    final /* synthetic */ ay ccb;

    private ba(ay ayVar) {
        this.ccb = ayVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ba(ay ayVar, ba baVar) {
        this(ayVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String doInBackground(String... strArr) {
        Context context;
        String rK = com.baidu.tbadk.core.util.o.rK();
        long k = com.baidu.tbadk.core.util.o.k(TbConfig.IMAGE_CACHE_DIR_NAME, false) + com.baidu.tbadk.core.util.o.k(String.valueOf(rK) + TbConfig.TMP_PIC_DIR_NAME, false) + com.baidu.tbadk.core.util.o.k(String.valueOf(rK) + "voice", false) + com.baidu.tbadk.core.util.o.ct(String.valueOf(rK) + TbConfig.TMP_DATABASE_NAME);
        float f = 0.0f + ((float) k);
        if (k < 10485.76d) {
            return "";
        }
        StringBuilder sb = new StringBuilder(String.valueOf(String.format("%.2f", Float.valueOf(f / 1048576.0f))));
        context = this.ccb.mContext;
        return sb.append(context.getString(com.baidu.tieba.y.mebibyte)).toString();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        BaseActivity.LoadDataCallBack loadDataCallBack;
        BaseActivity.LoadDataCallBack loadDataCallBack2;
        super.onPostExecute((ba) str);
        this.ccb.cca = null;
        loadDataCallBack = this.ccb.bEn;
        if (loadDataCallBack == null) {
            return;
        }
        loadDataCallBack2 = this.ccb.bEn;
        loadDataCallBack2.callback(MoreModel.TaskType.GET_SIZE, str);
    }
}
