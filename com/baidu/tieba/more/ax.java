package com.baidu.tieba.more;

import android.content.Context;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.model.MoreModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax extends BdAsyncTask<String, String, String> {
    final /* synthetic */ av bta;

    private ax(av avVar) {
        this.bta = avVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ax(av avVar, ax axVar) {
        this(avVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: h */
    public String doInBackground(String... strArr) {
        Context context;
        String lw = com.baidu.tbadk.core.util.s.lw();
        long i = com.baidu.tbadk.core.util.s.i(TbConfig.IMAGE_CACHE_DIR_NAME, false) + com.baidu.tbadk.core.util.s.i(String.valueOf(lw) + TbConfig.TMP_PIC_DIR_NAME, false) + com.baidu.tbadk.core.util.s.i(String.valueOf(lw) + "voice", false) + com.baidu.tbadk.core.util.s.by(String.valueOf(lw) + TbConfig.TMP_DATABASE_NAME);
        float f = 0.0f + ((float) i);
        if (i < 10485.76d) {
            return "";
        }
        StringBuilder sb = new StringBuilder(String.valueOf(String.format("%.2f", Float.valueOf(f / 1048576.0f))));
        context = this.bta.mContext;
        return sb.append(context.getString(com.baidu.tieba.y.mebibyte)).toString();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        BaseActivity.LoadDataCallBack loadDataCallBack;
        BaseActivity.LoadDataCallBack loadDataCallBack2;
        super.onPostExecute((ax) str);
        this.bta.bsZ = null;
        loadDataCallBack = this.bta.ats;
        if (loadDataCallBack == null) {
            return;
        }
        loadDataCallBack2 = this.bta.ats;
        loadDataCallBack2.callback(MoreModel.TaskType.GET_SIZE, str);
    }
}
