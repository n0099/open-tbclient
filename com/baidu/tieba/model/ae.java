package com.baidu.tieba.model;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae extends BdAsyncTask<Object, Integer, Bitmap> {
    private String bpi;
    final /* synthetic */ ad bpj;

    public ae(ad adVar, String str) {
        this.bpj = adVar;
        this.bpi = null;
        this.bpi = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: g */
    public Bitmap doInBackground(Object... objArr) {
        if (this.bpi != null && !this.bpi.equals(TbConfig.IMAGE_RESIZED_FILE)) {
            com.baidu.tbadk.core.util.s.M("photos/" + this.bpi, TbConfig.IMAGE_RESIZED_FILE);
        }
        return com.baidu.tbadk.core.util.d.a(com.baidu.tbadk.core.util.d.b(com.baidu.tbadk.core.util.s.K(null, TbConfig.IMAGE_RESIZED_FILE)), 5.0f, true);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.base.h hVar;
        com.baidu.adp.base.h hVar2;
        this.bpj.bph = null;
        hVar = this.bpj.mLoadDataCallBack;
        if (hVar != null) {
            hVar2 = this.bpj.mLoadDataCallBack;
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
    /* renamed from: e */
    public void onPostExecute(Bitmap bitmap) {
        com.baidu.adp.base.h hVar;
        com.baidu.adp.base.h hVar2;
        super.onPostExecute(bitmap);
        this.bpj.bph = null;
        hVar = this.bpj.mLoadDataCallBack;
        if (hVar != null) {
            hVar2 = this.bpj.mLoadDataCallBack;
            hVar2.a(bitmap);
        }
    }
}
