package com.baidu.tieba.model;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad extends BdAsyncTask<Object, Integer, Bitmap> {
    final /* synthetic */ ac a;
    private String b;

    public ad(ac acVar, String str) {
        this.a = acVar;
        this.b = null;
        this.b = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public Bitmap doInBackground(Object... objArr) {
        if (this.b != null && !this.b.equals(TbConfig.IMAGE_RESIZED_FILE)) {
            com.baidu.tbadk.core.util.x.f("photos/" + this.b, TbConfig.IMAGE_RESIZED_FILE);
        }
        return com.baidu.tbadk.core.util.g.a(com.baidu.tbadk.core.util.g.b(com.baidu.tbadk.core.util.x.c(null, TbConfig.IMAGE_RESIZED_FILE)), 5.0f, true);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.base.g gVar;
        com.baidu.adp.base.g gVar2;
        this.a.a = null;
        gVar = this.a.mLoadDataCallBack;
        if (gVar != null) {
            gVar2 = this.a.mLoadDataCallBack;
            gVar2.a(null);
        }
        super.cancel(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onCancelled() {
        super.onCancelled();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(Bitmap bitmap) {
        com.baidu.adp.base.g gVar;
        com.baidu.adp.base.g gVar2;
        super.onPostExecute(bitmap);
        this.a.a = null;
        BdLog.i(getClass().getName(), "onPostExecute", "is Null?" + String.valueOf(bitmap == null));
        gVar = this.a.mLoadDataCallBack;
        if (gVar != null) {
            gVar2 = this.a.mLoadDataCallBack;
            gVar2.a(bitmap);
        }
    }
}
