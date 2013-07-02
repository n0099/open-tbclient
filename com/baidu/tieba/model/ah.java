package com.baidu.tieba.model;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah extends BdAsyncTask {
    final /* synthetic */ ag a;
    private String b;

    public ah(ag agVar, String str) {
        this.a = agVar;
        this.b = null;
        this.b = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public Bitmap a(Object... objArr) {
        if (this.b != null && !this.b.equals("tieba_resized_image")) {
            com.baidu.tieba.util.m.e("photos/" + this.b, "tieba_resized_image");
        }
        return com.baidu.tieba.util.d.a(com.baidu.tieba.util.d.b(com.baidu.tieba.util.m.c(null, "tieba_resized_image_display")), 5.0f);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.a.e eVar;
        com.baidu.adp.a.e eVar2;
        this.a.a = null;
        eVar = this.a.mLoadDataCallBack;
        if (eVar != null) {
            eVar2 = this.a.mLoadDataCallBack;
            eVar2.a(null);
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
        com.baidu.adp.a.e eVar;
        com.baidu.adp.a.e eVar2;
        super.a((Object) bitmap);
        this.a.a = null;
        com.baidu.tieba.util.z.a(getClass().getName(), "onPostExecute", "is Null?" + String.valueOf(bitmap == null));
        eVar = this.a.mLoadDataCallBack;
        if (eVar != null) {
            eVar2 = this.a.mLoadDataCallBack;
            eVar2.a(bitmap);
        }
    }
}
