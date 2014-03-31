package com.baidu.tieba.model;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ad extends BdAsyncTask<Object, Integer, Bitmap> {
    final /* synthetic */ ac a;
    private String b;

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ Bitmap a(Object... objArr) {
        if (this.b != null && !this.b.equals("tieba_resized_image")) {
            com.baidu.tbadk.core.util.w.f("photos/" + this.b, "tieba_resized_image");
        }
        return com.baidu.tbadk.core.util.g.a(com.baidu.tbadk.core.util.g.b(com.baidu.tbadk.core.util.w.c(null, "tieba_resized_image")), 5.0f, true);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(Bitmap bitmap) {
        com.baidu.adp.a.h hVar;
        com.baidu.adp.a.h hVar2;
        Bitmap bitmap2 = bitmap;
        super.a((ad) bitmap2);
        this.a.a = null;
        com.baidu.adp.lib.util.f.a(getClass().getName(), "onPostExecute", "is Null?" + String.valueOf(bitmap2 == null));
        hVar = this.a.mLoadDataCallBack;
        if (hVar != null) {
            hVar2 = this.a.mLoadDataCallBack;
            hVar2.a(bitmap2);
        }
    }

    public ad(ac acVar, String str) {
        this.a = acVar;
        this.b = null;
        this.b = str;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        com.baidu.adp.a.h hVar;
        com.baidu.adp.a.h hVar2;
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
    public final void d() {
        super.d();
    }
}
