package com.baidu.tieba.model;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class aq extends BdAsyncTask<Object, Integer, Bitmap> {
    final /* synthetic */ ap a;
    private String b;

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ Bitmap a(Object... objArr) {
        if (this.b != null && !this.b.equals("tieba_resized_image")) {
            com.baidu.tieba.util.af.e("photos/" + this.b, "tieba_resized_image");
        }
        return com.baidu.tieba.util.n.a(com.baidu.tieba.util.n.b(com.baidu.tieba.util.af.c(null, "tieba_resized_image")), 5.0f, true);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(Bitmap bitmap) {
        com.baidu.adp.a.g gVar;
        com.baidu.adp.a.g gVar2;
        Bitmap bitmap2 = bitmap;
        super.a((aq) bitmap2);
        this.a.a = null;
        com.baidu.adp.lib.util.e.a(getClass().getName(), "onPostExecute", "is Null?" + String.valueOf(bitmap2 == null));
        gVar = this.a.mLoadDataCallBack;
        if (gVar != null) {
            gVar2 = this.a.mLoadDataCallBack;
            gVar2.a(bitmap2);
        }
    }

    public aq(ap apVar, String str) {
        this.a = apVar;
        this.b = null;
        this.b = str;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        com.baidu.adp.a.g gVar;
        com.baidu.adp.a.g gVar2;
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
    public final void c() {
        super.c();
    }
}
