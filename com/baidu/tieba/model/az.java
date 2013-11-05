package com.baidu.tieba.model;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az extends BdAsyncTask<Object, Integer, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ay f1909a;
    private String b;

    public az(ay ayVar, String str) {
        this.f1909a = ayVar;
        this.b = null;
        this.b = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public Bitmap a(Object... objArr) {
        if (this.b != null && !this.b.equals("tieba_resized_image")) {
            com.baidu.tieba.util.w.e("photos/" + this.b, "tieba_resized_image");
        }
        return com.baidu.tieba.util.e.a(com.baidu.tieba.util.e.b(com.baidu.tieba.util.w.c(null, "tieba_resized_image_display")), 5.0f);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.a.g gVar;
        com.baidu.adp.a.g gVar2;
        this.f1909a.f1908a = null;
        gVar = this.f1909a.mLoadDataCallBack;
        if (gVar != null) {
            gVar2 = this.f1909a.mLoadDataCallBack;
            gVar2.a(null);
        }
        super.cancel(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void c() {
        super.c();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Bitmap bitmap) {
        com.baidu.adp.a.g gVar;
        com.baidu.adp.a.g gVar2;
        super.a((az) bitmap);
        this.f1909a.f1908a = null;
        com.baidu.tieba.util.be.a(getClass().getName(), "onPostExecute", "is Null?" + String.valueOf(bitmap == null));
        gVar = this.f1909a.mLoadDataCallBack;
        if (gVar != null) {
            gVar2 = this.f1909a.mLoadDataCallBack;
            gVar2.a(bitmap);
        }
    }
}
