package com.baidu.tieba.more;

import android.content.Context;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.model.MoreModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av extends BdAsyncTask<String, String, String> {
    final /* synthetic */ at bwx;

    private av(at atVar) {
        this.bwx = atVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ av(at atVar, av avVar) {
        this(atVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: l */
    public String doInBackground(String... strArr) {
        Context context;
        String or = com.baidu.tbadk.core.util.s.or();
        long k = com.baidu.tbadk.core.util.s.k(TbConfig.IMAGE_CACHE_DIR_NAME, false) + com.baidu.tbadk.core.util.s.k(String.valueOf(or) + TbConfig.TMP_PIC_DIR_NAME, false) + com.baidu.tbadk.core.util.s.k(String.valueOf(or) + "voice", false) + com.baidu.tbadk.core.util.s.cq(String.valueOf(or) + TbConfig.TMP_DATABASE_NAME);
        float f = 0.0f + ((float) k);
        if (k < 10485.76d) {
            return "";
        }
        StringBuilder sb = new StringBuilder(String.valueOf(String.format("%.2f", Float.valueOf(f / 1048576.0f))));
        context = this.bwx.mContext;
        return sb.append(context.getString(com.baidu.tieba.z.mebibyte)).toString();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        BaseActivity.LoadDataCallBack loadDataCallBack;
        BaseActivity.LoadDataCallBack loadDataCallBack2;
        super.onPostExecute((av) str);
        this.bwx.bww = null;
        loadDataCallBack = this.bwx.AQ;
        if (loadDataCallBack == null) {
            return;
        }
        loadDataCallBack2 = this.bwx.AQ;
        loadDataCallBack2.callback(MoreModel.TaskType.GET_SIZE, str);
    }
}
