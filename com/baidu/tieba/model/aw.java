package com.baidu.tieba.model;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw extends BdAsyncTask<Object, Integer, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ av f1997a;
    private String b;

    public aw(av avVar, String str) {
        this.f1997a = avVar;
        this.b = null;
        this.b = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public Bitmap a(Object... objArr) {
        if (this.b != null && !this.b.equals("tieba_resized_image")) {
            com.baidu.tieba.util.x.e("photos/" + this.b, "tieba_resized_image");
        }
        return com.baidu.tieba.util.m.a(com.baidu.tieba.util.m.b(com.baidu.tieba.util.x.c(null, "tieba_resized_image_display")), 5.0f);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.a.g gVar;
        com.baidu.adp.a.g gVar2;
        this.f1997a.f1996a = null;
        gVar = this.f1997a.mLoadDataCallBack;
        if (gVar != null) {
            gVar2 = this.f1997a.mLoadDataCallBack;
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
        super.a((aw) bitmap);
        this.f1997a.f1996a = null;
        com.baidu.tieba.util.bd.a(getClass().getName(), "onPostExecute", "is Null?" + String.valueOf(bitmap == null));
        gVar = this.f1997a.mLoadDataCallBack;
        if (gVar != null) {
            gVar2 = this.f1997a.mLoadDataCallBack;
            gVar2.a(bitmap);
        }
    }
}
