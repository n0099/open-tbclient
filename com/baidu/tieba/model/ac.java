package com.baidu.tieba.model;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac extends BdAsyncTask<Object, Integer, Bitmap> {
    final /* synthetic */ ab a;
    private String b;

    public ac(ab abVar, String str) {
        this.a = abVar;
        this.b = null;
        this.b = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public Bitmap doInBackground(Object... objArr) {
        if (this.b != null && !this.b.equals(TbConfig.IMAGE_RESIZED_FILE)) {
            com.baidu.tbadk.core.util.z.f("photos/" + this.b, TbConfig.IMAGE_RESIZED_FILE);
        }
        return com.baidu.tbadk.core.util.h.a(com.baidu.tbadk.core.util.h.b(com.baidu.tbadk.core.util.z.c(null, TbConfig.IMAGE_RESIZED_FILE)), 5.0f, true);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.base.h hVar;
        com.baidu.adp.base.h hVar2;
        this.a.a = null;
        hVar = this.a.mLoadDataCallBack;
        if (hVar != null) {
            hVar2 = this.a.mLoadDataCallBack;
            hVar2.a(null);
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
        com.baidu.adp.base.h hVar;
        com.baidu.adp.base.h hVar2;
        super.onPostExecute(bitmap);
        this.a.a = null;
        hVar = this.a.mLoadDataCallBack;
        if (hVar != null) {
            hVar2 = this.a.mLoadDataCallBack;
            hVar2.a(bitmap);
        }
    }
}
