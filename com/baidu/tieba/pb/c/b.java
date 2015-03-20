package com.baidu.tieba.pb.c;

import android.graphics.Bitmap;
import com.baidu.adp.base.i;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.c;
import com.baidu.tbadk.core.util.o;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends BdAsyncTask<Object, Integer, Bitmap> {
    final /* synthetic */ a bHD;
    private String filename;

    public b(a aVar, String str) {
        this.bHD = aVar;
        this.filename = null;
        this.filename = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: k */
    public Bitmap doInBackground(Object... objArr) {
        if (this.filename != null && !this.filename.equals(TbConfig.IMAGE_RESIZED_FILE)) {
            o.aa("photos/" + this.filename, TbConfig.IMAGE_RESIZED_FILE);
        }
        return c.a(c.e(o.Y(null, TbConfig.IMAGE_RESIZED_FILE)), 5.0f, true);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        i iVar;
        i iVar2;
        this.bHD.bHC = null;
        iVar = this.bHD.mLoadDataCallBack;
        if (iVar != null) {
            iVar2 = this.bHD.mLoadDataCallBack;
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
        super.onPostExecute((b) bitmap);
        this.bHD.bHC = null;
        iVar = this.bHD.mLoadDataCallBack;
        if (iVar != null) {
            iVar2 = this.bHD.mLoadDataCallBack;
            iVar2.c(bitmap);
        }
    }
}
