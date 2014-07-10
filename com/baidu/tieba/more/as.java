package com.baidu.tieba.more;

import android.content.Context;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.model.MoreModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as extends BdAsyncTask<String, String, String> {
    final /* synthetic */ aq a;

    private as(aq aqVar) {
        this.a = aqVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ as(aq aqVar, as asVar) {
        this(aqVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public String doInBackground(String... strArr) {
        Context context;
        String d = com.baidu.tbadk.core.util.z.d();
        long a = com.baidu.tbadk.core.util.z.a(TbConfig.IMAGE_CACHE_DIR_NAME, false) + com.baidu.tbadk.core.util.z.a(String.valueOf(d) + TbConfig.TMP_PIC_DIR_NAME, false) + com.baidu.tbadk.core.util.z.a(String.valueOf(d) + "voice", false) + com.baidu.tbadk.core.util.z.k(String.valueOf(d) + TbConfig.TMP_DATABASE_NAME);
        float f = 0.0f + ((float) a);
        if (a < 10485.76d) {
            return "";
        }
        StringBuilder sb = new StringBuilder(String.valueOf(String.format("%.2f", Float.valueOf(f / 1048576.0f))));
        context = this.a.c;
        return sb.append(context.getString(com.baidu.tieba.y.mebibyte)).toString();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(String str) {
        BaseActivity.LoadDataCallBack loadDataCallBack;
        BaseActivity.LoadDataCallBack loadDataCallBack2;
        super.onPostExecute(str);
        this.a.b = null;
        loadDataCallBack = this.a.d;
        if (loadDataCallBack == null) {
            return;
        }
        loadDataCallBack2 = this.a.d;
        loadDataCallBack2.callback(MoreModel.TaskType.GET_SIZE, str);
    }
}
