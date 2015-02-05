package com.baidu.tieba.model;

import android.graphics.Bitmap;
import com.baidu.adp.base.i;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends BdAsyncTask<Object, Integer, Bitmap> {
    final /* synthetic */ m buE;
    private String filename;

    public n(m mVar, String str) {
        this.buE = mVar;
        this.filename = null;
        this.filename = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: k */
    public Bitmap doInBackground(Object... objArr) {
        if (this.filename != null && !this.filename.equals(TbConfig.IMAGE_RESIZED_FILE)) {
            com.baidu.tbadk.core.util.s.Z("photos/" + this.filename, TbConfig.IMAGE_RESIZED_FILE);
        }
        return com.baidu.tbadk.core.util.d.a(com.baidu.tbadk.core.util.d.e(com.baidu.tbadk.core.util.s.X(null, TbConfig.IMAGE_RESIZED_FILE)), 5.0f, true);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        i iVar;
        i iVar2;
        this.buE.buD = null;
        iVar = this.buE.mLoadDataCallBack;
        if (iVar != null) {
            iVar2 = this.buE.mLoadDataCallBack;
            iVar2.c(null);
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
    public void onPostExecute(Bitmap bitmap) {
        i iVar;
        i iVar2;
        super.onPostExecute((n) bitmap);
        this.buE.buD = null;
        iVar = this.buE.mLoadDataCallBack;
        if (iVar != null) {
            iVar2 = this.buE.mLoadDataCallBack;
            iVar2.c(bitmap);
        }
    }
}
